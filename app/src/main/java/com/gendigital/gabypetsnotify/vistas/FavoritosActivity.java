package com.gendigital.gabypetsnotify.vistas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.gendigital.gabypetsnotify.R;
import com.gendigital.gabypetsnotify.adaptadores.FavoritosAdapter;
import com.gendigital.gabypetsnotify.db_modelo.PetInfo;
import com.gendigital.gabypetsnotify.presentadores.FavoritosPresentador;
import com.gendigital.gabypetsnotify.presentadores.IFavoritosPresentador;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public class FavoritosActivity extends AppCompatActivity implements IFavoritosActivity {
    private RecyclerView rvListaFavoritos;
    private IFavoritosPresentador iPresentador;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar actionBar = (Toolbar) findViewById(R.id.barraSup);
        setSupportActionBar(actionBar);

        actionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FavoritosActivity.this, "Regresando", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        activity = this;


        rvListaFavoritos = (RecyclerView) this.findViewById(R.id.rvListaFavoritos);
        iPresentador = new FavoritosPresentador(this);
    }


    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(activity);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaFavoritos.setLayoutManager(llm);

    }

    @Override
    public FavoritosAdapter crearAdaptador(ArrayList<PetInfo> listaPets) {
        FavoritosAdapter adaptador = new FavoritosAdapter(listaPets, activity);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(FavoritosAdapter adaptador) {
        rvListaFavoritos.setAdapter(adaptador);
    }
}
