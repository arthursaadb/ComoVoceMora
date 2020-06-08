package br.com.como_voce_mora.model;

public enum CurrentResidenceAnswer {

    CITY("Em que cidade você mora?", "f7185827-86d3-4b93-9c53-32af2dd4b34a"),
    NEIGHBORHOOD("Qual o nome do seu bairro?", "d9b53923-35df-4b57-b3a1-a40601e418d4"),
    CEP("Qual o seu CEP?", "719e6d5c-83bb-4a42-a0c2-0893d35e7fd2"),
    APARTAMENT_NUMBBER("Qual o número do seu apartamento/bloco?", "0e065fbe-0187-4805-8295-ed2c7cdef567"),
    HOUSE_NUMEBR("Qual o nome da sua rua e número da residência?", "b59c3ff5-c3a7-4f55-9528-d64f68e265a1"),
    TIME_LIVING("Desde quando você mora neste local?", "39817be1-f9bc-4c2e-a5f3-459f5db25d21"),

    URBAN_EQUIPMENT("Você conhece os seguintes equipamentos urbanos no seu bairro?", "4efbf667-9637-4ffa-b269-11900d67e91a"),
    SAUDE("Saude", "8e5bce95-4b63-49e9-831e-575033476dc6"),
    ESCOLA("Escola", "a6cd247b-cb34-4c3b-9c64-0b8c167cb394"),
    CULTURA("Cultura", "6c437fb1-012f-4c37-a6d6-972bd6e0023a"),
    LAZER("Lazer", "ede14a71-b52d-451d-8981-42d6ae80021b"),
    ESPORTE("Esporte", "1f065015-64d7-49e5-b945-ea1721328ee7"),
    SEGURANCA("Seguranca", "983cb6ba-cad8-42cc-b42c-c9ee291e88cb"),


    PUBLIC_SPACE_SATISFACTION("Qual sua satisfação dos espaços públicos de lazer e esporte em relação a:", "12917a7d-8f4e-4b8a-b0e6-98f969ef1146"),

    SECURITY("Segurança", "590b5fd61e4d3f620eea26f6"),

    EQUIPMENTS_QUALITY("Qualidade de Equipamentos", "59c2ca87f9a75c213d64b213"),

    EQUIPMENTS_QUANTITY("Quantidade de Equipamentos", "59c2ca7cf9a75c213d64b212"),

    ACCESSIBILITY("Acessibilidade", "590b5fd61e4d3f620eea271c"),

    COMMERCE("Em relação à presença de comércio, seu bairro é:", "2854c32c-6d1a-45a6-8199-ab23260a45bc"),

    COMMERCE_TYPE_MISSING("De qual tipo de estabelecimento comercial ou serviço você sente falta no seu bairro?", "65691f6a-7105-474c-b1f6-b19aabd6785f"),

    NEIGHBORHOOD_ASPECTS("Em relação ao bairro, classifique os aspectos:", "e3b4d5dc-5ad4-4c9b-a70c-aa50272ee3fe"),

    COLLECTIVE_INTERACTION("Convívio social coletivo", "590b5fd61e4d3f620eea2799"),

    ACCESSIBILITY_SIDEWALKS("Acessibilidade e qualidade das calçadas", "590b5fd61e4d3f620eea27bb"),

    PLEASANTNESS("Agradabilidade", "5a1c1230f9a75c50ae7eb283"),

    NEIGHBORHOOD_ORGANIZATION("Existe alguma organização de moradores (comunitária) em seu bairro?", "89561549-0343-4224-8df2-c98a50450799"),

    NEIGHBORHOOD_ORGANIZATION_TYPE("Informe qual organização de moradores (comunitária) está presente no seu bairro.", "1752bdd5-0e02-4962-994e-7b0b9fe5ceed"),

    INTEGRATED_IN_CITY("Você se sente integrado à cidade onde mora?", "3c0ad0c0-57ef-4dd8-a138-e4569bba29aa"),

     DEFAULT_PULIC_AREA("Você conhece os seguintes equipamentos urbanos no seu bairro?", "40ae50b9-8c33-43d9-b2a8-261a943d6cf4"),


    LATITUDE_LONGITUDE("Informe a latitude e longitude de sua moradia atual.","771578be-85a7-404a-8e09-a27e569d5444");

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
