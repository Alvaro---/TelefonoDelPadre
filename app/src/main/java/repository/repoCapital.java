package repository;

import clases.Capital;

/**
 * Created by HP on 11/04/2015.
 */
public interface repoCapital {


    void guardarCapitalDia(Capital capital);

    String cargarFecha(String fechaOb);
}
