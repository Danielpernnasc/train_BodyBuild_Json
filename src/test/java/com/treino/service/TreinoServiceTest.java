package com.treino.service;

import com.treino.domain.model.DiaTreino;
import com.treino.domain.model.Exercicio;
import com.treino.domain.model.Treino;
import com.treino.application.service.TreinoService;
import com.treino.domain.repository.TreinoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TreinoServiceTest {
    private TreinoRepository treinoRepository;
    private TreinoService treinoService;

    @BeforeEach
    void setUp() {
        treinoRepository = mock(TreinoRepository.class);
        treinoService = new TreinoService(treinoRepository);
    }

    @Test
    void testCriarTreinoComDiasEExercicios() {
        Treino treino = new Treino();
        treino.setNomeTreino("Treino A");
        treino.setCategoria("Categoria A");
        treino.setDescricao("Desc");

        DiaTreino dia = new DiaTreino();
        dia.setDiaSemana("Segunda");
        dia.setGrupoMuscular("Peito");
        dia.setEnfase("Hipertrofia");

        Exercicio ex = new Exercicio();
        ex.setTreino("Supino");
        ex.setSeries(4);
        ex.setRepeticoes("8-10");
        ex.setDescanso("90s");
        ex.setObservacoes("Foco");

        dia.setExercicios(Arrays.asList(ex));
        treino.setDiasTreino(Arrays.asList(dia));

        when(treinoRepository.save(any(Treino.class))).thenAnswer(i -> i.getArgument(0));

        Treino salvo = treinoService.criarTreinoComDiasEExercicios(treino);

        assertEquals("Treino A", salvo.getNomeTreino());
        assertEquals(1, salvo.getDiasTreino().size());
        assertEquals("Segunda", salvo.getDiasTreino().get(0).getDiaSemana());
        assertEquals("Supino", salvo.getDiasTreino().get(0).getExercicios().get(0).getTreino());
        verify(treinoRepository, times(1)).save(any(Treino.class));
    }

    
    @Test
    void testListar() {
        Treino treino = new Treino();
        when(treinoRepository.findAll()).thenReturn(Arrays.asList(treino));
        List<Treino> result = treinoService.listar();
        assertEquals(1, result.size());
        verify(treinoRepository, times(1)).findAll();
    }

    @Test
    void testBuscar() {
        Treino treino = new Treino();
        when(treinoRepository.findById(1L)).thenReturn(Optional.of(treino));
        Optional<Treino> result = treinoService.buscar(1L);
        assertTrue(result.isPresent());
        verify(treinoRepository, times(1)).findById(1L);
    }

    @Test
    void testAtualizar() {
        Treino existente = new Treino();
        existente.setId(1L);
        existente.setNomeTreino("Antigo");

        when(treinoRepository.findById(1L)).thenReturn(Optional.of(existente));

        Treino dto = new Treino();
        dto.setNomeTreino("Novo");
        dto.setCategoria("NovaCat");
        dto.setDescricao("NovaDesc");

        Treino atualizado = treinoService.atualizar(1L, dto);

        assertEquals("Novo", atualizado.getNomeTreino());
        assertEquals("NovaCat", atualizado.getCategoria());
        assertEquals("NovaDesc", atualizado.getDescricao());
        verify(treinoRepository, times(1)).findById(1L);
    }

    @Test
    void testDeletar() {
        doNothing().when(treinoRepository).deleteById(1L);
        treinoService.deletar(1L);
        verify(treinoRepository, times(1)).deleteById(1L);
    }

}