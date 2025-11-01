package com.treino.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.treino.domain.model.DiaTreino;
import com.treino.domain.repository.DiaTreinoRepository;

import jakarta.transaction.Transactional;

@Service
public class DiaTreinoService {

    private final DiaTreinoRepository diaTreinoRepository;

    public DiaTreinoService(DiaTreinoRepository diaTreinoRepository) {
        this.diaTreinoRepository = diaTreinoRepository;
    }

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

    public Optional<DiaTreino> buscarDiaTreinoPorId(Long id) {
        return diaTreinoRepository.findById(id);
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
