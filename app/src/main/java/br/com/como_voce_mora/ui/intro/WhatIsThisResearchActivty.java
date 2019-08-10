package br.com.como_voce_mora.ui.intro;

import androidx.fragment.app.Fragment;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseActivity;

public class WhatIsThisResearchActivty extends BaseActivity {
    @Override
    public int getResLayout() {
        return R.layout.activity_what_is_this_research;
    }

    @Override
    public void init() {
        super.init();

        replaceFragment(WhatIsThisResearchFragment.newInstance());
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
