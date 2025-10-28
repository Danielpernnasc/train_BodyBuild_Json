package com.treino.application.plan;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.treino.domain.model.Exercicios;

public class TrainOPEN implements Treino {

    public Map<String, List<Exercicios>>  getTrainOPEN(){
        rotineTrainOPEN();

        treinos.put("Segunda", Arrays.asList(
            new Exercicios("Supino inclinado com halteres", 4, "8-10", "90s", "Foco na contração máxima."),
            new Exercicios("Crucifixo inclinado na máquina", 4, "10-12", "75s", "Controle total do movimento. focar em alongar"),
            new Exercicios("Supino reto máquina", 3, "12", "60s", "(última até falha com drop."),
            new Exercicios("Desenvolvimento como halteres sentado", 4, "10", "60s", "Técnica perfeita."),
            new Exercicios("Elevação lateral unilateral", 4, "15-20", "60s", "Foco na contração e descanço 20s entre os lados."),
            new Exercicios("Elevação frontal na corta", 3, "15", "60s", "Controle total do movimento."),
            new Exercicios("Crucifixo invertido máquina", 3, "15", "60s", "Foco no deltóide posterior.")
        ));

        treinos.put("Terça", Arrays.asList(
            new Exercicios("Puxada frente pegada média", 4, "10", "90s", "Foco na contração máxima."),
            new Exercicios("Remata curvada barra T", 4, "8-10", "75s", "Estilo Cbum — pesada e técnica. explosiva na subida, controlada na descida"),
            new Exercicios("Remada baixa na polia", 3, "12", "60s", "2s isometria e drop até a falha"),
            new Exercicios("Puxada unilateral na máquina", 4, "10", "90s", "Aquecimento + falha controlada."),
            new Exercicios("Pullover na corda", 3, "15-20", "60s", "Foco na conexão mente-músculo."),
            new Exercicios("Encolhimento com halteres", 4, "15", "60s", "Trapézio.")

        ));

        treinos.put("Quarta", Arrays.asList(
            new Exercicios("Cadeira extensora", 6, "15", "60s", "pré-exaustão, contração máxima." ),
            new Exercicios("Agachamento livre", 5, "10-12", "90s", "aumentar carga progressivamente."),
            new Exercicios("Leg press 45°", 4, "15", "75s", "Pés juntos/foco no vasto lateral drop set na ultima com ajuda."),
            new Exercicios("Cadeira flexora", 4, "12", "60s", "Isometria 2s na contracao." ),
            new Exercicios("Stiff com halteres", 4, "10", "75s", "Foco no alongamento do posterior." ),
            new Exercicios("Panturrilha em pé", 4, "15", "60s", "Pausa de 1s no topo"),
            new Exercicios("Panturrilha sentado", 4, "15-20", "45s", "Foco na contração máxima." )
        ));

        treinos.put("Quinta", Arrays.asList(
            new Exercicios("Rosca direta barra EX", 4, "10", "60s", "Técnica perfeita."),
            new Exercicios("Rosca alternada com supinação total", 4, "12", "60s", "Controle total do movimento."),
            new Exercicios("Rosca concentrada", 3, "15", "60s", "Foco na contração máxima."),
            new Exercicios("Tríceps corda", 4, "12", "60s", "Aquecimento."),
            new Exercicios("Tríceps francês com halteres", 4, "10", "75s", "Pesado."),
            new Exercicios("Mergulho máquina ou peso corporal", 3, "20", "60s", "Falha técnica."),
            new Exercicios("Antebraço rosca inversa barra W", 3, "15", "45s", "Foco na resistência.")
        ));

        treinos.put("Sexta", Arrays.asList(
            new Exercicios("Supino reto máquina pesada", 4, "8-10", "120s", "Densidade e força."),
            new Exercicios("Puxada frente pegada aberta", 4, "10", "90s", "Contração total."),
            new Exercicios("Crucifixo inclinado", 3, "12", "75s", "Estilo Cbum — pesada e técnica."),
            new Exercicios("Remada curvada barra livre", 4, "8", "60s", "Alongar ao máximo."),
            new Exercicios("Supino declinado com halteres", 3, "10", "60s", "Contrair forte."),
            new Exercicios("Remada unilateral com halter", 3, "12", "60s", "Estilo Classic."),
            new Exercicios("Pull-over com halter", 3, "15", "60s", "Contrair forte.")
        ));

        treinos.put("Sábado", Arrays.asList(
            new Exercicios("Cadeira flexora", 4, "15", "90s", "Foco na técnica e profundidade."),
            new Exercicios("Stiff máquina", 4, "10", "45s", "Alongamento total do posterior."),
            new Exercicios("Leg press pés altos e juntos", 4, "15", "60s", "Foco no glúteo."),
            new Exercicios("Glute kick na polia ou Máquina", 4, "20 cada perna", "60s", "Queima total." ),
            new Exercicios("Abdução de quadril na máquina", 4, "20", "60s", "Foco na contração máxima." ),
            new Exercicios("Panturrilha sentado", 5, "20", "60s", "Pausa de 1s no topo")
        ));

        treinos.put("Domingo", Arrays.asList(
            new Exercicios("Descanso", 0, "-", "-", "Recuperação ativa: caminhada leve, alongamento ou yoga." )

        ));

        return treinos;
        
    }

    public void rotineTrainOPEN() {
        descricaoDia.put("Segunda", "Peito e ombros (ênfase superior)");
        descricaoDia.put("Terça", "Costas e posteriores de ombro");
        descricaoDia.put("Quarta", "Pernas completas (quadríceps e posteriores)");
        descricaoDia.put("Quinta", "Braços (bíceps + tríceps)");
        descricaoDia.put("Sexta", "Peito e costas (treino combinado — densidade)");
        descricaoDia.put("Sábado", "(ênfase glúteo e posterior)");
        descricaoDia.put("Domingo", "Descanso");
    }
    
}
