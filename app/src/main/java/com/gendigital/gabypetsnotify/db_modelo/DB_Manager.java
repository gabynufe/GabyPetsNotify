package com.gendigital.gabypetsnotify.db_modelo;

import android.content.ContentValues;
import android.content.Context;

import com.gendigital.gabypetsnotify.R;
import com.gendigital.gabypetsnotify.db.DB_Conexion;
import com.gendigital.gabypetsnotify.db.DB_Config;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public class DB_Manager {

    private static final int LIKE = 1;
    private Context context;
    public DB_Manager(Context context) {
        this.context = context;
    }

    public ArrayList<PetInfo> obtenerDatos() {
        DB_Conexion db = new DB_Conexion(context);
        if (db.estaVacio()) cargarDatos(db);
        return  db.leerTodo();
    }

    public void cargarDatos(DB_Conexion db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Lory");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.loro);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 13);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Fisher");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.pez);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 18);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Torty");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.tortuga);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 2);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Perry");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.perro);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 5);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Katy");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.gato);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 2);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Snaky");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.serpiente);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 0);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Ardy");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.petardy);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 0);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Cas");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.petcas);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 0);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Dalmy");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.petdalmy);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 0);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Draggy");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.petdragy);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 0);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Horsy");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.pethorsy);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 0);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Orugy");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.petorugy);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 0);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Pandy");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.petpandy);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 0);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "Tigris");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.pettigris);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 0);
        db.insertarPetInfo(contentValues);
    }

    public void actualizarMascota(PetInfo petInfo){
        DB_Conexion db = new DB_Conexion(context);
        db.updateLikes(petInfo.getId(), petInfo.getLikes());
    }
}
