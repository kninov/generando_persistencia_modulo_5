package com.example.petagrama.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.petagrama.R;
import com.example.petagrama.pojo.Mascota;

import java.util.ArrayList;

public class base_datos extends SQLiteOpenHelper {

    private Context context;

    public base_datos(Context context) {
        super(context, base_datos_constante.DATA_BASE_NAME, null, base_datos_constante.DATABASE_VESION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + base_datos_constante.TABLE_MASCOTA + " (" +
                base_datos_constante.TABLE_MASCOTA_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                base_datos_constante.TABLE_MASCOTA_NOMBRE   + " TEXT, " +
                base_datos_constante.TABLE_MASCOTA_FOTO     + " INTEGER" +
                ")";

        String queryCrearTablaLikeMascota = "CREATE TABLE " + base_datos_constante.TABLE_LIKE_MASCOTA + " (" +
                base_datos_constante.TABLE_LIKE_MASCOTA_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                base_datos_constante.TABLE_LIKE_MASCOTA_ID_MASCOTA + " INTEGER, " +
                base_datos_constante.TABLE_LIKE_MASCOTA_NO_LIKES    + " INTEGER, " +
                "FOREIGN KEY (" + base_datos_constante.TABLE_LIKE_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + base_datos_constante.TABLE_MASCOTA + " (" + base_datos_constante.TABLE_MASCOTA_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikeMascota);
        iniPuppies(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + base_datos_constante.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + base_datos_constante.TABLE_LIKE_MASCOTA);
        onCreate(db);
    }
    public void iniPuppies(SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(base_datos_constante.TABLE_MASCOTA_NOMBRE, "mascota4");
        contentValues.put(base_datos_constante.TABLE_MASCOTA_FOTO, R.drawable.mascota4);
        db.insert(base_datos_constante.TABLE_MASCOTA, null, contentValues);;

        contentValues = new ContentValues();
        contentValues.put(base_datos_constante.TABLE_MASCOTA_NOMBRE, "mascota3");
        contentValues.put(base_datos_constante.TABLE_MASCOTA_FOTO, R.drawable.mascota3);
        db.insert(base_datos_constante.TABLE_MASCOTA, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(base_datos_constante.TABLE_MASCOTA_NOMBRE, "mascota8");
        contentValues.put(base_datos_constante.TABLE_MASCOTA_FOTO, R.drawable.mascota8);
        db.insert(base_datos_constante.TABLE_MASCOTA, null, contentValues);;

        contentValues = new ContentValues();
        contentValues.put(base_datos_constante.TABLE_MASCOTA_NOMBRE, "mascota4");
        contentValues.put(base_datos_constante.TABLE_MASCOTA_FOTO, R.drawable.mascota4);
        db.insert(base_datos_constante.TABLE_MASCOTA, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(base_datos_constante.TABLE_MASCOTA_NOMBRE, "mascota5");
        contentValues.put(base_datos_constante.TABLE_MASCOTA_FOTO, R.drawable.mascota5);
        db.insert(base_datos_constante.TABLE_MASCOTA, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(base_datos_constante.TABLE_MASCOTA_NOMBRE, "mascota6");
        contentValues.put(base_datos_constante.TABLE_MASCOTA_FOTO, R.drawable.mascota6);
        db.insert(base_datos_constante.TABLE_MASCOTA, null, contentValues);

    }








    public ArrayList<Mascota> obtenerTodasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + base_datos_constante.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + base_datos_constante.TABLE_LIKE_MASCOTA_NO_LIKES + ") as likes" +
                    " FROM " + base_datos_constante.TABLE_LIKE_MASCOTA +
                    " WHERE " + base_datos_constante.TABLE_LIKE_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setRating(registrosLikes.getInt(0));
            }else{
                mascotaActual.setRating(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(base_datos_constante.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(base_datos_constante.TABLE_LIKE_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT(" + base_datos_constante.TABLE_LIKE_MASCOTA_NO_LIKES + ")" +
                " FROM " + base_datos_constante.TABLE_LIKE_MASCOTA +
                " WHERE " + base_datos_constante.TABLE_LIKE_MASCOTA_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

    public void eliminarTablasDB(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(base_datos_constante.TABLE_LIKE_MASCOTA,null,null);
        db.delete(base_datos_constante.TABLE_MASCOTA,null,null);
    }

    public ArrayList<Mascota> obtenerRankingMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "select m."+ base_datos_constante.TABLE_MASCOTA_ID +
                ", m."+ base_datos_constante.TABLE_MASCOTA_NOMBRE +
                ", m."+ base_datos_constante.TABLE_MASCOTA_FOTO +
                ", t1.cant " +
                "from "+ base_datos_constante.TABLE_MASCOTA +" m" +
                ", (select "+ base_datos_constante.TABLE_LIKE_MASCOTA_ID_MASCOTA + ", count("+ base_datos_constante.TABLE_LIKE_MASCOTA_NO_LIKES +") as cant from "+ base_datos_constante.TABLE_LIKE_MASCOTA +" group by "+ base_datos_constante.TABLE_LIKE_MASCOTA_ID_MASCOTA +" order by 2 desc) t1 " +
                "where m."+ base_datos_constante.TABLE_MASCOTA_ID +" = t1."+ base_datos_constante.TABLE_LIKE_MASCOTA_ID_MASCOTA + " limit 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setRating(registros.getInt(3));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }
}