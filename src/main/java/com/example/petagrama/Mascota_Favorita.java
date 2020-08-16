package com.example.petagrama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.petagrama.adapter.Favoritas_Mascotas_Adaptador;
import com.example.petagrama.db.mascota_constructor;
import com.example.petagrama.pojo.Mascota;

import java.util.ArrayList;

public class Mascota_Favorita extends AppCompatActivity {


    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    public Favoritas_Mascotas_Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_favoritas);

        Toolbar miActionBarFavoritos = (Toolbar) findViewById(R.id.miActionBarFavoritos);

        setSupportActionBar(miActionBarFavoritos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        obtenerRankingMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        adaptador = new Favoritas_Mascotas_Adaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);
    }

    public void obtenerRankingMascotas() {
        mascota_constructor constructorMascotas = new mascota_constructor(this);
        mascotas = constructorMascotas.obtenerRankingMacotas();
    }

}