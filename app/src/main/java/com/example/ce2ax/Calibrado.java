package com.example.ce2ax;

/**
 * Created by FYF on 19/08/2015.
 */
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by ssevilla on 19/08/2015.
 */
public class Calibrado
{

    File calibradoFile = new File(crearDirectorio("ce2ax"), "ce2ax.dat");
    int opcion0=1;
    int opcion1=1;
    int opcion2=1;

    public Calibrado()
    {
        if (!(calibradoFile.exists()))
        {
            crearFichero(1,1,1);
        }
        cargarFichero(calibradoFile);

    }

    public void crearFichero(int op0, int op1, int op2)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.calibradoFile);
            pw = new PrintWriter(fichero);
            pw.println(op0); //valor por defecto del calibrado de la opcion 0
            pw.println(op1); //valor por defecto del calibrado de la opcion 1
            pw.println(op2); //valor por defecto del calibrado de la opcion 2
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void cargarFichero(File ficheroCal)
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).

            fr = new FileReader (ficheroCal);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            linea=br.readLine();
            setOpcion0(Integer.valueOf(linea));
            linea=br.readLine();
            setOpcion1(Integer.valueOf(linea));
            linea=br.readLine();
            setOpcion2(Integer.valueOf(linea));

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public void crearFichero(File ficheroCal)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ficheroCal);
            pw = new PrintWriter(fichero);
            pw.println("1"); //valor por defecto del calibrado de la opcion 0
            pw.println("1"); //valor por defecto del calibrado de la opcion 1
            pw.println("1"); //valor por defecto del calibrado de la opcion 2
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private File crearDirectorio(String dir)
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

    public int getOpcion0() {
        return opcion0;
    }

    public int getOpcion1() {
        return opcion1;
    }

    public int getOpcion2() {
        return opcion2;
    }

    public void setOpcion0(int opcion0) {
        this.opcion0 = opcion0;
    }

    public void setOpcion1(int opcion1) {
        this.opcion1 = opcion1;
    }

    public void setOpcion2(int opcion2) {
        this.opcion2 = opcion2;
    }

}
