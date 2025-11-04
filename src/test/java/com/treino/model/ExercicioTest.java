package com.treino.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.treino.domain.model.Exercicio;

public class ExercicioTest {
    private static ObjectMapper mapper() {
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return om;
    }

    @Test
    @DisplayName("Teste de serialização/deserialização de Exercicio")
    public void testSerializationDeserialization() {
        Exercicio exercicio = new Exercicio();
        exercicio.setTreino("Supino Reto");
        exercicio.setSeries(4);
        exercicio.setRepeticoes("10");
        exercicio.setDescanso("60s");
        exercicio.setObservacoes("Manter postura correta");
       try{
        // Serialização
        ObjectMapper objectMapper = mapper();
        String jsonString = objectMapper.writeValueAsString(exercicio);
        System.out.println("Serialized JSON: " + jsonString);

        // Deserialização
        Exercicio deserializedExercicio = objectMapper.readValue(jsonString, Exercicio.class);

        // Verificações
        assert exercicio.getTreino().equals(deserializedExercicio.getTreino());
        assert exercicio.getSeries().equals(deserializedExercicio.getSeries());
        assert exercicio.getRepeticoes().equals(deserializedExercicio.getRepeticoes());
        assert exercicio.getDescanso().equals(deserializedExercicio.getDescanso());
        assert exercicio.getObservacoes().equals(deserializedExercicio.getObservacoes());
       } catch (Exception e) {
           e.printStackTrace();
           assert false : "Exception during serialization/deserialization test";                            
       }
    }

}