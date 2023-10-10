package com.gestionAulas.Gestion.infrastructura.data;

import com.gestionAulas.Gestion.domain.Aula;
import com.gestionAulas.Gestion.domain.AulasRepository;
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
    public List<Aula> getAll() {
        List<Aula> aulas = new ArrayList<>();

        try {
            Statement st = DBConnection.getInstance().createStatement();
            ResultSet rs = st.executeQuery("select distinct aula from sesion;");
            while(rs.next()){
                Aula aula = new Aula(
                        rs.getString("aula")
                );
                aulas.add(aula);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  aulas;
    }

    @Override
    public void save(Sesion sesion) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("insert into sesion (horaFin,horaInicio, responsable, numeroSesion,diaSemana, aula) values(?,?,?,?,?,?);");
            ps.setString(1, sesion.getHoraFin());
            ps.setString(2, sesion.getHoraInicio());
            ps.setString(3, String.valueOf(sesion.getResponsable()));
            ps.setInt(4, sesion.getNumeroSesion());
            ps.setInt(5, sesion.getNumeroSesion());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Aula findAula(String id) {
        return null;
    }

    @Override
    public void deleteAula(String id) {

    }
}
