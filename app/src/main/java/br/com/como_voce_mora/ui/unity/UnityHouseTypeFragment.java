package br.com.como_voce_mora.ui.unity;

import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.previoushouse.PreviousAcquisitionStateFragment;
import br.com.como_voce_mora.ui.previoushouse.PreviousWhichHouseFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityHouseTypeFragment extends BaseFragment {
    @BindView(R.id.rootLayout)
    ConstraintLayout mRootLayout;
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
    private UnityAnswer unityAnswer = UnityAnswer.HOUSE_TYPE;

    public static UnityHouseTypeFragment newInstance() {
        return new UnityHouseTypeFragment();
    }

    @Override
    public void init() {
        mRootLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPink));
        tvQuestion.setText(unityAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
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
        answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), text);
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_which_house;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(answerRequest, this);
            ((AboutYouActivity) requireActivity()).addFragment(UnityHouseLivingFragment.newInstance());
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
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}
