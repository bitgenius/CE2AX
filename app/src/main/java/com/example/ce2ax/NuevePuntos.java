package com.example.ce2ax;



import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class NuevePuntos extends Activity {

	final Context context = this;
	private ImageView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,calcular;
	private TextView tp1,tp2,tp3,tp4,tp5,tp6,tp7,tp8,tp9,tp10,tp11,tp12,tp13,tp14,tp15;
	private EditText result;
	private ToggleButton luxo; 
	private static final int OK_RESULT_CODE = 1;
	protected static final int REQUEST_CODE = 20;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nueve_puntos);
		
		// Declaración e inicialización de variables de los puntos como imágenes
		p1 = (ImageView) findViewById(R.id.Punto1);p2 = (ImageView) findViewById(R.id.pmedizq);p3 = (ImageView) findViewById(R.id.Punto3);
		p4 = (ImageView) findViewById(R.id.Punto4);p5 = (ImageView) findViewById(R.id.Punto5);p6 = (ImageView) findViewById(R.id.Punto6);
		p7 = (ImageView) findViewById(R.id.Punto7);p8 = (ImageView) findViewById(R.id.Punto8);p9 = (ImageView) findViewById(R.id.Punto9);
		p10 = (ImageView) findViewById(R.id.Punto10);p11 = (ImageView) findViewById(R.id.pmedder);p12 = (ImageView) findViewById(R.id.Punto12);
		p13 = (ImageView) findViewById(R.id.pder);p14 = (ImageView) findViewById(R.id.Punto14);p15 = (ImageView) findViewById(R.id.Punto15);
		
		// Declaración e inicialización de variables del texto (que indicará el valor) de los puntos
		tp1 = (TextView) findViewById(R.id.TextPunto1);tp2 = (TextView) findViewById(R.id.TextPunto2);tp3 = (TextView) findViewById(R.id.TextPunto3);
		tp4 = (TextView) findViewById(R.id.TextPunto4);tp5 = (TextView) findViewById(R.id.TextPunto5);tp6 = (TextView) findViewById(R.id.TextPunto6);
		tp7 = (TextView) findViewById(R.id.TextPunto7);tp8 = (TextView) findViewById(R.id.TextPunto8);tp9 = (TextView) findViewById(R.id.TextPunto9);
		tp10 = (TextView) findViewById(R.id.TextPunto10);tp11 = (TextView) findViewById(R.id.TextPunto11);tp12 = (TextView) findViewById(R.id.TextPunto12);
		tp13 = (TextView) findViewById(R.id.TextPunto13);tp14 = (TextView) findViewById(R.id.TextPunto14);tp15 = (TextView) findViewById(R.id.TextPunto15);
		
		// Declaración e inicialización del botón del luxometro
		luxo = (ToggleButton) findViewById(R.id.toggleButton1);
		
		// Declaración e inicialización del botón calcular
		calcular = (ImageView) findViewById(R.id.Calc);
		
		/*
		 * A continuación se declaran todos los listener de los puntos en la vía, de tal manera que si está marcado
		 * el botón de luxometro se inicializaria la medición por luxometro, pero si no es así se mostraía una 
		 * ventana para introducir el valor manualmente.
		 */
		
		p1.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				
				if (luxo.isChecked())
				{
					startLuxometro(10);
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
					    		tp1.setText("");
					    		p1.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp1.setText(userInput.getText());
					    		p1.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p2.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				
				
				if (luxo.isChecked())
				{
					startLuxometro(20);
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
					    		tp2.setText("");
					    		p2.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp2.setText(userInput.getText());
					    		p2.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		
		p3.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				
				if (luxo.isChecked())
				{
					startLuxometro(30);
				}
				else
				{
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
					    		tp3.setText("");
					    		p3.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp3.setText(userInput.getText());
					    		p3.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p4.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(40);
				}
				else
				{
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
					    		tp4.setText("");
					    		p4.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp4.setText(userInput.getText());
					    		p4.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p5.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(50);
				}
				else
				{
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
					    		tp5.setText("");
					    		p5.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp5.setText(userInput.getText());
					    		p5.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p6.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(60);
				}
				else
				{
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
					    		tp6.setText("");
					    		p6.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp6.setText(userInput.getText());
					    		p6.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p7.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(70);
				}
				else
				{
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
					    		tp7.setText("");
					    		p7.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp7.setText(userInput.getText());
					    		p7.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p8.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(80);
				}
				else
				{
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
					    		tp8.setText("");
					    		p8.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp8.setText(userInput.getText());
					    		p8.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p9.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(90);
				}
				else
				{
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
					    		tp9.setText("");
					    		p9.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp9.setText(userInput.getText());
					    		p9.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p10.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(100);
				}
				else
				{
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
					    		tp10.setText("");
					    		p10.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp10.setText(userInput.getText());
					    		p10.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p11.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(110);
				}
				else
				{
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
					    		tp11.setText("");
					    		p11.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp11.setText(userInput.getText());
					    		p11.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p12.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(120);
				}
				else
				{
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
					    		tp12.setText("");
					    		p12.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp12.setText(userInput.getText());
					    		p12.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p13.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(130);
				}
				else
				{
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
					    		tp13.setText("");
					    		p13.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp13.setText(userInput.getText());
					    		p13.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p14.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(140);
				}
				else
				{
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
					    		tp14.setText("");
					    		p14.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp14.setText(userInput.getText());
					    		p14.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		p15.setOnClickListener(new OnClickListener() {
			 

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get prompts.xml view
				if (luxo.isChecked())
				{
					startLuxometro(150);
				}
				else
				{
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
					    		tp15.setText("");
					    		p15.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
					    		if (completado ()) calcular.setVisibility(View.VISIBLE);
					    		}
					    	else
					    	{
					    		tp15.setText(userInput.getText());
					    		p15.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
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
		
		
		//Declaración del botón calcular que comprueba que todos los puntos estén completados para después llamar al método calcularEm()
		
		ImageView funcion = (ImageView) findViewById(R.id.Calc);
		funcion.setOnClickListener(new OnClickListener() {
	         public void onClick(View v) {
	            //Cierra la actividad y la saca de la pila
	        	 if (completado ()) calcularEm();
	        	 
	         }
	      });
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {


		if (resultCode == RESULT_OK)
		{
			switch(requestCode){
				case 10:

					if (data.getStringExtra("result").equals(""))
					{
						tp1.setText("");
						p1.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp1.setText(data.getStringExtra("result").replaceAll(",","."));
						p1.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 20:

					if (data.getStringExtra("result").equals(""))
					{
						tp2.setText("");
						p2.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp2.setText(data.getStringExtra("result").replaceAll(",","."));
						p2.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 30:

					if (data.getStringExtra("result").equals(""))
					{
						tp3.setText("");
						p3.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp3.setText(data.getStringExtra("result").replaceAll(",","."));
						p3.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 40:

					if (data.getStringExtra("result").equals(""))
					{
						tp4.setText("");
						p4.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp4.setText(data.getStringExtra("result").replaceAll(",","."));
						p4.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 50:

					if (data.getStringExtra("result").equals(""))
					{
						tp5.setText("");
						p5.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp5.setText(data.getStringExtra("result").replaceAll(",","."));
						p5.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 60:

					if (data.getStringExtra("result").equals(""))
					{
						tp6.setText("");
						p6.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp6.setText(data.getStringExtra("result").replaceAll(",","."));
						p6.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 70:

					if (data.getStringExtra("result").equals(""))
					{
						tp7.setText("");
						p4.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp7.setText(data.getStringExtra("result").replaceAll(",","."));
						p7.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 80:

					if (data.getStringExtra("result").equals(""))
					{
						tp8.setText("");
						p8.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp8.setText(data.getStringExtra("result").replaceAll(",","."));
						p8.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 90:

					if (data.getStringExtra("result").equals(""))
					{
						tp9.setText("");
						p9.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp9.setText(data.getStringExtra("result").replaceAll(",","."));
						p9.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 100:

					if (data.getStringExtra("result").equals(""))
					{
						tp10.setText("");
						p10.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp10.setText(data.getStringExtra("result").replaceAll(",","."));
						p10.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 110:

					if (data.getStringExtra("result").equals(""))
					{
						tp11.setText("");
						p11.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp11.setText(data.getStringExtra("result").replaceAll(",","."));
						p11.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 120:

					if (data.getStringExtra("result").equals(""))
					{
						tp12.setText("");
						p12.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp12.setText(data.getStringExtra("result").replaceAll(",","."));
						p12.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 130:

					if (data.getStringExtra("result").equals(""))
					{
						tp13.setText("");
						p13.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp13.setText(data.getStringExtra("result").replaceAll(",","."));
						p13.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 140:

					if (data.getStringExtra("result").equals(""))
					{
						tp14.setText("");
						p14.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp14.setText(data.getStringExtra("result").replaceAll(",","."));
						p14.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
				case 150:

					if (data.getStringExtra("result").equals(""))
					{
						tp15.setText("");
						p15.setImageDrawable(getResources().getDrawable(R.drawable.puntorojo));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					else
					{
						tp15.setText(data.getStringExtra("result").replaceAll(",","."));
						p15.setImageDrawable(getResources().getDrawable(R.drawable.puntoverde));
						if (completado ()) calcular.setVisibility(View.VISIBLE);
					}
					break;
			}
		}
	}//onActivityResult
	
	/*
	 * Cálculo del valos Em a partir de la formula de los 9 puntos.
	 */

	public void calcularEm ()
	{
		TextView editB1 = (TextView) findViewById(R.id.TextPunto1);
		TextView editB2 = (TextView) findViewById(R.id.TextPunto4);
		TextView editB3 = (TextView) findViewById(R.id.TextPunto7);
		TextView editB4 = (TextView) findViewById(R.id.TextPunto10);
		TextView editB5 = (TextView) findViewById(R.id.TextPunto13);
		TextView editC1 = (TextView) findViewById(R.id.TextPunto2);
		TextView editC2 = (TextView) findViewById(R.id.TextPunto5);
		TextView editC3 = (TextView) findViewById(R.id.TextPunto8);
		TextView editC4 = (TextView) findViewById(R.id.TextPunto11);
		TextView editC5 = (TextView) findViewById(R.id.TextPunto14);
		TextView editD1 = (TextView) findViewById(R.id.TextPunto3);
		TextView editD2 = (TextView) findViewById(R.id.TextPunto6);
		TextView editD3 = (TextView) findViewById(R.id.TextPunto9);
		TextView editD4 = (TextView) findViewById(R.id.TextPunto12);
		TextView editD5 = (TextView) findViewById(R.id.TextPunto15);
		double e1,e2,e3,e4,e5,e6,e7,e8,e9;
						
		e1= ((Double.valueOf(editB1.getText().toString()))+(Double.valueOf(editB5.getText().toString()))) / 2;
		e2= ((Double.valueOf(editC1.getText().toString()))+(Double.valueOf(editC5.getText().toString()))) / 2;
		e3= ((Double.valueOf(editD1.getText().toString()))+(Double.valueOf(editD5.getText().toString()))) / 2;
		e4= ((Double.valueOf(editB2.getText().toString()))+(Double.valueOf(editB4.getText().toString()))) / 2;
		e5= ((Double.valueOf(editC2.getText().toString()))+(Double.valueOf(editC4.getText().toString()))) / 2;
		e6= ((Double.valueOf(editD2.getText().toString()))+(Double.valueOf(editD4.getText().toString()))) / 2;
		e7= Double.valueOf(editB3.getText().toString());
		e8= Double.valueOf(editC3.getText().toString());
		e9= Double.valueOf(editD3.getText().toString());
		
		double em= (e1+(e2*2)+e3+(2*e4)+(4*e5)+(2*e6)+e7+(2*e8)+e9) / 16;


		Intent intent = new Intent();
	    intent.putExtra("em", String.valueOf(em));
	    setResult(RESULT_OK, intent);
	    finish();
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nueve_puntos, menu);
		return true;
	}
	
	
	//método para comprobar que todos los puntos esten completos.
	
	public boolean completado ()
	{
		TextView punto1 = (TextView) findViewById(R.id.TextPunto1);
		TextView punto2 = (TextView) findViewById(R.id.TextPunto2);
		TextView punto3 = (TextView) findViewById(R.id.TextPunto3);
		TextView punto4 = (TextView) findViewById(R.id.TextPunto4);
		TextView punto5 = (TextView) findViewById(R.id.TextPunto5);
		TextView punto6 = (TextView) findViewById(R.id.TextPunto6);
		TextView punto7 = (TextView) findViewById(R.id.TextPunto7);
		TextView punto8 = (TextView) findViewById(R.id.TextPunto8);
		TextView punto9 = (TextView) findViewById(R.id.TextPunto9);
		TextView punto10 = (TextView) findViewById(R.id.TextPunto10);
		TextView punto11 = (TextView) findViewById(R.id.TextPunto11);
		TextView punto12 = (TextView) findViewById(R.id.TextPunto12);
		TextView punto13 = (TextView) findViewById(R.id.TextPunto13);
		TextView punto14 = (TextView) findViewById(R.id.TextPunto14);
		TextView punto15 = (TextView) findViewById(R.id.TextPunto15);
				
		return ((!punto1.getText().toString().equals("")) && (!punto2.getText().toString().equals("")) && (!punto3.getText().toString().equals(""))
				 && (!punto4.getText().toString().equals("")) && (!punto5.getText().toString().equals("")) && (!punto6.getText().toString().equals(""))
				  && (!punto7.getText().toString().equals("")) && (!punto8.getText().toString().equals("")) && (!punto9.getText().toString().equals(""))
				   && (!punto10.getText().toString().equals("")) && (!punto11.getText().toString().equals("")) && (!punto12.getText().toString().equals(""))
				    && (!punto13.getText().toString().equals(""))  && (!punto14.getText().toString().equals("")) && (!punto15.getText().toString().equals("")));
		
	}

	public void startLuxometro(int punto)
	{
		Intent intent = new Intent(this, Luxometro.class);
		startActivityForResult(intent, punto);

	}
	
}