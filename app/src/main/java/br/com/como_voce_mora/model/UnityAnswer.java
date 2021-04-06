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
    KEEP_FURNISHINGS_WHY("Por que não houve dificuldade em acomodar os antigos móveis e eletrodomésticos?", "eabb1f63-ff85-4269-8823-7e4a910af7c8"),

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

    MADE_LIST_CHANGES("Você já realizou alguma das alterações listadas na questão anterior?", "4dfb331c-d1fd-4da8-a763-e11fdfa42a31"),
    MADE_LIST_CHANGES_YES("Se foram feitas alterações, quais?", "9ced6daa-73c8-4422-86b4-630b5983b52a"),
    MADE_LIST_CHANGES_NO("Se nenhuma alteração foi feita, qual (is) o(s) motivo(s)?","1df2708b-e6c1-44cf-83d9-a083d27c1e24"),

    NEIGHBORHOOD_DELIMITATION_TYPE("Existe alguma delimitação/barreira entre a sua moradia e a vizinhança?", "821adcc8-00ec-4c9e-a425-ffd97f0aa784"),
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
    CHARACTERISTICS_SATISFACTION_ROOM("Agora avalie a SALA DE ESTAR. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27f4"),
    EASE_OF_FURNISHINGS_ROOM("Facilidade de mobiliar", "f8e3755b-608b-49fc-a440-30eb52ffd6e6"),
    TEMPERATURE_ROOM("Temperatura", "e491024b-b0b5-4651-b187-6abd6993aba7"),
    NATURAL_VENTILATION_ROOM("Nível de Convivência", "dc05adb7-ffca-48ec-be02-b16bfcce3c56"),
    NATURAL_ILUMINATION_ROOM("Iluminação natural", "5775cb64-5020-410b-9e09-98d672fff301"),
    NOISE_LEVEL_ROOM("Nível de ruído", "19b3ad51-a591-430d-9c51-54ccf385a060"),
    SIZE_SATISFACTION_ROOM("Tamanho", "be9a5c6c-6cf8-4c47-bdb7-a2e0a9a7478b"),

    CHARACTERISTICS_SATISFACTION_KITCHEN("Agora avalie a COZINHA. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27f8"),
    EASE_OF_FURNISHINGS_KITCHEN("Facilidade de mobiliar", "eebac32e-df4c-4244-8a75-cf04e899b070"),
    TEMPERATURE_KITCHEN("Temperatura", "2090d3f5-2437-42ff-b197-8ea723d44869"),
    NATURAL_VENTILATION_KITCHEN("Nível de Convivência", "ae72adb2-6d87-4be6-aa9e-b64e276302ce"),
    NATURAL_ILUMINATION_KITCHEN("Iluminação natural", "ca2f4dd8-22cd-4f0e-85b9-c0b133cecbc0"),
    NOISE_LEVEL_KITCHEN("Nível de ruído", "598b9f23-b8e8-4426-a701-960dee48cb6f"),
    SIZE_SATISFACTION_KITCHEN("Tamanho", "f13734a5-b0f3-40e8-bd48-ceefd668fac4"),

    CHARACTERISTICS_SATISFACTION_SINGLEROMM("Agora avalie o DORMITÓRIO DE SOLTEIRO. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27fb"),
    EASE_OF_FURNISHINGS_SINGLEROMM("Facilidade de mobiliar", "658e5b0d-b286-4b62-b151-5b8d0459e6bf"),
    TEMPERATURE_SINGLEROMM("Temperatura", "b7e45257-388d-4b51-a6ac-356c406fe045"),
    NATURAL_VENTILATION_SINGLEROMM("Nível de Convivência", "e116150e-d0d1-42c5-83f2-43c9ca743642"),
    NATURAL_ILUMINATION_SINGLEROMM("Iluminação natural", "9f968389-507b-48ff-af87-750e2e8f0d46"),
    NOISE_LEVEL_SINGLEROMM("Nível de ruído", "eab7335f-3015-45c8-996b-b9982ee2879a"),
    SIZE_SATISFACTION_SINGLEROMM("Tamanho", "ac96d741-6ade-4ea6-ad30-b1acfa79e816"),

    CHARACTERISTICS_SATISFACTION_BIGROOM("Agora avalie o DORMITÓRIO DE CASAL. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea27fc"),
    EASE_OF_FURNISHINGS_BIGROOM("Facilidade de mobiliar", "de682fd7-b4a9-42cc-bb73-782933e257c0"),
    TEMPERATURE_BIGROOM("Temperatura", "f6820363-d0c5-4541-b44a-d75c21310911"),
    NATURAL_VENTILATION_BIGROOM("Nível de Convivência", "a3c030bf-5e84-4b48-855b-6297c1a6ff59"),
    NATURAL_ILUMINATION_BIGROOM("Iluminação natural", "88ab3e8d-0db8-4012-bd18-928436ce68b1"),
    NOISE_LEVEL_BIGROOM("Nível de ruído", "b69426a2-996e-40d3-849d-0cda896f5f40"),
    SIZE_SATISFACTION_BIGROOM("Tamanho", "fd65fa55-6148-441c-ae6e-5f050d765d37"),

    CHARACTERISTICS_SATISFACTION_BATHROOM("Agora avalie seu BANHEIRO. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea2807"),
    EASE_OF_FURNISHINGS_BATHROOM("Facilidade de mobiliar", "90f3da37-2e78-4a30-ae7a-d97e12994973"),
    TEMPERATURE_BATHROOM("Temperatura", "8a04f20c-6fef-4a45-8b26-c92e1b0a8c9d"),
    NATURAL_VENTILATION_BATHROOM("Nível de Convivência", "d1d491d5-354e-4988-a889-295fa154a4dd"),
    NATURAL_ILUMINATION_BATHROOM("Iluminação natural", "77e6d3cb-96bd-4b16-9aaa-e7d996bf4796"),
    NOISE_LEVEL_BATHROOM("Nível de ruído", "952cc96c-960c-473f-8e94-a0e694bfb0dc"),
    SIZE_SATISFACTION_BATHROOM("Tamanho", "71365fe0-561a-4de5-ac45-157526306a95"),

    CHARACTERISTICS_SATISFACTION_BALCONY("Agora avalie a VARANDA. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea280f"),
    EASE_OF_FURNISHINGS_BALCONY("Facilidade de mobiliar", "90f3da37-2e78-4a30-ae7a-d97e12994973"),
    TEMPERATURE_BALCONY("Temperatura", "8a04f20c-6fef-4a45-8b26-c92e1b0a8c9d"),
    NATURAL_VENTILATION_BALCONY("Nível de Convivência", "d1d491d5-354e-4988-a889-295fa154a4dd"),
    NATURAL_ILUMINATION_BALCONY("Iluminação natural", "77e6d3cb-96bd-4b16-9aaa-e7d996bf4796"),
    NOISE_LEVEL_BALCONY("Nível de ruído", "952cc96c-960c-473f-8e94-a0e694bfb0dc"),
    SIZE_SATISFACTION_BALCONY("Tamanho", "71365fe0-561a-4de5-ac45-157526306a95"),

    CHARACTERISTICS_SATISFACTION_SERVICE_AREA("Agora avalie a ÁREA DE SERVIÇO. Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea2813"),
    EASE_OF_FURNISHINGS_SERVICE_AREA("Facilidade de mobiliar", "3d89f069-d22d-48c5-bc56-9164831b2fd3"),
    TEMPERATURE_SERVICE_AREA("Temperatura", "8af3109c-5cc9-4a76-a51b-12f97ba169e4"),
    NATURAL_VENTILATION_SERVICE_AREA("Nível de Convivência", "6a31d8ca-e1cd-4b5d-b8e3-7a2c7e0bf11c"),
    NATURAL_ILUMINATION_SERVICE_AREA("Iluminação natural", "aadd9d72-001c-432a-b26a-85ce8b6c4af8"),
    NOISE_LEVEL_SERVICE_AREA("Nível de ruído", "4e4fe290-5d85-42ca-932c-0b49ec2474d9"),
    SIZE_SATISFACTION_SERVICE_AREA("Tamanho", "e7df3378-feed-440c-a2af-aa142763f505"),

    CHARACTERISTICS_SATISFACTION_DINNERROOM("Agora avalie a SALA DE JANTAR . Para cada característica, informe o seu nível de satisfação.", "590b5fd61e4d3f620eea2802"),
    EASE_OF_FURNISHINGS_DINNERROOM("Facilidade de mobiliar", "919ec16f-754b-4f05-81ce-7417d78d960f"),
    TEMPERATURE_DINNERROOM("Temperatura", "12070b13-541d-4a91-bd56-43b70b982c69"),
    NATURAL_VENTILATION_DINNERROOM("Nível de Convivência", "93ad07d3-0e04-4d50-816c-c21c2b93205f"),
    NATURAL_ILUMINATION_DINNERROOM("Iluminação natural", "a3b5bdb9-f3d3-4d43-86e5-6b92e01a78b3"),
    NOISE_LEVEL_DINNERROOM("Nível de ruído", "9a2ddd0b-205f-47c3-b567-59c4225fe769"),
    SIZE_SATISFACTION_DINNERROOM("Tamanho", "43cd008d-a62d-4109-9ef4-278c7ee61de1"),

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
