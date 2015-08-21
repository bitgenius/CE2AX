package com.example.ce2ax;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Calculos
{

    /* método para cálcular la luminancia de una imágen en formato YUVimage */
    public double getLuminance (YuvImage yuvImage, Camera.Size previewSize)
    {
        double luminance=0;
        //se ha de convertir YUVimage en un BMP para posteriormente hacer los calculos en cada pixel
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, previewSize.width, previewSize.height), 80, baos);
        byte[] jdata = baos.toByteArray();
        Bitmap bitmap = BitmapFactory.decodeByteArray(jdata, 0, jdata.length);
        Color color = new Color();

        //ahora convertimos cada pixel a una escala de gris y guardamos la suma del brillo de cada pixel en la variable luminance
        for (int alto=1;alto<bitmap.getWidth();alto++)
        {
            for (int ancho=1;ancho<bitmap.getHeight();ancho++)
            {
                int colorp = bitmap.getPixel(alto, ancho);
                double azul =(color.blue(colorp)*1.0)/255;
                double rojo = (color.red(colorp)*1.0)/255;
                double verde = (color.green(colorp)*1.0)/255;
                luminance += (azul*0.114) + (rojo*0.299) + (verde*0.587);
            }
        }

        //hacemos la media para obtener la luminancia en candelas / metro cuadrado


        luminance=luminance/(bitmap.getWidth()*bitmap.getHeight());
        System.out.println("esto es lo que sale de luminancia :"+luminance+" calculandolo con :"+(bitmap.getWidth()*bitmap.getHeight())+" pixeles en total");


        return luminance;
    }

    /* método para cálcular la luminancia de una imágen en formato YUVimage */
    public double getLuminanceJPG (File imagenJPG)
    {
        double luminance=0;
        try {
        FileInputStream fis = null;

            fis = new FileInputStream(imagenJPG);

        byte[] jdata = new byte[(int)imagenJPG.length()];
        fis.read(jdata);
        Bitmap bitmap = BitmapFactory.decodeByteArray(jdata, 0, jdata.length);
        Color color = new Color();

        //ahora convertimos cada pixel a una escala de gris y guardamos la suma del brillo de cada pixel en la variable luminance
        for (int alto=1;alto<bitmap.getWidth();alto++)
        {
            for (int ancho=1;ancho<bitmap.getHeight();ancho++)
            {
                int colorp = bitmap.getPixel(alto, ancho);
                double azul =(color.blue(colorp)*1.0)/255;
                double rojo = (color.red(colorp)*1.0)/255;
                double verde = (color.green(colorp)*1.0)/255;
                luminance += (azul*0.114) + (rojo*0.299) + (verde*0.587);
            }
        }

        //hacemos la media para obtener la luminancia en candelas / metro cuadrado


        luminance=luminance/(bitmap.getWidth()*bitmap.getHeight());
        System.out.println("esto es lo que sale de luminancia :"+luminance+" calculandolo con :"+(bitmap.getWidth()*bitmap.getHeight())+" pixeles en total");
        fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return luminance;
    }

    //Este método es una prueba no se utiliza, pero puede ser útil:
    public double getIlluminance (double luminance, double fDifusion)
    {
        //La manera de convertir cd/m^2 (iluminancia) a luxes (iluminancia) es multiplicando 2PI (hemisferio reflectado) por un factor de difusión (material propio [asfalto p.ej])

        return (luminance*2*Math.PI)/fDifusion;

    }

    public double getIluminanciaExif() throws IOException
    {
        double iluminance=0;
        double luminance=0;
        File pictureFile = new File(crearDirectorio("ce2ax"), "ce2ax.tmp");
        ExifInterface exif = new ExifInterface(pictureFile.getAbsolutePath());
        System.out.println("ISO = " + exif.getAttribute(ExifInterface.TAG_ISO));
        luminance = getLuminanceJPG(pictureFile);


        int iso=0;

        if (exif.getAttribute(ExifInterface.TAG_ISO)==null)
        {
            iso=-1;
        }
        else
        {
            iso=(Integer.valueOf(exif.getAttribute(ExifInterface.TAG_ISO)));

        }



        iluminance = (luminance*iso);
        return iluminance;
    }


    public double getIluminanciaSoloExif() throws IOException {



        File pictureFile = new File(crearDirectorio("ce2ax"), "ce2ax.tmp");
        ExifInterface exif = new ExifInterface(pictureFile.getAbsolutePath());
        System.out.println("ISO = " + exif.getAttribute(ExifInterface.TAG_ISO));


        int iso=0;
        String t="",fnumber="";

        if (exif.getAttribute(ExifInterface.TAG_ISO)==null)
        {
            iso=-1;
        }
        else
        {
            iso=(Integer.valueOf(exif.getAttribute(ExifInterface.TAG_ISO)));

        }
        if (exif.getAttribute(ExifInterface.TAG_EXPOSURE_TIME)==null)
        {
            t="";
        }
        else
        {
            t=exif.getAttribute(ExifInterface.TAG_EXPOSURE_TIME);

        }
        if (exif.getAttribute(ExifInterface.TAG_APERTURE)==null)
        {
            fnumber="";
        }
        else
        {
            fnumber=exif.getAttribute(ExifInterface.TAG_APERTURE);

        }

        System.out.println ("iso="+iso+" t(exposure time)="+t+" fnumber="+fnumber);
        double resultado=0;
        double f= Double.valueOf(fnumber);
        double td= Double.valueOf(t);
        resultado=((f*f)/(td*iso));
        System.out.println ("resultado "+resultado);


        return resultado;
    }

    public File crearDirectorio(String dir)
    {
        File pictureDir = new File(Environment.getExternalStorageDirectory(),dir);

        if (!pictureDir.exists())
        {
            try{
                System.out.println ("Creamos dir");
                pictureDir.mkdirs();
            }
            catch (Error e)
            {
                System.out.println (e);
            }
        }

        return pictureDir;
    }


}