package br.com.como_voce_mora.ui.intro;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.como_voce_mora.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InfoSaveDataActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info_save);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_ok)
    public void onClickOk() {
        Intent intent = new Intent(this, WhatIsThisResearchActivty.class);
        startActivity(intent);
    }
}
