package com.petagram_.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.petagram_.activities.MainActivity;

import static android.app.PendingIntent.getActivity;

public class AccionesWear extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("VER_PERFIL")){
            Toast.makeText(context, "Estas en el Perfil", Toast.LENGTH_LONG).show();
            MainActivity.seleccionarPerfil(1);
        }else if(intent.getAction().equals("IR_MASCOTAS")){
            Toast.makeText(context, "Estas en Mascotas", Toast.LENGTH_LONG).show();
            MainActivity.seleccionarPerfil(0);
        }
    }
}
