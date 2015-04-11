package clases;

import repository.repoCapital;
import repositorySQLite.sqliteCapital;

/**
 * Created by HP on 11/04/2015.
 */
public class Capital {

    String frase;
    String fecha;

    repoCapital repository = new sqliteCapital();

    public Capital(String frase, String fecha) {
        this.frase = frase;
        this.fecha = fecha;
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


    public void guardarFechaDia() {
        repository.guardarCapitalDia(this);
    }

    public void cargarFecha(String fechaOb) {
        this.setFecha(fechaOb);
        this.setFrase(repository.cargarFecha(fechaOb));
    }
}
