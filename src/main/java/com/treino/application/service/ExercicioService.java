package com.treino.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.treino.domain.model.Exercicio;
import com.treino.domain.repository.ExercicioRepository;

import jakarta.transaction.Transactional;

@Service
public class ExercicioService {
    private final ExercicioRepository exercicioRepository;
    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    @Transactional
    public Exercicio criar(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }


    public List<Exercicio> getAllExercicios() {
        return exercicioRepository.findAll();
    }

    public Optional<Exercicio> getExercicioById(Long id) {
        return exercicioRepository.findById(id);
    }

    public Exercicio Atualizar(long id, Exercicio updatedExercicio) {
        Exercicio exercicio = exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercicio " + id + " não encontrado"));

        exercicio.setTreino(updatedExercicio.getTreino());
        exercicio.setSeries(updatedExercicio.getSeries());
        exercicio.setRepeticoes(updatedExercicio.getRepeticoes());
        exercicio.setDescanso(updatedExercicio.getDescanso());
        exercicio.setObservacoes(updatedExercicio.getObservacoes());
        // Removed the call to addExercicio as it is undefined in the Exercicio class
        return exercicioRepository.save(exercicio);
    }
    
   

    @Transactional
    public void deleter(Long id) {
        exercicioRepository.deleteById(id);
    }




}
