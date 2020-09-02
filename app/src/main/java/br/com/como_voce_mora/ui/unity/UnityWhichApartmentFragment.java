package br.com.como_voce_mora.ui.unity;

import android.view.View;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityWhichApartmentFragment extends BaseFragment {
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
    UnityAnswer unityAnswer = UnityAnswer.APARTMENT_TYPE;
    AnswerRequest answerRequest;

    public static UnityWhichApartmentFragment newInstance() {
        return new UnityWhichApartmentFragment();
    }

    @Override
    public void init() {
        tvQuestion.setText(unityAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
    }

    @OnClick({R.id.csvDuplex, R.id.csvTiplex, R.id.csvQuintinete, R.id.csvLoft, R.id.csvConvencional, R.id.csvCobertura})
    public void onCheckedChanged(View view) {
        anyOptionChecked = true;
        CustomSelectedView csv = (CustomSelectedView) view;
        answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), csv.getText());
        switch (view.getId()) {
            case R.id.csvDuplex:
                csvDuplex.setChecked(true);
                csvTiplex.setChecked(false);
                csvQuintinete.setChecked(false);
                csvLoft.setChecked(false);
                csvConvencional.setChecked(false);
                csvCobertura.setChecked(false);
                break;
            case R.id.csvTiplex:
                csvDuplex.setChecked(false);
                csvTiplex.setChecked(true);
                csvQuintinete.setChecked(false);
                csvLoft.setChecked(false);
                csvConvencional.setChecked(false);
                csvCobertura.setChecked(false);
                break;
            case R.id.csvQuintinete:
                csvDuplex.setChecked(false);
                csvTiplex.setChecked(false);
                csvQuintinete.setChecked(true);
                csvLoft.setChecked(false);
                csvConvencional.setChecked(false);
                csvCobertura.setChecked(false);
                break;
            case R.id.csvLoft:
                csvDuplex.setChecked(false);
                csvTiplex.setChecked(false);
                csvQuintinete.setChecked(false);
                csvLoft.setChecked(true);
                csvConvencional.setChecked(false);
                csvCobertura.setChecked(false);
                break;
            case R.id.csvConvencional:
                csvDuplex.setChecked(false);
                csvTiplex.setChecked(false);
                csvQuintinete.setChecked(false);
                csvLoft.setChecked(false);
                csvConvencional.setChecked(true);
                csvCobertura.setChecked(false);
                break;
            case R.id.csvCobertura:
                csvDuplex.setChecked(false);
                csvTiplex.setChecked(false);
                csvQuintinete.setChecked(false);
                csvLoft.setChecked(false);
                csvConvencional.setChecked(false);
                csvCobertura.setChecked(true);
                break;
        }
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_apartament;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            if (getActivity() != null) {
                ResearchFlow.addAnswer(answerRequest, this);
                ((AboutYouActivity) getActivity()).addFragment(UnityHouseLivingFragment.newInstance());
            }
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
