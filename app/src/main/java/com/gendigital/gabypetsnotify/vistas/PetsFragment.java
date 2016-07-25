package com.gendigital.gabypetsnotify.vistas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gendigital.gabypetsnotify.R;
import com.gendigital.gabypetsnotify.adaptadores.PetsAdapter;
import com.gendigital.gabypetsnotify.db_modelo.PetInfo;
import com.gendigital.gabypetsnotify.presentadores.IPetsPresentador;
import com.gendigital.gabypetsnotify.presentadores.PetsPresentador;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public class PetsFragment extends Fragment implements IPetsFragment {
    private RecyclerView rvListaPets;
    private IPetsPresentador iPresentador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pets, container, false);
        //v.setTag(TAG);

        rvListaPets = (RecyclerView) v.findViewById(R.id.rvListaPets);
        iPresentador = new PetsPresentador(this, getContext());
        return v;
    }

    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaPets.setLayoutManager(llm);

    }

    @Override
    public PetsAdapter crearAdaptador(ArrayList<PetInfo> listaPets) {
        PetsAdapter adaptador = new PetsAdapter(listaPets, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(PetsAdapter adaptador) {
        rvListaPets.setAdapter(adaptador);
    }
}
