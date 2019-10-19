package br.com.como_voce_mora;

import android.app.Application;
import android.media.MediaPlayer;

import br.com.como_voce_mora.db.PostDbHelper;

public class AppController extends Application {
    private static AppController mInstance;
    public MediaPlayer mMediaPlayer;
    private PostDbHelper mDbHelper;

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        AppController.getInstance().mMediaPlayer = MediaPlayer.create(mInstance, R.raw.sound);

        mDbHelper = new PostDbHelper(this);
    }

    public PostDbHelper getDbHelper() {
        return mDbHelper;
    }
}
