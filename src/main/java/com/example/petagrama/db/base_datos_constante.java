package com.example.petagrama.db;

import java.security.PublicKey;

public class base_datos_constante {

    public static final String DATA_BASE_NAME = "mascotas";
    public static final int DATABASE_VESION = 1;

    //Tabla Mascota
    public static final String TABLE_MASCOTA = "mascota";
    public static final String TABLE_MASCOTA_ID = "id";
    public static final String TABLE_MASCOTA_NOMBRE = "nombre";
    public static final String TABLE_MASCOTA_FOTO = "foto";

    //Tabla Mascota Likes
    public static final String TABLE_LIKE_MASCOTA = "mascota_like";
    public static final String TABLE_LIKE_MASCOTA_ID = "id";
    public static final String TABLE_LIKE_MASCOTA_ID_MASCOTA = "mascota";
    public static final String TABLE_LIKE_MASCOTA_NO_LIKES = "numero_likes";
}