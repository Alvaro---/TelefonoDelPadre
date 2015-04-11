package repositorySQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.secretara_santuario.telefonodelpadre.LlamadaActivity;
import com.example.secretara_santuario.telefonodelpadre.MainActivity;

import Coneccion.Conexion;
import clases.Capital;
import repository.repoCapital;

/**
 * Created by HP on 11/04/2015.
 */
public class sqliteCapital implements repoCapital {

    @Override
    public void guardarCapitalDia(Capital capital) {
        Conexion conex=Conexion.getInstance(LlamadaActivity.contextLlamada);
        SQLiteDatabase db= conex.getWritableDatabase();

        ContentValues registro=new ContentValues();
        registro.put("fecha",capital.getFecha());
        registro.put("frase",capital.getFrase());

        db.insert("fechasCapital",null, registro);
    }

    @Override
    public String cargarFecha(String fechaOb) {
        String frase="";
        Conexion conex=Conexion.getInstance(MainActivity.cont);

        //Obtiene Base de datos.
        SQLiteDatabase db= conex.getWritableDatabase();

        //Consulta para obtener el nobmre de usuario
        String consulta="select frase from fechasCapital where fecha = '"+fechaOb+"'";

        Log.v("CARGAR LLAMADA",consulta);
        //Cursor para consulta - ejecuta query
        Cursor fila=db.rawQuery(consulta, null);

        //Nombre, toma el primer nombre encontrado
        if (fila.moveToFirst()) {
            frase = fila.getString(0);
            Log.v("AAAAA", "dentro");
        }
        fila.close();
        db.close();
        return frase;
    }
}
