package com.gestionAulas.Gestion.infrastructura;

import com.gestionAulas.Gestion.domain.Aula;
import com.gestionAulas.Gestion.domain.Sesion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class AulasController {
    List<Sesion> listaSesiones = new ArrayList<>();
    @GetMapping("/")
    String aula(Model model){
        List<Sesion> listaSesiones = this.listaSesiones;
        model.addAttribute("sesiones",listaSesiones);
        return "index";
    }
    @PostMapping("/buscar")
    String buscar(Model model, String id){
        for (Sesion s: listaSesiones){
            if(s.getAula().equals(id)){
                model.addAttribute("sesiones",s);
            }
        }
        return "buscaSesion";
    }
}
