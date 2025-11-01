package com.treino.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.treino.application.service.DiaTreinoService;
import com.treino.domain.model.DiaTreino;
import com.treino.domain.repository.DiaTreinoRepository;

@RestController
@RequestMapping("/api/dias-treino")
@CrossOrigin(origins = "*")
@Tag(name = "DiasTreino", description = "Endpoints para consulta de dias de treino")
public class DiasTreinoController {

    private final DiaTreinoService service;
    private final DiaTreinoRepository repo;
    public DiasTreinoController(DiaTreinoService service, DiaTreinoRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<DiaTreino> criarDiaTreino(DiaTreino diaTreino) {
        DiaTreino criado = service.criarDiaTreino(diaTreino);
        return ResponseEntity.ok(criado);
    }

    @GetMapping
    public ResponseEntity<List<DiaTreino>> listarTodos() {
        java.util.List<DiaTreino> diasTreino = repo.findAll();
        return ResponseEntity.ok(diasTreino);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaTreino> buscarPorId(@PathVariable Long id) {
        return service.buscarDiaTreinoPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaTreino> atualizarDiaTreino(@PathVariable Long id, DiaTreino diaTreinoAtualizado) {
        try {
            DiaTreino atualizado = service.atualizar(id, diaTreinoAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
 

