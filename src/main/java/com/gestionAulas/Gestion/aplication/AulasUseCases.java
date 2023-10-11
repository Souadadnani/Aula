package com.gestionAulas.Gestion.aplication;

import com.gestionAulas.Gestion.domain.Aula;
import com.gestionAulas.Gestion.domain.AulasRepository;
import com.gestionAulas.Gestion.domain.Sesion;

import java.util.List;

public class AulasUseCases {
    private AulasRepository aulasRepository;
    public AulasUseCases(AulasRepository aulasRepository){
        this.aulasRepository=aulasRepository;
    }
    public List<Sesion> getAll(){
        return this.aulasRepository.getAll();
    }

    public Sesion findAula(String id){
        return this.aulasRepository.findAula(id);
    }

}
