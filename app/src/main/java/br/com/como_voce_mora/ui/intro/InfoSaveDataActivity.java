package br.com.como_voce_mora.ui.intro;

import android.content.Intent;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseActivity;
import butterknife.OnClick;

public class InfoSaveDataActivity extends BaseActivity {
    @Override
    public int getResLayout() {
        return R.layout.activity_info_save;
    }

    @OnClick(R.id.bt_ok)
    public void onClickOk() {
        Intent intent = new Intent(this, WhatIsThisResearchActivty.class);
        startActivity(intent);
    }
}
