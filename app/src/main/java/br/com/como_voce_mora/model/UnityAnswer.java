package br.com.como_voce_mora.model;

public enum UnityAnswer {

    HOUSING_STATE("Qual é o estado de aquisição da sua moradia?", "c0ef6d0a-9239-4c85-b543-788beea7c322"),
    APARTMENT_TYPE("Qual é o tipo do seu apartamento?", "e3b5d26a-3351-40cb-9089-e66cf88da694"),
    HOUSE_TYPE("Qual é o tipo da sua casa?", "d1c3a164-62a7-40a0-81e2-084e846da1d4"),
    HOME_TYPE("O que a sua moradia significa pra você?", "1b010a14-85c7-45e8-abb1-3984eef1e5f5"),
    KEEP_FURNISHINGS("Na sua moradia, foi possível acomodar seus antigos móveis e eletrodomésticos?", "93290ddc-5e83-4da6-9621-7ea28e9af17a"),
    DIFFICULTY_KEEP_FURNISHINGS("Informe o grau de dificuldade para a acomodação dos móveis e eletrodomésticos.", "b8b58180-05f4-48df-b180-f58a3f17e80f"),
    NO_DIFFICULTY_KEEP_FURNISHINGS("Por que não houve dificuldade em acomodar os antigos móveis e eletrodomésticos?", "6ce823ea-9635-41fe-a78e-b56f6a2b6c20"),
    HAS_DIFFICULTY_KEEP_FURNISHINGS("Por que houve dificuldade em acomodar os antigos móveis e eletrodomésticos?", "db81ba9e-961a-470d-8cfa-2dc579e085ec"),
    HAS_ADAPTED_HOME("Você se adaptou à sua moradia e se identifica com ela?", " f91dc06d-c664-40b4-a701-d523cb5a3d31"),
    USE_AS_EXTRA("Você utiliza sua moradia para adquirir alguma renda extra?", "21dee39e-c25f-4782-bc58-cbb2f4799fd6"),
    PERSONS_USES_AS_EXTRA("Quantos moradores utilizam a moradia como fonte de renda?", "fc37e38c-9a6d-4516-ae4d-9a7901f10f6d"),
    ACTIVITY_TYPE("Que atividade(s) você realiza como fonte de renda em casa?", "ff5451e6-59f3-4792-96ce-e79eb94908f3"),
    ACTIVITY_USE_TYPE(" Em casos de utilização da moradia como fonte de renda, o espaço é utilizado: ", "6ff743c2-fff0-46c8-85dd-604e27b7212c"),
    UTIL_AREA("Qual a área útil aproximada da sua moradia?", "f6e354cf-2188-4cd8-ad5d-84100d972184"),
    SATISFACTION_FOR_ROOMS("Qual a sua satisfação em relação à capacidade dos cômodos da sua moradia de se alterarem a funções diferentes?", "e43d0c98-463e-4b4c-a11f-8850dadcf52d"),
    TECNOLOGY_IMPORTANCE("A tecnologia, em especial a Internet, influencia nas relações pessoais dentro da moradia?", "7c1fb0c1-e986-4b8d-a25c-87d27c33624f"),
    REFORM_MADE("Quais dessas alterações ou reformas foram feitas nos cômodos da sua moradia?", "0b8a5265-b8ed-459a-93d9-077bea9bd9c3"),
    CHANGE_TO_BETTER_ATEMPTEMENT("Com relação a decoração, a sua moradia permite fazer alterações para atender melhor sua necessidade ou seu gosto?", "eb7b1308-abff-4b89-903b-34fe2497affe"),
    WHY_DONT_REFORM("Se não foram feitas alterações, quais os motivos?", "32314047-ccfd-48fc-84ca-1adb9b74f50a"),
    SUN_RECEIVE("Em que período do dia sua moradia recebe mais sol?", "9351b2ba-5ba2-4f3c-a166-05a6617922d7"),
    BETTER_SUN("Quais cômodos da sua moradia recebem mais sol?", "f70da57f-bb79-4bd7-b91d-bcd999ede91c"),
    EXISTING_ROOMS("Selecione os cômodos que existem em sua moradia e a quantidade", "4e190989-5d7e-4c41-875a-b1f2f98b4edb"),
    CHANGES_MADE("Se foram feitas alterações, quais? ", "6596d3a3-6957-4605-8548-7dd5d9ad8fec"),
    NO_CHANGES_MADE("Se nenhuma alteração foi feita, qual (is) o(s) motivo(s)?", "7ff06bfe-9fa7-4093-b366-1a31dfefa02d"),
    MADE_LIST_CHANGES("Você já realizou alguma das alterações listadas na questão anterior?", "30d1f4d4-51ff-441b-961d-2ab4bf1aaabc"),
    NEIGHBORHOOD_DELIMITATION_TYPE("Que delimitação existem entre sua residência e a vizinhança?", "f0ce08bf-d19e-4946-bf47-bb63329c37a0"),
    KITCHEN_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem na COZINHA?","590b5fd61e4d3f620eea27f8"),
    BALCONY_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem na VARANDA?","590b5fd61e4d3f620eea280f"),
    DINNERROOM_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem na SALA DE JANTAR?","590b5fd61e4d3f620eea2802"),
    ROOM_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem na SALA DE ESTAR?","590b5fd61e4d3f620eea27f4"),
    SINGLEROMM_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem no DORMITÓRIO DE SOLTEIRO?","590b5fd61e4d3f620eea27fb"),
    BIGROOM_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem no DORMITÓRIO DE CASAL?","590b5fd61e4d3f620eea27fc"),
    BATHROOM_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem no BANHEIRO?","590b5fd61e4d3f620eea2807"),
    SERVICE_AREA_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem na ÁREA DE SERVIÇO?","590b5fd61e4d3f620eea2808"),


