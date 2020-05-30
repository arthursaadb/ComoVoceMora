package br.com.como_voce_mora.ui.sustainablehabits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SustainableHabitsEndFragment extends BaseFragment {

    public SustainableHabitsEndFragment newInstance() {
        return new SustainableHabitsEndFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_sustainable_habits_end;
    }

    @Override
    public void init() {

    }

    @OnClick(R.id.rootLayout)
    public void onClickRoot() {
//        ((AboutYouActivity) requireActivity()).addFragment(WhyDoYouSaveWater.newInstance());
    }
}
