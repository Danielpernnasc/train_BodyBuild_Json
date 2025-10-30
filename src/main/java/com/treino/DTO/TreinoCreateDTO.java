package com.treino.DTO;

import java.util.List;

import com.treino.domain.model.Treino;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TreinoCreateDTO {
     @NotNull private final String nomeTreino;
     @NotNull @Size(min = 1) List<DiaTreinoDTO> dias;


     public TreinoCreateDTO(String nomeTreino, List<DiaTreinoDTO> dias) {
          this.nomeTreino = nomeTreino;
          this.dias = dias;
     }

     public List<DiaTreinoDTO> dias() {
          return dias;
     }

     public String getNomeTreino() {
          return nomeTreino;
     }

     public Treino criarTreinoComDiasEExercicios(TreinoCreateDTO dto) {
        Treino treino = new Treino();
        return treino;
    }

}
