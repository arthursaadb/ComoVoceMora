package br.com.como_voce_mora.model;

public class AnswerRequest {
    private String dwellerId;
    private String questionPartId;
    private String texto;
    private String evaluationId;

    public AnswerRequest() {
    }

    public AnswerRequest(String dwellerId, String questionPartId, String texto, String evaluationId) {
        this.dwellerId = dwellerId;
        this.questionPartId = questionPartId;
        this.texto = texto;
        this.evaluationId = "5dc4a37451f72163e4182fe9";
    }

    public AnswerRequest(String dwellerId, String questionPartId, String texto) {
        this.dwellerId = dwellerId;
        this.questionPartId = questionPartId;
        this.texto = texto;
        this.evaluationId = "5dc4a37451f72163e4182fe9";
    }

    public String getDwellerId() {
        return dwellerId;
    }

    public void setDwellerId(String dwellerId) {
        this.dwellerId = dwellerId;
    }

    public String getQuestionPartId() {
        return questionPartId;
    }

    public void setQuestionPartId(String questionPartId) {
        this.questionPartId = questionPartId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }
}