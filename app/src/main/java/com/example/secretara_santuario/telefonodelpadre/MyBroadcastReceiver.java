package com.example.secretara_santuario.telefonodelpadre;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by HP on 07/03/2015.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bun=intent.getExtras();
        int sonido=bun.getInt("varSonido");
        //***Toast.makeText(context,sonido+"... En Broadcast",Toast.LENGTH_LONG).show();
        Intent i = new Intent(context, servicioClass.class);
        i.putExtra("sonido",sonido);
        context.startService(i);
    }
}
