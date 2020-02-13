package br.com.como_voce_mora.model;

public enum CurrentResidenceAnswer {

    STATE("Em qual estado você mora?", "ce15d880-3e9d-45d5-909b-a5cffabc5d76"),
    CITY("Em que cidade você mora?", "f7185827-86d3-4b93-9c53-32af2dd4b34a"),
    NEIGHBORHOOD("Qual o nome do seu bairro?", "d9b53923-35df-4b57-b3a1-a40601e418d4"),
    CEP("Qual o seu CEP?", "719e6d5c-83bb-4a42-a0c2-0893d35e7fd2"),
    APARTAMENT_NUMBBER("Qual o número do seu apartamento/bloco?", "0e065fbe-0187-4805-8295-ed2c7cdef567"),
    HOUSE_NUMEBR("Qual o nome da sua rua e número da residência?", "b59c3ff5-c3a7-4f55-9528-d64f68e265a1"),
    TIME_LIVING("Desde quando você mora neste local?", "39817be1-f9bc-4c2e-a5f3-459f5db25d21"),
    NEIGHBORHOOD_IDENTIFICATION("Você se identifica com o seu bairro?", "47686f3b-6983-44a3-9aff-f15e7a6b1e18"),

    URBAN_EQUIPMENT("Quais equipamentos urbanos estão presentes no seu bairro?", "4efbf667-9637-4ffa-b269-11900d67e91a"),
    HEALTH("Saúde (UBS e UAI)", "590b5fd61e4d3f620eea272a"),
    SCHOOL("Educação (creches e escolas)", "590b5fd61e4d3f620eea272b"),
    CULTURE("Cultura", "590b5fd61e4d3f620eea272c"),
    RECREATION("Lazer (praças e parques)", "590b5fd61e4d3f620eea272d"),
    SPORT_EQUIPMENT("Equipamentos para Esporte", "590b5fd61e4d3f620eea27b0"),
    SAFETY("Segurança (Posto Policial)", "590b5fd61e4d3f620eea27b1"),

    COMMERCE("Em relação à presença de comércio, seu bairro é:", "2854c32c-6d1a-45a6-8199-ab23260a45bc"),
    COMMERCE_TYPE_MISSING("De qual tipo de estabelecimento comercial ou serviço você sente falta no seu bairro?", "65691f6a-7105-474c-b1f6-b19aabd6785f"),

    PUBBLIC_SPACE("Indique quais dos espaços públicos estão presentes no seu bairro?", "1af81c94-5e56-41ce-b87d-88b7f97df916"),
    SQUARE("Praça", "590b5fd61e4d3f620eea27b2"),
    PARK("Parque", "590b5fd61e4d3f620eea27b3"),
    GYM("Academia ao ar livre", "590b5fd61e4d3f620eea27b4"),
    SPORTS_PLACE("Espaço esportivo (campo de futebol, quadra)", "590b5fd61e4d3f620eea27b5"),

    PUBLIC_SPACE_SATISFACTION("Qual sua satisfação para os espaços públicos com relação a:", "12917a7d-8f4e-4b8a-b0e6-98f969ef1146"),
    SECURITY("Segurança", "590b5fd61e4d3f620eea26f6"),
    EQUIPMENTS_QUALITY("Qualidade de Equipamentos", "59c2ca87f9a75c213d64b213"),
    EQUIPMENTS_QUANTITY("Quantidade de Equipamentos", "59c2ca7cf9a75c213d64b212"),
    ACCESSIBILITY("Acessibilidade", "590b5fd61e4d3f620eea271c"),

    NEIGHBORHOOD_ASPECTS("Em relação ao bairro, classifique os aspectos:", "e3b4d5dc-5ad4-4c9b-a70c-aa50272ee3fe"),
    COLLECTIVE_INTERACTION("Convívio social coletivo", "590b5fd61e4d3f620eea2799"),
    ACCESSIBILITY_SIDEWALKS("Acessibilidade e qualidade das calçadas", "590b5fd61e4d3f620eea27bb"),
    PLEASANTNESS("Agradabilidade", "5a1c1230f9a75c50ae7eb283"),

    NEIGHBORHOOD_ORGANIZATION("Existe alguma organização de moradores (comunitária) em seu bairro?", "89561549-0343-4224-8df2-c98a50450799"),
    NEIGHBORHOOD_ORGANIZATION_TYPE("Informe qual organização de moradores (comunitária) está presente no seu bairro.", "1752bdd5-0e02-4962-994e-7b0b9fe5ceed"),
    INTEGRATED_IN_CITY("Você se sente integrado à cidade em que mora?", "3c0ad0c0-57ef-4dd8-a138-e4569bba29aa"),
    LATITUDE_LONGITUDE("Informe a latitude e longitude de sua moradia atual.", "771578be-85a7-404a-8e09-a27e569d5444")

    ;

    String question;
    String questionPartId;

    CurrentResidenceAnswer(String question, String questionPartId) {
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
