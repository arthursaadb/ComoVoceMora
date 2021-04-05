package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.VolumeHorizontal;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.previoushouse.PreviousHomeSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class WhatsYourSatisfactionFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.volumeSeguranca)
    VolumeHorizontal volumeSegurana;
    @BindView(R.id.volumeAcesso)
    VolumeHorizontal volumeAcesso;
    @BindView(R.id.volumeQualidade)
    VolumeHorizontal volumeQualidade;
    @BindView(R.id.volumeQuantidade)
    VolumeHorizontal volumeQuantidade;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked1 = false;
    private boolean anyOptionChecked2 = false;
    private boolean anyOptionChecked3 = false;
    private boolean anyOptionChecked4 = false;

    private CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.PUBLIC_SPACE_SATISFACTION;
    private CurrentResidenceAnswer segurancaCurrentResidenceAnswer = CurrentResidenceAnswer.SECURITY;
    private CurrentResidenceAnswer qualidadeCurrentResidenceAnswer = CurrentResidenceAnswer.EQUIPMENTS_QUALITY;
    private CurrentResidenceAnswer quantidadeCurrentResidenceAnswer = CurrentResidenceAnswer.EQUIPMENTS_QUANTITY;
    private CurrentResidenceAnswer acessoCurrentResidenceAnswer = CurrentResidenceAnswer.ACCESSIBILITY;
    private List<String> texts = new ArrayList<>();
    private AnswerRequest answerRequests1;
    private AnswerRequest answerRequests2;
    private AnswerRequest answerRequests3;
    private AnswerRequest answerRequests4;

    public static WhatsYourSatisfactionFragment newInstance() {

        Bundle args = new Bundle();

        WhatsYourSatisfactionFragment fragment = new WhatsYourSatisfactionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_whats_your_satisfaction;
    }

    @Override
    public void init() {
        tvQuestion.setText(currentResidenceAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ACTUAL_RESIDENCE);
        texts.add("Muito Ruim");
        texts.add("Ruim");
        texts.add("Regular");
        texts.add("Bom");
        texts.add("Muito Bom");

        volumeAcesso.setMax(texts.size() - 1);
        volumeQuantidade.setMax(texts.size() - 1);
        volumeQualidade.setMax(texts.size() - 1);
        volumeSegurana.setMax(texts.size() - 1);
        initVolumes();
    }

    private void initVolumes() {
        volumeAcesso.setListener(position -> {
            anyOptionChecked1 = true;
            volumeAcesso.setInfo(texts.get(position));
            answerRequests1 = new AnswerRequest(acessoCurrentResidenceAnswer.getQuestion(), acessoCurrentResidenceAnswer.getQuestionPartId(), texts.get(position));
        });
        volumeQuantidade.setListener(position -> {
            anyOptionChecked2 = true;
            volumeQuantidade.setInfo(texts.get(position));
            answerRequests2 = new AnswerRequest(quantidadeCurrentResidenceAnswer.getQuestion(), quantidadeCurrentResidenceAnswer.getQuestionPartId(), texts.get(position));
            ;
        });
        volumeQualidade.setListener(position -> {
            anyOptionChecked3 = true;
            volumeQualidade.setInfo(texts.get(position));
            answerRequests3 = new AnswerRequest(qualidadeCurrentResidenceAnswer.getQuestion(), qualidadeCurrentResidenceAnswer.getQuestionPartId(), texts.get(position));
            ;
        });
        volumeSegurana.setListener(position -> {
            anyOptionChecked4 = true;
            volumeSegurana.setInfo(texts.get(position));
            answerRequests4 = new AnswerRequest(segurancaCurrentResidenceAnswer.getQuestion(), segurancaCurrentResidenceAnswer.getQuestionPartId(), texts.get(position));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked1 && anyOptionChecked2 && anyOptionChecked3 && anyOptionChecked4) {
            setAnswers();
            ((AboutYouActivity) requireActivity()).addFragment(ComercialFragment.newInstance());
        }
    }

    private void setAnswers() {
        ResearchFlow.addAnswer(answerRequests1, this);
        ResearchFlow.addAnswer(answerRequests2, this);
        ResearchFlow.addAnswer(answerRequests3, this);
        ResearchFlow.addAnswer(answerRequests4, this);
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
            ((AboutYouActivity) requireActivity()).addFragment(PreviousHomeSplashFragment.newInstance());
        }
    }
}
