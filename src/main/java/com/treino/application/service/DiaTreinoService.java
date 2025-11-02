package com.treino.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.treino.domain.model.DiaTreino;
import com.treino.domain.model.Exercicio;
import com.treino.domain.repository.DiaTreinoRepository;
import com.treino.domain.repository.ExercicioRepository;

import jakarta.transaction.Transactional;

@Service
public class DiaTreinoService {

    private final DiaTreinoRepository diaTreinoRepository;
    private final ExercicioRepository exercicioRepository;

    public DiaTreinoService(DiaTreinoRepository diaTreinoRepository, ExercicioRepository exercicioRepository) {
        this.diaTreinoRepository = diaTreinoRepository;
        this.exercicioRepository = exercicioRepository;
    }

    // Removed incomplete method declaration

    @Transactional
    public DiaTreino criarDiaTreino(DiaTreino diaTreino) {
        DiaTreino novoDiaTreino = new DiaTreino();
        novoDiaTreino.setDiaSemana(diaTreino.getDiaSemana());
        novoDiaTreino.setGrupoMuscular(diaTreino.getGrupoMuscular());
        novoDiaTreino.setEnfase(diaTreino.getEnfase());
        novoDiaTreino.setExercicios(diaTreino.getExercicios() != null ? diaTreino.getExercicios() : new ArrayList<>());
        return diaTreinoRepository.save(novoDiaTreino);
    }

    public List<DiaTreino> listarDiasTreino() {
        return diaTreinoRepository.findAll();
    }

    public List<Exercicio> buscarExercicioSemanal(){
        return exercicioRepository.findAll();
    }

    public Optional<DiaTreino> buscarDiaTreinoPorId(Long id) {
        return diaTreinoRepository.findById(id);
    }

    public Optional<Exercicio> buscarDiaExercicioPorId(Long id) {
        return exercicioRepository.findById(id);
    }


    @Transactional
    public DiaTreino atualizar(Long id, DiaTreino diaTreinoAtualizado) {
        return diaTreinoRepository.findById(id).map(diaTreino -> {
            diaTreino.setDiaSemana(diaTreinoAtualizado.getDiaSemana());
            diaTreino.setGrupoMuscular(diaTreinoAtualizado.getGrupoMuscular());
            diaTreino.setEnfase(diaTreinoAtualizado.getEnfase());
            diaTreino.setExercicios(diaTreinoAtualizado.getExercicios());
            return diaTreinoRepository.save(diaTreino);
        }).orElseThrow(() -> new RuntimeException("Dia de Treino não encontrado com ID: " + id));
    }


  

    
    
}
