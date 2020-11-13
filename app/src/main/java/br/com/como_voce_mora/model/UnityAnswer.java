package br.com.como_voce_mora.model;

import java.io.Serializable;

public enum UnityAnswer implements Serializable {
    HOUSING_STATE("Qual é o estado de aquisição da sua moradia?", "e67d4171-681f-4423-8363-a3afa7b67fa9"),

    APARTMENT_TYPE("Qual é o tipo do seu apartamento?", "84720641-6f6d-489f-a370-0fb300a4240c"),

    HOUSE_TYPE("Qual é o tipo da sua casa?", "2619d540-2003-42e2-b278-ada889b665e0"),

    HOME_TYPE("O que a sua moradia significa pra você?", "1b010a14-85c7-45e8-abb1-3984eef1e5f5"),
    INVESTIMENTO("Investimento", "617da375-d631-403b-924b-05448e3022ea"),
    LOCAL_EM_QUE_PASSO_MAIS_TEMPO("Local em que passo mais tempo", "eb925fe8-56b5-4753-a7b6-141ef8d242a0"),
    LOCAL_SEGURO("Local Seguro", "da437930-4762-461c-bc4f-c9b68bde1bf3"),
    LOCAL_COM_O_QUE_MAIS_ME_IDENTIFICO("Local com o qual me identifico", "d4c0d060-b74d-491d-87e2-65a173206d41"),
    LOCAL_PERTENCES("Local onde estão meus pertences", "a115f453-660f-42e7-9a7d-fce85a71e6a7"),
    LOCAL_DURMO("Local onde apenas durmo\"", "fbdd0f01-d30f-4165-860f-2e109286a646"),
    LOCAL_PESSOAS_INTERESSAM("Local onde estão as pessoas que me interessam", "1c7cbb74-da22-4ec1-85b7-5587ce228204"),
    LOCAL_ATIVIDADES("Local no qual consigo realizar minhas atividades", "250bb5fd-966e-4d73-8902-e197de7bdc1b"),
    OUTRO("Outro", "5f06efa4-7612-483a-9e07-78097e405240"),

    KEEP_FURNISHINGS("Na sua moradia, foi possível acomodar seus antigos móveis e eletrodomésticos?", "c0bbed6d-0847-4c4c-b6d4-c6b3e5d435e9"),
    KEEP_FURNISHINGS_WHY("Por que não houve dificuldade em acomodar os antigos móveis e eletrodomésticos?", "045ab70a-dbd8-4a21-b01a-85416b56eb42"),

    DIFFICULTY_KEEP_FURNISHINGS("Informe o grau de dificuldade para a acomodação dos móveis e eletrodomésticos.", "cfca5271-bf24-4a5a-9491-dfe618587474"),

    NO_DIFFICULTY_KEEP_FURNISHINGS("Por que não houve dificuldade em acomodar os antigos móveis e eletrodomésticos?", "045ab70a-dbd8-4a21-b01a-85416b56eb42"),

    HAS_DIFFICULTY_KEEP_FURNISHINGS("Por que houve dificuldade em acomodar os antigos móveis e eletrodomésticos?", "eabb1f63-ff85-4269-8823-7e4a910af7c8"),

    HAS_ADAPTED_HOME("Você se adaptou à sua moradia e se identifica com ela?", "5cc778e8-d0c7-4977-967f-4ddea9439e73"),

    USE_AS_EXTRA("Você utiliza sua moradia para adquirir alguma renda extra?", "d24687d4-b946-414c-8e87-b05b07f9186d"),
    USE_AS_EXTRA_YES("Que atividade(s) você realiza como fonte de renda em casa?","5568d4a6-5adc-4603-baa9-27897b94f94f"),

    PERSONS_USES_AS_EXTRA("Quantos moradores utilizam a moradia como fonte de renda?", "fc37e38c-9a6d-4516-ae4d-9a7901f10f6d"),

    ACTIVITY_TYPE("Que atividade(s) você realiza como fonte de renda em casa?", "5568d4a6-5adc-4603-baa9-27897b94f94f"),

    ACTIVITY_USE_TYPE(" Em casos de utilização da moradia como fonte de renda, o espaço é utilizado: ", "468ca815-651d-4e04-b080-79b515a50267"),

    UTIL_AREA("Qual a área útil aproximada da sua moradia?", "e83d7493-9e98-49b5-8d16-8ba4a9eec2e3"),

    SATISFACTION_FOR_ROOMS("Qual a sua satisfação em relação à capacidade dos cômodos da sua moradia de se alterarem a funções diferentes?", "08639e9f-58ae-427a-92b8-0a4ee2855bc0"),

    TECNOLOGY_IMPORTANCE("A tecnologia, em especial a Internet, influencia nas relações pessoais dentro da moradia?", "a5bc5140-1d35-4c2c-8c59-9507ff325512"),

