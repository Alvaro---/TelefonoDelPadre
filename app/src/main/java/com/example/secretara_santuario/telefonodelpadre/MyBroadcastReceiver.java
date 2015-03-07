package com.example.secretara_santuario.telefonodelpadre;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by HP on 07/03/2015.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, servicioClass.class);
        context.startService(i);
    }
}
