package com.treino.application.plan;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.treino.domain.model.Exercicios;

public class TrainNaturalPlan implements TrainingPlan {


  @Override
  public Map<String, List<Exercicios>> buildSchedule() {
    Map<String, List<Exercicios>> dias = new LinkedHashMap<>();
    dias.put("Segunda", List.of(
        new Exercicios("Barra fixa ou puxada alta", 4, "10", "90s", "Foco na contração máxima."),
        new Exercicios("Remada unilateral", 4, "10", "75s", "Controle total do movimento."),
        new Exercicios("Pulldown pegada neutra", 3, "12", "60s", "2s isometria e drop até a falha"),
        new Exercicios("Coice no cabo ou máquina (gluteo médio)", 3, "15", "60s", "Foco na contração máxima."),
        new Exercicios("Abdutora lateral", 3, "20", "60s", "Foco na contração máxima."),
        new Exercicios("Abdominal infra + prancha", 3, "20 + 30 segundo na prancha", "60s", "Foco na contração máxima.")
    ));
    dias.put("Terça", List.of(
        new Exercicios("Supino inclinado com halter", 4, "10", "90s", "Foco na contração máxima."),
        new Exercicios("Crossover com contraçao no final", 3, "15", "60s", "Foco na contração máxima."),
        new Exercicios("Rosca alternada", 3, "12", "60s", "2s isometria e drop até a falha"),
        new Exercicios("Rosca Martelo", 3, "15", "60s", "Foco na contração máxima."),
        new Exercicios("Abdominal obliquo", 3, "20 cada lado", "30s", "Foco na contração máxima.")
    ));
    dias.put("Quarta". List.of)
    // ... demais dia
    return Collections.unmodifiableMap(dias);
  }

  @Override
  public Map<String, String> buildDescriptions() {
    return Map.of(
      "Segunda", "Dia de Peito/Ombros",
      "Terça",   "Costas e Abdômen"
      // ...
    );
  }
    
}
