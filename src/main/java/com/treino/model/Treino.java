package com.treino.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Treino {

    Map<String, List<Exercicios>> treinos = new HashMap<>();
    Map<String, String> descricaoDia = new HashMap<>();
    Map<String, String> descricaoTreino = new HashMap<>();
    default void itsTrain(){
        descricaoTreino.put("Tipo de Treino", "");
    }
    
}
