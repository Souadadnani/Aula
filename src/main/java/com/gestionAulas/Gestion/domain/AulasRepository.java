package com.gestionAulas.Gestion.domain;

import java.util.List;

public interface AulasRepository {
    List<Sesion> getAll();
    void  save(Sesion sesion);
    Aula findAula(String id);
    void deleteAula(String id);

}
