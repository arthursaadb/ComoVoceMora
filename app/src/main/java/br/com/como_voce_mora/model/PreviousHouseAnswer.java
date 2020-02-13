package br.com.como_voce_mora.model;

public enum PreviousHouseAnswer {

    LIVED_IN_SAME_PLACE("Você sempre morou no mesmo local ou já morou em outro local antes?", "92cd330f-b184-4004-9fb9-8d24a0d6cd09"),
    LIVE_IN_CONDOMINIUM("Você residia em condomínio?", "fa0212cd-3ea2-42df-8dc3-5916719e5989"),
    PREVIUS_PLACE_TYPE("Qual era o tipo da sua moradia anterior?", "bdd6ac48-01f9-4249-92e6-0384f77811ff"),
    PREVIUS_APARTAMENT_TYPE("Que tipo de apartamento era?", "ad014bc3-b05b-4d56-8e0d-d5cff9a1c4cd"),
    PREVIUS_HOUSE_TYPE("Que tipo de casa era?", "a3d75d2e-4a8c-44ee-936d-f3cb78a004fc"),
    BUY_TYPE("Qual era o estado de aquisição", "38be2056-927c-4759-81f3-211c3b7fcfc9"),

    PREVIUS_HOUSE_SATISFACTION("Qual o nível de satisfação para a moradia anterior quanto a:", "070fe97e-a155-418b-ba94-26da321017b0"),
    GENERAL_ASPECTS("Aspectos Gerais", "59c54861f9a75c213d64b214"),
    COST_BENEFIT("Relação de Custo Benefício", "590b5fd61e4d3f620eea271a"),
    FINISHHING("Acabamento", "590b5fd51e4d3f620eea26d3"),
    LOCATION("Localização", "590b5fd61e4d3f620eea2790"),
    SIZE("Tamanho", "59c5489bf9a75c213d64b215"),

    STAY_TIME("Qual o tempo de permanência na moradia anterior?", "471000f6-2f09-4227-ba7d-00e729e062d0"),
    LATITUDE_LONGITUDE("Informe a latitude e longitude da moradia anterior.", "840ab2d4-ef57-47c9-89c6-dc74b08f1882")



    ;


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
