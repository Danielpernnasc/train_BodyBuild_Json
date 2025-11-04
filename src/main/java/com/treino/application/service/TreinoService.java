package com.treino.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;



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
public Treino criarTreinoComDiasEExercicios(Treino body) {
  Treino treino = new Treino();
  treino.setNomeTreino(body.getNomeTreino());
  treino.setCategoria(body.getCategoria());
  treino.setDescricao(body.getDescricao());
  treino.setCreatedAt(body.getCreatedAt());

  if (body.getDiasTreino() != null) {
    body.getDiasTreino().forEach(diaIn -> {
      DiaTreino dia = new DiaTreino();
      dia.setDiaSemana(diaIn.getDiaSemana());           // <- ESSENCIAL
      dia.setGrupoMuscular(diaIn.getGrupoMuscular());
      dia.setEnfase(diaIn.getEnfase());

      treino.addDia(dia); // addDia já faz dia.setTreino(this)

      if (diaIn.getExercicios() != null) {
        diaIn.getExercicios().forEach(exIn -> {
          Exercicio ex = new Exercicio();
          ex.setTreino(exIn.getTreino());               // nome/texto do exercício
          ex.setSeries(exIn.getSeries());
          ex.setRepeticoes(exIn.getRepeticoes());
          ex.setDescanso(exIn.getDescanso());
          ex.setObservacoes(exIn.getObservacoes());
          ex.setDiaTreino(dia);                         // <- FK DIA_TREINO_ID
          dia.getExercicios().add(ex);
        });
      }
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
public Treino atualizar(Long id, Treino dto) {
    Treino existente = treinoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Treino " + id + " não encontrado"));

    // Atualiza campos do treino
    existente.setNomeTreino(dto.getNomeTreino());
    existente.setCategoria(dto.getCategoria());
    existente.setDescricao(dto.getDescricao());

    // Zera os dias/exercícios atuais (orphanRemoval remove no banco)
    existente.getDiasTreino().clear();

    // Recria a estrutura a partir do DTO
    if (dto.getDiasTreino() != null) {
        dto.getDiasTreino().forEach(diaDTO -> {
            DiaTreino dia = new DiaTreino();
            dia.setDiaSemana(diaDTO.getDiaSemana());
            dia.setGrupoMuscular(diaDTO.getGrupoMuscular());
            dia.setEnfase(diaDTO.getEnfase());

            existente.addDia(dia);  // Configura dia.setTreino(existente)

            if (diaDTO.getExercicios() != null) {
                diaDTO.getExercicios().forEach(exDTO -> {
                    Exercicio ex = new Exercicio();
                    ex.setTreino(exDTO.getTreino());
                    ex.setSeries(exDTO.getSeries());
                    ex.setRepeticoes(exDTO.getRepeticoes());
                    ex.setDescanso(exDTO.getDescanso());
                    ex.setObservacoes(exDTO.getObservacoes());

                    dia.addExercicio(ex);  // Configura ex.setDiaTreino(dia)
                });
            }
        });
    }

    return existente;  // JPA flush automático no commit
}

  
    @Transactional
    public void deletar(Long id) {
        treinoRepository.deleteById(id);
    }

    
}
