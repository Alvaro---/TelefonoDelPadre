package com.example.secretara_santuario.telefonodelpadre;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Alvaro on 04/03/2015.
 */
public class ProgramarActivity extends Activity {

    RadioGroup radioGroupDias, radioGroupSonido;
    RadioButton radioTodos, radioDias, radioSilencio, radioSonido;

    CheckBox boxLunes, boxMartes, boxMiercoles, boxJueves, boxViernes, boxSabado, boxDomingo;
    RelativeLayout lay;

    Button btnAceptar, btnCancelar;

    //Si es 0 sera silencio, 1 sonido
    int sonido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programar);

        cargarElementos();

        radioGroupDias.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.radioTodos){
                    lay.setVisibility(View.INVISIBLE);
                } else {
                    lay.setVisibility(View.VISIBLE);
                }
            }
        });

        radioGroupSonido.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.radioSonido)
                    sonido=1;
                else sonido=0;
            }
        });


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearNotificaciones();
            }

        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //cargar todos lo elementos de la interfaz
    private void cargarElementos() {
        lay=(RelativeLayout)findViewById(R.id.relativeCheck);

        radioGroupDias=(RadioGroup)findViewById(R.id.radioGroupDias);
        radioGroupSonido=(RadioGroup)findViewById(R.id.radioGroupSonido);

        radioTodos=(RadioButton)findViewById(R.id.radioTodos);
        radioDias=(RadioButton)findViewById(R.id.radioSemana);
        radioSonido=(RadioButton)findViewById(R.id.radioSonido);
        radioSilencio=(RadioButton)findViewById(R.id.radioSilencio);

        btnAceptar=(Button)findViewById(R.id.btnAceptar);
        btnCancelar=(Button)findViewById(R.id.btnCancelar);
    }

    private void crearNotificaciones() {

        Notification.Builder notificacion=new Notification.Builder(ProgramarActivity.this);
        notificacion.setSmallIcon(R.drawable.ic_launcher);
        notificacion.setTicker("Llamada Perdida");
        notificacion.setWhen(System.currentTimeMillis());
        notificacion.setContentTitle("Pare Kentenich");
        notificacion.setContentText("Desea devolver la llamada?");
        notificacion.setContentInfo("Desde el Snatuario");

        //Sonido
        if (sonido==1) {
            Uri sonido = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
            notificacion.setSound(sonido);
        }

        //Imagen
        Bitmap icono= BitmapFactory.decodeResource(getResources(),R.drawable.padre);
        notificacion.setLargeIcon(icono);

        //Accion de la notificacion
        PendingIntent pending;
        Intent intent=new Intent();
        Context con=getApplicationContext(); // tambien podria llamarse en el intent, con ProgarmarActivity.getContext, o con getAplicationContext
        intent.setClass(con, LlamadaActivity.class);
        intent.putExtra("ID",1);
        pending=PendingIntent.getActivity(con,0,intent,0);
        notificacion.setContentIntent(pending);

        Notification n=notificacion.getNotification(); // Esta opcion sirve para construit por el motodo antiguo, para api anterio a 16. Se puede cambiar por .build()
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1,n);
    }

}
