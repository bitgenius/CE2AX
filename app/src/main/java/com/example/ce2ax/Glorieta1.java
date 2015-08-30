package com.example.ce2ax;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import java.util.ArrayList;

public class Glorieta1 extends Activity {

	double supcen1=-1,supcen2=-1,supcen3=-1;
	double supizq1=-1,supizq2=-1,supizq3=-1;
	double supder1=-1,supder2=-1,supder3=-1;
	double medizq1=-1,medizq2=-1,medizq3=-1;
	double medder1=-1,medder2=-1,medder3=-1;
	double infcen1=-1,infcen2=-1,infcen3=-1;
	double infizq1=-1,infizq2=-1,infizq3=-1;
	double infder1=-1,infder2=-1,infder3=-1;
	protected static final int REQUEST_CODE_SUPCEN = 1;
	protected static final int REQUEST_CODE_SUPDER = 2;
	protected static final int REQUEST_CODE_MEDDER = 3;
	protected static final int REQUEST_CODE_INFDER = 4;
	protected static final int REQUEST_CODE_INFCEN = 5;
	protected static final int REQUEST_CODE_INFIZQ = 6;
	protected static final int REQUEST_CODE_MEDIZQ = 7;
	protected static final int REQUEST_CODE_SUPIZQ = 8;
	public final static String EXTRA_MESSAGE = "Datos";
	private ImageView psupcen,psupder,psupizq, pmedder, pmedizq, pinfizq, pinfcen, pinfder,calcular;

	private static final int OK_RESULT_CODE = 1;

	@Override
	protected void onSaveInstanceState(Bundle state) {
		super.onSaveInstanceState(state);
		state.putSerializable("supcen1", supcen1);
		state.putSerializable("supcen2", supcen2);
		state.putSerializable("supcen3", supcen3);
		state.putSerializable("supizq1=", supizq1);
		state.putSerializable("supizq2", supizq2);
		state.putSerializable("supizq3", supizq3);
		state.putSerializable("supder1", supder1);
		state.putSerializable("supder2", supder2);
		state.putSerializable("supder3", supder3);
		state.putSerializable("medizq", medizq1);
		state.putSerializable("medizq2", medizq2);
		state.putSerializable("medizq3", medizq3);
		state.putSerializable("medder1", medder1);
		state.putSerializable("medder2", medder2);
		state.putSerializable("medder3", medder3);
		state.putSerializable("infcen1", infcen1);
		state.putSerializable("infcen2", infcen2);
		state.putSerializable("infcen3", infcen3);
		state.putSerializable("infizq1", infizq1);
		state.putSerializable("infizq2", infizq2);
		state.putSerializable("infizq3", infizq3);
		state.putSerializable("infder1", infder1);
		state.putSerializable("infder2", infder2);
		state.putSerializable("infder3", infder3);

	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		super.onRestoreInstanceState(savedInstanceState);
		restaurarEstado(savedInstanceState);


	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_glorieta1);
		psupcen = (ImageView) findViewById(R.id.psupmed);
		psupizq = (ImageView) findViewById(R.id.psupizq);
		psupder = (ImageView) findViewById(R.id.psupder);
		pmedder = (ImageView) findViewById(R.id.pmedder);
		pmedizq = (ImageView) findViewById(R.id.pmedizq);
		pinfizq = (ImageView) findViewById(R.id.pinfizq);
		pinfder = (ImageView) findViewById(R.id.pinfder);
		pinfcen = (ImageView) findViewById(R.id.pinfcen);

		calcular = (ImageView) findViewById(R.id.Calc);

