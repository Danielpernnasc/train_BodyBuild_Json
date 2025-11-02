package com.treino.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "TREINO")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_treino")
    @SequenceGenerator(name = "seq_treino", sequenceName = "SEQ_TREINO", allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    

    @Column(name = "TREINO", nullable = false, length = 120)
    private String nomeTreino;

    @Column(name = "CATEGORIA", length = 100)
    private String categoria;

    @Column(name = "DESCRICAO", length = 500)
    private String descricao;

    @Column(name = "CREATED_AT")
    private java.time.LocalDateTime createdAt;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DiaTreino> diasTreino = new ArrayList<>();


    // public void addDia(DiaTreino d) {
    //     d.setTreino(this);
    //     diasTreino.add(d);
    // }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeTreino() { return nomeTreino; }
    public void setNomeTreino(String nomeTreino) { this.nomeTreino = nomeTreino; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public java.time.LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.time.LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<DiaTreino> getDiasTreino() { return diasTreino; }
    public void setDiasTreino(List<DiaTreino> diasTreino) { this.diasTreino = diasTreino; }


}
