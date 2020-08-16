package com.example.petagrama.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagrama.pojo.Mascota;
import com.example.petagrama.R;
import com.example.petagrama.adapter.AdaptadorFoto;

import java.util.ArrayList;

public class Frag_Perfil extends Fragment {

    RecyclerView.LayoutManager layoutManager;


    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public AdaptadorFoto adaptador;

    public Frag_Perfil() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragm_perfil,container,false);
        listaMascotas = v.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getActivity(),2);

        listaMascotas.setLayoutManager(layoutManager);

        inicializarFotosPerfilMascotas();
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador(){
        adaptador = new AdaptadorFoto(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarFotosPerfilMascotas(){

        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.mascota3,"Perro",2));
        mascotas.add(new Mascota(R.drawable.mascota3,"Perro",2));
        mascotas.add(new Mascota(R.drawable.mascota3,"Perro",2));
        mascotas.add(new Mascota(R.drawable.mascota3,"Perro",2));
        mascotas.add(new Mascota(R.drawable.mascota3,"Perro",2));
        mascotas.add(new Mascota(R.drawable.mascota3,"Perro",2));
    }

}