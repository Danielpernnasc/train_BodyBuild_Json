// src/main/java/com/treino/DTO/ExercicioResponse.java
package com.treino.DTO;

public class ExercicioResponse {
  private Long id, diaTreinoId;
  private String treino, repeticoes, descanso, observacoes;
  private Integer series;

  public ExercicioResponse(Long id, Long diaTreinoId, String treino,
                           Integer series, String repeticoes, String descanso, String observacoes) {
    this.id = id; this.diaTreinoId = diaTreinoId; this.treino = treino;
    this.series = series; this.repeticoes = repeticoes; this.descanso = descanso; this.observacoes = observacoes;
  }
  public Long getId() { return id; }
  public Long getDiaTreinoId() { return diaTreinoId; }
  public String getTreino() { return treino; }
  public Integer getSeries() { return series; }
  public String getRepeticoes() { return repeticoes; }
  public String getDescanso() { return descanso; }
  public String getObservacoes() { return observacoes; }
}
