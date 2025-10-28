package com.treino.application.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.treino.application.plan.TrainClassicPhysique;
import com.treino.application.plan.TrainMensPhysique;
import com.treino.application.plan.TrainNatural;
import com.treino.application.plan.TrainOPEN;
import com.treino.application.plan.Treino;
import com.treino.domain.model.Exercicios;



@Service
public class TreinoService implements Treino {  


    private final TrainMensPhysique trainMensPhysique = new TrainMensPhysique();

    private final TrainClassicPhysique trainClassicPhysique = new TrainClassicPhysique();

    private final TrainOPEN trainOPENPhysique = new TrainOPEN();

    private final TrainNatural trainNaturalPhysique = new TrainNatural();


    public final void oTreinoMP(){
        Map<String, List<Exercicios>> treinoMap = trainMensPhysique.getTrainMensPhysique();
        if (treinoMap != null) {
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        System.out.println("Treinos carregados: " + trainMensPhysique.getTrainMensPhysique());
        }
        trainingDescriptionFor("MensPhysique");

   
    }

    public final void oTrainCP(){
        Map<String, List<Exercicios>> treinoMap = trainClassicPhysique.getTrainClassicPhysique();
        if(treinoMap != null){
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }
        System.out.println("Treinos carregados: " + trainClassicPhysique.getTrainClassicPhysique());
        trainingDescriptionFor("ClassicPhysique");
    }

    public final void oTrainOPEN(){
        Map<String, List<Exercicios>> treinoMap = trainOPENPhysique.getTrainOPEN();
        if(treinoMap != null){
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }
        System.out.println("Treinos carregados: " + trainOPENPhysique.getTrainOPEN());
        trainingDescriptionFor("OpenPhysique");
    }

    public final void oTrainNatural(){
        Map<String, List<Exercicios>> treinoMap = trainNaturalPhysique.getTrainNatural();
        if(treinoMap != null){
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }
        System.out.println("Treinos carregados: " + trainNaturalPhysique.getTrainNatural());
        trainingDescriptionFor("NaturalPhysique");
    }

 

    public List<Exercicios> getTreinoDoDia() {
        DayOfWeek diaSemana = LocalDate.now().getDayOfWeek();
        String dia = converterDia(diaSemana); // usa o método que converte para "Segunda", "Terça"...
        List<Exercicios> treinoDoDia = treinos.get(dia);
        return treinoDoDia != null ? treinoDoDia : Collections.emptyList();
    }

    public String converterDia(DayOfWeek diaSemana) {
        return switch (diaSemana) {
            case MONDAY -> "Segunda";
            case TUESDAY -> "Terça";
            case WEDNESDAY -> "Quarta";
            case THURSDAY -> "Quinta";
            case FRIDAY -> "Sexta";
            case SATURDAY -> "Sábado";
            case SUNDAY -> "Domingo";
        };
    }

    public String trainingDescriptionFor(String trainingType){
        return switch (trainingType) {
            case "MensPhysique" -> {
                trainMensPhysique.itsTrain();
                descricaoTreino.put("Tipo de Treino", "Mens Physique");
                yield "Mens Physique";
            }
            case "ClassicPhysique" -> {
                trainClassicPhysique.itsTrain();
                descricaoTreino.put("Tipo de Treino", "Classic Physique");
                yield "Classic Physique";
            }
            case "OpenPhysique" -> {
                trainOPENPhysique.itsTrain();
                descricaoTreino.put("Tipo de Treino", "Open Physique");
                yield "Open Physique";
            }
            case "NaturalPhysique" -> {
                trainNaturalPhysique.itsTrain();
                descricaoTreino.put("Tipo de Treino", "Natural Physique");
                yield "Natural Physique";
            }
            default -> throw new IllegalStateException("Unexpected training type: " + trainingType);
        };
        }
    
    }



    