    REFORM_MADE("Quais dessas alterações ou reformas foram feitas nos cômodos da sua moradia?", "f27964ad-78b5-4d2b-98ea-984c6dcdb431"),

    CHANGE_TO_BETTER_ATEMPTEMENT("A sua moradia permite fazer alterações para atender melhor sua necessidade ou seu gosto?", "2db6b9e3-7374-47eb-b2ba-9b584b094876"),

    WHY_DONT_REFORM("Se não foram feitas alterações, quais os motivos?", "14a28215-bfa0-4887-a533-7baac8819afa"),

    SUN_RECEIVE("Em que período do dia sua moradia recebe mais sol?", "44ad4fc1-aa86-4a45-9839-f46ff68b67bd"),

    BETTER_SUN("Quais cômodos da sua moradia recebem mais sol?", "c5d16ef3-dcd2-4401-b37c-a80d72052408"),

    EXISTING_ROOMS("Muito bem. Agora selecione os cômodos ou espaços que existem na sua moradia.", "4e190989-5d7e-4c41-875a-b1f2f98b4edb"),
    SALA_TV("Sala de TV/Estar", "08cb63f0-e52d-49d1-88a9-71274c70ed8b"),
    COZINHA("Cozinha", "fcb91912-9be5-4fbc-9431-4e82e57e3c2a"),
    QUARTO_SOLTEIRO("Quarto Solteiro", "a9f26702-5bee-4f2f-b315-5b8cd1d36ad2"),
    QUARTO_CASAL("Quarto Casal", "1863e65b-43cd-4b96-a6ca-33dbdf3f72c9"),
    SALA_JANTAR("Sala de Jantar", "08745e79-a012-4534-bb14-dfaad77126b5"),
    BANHEIROS("Banheiros", "51762e29-522c-4e86-9c07-bcd4e1eb0f44"),
    VARANDA("Varanda", "2fb18b32-08aa-4c21-a1d5-389e7d02d00a"),
    AREA_SERVICO("Área de serviço", "caceae0c-b2a0-4561-be51-8f3f81952d93"),

    CHANGES_MADE("Se foram feitas alterações, quais? ", "9ced6daa-73c8-4422-86b4-630b5983b52a"),

    NO_CHANGES_MADE("Se nenhuma alteração foi feita, qual (is) o(s) motivo(s)?", "1df2708b-e6c1-44cf-83d9-a083d27c1e24"),

    MADE_LIST_CHANGES("Você já realizou alguma das alterações listadas na questão anterior?", "4dfb331c-d1fd-4da8-a763-e11fdfa42a31"),

    NEIGHBORHOOD_DELIMITATION_TYPE("Existe alguma delimitação/barreira entre a sua moradia e a vizinhança?", "f0ce08bf-d19e-4946-bf47-bb63329c37a0"),
    KITCHEN_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem na COZINHA?", "3f60ae3f-1439-4692-a0b8-97b08590fd5a"),
    BALCONY_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem na VARANDA?", "3ea3e786-8acc-4f8f-9dea-a4146ae7fd09"),
    DINNERROOM_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem na SALA DE JANTAR?", "960269fb-8a0f-4063-842e-2eee996678d0"),
    ROOM_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem na SALA DE ESTAR?", "39bb42b5-f4f7-4c60-82a2-79c0e52e9900"),
    SINGLEROMM_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem no DORMITÓRIO DE SOLTEIRO?", "2967af1f-d224-4f6e-83cb-297b10d3ef92"),
    BIGROOM_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem no DORMITÓRIO DE CASAL?", "86b74aeb-103a-4f39-8625-c9712bd90076"),
    BATHROOM_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem no BANHEIRO?", "6e04223a-0c4b-4b50-bddb-790f6a1be339"),
    SERVICE_AREA_ACTIVITIES("Além das atividades convencionais, o que você e os demais moradores fazem na ÁREA DE SERVIÇO?", "0b347736-9b46-4807-a5dd-8d46a1a9b579"),


    //VOLUME HORIZONTAL QUESTION
    SATISFACTION_BY_ROOM("Agora avalie sua moradia. Para cada característica, informe seu nível de satisfação.", "f8325fd8-ffc8-4752-9906-01d84788709a"),
    SIZE("Tamanho", "95ee01f6-c3ec-40b4-8d2e-15b1eef85d16"),
    DIVISION("Divisão dos cômodos", "2679e353-8fe3-46f2-8b7d-4b089d092c9b"),
    CONSTRUCTION_QUALITY("Qualidade da Construção", "6d36b1b6-3ba2-4797-96a0-d3564fec5529"),
    CLEAN_DIFFICULTY("Facilidade de limpeza", "52bc624b-a0f2-4bb8-bcc4-d103999047dc"),
    ADAPTATION("Adaptação", "cd477d19-ccbd-44bf-bd7b-d038daf9a562"),
    PRIVACY("Privacidade", "b786b3e3-8a38-40f3-ab65-7396d15d6a39"),

