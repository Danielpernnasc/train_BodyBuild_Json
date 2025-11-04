package com.treino.api.controller;

import org.slf4j.LoggerFactory;
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

import org.slf4j.Logger;

// Ensure the Treino class is explicitly declared and properly imported


@RestController
@RequestMapping("/api") // base = /api
public class TreinosController {
  private static final Logger log = LoggerFactory.getLogger(TreinosController.class);

  private final TreinoService service;

  public TreinosController(TreinoService service) { this.service = service; }


  @PostMapping(path = "/treinos")
  public ResponseEntity<Treino> criar(@RequestBody Treino body) {
    log.info("Recebido treino: {}", body.getNomeTreino());
    Treino salvo = service.criarTreinoComDiasEExercicios(body);
    return ResponseEntity.status(201).body(salvo);
  }
  // @PostMapping(path = "/treinos", consumes = "application/json", produces = "application/json")
  // public ResponseEntity<Treino> criar(@RequestBody Treino body) {
  //   Treino salvo = service.criarTreinoComDiasEExercicios(body);
  //   return ResponseEntity.status(201).body(salvo);
  // }

  

  @PostMapping(path = "/treinos/teste")
  public ResponseEntity<String> teste() {
    log.info("Endpoint de teste chamado");
    return ResponseEntity.ok("Funcionou!");
  }

  @GetMapping("/treinos")
  public ResponseEntity<?> listar() {
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/treinos/{id}")
  public ResponseEntity<?> buscar(@PathVariable Long id) {
    return ResponseEntity.of(service.buscar(id));
  }

  @PutMapping("/treinos/{id}")
public ResponseEntity<Treino> atualizar(@PathVariable Long id, @RequestBody Treino dto) {
  log.info("Atualizando treino ID: {}", id);
  try {
    Treino atualizado = service.atualizar(id, dto);
    return ResponseEntity.ok(atualizado);
  } catch (IllegalArgumentException e) {
    log.warn("Treino {} não encontrado", id);
    return ResponseEntity.notFound().build();
  }
}

  @DeleteMapping("/treinos/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    try {
      service.deletar(id);
      return ResponseEntity.noContent().build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.notFound().build();
    }
  }
}

