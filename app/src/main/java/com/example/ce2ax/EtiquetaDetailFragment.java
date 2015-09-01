package com.example.ce2ax;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A fragment representing a single Etiqueta detail screen.
 * This fragment is either contained in a {@link EtiquetaListActivity}
 * in two-pane mode (on tablets) or a {@link EtiquetaDetailActivity}
 * on handsets.
 */
public class EtiquetaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Etiqueta mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EtiquetaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = EtiquetaContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_etiqueta_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            //((TextView) rootView.findViewById(R.id.etiqueta_detail)).setText(mItem.getCalle());
            ((TextView) rootView.findViewById(R.id.textView22)).setText(mItem.getTipo());
            ((TextView) rootView.findViewById(R.id.textView24)).setText(mItem.getCalle());
            ((TextView) rootView.findViewById(R.id.textView32)).setText(truncarDecimales(mItem.getIe()));
            ((TextView) rootView.findViewById(R.id.textView34)).setText(truncarDecimales (mItem.getEm()));
            ((TextView) rootView.findViewById(R.id.textView43)).setText(mItem.getCalle());
            ((TextView) rootView.findViewById(R.id.textView45)).setText(mItem.getTipo());
            ((TextView) rootView.findViewById(R.id.textView47)).setText(truncarDecimales(mItem.getPotencia()));
            ((TextView) rootView.findViewById(R.id.textView49)).setText(truncarDecimales(mItem.getSuperficie()));
            ((TextView) rootView.findViewById(R.id.textView51)).setText(truncarDecimales(mItem.getEm()));
            ((TextView) rootView.findViewById(R.id.textView53)).setText(truncarDecimales(mItem.getE()));
            ((TextView) rootView.findViewById(R.id.textView55)).setText(truncarDecimales(mItem.getEr()));
            ((TextView) rootView.findViewById(R.id.textView61)).setText(truncarDecimales(mItem.getEmin()));
            ((TextView) rootView.findViewById(R.id.textView57)).setText(truncarDecimales(mItem.getIe()));
            ((TextView) rootView.findViewById(R.id.textView59)).setText(truncarDecimales(mItem.getIce()));
            ((TextView) rootView.findViewById(R.id.textView40)).setText(mItem.getObservaciones());
            if (Double.valueOf(mItem.getE())<Double.valueOf(mItem.getEmin())) ((TextView) rootView.findViewById(R.id.textView62)).setVisibility(View.VISIBLE);

            if (mItem.getCalificacion().equals("A")) { ImageView flecha = (ImageView) rootView.findViewById(R.id.imageView); flecha.setVisibility(View.VISIBLE);}
            if (mItem.getCalificacion().equals("B")) { ImageView flecha = (ImageView) rootView.findViewById(R.id.imageView2); flecha.setVisibility(View.VISIBLE);}
            if (mItem.getCalificacion().equals("C")) { ImageView flecha = (ImageView) rootView.findViewById(R.id.imageView3); flecha.setVisibility(View.VISIBLE);}
            if (mItem.getCalificacion().equals("D")) { ImageView flecha = (ImageView) rootView.findViewById(R.id.imageView4); flecha.setVisibility(View.VISIBLE);}
            if (mItem.getCalificacion().equals("E")) { ImageView flecha = (ImageView) rootView.findViewById(R.id.imageView5); flecha.setVisibility(View.VISIBLE);}
            if (mItem.getCalificacion().equals("F")) { ImageView flecha = (ImageView) rootView.findViewById(R.id.imageView6); flecha.setVisibility(View.VISIBLE);}
            if (mItem.getCalificacion().equals("G")) { ImageView flecha = (ImageView) rootView.findViewById(R.id.imageView7); flecha.setVisibility(View.VISIBLE);}
        }

        return rootView;
    }


    public String truncarDecimales (String cifra)
    {
        Double aux = Double.valueOf(cifra);
        DecimalFormat df = new DecimalFormat("#.##");
        return String.valueOf(df.format(aux));
    }


}
