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
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationCondominiumFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.rbYes)
    CustomRadioButton rbYes;
    @BindView(R.id.rbNo)
    CustomRadioButton rbNo;

    private AnswerRequest answerRequests;
    private HouseGroupAnswer houseGroupAnser = HouseGroupAnswer.LIVE_IN_CONDOMINIUM;
    private boolean yesChecked = false;
    private boolean houseType = true;

    public static HabitationCondominiumFragment newInstance(boolean houseType) {
        HabitationCondominiumFragment habitationCondominiumFragment = new HabitationCondominiumFragment();
        habitationCondominiumFragment.houseType = houseType;

        return new HabitationCondominiumFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_condominium;
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
        ResearchFlow.addAnswer(houseGroupAnser.getQuestion(), answerRequests);
        if (yesChecked) {
            if (houseType) {
                ((AboutYouActivity) requireActivity()).addFragment(HabitationEquipmentsFragment.newInstance());
            } else {
                ((AboutYouActivity) requireActivity()).addFragment(HabitationBlocksFragment.newInstance());
            }
        } else {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
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
        if (isChecked) {
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
}
