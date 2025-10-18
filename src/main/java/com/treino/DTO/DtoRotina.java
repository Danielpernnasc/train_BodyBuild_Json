package com.treino.DTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.treino.model.Exercicios;
import com.treino.model.TrainMensPhysique;
import com.treino.model.Treino;
import com.treino.service.TreinoService;

@Component
public class DtoRotina implements Treino {
    private final TreinoService treinoService;

    public DtoRotina(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    public Map<String, Object> rotinaTrain(){
        DayOfWeek diaSemana = LocalDate.now().getDayOfWeek();
        String dia = treinoService.converterDia(diaSemana);
        
        List<Exercicios> treinoDoDiaList = treinoService.getTreinoDoDia();
        String descricao = TrainMensPhysique.descricaoDia.getOrDefault(dia, "Dia de descanso ou atividade leve");

        // monta o JSON
            Map<String, Object> resposta = new LinkedHashMap<>();
            resposta.put("tipoTreino", Treino.descricaoTreino.get("Tipo de Treino"));
            resposta.put("dia", dia);
            resposta.put("descricao", descricao);
            resposta.put("exercicios", treinoDoDiaList != null ? treinoDoDiaList : Collections.emptyList());

            return resposta;
    }
}
