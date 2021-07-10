package br.com.como_voce_mora.ui.sustainablehabits;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.SustainableHabitsAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.unity.UnitySplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class WhyYouSaveWaterFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
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
    @BindView(R.id.rbAbundantResource)
    CustomRadioButton rbAbundantResource;
    @BindView(R.id.rbOthersNo)
    CustomRadioButton rbOthersNo;
    @BindView(R.id.rbNoNeed)
    CustomRadioButton rbNoNeed;
    @BindView(R.id.rbLowCost)
    CustomRadioButton rbLowCost;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.WHY_YOU_SAVE_WATER;
    AnswerRequest answerRequest;

    StringBuilder answerRequestYes = new StringBuilder();
    StringBuilder answerRequestNo = new StringBuilder();

    List<String> answerListYes = new ArrayList<>();
    List<String> answerListNo = new ArrayList<>();

    BaseFragment mNextFragment;
    private boolean anyOptionChecked = false;
    private boolean optionYesChecked = false;
    private boolean optionNoChecked = false;


    public static WhyYouSaveWaterFragment newInstance() {
        return new WhyYouSaveWaterFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_why_you_save_water;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null && mNextFragment != null && anyOptionChecked && (answerListYes.size() > 0 || answerListNo.size() > 0)) {
            setAnswers();
            ((AboutYouActivity) requireActivity()).addFragment(mNextFragment);
        }
    }

    private void setAnswers() {
        ResearchFlow.addAnswer(answerRequest, this);

        if (answerListYes.size() != 0) {
            for (String text : answerListYes) {
                answerRequestYes.append(text);
                answerRequestYes.append(";");
            }

            ResearchFlow.addAnswer(new AnswerRequest(SustainableHabitsAnswer.WHY_WATER.getQuestion(),
                    SustainableHabitsAnswer.WHY_WATER.getQuestionPartId(),
                    answerRequestYes.toString()), this);
        }


        if (answerListNo.size() != 0) {
            for (String text : answerListNo) {
                answerRequestNo.append(text);
                answerRequestNo.append(";");
            }

            ResearchFlow.addAnswer(new AnswerRequest(SustainableHabitsAnswer.WHY_NOT_WATER.getQuestion(),
                            SustainableHabitsAnswer.WHY_NOT_WATER.getQuestionPartId(),
                            answerRequestNo.toString()),
                    this);
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
        rbAbundantResource.setOnCheckedChangeListener(this);
        rbOthersNo.setOnCheckedChangeListener(this);
        rbNoNeed.setOnCheckedChangeListener(this);
        rbLowCost.setOnCheckedChangeListener(this);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    private void hideYesItems() {
        rbBillsPrice.setVisibility(View.INVISIBLE);
        rbLessAmbientalDamage.setVisibility(View.INVISIBLE);
        rbDry.setVisibility(View.INVISIBLE);
        rbOthers.setVisibility(View.INVISIBLE);
    }

    private void showYesItems() {
        rbBillsPrice.setVisibility(View.VISIBLE);
        rbLessAmbientalDamage.setVisibility(View.VISIBLE);
        rbDry.setVisibility(View.VISIBLE);
        rbOthers.setVisibility(View.VISIBLE);
    }

    private void hideNoItems() {
        rbAbundantResource.setVisibility(View.INVISIBLE);
        rbOthersNo.setVisibility(View.INVISIBLE);
        rbNoNeed.setVisibility(View.INVISIBLE);
        rbLowCost.setVisibility(View.INVISIBLE);
    }

    private void showNoItems() {
        rbAbundantResource.setVisibility(View.VISIBLE);
        rbOthersNo.setVisibility(View.VISIBLE);
        rbNoNeed.setVisibility(View.VISIBLE);
        rbLowCost.setVisibility(View.VISIBLE);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.optionYes:
                if (isChecked) {
                    anyOptionChecked = true;
                    optionNoChecked = false;
                    answerListNo.clear();
                    mNextFragment = DoYouKnowEquipamentsFragment.newInstance();
                    showYesItems();
                    hideNoItems();
                    optionYes.setChecked(true);
                    optionNo.setChecked(false);
                    rbBillsPrice.setChecked(false);
                    rbLessAmbientalDamage.setChecked(false);
                    rbDry.setChecked(false);
                    rbOthers.setChecked(false);
                    setAnswer(buttonView.getText().toString());
                }
                updateViews();
                break;
            case R.id.optionNo:
                if (isChecked) {
                    anyOptionChecked = true;
                    optionYesChecked = false;
                    answerListYes.clear();
                    mNextFragment = WhyYouSaveElectricityFragment.newInstance();
                    hideYesItems();
                    showNoItems();
                    optionYes.setChecked(false);
                    optionNo.setChecked(true);
                    rbBillsPrice.setChecked(false);
                    rbLessAmbientalDamage.setChecked(false);
                    rbDry.setChecked(false);
                    rbOthers.setChecked(false);
                    setAnswer(buttonView.getText().toString());
                }
                updateViews();
                break;
            case R.id.rbBillsPrice:
                optionYesChecked = true;
                rbBillsPrice.setChecked(isChecked);
                setAnswerYes(buttonView.getText().toString(), isChecked);
                updateViews();
                break;
            case R.id.rbLessAmbientalDamage:
                optionYesChecked = true;
                rbLessAmbientalDamage.setChecked(isChecked);
                setAnswerYes(buttonView.getText().toString(), isChecked);
                updateViews();
                break;
            case R.id.rbDry:
                optionYesChecked = true;
                rbDry.setChecked(isChecked);
                setAnswerYes(buttonView.getText().toString(), isChecked);
                updateViews();
                break;
            case R.id.rbOthers:
                optionYesChecked = true;
                rbOthers.setChecked(isChecked);
                setAnswerYes(buttonView.getText().toString(), isChecked);
                updateViews();
                break;

            case R.id.rbAbundantResource:
                optionNoChecked = true;
                rbAbundantResource.setChecked(isChecked);
                setAnswerNo(buttonView.getText().toString(), isChecked);
                updateViews();
                break;

            case R.id.rbOthersNo:
                optionNoChecked = true;
                rbOthersNo.setChecked(isChecked);
                setAnswerNo(buttonView.getText().toString(), isChecked);
                updateViews();
                break;

            case R.id.rbNoNeed:
                optionNoChecked = true;
                rbNoNeed.setChecked(isChecked);
                setAnswerNo(buttonView.getText().toString(), isChecked);
                updateViews();
                break;

            case R.id.rbLowCost:
                optionNoChecked = true;
                rbLowCost.setChecked(isChecked);
                setAnswerNo(buttonView.getText().toString(), isChecked);
                updateViews();
                break;
        }
    }

    private void updateViews() {
        optionYes.updateView();
        optionNo.updateView();
        rbBillsPrice.updateView();
        rbLessAmbientalDamage.updateView();
        rbDry.updateView();
        rbOthers.updateView();
        rbAbundantResource.updateView();
        rbOthersNo.updateView();
        rbNoNeed.updateView();
        rbLowCost.updateView();
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), text);
    }

    private void setAnswerYes(String text, boolean isChecked) {
        if (isChecked) {
            answerListYes.add(text);
        } else {
            answerListYes.remove(text);
        }
    }

    private void setAnswerNo(String text, boolean isChecked) {
        if (isChecked) {
            answerListNo.add(text);
        } else {
            answerListNo.remove(text);
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(UnitySplashFragment.newInstance());
        }
    }
}