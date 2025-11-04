package com.treino.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

import com.treino.domain.model.Treino; // Ensure this import matches the actual package of the Treino class
import com.treino.domain.model.DiaTreino;

public class TreinoTest {
    private static ObjectMapper mapper() {
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return om;
    }

    @Test
    @DisplayName("prePersist: deve setar createdAt quando estiver null")
    void prePersist_setsCreatedAtWhenNull() {
        Treino t = new Treino();
        t.setNomeTreino("Natural Strength Plan");

        assertNull(t.getCreatedAt(), "createdAt deve iniciar null");

        // simula o ciclo do JPA
        t.prePersist();

        assertNotNull(t.getCreatedAt(), "prePersist deve preencher createdAt");
        // createdAt muito próximo de agora (tolerância simples)
        assertTrue(t.getCreatedAt().isBefore(LocalDateTime.now().plusSeconds(2)));
    }

    @Test
    @DisplayName("prePersist: não deve sobrescrever createdAt já definido manualmente")
    void prePersist_doesNotOverrideWhenPresent() {
        Treino t = new Treino();
        LocalDateTime dt = LocalDateTime.of(2025, 11, 2, 12, 0);
        t.setCreatedAt(dt);

        t.prePersist();

        assertEquals(dt, t.getCreatedAt(), "prePersist não pode sobrescrever createdAt existente");
    }

    @Test
    @DisplayName("addDia: vincula os dois lados (Treino <-> DiaTreino)")
    void addDia_linksBothSides() {
        Treino t = new Treino();
        t.setNomeTreino("Teste");

        DiaTreino d = new DiaTreino();
        d.setDiaSemana("Segunda");

        assertNull(d.getTreino(), "Antes do addDia, o DiaTreino não deve ter treino setado");
        assertEquals(0, t.getDiasTreino().size(), "Lista inicia vazia");

        t.addDia(d);

        assertEquals(1, t.getDiasTreino().size(), "addDia deve incluir o dia na lista");
        assertSame(t, d.getTreino(), "addDia deve setar o Treino dentro do DiaTreino");
    }

    @Test
    @DisplayName("JSON: id é READ_ONLY (ignorado na desserialização) e presente na serialização")
    void json_idReadOnly() throws Exception {
        ObjectMapper om = mapper();

        // --- desserialização (entrada) com id não deve popular o campo ---
        String jsonEntrada = """
            {
              "id": 999,
              "nomeTreino": "X",
              "categoria": "Y",
              "descricao": "Z"
            }
            """;
        Treino t = om.readValue(jsonEntrada, Treino.class);

        assertNull(t.getId(), "id deve ser ignorado na desserialização (READ_ONLY)");
        assertEquals("X", t.getNomeTreino());

        // --- serialização (saída) deve exibir id quando preenchido ---
        t.setId(42L);
        t.setCreatedAt(LocalDateTime.of(2025, 11, 2, 12, 0));

        String jsonSaida = om.writeValueAsString(t);
        // Verificações simples de conteúdo
        assertTrue(jsonSaida.contains("\"id\":42"), "serialização deve incluir o id");
        assertTrue(jsonSaida.contains("\"nomeTreino\":\"X\""));
    }
 
}
