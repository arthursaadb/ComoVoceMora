package br.com.como_voce_mora.model;

public enum HouseGroupAnswer {

    HOUSING_TYPOLOGY("Em que tipologia de habitação você reside?", "b9badba5-9a5a-4bab-95e2-f7664e1a908b"),
    LIVE_IN_CONDOMINIUM("A moradia em que você reside pertence a um condomínio?", "3b286887-ea0e-4a0f-b22c-ed2cbe4673ed"),
    CONDOMINIUM_BLOCKS("Quantos blocos existem no seu condomínio?", "0e43b1af-bbe0-48e2-8ffc-1a663681cf0a"),
    CONDOMINIUM_PUBLIC_EQUIPMENT("Selecione os equipamentos de uso coletivo que existem no seu condomínio ou edifício e clique em avançar. Se não houver nenhum dos que eu mostrar, clique em avançar.", "41a76c17-3ea9-47e8-bf25-45d7bab862fa"),

    //VOLUME HORIZONTAL QUESTION
    SATISFACTION_OF_HOME_ASPECTS("Agora classifique os seguintes aspectos de seu condomínio, de acordo com seu nível de satisfação.", "c89d3e36-68fd-4bd9-bd29-4bc43ffd829e"),
    ACCESSIBILITY("Acessibilidade", "590b5fd51e4d3f620eea26e0"),
    CONSTRUCTION_QUALITY_OF_HOME("Qualidade da Construção", "590b5fd61e4d3f620eea2716"),
    GENERAL_APARENCE("Aparência geral", "590b5fd61e4d3f620eea272f"),
    CLEANS_AND_PRESERVATION("Limpeza e Conservação", "590b5fd61e4d3f620eea2718"),

    //VOLUME HORIZONTAL QUESTION
    ASPECTS("O que voce acha desses aspectos?", "e2ca70eb-4426-44ec-8806-63f27b8eeade"),
    ASPECTS_SECURITY("Segurança", "590b5fd61e4d3f620eea271a"),
    ASPECTS_STREET_SECURITY("Segurança em relação à rua", "590b5fd61e4d3f620eea2735"),
    ASPECTS_CONVIVENCE("Nível de Convivência", "590b5fd61e4d3f620eea2719"),
    ASPECTS_PRIVACY("Privacidade", "590b5fd61e4d3f620eea26f5"),

    EQUIPMENTS_TO_ADD("Indique quais desses equipamentos você gostaria que seu edifício possuísse:", "3457ec97-99fd-4be0-a919-4ce991aae20b"),
    EXISTENCE_OF_GREEN_AREA("Existem áreas verdes no seu edifício?", "ec1cd8cc-2eee-4326-9ba2-d3cc1c471687"),
    MISS_GREEN_AREA("Você sente falta dessas áreas?", "f56106f2-a57d-41be-8378-6961efd27fbb"),
    GREEN_AREA_SATISFACTION("Qual a sua satisfação em relação à  quantidade dessas áreas verdes?", "058b4850-21f6-498e-be57-8abae21786c2"),
    DELIMITATION("Existe delimitação entre sua residência e a vizinhança?", "6a1601b4-3a30-4e86-a2d9-e766a2375b4e"),
    DELIMITATION_TYPE("Que delimitação existem entre sua residência e a vizinhança?", "f0ce08bf-d19e-4946-bf47-bb63329c37a0"),
    BLOCK_TYPE("Existe algum elemento de identificação no espaço do seu conjunto? (Em que seu bloco se diferencia dos demais)", "e7268e97-77fc-4e01-a29b-5454a3d67acc"),
    RESIDENTS_ORGANIZATION("Existe algum organização de moradores em seu conjunto?", "288cb1c5-1cfe-43a1-963c-eb0a88311c65"),
    RESIDENTS_ORGANIZATION_TYPE("Se existe, indique a organização de moradores do seu conjunto?", "076c146b-0d4b-4354-b933-0a0da3e3e0ad"),

    //PODIUM QUESTION
    EQUIPMENTS_IMPORTANCE("O que significa a presença de equipamentos de uso comum no edifício?", "d325448c-3b17-42b2-8c45-2de33a6645e6"),
    PRIVACY_IMPORTANCE("Privacidade", "590b5fd61e4d3f620eea2752"),
    SECURITY_IMPORTANCE("Segurança", "590b5fd61e4d3f620eea2753"),
    SOCIAL_STATUS_IMPORTANCE("Status Social", "590b5fd61e4d3f620eea278f"),
    LIFE_QUALITY_IMPORTANCE("Qualidade de Vida", "590b5fd61e4d3f620eea279a"),
    FACILITY_IMPORTANCE("Praticidade de Vida", "590b5fd61e4d3f620eea279b"),
    MONEY_IMPORTANCE("Valor Comercial / Imobiliário", "590b5fd61e4d3f620eea279c"),
    NO_IMPORTANCE("Não significa nada", "590b5fd61e4d3f620eea27ba"),
    OTHER_MOTIVE_IMPORTANCE("Outro Motivo", "590b5fd61e4d3f620eea2793"),

    GREEN_AREA("Existem áreas verdes no seu edifício?", "ec1cd8cc-2eee-4326-9ba2-d3cc1c471687"),
    NEIGHBORHOOD_DELIMITATION("Existe delimitação entre sua residência e a vizinhança?", "6a1601b4-3a30-4e86-a2d9-e766a2375b4e"),


    ;
    String question;
    String questionPartId;

    HouseGroupAnswer(String question, String questionPartId) {
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
