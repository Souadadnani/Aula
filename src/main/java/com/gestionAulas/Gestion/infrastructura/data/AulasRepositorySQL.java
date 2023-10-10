package com.gestionAulas.Gestion.infrastructura.data;

import com.gestionAulas.Gestion.domain.Aula;
import com.gestionAulas.Gestion.domain.AulasRepository;

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return null;
    }

    @Override
    public void save(Aula aula) {

    }

    @Override
    public Aula findAula(String id) {
        return null;
    }

    @Override
    public void deleteAula(String id) {

    }
}
