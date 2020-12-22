package com.petagram_.db;

import android.content.ContentValues;
import android.content.Context;

import com.petagram_.models.Mascota;

import java.util.ArrayList;

public class ConstructorBD {
    private Context context;

    public ConstructorBD(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        BaseDatos db = new BaseDatos(context);
        return  db.obtenerMasCotasFavoritas();
    }

    public void agregarMascotaFavorita(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FAVORITAS_NOMBRE, mascota.getNombreMascota());
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FAVORITAS_FOTO, mascota.getFotoMascota());
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FAVORITAS_RAITING, mascota.getValorRaiting());
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FAVORITAS_SEXO, mascota.isSexo() ? 1:0);
        db.insertarMascotaFavorita(contentValues);
    }

    public String obtenerIdNotificacion(){
        BaseDatos db = new BaseDatos(context);
        return  db.consultaIdNotificacion();
    }

    public void agregarIdNotificacion(String id){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_ID_NOTIFICACIONES_ID, id);
        db.insersarIdNotificacion(contentValues);
    }
}
