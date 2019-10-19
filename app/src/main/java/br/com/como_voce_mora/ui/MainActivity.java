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

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            startIntro();
            insertTest();
        }
    }

    private void insertTest() {
        ContentValues values = new ContentValues();
        values.put(PostContract.PostEntry.COLUMN_NAME_TITLE, "Titulo do Post");
        values.put(PostContract.PostEntry.COLUMN_NAME_SUBTITLE, "Subtitulo do Post");

        SQLiteDatabase db = AppController.getInstance().getDbHelper().getWritableDatabase();
        try {
            db.insertOrThrow(PostContract.PostEntry.TABLE_NAME, null, values);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void startIntro() {
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startIntro();
                    insertTest();
                }
            }
        }
    }
}