		psupcen.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(1);


			}

		});

		psupder.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(2);


			}

		});

		pmedder.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(3);


			}

		});

		pinfder.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(4);


			}

		});


		pinfcen.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(5);


			}

		});

		pinfizq.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(6);


			}

		});

		pmedizq.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(7);


			}

		});

		psupizq.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(8);


			}

		});

		ImageView funcion = (ImageView) findViewById(R.id.Calc);
		funcion.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//Cierra la actividad y la saca de la pila
				if (completado ()) calcularEm();

			}
		});

		if (savedInstanceState != null) {
			restaurarEstado(savedInstanceState);
		}

	}



	protected void calcularEm() {

		double em;
		em =supcen1+supcen2+supcen3+supizq1+supizq2+supizq3
				+supder1+supder2+supder3
				+medizq1+medizq2+medizq3+medder1+medder2+medder3
				+infcen1+infcen2+infcen3
				+infizq1+infizq2+infizq3
				+infder1+infder2+infder3;
		em = em / 24;


		Intent intent = new Intent();
		intent.putExtra("em", String.valueOf(em));
		setResult(RESULT_OK, intent);
		finish();
	}


	protected void comenzar(int i) {
		// TODO Auto-generated method stub

		if (i == 1 )
		{
			Intent intent = new Intent(this, CarrilUnico.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("1");
			argumentos.add(Double.toString(this.supcen1));
			argumentos.add(Double.toString(this.supcen2));
			argumentos.add(Double.toString(this.supcen3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPCEN);
		}

		if (i == 2 )
		{
			Intent intent = new Intent(this, CarrilUnico.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("2");
			argumentos.add(Double.toString(this.supder1));
			argumentos.add(Double.toString(this.supder2));
			argumentos.add(Double.toString(this.supder3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPDER);
		}

		if (i == 3 )
		{
			Intent intent = new Intent(this, CarrilUnico.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("3");
			argumentos.add(Double.toString(this.medder1));
			argumentos.add(Double.toString(this.medder2));
			argumentos.add(Double.toString(this.medder3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_MEDDER);
		}

		if (i == 4 )
		{
			Intent intent = new Intent(this, CarrilUnico.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("4");
			argumentos.add(Double.toString(this.infder1));
			argumentos.add(Double.toString(this.infder2));
			argumentos.add(Double.toString(this.infder3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFDER);
		}

		if (i == 5 )
		{
			Intent intent = new Intent(this, CarrilUnico.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("5");
			argumentos.add(Double.toString(this.infcen1));
			argumentos.add(Double.toString(this.infcen2));
			argumentos.add(Double.toString(this.infcen3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFCEN);
		}

		if (i == 6 )
		{
			Intent intent = new Intent(this, CarrilUnico.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("6");
			argumentos.add(Double.toString(this.infizq1));
			argumentos.add(Double.toString(this.infizq2));
			argumentos.add(Double.toString(this.infizq3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFIZQ);
		}

		if (i == 7 )
		{
			Intent intent = new Intent(this, CarrilUnico.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("7");
			argumentos.add(Double.toString(this.medizq1));
			argumentos.add(Double.toString(this.medizq2));
			argumentos.add(Double.toString(this.medizq3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_MEDIZQ);
		}

		if (i == 8 )
		{
			Intent intent = new Intent(this, CarrilUnico.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("8");
			argumentos.add(Double.toString(this.supizq1));
			argumentos.add(Double.toString(this.supizq2));
			argumentos.add(Double.toString(this.supizq3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPIZQ);
		}



	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.glorieta1, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == REQUEST_CODE_SUPCEN) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supcen1 = Double.parseDouble(resultado.get(0));
				this.supcen2 = Double.parseDouble(resultado.get(1));
				this.supcen3 = Double.parseDouble(resultado.get(2));
				if ((this.supcen1 >= 0) && (this.supcen2 >= 0) && (this.supcen3 >= 0))
				{
					psupcen.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}
				if (completado ()) calcular.setVisibility(View.VISIBLE); else calcular.setVisibility(View.GONE);

			}

		}

		if (requestCode == REQUEST_CODE_SUPDER) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supder1 = Double.parseDouble(resultado.get(0));
				this.supder2 = Double.parseDouble(resultado.get(1));
				this.supder3 = Double.parseDouble(resultado.get(2));
				if ((this.supder1 >= 0) && (this.supder2 >= 0) && (this.supder3 >= 0))
				{
					psupder.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}
				if (completado ()) calcular.setVisibility(View.VISIBLE); else calcular.setVisibility(View.GONE);

			}

		}

		if (requestCode == REQUEST_CODE_MEDDER) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.medder1 = Double.parseDouble(resultado.get(0));
				this.medder2 = Double.parseDouble(resultado.get(1));
				this.medder3 = Double.parseDouble(resultado.get(2));
				if ((this.medder1 >= 0) && (this.medder2 >= 0) && (this.medder3 >= 0))
				{
					pmedder.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}
				if (completado ()) calcular.setVisibility(View.VISIBLE); else calcular.setVisibility(View.GONE);

			}

		}

		if (requestCode == REQUEST_CODE_INFDER) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infder1 = Double.parseDouble(resultado.get(0));
				this.infder2 = Double.parseDouble(resultado.get(1));
				this.infder3 = Double.parseDouble(resultado.get(2));
				if ((this.infder1 >= 0) && (this.infder2 >= 0) && (this.infder3 >= 0))
				{
					pinfder.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}
				if (completado ()) calcular.setVisibility(View.VISIBLE); else calcular.setVisibility(View.GONE);

			}

		}

		if (requestCode == REQUEST_CODE_INFCEN) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infcen1 = Double.parseDouble(resultado.get(0));
				this.infcen2 = Double.parseDouble(resultado.get(1));
				this.infcen3 = Double.parseDouble(resultado.get(2));
				if ((this.infcen1 >= 0) && (this.infcen2 >= 0) && (this.infcen3 >= 0))
				{
					pinfcen.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}
				if (completado ()) calcular.setVisibility(View.VISIBLE); else calcular.setVisibility(View.GONE);

			}

		}

		if (requestCode == REQUEST_CODE_INFIZQ) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infizq1 = Double.parseDouble(resultado.get(0));
				this.infizq2 = Double.parseDouble(resultado.get(1));
				this.infizq3 = Double.parseDouble(resultado.get(2));
				if ((this.infizq1 >= 0) && (this.infizq2 >= 0) && (this.infizq3 >= 0))
				{
					pinfizq.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}
				if (completado ()) calcular.setVisibility(View.VISIBLE); else calcular.setVisibility(View.GONE);

			}

		}

		if (requestCode == REQUEST_CODE_MEDIZQ) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.medizq1 = Double.parseDouble(resultado.get(0));
				this.medizq2 = Double.parseDouble(resultado.get(1));
				this.medizq3 = Double.parseDouble(resultado.get(2));
				if ((this.medizq1 >= 0) && (this.medizq2 >= 0) && (this.medizq3 >= 0))
				{
					pmedizq.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}

				if (completado ()) calcular.setVisibility(View.VISIBLE); else calcular.setVisibility(View.GONE);
			}

		}

		if (requestCode == REQUEST_CODE_SUPIZQ) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supizq1 = Double.parseDouble(resultado.get(0));
				this.supizq2 = Double.parseDouble(resultado.get(1));
				this.supizq3 = Double.parseDouble(resultado.get(2));
				if ((this.supizq1 >= 0) && (this.supizq2 >= 0) && (this.supizq3 >= 0))
				{
					psupizq.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}

				if (completado ()) calcular.setVisibility(View.VISIBLE); else calcular.setVisibility(View.GONE);
			}

		}

	}

	public boolean completado ()
	{



		return ((supcen1!= -1) && (supcen2!=-1) && (supcen3!=-1)
				&& (supizq1!=-1) && (supizq2!=-1) && (supizq3!=-1)
				&& (supder1!=-1)  && (supder2!=-1) && (supder3!=-1)
				&& (medizq1!=-1)  && (medizq2!=-1) && (medizq3!=-1)
				&& (medder1!=-1)  && (medder2!=-1) && (medder3!=-1)
				&& (infcen1!=-1)  && (infcen2!=-1) && (infcen3!=-1)
				&& (infizq1!=-1)  && (infizq2!=-1) && (infizq3!=-1)
				&& (infder1!=-1)  && (infder2!=-1) && (infder3!=-1));

	}

	private void restaurarEstado(Bundle savedInstanceState)
	{

		supcen1=(double) savedInstanceState.getSerializable("supcen1");
		supcen2=(double) savedInstanceState.getSerializable("supcen2");
		supcen3=(double) savedInstanceState.getSerializable("supcen3");
		supizq1=(double) savedInstanceState.getSerializable("supizq1");
		supizq2=(double) savedInstanceState.getSerializable("supizq2");
		supizq3=(double) savedInstanceState.getSerializable("supizq3");
		supder1=(double) savedInstanceState.getSerializable("supder1");
		supder2=(double) savedInstanceState.getSerializable("supder2");
		supder3=(double) savedInstanceState.getSerializable("supder3");
		medizq1= (double) savedInstanceState.getSerializable("medizq1");
		medizq2=(double) savedInstanceState.getSerializable("medizq2");
		medizq3=(double) savedInstanceState.getSerializable("medizq3");
		medder1=(double) savedInstanceState.getSerializable("medder1");
		medder2=(double) savedInstanceState.getSerializable("medder2");
		medder3=(double) savedInstanceState.getSerializable("medder3");
		infcen1=(double) savedInstanceState.getSerializable("infcen1");
		infcen2=(double) savedInstanceState.getSerializable("infcen2");
		infcen3=(double) savedInstanceState.getSerializable("infcen3");
		infizq1=(double) savedInstanceState.getSerializable("infizq1");
		infizq2=(double) savedInstanceState.getSerializable("infizq2");
		infizq3=(double) savedInstanceState.getSerializable("infizq3");
		infder1=(double) savedInstanceState.getSerializable("infder1");
		infder2=(double) savedInstanceState.getSerializable("infder2");
		infder3=(double) savedInstanceState.getSerializable("infder3");


		if ((this.supcen1 >= 0) && (this.supcen2 >= 0) && (this.supcen3 >= 0))
		{
			psupcen.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
		}


		if ((this.supder1 >= 0) && (this.supder2 >= 0) && (this.supder3 >= 0))
		{
			psupder.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
		}



		if ((this.medder1 >= 0) && (this.medder2 >= 0) && (this.medder3 >= 0))
		{
			pmedder.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
		}

		if ((this.infder1 >= 0) && (this.infder2 >= 0) && (this.infder3 >= 0))
		{
			pinfder.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
		}
		if (completado ()) calcular.setVisibility(View.VISIBLE); else calcular.setVisibility(View.GONE);


		if ((this.infcen1 >= 0) && (this.infcen2 >= 0) && (this.infcen3 >= 0))
		{
			pinfcen.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
		}



		if ((this.infizq1 >= 0) && (this.infizq2 >= 0) && (this.infizq3 >= 0))
		{
			pinfizq.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
		}



		if ((this.medizq1 >= 0) && (this.medizq2 >= 0) && (this.medizq3 >= 0))
		{
			pmedizq.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
		}



		if ((this.supizq1 >= 0) && (this.supizq2 >= 0) && (this.supizq3 >= 0))
		{
			psupizq.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
		}



		if (completado ()) calcular.setVisibility(View.VISIBLE); else calcular.setVisibility(View.GONE);

	}

}