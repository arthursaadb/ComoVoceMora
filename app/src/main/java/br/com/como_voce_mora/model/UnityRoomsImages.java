package br.com.como_voce_mora.model;

import br.com.como_voce_mora.R;

public enum UnityRoomsImages {
    BATHROOM(R.drawable.banheiro_iluminacao, R.drawable.banheiro_mobiliar, R.drawable.banheiro_ruido, R.drawable.banheiro_tamanho, R.drawable.banheiro_temperatura, R.drawable.banheiro_ventilacao),
    BIGROOM(R.drawable.casal_iluminacao, R.drawable.casal_mobiliar, R.drawable.casal_ruido, R.drawable.casal_tamanho, R.drawable.casal_temperatura, R.drawable.casal_ventilacao),
    SINGLEROOM(R.drawable.solteiro_iluminacao, R.drawable.solteiro_mobiliar, R.drawable.solteiro_ruido, R.drawable.solteiro_tamanho, R.drawable.solteiro_temperatura, R.drawable.solteiro_ventilacao),
    ROOM(R.drawable.estar_iluminacao, R.drawable.estar_mobiliar, R.drawable.estar_ruido, R.drawable.estar_tamanho, R.drawable.estar_temperatura, R.drawable.estar_ventilacao),
    DINNERROOM(R.drawable.jantar_iluminacao, R.drawable.jantar_mobiliar, R.drawable.jantar_ruido, R.drawable.jantar_tamanho, R.drawable.jantar_temperatura, R.drawable.jantar_ventilacao),
    BALCONY(R.drawable.varanda_iluminacao, R.drawable.varanda_mobiliar, R.drawable.varanda_ruido, R.drawable.varanda_tamanho, R.drawable.varanda_temperatura, R.drawable.varanda_ventilacao),
    KITCHEN(R.drawable.cozinha_iluminacao, R.drawable.cozinha_mobiliar, R.drawable.cozinha_ruido, R.drawable.cozinha_tamanho, R.drawable.cozinha_temperatura, R.drawable.cozinha_ventilacao),
    SERVICE(R.drawable.servico_iluminacao, R.drawable.servico_mobiliar, R.drawable.servico_ruido, R.drawable.servico_tamanho, R.drawable.servico_temperatura, R.drawable.servico_ventilacao);


    int iluminacao;
    int mobiliar;
    int ruido;
    int tamanho;
    int temperatura;
    int ventilacao;

    public int getIluminacao() {
        return iluminacao;
    }

    public void setIluminacao(int iluminacao) {
        this.iluminacao = iluminacao;
    }

    public int getMobiliar() {
        return mobiliar;
    }

    public void setMobiliar(int mobiliar) {
        this.mobiliar = mobiliar;
    }

    public int getRuido() {
        return ruido;
    }

    public void setRuido(int ruido) {
        this.ruido = ruido;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getVentilacao() {
        return ventilacao;
    }

    public void setVentilacao(int ventilacao) {
        this.ventilacao = ventilacao;
    }

    UnityRoomsImages(int iluminacao, int mobiliar, int ruido, int
            tamanho, int temperatura, int ventilacao
    ) {
        this.iluminacao = iluminacao;
        this.mobiliar = mobiliar;
        this.ruido = ruido;
        this.tamanho = tamanho;
        this.temperatura = temperatura;
        this.ventilacao = ventilacao;
    }
}
