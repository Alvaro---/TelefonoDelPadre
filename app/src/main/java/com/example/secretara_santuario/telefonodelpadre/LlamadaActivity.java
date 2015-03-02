package com.example.secretara_santuario.telefonodelpadre;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import Coneccion.Conexion;
import clases.FraseLlamada;

public class LlamadaActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada);

        FraseLlamada fra=new FraseLlamada(null,getApplicationContext());

        String frase=fra.getFraseNueva();
        //Toast.makeText(this,frase,Toast.LENGTH_LONG).show();

        TextView texto=(TextView)findViewById(R.id.lblFrase);
        texto.setText(frase);
    }
}
