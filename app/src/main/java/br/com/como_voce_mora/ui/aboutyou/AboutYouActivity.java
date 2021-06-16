package br.com.como_voce_mora.ui.aboutyou;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseActivity;
import br.com.como_voce_mora.ui.housegroup.HabitationEquipmentsFragment;
import br.com.como_voce_mora.ui.sustainablehabits.DoYouKnowMedicamentExpiredFragment;
import br.com.como_voce_mora.ui.sustainablehabits.DoYouSeparateGarbageFragment;
import br.com.como_voce_mora.ui.sustainablehabits.DoYouSeparateOilFragment;
import br.com.como_voce_mora.ui.sustainablehabits.ExpiredMedicationFragment;
import br.com.como_voce_mora.ui.sustainablehabits.WhatYouDoToSaveElectricity;
import br.com.como_voce_mora.ui.sustainablehabits.WhatYouDoToSaveWater;
import br.com.como_voce_mora.ui.unity.UnityRateRoomsFragment;
import br.com.como_voce_mora.ui.unity.UnityReformsNoNeedFragment;
import br.com.como_voce_mora.ui.unity.UnityReformssNeeds;
import br.com.como_voce_mora.ui.unity.UnitySatisfactionRoom;

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
//            List<UnityAnswer> unityAnswers = new ArrayList<>();
//            unityAnswers.add(UnityAnswer.CHARACTERISTICS_SATISFACTION_ROOM);
//            unityAnswers.add(UnityAnswer.CHARACTERISTICS_SATISFACTION_BALCONY);
            replaceFragment(WhatYourGenderFragment.newInstance());
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
