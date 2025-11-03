package com.treino.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "DIA_TREINO")
public class DiaTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dia_treino")
    @SequenceGenerator(name = "seq_dia_treino", sequenceName = "SEQ_DIA_TREINO", allocationSize = 1)
    @Column(name = "ID")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "TREINO_ID")
    @com.fasterxml.jackson.annotation.JsonIgnore // mantenha só isso no lado ManyToOne
    private Treino treino;

    @Column(name = "DIA_SEMANA", nullable = false, length = 20)
    private String diaSemana;

    @Column(name = "GRUPO_MUSCULAR", length = 60)
    private String grupoMuscular;

    @Column(name = "ENFASE", length = 60)
    private String enfase;

    //@JsonManagedReference //Evita o loop com Exercicio
    // @JsonManagedReference("dia-exs")
    @OneToMany(mappedBy = "diaTreino", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Exercicio> exercicios = new ArrayList<>();
    
    public void addExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
        exercicio.setDiaTreino(this); 

    }

    public DiaTreino() {
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

  
    public List<Exercicio> getExercicios() {

        return exercicios;

    }



    public void setExercicios(List<Exercicio> exercicios) {

        this.exercicios = exercicios;

    }

 
}
