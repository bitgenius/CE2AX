package com.example.ce2ax;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PreviewCallback;
import android.media.ExifInterface;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class Preview extends SurfaceView implements SurfaceHolder.Callback {

	SurfaceHolder mHolder;
	public Camera camera;
	double iluminancia=0;
	int opcion=0;
	Calculos calculos;
	boolean pausa=false;
	int camaraFrontal=-1;
	int camaraTrasera=-1;
	int camaraActual=-1;

	private Camera.PictureCallback mPicture = new Camera.PictureCallback() {

		@Override
		public void onPictureTaken(byte[] data, Camera camera) {


			File pictureFile = new File(calculos.crearDirectorio("ce2ax"), "ce2ax.tmp");

			if (pictureFile == null){
				Log.d("CameraPrueba", "Error creating media file, check storage permissions: " );
				return;
			}

			try {
				FileOutputStream fos = new FileOutputStream(pictureFile);
				fos.write(data);
				fos.close();
				camera.startPreview();
			} catch (FileNotFoundException e) {
				Log.d("CameraPrueba", "File not found: " + e.getMessage());
			} catch (IOException e) {
				Log.d("CameraPrueba", "Error accessing file: " + e.getMessage());
			}
		}
	};


	Preview(Context context,int opcion) {
		super(context);

		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		this.camaraFrontal=findFrontFacingCamera();
		this.camaraTrasera=findBackCamera();
		this.camaraActual=this.camaraFrontal;
		this.opcion=opcion;
	}

	@SuppressWarnings("deprecation")
	public void surfaceCreated(SurfaceHolder holder) {

		safeCameraOpen(findFrontFacingCamera());
		Camera.Parameters params = camera.getParameters();
		params.setJpegQuality(100);
		params.setPreviewSize(480, 320);
		camera.setParameters(params);
		calculos= new Calculos();
		try {
			camera.setPreviewDisplay(holder);

			camera.setPreviewCallback(new PreviewCallback() {

				public void onPreviewFrame(byte[] data, Camera arg1) {

					if ((opcion==1) && (!pausa))
					{
						try {
							Camera.Size previewSize = arg1.getParameters().getPreviewSize();
							YuvImage yuvImage = new YuvImage(data, ImageFormat.NV21,previewSize.width,previewSize.height, null);

							setLuminancia(calculos.getLuminance(yuvImage,previewSize)); //convertimos el frame actual en luminancia
							setOpcion(0);

						} catch (Exception e) {
							e.printStackTrace();
						} finally {
						}
						Preview.this.invalidate();
					}

					if ((opcion==2) && (!pausa))
					{

						try {
							camera.takePicture(null, null, mPicture);
							setOpcion(0);
							setLuminancia(calculos.getIluminanciaSoloExif());
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
						}
						Preview.this.invalidate();
					}


					if ((opcion==3) && (!pausa))
					{

						try {
							camera.takePicture(null, null, mPicture);
							setOpcion(0);
							setLuminancia(calculos.getIluminanciaSoloExif());

						} catch (Exception e) {
							e.printStackTrace();
						} finally {
						}
						Preview.this.invalidate();
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void surfaceDestroyed(SurfaceHolder holder) {

		camera.stopPreview();
		camera.setPreviewCallback(null);
		camera.release();
		camera = null;
	}



	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {

		Camera.Parameters parameters = camera.getParameters();
		camera.setParameters(parameters);
		camera.startPreview();
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		Paint p = new Paint(Color.RED);
		canvas.drawText("PREVIEW", canvas.getWidth() / 2,
				canvas.getHeight() / 2, p);
	}

	private int findFrontFacingCamera() {
		int cameraId = -1;
		int numberOfCameras = Camera.getNumberOfCameras();
		for (int i = 0; i < numberOfCameras; i++) {
			CameraInfo info = new CameraInfo();
			Camera.getCameraInfo(i, info);
			if (info.facing == CameraInfo.CAMERA_FACING_FRONT) {
				cameraId = i;
				break;
			}
		}
		return cameraId;
	}

	private int findBackCamera() {
		int cameraId = -1;
		int numberOfCameras = Camera.getNumberOfCameras();
		for (int i = 0; i < numberOfCameras; i++) {
			CameraInfo info = new CameraInfo();
			Camera.getCameraInfo(i, info);
			if (info.facing == CameraInfo.CAMERA_FACING_BACK) {
				cameraId = i;
				break;
			}
		}
		return cameraId;
	}

	private boolean safeCameraOpen(int id) {
		boolean qOpened = false;
		try {
			mUnexpectedTerminationHelper.init();
			camera = Camera.open(id);
			qOpened = (camera != null);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return qOpened;
	}

	private void releaseCamera() {
		if (camera != null) {
			camera.stopPreview();
			camera.release();
			camera = null;
			mUnexpectedTerminationHelper.fini();
		}
	}

	public double getLuminancia ()
	{
		synchronized(this) {
			return this.iluminancia;
		}
	}

	public void setLuminancia (double iluminancia)
	{
		synchronized(this) {
			this.iluminancia=iluminancia;
		}
	}

	public void setOpcion (int opcion)
	{
		synchronized(this) {
			this.opcion = opcion;
		}
	}

	public void pausar()
	{
		pausa=true;
		camera.stopPreview();
	}

	public void resumir()
	{

		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		camera.startPreview();
		pausa=false;
	}

	public void cambiarCamara()
	{
		if (this.camaraActual==this.camaraFrontal)
		{

			releaseCamera();
			safeCameraOpen(this.camaraTrasera);
			Camera.Parameters params = camera.getParameters();
			params.setJpegQuality(100);
			params.setPreviewSize(480, 320);
			try {
				camera.setPreviewDisplay(getHolder());
				camera.setPreviewCallback(new PreviewCallback() {

					public void onPreviewFrame(byte[] data, Camera arg1) {
						if ((opcion == 1) && (!pausa)) {
							try {
								Camera.Size previewSize = arg1.getParameters().getPreviewSize();
								YuvImage yuvImage = new YuvImage(data, ImageFormat.NV21, previewSize.width, previewSize.height, null);

								setLuminancia(calculos.getLuminance(yuvImage, previewSize)); //convertimos el frame actual en luminancia
								setOpcion(0);

							} catch (Exception e) {
								e.printStackTrace();
							} finally {
							}
							Preview.this.invalidate();
						}

						if ((opcion == 2) && (!pausa)) {

							try {
								camera.takePicture(null, null, mPicture);
								setOpcion(0);
								setLuminancia(calculos.getIluminanciaSoloExif());
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
							}
							Preview.this.invalidate();
						}


						if ((opcion == 3) && (!pausa)) {

							try {
								camera.takePicture(null, null, mPicture);
								setOpcion(0);
								setLuminancia(calculos.getIluminanciaSoloExif());
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
							}
							Preview.this.invalidate();
						}
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
			camera.setParameters(params);

			resumir();
			camaraActual=camaraTrasera;
		}

		else
		{
			releaseCamera();
			safeCameraOpen(this.camaraFrontal);
			Camera.Parameters params = camera.getParameters();
			params.setJpegQuality(100);
			params.setPreviewSize(480, 320);
			camera.setParameters(params);

			try {
				camera.setPreviewDisplay(getHolder());
				camera.setPreviewCallback(new PreviewCallback() {

					public void onPreviewFrame(byte[] data, Camera arg1) {
						if ((opcion == 1) && (!pausa)) {
							try {
								Camera.Size previewSize = arg1.getParameters().getPreviewSize();
								YuvImage yuvImage = new YuvImage(data, ImageFormat.NV21, previewSize.width, previewSize.height, null);

								setLuminancia(calculos.getLuminance(yuvImage, previewSize)); //convertimos el frame actual en luminancia
								setOpcion(0);

							} catch (Exception e) {
								e.printStackTrace();
							} finally {
							}
							Preview.this.invalidate();
						}

						if ((opcion == 2) && (!pausa)) {

							try {
								camera.takePicture(null, null, mPicture);
								setOpcion(0);
								setLuminancia(calculos.getIluminanciaSoloExif());
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
							}
							Preview.this.invalidate();
						}


						if ((opcion == 3) && (!pausa)) {

							try {
								camera.takePicture(null, null, mPicture);
								setOpcion(0);
								setLuminancia(calculos.getIluminanciaSoloExif());
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
							}
							Preview.this.invalidate();
						}
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
			camera.setParameters(params);
			resumir();
			camaraActual=camaraFrontal;
		}
	}

	private UnexpectedTerminationHelper mUnexpectedTerminationHelper = new UnexpectedTerminationHelper();
	private class UnexpectedTerminationHelper {
		private Thread mThread;
		private Thread.UncaughtExceptionHandler mOldUncaughtExceptionHandler = null;
		private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread thread, Throwable ex) { // gets called on the same (main) thread
				camera.stopPreview();
				camera.release(); // TODO: write appropriate code here
				if(mOldUncaughtExceptionHandler != null) {
					// it displays the "force close" dialog
					mOldUncaughtExceptionHandler.uncaughtException(thread, ex);
				}
			}
		};
		void init() {
			mThread = Thread.currentThread();
			mOldUncaughtExceptionHandler = mThread.getUncaughtExceptionHandler();
			mThread.setUncaughtExceptionHandler(mUncaughtExceptionHandler);
		}
		void fini() {
			mThread.setUncaughtExceptionHandler(mOldUncaughtExceptionHandler);
			mOldUncaughtExceptionHandler = null;
			mThread = null;
		}
	}


}