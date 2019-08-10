package br.com.como_voce_mora.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.como_voce_mora.R;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        setContentView(getResLayout());
        mUnBinder = ButterKnife.bind(this);

        init();
    }

    @Override
    protected void onDestroy() {
        mUnBinder.unbind();
        super.onDestroy();
    }

    public abstract int getResLayout();

    public void init() {

    }
}
