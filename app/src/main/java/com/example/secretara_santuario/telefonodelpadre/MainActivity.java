package com.example.secretara_santuario.telefonodelpadre;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    Button btnLlamar, btnHistorial;
    Button btnProgramar;

    public static Context cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont=getApplicationContext();

        btnLlamar=(Button)findViewById(R.id.btnLlamar);
        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamar=new Intent(MainActivity.this, LlamadaActivity.class);
                startActivity(llamar);
            }
        });

        btnProgramar=(Button)findViewById(R.id.btnProgramarLlamada);
        btnProgramar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent programar=new Intent(MainActivity.this, ListaAlarmasActivity.class);
                startActivity(programar);
            }
        });

        btnHistorial=(Button)findViewById(R.id.btnHistorial);
        btnHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historial=new Intent(MainActivity.this, CapitalActivity.class);
                startActivity(historial);
            }
        });

    }
}
