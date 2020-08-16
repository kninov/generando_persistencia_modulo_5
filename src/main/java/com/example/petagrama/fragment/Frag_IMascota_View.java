package com.example.petagrama.fragment;

import com.example.petagrama.adapter.Adaptador_Mascota;
import com.example.petagrama.pojo.Mascota;

import java.util.ArrayList;

public interface Frag_IMascota_View {
    public void generarLinearLayoutVertical();
    public Adaptador_Mascota crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(Adaptador_Mascota adaptador);
}