    //VOLUME HORIZONTAL QUESTION
    SATISFACTION_BY_ROOM("Agora avalie sua moradia. Para cada característica, informe seu nível de satisfação.", "f8325fd8-ffc8-4752-9906-01d84788709a"),
    SIZE("Tamanho", "59c5489bf9a75c213d64b215"),
    DIVISION("Divisão dos cômodos", "5a1efa3ff9a75c50ae7eb284"),
    CONSTRUCTION_QUALITY("Qualidade da Construção", "590b5fd61e4d3f620eea2716"),
    CLEAN_DIFFICULTY("Facilidade de limpeza", "590b5fd51e4d3f620eea26d0"),
    ADAPTATION("Adaptação", "590b5fd51e4d3f620eea26ce"),
    PRIVACY("Privacidade", "590b5fd61e4d3f620eea26f5"),

    //VOLUME HORIZONTAL QUESTION
    CHARACTERISTICS_SATISFACTION_BATHROOM("Agora avalie seu BANHEIRO. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea2807"),
    CHARACTERISTICS_SATISFACTION_BIGROOM("Agora avalie o DORMITÓRIO DE CASAL. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27fc"),
    CHARACTERISTICS_SATISFACTION_SINGLEROMM("Agora avalie o DORMITÓRIO DE SOLTEIRO. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27fb"),
    CHARACTERISTICS_SATISFACTION_ROOM("Agora avalie a SALA DE ESTAR. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27f4"),
    CHARACTERISTICS_SATISFACTION_DINNERROOM("Agora avalie a SALA DE JANTAR . Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea2802"),
    CHARACTERISTICS_SATISFACTION_BALCONY("Agora avalie a VARANDA. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea280f"),
    CHARACTERISTICS_SATISFACTION_KITCHEN("Agora avalie a COZINHA. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27f8"),
    EASE_OF_FURNISHINGS("Facilidade de mobiliar", "5d0975d22771712aa06c6bf8"),
    TEMPERATURE("Temperatura", "5d0975832771712aa06c6bf6"),
    NATURAL_VENTILATION("Nível de Convivência", "590b5fd61e4d3f620eea2700"),
    NATURAL_ILUMINATION("Iluminação natural", "590b5fd61e4d3f620eea26ff"),
    NOISE_LEVEL("Nível de ruído", "5d0975be2771712aa06c6bf7"),
    SIZE_SATISFACTION("Tamanho", "59c5489bf9a75c213d64b215"),

    //VOLUME HORIZONTAL QUESTION
    REFORM_DIFICULTY("Considerando as alterações/reformas, diga-me o nível de dificuldade em:", "1c62df09-ca01-4f9c-be06-2b62582b4cfc"),
    CHANGE_FURNISHINGS_POSITION("Variar posição dos móveis", "590b5fd61e4d3f620eea27c8"),
    CAHNGE_ELETRONICS_POSITIONS("Variar posição dos eletrodomésticos", "590b5fd61e4d3f620eea27c9"),
    NATURAL_PLANTS("Inserir flores e plantas naturais", "590b5fd61e4d3f620eea27ca"),
    PERSONAL_DECORATION("Inserir objetos pessoais decorativos ou de recordações", "590b5fd61e4d3f620eea27cb"),
    PAINT("Pintar e/ou usar papel de parede", "590b5fd61e4d3f620eea27cc"),
    DROP_WALL("Abrir vãos e/ou derrubar paredes", "590b5fd61e4d3f620eea27cd"),
    PLASTER("Colocar forro de gesso", "590b5fd61e4d3f620eea27ce"),
    INNCREASE_POWER_PLUG("Acrescentar tomadas e/ou iluminação", "590b5fd61e4d3f620eea27cf"),

    //PODIUM QUESTION
    REFORM_REASON("Quais foram as razões das reformas e alterações? Escolha por ordem de prioridade", "12bb5893-1908-48f2-9b2a-ac4a31d06fec"),
    ENLARGE_ROOM("Ampliar cômodo", "590b5fd61e4d3f620eea27a4"),
    IMPROVE_FINISHING("Melhorar o acabamento", "590b5fd61e4d3f620eea27a6"),
    IMPROVE_CONFORT("Melhorar o conforto", "590b5fd61e4d3f620eea27a7"),
    RESOLVE_TECNICAL_INSUE("Resolver problema técnico", "590b5fd61e4d3f620eea27a8"),
    DECREASE_ROOM("Diminuir cômodo", "590b5fd61e4d3f620eea27a9"),
    CHANGE_ROOM_FUNCTION("Alterar a função do cômodo", "590b5fd61e4d3f620eea27aa"),
    OTHER_REASON("Outro", "590b5fd61e4d3f620eea27c1"),
    ELIMINATE_ROOM("Eliminar cômodo", "590b5fd61e4d3f620eea27c7"),

    ;
    String question;
    String questionPartId;

    UnityAnswer(String question, String questionPartId) {
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
