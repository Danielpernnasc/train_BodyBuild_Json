package com.treino.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "DIA_TREINO")
public class DiaTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TREINO_ID")
    @JsonBackReference //Evita o loop com Treino
    private Treino treino;

    @Column(name = "DIA_SEMANA", nullable = false, length = 20)
    private String diaSemana;

    @Column(name = "GRUPO_MUSCULAR", length = 60)
    private String grupoMuscular;

    @Column(name = "ENFASE", length = 60)
    private String enfase;

    @OneToMany(mappedBy = "diaTreino", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference //Evita o loop com Exercicio
    private List<Exercicio> exercicio = new ArrayList<>();
    
    public void addExercicio(Exercicio exercicio) {
        this.exercicio.add(exercicio);
        exercicio.setDiaTreino(this); 

    }
    

    public void getIdTreino(){
        this.treino.getId();
    }

    public void getNomeTreino(){
        this.treino.getNomeTreino();
    }


    public Long getId() { return id; }
    public Treino getTreino() { return treino; }
    public void setTreino(Treino treino) { this.treino = treino; }

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public String getGrupoMuscular() { return grupoMuscular; }
    public void setGrupoMuscular(String grupoMuscular) { this.grupoMuscular = grupoMuscular; }

    public String getEnfase() { return enfase; }
    public void setEnfase(String enfase) { this.enfase = enfase; }

    public List<Exercicio> getExercicios() { return exercicio; }
    public void setExercicios(List<Exercicio> exercicio) { this.exercicio = exercicio; }

 
}
