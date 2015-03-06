package com.example.secretara_santuario.telefonodelpadre;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by Alvaro on 05/03/2015.
 */
public class alarmChecker extends Service implements Runnable{

    public static final int APP_ID_NOTIFICATION = 0;
    private NotificationManager mManager;

    private final int MSG_KEY_ES_IMPAR = 1;
    private final int MSG_KEY_ES_PAR = 2;

    public static Calendar cal;


    @Override
    public void run() {
        long a=cal.getTimeInMillis();
        long b=System.currentTimeMillis();
        Log.e("entro acquisition","aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        if (a==b)
        {
            //Respondemos que es impar
            handler.sendEmptyMessage(MSG_KEY_ES_IMPAR);
        }else
        {
            //Respondemos que es par
            handler.sendEmptyMessage(MSG_KEY_ES_PAR);
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_KEY_ES_PAR: //Hemos obtenido un numero par
                    Notificar();
                    break;
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void Notificar(){
        //Prepara la actividad que se abrira cuando el usuario pulse la notificacion
        Intent intentNot = new Intent(this, LlamadaActivity.class);

        //Prepara la notificacion
        Notification notification = new Notification(R.drawable.padre, "Hay cambios", System.currentTimeMillis());
        notification.setLatestEventInfo(this, getString(R.string.app_name), "que?", //getString(R.string.notified)
                PendingIntent.getActivity(this.getBaseContext(), 0, intentNot, PendingIntent.FLAG_CANCEL_CURRENT));

        //Le añade sonido
        notification.defaults |= Notification.DEFAULT_SOUND;
        //Le añade vibración
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        //La notificación se detendrá cuando el usuario pulse en ella
        notification.flags = Notification.FLAG_AUTO_CANCEL;

        //Lanza la notificación
        mManager.notify(APP_ID_NOTIFICATION, notification);

    }

    public static void darCalendario(Calendar calendar) {
        cal=calendar;
    }
}
