package repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.secretara_santuario.telefonodelpadre.LlamadaActivity;

import Coneccion.Conexion;

/**
 * Created by Alvaro on 02/03/2015.
 */


public class sqliteFraseLlamada extends repoFraseLlamada{
    @Override
    public String NuevaFrase(Context con) {

        Conexion conex=Conexion.getInstance(con);

        String frase="";
        SQLiteDatabase db= conex.getWritableDatabase();
        String consulta="select frase from frases";
        Cursor fila=db.rawQuery(consulta,null);
        if (fila.moveToFirst()){
            frase=fila.getString(0);
        }else{
            frase="No existe actividad";
        }
        db.close();

        return frase;
    }
}
