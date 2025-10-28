package com.treino.application.plan;

import java.util.List;
import java.util.Map;

import com.treino.domain.model.Exercicios;

public class TrainNatural  implements  Treino{
    public Map<String, List<Exercicios>> getTrainNatural(){

        rotineTrainNatural();

        treinos.put("Segunda", List.of(
            new Exercicios("Barra fixa ou puxada alta", 4, "10", "90s", "Foco na contração máxima."),
            new Exercicios("Remada unilateral", 4, "10", "75s", "Controle total do movimento."),
            new Exercicios("Pulldown pegada neutra", 3, "12", "60s", "2s isometria e drop até a falha"),
            new Exercicios("Coice no cabo ou máquina (gluteo médio)", 3, "15", "60s", "Foco na contração máxima."),
            new Exercicios("Abdutora lateral", 3, "20", "60s", "Foco na contração máxima."),
            new Exercicios("Abdominal infra + prancha", 3, "20 + 30 segundo na prancha", "60s", "Foco na contração máxima.")
        ));

        treinos.put("Terça", List.of(
            new Exercicios("Supino inclinado com halter", 4, "10", "90s", "Foco na contração máxima."),
            new Exercicios("Crossover com contraçao no final", 3, "15", "60s", "Foco na contração máxima."),
            new Exercicios("Rosca alternada", 3, "12", "60s", "2s isometria e drop até a falha"),
            new Exercicios("Rosca Martelo", 3, "15", "60s", "Foco na contração máxima."),
            new Exercicios("Abdominal obliquo", 3, "20 cada lado", "30s", "Foco na contração máxima.")
        ));

        treinos.put("Quarta", List.of(
            new Exercicios("Stiff com barra ou halteres", 4, "10", "90s", "Descida controlada, foco na contração máxima."),
            new Exercicios("Mesa flexora", 4, "15", "60s", "2s isometria e drop até a falha"),
            new Exercicios("Passa longa para trás", 3, "10 por perna", "60s", "Concentração na descida."),
            new Exercicios("Prança com elevação alternada de perna", 3, "30", "60s", "velocidade normal ao fazer o movimento"),
            new Exercicios("Elevação de pernas na barra", 3, "15", "60s", "Controle na velocidade do movimento.")
        ));

        treinos.put("Quinta", List.of(
            new Exercicios("Caminhada rápida ou corrida leve", 1, "20-30 minutos", "N/A", "Manter ritmo confortável."),
            new Exercicios("Alongamentos e mobilidade para quadril e lombar ", 1, "15 minutos", "N/A", "Focar em amplitude de movimento."),
            new Exercicios("Prancha lateral + prancha tradicional", 3, "30 segundos cada", "N/A", "Manter postura correta.")
        ));

        treinos.put("Sexta", List.of(
            new Exercicios("Elevação lateral 21(7 reps curtas + 7 meia amplitude + 7 completas)", 3, "21", "60s", "Foco na contração máxima."),
            new Exercicios("Desenvolvimento Arnold", 3, "12", "60s", "Foco na contração máxima."),
            new Exercicios("Tríceps corda", 3, "15", "60s", "2s isometria e drop até a falha"),
            new Exercicios("Tríceps coice", 3, "15", "60s", "Foco na contração máxima."),
            new Exercicios("Abdominal com carga no cross", 3, "15", "60s", "Foco na contração máxima.")
        ));

        treinos.put("Sábado", List.of(
            new Exercicios("Agachamento frontal ou livre", 4, "10", "90s", "Descida controlada, foco na contração máxima."),
            new Exercicios("Leg press 45°", 4, "12", "60s", "2s isometria e drop até a falha"),
            new Exercicios("Avanço com halteres", 3, "10 por perna", "60s", "Concentração na descida."),
            new Exercicios("Cadeira extensora (drop set na última série)", 3, "15", "30s", "Controle na velocidade do movimento."),
            new Exercicios("Glúteo no cabo ou máquina", 3, "20 por perna", "30s", "Foco na contração máxima.")
        ));

        treinos.put("Domingo", List.of(
            new Exercicios("Descanso total", 0, "N/A", "N/A", "Recuperação muscular.")
        ));
        
        return treinos;
    }

    public void rotineTrainNatural() {
        descricaoDia.put("Segunda", "Costas + Glúteo Médio + Abdômen");	
        descricaoDia.put("Terça", "Peito + Bíceps + Abdômen");
        descricaoDia.put("Quarta", "Posterior de Coxa + Quadríceps + Panturrilha");
        descricaoDia.put("Quinta", "Descanso ativo (cárdio leve + mobilidade + core)");
        descricaoDia.put("Sexta", "Ombros + Triceps + Abdômen");
        descricaoDia.put("Sábado", "Quadríceps + Glúteos");
        descricaoDia.put("Domingo", "Descanso total");
    }

    
}
