package br.com.como_voce_mora.model;

public enum PreviousHouseAnswer {

    LIVED_IN_SAME_PLACE("Você sempre morou no mesmo local ou já morou em outro local?", "c5ecabce-639e-4594-957f-b4fa2c9af6e2"),
    LIVE_IN_CONDOMINIUM("A sua moradia anterior pertencia a um condomínio?", "d0e72e35-eb3a-46c1-83d5-33a01ef4d479"),
    PREVIUS_PLACE_TYPE("Qual era o tipo da sua moradia anterior?", "ba676592-3a90-4a9c-a83c-9cdc53c423da"),
    PREVIUS_APARTAMENT_TYPE("Que tipo de apartamento era?", "1835d2b9-efd4-493c-b9f1-ab2735a57743"),
    PREVIUS_HOUSE_TYPE("Que tipo de casa era?", "5b43b21b-73b5-4688-9bd4-ceb8e167f839"),
    BUY_TYPE("Qual era o estado de aquisição?", "e27f989e-a61b-4473-8a1a-694f85cc018e"),

    PREVIUS_HOUSE_SATISFACTION("Sobre a moradia anterior, indique seu grau de satisfação em relação a:", "070fe97e-a155-418b-ba94-26da321017b0"),
    GENERAL_ASPECTS("Aspectos Gerais", "e038d74e-68aa-4404-9a4d-badbddea1d8c"),
    COST_BENEFIT("Relação de Custo Benefício", "a18cc874-83be-44ba-8b99-4be2bd323eee"),
    FINISHHING("Acabamento", "4c8618db-e472-4857-98f8-1077d51ceb13"),
    LOCATION("Localização", "2a4efa01-82ca-4d5c-8352-ca4862dec833"),
    SIZE("Tamanho", "d0a78d40-72da-4e86-b847-0a45f0a99ddb"),

    STAY_TIME("Qual o tempo de permanência na moradia anterior?", "31e45ecf-9511-451e-b181-dc8922f8ae2f"),
    LATITUDE_LONGITUDE("Informe a latitude e longitude da moradia anterior.", "840ab2d4-ef57-47c9-89c6-dc74b08f1882");


    String question;
    String questionPartId;

    PreviousHouseAnswer(String question, String questionPartId) {
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
