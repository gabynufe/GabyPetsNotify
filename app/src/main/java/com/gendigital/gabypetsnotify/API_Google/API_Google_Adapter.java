package com.gendigital.gabypetsnotify.API_Google;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gaby on 24/07/2016.
 */
public class API_Google_Adapter {
    public Google_Endpoint establecerConexionRestAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_Google_Config.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;

        //Log.d("FIREBASE_GOOGLE_ADAPTER", "ESTABLECIENDO CONEXION");
        return retrofit.create(Google_Endpoint.class);
    }
}
