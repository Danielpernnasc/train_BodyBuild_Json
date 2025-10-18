package com.treino.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treino.DTO.DtoRotina;
import com.treino.service.TreinoService;



@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TreinosController {
    private final TreinoService treinoService;



    @Autowired
    public TreinosController(TreinoService treinoService) {
        this.treinoService = treinoService;
     
    }


    @GetMapping("/api/treino/mensPhysique")
    public Map<String, Object> treinoDoDia() {
        treinoService.oTreinoMP();
        DtoRotina dto = new DtoRotina(treinoService); 
        return dto.rotinaTrain();
    }

    @GetMapping("/api/treino/classicPhysique")
    public Map<String, Object> treinoDoDiaCP() {
        treinoService.oTrainCP(); 
        DtoRotina dto = new DtoRotina(treinoService); 
        return dto.rotinaTrain();
 
    }

    @GetMapping("/api/treino/openPhysique")
    public Map<String, Object> treinoDoDiaOPEN() {
        treinoService.oTrainOPEN(); 
        DtoRotina dto = new DtoRotina(treinoService); 
        return dto.rotinaTrain();
 
    }

    @GetMapping("/api/treino/naturalPhysique")
    public Map<String, Object> treinoDoDiaNatural() {
        treinoService.oTrainNatural(); 
        DtoRotina dto = new DtoRotina(treinoService); 
        return dto.rotinaTrain();
 
    }
    
}