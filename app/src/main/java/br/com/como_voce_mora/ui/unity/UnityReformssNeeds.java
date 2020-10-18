package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.BuildingAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingApartmentNegativePointsFragment;
import br.com.como_voce_mora.ui.building.BuildingContributionFragment;
import br.com.como_voce_mora.ui.building.BuildingHadAChoiceFragment;
import br.com.como_voce_mora.ui.building.BuildingHouseNegativePointsFragment;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.housegroup.HouseGroupFragment;
import butterknife.BindView;
import butterknife.OnClick;

    public class UnityReformssNeeds extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbYes)
    CustomRadioButton rbYes;
    @BindView(R.id.rbNo)
    CustomRadioButton rbNo;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private UnityAnswer unityAnswer = UnityAnswer.CHANGE_TO_BETTER_ATEMPTEMENT;
    private boolean anyOneSelected = false;
    private AnswerRequest answerRequests;
    private boolean yesChecked = false;

    public static UnityReformssNeeds newInstance(List<UnityAnswer> room) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
        UnityReformssNeeds fragment = new UnityReformssNeeds();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.unity_reform_needss;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOneSelected) {
            ResearchFlow.addAnswer(answerRequests, this);
            if (yesChecked) {
                ((AboutYouActivity) requireActivity()).addFragment(UnityReformDificult.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
            } else {
                ((AboutYouActivity) requireActivity()).addFragment(UnitySunLightFragment.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
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
        tvQuestion.setText(unityAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        rbYes.setOnCheckedChangeListener(this);
        rbNo.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            anyOneSelected = true;
            switch (buttonView.getId()) {
                case R.id.rbYes:
                    yesChecked = true;
                    rbYes.setChecked(true);
                    rbNo.setChecked(false);
                    answerRequests = new AnswerRequest(unityAnswer.getQuestion(),
                            unityAnswer.getQuestionPartId(), "Sim");
                    updateRbs();
                    break;
                case R.id.rbNo:
                    yesChecked = false;
                    rbYes.setChecked(false);
                    rbNo.setChecked(true);
                    answerRequests = new AnswerRequest(unityAnswer.getQuestion(),
                            unityAnswer.getQuestionPartId(), "Não");

                    updateRbs();
                    break;
            }
        }
    }

    private void updateRbs() {
        rbYes.updateView();
        rbNo.updateView();
    }

        @OnClick(R.id.btPreviousSession)
        public void onBtPreviouSessionClicked() {
            if (getActivity() != null) {
                ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
            }
        }
}
