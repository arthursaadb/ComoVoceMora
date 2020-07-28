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

    private CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.PUBLIC_SPACE_SATISFACTION;
    private CurrentResidenceAnswer segurancaCurrentResidenceAnswer = CurrentResidenceAnswer.SECURITY;
    private CurrentResidenceAnswer qualidadeCurrentResidenceAnswer = CurrentResidenceAnswer.EQUIPMENTS_QUALITY;
    private CurrentResidenceAnswer quantidadeCurrentResidenceAnswer = CurrentResidenceAnswer.EQUIPMENTS_QUANTITY;
    private CurrentResidenceAnswer acessoCurrentResidenceAnswer = CurrentResidenceAnswer.ACCESSIBILITY;
    private List<String> texts = new ArrayList<>();
    private List<AnswerRequest> answerRequests = new ArrayList<>();

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
            volumeAcesso.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(acessoCurrentResidenceAnswer.getQuestion(), acessoCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });
        volumeQuantidade.setListener(position -> {
            volumeQuantidade.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(quantidadeCurrentResidenceAnswer.getQuestion(), quantidadeCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });
        volumeQualidade.setListener(position -> {
            volumeQualidade.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(qualidadeCurrentResidenceAnswer.getQuestion(), qualidadeCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });
        volumeSegurana.setListener(position -> {
            volumeSegurana.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(segurancaCurrentResidenceAnswer.getQuestion(), segurancaCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        setAnswers();
        ((AboutYouActivity) requireActivity()).addFragment(ComercialFragment.newInstance());
    }

    private void setAnswers() {
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r, this);
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
