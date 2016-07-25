package com.gendigital.gabypetsnotify.presentadores;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.gendigital.gabypetsnotify.db_modelo.CuentaInstagram;
import com.gendigital.gabypetsnotify.db_modelo.PerfilInfo;
import com.gendigital.gabypetsnotify.restAPI.API_Endpoints;
import com.gendigital.gabypetsnotify.restAPI.API_adapter;
import com.gendigital.gabypetsnotify.restAPI.API_model;
import com.gendigital.gabypetsnotify.vistas.IPerfilFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gaby on 07/07/2016.
 */
public class PerfilPresentador implements IPerfilPresentador {

    private IPerfilFragment iPerfilFragment;
    private Context context;
    private ArrayList<PerfilInfo> listaPerfil;
    private static final String TAG = "CONEXION_INSTAGRAM";
    private CuentaInstagram cuentaActual;

    public PerfilPresentador(IPerfilFragment iPerfilFragment, Context context) {
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        if (CuentaInstagram.listaCuentas.size() == 0) {
            LlenaCuentas ();
            //CuentaInstagram.userPerfil = "3470121575";
            CuentaInstagram.userSelected = "3470121575";
            Log.v(TAG, "DATOS INICIALIZADOS");
        }
        if (CuentaInstagram.userPerfil != null) {
            obtenerListaInstagram();
        }
    }

    @Override
    public void LlenaCuentas () {
        cuentaActual = new CuentaInstagram("3470121575", "gaby_petfly", "Gaby Nuñez", "https://scontent.cdninstagram.com/t51.2885-19/s150x150/13557166_1637974566521422_1967247359_a.jpg");
        cuentaActual = new CuentaInstagram("3502625180", "rodaghero7102", "Rod Aghero", "https://scontent.cdninstagram.com/t51.2885-19/s150x150/13549451_1924392194454213_640488733_a.jpg");
        cuentaActual = new CuentaInstagram("1367162880", "flyn139566", "Isaac", "https://scontent.cdninstagram.com/t51.2885-19/s150x150/13534406_1048087365282770_1025401511_a.jpg");
        cuentaActual = new CuentaInstagram("3453931761", "perritinsta", "Perrito", "https://scontent.cdninstagram.com/t51.2885-19/13473368_1137847402953694_2092432719_a.jpg");
    }

    @Override
    public void obtenerListaInstagram() {
        API_adapter apiAdapter = new API_adapter();
        Gson gsonMediaRecent = apiAdapter.construyeGsonDeserializadorMediaRecent();
        API_Endpoints apiEndpoints = apiAdapter.establecerConexionApiInstagram(gsonMediaRecent);
        Log.v(TAG, "USERPERFIL:" + CuentaInstagram.userPerfil);
        Call<API_model> apiModelCall = apiEndpoints.getRecentMedia(CuentaInstagram.userPerfil);

        apiModelCall.enqueue(new Callback<API_model>() {
            @Override
            public void onResponse(Call<API_model> call, Response<API_model> response) {
                Log.v(TAG, "CONEXION API REALIZADA");
                API_model apiModel = response.body();
                listaPerfil = apiModel.getListaInstagram();
                mostrarListaRV();
            }

            @Override
            public void onFailure(Call<API_model> call, Throwable t) {
                Toast.makeText(context, "¡falló conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e(TAG, "FALLO LA CONEXION API[" + t.toString() + "]");
            }
        });
    }


    @Override
    public void mostrarListaRV() {
        iPerfilFragment.inicializarAdaptadorRV(iPerfilFragment.crearAdaptador(listaPerfil));
        iPerfilFragment.generarLayout();
    }
}
