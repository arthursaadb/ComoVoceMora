package br.com.como_voce_mora.model;

public enum SustainableHabitsAnswer {
    YOU_SAVE_WATER("Você economiza água, por que?", ""),
    WHAT_YOU_DO_TO_SAVE_WATER("O que você faz para economizar água?", ""),
    WATER_SAVE_EQUIPMENT("Por qual motivo você não possui equipamentos economizadores de água?", ""),
    YOU_SAVE_ELECTRICITY("Você economiza energia elétrica, por que?", ""),
    WHAT_YOU_DO_TO_SAVE_ELECTRICITY("O que você faz para economizar energia elétrica", ""),
    DIFFERENCE_TARIFF_FLAGS("Você sabe qual é a diferença entre as bandeiras tarifáricas na conta de energia elétrica", ""),
    EQUIPMENT_SOLAR_ENERGY("Na sua habitação, há algum equipamento que usa energia solar?", ""),
    WHYY_NOT_USE_EQUIPMENT("Por quê você não usa esse tipo de equipamento (painéis fotovoltaicos ou placas solares", ""),
    SEPARATE_GARBAGE("Você separa o lixo entre reciclável e comum?", ""),
    WHERE_GO_GARBAGE("Você sabe para onde o lixo reciclável da sua cidade vai?", ""),
    ECOPOINT("Você conhece algum Ecoponto próximo da sua residência?", ""),
    SEPARATE_OIL("Você separa o óleo dos outros tipos de resíduos, por que?",""),
    CONSTRUCTION("O que você faz com resíduos de construção civil?",""),
    ELETRONIC("Como você realiza o descarte de baterias e equipamentos eletrônicos?",""),
    MEDICAMENT_EXPIRED("Como você realiza o descarte de medicamentos vencidos?",""),
    ORGANIC_FOOD("Você consome alimentos orgânicos, aqueles produzidos sem substâncias químicas (como agrotóxicos ou hormônios)?",""),
    ORGANIC_FOOD_WHY("Por que", ""),
    ORGANIC_FOOD_TYPE("Quais tipos de alimentos você consome?",""),
    ORGANIC_FOOD_TRANSPORT("Quando você vai ao supermercado, como transporta as mercadorias compradas?",""),
    PLANTS("Você possui plantas em sua moradia?",""),
    PLANTS_TYPE("Quais tipos de plantas você possui?",""),
    TRANSPORTATION("Qual meio de transporte você utiliza nos casos abaixo?",""),
    TRANSPORTATION_REASON("Em relação ao meio de transporte que você mais utiliza, explique sua escolha. Pode marcar mais de uma resposta","");



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