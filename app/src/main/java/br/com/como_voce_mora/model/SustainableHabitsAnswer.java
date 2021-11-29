package br.com.como_voce_mora.model;

public enum SustainableHabitsAnswer {
    WHY_YOU_SAVE_WATER("Você economiza água? Por quê?", "44b61af9-3c58-41bc-8345-e364c9113504"),
    WHY_WATER("Por quê", "8171ab03-7f46-43f8-b162-b9f51e1e477c"),
    WHY_NOT_WATER("Por quê não", "afd8a06b-e27a-4081-a53a-e8f1400198d5"),

    WHAT_YOU_DO_TO_SAVE_WATER("O que você faz para economizar água?", "a133890b-12ab-4428-8947-32876ef7d4f5"),

    WATHER_SAVE_EQUIPMENT("Quais tipos de equipamentos economizadores de água você possui?", "ef597c20-d9da-4d18-a08d-5454ceb2d3bd"),
    MAQUINA_LAVAR_REUSO("Máquina de lavar com reuso", "90f3aac3-721a-4d27-8766-8e8048a2d6f2"),
    CAIXA_DE_AGUA("Caixa d'água para reuso", "4ca0c002-fc2e-4975-a74e-298a1758141a"),
    DESCARGA_DUPLO_FLUXO("Descarga duplo fluxo", "99c339bb-0a1f-4b37-967f-092eb2f3e52e"),
    VASO_CAIXA_ACOPLADA("Vaso caixa acoplada", "292141e4-d4f0-440f-884b-146dc4be9112"),
    TORNEIRA_ECONOMICA("Torneira", "70828956-4e94-457b-98ba-809584452511"),
    OUTRO("Outro", "70828956-4e94-457b-98ba-809584452511"),

    WATER_SAVE_NO_EQUIPMENT("Por qual motivo você não possui equipamentos economizadores de água?", "c84aa9d0-38f9-4342-b072-583c92cff9de"),

    WHY_YOU_SAVE_ELECTRICITY("Você economiza energia elétrica? Por quê?", "b2205f80-1cbd-4f18-b8da-791c9ab3207a"),
    WHY_ENERGY("Por quê", "548af430-7333-4a58-b421-8277312e1eee"),
    WHY_NOT_ENERGY("Por quê não", "8dbcd19d-1dde-4413-98f0-567603155d15"),

    WHAT_YOU_DO_TO_SAVE_ELECTRICITY("O que você faz para economizar energia elétrica?", "629e7294-7825-4625-830b-8d85dbc24e49"),

    DIFFERENCE_TARIFF_FLAGS("Você sabe qual é a diferença entre as bandeiras tarifárias na conta de energia elétrica", "dde24fec-73d8-4340-9b29-f5abf9ce1c40"),

    EQUIPMENT_SOLAR_ENERGY("Na sua habitação, há algum equipamento que usa energia solar?", "71180a9f-13ca-4081-abe7-6a0704f5fa47"),

    WHYY_NOT_USE_EQUIPMENT("Por que você não usa esse tipo de equipamento (painéis fotovoltaicos ou placas solares)?", "3d2aaac8-18e9-494f-8488-9f66dc76cdb8"),

    SEPARATE_GARBAGE("Você separa o lixo entre reciclável e comum?", "c48ef948-6333-408b-98fa-1247393284d7"),
    SEPARATE_GARBAGE_WHY("Por que você separa o lixo?", "d341e806-e271-40a9-a565-490b616cc086"),
    SEPARATE_GARBAGE_WHY_NOT("Por que você não separa o lixo? ", "f383074b-68b9-4ba2-9a32-5d27cf1ecf9d"),

    WHERE_GO_GARBAGE("Você sabe para onde o lixo reciclável da sua cidade vai?", "c2d1c266-e78c-4cd6-807a-f8b5224f3ca5"),

    ECOPOINT("Você conhece algum Ecoponto próximo da sua residência?", "09851d60-4a84-4d33-a347-4121d04d9476"),

    SEPARATE_OIL("Você separa o óleo dos outros tipos de resíduos? Por quê?", "86fc1f18-7ce5-4a49-9c9c-c23ee6c555d9"),
    WHY_OIL("Por quê", "0a8e5f3f-d731-4d72-8830-b7f4bd34922a"),
    WHY_NOT_OIL("Por quê não", "3bfe0168-c464-4280-ab79-39f10e430c53"),

    CONSTRUCTION("O que você faz com resíduos de construção civil?", "65dd4f91-d602-4349-9e3f-d31c6b108a02"),

    ELETRONIC("Como você realiza o descarte de baterias e equipamentos eletrônicos?", "8376b5d5-af92-465f-b663-16aa21cbae85"),

    MEDICAMENT_EXPIRED("Como você realiza o descarte de medicamentos vencidos?", "dd7e61a9-591d-4b09-9796-ca702830db5c"),

    ORGANIC_FOOD("Você consome alimentos orgânicos, aqueles produzidos sem substâncias químicas (como agrotóxicos ou hormônios)?", "982676f2-3f33-4d56-818b-54f1464a1112"),

    ORGANIC_FOOD_WHY("Por que você consome alimento orgânico?", "293966a9-62f5-4ebf-ace0-5ca7b71b46b1"),

    ORGANIC_FOOD_WHY_NOT("Por que você não consome alimento orgânico?", "58f772fa-33f8-48bc-8a83-92a5052b7821"),

    ORGANIC_FOOD_TYPE("Que tipos de alimentos orgânicos você consome?", "c89d606f-a986-45f5-b0f3-b885ed81aed8"),

    ORGANIC_FOOD_TRANSPORT("Quando você vai ao supermercado, como transporta as mercadorias compradas?", "3e6d3972-3095-4de1-b668-b971de9f0afa"),

    PLANTS("Você possui plantas em sua moradia?", "0755c907-57c6-42bd-9086-d539267c8839"),
    PLANTS_WHY("Por que você possui plantas em sua moradia", "18ce234c-be87-4591-8e8f-7dbc97892604"),
    PLANTS_WHY_NOT("Por que você não possui plantas em sua moradia?", "ab21b4f3-eac7-49c3-ba5f-79391426025b"),

    PLANTS_TYPE("Quais tipos de plantas você possui?", "77ebfb8b-99db-4d09-b096-cb08a90ca08c"),

    TRANSPORTATION("Qual meio de transporte você utiliza nos casos abaixo?", "78dc7b91-0acc-4e59-ac9e-32a1624f34a3"),

    TRANSPORTATION_1("Até 500 metros (cinco quarteirões)", "93709e9b-c937-41be-b1d0-27fe1b1d655f"),

    TRANSPORTATION_2("De 500 até 1000 metros (cinco a dez quarteirões)", "a446b6e4-9a33-4e07-9e55-3fd1681d6db8"),

    TRANSPORTATION_3("Acima de 1000 metros (acima de 10 quarteirões)", "4c0ed869-3ae8-458c-8346-285d2b3bf9d9"),

    TRANSPORTATION_4("Meio de transporte mais utilizado no geral", "635e9d61-78d5-4d5a-8def-c1bfd1e3fc78"),

    TRANSPORTATION_REASON("Em relação ao meio de transporte que você mais utiliza, explique sua escolha. Pode marcar mais de uma resposta", "4e140ddb-98ed-4006-9ecc-1f7f5e39b8cf");

    String question;
    String questionPartId;

    SustainableHabitsAnswer(String question, String questionPartId) {
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