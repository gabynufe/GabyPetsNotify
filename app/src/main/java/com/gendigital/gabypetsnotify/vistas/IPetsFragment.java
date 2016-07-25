package com.gendigital.gabypetsnotify.vistas;

import com.gendigital.gabypetsnotify.adaptadores.PetsAdapter;
import com.gendigital.gabypetsnotify.db_modelo.PetInfo;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public interface IPetsFragment {
    public void generarLayoutVertical();

    public PetsAdapter crearAdaptador(ArrayList<PetInfo> listaPets);

    public void inicializarAdaptadorRV(PetsAdapter adaptador);
}
