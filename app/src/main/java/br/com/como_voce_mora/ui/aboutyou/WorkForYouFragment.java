package br.com.como_voce_mora.ui.aboutyou;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AboutYouAnswer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class WorkForYouFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.btYes)
    CustomRadioButton cbYes;
    @BindView(R.id.btNo)
    CustomRadioButton cbNo;
    @BindView(R.id.btMens)
    CustomRadioButton cbMens;
    @BindView(R.id.btDia)
    CustomRadioButton cbDia;
    @BindView(R.id.btAmbos)
    CustomRadioButton cbAmbos;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    boolean optionSelected = false;
    private AboutYouAnswer aboutYouAnswer = AboutYouAnswer.WORK_FOR_YOU;
    private AnswerRequest answerRequest;


    public static WorkForYouFragment newInstance() {
        return new WorkForYouFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_work_for_you;
    }

    @Override
    public void init() {
        super.init();
        tvQuestion.setText(aboutYouAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ABOUT_YOU);
        cbYes.setOnCheckedChangeListener(this);
        cbNo.setOnCheckedChangeListener(this);
        cbMens.setOnCheckedChangeListener(this);
        cbDia.setOnCheckedChangeListener(this);
        cbAmbos.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (optionSelected) {
            ResearchFlow.addAnswer(aboutYouAnswer.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(FamilyIncomeFragment.newInstance());
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
                case R.id.btYes:
                    cbYes.setChecked(true);
                    cbNo.setChecked(false);
                    updateRbs();
                    showSecondary();
                    break;
                case R.id.btNo:
                    cbYes.setChecked(false);
                    cbNo.setChecked(true);
                    hideSecondary();
                    updateRbs();
                    optionSelected = true;
                    break;
                case R.id.btMens:
                    cbMens.setChecked(true);
                    cbDia.setChecked(false);
                    cbAmbos.setChecked(false);
                    updateSecondaryRbs();
                    optionSelected = true;
                    break;

                case R.id.btDia:
                    cbMens.setChecked(false);
                    cbDia.setChecked(true);
                    cbAmbos.setChecked(false);
                    updateSecondaryRbs();
                    optionSelected = true;
                    break;
                case R.id.btAmbos:
                    cbMens.setChecked(false);
                    cbDia.setChecked(false);
                    cbAmbos.setChecked(true);
                    updateSecondaryRbs();
                    optionSelected = true;
                    break;
            }
        }
    }

    private void setAnswer(String question) {
        answerRequest = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), question);
    }

    private void hideSecondary() {
        cbMens.setVisibility(View.INVISIBLE);
        cbDia.setVisibility(View.INVISIBLE);
        cbAmbos.setVisibility(View.INVISIBLE);
    }

    private void showSecondary() {
        cbMens.setVisibility(View.VISIBLE);
        cbDia.setVisibility(View.VISIBLE);
        cbAmbos.setVisibility(View.VISIBLE);
    }

    private void updateRbs() {
        cbYes.updateView();
        cbNo.updateView();
    }

    private void updateSecondaryRbs() {
        cbMens.updateView();
        cbDia.updateView();
        cbAmbos.updateView();
    }

}
