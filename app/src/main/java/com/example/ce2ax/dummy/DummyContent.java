package com.example.ce2ax.dummy;

import android.os.Environment;

import com.example.ce2ax.Etiqueta;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<Etiqueta> ITEMS = new ArrayList<Etiqueta>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, Etiqueta> ITEM_MAP = new HashMap<String, Etiqueta>();

    static {
        // Add 3 sample items.

        //addItem(new DummyItem("1", "Item 1"));
        //addItem(new DummyItem("2", "Item 2"));
        //addItem(new DummyItem("3", "Item 3"));

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
                System.out.println ("entro");
                Etiqueta aux = (Etiqueta) ois.readObject();
                System.out.println (aux.toString());
                addItem(aux);
            }





        } catch (IOException e) {
            System.out.println (e);

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


    }


    private static void addItem(Etiqueta item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getCalle(), item);
    }

    /**
     * A dummy item representing a piece of content.
     */

}
