package com.example.petagrama.presentar;

import android.content.Context;

import com.example.petagrama.db.mascota_constructor;

import com.example.petagrama.fragment.Frag_IMascota_View;

import com.example.petagrama.pojo.Mascota;

import java.util.ArrayList;

public class Presentar_Mascota_Frag implements Presentar_frag_IMascota {


    private Frag_IMascota_View iMascotasFragmentView;
    private Context context;
    private mascota_constructor constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public Presentar_Mascota_Frag(Frag_IMascota_View iMascotasFragmentView , Context context){
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new mascota_constructor(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotasFragmentView.inicializarAdaptadorRV(iMascotasFragmentView.crearAdaptador(mascotas));
        iMascotasFragmentView.generarLinearLayoutVertical();
    }

    @Override
    public void eliminarDatos() {
        constructorMascotas.eliminarTablasDB();
    }
}