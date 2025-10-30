package com.treino.domain.model;

import com.treino.domain.DiaTreino;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EXERCICIO")
public class Exercicios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "DIA_TREINO_ID")
    private DiaTreino diaTreino;

    @Column(name = "treino", nullable = false, length = 120)
    private String treino;

    @Column(name = "SERIES", nullable = false)
    private Integer series;

    @Column(name = "REPETICOES", nullable = false, length = 20)
    private String repeticoes;

    @Column(name = "DESCANSO", length = 20)
    private String descanso;

    @Column(name = "OBSERVACOES", length = 255)
    private String observacoes;

    // getters/setters
    public Long getId() { return id; }
    public DiaTreino getDiaTreino() { return diaTreino; }
    public void setDiaTreino(DiaTreino diaTreino) { this.diaTreino = diaTreino; }
    public String getTreino() { return treino; }
    public void setTreino(String treino) { this.treino = treino; }
    public Integer getSeries() { return series; }
    public void setSeries(Integer series) { this.series = series; }
    public String getRepeticoes() { return repeticoes; }
    public void setRepeticoes(String repeticoes) { this.repeticoes = repeticoes; }
    public String getDescanso() { return descanso; }
    public void setDescanso(String descanso) { this.descanso = descanso; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
