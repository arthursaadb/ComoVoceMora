package br.com.como_voce_mora.ui.aboutyou;

import androidx.fragment.app.Fragment;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseActivity;
import br.com.como_voce_mora.ui.building.BuildingHouseNegativePointsFragment;
import br.com.como_voce_mora.ui.currentresidence.EquipamentsFragment;
import br.com.como_voce_mora.ui.housegroup.HabitationEquipmentsFragment;
import br.com.como_voce_mora.ui.housegroup.HabitationEquipmentsMeaningFragment;
import br.com.como_voce_mora.ui.housegroup.HabitationSatisfactionFragment;
import br.com.como_voce_mora.ui.sustainablehabits.DoYouSeparateOilFragment;
import br.com.como_voce_mora.ui.sustainablehabits.OrganicFoodTransportFragment;
import br.com.como_voce_mora.ui.sustainablehabits.PlantsFragment;
import br.com.como_voce_mora.ui.sustainablehabits.SolarEquipamentTypeFragment;
import br.com.como_voce_mora.ui.sustainablehabits.SustainableHabitsIntroFragment;
import br.com.como_voce_mora.ui.sustainablehabits.WhatYouDoToSaveElectricity;
import br.com.como_voce_mora.ui.sustainablehabits.WhyYouNotUseEquipamentFragment;
import br.com.como_voce_mora.ui.sustainablehabits.WhyYouSaveWaterFragment;
import br.com.como_voce_mora.ui.unity.UnityActualHouseLivingFragment;
import br.com.como_voce_mora.ui.unity.UnityRoomsFragment;

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
