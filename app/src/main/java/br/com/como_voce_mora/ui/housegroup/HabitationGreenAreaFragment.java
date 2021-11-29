package br.com.como_voce_mora.ui.housegroup;

import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.HouseGroupAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationGreenAreaFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.rbYes)
    CustomRadioButton rbYes;
    @BindView(R.id.rbNo)
    CustomRadioButton rbNo;

    private AnswerRequest answerRequests;
    private HouseGroupAnswer houseGroupAnser = HouseGroupAnswer.GREEN_AREA;
    private boolean yesChecked = false;
    private boolean anyOptionChecked = false;

    public static HabitationGreenAreaFragment newInstance() {
        return new HabitationGreenAreaFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_green_area;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
        tvQuestion.setText(houseGroupAnser.getQuestion());
        rbYes.setOnCheckedChangeListener(this);
        rbNo.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(answerRequests, this);
            if (yesChecked) {
                ((AboutYouActivity) requireActivity()).addFragment(HabitationGreenAreaSatisfactionFragment.newInstance());
            } else {
                ((AboutYouActivity) requireActivity()).addFragment(HabitationMissGreenAreaFragment.newInstance());
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
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            anyOptionChecked = true;
            setAnswer(buttonView.getText().toString());

            switch (buttonView.getId()) {
                case R.id.rbYes:
                    yesChecked = true;
                    rbYes.setChecked(true);
                    rbNo.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbNo:
                    yesChecked = false;
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
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }

}
