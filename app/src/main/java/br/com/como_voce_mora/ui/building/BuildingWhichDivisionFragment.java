package br.com.como_voce_mora.ui.building;

import android.view.View;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.housegroup.HouseGroupFragment;
import br.com.como_voce_mora.ui.unity.UnityAcquisitionFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingWhichDivisionFragment extends BaseFragment {
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvMuro)
    CustomSelectedView csvMuro;
    @BindView(R.id.csvViva)
    CustomSelectedView csvViva;
    @BindView(R.id.csvGrade)
    CustomSelectedView csvGrade;
    @BindView(R.id.csvNone)
    CustomSelectedView csvNone;

    private UnityAnswer unityAnswer = UnityAnswer.NEIGHBORHOOD_DELIMITATION_TYPE;
    private boolean anyOneSelected = false;


    public static BuildingWhichDivisionFragment newInstance() {
        return new BuildingWhichDivisionFragment();
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        tvQuestion.setText(unityAnswer.getQuestion());
    }

    @OnClick({R.id.csvViva, R.id.csvMuro, R.id.csvGrade, R.id.csvNone})
    public void onCheckedChanged(View view) {
        anyOneSelected = true;
        switch (view.getId()) {
            case R.id.csvViva:
                csvMuro.setChecked(false);
                csvViva.setChecked(true);
                csvGrade.setChecked(false);
                csvNone.setChecked(false);
                break;
            case R.id.csvMuro:
                csvMuro.setChecked(true);
                csvViva.setChecked(false);
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
        return R.layout.fragment_building_which_division;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOneSelected) {
            if (getActivity() != null) {
                ((AboutYouActivity) getActivity()).addFragment(UnityAcquisitionFragment.newInstance());
            }
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(HouseGroupFragment.newInstance());
        }
    }
}
