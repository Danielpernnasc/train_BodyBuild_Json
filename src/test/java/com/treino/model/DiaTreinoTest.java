package com.treino.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.treino.domain.model.DiaTreino;
import com.treino.domain.model.Exercicio;
import com.treino.domain.model.Treino;

public class DiaTreinoTest {
     private static ObjectMapper mapper() {
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return om;
    }

    @Test
    @DisplayName("addExercicio: vincula os dois lados (DiaTreino <-> Exercicio)")
    public void testAddExercicio() {
        DiaTreino dt = new DiaTreino();
        dt.setDiaSemana("Segunda-feira");
        Exercicio ex = new Exercicio();
        ex.setTreino("Supino Reto"); // Correctly formatted string and statement
        
        assertNull(ex.getDiaTreino(), "Exercicio não deve ter referência ao DiaTreino antes da adição");
        assertEquals(0, dt.getExercicios().size(), "DiaTreino deve conter o Exercicio adicionado");
        
        dt.addExercicio(ex);

        assertEquals(1, dt.getExercicios().size(), "DiaTreino deve conter o Exercicio adicionado");

        assertEquals(dt, ex.getDiaTreino(), "Exercicio deve ter referência ao DiaTreino após adição");
        
      
    }


    @Test
    @DisplayName("JSON: id é READ_ONLY (ignorado na desserialização) e presente na serialização")
    void json_idReadOnly() throws Exception {
        ObjectMapper om = mapper();

        // id no input deve ser ignorado
        String in = """
            {
              "id": 999,
              "diaSemana": "Terça",
              "grupoMuscular": "Costas",
              "enfase": "Largura"
            }
            """;
        DiaTreino dia = om.readValue(in, DiaTreino.class);

        assertNull(dia.getId(), "id deve ser ignorado na desserialização (READ_ONLY)");
        assertEquals("Terça", dia.getDiaSemana());

        // id na saída deve aparecer quando setado
        // (simulando que o JPA populou o id)
        var field = DiaTreino.class.getDeclaredField("id");
        field.setAccessible(true);
        field.set(dia, 42L);

        String out = om.writeValueAsString(dia);
        assertTrue(out.contains("\"id\":42"), "serialização deve incluir o id");
    }

    @Test
    @DisplayName("JSON: 'treino' é ignorado na serialização (por @JsonIgnore no ManyToOne)")
    void json_treinoIsIgnored() throws Exception {
        ObjectMapper om = mapper();

        Treino t = new Treino();
        t.setNomeTreino("Natural Strength Plan");

        DiaTreino dia = new DiaTreino();
        dia.setDiaSemana("Quarta");
        dia.setTreino(t); // ManyToOne com @JsonIgnore

        String json = om.writeValueAsString(dia);

        assertFalse(json.contains("treino"), "campo 'treino' não deve aparecer no JSON");
        assertTrue(json.contains("\"diaSemana\":\"Quarta\""));
    }

    @Test
    @DisplayName("JSON: lista de exercícios aparece e sem referência cíclica")
    void json_exerciciosSerializeOk() throws Exception {
        ObjectMapper om = mapper();

        DiaTreino dia = new DiaTreino();
        dia.setDiaSemana("Quinta");

        Exercicio ex1 = new Exercicio();
        ex1.setTreino("Remada curvada");
        dia.addExercicio(ex1);

        Exercicio ex2 = new Exercicio();
        ex2.setTreino("Puxada frente");
        dia.addExercicio(ex2);

        String json = om.writeValueAsString(dia);

        // deve conter a lista "exercicios" e os nomes, sem loops
        assertTrue(json.contains("\"exercicios\""), "JSON deve conter a lista de exercícios");
        assertTrue(json.contains("Remada curvada"));
        assertTrue(json.contains("Puxada frente"));
        // não deve serializar diaTreino dentro de cada Exercicio (para evitar loop)
        assertFalse(json.contains("diaTreino"), "Exercicio não deve serializar o back-reference");
    }

    
}
