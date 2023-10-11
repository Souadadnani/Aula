package com.gestionAulas.Gestion.infrastructura;

import com.gestionAulas.Gestion.aplication.AulasUseCases;
import com.gestionAulas.Gestion.domain.Aula;
import com.gestionAulas.Gestion.domain.Sesion;
import com.gestionAulas.Gestion.infrastructura.data.AulasRepositorySQL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
public class AulasController {
    private AulasUseCases aulasUseCases;
    public AulasController(){
        this.aulasUseCases=new AulasUseCases(new AulasRepositorySQL());
    }
    List<Sesion> listaSesiones = new ArrayList<>();

    @GetMapping("/")
    String aula(Model model){
        List<Sesion> listaSesiones = this.aulasUseCases.getAll();
        model.addAttribute("sesiones",listaSesiones);
        return "index";
    }
    @GetMapping("/buscar")
    String buscar(Model model,String id){
        List<Sesion> listaSesiones = this.aulasUseCases.getAll();
        List<Sesion> sesiones = new ArrayList<>();
        for (Sesion s: listaSesiones){
            if(s.getAula().equals(id)){
                sesiones.add(s);
                model.addAttribute("sesiones",sesiones);
            }
        }
        return "buscaSesion";
    }
}
