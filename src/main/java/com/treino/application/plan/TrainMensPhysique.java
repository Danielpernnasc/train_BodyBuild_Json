package com.treino.application.plan;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.treino.domain.model.Exercicios;

public class TrainMensPhysique implements Treino {


    public Map<String, List<Exercicios>> getTrainMensPhysique() {

        RotinaMensPhysique();

        treinos.put("Segunda", Arrays.asList(
            new Exercicios("Supino Reto barra", 4, "8-10", "90s", "Manter os pés no chão e a coluna neutra."),
            new Exercicios("Supino Inclinado halteres", 4, "10-12", "75s", "Controlar a descida dos halteres."),
            new Exercicios("Crossover polia alta", 3, "12-15", "60s", "Evitar sobrecarga nos ombros."),
            new Exercicios("Mergulho paralelas", 3, "10-12", "75s", "Manter o tronco levemente inclinado para frente."),
            new Exercicios("Tríceps testa barra W", 3, "10-12", "75s", "Evitar hiperextensão dos cotovelos."),
            new Exercicios("Tríceps corda polia alta", 3, "12-15", "60s", "Manter os cotovelos fixos ao lado do corpo.")
        ));

        treinos.put("Terça", Arrays.asList(
            new Exercicios("Puxada frente pegada aberta", 4,"10-12", "90", "Pegar nas ates inclinar o tronco para trás e puxar contra o peito"),
            new Exercicios("Remada curvada com barra", 4, "8-10", "90s", "Manter a coluna neutra durante o movimento."),
            new Exercicios("Remada unilateral com halteres", 3, "10-12", "75s", "Evitar girar o tronco durante o movimento."),
            new Exercicios("Rosca direta barra reta", 3, "10", "60s", "Manter os cotovelos fixos ao lado do corpo."),
            new Exercicios("Rosca alternada c/ rotação", 3, "12", "60s", "Controlar a descida dos halteres."),
            new Exercicios("Rosca martelo", 2, "15", "45s", "Manter os punhos neutros durante o movimento.")
        ));


        treinos.put("Quarta", Arrays.asList(
            new Exercicios("Descanso total ou outra atividade", 0, "", "", "Cross fit a noite")
        ));

        treinos.put("Quinta", Arrays.asList(
          new Exercicios("Cardio leve/moderado 30-45 min", 0, "", "", ""),
          new Exercicios("Abdominal infra banco", 3, "20", "45s", "Deitar no cochonete com as maos na cabeça elevar o tronco na cotra a pernas flexionadas"),
          new Exercicios("Prancha", 3, "45s", "45s", "Posição de ponte com apoio dos contovelos e o gluteo enpinado"),
          new Exercicios("Abdominal lateral oblíquo", 3, "15 cada lado", "45s", "Elevar o tronco para a direita e para a esquerda")
        ));

        treinos.put("Sexta", Arrays.asList(
            new Exercicios("Cadeira flexora", 4, "12", "60s", "Sentar na cadeixar e baixar os tornozelos com peso"),
            new Exercicios("Stiff halteres", 4, "10–12", "90s", "Juntar os pes abrir os calcanhares e depois as ponta do pes. Depois so descer"),
            new Exercicios("Agachamento livre/smith", 3, "8–10", "90s", "Barra no trapézio, descer até 90 graus e subir"),
            new Exercicios("Leg press", 3, "12", "75s", "Sentado no legPress e empurrar a plataforma com os calcanhares"),
            new Exercicios("Cadeira extensora", 3, "15", "60s", "Levantar os tornozelos com pesos sentando na cadeira"),
            new Exercicios("Panturrilha em pé", 4, "20", "45s", "elevação da panturrilhas")
        ));

        treinos.put("Sábado", Arrays.asList(
            new Exercicios("Desenvolvimento halteres", 4, "8–10", "90s", "Levantar os pesos sobre a cabeça"),
            new Exercicios("Elevação lateral", 4, "12–15", "60s", "Levantar os pesos com os braços levemente flexionados na lateral"),
            new Exercicios("Elevação frontal alternada", 3, "12", "60s", "Levantar os peso com os braços esticados"),
            new Exercicios("Crucifixo invertido", 3, "15", "60s", "sentar da maquina e abrir os braços"),
            new Exercicios("Encolhimento halteres", 3, "12–15", "60s", "com os halteres so encolher os ombros")
        ));

        treinos.put("Domingo", Arrays.asList(
            new Exercicios("Descanso", 0, "", "", "tire o dia para descansar ou fazer alguma atividade leve com caminhada no parque ou praça")
        ));
        return treinos;
    }
    
    public void RotinaMensPhysique() {
        // ... seu código já existente que preenche treinos ...
        descricaoDia.put("Segunda-Feira", "Dia de Peito");
        descricaoDia.put("Terça", "Costas e Bíceps");
        descricaoDia.put("Quarta", "Descanso / Cardio leve");
        descricaoDia.put("Quinta", "Abdômen e Core");
        descricaoDia.put("Sexta", "Pernas");
        descricaoDia.put("Sábado", "Ombros e Trapézio");
        descricaoDia.put("Domingo", "Descanso");
    }

}
