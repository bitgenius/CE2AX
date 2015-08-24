package com.example.ce2ax;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Timer;

import android.os.Handler;
import android.os.Message;
//import android.support.v7.app;
import android.app.Activity;
import android.content.Intent;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;


public class Luxometro extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
	private Sensor mLight;
	private Spinner spinner;
	public ImageView d1,d2,d3,d4,d5,d6,punto;
	public int eleccion = 0;
	private boolean runningHilo=true;
	SurfaceView view;
	SeekBar volumeControl;
	TextView calibracion;
	double constante=1;
	Preview preview;
	boolean first=true;
	double valor=0;
	String valorFinal;
	private static final int OK_RESULT_CODE = 2;
	int calibradoOp0=1;int calibradoOp1=1;int calibradoOp2=1;
	Calibrado calibrado = new Calibrado();

	//Declaración del hilo que llamará a la función correspondiente y cambia el display
	Thread hilo = new Thread(){
		public void run()
		{
			while(runningHilo) {
				try
				{
					this.sleep(500); //liberamos la CPU
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (eleccion!=0) {


					preview.setOpcion(eleccion);
					setValor(preview.getLuminancia());
					runOnUiThread(new Runnable() {    // <--- solo el hilo original puede tocar el view

						@Override
						public void run() {
							cambiarDisplay(valor);
						}
					});
				}
			}
		}
	};



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_luxometro);

		//Inicialización de los componentes de los componentes del View
		d1 = (ImageView) this.findViewById(R.id.Dig1);
		d2 = (ImageView) this.findViewById(R.id.Dig2);
		d3 = (ImageView) this.findViewById(R.id.Dig3);
		d4 = (ImageView) this.findViewById(R.id.Dig4);
		d5 = (ImageView) this.findViewById(R.id.Dig5);
		d6 = (ImageView) this.findViewById(R.id.Dig6);
		punto = (ImageView) this.findViewById(R.id.digPunto);
		calibracion = (TextView) this.findViewById(R.id.textView1);

		//inicializamos valores de calibración guardados
		this.calibradoOp0=calibrado.getOpcion0();
		this.calibradoOp1=calibrado.getOpcion1();
		this.calibradoOp2=calibrado.getOpcion2();
		this.constante=this.calibradoOp0;
		calibracion.setText(String.valueOf(this.calibradoOp0));

		//Inicialización del sensor de luz:
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);


		//Inicializacion del seekbar que será utilizado para calibrar el luxómetro
		volumeControl = (SeekBar) findViewById(R.id.seekBar1);
		volumeControl.setMax(400);
		volumeControl.setProgress(calibradoOp0);
		volumeControl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int progreso = calibradoOp0;

			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

				if (spinner.getSelectedItemPosition()==0)
				{
					calibradoOp0=progress;
				}
				if (spinner.getSelectedItemPosition()==1)
				{
					calibradoOp1=progress;
				}
				if (spinner.getSelectedItemPosition()==2)
				{
					calibradoOp2=progress;
				}
				progreso = progress;
				constante = progress;
				calibracion.setText(String.valueOf(progress));
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				constante = progreso;
				calibracion.setText(String.valueOf(progreso));
			}
		});

		//Inicialización del preview para mostrar el contenido de la cámara
		preview = new Preview(this,0);
		((FrameLayout) this.findViewById(R.id.preview)).addView(preview);

		//Inicializamos hilo
		hilo.start();

		//Inicialización del spinner que mostrará las distintas opciones de luxómetro
		spinner = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.sensor, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			/*comportamiento del spinner en función de la opción:
			* 	- opcion 0: Sensor de luz.
			* 	- opción 1: cálculo de luminancia -> iluminancia
			* 	- opción 2: cálculos con exiff
			* */
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
									   int posicion, long arg3) {
				// TODO Auto-generated method stub
				switch(posicion) {
					case 0:
						setEleccion(posicion);
						volumeControl.setProgress(calibradoOp0);
						calibracion.setText(String.valueOf(calibradoOp0));
						preview.setOpcion(0);
						break;
					case 1:
						volumeControl.setProgress(calibradoOp1);
						calibracion.setText(String.valueOf(calibradoOp1));
						setEleccion(posicion);
						break;
					case 2:
						volumeControl.setProgress(calibradoOp2);
						calibracion.setText(String.valueOf(calibradoOp2));
						setEleccion(posicion);
						break;
					default:

				}




			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.luxometro, menu);
		return true;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub


	}

	//Cuando la actividad se destruye hemos de destruir el hilo y guardar los cambios de calibración
	@Override
	protected void onDestroy() {
		preview.setOpcion(0);
		this.runningHilo=false;
		calibrado.crearFichero(calibradoOp0,calibradoOp1,calibradoOp2);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onDestroy();
	}

	@Override
	public void onSensorChanged(SensorEvent event) {


		if((event.sensor.getType()==Sensor.TYPE_LIGHT) && (eleccion==0))
		{
			float currentLight = event.values[0];
			cambiarDisplay(currentLight);

		}
	}

	@Override
	protected void onPause() {
		preview.pausar();
		super.onPause();
	}

	@Override
	protected void onResume()
	{
		if (!first)
		{
			preview.resumir();
			if (this.eleccion>0) this.runningHilo=true;

		} else {first=false;}
		super.onResume();
	}


	private void cambiarDisplay(double currentLight)
	{


		double valor_calibrado= currentLight*this.constante;
		ImageView d1,d2,d3,d4,d5,d6,punto;
		DecimalFormat df = new DecimalFormat("0.00");
		String strValor= String.valueOf(df.format(valor_calibrado));
		valorFinal= strValor;
		d1 = (ImageView) this.findViewById(R.id.Dig1);
		d2 = (ImageView) this.findViewById(R.id.Dig2);
		d3 = (ImageView) this.findViewById(R.id.Dig3);
		d4 = (ImageView) this.findViewById(R.id.Dig4);
		d5 = (ImageView) this.findViewById(R.id.Dig5);
		d6 = (ImageView) this.findViewById(R.id.Dig6);
		punto = (ImageView) this.findViewById(R.id.digPunto);



		int i = 1;
		while (i<8)
		{

			if (i<=strValor.length())
			{
				if (strValor.charAt(strValor.length()-i) == '0')
				{
					if (i==1)
					{
						d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_cero));
					}
					if (i==2)
					{
						d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_cero));
					}
					if (i==4)
					{
						d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_cero));
					}
					if (i==5)
					{
						d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_cero));
					}
					if (i==6)
					{
						d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_cero));
					}
					if (i==7)
					{
						d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_cero));
					}
				}
				if (strValor.charAt(strValor.length()-i) == '1')
				{
					if (i==1)
					{
						d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_uno));
					}
					if (i==2)
					{
						d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_uno));
					}
					if (i==4)
					{
						d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_uno));
					}
					if (i==5)
					{
						d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_uno));
					}
					if (i==6)
					{
						d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_uno));
					}
					if (i==7)
					{
						d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_uno));
					}
				}
				if (strValor.charAt(strValor.length()-i) == '2')
				{
					if (i==1)
					{
						d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_dos));
					}
					if (i==2)
					{
						d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_dos));
					}
					if (i==4)
					{
						d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_dos));
					}
					if (i==5)
					{
						d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_dos));
					}
					if (i==6)
					{
						d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_dos));
					}
					if (i==7)
					{
						d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_dos));
					}
				}
				if (strValor.charAt(strValor.length()-i) == '3')
				{
					if (i==1)
					{
						d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_tres));
					}
					if (i==2)
					{
						d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_tres));
					}
					if (i==4)
					{
						d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_tres));
					}
					if (i==5)
					{
						d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_tres));
					}
					if (i==6)
					{
						d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_tres));
					}
					if (i==7)
					{
						d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_tres));
					}

				}
				if (strValor.charAt(strValor.length()-i) == '4')
				{
					if (i==1)
					{
						d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_cuatro));
					}
					if (i==2)
					{
						d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_cuatro));
					}
					if (i==4)
					{
						d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_cuatro));
					}
					if (i==5)
					{
						d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_cuatro));
					}
					if (i==6)
					{
						d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_cuatro));
					}
					if (i==7)
					{
						d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_cuatro));
					}

				}

				if (strValor.charAt(strValor.length()-i) == '5')
				{
					if (i==1)
					{
						d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_cinco));
					}
					if (i==2)
					{
						d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_cinco));
					}
					if (i==4)
					{
						d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_cinco));
					}
					if (i==5)
					{
						d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_cinco));
					}
					if (i==6)
					{
						d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_cinco));
					}
					if (i==7)
					{
						d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_cinco));
					}

				}
				if (strValor.charAt(strValor.length()-i) == '6')
				{
					if (i==1)
					{
						d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_seis));
					}
					if (i==2)
					{
						d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_seis));
					}
					if (i==4)
					{
						d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_seis));
					}
					if (i==5)
					{
						d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_seis));
					}
					if (i==6)
					{
						d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_seis));
					}
					if (i==7)
					{
						d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_seis));
					}

				}
				if (strValor.charAt(strValor.length()-i) == '7')
				{
					if (i==1)
					{
						d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_siete));
					}
					if (i==2)
					{
						d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_siete));
					}
					if (i==4)
					{
						d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_siete));
					}
					if (i==5)
					{
						d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_siete));
					}
					if (i==6)
					{
						d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_siete));
					}
					if (i==7)
					{
						d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_siete));
					}

				}

				if (strValor.charAt(strValor.length()-i) == '8')
				{
					if (i==1)
					{
						d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_ocho));
					}
					if (i==2)
					{
						d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_ocho));
					}
					if (i==4)
					{
						d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_ocho));
					}
					if (i==5)
					{
						d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_ocho));
					}
					if (i==6)
					{
						d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_ocho));
					}
					if (i==7)
					{
						d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_ocho));
					}

				}
				if (strValor.charAt(strValor.length()-i) == '9')
				{
					if (i==1)
					{
						d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_nueve));
					}
					if (i==2)
					{
						d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_nueve));
					}
					if (i==4)
					{
						d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_nueve));
					}
					if (i==5)
					{
						d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_nueve));
					}
					if (i==6)
					{
						d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_nueve));
					}
					if (i==7)
					{
						d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_nueve));
					}

				}

				if (strValor.charAt(strValor.length()-i) == ',')
				{

					punto.setImageDrawable(getResources().getDrawable(R.drawable.dig_punto));


				}


			}
			else
			{
				if (i==1)
				{
					d1.setImageDrawable(getResources().getDrawable(R.drawable.dig_vacio));
				}
				if (i==2)
				{
					d2.setImageDrawable(getResources().getDrawable(R.drawable.dig_vacio));
				}
				if (i==4)
				{
					d3.setImageDrawable(getResources().getDrawable(R.drawable.dig_vacio));
				}
				if (i==5)
				{
					d4.setImageDrawable(getResources().getDrawable(R.drawable.dig_vacio));
				}
				if (i==6)
				{
					d5.setImageDrawable(getResources().getDrawable(R.drawable.dig_vacio));
				}
				if (i==7)
				{
					d6.setImageDrawable(getResources().getDrawable(R.drawable.dig_vacio));
				}
			}
			i++;
		}

	}

	private synchronized void setEleccion(int i)
	{
		this.eleccion=i;
	}

	private synchronized void setValor(double i)
	{
		this.valor=i;
	}


	public void cambiaCamara(View view)
	{
		preview.cambiarCamara();
	}


	public void capturaLux(View view)
	{
		Intent intent = new Intent();
		intent.putExtra("result", valorFinal);
		setResult(RESULT_OK, intent);
		finish();
	}

}
