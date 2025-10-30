package com.treino.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExercicioDTO {
    @NotBlank
    private String nomeTreino;
    
    @NotNull
    private Integer series;

    
    @NotBlank
    private String repeticoes;
    
    private String descanso;
    private String observacoes;

    public String getDescanso() {
        return descanso;
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
    
    public String getObservacoes() {
        return observacoes;
    }
    

  
}
