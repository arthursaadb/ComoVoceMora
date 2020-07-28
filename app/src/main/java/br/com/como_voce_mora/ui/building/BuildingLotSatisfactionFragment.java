package br.com.como_voce_mora.ui.building;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeHorizontal;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.BuildingAnswer;
import br.com.como_voce_mora.model.HouseGroupAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.housegroup.HabitationHowYouThinkAboutAspectsFragment;
import br.com.como_voce_mora.ui.unity.UnitySplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingLotSatisfactionFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.volume1)
    VolumeHorizontal vhAcessibilidade;
    @BindView(R.id.volume2)
    VolumeHorizontal vhConstrucao;
    @BindView(R.id.volume3)
    VolumeHorizontal vhAparencia;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    BuildingAnswer satisfaction = BuildingAnswer.LOT_REVIEW;
    BuildingAnswer tamanho = BuildingAnswer.LOT_SIZE;
    BuildingAnswer evolucao = BuildingAnswer.LOT_EVOLUTION;
    BuildingAnswer construcao = BuildingAnswer.LOT_CONSTROCTION;
    private List<String> texts = new ArrayList<>();

    public static BuildingLotSatisfactionFragment newInstance() {

        Bundle args = new Bundle();

        BuildingLotSatisfactionFragment fragment = new BuildingLotSatisfactionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_building_lote_satisfaction;
    }

    @Override
    public void init() {
        tvQuestion.setText(satisfaction.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
        texts.add("Muito Ruim");
        texts.add("Ruim");
        texts.add("Regular");
        texts.add("Bom");
        texts.add("Muito Bom");

        vhAcessibilidade.setMax(texts.size() - 1);
        vhAparencia.setMax(texts.size() - 1);
        vhConstrucao.setMax(texts.size() - 1);
        initVolumes();
    }

    private void initVolumes() {
        vhAcessibilidade.setListener(position -> {
            vhAcessibilidade.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(tamanho.getQuestion(), tamanho.getQuestionPartId(), texts.get(position)));
        });
        vhAparencia.setListener(position -> {
            vhAparencia.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(evolucao.getQuestion(), evolucao.getQuestionPartId(), texts.get(position)));
        });
        vhConstrucao.setListener(position -> {
            vhConstrucao.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(construcao.getQuestion(), construcao.getQuestionPartId(), texts.get(position)));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            setAnswers();
            ((AboutYouActivity) getActivity()).addFragment(UnitySplashFragment.newInstance());
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
}
