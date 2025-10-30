package com.treino.application.service;

import org.springframework.stereotype.Service;

import com.treino.DTO.DiaTreinoDTO;
import com.treino.DTO.TreinoCreateDTO;
import com.treino.domain.DiaTreino;
import com.treino.domain.Treino;
import com.treino.domain.model.Exercicios;
import com.treino.domain.repository.TreinoRepository;

import jakarta.transaction.Transactional;


@Service
public class TreinoService  {  
        private final TreinoRepository repo;

        public TreinoService(TreinoRepository repo){
            this.repo = repo;
        }


        @Transactional
        public Treino criarTreino(TreinoCreateDTO dto){
            Treino treino = new Treino();
            
            treino.setNomeTreino(dto.getNomeTreino());
            return repo.save(treino);
        }

        @Transactional
        public Treino diaTreino(DiaTreinoDTO diaDTO){
            Treino treino = new Treino();

            diaDTO.dias().forEach(d -> {
                DiaTreino dia = new DiaTreino();
                dia.setDiaSemana(d.getNomeDia());
    
                d.getExercicios().forEach(ex -> {
                    Exercicios e = new Exercicios();
                    e.setTreino(ex.getNomeTreino());
                    e.setSeries(ex.getSeries());
                    e.setRepeticoes(ex.getRepeticoes());
                    e.setDescanso(ex.getDescanso());
                    e.setObservacoes(ex.getObservacoes());
                    treino.addExercicio(dia, e);
                });
    
                treino.addDia(dia);
            });
            return repo.save(treino);
        }

        public java.util.List<Treino> listar() {
            return repo.findAll();
        }
    
        public java.util.Optional<Treino> buscar(Long id) {
            return repo.findById(id);
        }


  
        public Treino criarTreinoComDiasEExercicios(TreinoCreateDTO dto) {
            Treino treino = new Treino();
            treino.setNomeTreino(dto.getNomeTreino());
        
            if (dto.dias() != null) {
                dto.dias().forEach(d -> {
                    DiaTreino dia = new DiaTreino();
                    dia.setDiaSemana(d.getNomeDia());         // ✅ casa com DIA_SEMANA

        
                    if (d.getExercicios() != null) {
                        d.getExercicios().forEach(ex -> {
                            Exercicios e = new Exercicios();
                            e.setTreino(ex.getNomeTreino());                    // ajuste para seu DTO
                            e.setSeries(ex.getSeries());
                            e.setRepeticoes(ex.getRepeticoes());
                            e.setDescanso(ex.getDescanso());
                            e.setObservacoes(ex.getObservacoes());
                            dia.addExercicio(e);
                        });
                    }
        
                    treino.addDia(dia);
                });
            }
        
            return repo.save(treino);
        }





   
    }



    

