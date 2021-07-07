package br.com.como_voce_mora.model;

public enum CurrentResidenceAnswer {
    CITY("Em que cidade você mora?", "ea1b3bc8-ae2c-4c63-9e7b-5b4cb61133e1"),

    NEIGHBORHOOD("Qual o nome do seu bairro?", "fdf266ab-169b-48d4-b4c7-cfc6344d3ce8"),

    CEP("Qual o seu CEP?", "c19f77b3-1e97-4e0e-a658-fd08d961e04c"),
    APARTAMENT_NUMBBER("Qual o número do seu apartamento/bloco?", "771f1b45-5273-4b05-a415-8e14c5b07d74"),

    HOUSE_NUMEBR("Qual o nome da sua rua e número da residência?", "8e87114c-0f98-42eb-bc76-8f8195cb3ef5"),

    TIME_LIVING("Desde quando você mora neste local?", "9058eb48-3e7e-4786-9dd1-65ca66279d35"),

    URBAN_EQUIPMENT("Você conhece os seguintes equipamentos urbanos no seu bairro?", "4efbf667-9637-4ffa-b269-11900d67e91a"),
    SAUDE("Saude", "66fa297e-fa52-4611-8df1-4bc0a64222cd"),
    ESCOLA("Educação", "9873761b-013a-457b-a90e-eaf1ed94b62e"),
    CULTURA("Cultura", "fb80739d-49a9-4886-b6f2-91098e548466"),
    LAZER("Lazer", "fe44b7bd-dc82-4551-85a1-31e903fef421"),
    ESPORTE("Esporte", "13ecaa1c-a950-4308-8fee-ee4094644e5e"),
    SEGURANCA("Seguranca", "7c57a2db-5abc-4a97-964c-8089c52ddebe"),

    COMMERCE_TYPE_MISSING("De qual tipo de estabelecimento comercial/serviço você sente falta no seu bairro?", "65691f6a-7105-474c-b1f6-b19aabd6785f"),
    LOTERICA("Lotérica", "ba67ef17-aaf6-4da9-a043-ffda3827e72c"),
    ACOUGUE("Açougue", "6544855c-b658-4f62-90b6-44b75fa54c7c"),
    MERCADO("Mercado", "5b3f0510-cd2a-4b67-99c8-89e60fe01333"),
    LOJA("Loja", "ffabfa03-e8c4-4593-a773-349643d8707b"),
    FARMACIA("Farmacia", "4625cade-fe56-476e-9374-71bfa2c429eb"),
    POSTO_DE_GASOLINA("Posto de gasolina", "873b86ed-2dd3-4f91-951a-fba933c3f29f"),
    ACADEMIA("Academia", "597a46e8-04cd-42e1-a443-a291229f8d3a"),
    PADARIA("Padaria", "90df84b6-e469-41b5-bbdb-335442b54439"),
    RESTAURANTE("Restaurante", "2d5ca23b-e52d-4c78-8cec-1cb886c201db"),
    OUTROS("Outros", "e99ec45d-c1f7-4f89-bf64-bc0aa65a4d70"),
    NENHUM("Nenhum", "4dbc2e86-4bde-4be1-8b7a-96414ef2d9e3"),
    BANCO("Banco", "19c915c8-0b40-4eca-a3ca-af84aee70c62"),

    COMMERCE("Em relação à presença de comércio, seu bairro é:", "3b511c92-517d-49bb-b991-cf20e406c0df"),

    DEFAULT_PULIC_AREA("Você conhece os seguintes equipamentos urbanos no seu bairro?", "40ae50b9-8c33-43d9-b2a8-261a943d6cf4"),
    PRACA("Praça", "b7839c5f-af1e-4f79-a52e-d86bba5bf633"),
    PARQUE("Parque","87516934-3ff3-4bd3-8704-d9589334ca87"),
    ACADEMIA_AO_AR_LIVRE("Academia ao ar livre","9258f9a0-f034-4d1d-9f6f-ac296a222c2f"),
    ESPACO_ESPORTIVO("Espaço esportivo","ad6955f6-f483-4f0a-bd90-0b5b3ec3912a"),

    PUBLIC_SPACE_SATISFACTION("Qual sua satisfação dos espaços públicos de lazer e esporte em relação a:","12917a7d-8f4e-4b8a-b0e6-98f969ef1146"),
    SECURITY("Segurança","fa3d8914-9161-41d2-8aa6-4fe89fe3aede"),
    EQUIPMENTS_QUALITY("Qualidade de Equipamentos","3b2a919e-64bb-4b0e-ba96-98ccceaa9d30"),
    EQUIPMENTS_QUANTITY("Quantidade de Equipamentos","54c716f5-a1f0-496b-a2e7-14ebd9b5e129"),
    ACCESSIBILITY("Acessibilidade","8c7a0e80-337c-4a3a-adc1-ccedbde43d2d"),

    NEIGHBORHOOD_ASPECTS("Classifique os seguintes aspectos em relação ao seu BAIRRO:","e3b4d5dc-5ad4-4c9b-a70c-aa50272ee3fe"),
    COLLECTIVE_INTERACTION("Convívio social coletivo","47bf4461-394e-41fd-a62d-21dc843a79c6"),
    ACCESSIBILITY_SIDEWALKS("Acessibilidade e qualidade das calçadas","eefcb0a3-5a58-40bb-bb58-1312059cfb41"),
    PLEASANTNESS("Agradabilidade","666ee70d-e9b5-48d2-86f4-97e2fdf25566"),

    NEIGHBORHOOD_ORGANIZATION("Existe alguma organização de moradores (comunitária) em seu bairro?","fa76ce4f-2bf9-4cb9-ba3f-1ee758849bae"),

    NEIGHBORHOOD_ORGANIZATION_TYPE("Informe qual organização de moradores (comunitária) está presente no seu bairro.","ecdfb0a4-8bb1-4787-80da-5ab1d87ed806"),

    INTEGRATED_IN_CITY("Você se sente integrado à cidade onde mora?","f704788a-cbb2-4f32-9967-69c77caebfe6"),

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
