package br.com.como_voce_mora.model;

public enum Answer {
    WHATS_YOUR_GENDER("Qual é o seu genero?", "3c07a8d2-f39e-417f-bc92-6fdcc1811e14");
    String question;
    String questionPartId;

    Answer(String question, String questionPartId) {
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
