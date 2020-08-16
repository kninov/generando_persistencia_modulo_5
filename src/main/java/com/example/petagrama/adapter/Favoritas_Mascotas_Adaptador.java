package com.example.petagrama.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagrama.R;
import com.example.petagrama.pojo.Mascota;

import java.util.ArrayList;

public class Favoritas_Mascotas_Adaptador extends RecyclerView.Adapter<Favoritas_Mascotas_Adaptador.ViewHolder>{


    ArrayList<Mascota> mascotas;
    Activity activity;

    public Favoritas_Mascotas_Adaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    @NonNull
    @Override
    public Favoritas_Mascotas_Adaptador.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        Favoritas_Mascotas_Adaptador.ViewHolder viewHolder=new Favoritas_Mascotas_Adaptador.ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final Favoritas_Mascotas_Adaptador.ViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.tvNombreMascota.setText(mascota.getNombre());
        holder.imgMascota.setImageResource(mascota.getFoto());

        holder.tvRating.setText(String.valueOf(mascota.getRating()));

        holder.btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Te gustó jaja no mas " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota;
        private TextView tvNombreMascota;
        private TextView tvRating;
        private ImageButton btnRating;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            btnRating  = (ImageButton) itemView.findViewById(R.id.btnRating);

        }

    }
}