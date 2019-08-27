package br.com.como_voce_mora.ui.aboutyou;

import android.content.Intent;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseActivity;
import butterknife.OnClick;

public class SplashAboutYouActivity extends BaseActivity {
    @Override
    public int getResLayout() {
        return R.layout.activity_splash_about_you;
    }

    @OnClick(R.id.bt_touch_next)
    public void onClickTouchNext() {
        Intent intent = new Intent(this, AboutYouActivity.class);
        startActivity(intent);
        finish();
    }
}
