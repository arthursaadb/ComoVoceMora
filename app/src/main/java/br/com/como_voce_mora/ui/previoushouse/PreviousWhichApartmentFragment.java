package br.com.como_voce_mora.ui.previoushouse;

import android.view.View;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.PreviousHouseAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousWhichApartmentFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvDuplex)
    CustomSelectedView csvDuplex;
    @BindView(R.id.csvTiplex)
    CustomSelectedView csvTiplex;
    @BindView(R.id.csvQuintinete)
    CustomSelectedView csvQuintinete;
    @BindView(R.id.csvLoft)
    CustomSelectedView csvLoft;
    @BindView(R.id.csvConvencional)
    CustomSelectedView csvConvencional;
    @BindView(R.id.csvCobertura)
    CustomSelectedView csvCobertura;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private PreviousHouseAnswer previous = PreviousHouseAnswer.PREVIUS_APARTAMENT_TYPE;

    public static PreviousWhichApartmentFragment newInstance() {
        return new PreviousWhichApartmentFragment();
    }

    @Override
    public void init() {
        tvQuestion.setText(previous.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
    }

    @OnClick({R.id.csvDuplex, R.id.csvTiplex, R.id.csvQuintinete, R.id.csvLoft, R.id.csvConvencional, R.id.csvCobertura})
    public void onCheckedChanged(View view) {
        anyOptionChecked = true;
        switch (view.getId()) {
            case R.id.csvDuplex:
                csvDuplex.setChecked(true);
                csvTiplex.setChecked(false);
                csvQuintinete.setChecked(false);
                csvLoft.setChecked(false);
                csvConvencional.setChecked(false);
                csvCobertura.setChecked(false);
                setAnswer(csvDuplex.getText());
                break;
            case R.id.csvTiplex:
                csvDuplex.setChecked(false);
                csvTiplex.setChecked(true);
                csvQuintinete.setChecked(false);
                csvLoft.setChecked(false);
                csvConvencional.setChecked(false);
                csvCobertura.setChecked(false);
                setAnswer(csvTiplex.getText());
                break;
            case R.id.csvQuintinete:
                csvDuplex.setChecked(false);
                csvTiplex.setChecked(false);
                csvQuintinete.setChecked(true);
                csvLoft.setChecked(false);
                csvConvencional.setChecked(false);
                csvCobertura.setChecked(false);
                setAnswer(csvQuintinete.getText());
                break;
            case R.id.csvLoft:
                csvDuplex.setChecked(false);
                csvTiplex.setChecked(false);
                csvQuintinete.setChecked(false);
                csvLoft.setChecked(true);
                csvConvencional.setChecked(false);
                csvCobertura.setChecked(false);
                setAnswer(csvLoft.getText());
                break;
            case R.id.csvConvencional:
                csvDuplex.setChecked(false);
                csvTiplex.setChecked(false);
                csvQuintinete.setChecked(false);
                csvLoft.setChecked(false);
                csvConvencional.setChecked(true);
                csvCobertura.setChecked(false);
                setAnswer(csvConvencional.getText());
                break;
            case R.id.csvCobertura:
                csvDuplex.setChecked(false);
                csvTiplex.setChecked(false);
                csvQuintinete.setChecked(false);
                csvLoft.setChecked(false);
                csvConvencional.setChecked(false);
                csvCobertura.setChecked(true);
                setAnswer(csvCobertura.getText());
                break;
        }
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(previous.getQuestion(), previous.getQuestionPartId(), text);
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_which_apartament;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(previous.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(PreviousAcquisitionStateFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
