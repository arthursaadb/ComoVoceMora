package br.com.como_voce_mora.model;

import java.util.HashMap;

public class ResearchFlow {
    private static final ResearchFlow ourInstance = new ResearchFlow();

    private static HashMap<String, AnswerRequest> answerMap = new HashMap<>();
    private static boolean house = true;

    public static ResearchFlow getInstance() {
        return ourInstance;
    }

    private ResearchFlow() {
    }

    public static void addAnswer(String question, AnswerRequest answerRequest) {
        answerMap.put(question, answerRequest);
    }


    public static void setHouse(boolean houseChecked) {
        house = houseChecked;
    }

    public static boolean getHouse() {
        return house;
    }
}
