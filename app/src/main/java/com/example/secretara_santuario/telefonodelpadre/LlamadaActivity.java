package com.example.secretara_santuario.telefonodelpadre;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

import Coneccion.Conexion;
import clases.Capital;
import clases.FraseLlamada;

public class LlamadaActivity extends Activity implements TextToSpeech.OnInitListener{

    Button rellamada;
    FraseLlamada fra;
    ImageView imgPadre;
    TextView texto;

    public static Context contextLlamada;

    private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE=0;

    //Fecha para el capital de gracias
    Calendar c = Calendar.getInstance();
    String fecha;

    String frase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada);

        //Creacion Context
        contextLlamada=getApplicationContext();
        actualizarLlamada();

        //boton nueva llamada. Creacion y accion
        rellamada=(Button)findViewById(R.id.btnPreguntarDeeNuevo);
        rellamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarLlamada();
            }
        });

        //creacion de fecha
        fecha=c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR);

        imgPadre=(ImageView)findViewById(R.id.imgPadre);
        imgPadre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducir();
            }
        });

        Intent checkTTSIntent=new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
    }


    public void actualizarLlamada(){
        fra=new FraseLlamada(null);
        frase=fra.getFraseNueva();

        //Toast.makeText(this,frase,Toast.LENGTH_LONG).show();

        texto=(TextView)findViewById(R.id.lblFrase);
        texto.setText(frase);
    }

    public void reproducir() {
        String leer=texto.getText().toString();
        speak(leer);
    }

    private void speak(String leer) {
        myTTS.speak(leer, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {
        if (status==TextToSpeech.SUCCESS){
            Locale loc = new Locale ("spa", "ESP");
            myTTS.setLanguage(loc);
        }else if (status==TextToSpeech.ERROR){
            Toast.makeText(this,"Error.. Que sera... no se", Toast.LENGTH_LONG).show();
        }
    }

    protected void onActivityResult (int request_code, int result_code, Intent data){
        if (request_code==MY_DATA_CHECK_CODE){
            if (result_code==TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
                myTTS=new TextToSpeech(this,this);
            }else{
                Intent installTTSIntent=new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
        getMenuInflater().inflate(R.menu.activity_llamada, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nuevaMeditacion:

                break;
            case R.id.fraseDelDia:
                guardarFraseDelDia();

                break;
            case R.id.compartirFrase:

                break;

            case R.id.verMeditaciones:

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void guardarFraseDelDia() {
        Capital cap=new Capital(frase, fecha);
        Log.v("????????????????:",fecha);
        cap.guardarFechaDia();
    }

}
