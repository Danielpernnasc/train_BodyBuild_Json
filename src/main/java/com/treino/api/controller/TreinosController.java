package com.treino.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treino.DTO.TreinoCreateDTO;
import com.treino.application.service.TreinoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;



@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TreinosController {

    private final TreinoService treinoService;

    public TreinosController(TreinoService service){
        this.treinoService = service;
    }




    @Operation(summary = "Create a new Training Routine (days + exercises)")
    @PostMapping("/treinos/rotina")
    public ResponseEntity<Long> createRotina(@Valid @RequestBody TreinoCreateDTO dto){
        var treino = treinoService.criarTreinoComDiasEExercicios(dto);
        return ResponseEntity.ok(treino.getId());
    }

    @Operation(summary = "Lista todos os treinos")
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(treinoService.listar());
    }

    @Operation(summary = "Busca um treino por ID")
    @GetMapping("{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        return treinoService.buscar(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    


 


  
    
}