package com.treino.domain;

import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "TREINO_ID") // existe no seu schema
    private Treino treino;

    @Column(name = "DIA_SEMANA", nullable = false, length = 20)
    private String diaSemana; // ex: "SEGUNDA", "TERÇA", etc. (pode virar enum depois)

    @Column(name = "GRUPO_MUSCULAR", length = 60)
    private String grupoMuscular; // ex: “Peito/Tríceps”

    @Column(name = "ENFASE", length = 60)
    private String enfase; // ex: “Força”, “Volume”, “Resistência”

    @OneToMany(mappedBy = "diaTreino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<com.treino.domain.model.Exercicios> exercicios = new ArrayList<>();

    // getters/setters
    public Long getId() { return id; }
    public Treino getTreino() { return treino; }
    public void setTreino(Treino treino) { this.treino = treino; }

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public String getGrupoMuscular() { return grupoMuscular; }
    public void setGrupoMuscular(String grupoMuscular) { this.grupoMuscular = grupoMuscular; }

    public String getEnfase() { return enfase; }
    public void setEnfase(String enfase) { this.enfase = enfase; }

    public List<com.treino.domain.model.Exercicios> getExercicios() { return exercicios; }
    public void setExercicios(List<com.treino.domain.model.Exercicios> exercicios) { this.exercicios = exercicios; }

    public void addExercicio(com.treino.domain.model.Exercicios e) {
        e.setDiaTreino(this);
        exercicios.add(e);
    }
}
