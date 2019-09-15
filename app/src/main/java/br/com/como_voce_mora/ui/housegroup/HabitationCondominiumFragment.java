package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.previoushouse.PreviousHomeTypeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationCondominiumFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;

    public static HabitationCondominiumFragment newInstance() {
        return new HabitationCondominiumFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_condominium;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(HabitationBlocksFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
    }
}
