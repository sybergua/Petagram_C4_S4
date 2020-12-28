package com.petagram_.services;

//import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.petagram_.R;
import com.petagram_.activities.MainActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

public class NotificationService extends FirebaseMessagingService {
    public static final String TAG = "FIREBASE";
    private static final int NOTIFICATION_ID = 001;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

        //Intent i = new Intent(this, MainActivity.class);
        Intent i = new Intent();
        i.setAction("VER_PERFIL");

        Intent i2 = new Intent();
        i2.setAction("IR_MASCOTAS");

        //PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Action action = new NotificationCompat
                .Action.Builder(R.drawable.ic_perfil, getString(R.string.texto_perfil), pendingIntent)
                .build();

        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this, 0, i2, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Action action2 = new NotificationCompat
                .Action.Builder(R.drawable.ic_mascotas, getString(R.string.texto_mascotas), pendingIntent2)
                .build();

        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();
        ArrayList<NotificationCompat.Action> acciones = new ArrayList<>();
        acciones.add(action);
        acciones.add(action2);

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this,"Chanel_1")
                .setSmallIcon(R.drawable.icons8_huella_de_gato_48)
                .setContentTitle("Notificacion App")
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .extend(wearableExtender.addActions(acciones));

        /*NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificacion.build());*/
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID,notificacion.build());
    }

}

