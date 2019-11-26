package br.com.como_voce_mora.ui.building;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomPodium;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.aboutyou.HowOldAreYouFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class NegativePointsFragment extends BaseFragment {
    @BindView(R.id.progressBar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.cpPodium)
    CustomPodium customPodium;
    @BindViews({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
        R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption})
    List<Button> mButtons;


    public static NegativePointsFragment newInstance() {
        return new NegativePointsFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_negative_points;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        customPodium.setOnPodiumListener(xqdl -> {
            for (Button b : mButtons) {
                if (b.getText().equals(xqdl)) {
                    b.setVisibility(View.VISIBLE);
                }
            }
        });
        super.init();
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(BuildingFloorFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
        R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption})
    public void onClickOptions(View view) {
        Button textView = (Button) view;
        customPodium.putOnPodium(textView.getText().toString());
        textView.setVisibility(View.INVISIBLE);
    }


}
