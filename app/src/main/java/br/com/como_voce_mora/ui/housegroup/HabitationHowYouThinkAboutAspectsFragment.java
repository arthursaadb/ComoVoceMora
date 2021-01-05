package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeHorizontal;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.HouseGroupAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationHowYouThinkAboutAspectsFragment extends BaseFragment {

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
    @BindView(R.id.volume4)
    VolumeHorizontal vhLimpeza;
    @BindView(R.id.ivImage)
    ImageView ivPhoto;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    HouseGroupAnswer aspects = HouseGroupAnswer.ASPECTS;
    HouseGroupAnswer aspectSecurity = HouseGroupAnswer.ASPECTS_SECURITY;
    HouseGroupAnswer aspectStreet = HouseGroupAnswer.ASPECTS_STREET_SECURITY;
    HouseGroupAnswer aspectConvivence = HouseGroupAnswer.ASPECTS_CONVIVENCE;
    HouseGroupAnswer aspectPrivece = HouseGroupAnswer.ASPECTS_PRIVACY;
    private List<String> texts = new ArrayList<>();

    private boolean anyOptionChecked1 = false;
    private boolean anyOptionChecked2 = false;
    private boolean anyOptionChecked3 = false;
    private boolean anyOptionChecked4 = false;

    public static HabitationHowYouThinkAboutAspectsFragment newInstance() {

        Bundle args = new Bundle();

        HabitationHowYouThinkAboutAspectsFragment fragment = new HabitationHowYouThinkAboutAspectsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_how_you_think_aspects;
    }

    @Override
    public void init() {
        tvQuestion.setText(aspects.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
        texts.add("Muito Ruim");
        texts.add("Ruim");
        texts.add("Regular");
        texts.add("Bom");
        texts.add("Muito Bom");

        vhAcessibilidade.setMax(texts.size() - 1);
        vhAparencia.setMax(texts.size() - 1);
        vhConstrucao.setMax(texts.size() - 1);
        vhLimpeza.setMax(texts.size() - 1);
        initVolumes();
    }

    private void initVolumes() {
        vhAcessibilidade.setListener(position -> {
            anyOptionChecked1 = true;
            vhAcessibilidade.setInfo(texts.get(position));
            ivPhoto.setImageResource(R.drawable.cost_benefit);
            answerRequests.add(new AnswerRequest(aspectSecurity.getQuestion(), aspectSecurity.getQuestionPartId(), texts.get(position)));
        });
        vhAparencia.setListener(position -> {
            anyOptionChecked2 = true;
            vhAparencia.setInfo(texts.get(position));
            ivPhoto.setImageResource(R.drawable.street_privacy);
            answerRequests.add(new AnswerRequest(aspectStreet.getQuestion(), aspectStreet.getQuestionPartId(), texts.get(position)));
        });
        vhConstrucao.setListener(position -> {
            anyOptionChecked3 = true;
            vhConstrucao.setInfo(texts.get(position));
            ivPhoto.setImageResource(R.drawable.security);
            answerRequests.add(new AnswerRequest(aspectConvivence.getQuestion(), aspectConvivence.getQuestionPartId(), texts.get(position)));
        });
        vhLimpeza.setListener(position -> {
            anyOptionChecked4 = true;
            vhLimpeza.setInfo(texts.get(position));
            ivPhoto.setImageResource(R.drawable.coexistence);
            answerRequests.add(new AnswerRequest(aspectPrivece.getQuestion(), aspectPrivece.getQuestionPartId(), texts.get(position)));
        });

    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked1 && anyOptionChecked2 && anyOptionChecked3 && anyOptionChecked4) {
            if (getActivity() != null) {
                setAnswers();
                ((AboutYouActivity) getActivity()).addFragment(HabitationSatisfactionFragment.newInstance());
            }
        }
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

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }
}
