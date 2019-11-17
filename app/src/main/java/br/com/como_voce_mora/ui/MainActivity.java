package br.com.como_voce_mora.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import br.com.como_voce_mora.AppController;
import br.com.como_voce_mora.R;
import br.com.como_voce_mora.db.PostContract;
import br.com.como_voce_mora.ui.intro.IntroActivity;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validatePermissionWrite();
    }

    private void validatePermissionWrite() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            boolean shouldShowRequestPermission = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (shouldShowRequestPermission) {
                return;
            }

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL);
        } else {
            initApp();
        }
    }

    private void initApp() {
        startIntro();
//        insertTest();
    }

    private void startIntro() {
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
    }

//    private void insertTest() {
//        ContentValues valuesMorador = new ContentValues();
//        valuesMorador.put(PostContract.PostEntry.COLUMN_NAME_MORADOR_ID, "1");
//
//        ContentValues values = new ContentValues();
//        values.put(PostContract.PostEntry.COLUMN_NAME_MORADOR_ID, "1");
//        values.put(PostContract.PostEntry.COLUMN_NAME_PERGUNTA_ID, "1");
//        values.put(PostContract.PostEntry.COLUMN_NAME_RESPOSTA, "SIM");
//        values.put(PostContract.PostEntry.COLUMN_NAME_COMODO_ID, "");
//        values.put(PostContract.PostEntry.COLUMN_NAME_CONCEITO_ID, "");
//        values.put(PostContract.PostEntry.COLUMN_NAME_ATRIBUTO_ID, "");
//
//        SQLiteDatabase db = AppController.getInstance().getDbHelper().getWritableDatabase();
//        try {
//            db.insertOrThrow(PostContract.PostEntry.TABLE_NAME_MORADOR, null, valuesMorador);
//            db.insertOrThrow(PostContract.PostEntry.TABLE_NAME_APO, null, values);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initApp();
                }
            }
        }
    }
}
