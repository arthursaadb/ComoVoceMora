package br.com.como_voce_mora.ui.sustainablehabits;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.OnClick;

public class SustainableHabitsIntroFragment extends BaseFragment {

    public SustainableHabitsIntroFragment newInstance() {
        return new SustainableHabitsIntroFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_sustainable_habits_intro;
    }

    @OnClick(R.id.rootLayout)
    public void onClickRoot() {
        ((AboutYouActivity) requireActivity()).addFragment(WhyDoYouSaveWater.newInstance());
    }
}
