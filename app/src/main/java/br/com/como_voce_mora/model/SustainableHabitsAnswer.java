package br.com.como_voce_mora.model;

public enum SustainableHabitsAnswer {
    YOU_SAVE_WATER("Você economiza água, por que?", "d30fb458-32d3-44ee-bec1-7c91688c4eec"),
    WHAT_YOU_DO_TO_SAVE_WATER("O que você faz para economizar água?", "168e1a8a-d7c6-4537-ba07-c4b5f98b6f12"),
    WATHER_SAVE_EQUIPMENT("Quais tipos de equipamentos economizadores de água você possui?", "895c35c1-6cc3-4855-a350-8339c71a5940"),
    WATER_SAVE_NO_EQUIPMENT("Por qual motivo você não possui equipamentos economizadores de água?", "b996cc9f-6b63-4f83-be81-eeee7add622f"),
    YOU_SAVE_ELECTRICITY("Você economiza energia elétrica, por que?", "42926ab4-d439-46a2-88b2-3f6777af3a9e"),
    WHAT_YOU_DO_TO_SAVE_ELECTRICITY("O que você faz para economizar energia elétrica", "422e82be-55a2-4255-8f57-fd239f9c36ff"),
    DIFFERENCE_TARIFF_FLAGS("Você sabe qual é a diferença entre as bandeiras tarifáricas na conta de energia elétrica", "5a895b08-e230-4088-915f-d4fc94c8f86e"),
    EQUIPMENT_SOLAR_ENERGY("Na sua habitação, há algum equipamento que usa energia solar?", "e0c00e17-2c21-438c-b7d9-5cd6cbd96ad0"),
    WHYY_NOT_USE_EQUIPMENT("Por quê você não usa esse tipo de equipamento (painéis fotovoltaicos ou placas solares", "5931e972-031f-42f6-a0ae-42175117af4f"),
    SEPARATE_GARBAGE("Você separa o lixo entre reciclável e  comum?", "20250b0a-3b37-4385-a270-b2a89f468e41"),
    WHERE_GO_GARBAGE("Você sabe para onde o lixo reciclável da sua cidade vai?", "865d4d09-ad88-4707-aa87-e09f39e0a0d8"),
    ECOPOINT("Você conhece algum Ecoponto próximo da sua residência?", "6fc85561-cdd7-46cc-9ffa-08085d090c3c"),
    SEPARATE_OIL("Você separa o óleo dos outros tipos de resíduos, por que?", "156b325d-5528-4904-9dc2-371ecf9f3459"),
    CONSTRUCTION("O que você faz com resíduos de construção civil?", "47ae10c6-25ff-4ade-9f24-99f2621f065c"),
    ELETRONIC("Como você realiza o descarte de baterias e equipamentos eletrônicos?", "9a00c5a6-0e49-4f2d-8d85-3a7602658fdc"),
    MEDICAMENT_EXPIRED("Como você realiza o descarte de medicamentos vencidos?", "d2b057a1-c7ce-4c68-99e2-124608adc583"),
    ORGANIC_FOOD("Você consome alimentos orgânicos, aqueles produzidos sem substâncias químicas (como agrotóxicos ou hormônios)?", "471da053-f617-4ce0-8b0a-553cf267ab15"),
    ORGANIC_FOOD_WHY("Por que você consome alimento orgânico?", "9532d492-6939-48fd-90e3-4f99ae51bc09"),
    ORGANIC_FOOD_WHY_NOT("Por que você não consome alimento orgânico?", "9532d492-6939-48fd-90e3-4f99ae51bc09"),
    ORGANIC_FOOD_TYPE("Quais tipos de alimentos você consome?", "14fe2b14-1e97-439c-bde7-b2187f58cea0"),
    ORGANIC_FOOD_TRANSPORT("Quando você vai ao supermercado, como transporta as mercadorias compradas?", "d63ebfcc-d651-4786-a870-d375efa8a346"),
    PLANTS("Você possui plantas em sua moradia?", "67af8ecc-683f-43bf-9f9b-fa5052c68f06"),
    PLANTS_TYPE("Quais tipos de plantas você possui?", "96b9d058-dde7-459b-8ef5-c2e239b295ee"),
    TRANSPORTATION("Qual meio de transporte você utiliza nos casos abaixo?", "78dc7b91-0acc-4e59-ac9e-32a1624f34a3"),
    TRANSPORTATION_REASON("Em relação ao meio de transporte que você mais utiliza, explique sua escolha. Pode marcar mais de uma resposta", "0670c264-4236-4c04-a227-b682098dbc58");

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