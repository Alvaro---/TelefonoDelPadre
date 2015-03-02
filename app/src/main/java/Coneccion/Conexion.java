package Coneccion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alvaro on 02/03/2015.
 */
public class Conexion extends SQLiteOpenHelper {

    //patron singleton
    private static Conexion instancia=null;

    //dATOS
    private static final String DATABASE_NAME = "Telefono";
    private static final int DATABASE_VERSION=1;

    //creacion de tablas
    private String tb1="CREATE TABLE frases (frase TEXT primarykey)";

    //modificacion de tablas

    //eliminacion de tablas

    //insercion de datos iniciales
    private String a1="insert into frases values ('Di buen dia a todos')";


    public static Conexion getInstance(Context con) {
        /**
         * use the application context as suggested by CommonsWare.
         * this will ensure that you dont accidentally leak an Activitys
         * context (see this article for more information:
         * http://android-developers.blogspot.nl/2009/01/avoiding-memory-leaks.html)
         */
        if (instancia == null) {
            instancia = new Conexion(con.getApplicationContext());
        }
        return instancia;
    }

    //llamada al constructor
    public Conexion(Context context) {
        /*En lugar de esto creo que se podria aumentar todos los campos en el getInstance y ademas en la creacion de la
        instancia dentro del getInstance
        ademas. Eso tal vez para cambiar la version o algo asi.*/
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Ejecutar creacion al iniciar
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tb1);
        db.execSQL(a1);
    }

    //ejecutar actualiacion
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
