package com.example.secretara_santuario.telefonodelpadre;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Coneccion.Conexion;
import clases.FraseLlamada;

public class LlamadaActivity extends Activity{

    Button rellamada;
    FraseLlamada fra;

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
    }

    public void actualizarLlamada(){
        fra=new FraseLlamada(null,getApplicationContext());
        String frase=fra.getFraseNueva();

        //Toast.makeText(this,frase,Toast.LENGTH_LONG).show();

        TextView texto=(TextView)findViewById(R.id.lblFrase);
        texto.setText(frase);
    }
}
