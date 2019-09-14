package br.com.como_voce_mora.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.custom.CustomPodium;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;

import static br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar.*;

public class PlayGroundActivity extends AppCompatActivity {

    @BindView(R.id.progress)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.customPodium)
    CustomPodium customPodium;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
        ButterKnife.bind(this);

        customPodium.setOptions(getList());
        new Handler().postDelayed(() -> progressBar.setProgress(HowYouLive.BEFORE_RESIDENCE), 1500);
    }


    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("XQDL");
        list.add("DALE");
        list.add("DELE");
        list.add("DOLY");
        list.add("RELENS");
        list.add("RICKS");
        list.add("HOLE");
        list.add("MEEE");
        list.add("FUCK");
        list.add("DESQUEXELE");
        return list;
    }
}
