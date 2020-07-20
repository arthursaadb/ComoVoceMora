package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.housegroup.HouseGroupFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class CityIntegrationFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.rbNo)
    CustomRadioButton rbNo;
    @BindView(R.id.rbYes)
    CustomRadioButton rbYes;
    @BindView(R.id.rbRegultar)
    CustomRadioButton rbRegular;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.INTEGRATED_IN_CITY;

    public static CityIntegrationFragment newInstance() {

        Bundle args = new Bundle();

        CityIntegrationFragment fragment = new CityIntegrationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_city_integration;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ACTUAL_RESIDENCE);
        tvQuestion.setText(currentResidenceAnswer.getQuestion());
        rbYes.setOnCheckedChangeListener(this);
        rbNo.setOnCheckedChangeListener(this);
        rbRegular.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(currentResidenceAnswer.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(HouseGroupFragment.newInstance());
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
        anyOptionChecked = true;
        setAnswer(buttonView.getText().toString());
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbYes:
                    rbYes.setChecked(true);
                    rbNo.setChecked(false);
                    rbRegular.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbNo:
                    rbYes.setChecked(false);
                    rbNo.setChecked(true);
                    rbRegular.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbRegultar:
                    rbYes.setChecked(false);
                    rbNo.setChecked(false);
                    rbRegular.setChecked(true);
                    updateRbs();
                    break;
            }
        }
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), text);
    }

    private void updateRbs() {
        rbYes.updateView();
        rbNo.updateView();
        rbRegular.updateView();
    }
}
