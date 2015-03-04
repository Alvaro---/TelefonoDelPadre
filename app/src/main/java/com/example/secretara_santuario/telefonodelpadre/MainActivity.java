package com.example.secretara_santuario.telefonodelpadre;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    Button btnLlamar;
    Button btnProgramar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent programar=new Intent(MainActivity.this, ProgramarActivity.class);
                startActivity(programar);
            }
        });

    }
}
