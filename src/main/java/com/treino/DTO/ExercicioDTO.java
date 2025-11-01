package com.treino.DTO;

import com.treino.domain.model.DiaTreino;
import com.treino.domain.model.Exercicio;
import com.treino.domain.model.Treino;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExercicioDTO {

    private Treino idTreino;

    private Treino oTreino;
    

    private DiaTreino diaTreino;

    @NotBlank
    private String nomeTreino;
    
    @NotNull
    private Integer series;

    
    @NotBlank
    private String repeticoes;
    
    private String descanso;
    private String observacoes;


    public long getIdTreino() {
        return idTreino.getId();
    }

    public Treino getoTreino() {
        return oTreino;
    }


    public String getDiaTreino() {
        return diaTreino.getDiaSemana();
    }

 

    public String getNomeTreino() {
        return nomeTreino;
    }

    public Integer getSeries() {
        return series;
    }
    
    public String getRepeticoes() {
        return repeticoes;
    }

    public String getDescanso() {
        return descanso;
    }
    
    public String getObservacoes() {
        return observacoes;
    }


  
    

  
}
