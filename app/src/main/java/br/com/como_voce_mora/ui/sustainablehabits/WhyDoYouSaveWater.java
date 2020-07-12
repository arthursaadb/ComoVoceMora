package br.com.como_voce_mora.ui.sustainablehabits;

import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.SustainableHabitsAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class WhyDoYouSaveWater extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.optionYes)
    CustomRadioButton optionYes;
    @BindView(R.id.optionNo)
    CustomRadioButton optionNo;
    @BindView(R.id.rbBillsPrice)
    CustomRadioButton rbBillsPrice;
    @BindView(R.id.rbLessAmbientalDamage)
    CustomRadioButton rbLessAmbientalDamage;
    @BindView(R.id.rbDry)
    CustomRadioButton rbDry;
    @BindView(R.id.rbOthers)
    CustomRadioButton rbOthers;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.YOU_SAVE_WATER;
    AnswerRequest answerRequest;
    BaseFragment mNextFragment;

    public static WhyDoYouSaveWater newInstance() {
        return new WhyDoYouSaveWater();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_what_you_do_to_save_water;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null && mNextFragment != null) {
            ResearchFlow.addAnswer(sustainableHabitsAnswer.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(mNextFragment);
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
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
        optionYes.setOnCheckedChangeListener(this);
        optionNo.setOnCheckedChangeListener(this);
        rbBillsPrice.setOnCheckedChangeListener(this);
        rbLessAmbientalDamage.setOnCheckedChangeListener(this);
        rbDry.setOnCheckedChangeListener(this);
        rbOthers.setOnCheckedChangeListener(this);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    public void blockItems() {
        rbBillsPrice.setOnCheckedChangeListener(null);
        rbLessAmbientalDamage.setOnCheckedChangeListener(null);
        rbDry.setOnCheckedChangeListener(null);
        rbOthers.setOnCheckedChangeListener(null);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            setAnswer(buttonView.getText().toString());

            switch (buttonView.getId()) {
                case R.id.optionYes:
                    init();
                    mNextFragment = DoYouKnowEquipamentsFragment.newInstance();

                    optionYes.setChecked(true);
                    optionNo.setChecked(false);

                    updateViews();
                    break;
                case R.id.optionNo:
                    mNextFragment = new DoYouSaveElectricityFragment();
                    blockItems();

                    optionYes.setChecked(false);
                    optionNo.setChecked(true);
                    rbBillsPrice.setChecked(false);
                    rbLessAmbientalDamage.setChecked(false);
                    rbDry.setChecked(false);
                    rbOthers.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbBillsPrice:
                    rbBillsPrice.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbLessAmbientalDamage:
                    rbLessAmbientalDamage.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbDry:
                    rbDry.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbOthers:
                    rbOthers.setChecked(true);

                    updateViews();
                    break;
            }
        }
    }

    private void updateViews() {
        optionYes.updateView();
        optionNo.updateView();
        rbBillsPrice.updateView();
        rbLessAmbientalDamage.updateView();
        rbDry.updateView();
        rbOthers.updateView();
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), text);
    }
}
