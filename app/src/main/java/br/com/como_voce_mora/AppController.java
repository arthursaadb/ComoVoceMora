package br.com.como_voce_mora;

import android.app.Application;
import android.media.MediaPlayer;

public class AppController extends Application {
    private static AppController mInstance;
    public MediaPlayer mMediaPlayer;

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        AppController.getInstance().mMediaPlayer = MediaPlayer.create(mInstance, R.raw.sound);
    }
}
