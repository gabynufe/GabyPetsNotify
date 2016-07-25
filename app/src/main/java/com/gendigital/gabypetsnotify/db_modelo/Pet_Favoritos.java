package com.gendigital.gabypetsnotify.db_modelo;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public class Pet_Favoritos {
    public static ArrayList<PetInfo> listaFav = new ArrayList<PetInfo>();

    public static boolean esFavorito(PetInfo newObjeto) {
        boolean swEntra = false;
        boolean swYaEsta = false;
        if (listaFav.size() >= 5) {
            int posMenor = 0;
            int likesMenor = 9999;
            int likesObj = newObjeto.getLikes();
            int likesAct = 0;
            // verifica si entra a la lista
            for (int i = 0; i < listaFav.size(); i++) {
                likesAct = listaFav.get(i).getLikes();
                if (newObjeto.getId() == listaFav.get(i).getId()) swYaEsta = true;
                if (likesAct < likesObj &&  likesAct < likesMenor) {
                    swEntra = true;
                    likesMenor = likesAct;
                    posMenor = i;
                }
            }
            if (!swYaEsta && swEntra) listaFav.set(posMenor, newObjeto );

        } else {
            listaFav.add(newObjeto);
        }
        return swEntra;
    }

    public static void addItem(PetInfo newObjeto) {
        listaFav.add(newObjeto);
    }

    public static PetInfo getItem(int indice) {
        return (PetInfo) listaFav.get(indice);
    }
}
