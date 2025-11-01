package com.treino.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treino.application.service.TreinoService;
import com.treino.domain.model.Treino;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/treinos")
@Tag(name = "Treinos", description = "Gerencia treinos, dias e exercícios.")
public class TreinosController {

  private final TreinoService service;

  public TreinosController(TreinoService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Treino> criar(@RequestBody Treino dto) {
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

  // TreinoController.java
  @PutMapping("/{id}")
  public ResponseEntity<Treino> atualizar(@PathVariable Long id, @RequestBody Treino dto) {
      try {
          Treino atualizado = service.atualizar(id, dto);
          return ResponseEntity.ok(atualizado);
      } catch (IllegalArgumentException e) {
          return ResponseEntity.notFound().build();
      }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    try {
      service.deletar(id);
      return ResponseEntity.noContent().build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.notFound().build();
    }
  }

}
