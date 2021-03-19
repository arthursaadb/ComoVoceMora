package br.com.como_voce_mora.ui.aboutyou;

import androidx.fragment.app.Fragment;

import java.util.Collections;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseActivity;
import br.com.como_voce_mora.ui.sustainablehabits.DoYouSeparateGarbageFragment;
import br.com.como_voce_mora.ui.sustainablehabits.DoYouSeparateOilFragment;
import br.com.como_voce_mora.ui.sustainablehabits.ExpiredMedicationFragment;
import br.com.como_voce_mora.ui.sustainablehabits.PlantsFragment;
import br.com.como_voce_mora.ui.sustainablehabits.PlantsTypeFragment;
import br.com.como_voce_mora.ui.sustainablehabits.TransportationReasonFragment;
import br.com.como_voce_mora.ui.sustainablehabits.WhatYouDoToSaveElectricity;
import br.com.como_voce_mora.ui.unity.UnityActualHouseLivingFragment;
import br.com.como_voce_mora.ui.unity.UnityMadeChanges;
import br.com.como_voce_mora.ui.unity.UnityRateRoomsFragment;
import br.com.como_voce_mora.ui.unity.UnityUtilAreaFragment;

public class AboutYouActivity extends BaseActivity {
    public static final String SCREEN_FRAGMENT = "screen-fragment";

    @Override
    public int getResLayout() {
        return R.layout.activity_about_you;
    }

    @Override
    public void init() {
        super.init();
        String screen = getIntent().getStringExtra(SCREEN_FRAGMENT);

        if (screen == null) {
            replaceFragment(UnityMadeChanges.newInstance(Collections.emptyList()));
            return;
        }

        try {
            Fragment fragment = (Fragment) Class.forName(screen).newInstance();
            replaceFragment(fragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                .replace(R.id.container, fragment)
                .commitAllowingStateLoss();
    }
}
