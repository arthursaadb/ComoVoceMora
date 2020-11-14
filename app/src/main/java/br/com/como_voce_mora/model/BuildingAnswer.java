package br.com.como_voce_mora.model;

public enum BuildingAnswer {
    CHOOSE_HOUSE("Você escolheu viver nessa moradia ou não teve escolha?", "9182bae9-8908-48e2-b7a3-4c3cc8e65c15"),

    HELPED_IN_PROJECT("Você ou sua família participaram da elaboração do desenho da moradia original (sem reformas)?", "d4b1491c-cdbd-45be-979e-c82354aa7151"),

    //PODIUM QUESTION
    LIVED_IN_SAME_PLACE("Diga-me, por que você escolheu viver nessa moradia? Selecione um ou mais motivos por ordem de prioridade.", "1e9d5d2d-7688-42e4-8474-ec6b4b3b3528"),
    SECURITY("Segurança", "23cb27e4-d1ab-4f60-95a1-806021c35302"),
    CONSTRUCTION_QUALITY("Qualidade da Construção", "2e2440ff-b58c-4462-a89e-7c207a81b197"),
    SOCIAL_STATUS("Status Social", "6cbbdb37-7969-4435-a455-8c311fb46edd"),
    LOCATION("Localização", "17d3eb55-5ae3-4e09-8fbe-6d1f32088708"),
    VIEW("Vista Privilegiada", "36377ba7-f0c3-4579-aae8-665ec793e49a"),
    INVESTIMENT("Investimento", "6cc40f7c-c63b-4557-ba8c-37c52af1904c"),
    OTHER("Outro Motivo", "e950abbb-5f35-4546-b977-966d2c473f71"),

    //PODIUM QUESTION
    NEGATIVE_POINTS_LIVE_IN_HOUSE("Quais os pontos negativos de se morar em casa?", "62758c9c-1d8b-4041-be99-ab24431c5f1e"),
    COEXISTENCE_BBETWEEN_NEIGHBORS("Nível de convivência entre vizinhos", "3f674fcb-81c8-4255-b8f2-df2a5d52384f"),
    PRIVACY("Privacidade", "e421b413-e765-4155-8fcb-0b7f6996cffb"),
    LACK_OF_SECURITY("Falta de segurança", "877e8430-2cc8-4224-a373-efec08be7851"),
    LIMITATIONS_TO_REFORMS("Limitação à reformas", "9700c77e-4694-4ce6-881f-b905e139f764"),
    LACK_OF_SPACE("Espaço reduzido da casa", "91dd9213-7474-4125-a027-80ca8b409122"),
    CONTROL_OF_SOCIAL_LIFE("Vida social controlada", "1f6a8da7-1796-42ef-b436-490b4265dd65"),
    OTHER_NEGATIVE("Outro Motivo", "6b41fbeb-ef6d-4475-9267-a61011d31fc3"),

    //PODIUM QUESTION
    NEGATIVE_POINTS_LIVE_IN_APARTAMENT("Quais os pontos negativos de se morar em apartamento?", "e1d64477-e5b7-41f7-b13b-f6a25f2b4d44"),
    LACK_OF_PRIVATY_BBETWEEN_NEIGHBORS("Falta de privacidade em relação aos vizinhos", "ad5b25bb-5d38-49b0-846a-e2c06a835d51"),
    LACK_OF_GARDEN("Ausência de jardim privativo (quintal)", "0f48f5a6-5e43-445e-805d-f29fe563dc39"),
    LIMITATIONS_TO_REFORMS_APARTAMENTS("Limitação em relação as reformas nos apartamentos", "1ba636a9-ffc0-416c-83d9-ff5e690d4baa"),
    CONTROL_OF_SOCIAL_LIFE_BY_CONDOMINIUM("Vida social controlada pelas regras do condominio", "ca3e9fbc-bdb2-437f-91bf-72bb6f7fce88"),
    LACK_OF_SPACE_IN_APARTAMENT("Espaço reduzido do apartamento", "30fd1e02-066e-40c9-916f-8568acb077a2"),
    PUBLIC_SOCIAL_RELATIONSHIP("Convívio social coletivo", "d902df38-7556-469b-ab3f-df9450a5ee1d"),
    OTHER_MOTIVE("Outro Motivo", "d55e429f-c7dc-4f20-bae2-3f87626ff90e"),

    NUMBER_OF_FLOORS("Quantos andares tem em média cada edifício?", "4c39839d-cbf5-4a58-8eb8-6e933d7dc858"),

    APARTAMENTS_BY_FLOOR("Qual o número de apartamentos por andar existem no seu edifício?", "ad51fef3-fb4f-4467-b3fe-69a9c436a211"),

    //VOLUME HORIZONTAL QUESTION
    LOT_REVIEW("Qual a sua satisfação em relação ao seu lote?", "affe770a-0464-4e31-b47c-8953ac33fc48"),
    LOT_SIZE("Tamanho", "9db4d136-c1cf-418b-ab82-1bc9dba85dfe"),
    LOT_EVOLUTION("Capacidade de ampliação", "10319b40-e17a-41c2-9580-fab0866a7080"),
    LOT_CONSTROCTION("Aproveitamento da construção", "ff9c97f1-48b9-4a46-aa6b-62d612af11a5");

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
