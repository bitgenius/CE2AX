package com.example.ce2ax;



import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Info extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println ("activity Comenzada");
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
	    ArrayList<String> mensajes = intent.getStringArrayListExtra(CalcularEficiencia.EXTRA_MESSAGE);
	    
	    setContentView(R.layout.activity_info);
		
		TextView tipo = (TextView) findViewById(R.id.textView2);
		TextView potencia = (TextView) findViewById(R.id.tmed);
		TextView superficie = (TextView) findViewById(R.id.textView4);
		TextView em = (TextView) findViewById(R.id.textView6);
		TextView e = (TextView) findViewById(R.id.textView8);
		TextView emin = (TextView) findViewById(R.id.textView10);
		TextView ie = (TextView) findViewById(R.id.textView14);
		TextView er = (TextView) findViewById(R.id.textView18);
		TextView ice = (TextView) findViewById(R.id.textView16);
		TextView cali = (TextView) findViewById(R.id.textView17);
		TextView cumple = (TextView) findViewById(R.id.textView11);
		
		tipo.setText(mensajes.get(0));
		potencia.setText(mensajes.get(1));
		superficie.setText(mensajes.get(2));
		em.setText(mensajes.get(3));
		e.setText(mensajes.get(4));
		emin.setText(mensajes.get(5));
		er.setText(mensajes.get(6));
		ie.setText(mensajes.get(7));
		ice.setText(mensajes.get(8));
		cali.setText(mensajes.get(9));
		if (mensajes.get(10).equals("1")) cumple.setVisibility(View.GONE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info, menu);
		return true;
	}

}