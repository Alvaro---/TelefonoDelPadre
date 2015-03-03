package com.example.secretara_santuario.telefonodelpadre;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import Coneccion.Conexion;
import clases.FraseLlamada;

public class LlamadaActivity extends Activity implements TextToSpeech.OnInitListener{

    Button rellamada;
    FraseLlamada fra;
    ImageView imgPadre;
    TextView texto;

    private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada);
        actualizarLlamada();

        rellamada=(Button)findViewById(R.id.btnPreguntarDeeNuevo);
        rellamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarLlamada();
            }
        });

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
        fra=new FraseLlamada(null,getApplicationContext());
        String frase=fra.getFraseNueva();

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
}
