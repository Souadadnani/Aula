package com.gestionAulas.Gestion.domain;

public class Sesion {

    private String horaInicio;
    private String horaFin;
    private Responsable responsable;
    private Integer numerSesion;
    private Integer diaSemana;
    private Aula aula;

    public Sesion(String horaInicio, String horaFin, Responsable responsable, Integer numerSesion, Integer diaSemana, Aula aula) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.responsable = responsable;
        this.numerSesion = numerSesion;
        this.diaSemana = diaSemana;
        this.aula = aula;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public Integer getNumerSesion() {
        return numerSesion;
    }

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public Aula getAula() {
        return aula;
    }

    @Override
    public String toString() {
        return "Sesion{" +
                "horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", responsable=" + responsable +
                ", numerSesion=" + numerSesion +
                ", diaSemana=" + diaSemana +
                ", aula=" + aula +
                '}';
    }
}
