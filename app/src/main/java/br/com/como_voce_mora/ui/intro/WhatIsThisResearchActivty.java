package br.com.como_voce_mora.ui.intro;

import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import br.com.como_voce_mora.AppController;
import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class WhatIsThisResearchActivty extends BaseActivity {
    @BindView(R.id.ib_sound)
    ImageButton mIbSound;

    @Override
    public int getResLayout() {
        return R.layout.activity_what_is_this_research;
    }

    @Override
    public void init() {
        super.init();

        replaceFragment(WhatIsThisResearchFragment.newInstance());
    }

    @Override
    protected void onResume() {
        super.onResume();

        mIbSound.setImageResource(AppController.getInstance().mMediaPlayer.isPlaying() ? R.drawable.ic_speaker_on : R.drawable.ic_speaker_off);
    }

    @OnClick(R.id.ib_sound)
    public void playSound() {
        if (AppController.getInstance().mMediaPlayer.isPlaying()) {
            AppController.getInstance().mMediaPlayer.pause();
            mIbSound.setImageResource(R.drawable.ic_speaker_off);
            return;
        }

        AppController.getInstance().mMediaPlayer.start();
        mIbSound.setImageResource(R.drawable.ic_speaker_on);
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void addFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(fragment.getClass().getSimpleName())
                .add(R.id.container, fragment)
                .commit();
    }
}
