package com.treino.domain;

import java.util.ArrayList;
import java.util.List;

import com.treino.domain.model.Exercicios;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TREINO")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // funciona com IDENTITY/SEQUENCE do Oracle
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 120)
    private String nome;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiaTreino> dias = new ArrayList<>();

    public void addDia(DiaTreino d) {
        d.setTreino(this);
        dias.add(d);
    }

    public void addExercicio(DiaTreino d, Exercicios e) {
        d.setTreino(this);
        e.setDiaTreino(d);
        d.getExercicios().add(e);
        if (!dias.contains(d)) {
            dias.add(d);
        }
    }

    // getters/setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<DiaTreino> getDias() { return dias; }
    public void setDias(List<DiaTreino> dias) { this.dias = dias; }
}
