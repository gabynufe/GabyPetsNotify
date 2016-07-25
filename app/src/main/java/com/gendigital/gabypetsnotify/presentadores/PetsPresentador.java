package com.gendigital.gabypetsnotify.presentadores;

import android.content.Context;

import com.gendigital.gabypetsnotify.db_modelo.DB_Manager;
import com.gendigital.gabypetsnotify.db_modelo.PetInfo;
import com.gendigital.gabypetsnotify.vistas.IPetsFragment;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public class PetsPresentador implements IPetsPresentador {

    private IPetsFragment iPetsFragment;
    private Context context;
    private DB_Manager db_Manager;
    private ArrayList<PetInfo> listaPets;

    public  PetsPresentador(IPetsFragment iPetsFragment, Context context) {
        this.iPetsFragment = iPetsFragment;
        this.context = context;
        obtenerLista();
    }

    @Override
    public void obtenerLista() {
        db_Manager = new DB_Manager(context);
        listaPets = db_Manager.obtenerDatos();
        mostrarListaRV();
    }


    @Override
    public void mostrarListaRV() {
        iPetsFragment.inicializarAdaptadorRV(iPetsFragment.crearAdaptador(listaPets));
        iPetsFragment.generarLayoutVertical();
    }
}
