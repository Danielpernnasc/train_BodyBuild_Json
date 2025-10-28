
package com.treino.application.plan;



import java.util.List;

import java.util.Map;

import com.treino.domain.model.Exercicios;



public interface TrainingPlan {

    Map<String, List<Exercicios>> buildSchedule();

    Map<String, String> buildDescriptions();

}
