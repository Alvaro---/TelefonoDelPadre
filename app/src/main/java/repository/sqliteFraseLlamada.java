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

        //conex.onUpgrade(db,1,2);
        //ACTUALIZACION DE TABLA

        String consulta="select frase from frases";
        Cursor fila=db.rawQuery(consulta,null);
        if (fila.moveToFirst()){
            int val=fila.getCount();
            int numero=(int) (Math.random() * val);
            for (int i=0;i<numero;i++){
                fila.moveToNext();
            }
            frase=fila.getString(0);
        }else{
            frase="No existe actividad";
        }
        fila.close();
        db.close();

        return frase;
    }
}
