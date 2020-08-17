package br.com.como_voce_mora.ui.building;

import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.BuildingAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.housegroup.HabitationGreenAreaSatisfactionFragment;
import br.com.como_voce_mora.ui.housegroup.HouseGroupFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingContributionFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.rbYes)
    CustomRadioButton rbYes;
    @BindView(R.id.rbNo)
    CustomRadioButton rbNo;

    private AnswerRequest answerRequests;
    private BuildingAnswer houseGroupAnser = BuildingAnswer.HELPED_IN_PROJECT;
    private boolean anyOneSelected = false;

    public static BuildingContributionFragment newInstance() {
        return new BuildingContributionFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_building_contribuition_project;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        tvQuestion.setText(houseGroupAnser.getQuestion());
        rbYes.setOnCheckedChangeListener(this);
        rbNo.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOneSelected) {
            ResearchFlow.addAnswer(answerRequests, this);
            ((AboutYouActivity) requireActivity()).addFragment(BuildingReasonChoiceFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        setAnswer(buttonView.getText().toString());
        anyOneSelected = true;
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbYes:
                    rbYes.setChecked(true);
                    rbNo.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbNo:
                    rbYes.setChecked(false);
                    rbNo.setChecked(true);

                    updateRbs();
                    break;
            }
        }
    }

    private void setAnswer(String text) {
        answerRequests = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
    }

    private void updateRbs() {
        rbNo.updateView();
        rbYes.updateView();
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(HouseGroupFragment.newInstance());
        }
    }


}
