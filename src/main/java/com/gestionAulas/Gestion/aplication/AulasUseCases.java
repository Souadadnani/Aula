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
    public List<Aula> getAll(){
        return this.aulasRepository.getAll();
    }
    public void save(Sesion sesion){
        this.aulasRepository.save(sesion);
    }
    public Aula findAula(String id){
        return this.aulasRepository.findAula(id);
    }
    public void deleteAula(String id){
         this.aulasRepository.deleteAula(id);
    }
}
