package com.treino.DTO;

import java.util.List;

import com.treino.domain.model.DiaTreino;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class DiaTreinoDTO {
    @NotBlank String nomeDia;
    @NotNull @Size(min = 1) List<ExercicioDTO> exercicios;
    private List<DiaTreinoDTO> dias;
    private String diaSemana;
    private DiaTreino grupomuscular;



    public List<ExercicioDTO> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<ExercicioDTO> exercicios) {
        this.exercicios = exercicios;
    }
    

    public List<DiaTreinoDTO> dias() {

        return dias;

    }


    public String getNomeDia() {

        return nomeDia;

    }
    // Setter for dias

    public void setDias(List<DiaTreinoDTO> dias) {

        this.dias = dias;

    }


    public String getDiaSemana() {

        return diaSemana;

    }


    public void setDiaSemana(String diaSemana) {

        this.diaSemana = diaSemana;
    }




    public String getGrupoMuscular() {
        return grupomuscular.getGrupoMuscular();
    }

    public String getEnfase() {
        return grupomuscular.getEnfase();
    }

}
