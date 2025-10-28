package com.treino.application.plan;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.treino.domain.model.Exercicios;



public class TrainClassicPhysique implements Treino {
   


     public Map<String, List<Exercicios>> getTrainClassicPhysique()  {
        
        rotineTrainclassicPhysique();
        treinos.put("Segunda", Arrays.asList(
            new Exercicios("Supino reto barra", 4, "8-10", "90s", "1ª leve, últimas 2 até falha."),
            new Exercicios("Supino Inclinado halteres", 4, "10-12", "75s", "Concentração máxima no pico."),
            new Exercicios("Crucifixo inclinado máquina", 3, "12-15", "60s", "2s contração / 3s descida."),
            new Exercicios("Crossover alto → baixo", 3, "15", "75s", "Pump final."),
            new Exercicios("Desenvolvimento militar barra", 4, "8-10", "60s", "Técnica controlada."),
            new Exercicios("Elevação frontal halteres", 3, "12", "60s", "Superset com lateral."),
            new Exercicios("Elevação lateral halteres", 3, "12", "60s", "Rest-pause na ultima série.")
        ));

        treinos.put("Terça", Arrays.asList(
            new Exercicios("Barra fixa (pegada aberta)", 4,"8-12", "90s", "Aquecimento + falha controlada."),
            new Exercicios("Puxada frente pegada média", 4, "10-12", "90s", "Contração de 1s no final."),
            new Exercicios("Remada curvada barra", 4, "8-10", "75s", "Estilo Cbum — pesada e técnica."),
            new Exercicios("Remada unilateral halter", 3, "10-12", "60s", "Alongar ao máximo."),
            new Exercicios("Abdômen na polia alta", 4, "15", "60s", "Contrair forte."),
            new Exercicios("Prancha + elevação de pernas", 3, "30s + 15", "45s", "Estilo Classic.")
        ));

        treinos.put("Quarta", Arrays.asList(
            new Exercicios("Extensora (pré-exaustão)", 4, "20/15/12/10", "60s", "1ª leve, últimas 2 até falha"),
            new Exercicios("Agachamento livre", 4, "8-10", "90s", "Profundidade total."),
            new Exercicios("Leg press 45°", 4, "10-12", "75s", "Pés juntos/foco no vasto lateral."),
            new Exercicios("Hack squat", 3, "10-12", "60s", "3s descida."),
            new Exercicios("Panturrilha com halteres", 3, "12 cada perna", "45s", "Queima total."),
            new Exercicios("Panturrilha em pé", 4, "15", "60s", "Pausa de 1s no topo")
        
        ));

        treinos.put("Quinta", Arrays.asList(
            new Exercicios("Desenvolvimento halteres", 4, "8-12", "60s", "Drop na última."),
            new Exercicios("Elevação lateral polia", 4, "12-15", "60s", "Controle total."),
            new Exercicios("Elevação posterior banco 45°", 3, "12-15", "60s", "Estilo Caike (detalhe deltóide)."),
            new Exercicios("Encolhimento barra", 3, "15", "60s", "Trapézio."),
            new Exercicios("Tríceps corda", 4, "12", "60s", "Aquecimento."),
            new Exercicios("Tríceps francês", 4, "8-10", "75s", "Pesado."),
            new Exercicios("Mergulho máquina ou peso corporal", 3, "12 - 15", "60s", "Falha técnica.")

        ));

        treinos.put("Sexta", Arrays.asList(
            new Exercicios("Levantamento terra", 4, "6-8", "120s", "Densidade e força."),
            new Exercicios("Puxada neutra", 4, "10–12", "90s", "Contração total."),
            new Exercicios("Remada baixa cabo", 3, "12", "60s", "2s isometria."),
            new Exercicios("Pulldown unilateral", 3, "12", "60s", "Movimento Controlado."),
            new Exercicios("Rosca alternadas halteres", 3, "10-12", "75s", "Superset Martelo."),
            new Exercicios("Rosca martelo cabo", 3, "12-15", "60s", "Pump final.")
        ));

        treinos.put("Sábado", Arrays.asList(
            new Exercicios("Cadeira Flexora", 4, "15/12/10/8", "60s", "Rest-pause."),
            new Exercicios("Stiff halteres", 4, "8-10", "45s", "3s descida."),
            new Exercicios("Levantamento terra romeno", 3, "8-10", "45s", "Foco glúteo / posterior."),
            new Exercicios("Glute bridge", 3, "12-15", "60s", "Contração máxima."),
            new Exercicios("Adutor / abdutor máquina", 3, "12-15", "60s", "SuperSet."),
            new Exercicios("Panturrilha sentado", 4, "15", "60s", "2s no pico.")
        ));

        treinos.put("Domingo", Arrays.asList(
            new Exercicios("Descanso ativo", 0, "-", "-", "Caminhada leve, alongamento ou yoga.")
        ));
        return treinos;

    }


    public void rotineTrainclassicPhysique() {
        descricaoDia.put("Segunda", "Dia de Peito/Ombros");
        descricaoDia.put("Terça", "Costas e Abdômen");
        descricaoDia.put("Quarta", "Quadriceps");
        descricaoDia.put("Quinta", "Ombros e Tríceps");
        descricaoDia.put("Sexta", "Costa e Bíceps");
        descricaoDia.put("Sábado", "Pernas B (Posterior/Glúteos/Panturrilha)");
        descricaoDia.put("Domingo", "Descanso");
    }


}
