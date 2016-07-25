package com.gendigital.gabypetsnotify.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gendigital.gabypetsnotify.R;
import com.gendigital.gabypetsnotify.db_modelo.PerfilInfo;

import java.util.ArrayList;
import com.squareup.picasso.Picasso;

/**
 * Created by Gaby on 07/07/2016.
 */
public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.adaViewHolder> {

    private Activity activity;
    private ArrayList<PerfilInfo> perfilDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public PerfilAdapter(ArrayList<PerfilInfo> myDataset, Activity activity) {
            this.perfilDataset = myDataset;
            this.activity = activity;
    }

    public static class adaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvMeGusta;

        public adaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvMeGusta = (TextView) itemView.findViewById(R.id.tvMeGusta);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PerfilAdapter.adaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View vw = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        adaViewHolder vh = new adaViewHolder(vw);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final adaViewHolder vHolder, int position) {
        // - get element from your dataset at this position

        final PerfilInfo perfilInfo = perfilDataset.get(position);
        Picasso.with(activity)
                .load(perfilInfo.getUrlFoto())
                .placeholder(R.drawable.loro)
                .into(vHolder.imgFoto);
        //vHolder.imgFoto.setImageResource(perfilInfo.getFoto());
        vHolder.tvMeGusta.setText(Integer.toString(perfilInfo.getMeGusta()));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return perfilDataset.size();
    }
}
