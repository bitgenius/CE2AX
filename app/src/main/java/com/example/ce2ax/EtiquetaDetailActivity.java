package com.example.ce2ax;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * An activity representing a single Etiqueta detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link EtiquetaListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link EtiquetaDetailFragment}.
 */
public class EtiquetaDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etiqueta_detail);

        // Show the Up button in the action bar.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(EtiquetaDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(EtiquetaDetailFragment.ARG_ITEM_ID));
            EtiquetaDetailFragment fragment = new EtiquetaDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.etiqueta_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, EtiquetaListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void borrar (View view)
    {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Alerta");
        alert.setMessage("¿Está seguro que desea borrar esta etiqueta?");

// Set an EditText view to get user input
        //final EditText input = new EditText(this);
        //alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //String value = input.getText().toString();

                startBorrar();
            }
        });

        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();









    }

    private void startBorrar() {
        ArrayList etiquetas = new ArrayList();

        Etiqueta mItem = EtiquetaContent.ITEM_MAP.get(getIntent().getStringExtra(EtiquetaDetailFragment.ARG_ITEM_ID));


        File dir = new File(Environment.getExternalStorageDirectory(),"ce2ax");

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

        File fichero = new File(dir,"etiquetas.dat");

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero));



            while (true)
            {
                Etiqueta aux = (Etiqueta) ois.readObject();
                if (!(aux.getCalle().equals(mItem.getCalle()))) etiquetas.add(aux);
            }





        } catch (IOException e) {
            try {
                ois.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally
        {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        reguardarFichero(etiquetas);


        this.finish();
    }

    private void reguardarFichero(ArrayList etiquetas)
    {

        File fichero = new File(crearDirectorio("ce2ax"),"etiquetas.dat");


        fichero.delete();

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero, true));
            for (int i=0;i<etiquetas.size();i++)
            {
                oos.writeObject((Etiqueta) etiquetas.get(i));
            }
            oos.close();


        } catch (IOException e1) {
            e1.printStackTrace();
        }


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

}
