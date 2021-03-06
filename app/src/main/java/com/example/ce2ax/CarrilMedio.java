package com.example.ce2ax;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class CarrilMedio extends ActionBarActivity {

	double punto1,punto2,punto3;
	int request;
	private ToggleButton luxo;
	protected static final int REQUEST_CODE = 20;
	final Context context = this;
	private ImageView pder,pmed,pizq,calcular;
	private TextView tder,tmed,tizq;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carril_medio);
		Intent intent = getIntent();
		ArrayList<String> mensajes = intent.getStringArrayListExtra("Datos");
		this.request=Integer.parseInt(mensajes.get(0));
		this.punto1=Double.parseDouble(mensajes.get(1));
		this.punto2=Double.parseDouble(mensajes.get(2));
		this.punto3=Double.parseDouble(mensajes.get(3));


		pder = (ImageView) findViewById (R.id.pder);
		pmed = (ImageView) findViewById (R.id.pmed);
		pizq = (ImageView) findViewById (R.id.pizq);
		tder = (TextView) findViewById (R.id.tder);
		tmed = (TextView) findViewById (R.id.tmed);
		tizq = (TextView) findViewById (R.id.tizq);

		luxo = (ToggleButton) findViewById(R.id.toggleButton1);

		calcular = (ImageView) findViewById(R.id.Calc);

		if (this.punto1 >= 1)
		{
			tizq.setText(String.valueOf(this.punto1));
			pizq.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));

		}
		else
		{
			tizq.setText("");
			pizq.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
		}
		if (this.punto2 >= 1)
		{
			tmed.setText(String.valueOf(this.punto2));
			pmed.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));

		}
		else
		{
			tmed.setText("");
			pmed.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
		}
		if (this.punto3 >= 1)
		{
			tder.setText(String.valueOf(this.punto3));
			pder.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
		}
		else
		{
			tder.setText("");
			pder.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
		}

		pizq.setOnClickListener(new View.OnClickListener() {


			@Override
			public void onClick(View arg0) {

				if (luxo.isChecked())
				{
					startLuxometro(1);
				}
				else
				{


					// TODO Auto-generated method stub
					// get prompts.xml view
					LayoutInflater li = LayoutInflater.from(context);
					View promptsView = li.inflate(R.layout.prompts, null);

					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
							context);

					// set prompts.xml to alertdialog builder
					alertDialogBuilder.setView(promptsView);

					final EditText userInput = (EditText) promptsView
							.findViewById(R.id.editTextDialogUserInput);

					// set dialog message
					alertDialogBuilder.setCancelable(false).setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,int id) {
									// get user input and set it to result
									// edit text
									// ----> result.setText(userInput.getText());
									//tp1.setText(userInput.getText());
									if (userInput.getText().toString().equals(""))
									{
										tizq.setText("");
										pizq.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
										if (completado ()) calcular.setVisibility(View.VISIBLE);
									}
									else
									{
										tizq.setText(userInput.getText());
										pizq.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
										if (completado ()) calcular.setVisibility(View.VISIBLE);
									}

								}
							})
							.setNegativeButton("Cancel",
									new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog,int id) {
											dialog.cancel();
										}
									});

					// create alert dialog
					AlertDialog alertDialog = alertDialogBuilder.create();

					// show it
					alertDialog.show();
				}
			}
		});


		pmed.setOnClickListener(new View.OnClickListener() {


			@Override
			public void onClick(View arg0) {

				if (luxo.isChecked())
				{
					startLuxometro(2);
				}
				else
				{


					// TODO Auto-generated method stub
					// get prompts.xml view
					LayoutInflater li = LayoutInflater.from(context);
					View promptsView = li.inflate(R.layout.prompts, null);

					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
							context);

					// set prompts.xml to alertdialog builder
					alertDialogBuilder.setView(promptsView);

					final EditText userInput = (EditText) promptsView
							.findViewById(R.id.editTextDialogUserInput);

					// set dialog message
					alertDialogBuilder.setCancelable(false).setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,int id) {
									// get user input and set it to result
									// edit text
									// ----> result.setText(userInput.getText());
									//tp1.setText(userInput.getText());
									if (userInput.getText().toString().equals(""))
									{
										tmed.setText("");
										pmed.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
										if (completado ()) calcular.setVisibility(View.VISIBLE);
									}
									else
									{
										tmed.setText(userInput.getText());
										pmed.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
										if (completado ()) calcular.setVisibility(View.VISIBLE);
									}

								}
							})
							.setNegativeButton("Cancel",
									new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog,int id) {
											dialog.cancel();
										}
									});

					// create alert dialog
					AlertDialog alertDialog = alertDialogBuilder.create();

					// show it
					alertDialog.show();
				}
			}
		});


		pder.setOnClickListener(new View.OnClickListener() {


			@Override
			public void onClick(View arg0) {

				if (luxo.isChecked())
				{
					startLuxometro(3);
				}
				else
				{


					// TODO Auto-generated method stub
					// get prompts.xml view
					LayoutInflater li = LayoutInflater.from(context);
					View promptsView = li.inflate(R.layout.prompts, null);

					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
							context);

					// set prompts.xml to alertdialog builder
					alertDialogBuilder.setView(promptsView);

					final EditText userInput = (EditText) promptsView
							.findViewById(R.id.editTextDialogUserInput);

					// set dialog message
					alertDialogBuilder.setCancelable(false).setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,int id) {
									// get user input and set it to result
									// edit text
									// ----> result.setText(userInput.getText());
									//tp1.setText(userInput.getText());
									if (userInput.getText().toString().equals(""))
									{
										tder.setText("");
										pder.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
										if (completado ()) calcular.setVisibility(View.VISIBLE);
									}
									else
									{
										tder.setText(userInput.getText());
										pder.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
										if (completado ()) calcular.setVisibility(View.VISIBLE);
									}

								}
							})
							.setNegativeButton("Cancel",
									new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog,int id) {
											dialog.cancel();
										}
									});

					// create alert dialog
					AlertDialog alertDialog = alertDialogBuilder.create();

					// show it
					alertDialog.show();
				}
			}
		});

		ImageView funcion = (ImageView) findViewById(R.id.Calc);
		funcion.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Cierra la actividad y la saca de la pila
				if (completado ()) devolverResultado();

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {


		if (resultCode == RESULT_OK) {
			switch (requestCode) {
				case 1:

					if (data.getStringExtra("result").equals("")) {
						tizq.setText("");
						pizq.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado()) calcular.setVisibility(View.VISIBLE);
					} else {
						tizq.setText(data.getStringExtra("result").replaceAll(",", "."));
						pizq.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 2:
					if (data.getStringExtra("result").equals("")) {
						tmed.setText("");
						pmed.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado()) calcular.setVisibility(View.VISIBLE);
					} else {
						tmed.setText(data.getStringExtra("result").replaceAll(",", "."));
						pmed.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 3:
					if (data.getStringExtra("result").equals("")) {
						tder.setText("");
						pder.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado()) calcular.setVisibility(View.VISIBLE);
					} else {
						tder.setText(data.getStringExtra("result").replaceAll(",", "."));
						pder.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado()) calcular.setVisibility(View.VISIBLE);
					}
					break;
			}
		}
	}
	protected void devolverResultado() {
		// TODO Auto-generated method stub

		TextView tder = (TextView) findViewById(R.id.tder);
		TextView tizq = (TextView) findViewById(R.id.tizq);
		TextView tmed = (TextView) findViewById(R.id.tmed);

		ArrayList<String> mensajes = new ArrayList<>();

		mensajes.add(tizq.getText().toString());
		mensajes.add(tmed.getText().toString());
		mensajes.add(tder.getText().toString());

		Intent intent = new Intent();
		intent.putExtra("result", mensajes);
		setResult(this.request, intent);
		finish();


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.carril_unico, menu);
		return true;
	}

	public void startLuxometro(int punto)
	{
		Intent intent = new Intent(this, Luxometro.class);
		startActivityForResult(intent, punto);
	}


	public boolean completado ()
	{

		return ((!tizq.getText().toString().equals("")) && (!tmed.getText().toString().equals("")) && (!tder.getText().toString().equals("")));

	}

}