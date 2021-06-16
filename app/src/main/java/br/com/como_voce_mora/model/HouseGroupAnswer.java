package br.com.como_voce_mora.model;

public enum HouseGroupAnswer {

    HOUSING_TYPOLOGY("Em que tipologia de habitação você reside?", "c60edd89-c545-44d9-a655-63c372765c73"),

    LIVE_IN_CONDOMINIUM("A moradia em que você reside pertence a um condomínio?", "b1655b73-be21-4a1f-b917-086be68e8534"),

    CONDOMINIUM_BLOCKS("Quantos blocos existem no seu condomínio?", "1ad506a3-24e9-4e40-8b79-2f6b2ac501a7"),

    CONDOMINIUM_PUBLIC_EQUIPMENT("Selecione os equipamentos de uso coletivo que existem no seu condomínio ou edifício e clique em avançar. Se não houver nenhum dos que eu mostrar, clique em avançar.", "41a76c17-3ea9-47e8-bf25-45d7bab862fa"),
    ACADEMIA("Academia","0f90dcc5-3365-44cc-8ddf-4f4533dcf814"),
    SALAO_DE_FESTAS("Salão de festas","cfc19d47-9db7-4057-bc63-521b7bf6184b"),
    PLAYGROUND("Playground","347c2ee3-7763-4c35-b818-bfdccf810d78"),
    QUADRA_DE_ESPORTES("Quadra de esportes","4484d7eb-1be3-43ab-82a7-e75fa1c23c42"),
    SALAO_DE_JOGOS("Salão de jogos","6cbbdff0-f905-4449-8e6e-9ea1d5876fb4"),
    ESPACO_GOURMET("Espaço gourmet","6e7657ad-d2fe-43e1-9ade-07d4f1e2368c"),
    PISCINA_ADULTO("Piscina adulto","00c2a18f-c21f-4163-8715-8c7e32cf8dc1"),
    PISCINA_INFANTIL("Piscina infantil","3dcbeba7-7f12-4037-9624-b6c7ac85777d"),

    //VOLUME HORIZONTAL QUESTION
    SATISFACTION_OF_HOME_ASPECTS("Agora classifique os seguintes aspectos de seu condomínio, de acordo com seu nível de satisfação.", "c89d3e36-68fd-4bd9-bd29-4bc43ffd829e"),
    ACCESSIBILITY("Acessibilidade", "47eb4e86-da75-4f91-85d5-f15e282b9192"),
    CONSTRUCTION_QUALITY_OF_HOME("Qualidade da Construção", "103a4d39-8a85-43ed-b818-9e07bffb5dc8"),
    GENERAL_APARENCE("Aparência geral", "c311ab63-9660-40c9-8320-36ef29a2376b"),
    CLEANS_AND_PRESERVATION("Limpeza e Conservação", "9a79a8d1-fc9a-4d88-9c56-a0cd34e5633c"),

    //VOLUME HORIZONTAL QUESTION
    ASPECTS("O que você acha desses aspectos?", "e2ca70eb-4426-44ec-8806-63f27b8eeade"),
    ASPECTS_SECURITY("Relação de custo benefício", "594b0e04-2c5c-41bf-9efc-900bdcac07cc"),
    ASPECTS_STREET_SECURITY("Segurança em relação à rua", "a226341e-e98f-4fa2-85d4-825d795aff92"),
    ASPECTS_CONVIVENCE("Nível de Convivência", "73da3857-e8a1-446e-9609-b8f228875898"),
    ASPECTS_PRIVACY("Privacidade em relação à rua", "3bc5152c-81a2-41dc-bf4e-19c3ec82594e"),

    EQUIPMENTS_TO_ADD("Indique quais desses equipamentos você gostaria que seu edifício possuísse:", "99de50a3-ddd3-478c-a07e-9ae4f9240fdf"),
    EXISTENCE_OF_GREEN_AREA("Existem áreas verdes no seu edifício?", "2aa66471-a14a-4f54-9edb-e24a997de117"),
    MISS_GREEN_AREA("Você sente falta dessas áreas?", "a9761983-a589-4fb4-ae66-47e04bdaf501"),
    GREEN_AREA_SATISFACTION("Qual a sua satisfação em relação à quantidade dessas áreas verdes?", "85fff6f3-3ec4-4820-9de3-3a078f933c48"),
    DELIMITATION("Existe delimitação entre sua residência e a vizinhança?", "6a1601b4-3a30-4e86-a2d9-e766a2375b4e"),
    DELIMITATION_TYPE("Que delimitação existem entre sua residência e a vizinhança?", "f0ce08bf-d19e-4946-bf47-bb63329c37a0"),
    BLOCK_TYPE("Existe algum elemento de identificação no espaço do seu conjunto? (Em que seu bloco se diferencia dos demais)", "e7268e97-77fc-4e01-a29b-5454a3d67acc"),
    RESIDENTS_ORGANIZATION("Existe algum organização de moradores em seu conjunto?", "288cb1c5-1cfe-43a1-963c-eb0a88311c65"),
    RESIDENTS_ORGANIZATION_TYPE("Se existe, indique a organização de moradores do seu conjunto?", "076c146b-0d4b-4354-b933-0a0da3e3e0ad"),

    //PODIUM QUESTION
    EQUIPMENTS_IMPORTANCE("O que significa a presença de equipamentos de uso comum no edifício?", "d325448c-3b17-42b2-8c45-2de33a6645e6"),
    PRIVACY_IMPORTANCE("Privacidade", "d95e7aff-96a3-48d6-ad5d-044c88257608"),
    SECURITY_IMPORTANCE("Segurança", "e84f1021-a300-444f-89ad-1791fcae5458"),
    SOCIAL_STATUS_IMPORTANCE("Status Social", "592e91ca-2309-4c7a-ad26-0e4dd8fdba62"),
    LIFE_QUALITY_IMPORTANCE("Qualidade de Vida", "171788ee-0f8c-4679-856b-873f4bc3a04f"),
    FACILITY_IMPORTANCE("Praticidade de Vida", "fa3041df-57c5-4f77-a9c7-9e9340f3e5c2"),
    MONEY_IMPORTANCE("Valor Comercial / Imobiliário", "8fdde4e3-52ff-4891-b527-315b5e91aa9f"),
    NO_IMPORTANCE("Não significa nada", "070711e7-8fd3-4aa1-b937-62e68ab744ef"),
    OTHER_MOTIVE_IMPORTANCE("Outro Motivo", "5109b75e-7563-4994-b88c-a1e08b3540f9"),

    GREEN_AREA("Existem áreas verdes no seu condomínio?", "2aa66471-a14a-4f54-9edb-e24a997de117"),
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
