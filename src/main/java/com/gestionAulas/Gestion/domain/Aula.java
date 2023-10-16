package com.gestionAulas.Gestion.domain;

public class Aula {

    private String id;

    public Aula(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}
