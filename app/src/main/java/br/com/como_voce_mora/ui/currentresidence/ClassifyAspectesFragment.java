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

public class ClassifyAspectesFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.volumeAgradabilidade)
    VolumeHorizontal volumeAgradabilidade;
    @BindView(R.id.volumeConvivio)
    VolumeHorizontal volumeConvivio;
    @BindView(R.id.volumeAcessibilidade)
    VolumeHorizontal volumeAcessibilidade;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked = false;
    private List<String> texts = new ArrayList<>();
    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.NEIGHBORHOOD_ASPECTS;
    private CurrentResidenceAnswer convivioCurrentResidenceAnswer = CurrentResidenceAnswer.COLLECTIVE_INTERACTION;
    private CurrentResidenceAnswer acessibildadeCurrentResidenceAnswer = CurrentResidenceAnswer.ACCESSIBILITY_SIDEWALKS;
    private CurrentResidenceAnswer agradabilidadeCurrentResidenceAnswer = CurrentResidenceAnswer.PLEASANTNESS;


    public static ClassifyAspectesFragment newInstance() {

        Bundle args = new Bundle();

        ClassifyAspectesFragment fragment = new ClassifyAspectesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_classify_aspects;
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

        volumeAgradabilidade.setMax(texts.size() - 1);
        volumeConvivio.setMax(texts.size() - 1);
        volumeAcessibilidade.setMax(texts.size() - 1);
        initVolumes();
    }

    private void initVolumes() {
        volumeAgradabilidade.setListener(position -> {
            anyOptionChecked = true;
            volumeAgradabilidade.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(agradabilidadeCurrentResidenceAnswer.getQuestion(), agradabilidadeCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });
        volumeConvivio.setListener(position -> {
            anyOptionChecked = true;
            volumeConvivio.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(convivioCurrentResidenceAnswer.getQuestion(), convivioCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });
        volumeAcessibilidade.setListener(position -> {
            anyOptionChecked = true;
            volumeAcessibilidade.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(acessibildadeCurrentResidenceAnswer.getQuestion(), acessibildadeCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });

    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            setAnswers();
            ((AboutYouActivity) requireActivity()).addFragment(OrganizationFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void setAnswers() {
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r, this);
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(PreviousHomeSplashFragment.newInstance());
        }
    }
}
