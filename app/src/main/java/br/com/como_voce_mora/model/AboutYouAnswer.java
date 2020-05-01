package br.com.como_voce_mora.model;


public enum AboutYouAnswer {
    WHATS_YOUR_GENDER("Qual é o seu genero?", "60024160-4e66-44b3-9572-75a409685000"),
    WHATS_YOUR_AGE("Quantos anos você tem", "587f357b-8172-490d-a114-69da4109098f"),
    SCHOOLING("Até que ano da escola você cursou?", "95a92625-6ad9-4763-948a-aafff913d33d"),

    NUMBER_OF_PERSON("Agora vamos falar sobre os moradores. Selecione quem mora com você.", "2d40a340-1cc7-4d88-b9e5-f39404463c3b"),
    FAMILY_INCOME("Qual sua renda familiar em reais? Lembre-se que é a renda de todos os moradores\n" +
        "somada. Se você não souber ou quiser responder, apenas clique em avançar","92a177d9-27a6-4a21-a193-8ebe3fe556fb");


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
