package br.com.como_voce_mora.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.AppController;
import br.com.como_voce_mora.db.PostContract;
import br.com.como_voce_mora.db.SingletonCurrentResident;

import static android.database.sqlite.SQLiteDatabase.CONFLICT_REPLACE;
import static br.com.como_voce_mora.db.PostContract.PostEntry.TABLE_NAME_APO;
import static br.com.como_voce_mora.db.PostContract.PostEntry.TABLE_NAME_MORADOR;

public class ResearchFlow {
    private static final ResearchFlow ourInstance = new ResearchFlow();

    private static boolean house = true;

    public static ResearchFlow getInstance() {
        return ourInstance;
    }

    private ResearchFlow() {
    }

    public static void addAnswer(AnswerRequest answerRequest, Fragment fragment) {
        ContentValues valuesMorador = new ContentValues();
        valuesMorador.put(PostContract.PostEntry.COLUMN_NAME_MORADOR_ID, SingletonCurrentResident.getInstance().getCurrentResident());

        ContentValues values = new ContentValues();
        values.put(PostContract.PostEntry.COLUMN_NAME_SCREEN, fragment.getClass().getName());
        values.put(PostContract.PostEntry.COLUMN_NAME_MORADOR_ID, SingletonCurrentResident.getInstance().getCurrentResident());
        values.put(PostContract.PostEntry.COLUMN_NAME_DWELLER_ID, answerRequest.getDwellerId());
        values.put(PostContract.PostEntry.COLUMN_NAME_QUESTION_PART_ID, answerRequest.getQuestionPartId());
        values.put(PostContract.PostEntry.COLUMN_NAME_TEXTO, answerRequest.getTexto());
        values.put(PostContract.PostEntry.COLUMN_NAME_EVALUATION_ID, answerRequest.getEvaluationId());

        SQLiteDatabase db = AppController.getInstance().getDbHelper().getWritableDatabase();
        try {
            db.insertWithOnConflict(TABLE_NAME_MORADOR, null, valuesMorador, CONFLICT_REPLACE);
            db.insertWithOnConflict(TABLE_NAME_APO, null, values, CONFLICT_REPLACE);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getList();
    }

    public static List<AnswerRequest> getList() {
        List<AnswerRequest> listAnswerRequest = new ArrayList<>();

        SQLiteDatabase db = AppController.getInstance().getDbHelper().getReadableDatabase();
        try {
            String currentResident = String.valueOf(SingletonCurrentResident.getInstance().getCurrentResident());
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_APO + " WHERE " + PostContract.PostEntry.COLUMN_NAME_MORADOR_ID + " = ?", new String[]{currentResident});

            if (cursor.moveToFirst()) {
                do {
                    AnswerRequest answerRequest = new AnswerRequest();

                    answerRequest.setDwellerId(cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_NAME_DWELLER_ID)));
                    answerRequest.setQuestionPartId(cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_NAME_QUESTION_PART_ID)));
                    answerRequest.setTexto(cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_NAME_TEXTO)).replaceAll("\\n", ""));
                    answerRequest.setEvaluationId(cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_NAME_EVALUATION_ID)));

                    listAnswerRequest.add(answerRequest);
                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return listAnswerRequest;
    }

    public static ScreenAndMoradorId getQuestionLast() {
        SQLiteDatabase db = AppController.getInstance().getDbHelper().getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_APO, null);

            cursor.moveToLast();

            ScreenAndMoradorId screenAndMoradorId = new ScreenAndMoradorId();

            screenAndMoradorId.setMoradorId(cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_NAME_MORADOR_ID)));
            screenAndMoradorId.setScreen(cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_NAME_SCREEN)));

            return screenAndMoradorId;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void resetDabase() {
        SQLiteDatabase db = AppController.getInstance().getDbHelper().getWritableDatabase();
        db.delete(TABLE_NAME_MORADOR, null, null);
        db.delete(TABLE_NAME_APO, null, null);
    }

    public static void setHouse(boolean houseChecked) {
        house = houseChecked;
    }

    public static boolean getHouse() {
        return house;
    }
}
