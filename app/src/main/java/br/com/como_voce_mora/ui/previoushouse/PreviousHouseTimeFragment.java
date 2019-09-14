package br.com.como_voce_mora.ui.previoushouse;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousHouseTimeFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;

    public static PreviousHouseTimeFragment newInstance() {
        return new PreviousHouseTimeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_previous_house_time;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            Toast.makeText(getContext(), "Em Desenvolvimento!", Toast.LENGTH_SHORT).show();
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
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
    }
}
