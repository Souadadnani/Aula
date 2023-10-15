package com.gestionAulas.Gestion.domain;

public class Responsable {

    private Integer id;
    private String nombre;

    public Responsable(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "id=" + id + '\'' +
                '}';
    }
}
