package br.com.como_voce_mora.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PostDbHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_TABLE_APO =
            "CREATE TABLE IF NOT EXISTS " +
                    PostContract.PostEntry.TABLE_NAME_APO + " (" +
                    PostContract.PostEntry.COLUMN_NAME_PERGUNTA_ID + TEXT_TYPE + " PRIMARY KEY," +
                    PostContract.PostEntry.COLUMN_NAME_MORADOR_ID + INTEGER_TYPE + COMMA_SEP +
                    PostContract.PostEntry.COLUMN_NAME_RESPOSTA + TEXT_TYPE + COMMA_SEP +
                    PostContract.PostEntry.COLUMN_NAME_COMODO_ID + TEXT_TYPE + COMMA_SEP +
                    PostContract.PostEntry.COLUMN_NAME_CONCEITO_ID + TEXT_TYPE + COMMA_SEP +
                    PostContract.PostEntry.COLUMN_NAME_ATRIBUTO_ID + TEXT_TYPE + COMMA_SEP +
                    " FOREIGN KEY " + " (" + PostContract.PostEntry.COLUMN_NAME_MORADOR_ID + ") " +
                    " REFERENCES "  + PostContract.PostEntry.TABLE_NAME_MORADOR +" (" +  PostContract.PostEntry.COLUMN_NAME_MORADOR_ID + ") " +
                    " )";

    private static final String SQL_CREATE_TABLE_MORADOR =
            "CREATE TABLE IF NOT EXISTS " +
                    PostContract.PostEntry.TABLE_NAME_MORADOR + " (" +
                    PostContract.PostEntry.COLUMN_NAME_MORADOR_ID + INTEGER_TYPE +" PRIMARY KEY AUTOINCREMENT)";

    private static final String SQL_DELETE_APO = "DROP TABLE IF EXISTS " + PostContract.PostEntry.TABLE_NAME_APO;
    private static final String SQL_DELETE_MORADOR = "DROP TABLE IF EXISTS " + PostContract.PostEntry.TABLE_NAME_MORADOR;

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "como_voce_mora.db";

    public PostDbHelper(Context context) {
        super(new DatabaseContext(context), DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_MORADOR);
        db.execSQL(SQL_CREATE_TABLE_APO);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_MORADOR);
        db.execSQL(SQL_DELETE_APO);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
