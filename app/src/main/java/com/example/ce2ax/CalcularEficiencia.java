package com.example.ce2ax;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CalcularEficiencia extends Activity {

	public double er;
	public double e;
	public double ie;
	public double ice;
	public double p;
	public double em;
	public double emin;
	public double s;
	public String letra;
	public String tipo;
	protected static final int REQUEST_CODE = 20;
	public final static String EXTRA_MESSAGE = "Eficiencia Calculada";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Get the message from the intent
	    Intent intent = getIntent();
	    ArrayList<String> mensajes = intent.getStringArrayListExtra(MainActivity.EXTRA_MESSAGE);
	    this.p=Double.valueOf(mensajes.get(0)).doubleValue();
	    this.em=Double.valueOf(mensajes.get(1)).doubleValue();
	    this.s=Double.valueOf(mensajes.get(2)).doubleValue();
	    this.tipo= mensajes.get(3);
	    //System.out.println (tipo);
	    this.ice = calcularICE(p,em,s,tipo);
		System.out.println ("ice "+this.ice);
	    setContentView(R.layout.activity_calcular_eficiencia);
	    
	    this.letra = calcularCertificacion (this.ice);
	    
	    if (this.letra.equals("A")) { ImageView flecha = (ImageView) findViewById(R.id.flechaA); flecha.setVisibility(View.VISIBLE);}
	    if (this.letra.equals("B")) { ImageView flecha = (ImageView) findViewById(R.id.flechaB); flecha.setVisibility(View.VISIBLE);}
	    if (this.letra.equals("C")) { ImageView flecha = (ImageView) findViewById(R.id.flechaC); flecha.setVisibility(View.VISIBLE);}
	    if (this.letra.equals("D")) { ImageView flecha = (ImageView) findViewById(R.id.flechaD); flecha.setVisibility(View.VISIBLE);}
	    if (this.letra.equals("E")) { ImageView flecha = (ImageView) findViewById(R.id.flechaE); flecha.setVisibility(View.VISIBLE);}
	    if (this.letra.equals("F")) { ImageView flecha = (ImageView) findViewById(R.id.flechaF); flecha.setVisibility(View.VISIBLE);}
	    if (this.letra.equals("G")) { ImageView flecha = (ImageView) findViewById(R.id.flechaG); flecha.setVisibility(View.VISIBLE);}
	    
	    TextView eficienciaMedia = (TextView) findViewById(R.id.tder);
	    TextView ins = (TextView) findViewById(R.id.TextView14);
	    TextView iec = (TextView) findViewById(R.id.TextView04);
	    eficienciaMedia.setText(mensajes.get(1));
	    DecimalFormat df = new DecimalFormat("0.00");
	    iec.setText(String.valueOf(df.format(this.e/this.er)));
	    
	    this.emin=calcularEMin (this.tipo,this.em);
	    ins.setText(tipo);
	   
	}
	
	
	private String calcularCertificacion(double ice2) {
		// TODO Auto-generated method stub
		String letra = null;
		
		if (ice2 < 0.91) letra="A";
		else if ((ice2 >= 0.91) && (ice2 < 1.09)) letra = "B";
		else if ((ice2 >= 1.09) && (ice2 < 1.35)) letra = "C";
		else if ((ice2 >= 1.35) && (ice2 < 1.79)) letra = "D";
		else if ((ice2 >= 1.79) && (ice2 < 2.63)) letra = "E";
		else if ((ice2 >= 2.63) && (ice2 < 5)) letra = "F";
		else letra= "G";
		
		return letra;
	}

	private double calcularICE(double p, double em, double s,String tipo) {
		// TODO Auto-generated method stub
		this.er = calcularEr(tipo,em);
		this.e = calcularE(p,s,em);
		this.ie= this.e/this.er;		
		return (1/this.ie);
	}
	


	private double calcularE(double p, double s, double em) {
		// TODO Auto-generated method stub
		return ((s*em)/p);
	}

	private double calcularEr(String tipo, double em) {
		double aux;
		
		if (tipo.equals("Ambiental"))
		{
			if (em>=20) aux =  13;
			else if ((em <20) && (em>=15)) aux = interpolar (20,13,15,11,em);
			else if ((em <15) && (em>=10)) aux = interpolar (15,11,10,9,em);
			else if ((em <10) && (em>=7.5)) aux = interpolar (10,9,7.5,7,em);
			else if ((em <7.5) && (em>=5)) aux = interpolar (7.5,7,5,5,em);
			else aux = 5;
		}
		else
		{
			if (em>=30) aux =  32;
			else if ((em <30) && (em>=25)) aux = interpolar (30,32,25,29,em);
			else if ((em <25) && (em>=20)) aux = interpolar (25,29,20,26,em);
			else if ((em <20) && (em>=15)) aux = interpolar (20,26,15,23,em);
			else if ((em <15) && (em>=10)) aux = interpolar (15,23,10,18,em);
			else if ((em <10) && (em>=7.5)) aux = interpolar (10,18,7.5,14,em);
			else aux = 14;		
		}
		return aux;
	}

	
	private double calcularEMin(String tipo, double em) {
		double aux;
		
		if (tipo.equals("Ambiental"))
		{
			if (em>=20) aux =  9;
			else if ((em <20) && (em>=15)) aux = interpolar (20,9,15,7.5,em);
			else if ((em <15) && (em>=10)) aux = interpolar (15,7.5,10,6,em);
			else if ((em <10) && (em>=7.5)) aux = interpolar (10,6,7.5,5,em);
			else if ((em <7.5) && (em>=5)) aux = interpolar (7.5,5,5,3.5,em);
			else aux = 3.5;
		}
		else
		{
			if (em>=30) aux =  22;
			else if ((em <30) && (em>=25)) aux = interpolar (30,22,25,20,em);
			else if ((em <25) && (em>=20)) aux = interpolar (25,20,20,17.5,em);
			else if ((em <20) && (em>=15)) aux = interpolar (20,17.5,15,15,em);
			else if ((em <15) && (em>=10)) aux = interpolar (15,15,10,12,em);
			else if ((em <10) && (em>=7.5)) aux = interpolar (10,15,7.5,9.5,em);
			else aux = 9.5;		
		}
		return aux;
	}
	
	
	private double interpolar(double x1, double y1, double x2, double y2, double em) {
		
		return (((em - x1)*(y2 - y1)) / (x2 - x1)) + y1;
	}
	
	public void informacion (View view)
	{
	    String cumple;
		DecimalFormat df = new DecimalFormat("0.00");
	    ArrayList<String> argumentos = new ArrayList<String>();;  
	    argumentos.add(this.tipo);
	    argumentos.add(String.valueOf(df.format(this.p)));
	    argumentos.add(String.valueOf(df.format(this.s)));
	    argumentos.add(String.valueOf(df.format(this.em)));
	    argumentos.add(String.valueOf(df.format(this.e)));
	    argumentos.add(String.valueOf(df.format(this.emin)));
	    argumentos.add(String.valueOf(df.format(this.er)));
	    argumentos.add(String.valueOf(df.format(this.ie)));
	    argumentos.add(String.valueOf(df.format(this.ice)));
	    argumentos.add(this.letra);
	    if (this.e>=this.emin) cumple="1"; else cumple="0";
	    argumentos.add(cumple);
	    Intent intent = new Intent(this, Info.class);
		intent.putExtra(EXTRA_MESSAGE, argumentos);
		System.out.println ("Comenzamos activity");
		startActivity(intent);
			
	}


	public void guardado (View view)
	{
		/*
		String cumple;
		DecimalFormat df = new DecimalFormat("0.00");
		ArrayList<String> argumentos = new ArrayList<String>();;
		argumentos.add(this.tipo);
		argumentos.add(String.valueOf(df.format(this.p)));
		argumentos.add(String.valueOf(df.format(this.s)));
		argumentos.add(String.valueOf(df.format(this.em)));
		argumentos.add(String.valueOf(df.format(this.e)));
		argumentos.add(String.valueOf(df.format(this.emin)));
		argumentos.add(String.valueOf(df.format(this.er)));
		argumentos.add(String.valueOf(df.format(this.ie)));
		argumentos.add(String.valueOf(df.format(this.ice)));
		argumentos.add(this.letra);
		if (this.e>=this.emin) cumple="1"; else cumple="0";
		argumentos.add(cumple);
		Intent intent = new Intent(this, Info.class);
		intent.putExtra(EXTRA_MESSAGE, argumentos);
		System.out.println ("Comenzamos activity");
		startActivity(intent);
		*/

		// TODO Auto-generated method stub
		// get prompts.xml view
		LayoutInflater li = LayoutInflater.from(this);
		View promptsView = li.inflate(R.layout.emerg_guardado, null);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				this);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final EditText userInputCalle = (EditText) promptsView
				.findViewById(R.id.editTextCalle);

		final EditText userInputObs = (EditText) promptsView
				.findViewById(R.id.editTextObservaciones);

		// set dialog message
		alertDialogBuilder.setCancelable(false).setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// get user input and set it to result
						// edit text
						// ----> result.setText(userInput.getText());
						//tp1.setText(userInput.getText());
						if (!(userInputCalle.getText().toString().equals("")))
						{
							guardarFichero(userInputCalle.getText().toString(),userInputObs.getText().toString());
						}

					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();



	}

	public class AppendingObjectOutputStream extends ObjectOutputStream {

		public AppendingObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		@Override
		protected void writeStreamHeader() throws IOException {
			// do not write a header, but reset:
			// this line added after another question
			// showed a problem with the original
			reset();
		}

	}


	private void guardarFichero(String calle, String observaciones)
	{
		Etiqueta etiqueta= new Etiqueta();

		etiqueta.setCalificacion(this.letra);
		etiqueta.setCalle(calle);
		etiqueta.setE(String.valueOf(this.e));
		etiqueta.setEm(String.valueOf(this.em));
		etiqueta.setEmin(String.valueOf(this.emin));
		etiqueta.setEr(String.valueOf(this.er));
		etiqueta.setIce(String.valueOf(this.ice));
		etiqueta.setIe(String.valueOf(this.ie));
		etiqueta.setPotencia(String.valueOf(this.p));
		etiqueta.setSuperficie(String.valueOf(this.s));
		etiqueta.setObservaciones(observaciones);
		etiqueta.setTipo(tipo);

		File fichero = new File(crearDirectorio("ce2ax"),"etiquetas.dat");

		try {
			if (fichero.exists()) {
				AppendingObjectOutputStream oos = new AppendingObjectOutputStream(new FileOutputStream(fichero, true));

				oos.writeObject(etiqueta);
				oos.close();
			}
			else {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero, true));

				oos.writeObject(etiqueta);
				oos.close();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}


		this.finish();
	}


	private File crearDirectorio(String directorio)
	{
		File dir = new File(Environment.getExternalStorageDirectory(),directorio);

		if (!dir.exists())
		{
			try{
				dir.mkdirs();
			}
			catch (Error e)
			{
				System.out.println (e);
			}
		}

		return dir;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calcular_eficiencia, menu);
		return true;
	}

}
