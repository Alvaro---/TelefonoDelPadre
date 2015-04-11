package clases;

/**
 * Created by Alvaro on 02/03/2015.
 */

import repository.repoFraseLlamada;
import repositorySQLite.sqliteFraseLlamada;

public class FraseLlamada {

    String frase;
    String fecha;
    String meditacionPropia;
    String meditacionPerssonal;

    public repoFraseLlamada repository=new sqliteFraseLlamada();

    public FraseLlamada(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMeditacionPropia() {
        return meditacionPropia;
    }

    public void setMeditacionPropia(String meditacionPropia) {
        this.meditacionPropia = meditacionPropia;
    }

    public String getFraseNueva(){
        return repository.NuevaFrase();
    }
}
