package com.gestionAulas.Gestion.domain;

public class Responsable {

    private Integer id;
    private String nombre;

    public Responsable(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
