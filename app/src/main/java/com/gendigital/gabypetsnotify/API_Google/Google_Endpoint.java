package com.gendigital.gabypetsnotify.API_Google;

import com.gendigital.gabypetsnotify.API_Google.modelo.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Gaby on 24/07/2016.
 */
public interface Google_Endpoint {

    @FormUrlEncoded
    @POST(API_Google_Config.KEY_POST_ID_TOKEN)
   // Call<UsuarioResponse> registrarTokenID(@Field("token") String token);
    Call<UsuarioResponse> registrarTokenID(@Field("id_dispositivo") String id_dispositivo, @Field("id_usuario_instagram") String id_usuario_instagram);
/*
    Call<UsuarioResponse> registrarTokenID(@Field("token") String token, @Field("animal") String animal);
    @GET(RestAPI_Config.KEY_TOQUE_ANIMAL)
    Call<UsuarioResponse> toqueAnimal(@Path("id") String id, @Path("animal") String animal);
    */
}
