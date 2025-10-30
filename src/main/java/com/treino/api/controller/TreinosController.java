package com.treino.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treino.DTO.TreinoCreateDTO;
import com.treino.application.service.TreinoService;
import com.treino.domain.model.Treino;

@RestController
@RequestMapping("/api/treinos")
public class TreinosController {

  private final TreinoService service;

  public TreinosController(TreinoService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Treino> criar(@RequestBody TreinoCreateDTO dto) {
    return ResponseEntity.ok(service.criarTreinoComDiasEExercicios(dto));
  }

  @GetMapping
  public ResponseEntity<?> listar() {
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> buscar(@PathVariable Long id) {
    return ResponseEntity.of(service.buscar(id));
  }
}
