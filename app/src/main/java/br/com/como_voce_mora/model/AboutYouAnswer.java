package br.com.como_voce_mora.model;


public enum AboutYouAnswer {
    WHATS_YOUR_GENDER("Qual é o seu gênero?", "32f330d4-5583-4bcf-aec1-2830b3202655", ""),
    WHATS_YOUR_AGE("Quantos anos você tem?", "a10efa6b-96ad-4369-adb7-1ad476d6a6b5", ""),
    SCHOOLING("Até que ano da escola você cursou?", "c31308b8-2e1b-4033-95f0-a58821f30749", ""),
    NUMBER_OF_PERSON("Selecione quem mora com você e clique em avançar. Se você mora só, apenas clique em avançar.", "2f2a2bc2-5b03-4b59-a7f0-a2f48660b1ce", ""),
    FAMILY_INCOME("Qual sua renda familiar em reais? Lembre-se que é a renda de todos os moradores somada. Se você não souber ou quiser responder, apenas clique em avançar", "6832341d-1db5-47cd-8457-052a7090febb", ""),
    WORK_FOR_YOU("Trabalha algum funcionário em sua morada?", "17c7ca75-55bc-47d2-9ef0-d6770d65ee0d", ""),
    YOUR_PROFESSION("Qual é sua atividade principal?", "408f937b-2e42-4fae-ade5-b246771bc7ef", "");

    String question;
    String questionPartId;
    String evaluationId;

    AboutYouAnswer(String question, String questionPartId, String evaluationId) {
        this.question = question;
        this.questionPartId = questionPartId;
        this.evaluationId = evaluationId;
    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionPartId() {
        return questionPartId;
    }

    public void setQuestionPartId(String questionPartId) {
        this.questionPartId = questionPartId;
    }
}
