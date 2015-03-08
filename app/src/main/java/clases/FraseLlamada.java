package clases;

/**
 * Created by Alvaro on 02/03/2015.
 */
import android.content.Context;

import Coneccion.Conexion;
import repository.repoFraseLlamada;
import repository.sqliteFraseLlamada;

public class FraseLlamada {

    String frase;
    Context con;
    String meditacionPerssonal;

    public repoFraseLlamada repository=new sqliteFraseLlamada();

    public FraseLlamada(String frase, Context con) {
        this.frase = frase;
        this.con=con;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getFraseNueva(){
        return repository.NuevaFrase(this.con);
    }
}
