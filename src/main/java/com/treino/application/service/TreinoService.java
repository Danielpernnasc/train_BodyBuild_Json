package com.treino.application.service;

import org.springframework.stereotype.Service;

import com.treino.DTO.DiaTreinoDTO;
import com.treino.DTO.ExercicioDTO;
import com.treino.DTO.TreinoCreateDTO;
import com.treino.domain.model.DiaTreino;
import com.treino.domain.model.Exercicio;
import com.treino.domain.model.Treino;
import com.treino.domain.repository.TreinoRepository;

import jakarta.transaction.Transactional;

@Service
public class TreinoService {

  private final TreinoRepository repo;

  public TreinoService(TreinoRepository repo){
    this.repo = repo;
  }


  @Transactional
  public Treino criarTreinoComDiasEExercicios(TreinoCreateDTO dto) {
      Treino treino = new Treino();
      treino.setNomeTreino(dto.getNomeTreino());
  
      if (dto.dias() != null) {
          for (DiaTreinoDTO d : dto.dias()) {
              DiaTreino dia = new DiaTreino();
              dia.setDiaSemana(d.getDiaSemana());
              dia.setGrupoMuscular(d.getGrupoMuscular()); // novo campo
              dia.setEnfase(d.getEnfase());               // novo campo

  
              if (d.getExercicios() != null) {
                  for (ExercicioDTO ex : d.getExercicios()) {
                      Exercicio e = new Exercicio();
                      e.setTreino(ex.getNomeTreino());
                      e.setSeries(ex.getSeries());
                      e.setRepeticoes(ex.getRepeticoes());
                      e.setDescanso(ex.getDescanso());
                      e.setObservacoes(ex.getObservacoes());
                      dia.addExercicio(e);
                  }
              }
              treino.addDia(dia);
          }
      }
  
      return repo.save(treino);
  }
  

  public java.util.List<Treino> listar() { return repo.findAll(); }
  public java.util.Optional<Treino> buscar(Long id) { return repo.findById(id); }
}
