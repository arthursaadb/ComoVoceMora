package br.com.como_voce_mora.ui.building;

import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.BuildingAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingHadAChoiceFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbFemale)
    CustomRadioButton mRbFemale;
    @BindView(R.id.rbMale)
    CustomRadioButton mRbMale;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private BuildingAnswer buildingAnswer = BuildingAnswer.CHOOSE_HOUSE;
    private boolean anyOneSelected = false;
    private AnswerRequest answerRequests;
    private boolean yesChecked = false;

    public static BuildingHadAChoiceFragment newInstance() {
        return new BuildingHadAChoiceFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_building_had_choice;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOneSelected) {
            ResearchFlow.addAnswer(buildingAnswer.getQuestion(), answerRequests);
            if (yesChecked) {
                ((AboutYouActivity) requireActivity()).addFragment(BuildingContributionFragment.newInstance());
            } else {
                if (ResearchFlow.getHouse()) {
                    ((AboutYouActivity) requireActivity()).addFragment(BuildingHouseNegativePointsFragment.newInstance());
                } else {
                    ((AboutYouActivity) requireActivity()).addFragment(BuildingApartmentNegativePointsFragment.newInstance());
                }
            }
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void init() {
        tvQuestion.setText(buildingAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        mRbFemale.setOnCheckedChangeListener(this);
        mRbMale.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            anyOneSelected = true;
            switch (buttonView.getId()) {
                case R.id.rbFemale:
                    yesChecked = true;
                    mRbFemale.setChecked(true);
                    mRbMale.setChecked(false);
                    answerRequests = new AnswerRequest(buildingAnswer.getQuestion(),
                            buildingAnswer.getQuestionPartId(), "Sim");
                    updateRbs();
                    break;
                case R.id.rbMale:
                    yesChecked = false;
                    mRbFemale.setChecked(false);
                    mRbMale.setChecked(true);
                    answerRequests = new AnswerRequest(buildingAnswer.getQuestion(),
                            buildingAnswer.getQuestionPartId(), "Não");

                    updateRbs();
                    break;
            }
        }
    }

    private void updateRbs() {
        mRbFemale.updateView();
        mRbMale.updateView();
    }

}
