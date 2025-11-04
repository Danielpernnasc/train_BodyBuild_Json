package com.treino.api.controller;

import com.treino.application.service.TreinoService;
import com.treino.domain.model.Treino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Este teste NÃO usa ApplicationContext.
// Evita por completo os erros de WebMvcTest/Security.
@ExtendWith(MockitoExtension.class)
class TreinosControllerTest {

    @Mock
    private TreinoService treinoService;

    @InjectMocks
    private TreinosController controller;

    private MockMvc mockMvc;
    private Treino treino;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();

        treino = new Treino();
        treino.setId(1L);
        treino.setNomeTreino("Treino Teste");
    }

    @Test
    void criarDeveRetornar201() throws Exception {
        when(treinoService.criarTreinoComDiasEExercicios(any(Treino.class)))
                .thenReturn(treino);

        mockMvc.perform(post("/api/treinos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nomeTreino\":\"Treino Teste\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nomeTreino").value("Treino Teste"));

        verify(treinoService, times(1)).criarTreinoComDiasEExercicios(ArgumentMatchers.any(Treino.class));
    }

    @Test
    void listarDeveRetornar200() throws Exception {
        when(treinoService.listar()).thenReturn(Collections.singletonList(treino));

        mockMvc.perform(get("/api/treinos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomeTreino").value("Treino Teste"));
    }

    @Test
    void buscarDeveRetornar200QuandoEncontrado() throws Exception {
        when(treinoService.buscar(1L)).thenReturn(Optional.of(treino));

        mockMvc.perform(get("/api/treinos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomeTreino").value("Treino Teste"));
    }

    @Test
    void buscarDeveRetornar404QuandoNaoEncontrado() throws Exception {
        when(treinoService.buscar(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/treinos/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    void atualizarDeveRetornar200QuandoEncontrado() throws Exception {
        when(treinoService.atualizar(eq(1L), any(Treino.class))).thenReturn(treino);

        mockMvc.perform(put("/api/treinos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nomeTreino\":\"Treino Teste\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomeTreino").value("Treino Teste"));
    }

    @Test
    void atualizarDeveRetornar404QuandoNaoEncontrado() throws Exception {
        when(treinoService.atualizar(eq(2L), any(Treino.class)))
                .thenThrow(new IllegalArgumentException("Treino 2 não encontrado"));

        mockMvc.perform(put("/api/treinos/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nomeTreino\":\"Treino Teste\"}"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deletarDeveRetornar204() throws Exception {
        doNothing().when(treinoService).deletar(1L);

        mockMvc.perform(delete("/api/treinos/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deletarDeveRetornar404QuandoNaoEncontrado() throws Exception {
        doThrow(new IllegalArgumentException("not found")).when(treinoService).deletar(2L);

        mockMvc.perform(delete("/api/treinos/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testeEndpointDeveRetornar200() throws Exception {
        mockMvc.perform(post("/api/treinos/teste"))
                .andExpect(status().isOk())
                .andExpect(content().string("Funcionou!"));
    }
}
