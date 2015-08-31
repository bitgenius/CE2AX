package com.example.ce2ax;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	
	final Context context = this;
	private EditText editTextSuperficie;
	private EditText editTextPotencia;
	private EditText editTextEm;

	
	private TextView tcalcular;
	
	private RadioGroup rgTipo;
	private RadioGroup rgFunc;
	int numCarriles=0;
	
	protected static final int REQUEST_CODE = 10;
	public final static String EXTRA_MESSAGE = "Datos Calcular Eficiencia";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/* Inicializamos todos los atributos de la actividad */
		this.tcalcular = (TextView) this.findViewById(R.id.textViewCalc);
		this.rgTipo = (RadioGroup) this.findViewById(R.id.radioGroupVia);
		this.rgFunc = (RadioGroup) this.findViewById(R.id.radioGroupFun);
		
        this.editTextEm = (EditText) findViewById(R.id.editEm);  		
		this.editTextSuperficie = (EditText) this.findViewById(R.id.editSuperfie);
		this.editTextPotencia = (EditText) this.findViewById(R.id.editPotencia);
		this.editTextEm = (EditText) this.findViewById(R.id.editEm);
		
		/* En un principio se oculta el botón Calcular, que solámente se mostrará si están todos los campos completados */
		
		
		tcalcular.setVisibility(View.GONE);	

		/* Listener para el botón "Calcular". Si se pulsa llamará al método "calcularEficiencia" */
		
		tcalcular.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				calcularEficiencia ();
			}
		
		});
		
		/* Listener para controlar la visibilidad del radioGroupFun en el caso que no está marcado "Vía" */
		
		this.rgTipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
		      public void onCheckedChanged(RadioGroup arg0, int id) {
		        switch (id) {
		        case -1:		        	
		        	rgFunc.setVisibility (View.VISIBLE);
		          break;
		        case R.id.radioVia:
		        	rgFunc.setVisibility (View.VISIBLE);
		          break;
		        case R.id.radioGlor:
		        	rgFunc.setVisibility (View.GONE);
		          break;
		        default:
		        	rgFunc.setVisibility (View.VISIBLE);
		          break;
		        }
		      }
		    });
		
		
		/* Listeners para controlar que todos los edittext no están en blanco y si están todos completos 	 *
		 * el botón calcular se hará visible 																 */
		
		// listener para superficie:
		this.editTextSuperficie.addTextChangedListener(new TextWatcher() {			
	         public void afterTextChanged(Editable s){}
	         public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

	         public void onTextChanged(CharSequence s, int start, int before, int count) 
	         {

	        	 if (!(editTextSuperficie.getText().toString().equals("")) && 
	        			 !(editTextEm.getText().toString().equals("")) &&
	        			 !(editTextPotencia.getText().toString().equals(""))) 
	        	 {

	        		 tcalcular.setVisibility(View.VISIBLE);
	        	 }
	        	 else
	        	 {
	        		 tcalcular.setVisibility(View.GONE);
	        		 
	        	 }
	        	  
	         }});
		
		// listener para potencia:
		this.editTextPotencia.addTextChangedListener(new TextWatcher() {			
	         public void afterTextChanged(Editable s){}
	         public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

	         public void onTextChanged(CharSequence s, int start, int before, int count) 
	         {

	        	 if (!(editTextSuperficie.getText().toString().equals("")) && 
	        			 !(editTextEm.getText().toString().equals("")) &&
	        			 !(editTextPotencia.getText().toString().equals(""))) 
	        	 {
	        		 tcalcular.setVisibility(View.VISIBLE);
	        	 }
	        	 else
	        	 {
	        		 tcalcular.setVisibility(View.GONE);
	        	 }
	        	  
	         }});
		
		//listener para Em:
		this.editTextEm.addTextChangedListener(new TextWatcher() {			
	         public void afterTextChanged(Editable s){}
	         public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

	         public void onTextChanged(CharSequence s, int start, int before, int count) 
	         {

	        	 if (completado()) 
	        	 {
	        		 tcalcular.setVisibility(View.VISIBLE);
	        	 }
	        	 else
	        	 {
	        		 tcalcular.setVisibility(View.GONE);
	        	 }
	        	  
	         }});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
			case R.id.visualizar:
				//metodoAdd()
				Intent intent = new Intent(this, EtiquetaListActivity.class);
				startActivity(intent);
				return true;

			default:
				return super.onOptionsItemSelected(item);

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {


		System.out.println("requestCode=" + requestCode + " resultCode=" + resultCode + " RESULT_OK=" + RESULT_OK);
		if(resultCode == RESULT_OK){

		if (requestCode == REQUEST_CODE) {


				String result=data.getStringExtra("em");
				System.out.println(result);
				editTextEm.setText(result);
			}
		}
	}//onActivityResult
	
	
	
	
	/* Método para definir los parametros para enviar como mensaje a la actividad en la que se muestra la etiqueta */
	
	public void calcularEficiencia ()
	{
		

		if (completado()) 
		{
  
	        ArrayList<String> argumentos = new ArrayList<String>();
	        argumentos.add(this.editTextPotencia.getText().toString());
	        argumentos.add(this.editTextEm.getText().toString());
	        argumentos.add(this.editTextSuperficie.getText().toString());
	        
	        
	        if (this.rgTipo.getCheckedRadioButtonId()==R.id.radioGlor) 
	        {
	        	argumentos.add("Ambiental");
	        }
	        else
	        {
	        	if (this.rgFunc.getCheckedRadioButtonId()==R.id.radioAmb) argumentos.add("Ambiental");  else argumentos.add("Funcional");
	        }

			
	        //llamamos a la actividad CalcularEficiencia con el arrayList de variables como mensaje
			
			Intent intent = new Intent(this, CalcularEficiencia.class);
			intent.putExtra(EXTRA_MESSAGE, argumentos);
			startActivity(intent);
			
		}
	}
	
	
	/* Método que nos indica si todos los campos están completados */
	
	public boolean completado()
	{
		
		return (!(editTextSuperficie.getText().toString().equals("")) && !(editTextEm.getText().toString().equals("")) &&
   			 		!(editTextPotencia.getText().toString().equals("")));
	}
	
	
	/* Método que según el tipo de vía comienza la actividad de medida (9 puntos o glorieta) */
	
	
	public void comenzarMedir (View view)
	{
		
		if (this.rgTipo.getCheckedRadioButtonId()==R.id.radioGlor){
			
			//Ventana emergente para seleccionar el número de carriles de la glorieta:
			LayoutInflater li = LayoutInflater.from(context);
			View promptsView = li.inflate(R.layout.carriles, null);
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
			alertDialogBuilder.setView(promptsView);
			final Spinner userInput = (Spinner) promptsView
					.findViewById(R.id.spinnerCarriles);
			
			//inicializamos la lista de las opciones del spinner:
			List<String> list = new ArrayList<String>();
			list.add("1 carril");
			list.add("2 carriles");
			list.add("3 carriles");	
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			userInput.setAdapter(dataAdapter);
			
			//inicializamos listener de botón para comenzar la actividad correspondiente a 1, 2 o 3 carriles:
			
			alertDialogBuilder.setCancelable(false).setPositiveButton("OK",
					  new DialogInterface.OnClickListener() {
					    public void onClick(DialogInterface dialog,int id) {

					    	if (userInput.getSelectedItem().equals("1 carril")) {
					    		comienza(1);

					    	}
					    	if (userInput.getSelectedItem().equals("2 carriles")) {
					    		comienza(2);

					    	}
					    	if (userInput.getSelectedItem().equals("3 carriles")) {
					    		comienza(3);

					    	}
					    	
					    }
					  })
					.setNegativeButton("Cancel",
					  new DialogInterface.OnClickListener() {
					    public void onClick(DialogInterface dialog,int id) {
					    	numCarriles=0;
						dialog.cancel();
					    }
					  });
			
			AlertDialog alertDialog = alertDialogBuilder.create();

			
			alertDialog.show();
			System.out.println ("carril fuera= "+numCarriles);
			if (numCarriles==1)
			{
				Intent intent = new Intent(this, Glorieta1.class);
				startActivityForResult(intent, REQUEST_CODE);
			}
		}
		else
		{
			Intent intent = new Intent(this, NuevePuntos.class);
			startActivityForResult(intent, REQUEST_CODE);
		}
	}
	
	
	
	protected void comienza(int carriles) {
	
		
		if (carriles==1) {Intent intent = new Intent(this, Glorieta1.class);startActivityForResult(intent, REQUEST_CODE);}
		if (carriles==2) {Intent intent = new Intent(this, Glorieta2.class);startActivityForResult(intent, REQUEST_CODE);}
		if (carriles==3) {Intent intent = new Intent(this, Glorieta3.class);startActivityForResult(intent, REQUEST_CODE);}
	}
	
	
}
