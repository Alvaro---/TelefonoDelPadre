package com.example.secretara_santuario.telefonodelpadre;

import android.app.Activity;
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
    RadioButton radioTodos, radioDias, radioSilencio, radioVibracion, radioSonido;

    CheckBox boxLunes, boxMartes, boxMiercoles, boxJueves, boxViernes, boxSabado, boxDomingo;
    RelativeLayout lay;

    Button btnAceptar, btnCancelar;

    //Si es 0 sera silencio, 1 vibracion y 2 sonido
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
                    sonido=2;
                else if (checkedId==R.id.radioVibracion)
                    sonido=1;
                else sonido=0;
            }
        });
    }

    private void cargarElementos() {
        lay=(RelativeLayout)findViewById(R.id.relativeCheck);

        radioGroupDias=(RadioGroup)findViewById(R.id.radioGroupDias);
        radioGroupSonido=(RadioGroup)findViewById(R.id.radioGroupSonido);

        radioTodos=(RadioButton)findViewById(R.id.radioTodos);
        radioDias=(RadioButton)findViewById(R.id.radioSemana);
        radioSonido=(RadioButton)findViewById(R.id.radioSonido);
        radioSilencio=(RadioButton)findViewById(R.id.radioSilencio);
        radioVibracion=(RadioButton)findViewById(R.id.radioVibracion);

        btnAceptar=(Button)findViewById(R.id.btnAceptar);
        btnCancelar=(Button)findViewById(R.id.btnCancelar);
    }
}
