package br.com.como_voce_mora.db;

import android.provider.BaseColumns;

public class PostContract {
    private PostContract() {
    }

    public static class PostEntry implements BaseColumns {
        public static final String TABLE_NAME_MORADOR = "morador";
        public static final String TABLE_NAME_APO = "apo";
        public static final String COLUMN_NAME_MORADOR_ID = "morador_id";
        public static final String COLUMN_NAME_PERGUNTA_ID = "pergunta_id";
        public static final String COLUMN_NAME_RESPOSTA = "resposta";
        public static final String COLUMN_NAME_COMODO_ID = "comodo_id";
        public static final String COLUMN_NAME_CONCEITO_ID = "conceito_id";
        public static final String COLUMN_NAME_ATRIBUTO_ID = "atributo_id";
    }
}
