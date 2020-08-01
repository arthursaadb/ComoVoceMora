package br.com.como_voce_mora.model;


public enum AboutYouAnswer {
    WHATS_YOUR_GENDER("Qual é o seu gênero?", "60024160-4e66-44b3-9572-75a409685000"),
    WHATS_YOUR_AGE("Quantos anos você tem?", "587f357b-8172-490d-a114-69da4109098f"),
    SCHOOLING("Até que ano da escola você cursou?", "95a92625-6ad9-4763-948a-aafff913d33d"),
    NUMBER_OF_PERSON("Selecione quem mora com você e clique em avançar. Se você mora só, apenas clique em avançar.", "2d40a340-1cc7-4d88-b9e5-f39404463c3b"),
    FAMILY_INCOME("Qual sua renda familiar em reais? Lembre-se que é a renda de todos os moradores somada. Se você não souber ou quiser responder, apenas clique em avançar", "92a177d9-27a6-4a21-a193-8ebe3fe556fb"),
    WORK_FOR_YOU("Trabalha algum funcionário em sua morada?", "17c7ca75-55bc-47d2-9ef0-d6770d65ee0d"),
    YOUR_PROFESSION("Qual é sua atividade principal?", "408f937b-2e42-4fae-ade5-b246771bc7ef");

    String question;
    String questionPartId;

    AboutYouAnswer(String question, String questionPartId) {
        this.question = question;
        this.questionPartId = questionPartId;
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
