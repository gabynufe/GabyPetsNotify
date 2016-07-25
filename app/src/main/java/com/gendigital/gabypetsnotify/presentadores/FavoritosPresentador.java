package com.gendigital.gabypetsnotify.presentadores;

import android.content.Context;

import com.gendigital.gabypetsnotify.db_modelo.DB_Manager;
import com.gendigital.gabypetsnotify.db_modelo.PetInfo;
import com.gendigital.gabypetsnotify.db_modelo.Pet_Favoritos;
import com.gendigital.gabypetsnotify.vistas.IFavoritosActivity;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public class FavoritosPresentador implements IFavoritosPresentador {

    private IFavoritosActivity iFavoritosActivity;
    private ArrayList<PetInfo> listaPets;

    public FavoritosPresentador(IFavoritosActivity iFavoritosActivity) {
        this.iFavoritosActivity = iFavoritosActivity;
        obtenerLista();
    }

    @Override
    public void obtenerLista() {
        listaPets = Pet_Favoritos.listaFav;
        mostrarListaRV();
    }


    @Override
    public void mostrarListaRV() {
        iFavoritosActivity.inicializarAdaptadorRV(iFavoritosActivity.crearAdaptador(listaPets));
        iFavoritosActivity.generarLayoutVertical();
    }
}
