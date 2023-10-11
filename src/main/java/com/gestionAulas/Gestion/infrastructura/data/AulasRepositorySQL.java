package com.gestionAulas.Gestion.infrastructura.data;

import com.gestionAulas.Gestion.domain.Aula;
import com.gestionAulas.Gestion.domain.AulasRepository;
import com.gestionAulas.Gestion.domain.Responsable;
import com.gestionAulas.Gestion.domain.Sesion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AulasRepositorySQL implements AulasRepository {

    public AulasRepositorySQL(){};


    @Override
    public List<Sesion> getAll() {
        List<Sesion> sesiones = new ArrayList<>();


        try {
            Statement st = DBConnection.getInstance().createStatement();
            ResultSet rs = st.executeQuery("select * from sesion;");
            while(rs.next()){
                String horaInicio = rs.getString("horaInicio");
                String horaFin = rs.getString("horaFin");
                Responsable responsable = new Responsable(rs.getInt("id"), rs.getString("nombre"));
                Integer numeroSesion = rs.getInt("numeroSesion");
                Integer diaSemana = rs.getInt("numeroSesion");
                Aula aula = new Aula(rs.getString("id"));

                Sesion sesion = new Sesion(horaInicio, horaFin, responsable, numeroSesion, diaSemana, aula);
                sesiones.add(sesion);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return  sesiones;
    }

    @Override
    public void save(Sesion sesion) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("insert into sesion (horaFin,horaInicio, responsable, numeroSesion,diaSemana, aula) values(?,?,?,?,?,?);");
            ps.setString(1, sesion.getHoraFin());
            ps.setString(2, sesion.getHoraInicio());
            ps.setString(3, String.valueOf(sesion.getResponsable()));
            ps.setInt(4, sesion.getNumeroSesion());
            ps.setInt(5, sesion.getDiaSemana());
            ps.setString(6, String.valueOf(sesion.getAula()));
            ps.execute();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public Aula findAula(String id) {

        try {
            Statement st = DBConnection.getInstance().createStatement();
            ResultSet rs = st.executeQuery("select aula from sesion where id like '%" + id + "%';");

            if(rs.next()){
                return new Aula(rs.getString("id"));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void deleteAula(String id) {

        try {
            Statement st = DBConnection.getInstance().prepareStatement("delete aula from sesion where id=" + id + ";");


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
