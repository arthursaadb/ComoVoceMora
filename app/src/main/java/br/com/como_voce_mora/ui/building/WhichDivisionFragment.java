package br.com.como_voce_mora.ui.building;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.previoushouse.AcquisitionStateFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class WhichDivisionFragment extends BaseFragment {
    @BindView(R.id.progressBar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvMuro)
    CustomSelectedView csvMuro;
    @BindView(R.id.csvViva)
    CustomSelectedView csvViva;
    @BindView(R.id.csvGrade)
    CustomSelectedView csvGrade;
    @BindView(R.id.csvNone)
    CustomSelectedView csvNone;


    public static WhichDivisionFragment newInstance() {
        return new WhichDivisionFragment();
    }

    @Override
    public void init() {
        super.init();

    }

    @OnClick({R.id.csvViva, R.id.csvMuro, R.id.csvGrade, R.id.csvNone})
    public void onCheckedChanged(View view) {
        switch (view.getId()) {
            case R.id.csvViva:
                csvMuro.setChecked(true);
                csvViva.setChecked(false);
                csvGrade.setChecked(false);
                csvNone.setChecked(false);
                break;
            case R.id.csvMuro:
                csvMuro.setChecked(false);
                csvViva.setChecked(true);
                csvGrade.setChecked(false);
                csvNone.setChecked(false);
                break;
            case R.id.csvGrade:
                csvMuro.setChecked(false);
                csvViva.setChecked(false);
                csvGrade.setChecked(true);
                csvNone.setChecked(false);
                break;
            case R.id.csvNone:
                csvMuro.setChecked(false);
                csvViva.setChecked(false);
                csvGrade.setChecked(false);
                csvNone.setChecked(true);
                break;

        }
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_which_division;
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(BuildingFeelWellFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
    }
}
