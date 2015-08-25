package com.example.ce2ax;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Glorieta3 extends Activity {

	double supcenarr1=-1,supcenarr2=-1,supcenarr3=-1;
	double supcenab1=-1,supcenab2=-1,supcenab3=-1;
	double supcenmed1=-1,supcenmed2=-1,supcenmed3=-1;
	double supizqarr1=-1,supizqarr2=-1,supizqarr3=-1;
	double supizqab1=-1,supizqab2=-1,supizqab3=-1;
	double supizqmed1=-1,supizqmed2=-1,supizqmed3=-1;
	double supderarr1=-1,supderarr2=-1,supderarr3=-1;
	double supderab1=-1,supderab2=-1,supderab3=-1;
	double supdermed1=-1,supdermed2=-1,supdermed3=-1;
	double medizqarr1=-1,medizqarr2=-1,medizqarr3=-1;
	double medizqab1=-1,medizqab2=-1,medizqab3=-1;
	double medizqmed1=-1,medizqmed2=-1,medizqmed3=-1;
	double medderarr1=-1,medderarr2=-1,medderarr3=-1;
	double medderab1=-1,medderab2=-1,medderab3=-1;
	double meddermed1=-1,meddermed2=-1,meddermed3=-1;
	double infcenarr1=-1,infcenarr2=-1,infcenarr3=-1;
	double infcenab1=-1,infcenab2=-1,infcenab3=-1;
	double infcenmed1=-1,infcenmed2=-1,infcenmed3=-1;
	double infizqarr1=-1,infizqarr2=-1,infizqarr3=-1;
	double infizqab1=-1,infizqab2=-1,infizqab3=-1;
	double infizqmed1=-1,infizqmed2=-1,infizqmed3=-1;
	double infderarr1=-1,infderarr2=-1,infderarr3=-1;
	double infderab1=-1,infderab2=-1,infderab3=-1;
	double infdermed1=-1,infdermed2=-1,infdermed3=-1;

	protected static final int REQUEST_CODE_SUPCENARR = 1;
	protected static final int REQUEST_CODE_SUPCENAB = 9;
	protected static final int REQUEST_CODE_SUPDERARR = 2;
	protected static final int REQUEST_CODE_SUPDERAB= 10;
	protected static final int REQUEST_CODE_MEDDERARR = 3;
	protected static final int REQUEST_CODE_MEDDERAB = 11;
	protected static final int REQUEST_CODE_INFDERARR = 4;
	protected static final int REQUEST_CODE_INFDERAB = 12;
	protected static final int REQUEST_CODE_INFCENARR = 5;
	protected static final int REQUEST_CODE_INFCENAB = 13;
	protected static final int REQUEST_CODE_INFIZQARR = 6;
	protected static final int REQUEST_CODE_INFIZQAB = 14;
	protected static final int REQUEST_CODE_MEDIZQARR = 7;
	protected static final int REQUEST_CODE_MEDIZQAB = 15;
	protected static final int REQUEST_CODE_SUPIZQARR = 8;
	protected static final int REQUEST_CODE_SUPIZQAB = 16;

	protected static final int REQUEST_CODE_SUPCENMED = 17;
	protected static final int REQUEST_CODE_SUPDERMED = 18;
	protected static final int REQUEST_CODE_MEDDERMED = 19;
	protected static final int REQUEST_CODE_INFDERMED = 20;
	protected static final int REQUEST_CODE_INFCENMED = 21;
	protected static final int REQUEST_CODE_INFIZQMED = 22;
	protected static final int REQUEST_CODE_MEDIZQMED = 23;
	protected static final int REQUEST_CODE_SUPIZQMED = 24;

	public final static String EXTRA_MESSAGE = "Datos";
	private ImageView psupcenarr,psupderarr,psupizqarr, pmedderarr, pmedizqarr, pinfizqarr, pinfcenarr, pinfderarr;
	private ImageView psupcenab,psupderab,psupizqab, pmedderab, pmedizqab, pinfizqab, pinfcenab, pinfderab;
	private ImageView psupcenmed,psupdermed,psupizqmed, pmeddermed, pmedizqmed, pinfizqmed, pinfcenmed, pinfdermed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_glorieta3);

		psupcenarr = (ImageView) findViewById(R.id.psupcenarr);
		psupizqarr = (ImageView) findViewById(R.id.psupizqarr);
		psupderarr = (ImageView) findViewById(R.id.psupderarr);
		pmedderarr = (ImageView) findViewById(R.id.pmedderarr);
		pmedizqarr = (ImageView) findViewById(R.id.pmedizqarr);
		pinfizqarr = (ImageView) findViewById(R.id.pinfizqarr);
		pinfderarr = (ImageView) findViewById(R.id.pinfderarr);
		pinfcenarr = (ImageView) findViewById(R.id.pinfcenarr);
		psupcenab = (ImageView) findViewById(R.id.psupcenab);
		psupizqab = (ImageView) findViewById(R.id.psupizqab);
		psupderab = (ImageView) findViewById(R.id.psupderab);
		pmedderab = (ImageView) findViewById(R.id.pmedderab);
		pmedizqab = (ImageView) findViewById(R.id.pmedizqab);
		pinfizqab = (ImageView) findViewById(R.id.pinfizqab);
		pinfderab = (ImageView) findViewById(R.id.pinfderab);
		pinfcenab = (ImageView) findViewById(R.id.pinfcenab);

		psupcenmed = (ImageView) findViewById(R.id.psupcenmed);
		psupizqmed = (ImageView) findViewById(R.id.psupizqmed);
		psupdermed = (ImageView) findViewById(R.id.psupdermed);
		pmeddermed = (ImageView) findViewById(R.id.pmeddermed);
		pmedizqmed = (ImageView) findViewById(R.id.pmedizqmed);
		pinfizqmed = (ImageView) findViewById(R.id.pinfizqmed);
		pinfdermed = (ImageView) findViewById(R.id.pinfdermed);
		pinfcenmed = (ImageView) findViewById(R.id.pinfcenmed);

		psupcenarr.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(1);


			}

		});

		psupderarr.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(2);


			}

		});

		pmedderarr.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(3);


			}

		});

		pinfderarr.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(4);


			}

		});


		pinfcenarr.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(5);


			}

		});

		pinfizqarr.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(6);


			}

		});

		pmedizqarr.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(7);


			}

		});

		psupizqarr.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(8);


			}

		});

		psupcenab.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(9);


			}

		});

		psupderab.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(10);


			}

		});

		pmedderab.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(11);


			}

		});

		pinfderab.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(12);


			}

		});


		pinfcenab.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(13);


			}

		});

		pinfizqab.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(14);


			}

		});

		pmedizqab.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(15);


			}

		});

		psupizqab.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(16);


			}

		});

		psupcenmed.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(17);


			}

		});

		psupdermed.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(18);


			}

		});

		pmeddermed.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(19);


			}

		});

		pinfdermed.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(20);


			}

		});


		pinfcenmed.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(21);


			}

		});

		pinfizqmed.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(22);


			}

		});

		pmedizqmed.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(23);


			}

		});

		psupizqmed.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0)
			{
				comenzar(24);


			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.glorieta2, menu);
		return true;
	}


	protected void comenzar(int i) {
		// TODO Auto-generated method stub

		if (i == 1 )
		{
			Intent intent = new Intent(this, CarrilExterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("1");
			argumentos.add(Double.toString(this.supcenarr1));
			argumentos.add(Double.toString(this.supcenarr2));
			argumentos.add(Double.toString(this.supcenarr3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPCENARR);
		}

		if (i == 2 )
		{
			Intent intent = new Intent(this, CarrilExterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("2");
			argumentos.add(Double.toString(this.supderarr1));
			argumentos.add(Double.toString(this.supderarr2));
			argumentos.add(Double.toString(this.supderarr3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPDERARR);
		}

		if (i == 3 )
		{
			Intent intent = new Intent(this, CarrilExterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("3");
			argumentos.add(Double.toString(this.medderarr1));
			argumentos.add(Double.toString(this.medderarr2));
			argumentos.add(Double.toString(this.medderarr3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_MEDDERARR);
		}

		if (i == 4 )
		{
			Intent intent = new Intent(this, CarrilExterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("4");
			argumentos.add(Double.toString(this.infderarr1));
			argumentos.add(Double.toString(this.infderarr2));
			argumentos.add(Double.toString(this.infderarr3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFDERARR);
		}

		if (i == 5 )
		{
			Intent intent = new Intent(this, CarrilExterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("5");
			argumentos.add(Double.toString(this.infcenarr1));
			argumentos.add(Double.toString(this.infcenarr2));
			argumentos.add(Double.toString(this.infcenarr3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFCENARR);
		}

		if (i == 6 )
		{
			Intent intent = new Intent(this, CarrilExterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("6");
			argumentos.add(Double.toString(this.infizqarr1));
			argumentos.add(Double.toString(this.infizqarr2));
			argumentos.add(Double.toString(this.infizqarr3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFIZQARR);
		}

		if (i == 7 )
		{
			Intent intent = new Intent(this, CarrilExterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("7");
			argumentos.add(Double.toString(this.medizqarr1));
			argumentos.add(Double.toString(this.medizqarr2));
			argumentos.add(Double.toString(this.medizqarr3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_MEDIZQARR);
		}

		if (i == 8 )
		{
			Intent intent = new Intent(this, CarrilExterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("8");
			argumentos.add(Double.toString(this.supizqarr1));
			argumentos.add(Double.toString(this.supizqarr2));
			argumentos.add(Double.toString(this.supizqarr3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPIZQARR);
		}
		if (i == 9 )
		{
			Intent intent = new Intent(this, CarrilInterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("9");
			argumentos.add(Double.toString(this.supcenab1));
			argumentos.add(Double.toString(this.supcenab2));
			argumentos.add(Double.toString(this.supcenab3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPCENAB);
		}

		if (i == 10 )
		{
			Intent intent = new Intent(this, CarrilInterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("10");
			argumentos.add(Double.toString(this.supderab1));
			argumentos.add(Double.toString(this.supderab2));
			argumentos.add(Double.toString(this.supderab3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPDERAB);
		}

		if (i == 11 )
		{
			Intent intent = new Intent(this, CarrilInterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("11");
			argumentos.add(Double.toString(this.medderab1));
			argumentos.add(Double.toString(this.medderab2));
			argumentos.add(Double.toString(this.medderab3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_MEDDERAB);
		}

		if (i == 12 )
		{
			Intent intent = new Intent(this, CarrilInterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("12");
			argumentos.add(Double.toString(this.infderab1));
			argumentos.add(Double.toString(this.infderab2));
			argumentos.add(Double.toString(this.infderab3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFDERAB);
		}

		if (i == 13 )
		{
			Intent intent = new Intent(this, CarrilInterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("13");
			argumentos.add(Double.toString(this.infcenab1));
			argumentos.add(Double.toString(this.infcenab2));
			argumentos.add(Double.toString(this.infcenab3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFCENAB);
		}

		if (i == 14 )
		{
			Intent intent = new Intent(this, CarrilInterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("14");
			argumentos.add(Double.toString(this.infizqab1));
			argumentos.add(Double.toString(this.infizqab2));
			argumentos.add(Double.toString(this.infizqab3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFIZQAB);
		}

		if (i == 15 )
		{
			Intent intent = new Intent(this, CarrilInterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("15");
			argumentos.add(Double.toString(this.medizqab1));
			argumentos.add(Double.toString(this.medizqab2));
			argumentos.add(Double.toString(this.medizqab3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_MEDIZQAB);
		}

		if (i == 16 )
		{
			Intent intent = new Intent(this, CarrilInterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("16");
			argumentos.add(Double.toString(this.supizqab1));
			argumentos.add(Double.toString(this.supizqab2));
			argumentos.add(Double.toString(this.supizqab3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPIZQAB);
		}

		if (i == 17 )
		{
			Intent intent = new Intent(this, CarrilMedio.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("17");
			argumentos.add(Double.toString(this.supcenmed1));
			argumentos.add(Double.toString(this.supcenmed2));
			argumentos.add(Double.toString(this.supcenmed3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPCENARR);
		}

		if (i == 18 )
		{
			Intent intent = new Intent(this, CarrilMedio.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("18");
			argumentos.add(Double.toString(this.supdermed1));
			argumentos.add(Double.toString(this.supdermed2));
			argumentos.add(Double.toString(this.supdermed3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPDERARR);
		}

		if (i == 19 )
		{
			Intent intent = new Intent(this, CarrilMedio.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("19");
			argumentos.add(Double.toString(this.meddermed1));
			argumentos.add(Double.toString(this.meddermed2));
			argumentos.add(Double.toString(this.meddermed3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_MEDDERARR);
		}

		if (i == 20 )
		{
			Intent intent = new Intent(this, CarrilMedio.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("20");
			argumentos.add(Double.toString(this.infdermed1));
			argumentos.add(Double.toString(this.infdermed2));
			argumentos.add(Double.toString(this.infdermed3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFDERARR);
		}

		if (i == 21 )
		{
			Intent intent = new Intent(this, CarrilExterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("21");
			argumentos.add(Double.toString(this.infcenmed1));
			argumentos.add(Double.toString(this.infcenmed2));
			argumentos.add(Double.toString(this.infcenmed3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFCENARR);
		}

		if (i == 22 )
		{
			Intent intent = new Intent(this, CarrilMedio.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("22");
			argumentos.add(Double.toString(this.infizqmed1));
			argumentos.add(Double.toString(this.infizqmed2));
			argumentos.add(Double.toString(this.infizqmed3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_INFIZQARR);
		}

		if (i == 23 )
		{
			Intent intent = new Intent(this, CarrilMedio.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("23");
			argumentos.add(Double.toString(this.medizqmed1));
			argumentos.add(Double.toString(this.medizqmed2));
			argumentos.add(Double.toString(this.medizqmed3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_MEDIZQARR);
		}

		if (i == 24 )
		{
			Intent intent = new Intent(this, CarrilExterno.class);
			ArrayList<String> argumentos = new ArrayList<String>();
			argumentos.add("24");
			argumentos.add(Double.toString(this.supizqmed1));
			argumentos.add(Double.toString(this.supizqmed2));
			argumentos.add(Double.toString(this.supizqmed3));
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivityForResult(intent, REQUEST_CODE_SUPIZQARR);
		}

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == REQUEST_CODE_SUPCENARR) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supcenarr1 = Double.parseDouble(resultado.get(0));
				this.supcenarr2 = Double.parseDouble(resultado.get(1));
				this.supcenarr3 = Double.parseDouble(resultado.get(2));
				if ((this.supcenarr1 >= 0) && (this.supcenarr2 >= 0) && (this.supcenarr3 >= 0))
				{
					psupcenarr.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_SUPDERARR) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supderarr1 = Double.parseDouble(resultado.get(0));
				this.supderarr2 = Double.parseDouble(resultado.get(1));
				this.supderarr3 = Double.parseDouble(resultado.get(2));
				if ((this.supderarr1 >= 0) && (this.supderarr2 >= 0) && (this.supderarr3 >= 0))
				{
					psupderarr.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_MEDDERARR) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.medderarr1 = Double.parseDouble(resultado.get(0));
				this.medderarr2 = Double.parseDouble(resultado.get(1));
				this.medderarr3 = Double.parseDouble(resultado.get(2));
				if ((this.medderarr1 >= 0) && (this.medderarr2 >= 0) && (this.medderarr3 >= 0))
				{
					pmedderarr.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_INFDERARR) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infderarr1 = Double.parseDouble(resultado.get(0));
				this.infderarr2 = Double.parseDouble(resultado.get(1));
				this.infderarr3 = Double.parseDouble(resultado.get(2));
				if ((this.infderarr1 >= 0) && (this.infderarr2 >= 0) && (this.infderarr3 >= 0))
				{
					pinfderarr.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_INFCENARR) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infcenarr1 = Double.parseDouble(resultado.get(0));
				this.infcenarr2 = Double.parseDouble(resultado.get(1));
				this.infcenarr3 = Double.parseDouble(resultado.get(2));
				if ((this.infcenarr1 >= 0) && (this.infcenarr2 >= 0) && (this.infcenarr3 >= 0))
				{
					pinfcenarr.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_INFIZQARR) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infizqarr1 = Double.parseDouble(resultado.get(0));
				this.infizqarr2 = Double.parseDouble(resultado.get(1));
				this.infizqarr3 = Double.parseDouble(resultado.get(2));
				if ((this.infizqarr1 >= 0) && (this.infizqarr2 >= 0) && (this.infizqarr3 >= 0))
				{
					pinfizqarr.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_MEDIZQARR) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.medizqarr1 = Double.parseDouble(resultado.get(0));
				this.medizqarr2 = Double.parseDouble(resultado.get(1));
				this.medizqarr3 = Double.parseDouble(resultado.get(2));
				if ((this.medizqarr1 >= 0) && (this.medizqarr2 >= 0) && (this.medizqarr3 >= 0))
				{
					pmedizqarr.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_SUPIZQARR) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supizqarr1 = Double.parseDouble(resultado.get(0));
				this.supizqarr2 = Double.parseDouble(resultado.get(1));
				this.supizqarr3 = Double.parseDouble(resultado.get(2));
				if ((this.supizqarr1 >= 0) && (this.supizqarr2 >= 0) && (this.supizqarr3 >= 0))
				{
					psupizqarr.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_SUPCENAB) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supcenab1 = Double.parseDouble(resultado.get(0));
				this.supcenab2 = Double.parseDouble(resultado.get(1));
				this.supcenab3 = Double.parseDouble(resultado.get(2));
				if ((this.supcenab1 >= 0) && (this.supcenab2 >= 0) && (this.supcenab3 >= 0))
				{
					psupcenab.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_SUPDERAB) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supderab1 = Double.parseDouble(resultado.get(0));
				this.supderab2 = Double.parseDouble(resultado.get(1));
				this.supderab3 = Double.parseDouble(resultado.get(2));
				if ((this.supderab1 >= 0) && (this.supderab2 >= 0) && (this.supderab3 >= 0))
				{
					psupderab.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_MEDDERAB) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.medderab1 = Double.parseDouble(resultado.get(0));
				this.medderab2 = Double.parseDouble(resultado.get(1));
				this.medderab3 = Double.parseDouble(resultado.get(2));
				if ((this.medderab1 >= 0) && (this.medderab2 >= 0) && (this.medderab3 >= 0))
				{
					pmedderab.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_INFDERAB) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infderab1 = Double.parseDouble(resultado.get(0));
				this.infderab2 = Double.parseDouble(resultado.get(1));
				this.infderab3 = Double.parseDouble(resultado.get(2));
				if ((this.infderab1 >= 0) && (this.infderab2 >= 0) && (this.infderab3 >= 0))
				{
					pinfderarr.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_INFCENAB) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infcenab1 = Double.parseDouble(resultado.get(0));
				this.infcenab2 = Double.parseDouble(resultado.get(1));
				this.infcenab3 = Double.parseDouble(resultado.get(2));
				if ((this.infcenab1 >= 0) && (this.infcenab2 >= 0) && (this.infcenab3 >= 0))
				{
					pinfcenab.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_INFIZQAB) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infizqab1 = Double.parseDouble(resultado.get(0));
				this.infizqab2 = Double.parseDouble(resultado.get(1));
				this.infizqab3 = Double.parseDouble(resultado.get(2));
				if ((this.infizqab1 >= 0) && (this.infizqab2 >= 0) && (this.infizqab3 >= 0))
				{
					pinfizqab.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_MEDIZQAB) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.medizqab1 = Double.parseDouble(resultado.get(0));
				this.medizqab2 = Double.parseDouble(resultado.get(1));
				this.medizqab3 = Double.parseDouble(resultado.get(2));
				if ((this.medizqab1 >= 0) && (this.medizqarr2 >= 0) && (this.medizqarr3 >= 0))
				{
					pmedizqab.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}

		if (requestCode == REQUEST_CODE_SUPIZQAB) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supizqab1 = Double.parseDouble(resultado.get(0));
				this.supizqab2 = Double.parseDouble(resultado.get(1));
				this.supizqab3 = Double.parseDouble(resultado.get(2));
				if ((this.supizqab1 >= 0) && (this.supizqab2 >= 0) && (this.supizqab3 >= 0))
				{
					psupizqab.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
				}


			}

		}





		if (requestCode == REQUEST_CODE_SUPCENMED) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supcenmed1 = Double.parseDouble(resultado.get(0));
				this.supcenmed2 = Double.parseDouble(resultado.get(1));
				this.supcenmed3 = Double.parseDouble(resultado.get(2));
				if ((this.supcenmed1 >= 0) && (this.supcenmed2 >= 0) && (this.supcenmed3 >= 0))
				{
					psupcenmed.setImageDrawable(getResources().getDrawable(R.drawable.puntoverdepeq));
				}


			}

		}

		if (requestCode == REQUEST_CODE_SUPDERMED) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supdermed1 = Double.parseDouble(resultado.get(0));
				this.supdermed2 = Double.parseDouble(resultado.get(1));
				this.supdermed3 = Double.parseDouble(resultado.get(2));
				if ((this.supdermed1 >= 0) && (this.supdermed2 >= 0) && (this.supdermed3 >= 0))
				{
					psupdermed.setImageDrawable(getResources().getDrawable(R.drawable.puntoverdepeq));
				}


			}

		}

		if (requestCode == REQUEST_CODE_MEDDERMED) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.meddermed1 = Double.parseDouble(resultado.get(0));
				this.meddermed2 = Double.parseDouble(resultado.get(1));
				this.meddermed3 = Double.parseDouble(resultado.get(2));
				if ((this.meddermed1 >= 0) && (this.meddermed2 >= 0) && (this.meddermed3 >= 0))
				{
					pmeddermed.setImageDrawable(getResources().getDrawable(R.drawable.puntoverdepeq));
				}


			}

		}

		if (requestCode == REQUEST_CODE_INFDERMED) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infdermed1 = Double.parseDouble(resultado.get(0));
				this.infdermed2 = Double.parseDouble(resultado.get(1));
				this.infdermed3 = Double.parseDouble(resultado.get(2));
				if ((this.infdermed1 >= 0) && (this.infdermed2 >= 0) && (this.infdermed3 >= 0))
				{
					pinfderarr.setImageDrawable(getResources().getDrawable(R.drawable.puntoverdepeq));
				}


			}

		}

		if (requestCode == REQUEST_CODE_INFCENMED) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infcenmed1 = Double.parseDouble(resultado.get(0));
				this.infcenmed2 = Double.parseDouble(resultado.get(1));
				this.infcenmed3 = Double.parseDouble(resultado.get(2));
				if ((this.infcenmed1 >= 0) && (this.infcenmed2 >= 0) && (this.infcenmed3 >= 0))
				{
					pinfcenmed.setImageDrawable(getResources().getDrawable(R.drawable.puntoverdepeq));
				}


			}

		}

		if (requestCode == REQUEST_CODE_INFIZQMED) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.infizqmed1 = Double.parseDouble(resultado.get(0));
				this.infizqmed2 = Double.parseDouble(resultado.get(1));
				this.infizqmed3 = Double.parseDouble(resultado.get(2));
				if ((this.infizqmed1 >= 0) && (this.infizqmed2 >= 0) && (this.infizqmed3 >= 0))
				{
					pinfizqmed.setImageDrawable(getResources().getDrawable(R.drawable.puntoverdepeq));
				}


			}

		}

		if (requestCode == REQUEST_CODE_MEDIZQMED) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.medizqmed1 = Double.parseDouble(resultado.get(0));
				this.medizqmed2 = Double.parseDouble(resultado.get(1));
				this.medizqmed3 = Double.parseDouble(resultado.get(2));
				if ((this.medizqmed1 >= 0) && (this.medizqarr2 >= 0) && (this.medizqarr3 >= 0))
				{
					pmedizqmed.setImageDrawable(getResources().getDrawable(R.drawable.puntoverdepeq));
				}


			}

		}

		if (requestCode == REQUEST_CODE_SUPIZQMED) {
			if (data != null)
			{
				ArrayList<String> resultado = data.getStringArrayListExtra("result");
				this.supizqmed1 = Double.parseDouble(resultado.get(0));
				this.supizqmed2 = Double.parseDouble(resultado.get(1));
				this.supizqmed3 = Double.parseDouble(resultado.get(2));
				if ((this.supizqmed1 >= 0) && (this.supizqmed2 >= 0) && (this.supizqmed3 >= 0))
				{
					psupizqmed.setImageDrawable(getResources().getDrawable(R.drawable.puntoverdepeq));
				}


			}

		}






	}
}
