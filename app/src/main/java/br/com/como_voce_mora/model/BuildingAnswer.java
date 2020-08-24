package br.com.como_voce_mora.model;

public enum BuildingAnswer {

    CHOOSE_HOUSE("Você escolheu viver nessa moradia ou não teve escolha?", "729bae81-ff4f-4721-8d7a-cbaf9a589a7a"),
    HELPED_IN_PROJECT("Você ou sua família participaram da elaboração do desenho da moradia original (sem reformas)?", "b38958d5-5112-42a1-a15a-ef7dfaf2413f"),

    //PODIUM QUESTION
    LIVED_IN_SAME_PLACE("Diga-me, por que você escolheu viver nessa moradia? Selecione um ou mais motivos por ordem de prioridade.", "1e9d5d2d-7688-42e4-8474-ec6b4b3b3528"),
    SECURITY("Segurança", "90b5fd61e4d3f620eea26f6"),
    CONSTRUCTION_QUALITY("Qualidade da Construção", "590b5fd61e4d3f620eea2716"),
    SOCIAL_STATUS("Status Social", "590b5fd61e4d3f620eea278f"),
    LOCATION("Localização", "590b5fd61e4d3f620eea2790"),
    VIEW("Vista Privilegiada", "590b5fd61e4d3f620eea2791"),
    INVESTIMENT("Investimento", "590b5fd61e4d3f620eea2792"),
    OTHER("Outro Motivo", "590b5fd61e4d3f620eea2793"),

    //PODIUM QUESTION
    NEGATIVE_POINTS_LIVE_IN_HOUSE("Quais os pontos negativos de se morar em casa?", "62758c9c-1d8b-4041-be99-ab24431c5f1e"),
    COEXISTENCE_BBETWEEN_NEIGHBORS("Nível de convivência entre vizinhos", "590b5fd61e4d3f620eea2731"),
    PRIVACY("Privacidade", "590b5fd61e4d3f620eea2752"),
    LACK_OF_SECURITY("Falta de segurança", "92cd330f-b184-4004-9fb9-8d24a0d6cd09"),
    LIMITATIONS_TO_REFORMS("Limitação à reformas", "590b5fd61e4d3f620eea27b7"),
    LACK_OF_SPACE("Espaço reduzido da casa", "590b5fd61e4d3f620eea27b8"),
    CONTROL_OF_SOCIAL_LIFE("Vida social controlada", "90b5fd61e4d3f620eea27b9"),
    OTHER_NEGATIVE("Outro Motivo", "590b5fd61e4d3f620eea2793"),


    //PODIUM QUESTION
    NEGATIVE_POINTS_LIVE_IN_APARTAMENT("Quais os pontos negativos de se morar em apartamento?", "e1d64477-e5b7-41f7-b13b-f6a25f2b4d44"),
    LACK_OF_PRIVATY_BBETWEEN_NEIGHBORS("Falta de privacidade em relação aos vizinhos", "590b5fd61e4d3f620eea2794"),
    LACK_OF_GARDEN("Ausência de jardim privativo (quintal)", "590b5fd61e4d3f620eea2795"),
    LIMITATIONS_TO_REFORMS_APARTAMENTS("Limitação em relação as reformas nos apartamentos", "590b5fd61e4d3f620eea2796"),
    CONTROL_OF_SOCIAL_LIFE_BY_CONDOMINIUM("Vida social controlada pelas regras do condominio", "590b5fd61e4d3f620eea2797"),
    LACK_OF_SPACE_IN_APARTAMENT("Espaço reduzido do apartamento", "590b5fd61e4d3f620eea2798"),
    PUBLIC_SOCIAL_RELATIONSHIP("Convívio social coletivo", "590b5fd61e4d3f620eea2799"),
    OTHER_MOTIVE("Outro Motivo", "590b5fd61e4d3f620eea2793"),


    NUMBER_OF_FLOORS("Quantos andares tem em média cada edifício?", "33383772-2626-48d9-8aa7-012cdcde46cb"),
    APARTAMENTS_BY_FLOOR("Qual o número de apartamentos por andar existem no seu edifício?", "f6393328-7ad1-4fa4-904d-4963d2cd0bfb"),


    //VOLUME HORIZONTAL QUESTION
    LOT_REVIEW("Qual a sua satisfação em relação ao seu lote", "affe770a-0464-4e31-b47c-8953ac33fc48"),
    LOT_SIZE("Tamanho", "59c5489bf9a75c213d64b215"),
    LOT_EVOLUTION("Capacidade de ampliação", "590b5fd61e4d3f620eea26ec"),
    LOT_CONSTROCTION("Aproveitamento da construção", "5a427ec8f9a75c50ae7eb285")
    ;

    String question;
    String questionPartId;

    BuildingAnswer(String question, String questionPartId) {
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
