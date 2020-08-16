package com.example.petagrama.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagrama.pojo.Mascota;
import com.example.petagrama.R;

import java.util.ArrayList;

public class AdaptadorFoto extends RecyclerView.Adapter<AdaptadorFoto.ViewHolder>{
    public ArrayList<Mascota> mascotas;
    Activity activity;


    public AdaptadorFoto(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdaptadorFoto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foto,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorFoto.ViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.imgMascota.setImageResource(mascota.getFoto());
        holder.tvRating.setText(String.valueOf(mascota.getRating()));

    }

    @Override
    public int getItemCount() {

        return mascotas.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota;
        private TextView tvRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota1);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating1);

        }
    }
}