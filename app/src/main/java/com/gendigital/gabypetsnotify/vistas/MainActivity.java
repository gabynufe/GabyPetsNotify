package com.gendigital.gabypetsnotify.vistas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.gendigital.gabypetsnotify.API_Google.Google_Endpoint;
import com.gendigital.gabypetsnotify.API_Google.API_Google_Adapter;
import com.gendigital.gabypetsnotify.API_Google.modelo.UsuarioResponse;
import com.gendigital.gabypetsnotify.R;
import com.gendigital.gabypetsnotify.adaptadores.PagerAdaptador;
import com.gendigital.gabypetsnotify.db_modelo.CuentaInstagram;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_EXTRA_NAME = "name";
    private static final String TAG = "FIREBASE_TOKEN";
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.barraSup);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Log.e("MainActivity", "onCreate");
        setUpViewPager();


    }


    @Override
    public void onResume() {
        super.onResume();
        Fragment fragment = ((PagerAdaptador) viewPager.getAdapter()).getFragment(1);
        if (fragment != null) {
            fragment.onResume();
        }
    }

    private void setUpViewPager(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PetsFragment());
        fragments.add(new PerfilFragment());

        viewPager.setAdapter(new PagerAdaptador(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_photos);
    }

    public void verFavoritos() {
        Toast.makeText(getApplicationContext(), "Ver los 5 favoritos!",
                Toast.LENGTH_LONG).show();
        Intent ventanaFav = new Intent(this, FavoritosActivity.class);
        startActivity(ventanaFav);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFavoritos:
                verFavoritos();
                break;
            case R.id.mContacto:
                Intent ventanaContacto = new Intent(this, ContactoActivity.class);
                startActivity(ventanaContacto);
                break;
            case R.id.mAcerca:
                Intent ventanaAcerca = new Intent(this, AcercaActivity.class);
                startActivity(ventanaAcerca);
                break;
            case R.id.mPerfil:
                Intent ventanaPerfil = new Intent(this, ConfigPerfilActivity.class);
                startActivity(ventanaPerfil);
                break;
            case R.id.mNotify:
                obtieneGuardaTokenDispositivo ();
                break;
        }
        return true;
    }

    public void obtieneGuardaTokenDispositivo () {
        // obtiene token del dispositivo
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "InstanceID token: " + token);
        Log.d(TAG, "user selected: " + CuentaInstagram.userSelected);

        // guarda token del dispositivo y cuenta de instagram seleccionada en configuración
        API_Google_Adapter restApiAdapter = new API_Google_Adapter();
        Google_Endpoint endponits = restApiAdapter.establecerConexionRestAPI();
        Call<UsuarioResponse> usuarioResponseCall = endponits.registrarTokenID(token, CuentaInstagram.userSelected);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                String idRegistro = response.body().getIdRegistro();
                String idDispositivo = response.body().getIdDispositivo();
                String idUser = response.body().getIdUsuario();
                Log.d("FIREBASE_response", response.body().toString());
                Log.d("FIREBASE_idRegistro", idRegistro);
                Log.d("FIREBASE_idDispositivo", idDispositivo);
                Log.d("FIREBASE_idUsuario", idUser);
                Log.d("FIREBASE_idRegistro", usuarioResponse.getIdRegistro());
                Log.d("FIREBASE_idDispositivo", usuarioResponse.getIdDispositivo());
                Log.d("FIREBASE_idUsuario", usuarioResponse.getIdUsuario());
                Toast.makeText(getApplicationContext(), "idRegistro:" + usuarioResponse.getIdRegistro(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Log.e("FIREBASE_ERROR", "ERROR AL GUARDAR TOKEN");
                Toast.makeText(getApplicationContext(), "ERROR AL GUARDAR TOKEN [" + CuentaInstagram.userSelected,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
