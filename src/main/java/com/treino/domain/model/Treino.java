package com.treino.domain.model;

import java.util.ArrayList;
import java.util.List;

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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)  // ✅ Adicione esta linha
    private Long id;
    

    @Column(name = "TREINO", nullable = false, length = 120)
    private String nomeTreino;

    @Column(name = "CATEGORIA", length = 100)
    private String categoria;

    @Column(name = "DESCRICAO", length = 500)
    private String descricao;

    @Column(name = "CREATED_AT")
    private java.time.LocalDateTime createdAt;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DiaTreino> diasTreino = new ArrayList<>();

    public Treino() {
    }

    public void addDia(DiaTreino d) {
        d.setTreino(this);
        diasTreino.add(d);
    }

    @jakarta.persistence.PrePersist
    public void prePersist() {
        // Se createdAt ainda não foi definido manualmente,
        // define a data/hora atual no momento do INSERT.
        if (this.createdAt == null) {
            this.createdAt = java.time.LocalDateTime.now();
        }
    }


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
