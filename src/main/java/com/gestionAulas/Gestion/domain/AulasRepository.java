package com.gestionAulas.Gestion.domain;

import java.util.List;

public interface AulasRepository {
    List<Sesion> getAll();
    Aula findAula(String id);


}
