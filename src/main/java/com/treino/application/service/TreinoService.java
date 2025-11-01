package com.treino.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.treino.DTO.TreinoCreateDTO;
import com.treino.domain.model.DiaTreino;
import com.treino.domain.model.Exercicio;
import com.treino.domain.model.Treino;
import com.treino.domain.repository.TreinoRepository;

import jakarta.transaction.Transactional;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    /**
     * Cria um treino completo (com dias e exercícios).
     */
    @Transactional
    public Treino criarTreinoComDiasEExercicios(TreinoCreateDTO dto) {
        Treino treino = new Treino();
        treino.setNomeTreino(dto.getNomeTreino());

        if (dto.dias() != null) {
            dto.dias().forEach(diaDTO -> {
                DiaTreino dia = new DiaTreino();
                dia.setDiaSemana(diaDTO.getDiaSemana());
                dia.setGrupoMuscular(diaDTO.getGrupoMuscular());
                dia.setEnfase(diaDTO.getEnfase());
                dia.setTreino(treino); // <- importante: define a FK

                if (diaDTO.getExercicios() != null) {
                    diaDTO.getExercicios().forEach(exDTO -> {
                        Exercicio ex = new Exercicio();
                        ex.setSeries(exDTO.getSeries());
                        ex.setRepeticoes(exDTO.getRepeticoes());
                        ex.setDescanso(exDTO.getDescanso());
                        ex.setObservacoes(exDTO.getObservacoes());
                        ex.setDiaTreino(dia); // <- importante: define a FK
                        dia.addExercicio(ex);
                    });
                }

                treino.addDia(dia);
            });
        }

        return treinoRepository.save(treino);
    }

    /**
     * Lista todos os treinos cadastrados.
     */
    public List<Treino> listar() {
        return treinoRepository.findAll();
    }

    /**
     * Busca um treino pelo ID.
     */
    public Optional<Treino> buscar(Long id) {
        return treinoRepository.findById(id);
    }


    // TreinoService.java
    @Transactional
    public Treino atualizar(Long id, TreinoCreateDTO dto) {
        Treino existente = treinoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Treino " + id + " não encontrado"));

    // atualiza campos do treino
    existente.setNomeTreino(dto.getNomeTreino());

    // zera os dias/exercícios atuais (orphanRemoval remove no banco)
    existente.getDiasTreino().clear();

    // recria a estrutura a partir do DTO
    if (dto.dias() != null) {
        dto.dias().forEach(diaDTO -> {
            DiaTreino dia = new DiaTreino();
            dia.setDiaSemana(diaDTO.getDiaSemana());
            dia.setGrupoMuscular(diaDTO.getGrupoMuscular());
            dia.setEnfase(diaDTO.getEnfase());
            dia.setTreino(existente);

            if (diaDTO.getExercicios() != null) {
               
            }

            existente.addDia(dia);
        });
    }

    // como 'existente' está gerenciado, só retornar: o flush ocorre no commit
    return existente;
}


  
    @Transactional
    public void deletar(Long id) {
        treinoRepository.deleteById(id);
    }

    
}
