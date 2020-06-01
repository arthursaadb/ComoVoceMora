package br.com.como_voce_mora.ui.sustainablehabits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.presenter.ServicesPresenter;
import br.com.como_voce_mora.presenter.ServicesPresenterContract;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SustainableHabitsEndFragment extends BaseFragment implements ServicesPresenterContract.View {

    private ServicesPresenter mPresenter = new ServicesPresenter(this);
    public SustainableHabitsEndFragment newInstance() {
        return new SustainableHabitsEndFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_sustainable_habits_end;
    }

    @Override
    public void init() {
        mPresenter.callService();
    }

    @OnClick(R.id.rootLayout)
    public void onClickRoot() {
//        ((AboutYouActivity) requireActivity()).addFragment(WhyDoYouSaveWater.newInstance());
    }

    @Override
    public void showId(String dwellerId) {

    }

    @Override
    public void showError(String azedou) {

    }

    @Override
    public void advice() {

    }
}
