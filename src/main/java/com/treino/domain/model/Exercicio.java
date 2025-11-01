package com.treino.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "EXERCICIO")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DIA_TREINO_ID") // chave estrangeira existente no banco
    @JsonBackReference // Evita o loop com DiaTreino
    private DiaTreino diaTreino;

 

    @Column(name = "TREINO", length = 120)
    private String treino;

    @Column(name = "SERIES")
    private Integer series;

    @Column(name = "REPETICOES", length = 20)
    private String repeticoes;

    @Column(name = "DESCANSO", length = 10)
    private String descanso;

    @Column(name = "OBSERVACOES", length = 255)
    private String observacoes;

    public Exercicio() {}
    
    public Exercicio(Long id, DiaTreino diaTreinoId, String treino, Integer series, String repeticoes, String descanso, String observacoes) {

        this.id = id;

        this.diaTreino = diaTreinoId;

        this.treino = treino;

        this.series = series;

        this.repeticoes = repeticoes;

        this.descanso = descanso;

        this.observacoes = observacoes;

    }
   

    // Getters e Setters
    public Long getDiaTreinoId() { return id; }
    public Long getId() {

        return id;
    }



    public void setId(Long id) {

        this.id = id;

    }

    public DiaTreino getDiaTreino() { return diaTreino; }
    public void setDiaTreino(DiaTreino diaTreino) { 
        this.diaTreino = diaTreino; 
    }

   
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