    //VOLUME HORIZONTAL QUESTION
    CHARACTERISTICS_SATISFACTION_BATHROOM("Agora avalie seu BANHEIRO. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea2807"),
    CHARACTERISTICS_SATISFACTION_BIGROOM("Agora avalie o DORMITÓRIO DE CASAL. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27fc"),
    CHARACTERISTICS_SATISFACTION_SINGLEROMM("Agora avalie o DORMITÓRIO DE SOLTEIRO. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27fb"),
    CHARACTERISTICS_SATISFACTION_ROOM("Agora avalie a SALA DE ESTAR. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27f4"),
    CHARACTERISTICS_SATISFACTION_DINNERROOM("Agora avalie a SALA DE JANTAR . Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea2802"),
    CHARACTERISTICS_SATISFACTION_BALCONY("Agora avalie a VARANDA. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea280f"),
    CHARACTERISTICS_SATISFACTION_KITCHEN("Agora avalie a COZINHA. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27f8"),
    CHARACTERISTICS_SATISFACTION_SERVICE_AREA("Agora avalie a ÁREA DE SERVIÇO. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea2813"),
    EASE_OF_FURNISHINGS("Facilidade de mobiliar", "5d0975d22771712aa06c6bf8"),
    TEMPERATURE("Temperatura", "5d0975832771712aa06c6bf6"),
    NATURAL_VENTILATION("Nível de Convivência", "590b5fd61e4d3f620eea2700"),
    NATURAL_ILUMINATION("Iluminação natural", "590b5fd61e4d3f620eea26ff"),
    NOISE_LEVEL("Nível de ruído", "5d0975be2771712aa06c6bf7"),
    SIZE_SATISFACTION("Tamanho", "59c5489bf9a75c213d64b215"),

    //VOLUME HORIZONTAL QUESTION
    REFORM_DIFICULTY("Considerando as alterações/reformas, diga-me o nível de dificuldade em:", "1c62df09-ca01-4f9c-be06-2b62582b4cfc"),
    CHANGE_FURNISHINGS_POSITION("Variar posição dos móveis", "11ce7cd4-8b1b-4fd5-9a34-c688ef52cb2e"),
    CAHNGE_ELETRONICS_POSITIONS("Variar posição dos eletrodomésticos", "26d24553-1e4e-4d40-abda-209356e0128a"),
    NATURAL_PLANTS("Inserir flores e plantas naturais", "2763cfa3-6e7c-4e36-9073-db864a5e53df"),
    PERSONAL_DECORATION("Inserir objetos pessoais decorativos ou de recordações", "151a6387-eb09-4986-b743-7e827f3555ad"),
    PAINT("Pintar e/ou usar papel de parede", "dd7e8db8-c8d8-497e-ac32-9110b662abe3"),
    DROP_WALL("Abrir vãos e/ou derrubar paredes", "beabd856-5e2c-4b7b-88bc-7c8687637b97"),
    PLASTER("Colocar forro de gesso", "f5d93dc1-5a75-4aec-bdf9-96d475aa9df3"),
    INNCREASE_POWER_PLUG("Acrescentar tomadas e/ou iluminação", "9704d09e-ff00-418a-8c43-0386c9b35cac"),

    //PODIUM QUESTION
    REFORM_REASON("Quais foram as razões das reformas e alterações? Escolha por ordem de prioridade", "12bb5893-1908-48f2-9b2a-ac4a31d06fec"),
    ENLARGE_ROOM("Ampliar cômodo", "6f58ce93-1fe1-43ea-bfde-58a328deab47"),
    IMPROVE_FINISHING("Melhorar o acabamento", "0741977c-e4ba-4fda-ac36-5bf1a41dc2a0"),
    IMPROVE_CONFORT("Melhorar o conforto", "df2d3afd-f198-4cda-9d15-c98dba76fe45"),
    RESOLVE_TECNICAL_INSUE("Resolver problema técnico", "66bbebf7-707e-4e69-9b12-b16b8e9ece3e"),
    DECREASE_ROOM("Diminuir cômodo", "e3c30d96-ceaf-4c24-bb65-879a2efaaf3f"),
    CHANGE_ROOM_FUNCTION("Alterar a função do cômodo", "bb390dde-75e1-4669-a198-728cb6a3184c"),
    OTHER_REASON("Outro", "9cc882c1-ed15-4e34-9509-f5e5a671a759"),
    ELIMINATE_ROOM("Eliminar cômodo", "6e9133a7-b6b9-4d19-a8c7-03388ea0980e");

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
