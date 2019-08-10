package br.com.como_voce_mora.ui.intro;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.como_voce_mora.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroActivity extends AppCompatActivity {
    @BindView(R.id.ib_sound)
    ImageButton mIbSound;

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ib_sound)
    public void playSound() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mIbSound.setImageResource(R.drawable.ic_speaker_off);
            return;
        }

        mMediaPlayer = MediaPlayer.create(this, R.raw.sound);
        mMediaPlayer.start();
        mIbSound.setImageResource(R.drawable.ic_speaker_on);
    }

    @OnClick(R.id.bt_start)
    public void start() {
        Intent intent = new Intent(this, InfoSaveDataActivity.class);
        startActivity(intent);
    }
}
