package br.com.como_voce_mora.ui.previoushouse;

import android.content.Intent;
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
import br.com.como_voce_mora.ui.aboutyou.SplashAboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousWhichHouseFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvCasaGerminada)
    CustomSelectedView csvCasaGerminada;
    @BindView(R.id.csvSobrado)
    CustomSelectedView csvSobrado;
    @BindView(R.id.csvVila)
    CustomSelectedView csvVila;
    @BindView(R.id.csvTerreo)
    CustomSelectedView csvTerreo;
    @BindView(R.id.csvFundo)
    CustomSelectedView csvFundo;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private PreviousHouseAnswer previous = PreviousHouseAnswer.PREVIUS_HOUSE_TYPE;

    public static PreviousWhichHouseFragment newInstance() {
        return new PreviousWhichHouseFragment();
    }

    @Override
    public void init() {
        tvQuestion.setText(previous.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
    }

    @OnClick({R.id.csvCasaGerminada, R.id.csvSobrado, R.id.csvVila, R.id.csvTerreo, R.id.csvFundo})
    public void onCheckedChanged(View view) {
        anyOptionChecked = true;
        switch (view.getId()) {
            case R.id.csvCasaGerminada:
                csvCasaGerminada.setChecked(true);
                csvSobrado.setChecked(false);
                csvVila.setChecked(false);
                csvTerreo.setChecked(false);
                csvFundo.setChecked(false);
                setAnswer(csvCasaGerminada.getText());
                break;
            case R.id.csvSobrado:
                csvCasaGerminada.setChecked(false);
                csvSobrado.setChecked(true);
                csvVila.setChecked(false);
                csvTerreo.setChecked(false);
                csvFundo.setChecked(false);
                setAnswer(csvSobrado.getText());
                break;
            case R.id.csvVila:
                csvCasaGerminada.setChecked(false);
                csvSobrado.setChecked(false);
                csvVila.setChecked(true);
                csvTerreo.setChecked(false);
                csvFundo.setChecked(false);
                setAnswer(csvVila.getText());
                break;
            case R.id.csvTerreo:
                csvCasaGerminada.setChecked(false);
                csvSobrado.setChecked(false);
                csvVila.setChecked(false);
                csvTerreo.setChecked(true);
                csvFundo.setChecked(false);
                setAnswer(csvTerreo.getText());
                break;
            case R.id.csvFundo:
                csvCasaGerminada.setChecked(false);
                csvSobrado.setChecked(false);
                csvVila.setChecked(false);
                csvTerreo.setChecked(false);
                csvFundo.setChecked(true);
                setAnswer(csvFundo.getText());
                break;
        }

    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(previous.getQuestion(), previous.getQuestionPartId(), text);
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_which_house;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(answerRequest, this);
            ((AboutYouActivity) requireActivity()).addFragment(PreviousAcquisitionStateFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        Intent intent = new Intent(getActivity(), SplashAboutYouActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

}
