package com.gestionAulas.Gestion.domain;

public class Responsable {

    private int id;
    private String nombre;

    public Responsable(int id, String nombre) {
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
        return "Responsable{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
