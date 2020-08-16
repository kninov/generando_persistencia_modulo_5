package com.example.petagrama.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagrama.MainActivity;
import com.example.petagrama.pojo.Mascota;

import java.util.ArrayList;

// este es el interactor el intermediario ue consulta la fuente de datos
public class mascota_constructor extends MainActivity {

    private static final int LIKE = 1;
    private Context context;

    public mascota_constructor(Context context) {
        this.context = context;
    }
    public ArrayList<Mascota> obtenerDatos(){
        base_datos db = new base_datos(context);
        return db.obtenerTodasMascotas();
    }

    public void darLikeMascota(Mascota mascota){
        base_datos db = new base_datos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(base_datos_constante.TABLE_LIKE_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(base_datos_constante.TABLE_LIKE_MASCOTA_NO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        base_datos db = new base_datos(context);
        return db.obtenerLikesMascota(mascota);
    }

    public void eliminarTablasDB(){
        base_datos db = new base_datos(context);
        db.eliminarTablasDB();
    }

    public ArrayList<Mascota> obtenerRankingMacotas(){

        base_datos db = new base_datos(context);
        return db.obtenerRankingMascotas();
    }


}