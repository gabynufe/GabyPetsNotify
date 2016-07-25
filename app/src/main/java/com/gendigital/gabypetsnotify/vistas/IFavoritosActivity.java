package com.gendigital.gabypetsnotify.vistas;

import com.gendigital.gabypetsnotify.adaptadores.FavoritosAdapter;
import com.gendigital.gabypetsnotify.db_modelo.PetInfo;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public interface IFavoritosActivity {
    public void generarLayoutVertical();

    public FavoritosAdapter crearAdaptador(ArrayList<PetInfo> listaPets);

    public void inicializarAdaptadorRV(FavoritosAdapter adaptador);
}
