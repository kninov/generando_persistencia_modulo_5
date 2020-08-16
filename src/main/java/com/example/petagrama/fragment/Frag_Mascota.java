package com.example.petagrama.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagrama.pojo.Mascota;
import com.example.petagrama.adapter.Adaptador_Mascota;
import com.example.petagrama.R;
import com.example.petagrama.presentar.Presentar_frag_IMascota;
import com.example.petagrama.presentar.Presentar_Mascota_Frag;

import java.util.ArrayList;

public class Frag_Mascota extends Fragment implements Frag_IMascota_View {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private Presentar_frag_IMascota presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragm_reciclerview,container,false);
        rvMascotas=(RecyclerView)v.findViewById(R.id.recyclerMascota);
        presenter = new Presentar_Mascota_Frag( this , getContext());
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public Adaptador_Mascota crearAdaptador(ArrayList<Mascota> mascotas) {
        Adaptador_Mascota adaptador = new Adaptador_Mascota(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(Adaptador_Mascota adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
