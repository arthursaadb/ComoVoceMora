package br.com.como_voce_mora.db;

import android.provider.BaseColumns;

public class PostContract {
    private PostContract() {
    }

    public static class PostEntry implements BaseColumns {
        public static final String TABLE_NAME_MORADOR = "morador";
        public static final String TABLE_NAME_APO = "apo";
        public static final String COLUMN_NAME_MORADOR_ID = "morador_id";
        public static final String COLUMN_NAME_DWELLER_ID = "dweller_id";
        public static final String COLUMN_NAME_QUESTION_PART_ID = "question_part_id";
        public static final String COLUMN_NAME_TEXTO = "texto";
        public static final String COLUMN_NAME_EVALUATION_ID = "evaluation_id";
        public static final String COLUMN_NAME_SCREEN = "screen";
    }
}
