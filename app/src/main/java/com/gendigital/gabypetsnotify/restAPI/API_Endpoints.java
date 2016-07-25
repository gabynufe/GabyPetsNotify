package com.gendigital.gabypetsnotify.restAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Gaby on 09/07/2016.
 */
public interface API_Endpoints {
    @GET(API_Config.URL_GET_RECENT_MEDIA_USER)
    Call<API_model> getRecentMedia(@Path("user") String user);
}
