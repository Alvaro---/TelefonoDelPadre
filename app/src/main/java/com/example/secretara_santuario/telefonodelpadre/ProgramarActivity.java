package com.example.secretara_santuario.telefonodelpadre;

import android.app.Activity;
import android.app.AlarmManager;
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
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Alvaro on 04/03/2015.
 */
public class ProgramarActivity extends Activity {

    RadioGroup radioGroupDias, radioGroupSonido;
    RadioButton radioTodos, radioDias, radioSilencio, radioSonido;

    CheckBox boxLunes, boxMartes, boxMiercoles, boxJueves, boxViernes, boxSabado, boxDomingo;
    RelativeLayout lay;

    Button btnAceptar, btnCancelar, btnBorrar;

    Calendar cal;
    TimePicker timePicker;

    //Si es 0 sera silencio, 1 sonido
    static int sonido;

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
                startAlert();
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
        timePicker=(TimePicker)findViewById(R.id.timePicker);

        radioGroupDias=(RadioGroup)findViewById(R.id.radioGroupDias);
        radioGroupSonido=(RadioGroup)findViewById(R.id.radioGroupSonido);

        radioTodos=(RadioButton)findViewById(R.id.radioTodos);
        radioDias=(RadioButton)findViewById(R.id.radioSemana);
        radioSonido=(RadioButton)findViewById(R.id.radioSonido);
        radioSilencio=(RadioButton)findViewById(R.id.radioSilencio);

        btnAceptar=(Button)findViewById(R.id.btnAceptar);
        btnCancelar=(Button)findViewById(R.id.btnCancelar);
        btnBorrar=(Button)findViewById(R.id.btnQuitar);
    }

    public void startAlert(){
        cal=Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set (Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
        cal.set (Calendar.MINUTE, timePicker.getCurrentMinute());
        //cal.set (Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        //cal.set(Calendar.DAY_OF_WEEK,4);
        cal.set (Calendar.SECOND, 0);

        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
        Toast.makeText(this, "Alarma iniciada", Toast.LENGTH_LONG).show();
    }

}
