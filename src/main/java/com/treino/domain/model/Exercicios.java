package com.treino.domain.model;

public class Exercicios {
    private String nome;
    private int series;
    private String repeticoes;
    private String descanso;
    private String observacao;

    public Exercicios(String nome, int series, String repeticoes, String descanso, String observacao) {
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.descanso = descanso;
        this.observacao = observacao;
    }

    public String getNome() { return nome; }
    public int getSeries() { return series; }
    public String getRepeticoes() { return repeticoes; }
    public String getDescanso() { return descanso; }
    public String getObservacao() {
        return (observacao == null || observacao.isEmpty()) ? "Nenhuma" : observacao;
    }

    public void setNome(String nome) { this.nome = nome; }
    public void setSeries(int series) { this.series = series; }
    public void setRepeticoes(String repeticoes) { this.repeticoes = repeticoes; }
    public void setDescanso(String descanso) { this.descanso = descanso; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
}
