package com.gestionAulas.Gestion.infrastructura.data;

import com.gestionAulas.Gestion.domain.Aula;
import com.gestionAulas.Gestion.domain.AulasRepository;
import com.gestionAulas.Gestion.domain.Responsable;
import com.gestionAulas.Gestion.domain.Sesion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AulasRepositorySQL implements AulasRepository {

    public AulasRepositorySQL(){};


    @Override
    public List<Sesion> getAll() {
        List<Sesion> sesiones = new ArrayList<>();
        try {
            Statement st = DBConnection.getInstance().createStatement();
            ResultSet rs = st.executeQuery("select s.*, r.nombre as responsable_nombre from sesion s join responsable r on r.id = s.responsable;");
            while(rs.next()){
                String horaInicio = rs.getString("horaInicio");
                String horaFin = rs.getString("horaFin");
                Responsable responsable = new Responsable(rs.getInt("responsable"), rs.getString("responsable_nombre"));
                Integer numeroSesion = rs.getInt("numeroSesion");
                Integer diaSemana = rs.getInt("numeroSesion");
                Aula aula = new Aula(rs.getString("aula"));

                Sesion sesion = new Sesion(horaInicio, horaFin, responsable, numeroSesion, diaSemana, aula);
                sesiones.add(sesion);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return  sesiones;
    }

    @Override
    public Sesion findAula(String id) {

        try {
            Statement st = DBConnection.getInstance().createStatement();
            ResultSet rs = st.executeQuery("select s.*, r.nombre as responsable_nombre from sesion s join responsable r on r.id = s.responsable where s.aula like '%" + id + "%';");

            while(rs.next()){
                String horaInicio = rs.getString("horaInicio");
                String horaFin = rs.getString("horaFin");
                Responsable responsable = new Responsable(rs.getInt("responsable"), rs.getString("responsable_nombre"));
                Integer numeroSesion = rs.getInt("numeroSesion");
                Integer diaSemana = rs.getInt("numeroSesion");
                Aula aula = new Aula(rs.getString("aula"));

                return new Sesion(horaInicio, horaFin, responsable, numeroSesion, diaSemana, aula);


            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

}
