package br.com.como_voce_mora.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;

import static br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar.*;

public class PlayGroundActivity extends AppCompatActivity {

    @BindView(R.id.progress)
    HowYouLiveProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
        ButterKnife.bind(this);

        new Handler().postDelayed(() -> progressBar.setProgress(HowYouLive.BEFORE_RESIDENCE), 1500);
    }
}
