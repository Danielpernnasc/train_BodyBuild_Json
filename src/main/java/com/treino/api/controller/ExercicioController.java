package com.treino.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treino.DTO.ExercicioResponse;
import com.treino.application.service.ExercicioService;
import com.treino.domain.model.Exercicio;
import com.treino.domain.repository.ExercicioRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador responsável pelos endpoints relacionados à tabela EXERCICIO.
 * Retorna dados de forma plana (sem loops de treino/dia), no mesmo formato do SELECT do Oracle.
 */
@RestController
@RequestMapping("/api/exercicio")
@CrossOrigin(origins = "*")
@Tag(name = "Exercicio", description = "Endpoints para consulta de exercícios")
public class ExercicioController {

    private final ExercicioService service;
    private final ExercicioRepository repo;

    public ExercicioController(ExercicioService service, ExercicioRepository repo) {
        this.service = service;
        this.repo = repo;
    }
    

    @PostMapping
    public ResponseEntity<Exercicio> criarExercicio(Exercicio exercicio) {
        Exercicio criado = service.criar(exercicio);
        return ResponseEntity.ok(criado);
    }

    @Operation(
        summary = "Lista todos os exercícios",
        description = "Retorna todos os exercícios de forma plana, sem loops de treino/dia."
    )
    @GetMapping
    public ResponseEntity<List<ExercicioResponse>> listarTodos() {
        var lista = repo.findAll().stream()
            .map(e -> new ExercicioResponse(
                e.getId(),
                e.getDiaTreino() != null ? e.getDiaTreino().getId() : null,
                e.getTreino(),
                e.getSeries(),
                e.getRepeticoes(),
                e.getDescanso(),
                e.getObservacoes()
            ))
            .toList(); // ✅ compatível com Java 17

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    // ===================== BUSCAR POR ID =====================
    @Operation(
        summary = "Busca exercício por ID",
        description = "Retorna um exercício específico em formato plano (sem relacionamentos aninhados)."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ExercicioResponse> buscarPorId(@PathVariable Long id) {
        return repo.findById(id)
            .map(e -> new ExercicioResponse(
                e.getId(),
                e.getDiaTreino() != null ? e.getDiaTreino().getId() : null,
                e.getTreino(),
                e.getSeries(),
                e.getRepeticoes(),
                e.getDescanso(),
                e.getObservacoes()
            ))
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizarExercicio(@PathVariable Long id, Exercicio updatedExercicio) {
        try {
            Exercicio exercicio = service.atualizar(id, updatedExercicio);
            return ResponseEntity.ok(exercicio);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarExercicio(@PathVariable Long id) {
        try {
            service.deleter(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
