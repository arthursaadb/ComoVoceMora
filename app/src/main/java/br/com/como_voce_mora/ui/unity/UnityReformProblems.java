package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeHorizontal;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;


public class UnityReformProblems extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.volume1)
    VolumeHorizontal vhFurnishingsPosition;
    @BindView(R.id.volume2)
    VolumeHorizontal vhEletronicsPositions;
    @BindView(R.id.volume3)
    VolumeHorizontal vhNaturalPlants;
    @BindView(R.id.volume4)
    VolumeHorizontal vhPersonalDecoration;
    @BindView(R.id.ivImage)
    ImageView ivPhoto;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private UnityAnswer unityAnswer = UnityAnswer.REFORM_DIFICULTY;
    private UnityAnswer furnishingsPosition = UnityAnswer.PAINT;
    private UnityAnswer eletronicsPositions = UnityAnswer.DROP_WALL;
    private UnityAnswer naturalPlants = UnityAnswer.PLASTER;
    private UnityAnswer personalDecoration = UnityAnswer.INNCREASE_POWER_PLUG;
    private List<String> texts = new ArrayList<>();
    private boolean anyOptionChecked = false;

    public static UnityReformProblems newInstance() {

        Bundle args = new Bundle();

        UnityReformProblems fragment = new UnityReformProblems();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.unity_reform_problems;
    }

    @Override
    public void init() {
        tvQuestion.setText(unityAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        texts.add("Muito Difícil");
        texts.add("Difícil");
        texts.add("Regular");
        texts.add("Fácil");
        texts.add("Muito Fácil");

        vhFurnishingsPosition.setMax(texts.size() - 1);
        vhEletronicsPositions.setMax(texts.size() - 1);
        vhNaturalPlants.setMax(texts.size() - 1);
        vhPersonalDecoration.setMax(texts.size() - 1);
        initVolumes();
    }

    private void initVolumes() {
        vhFurnishingsPosition.setListener(position -> {
            anyOptionChecked = true;
            ivPhoto.setImageResource(R.drawable.pintar);
            vhFurnishingsPosition.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(furnishingsPosition.getQuestion(), furnishingsPosition.getQuestionPartId(), texts.get(position)));
        });
        vhEletronicsPositions.setListener(position -> {
            vhEletronicsPositions.setInfo(texts.get(position));
            ivPhoto.setImageResource(R.drawable.vao);
            answerRequests.add(new AnswerRequest(eletronicsPositions.getQuestion(), eletronicsPositions.getQuestionPartId(), texts.get(position)));
        });
        vhNaturalPlants.setListener(position -> {
            ivPhoto.setImageResource(R.drawable.forro);
            vhNaturalPlants.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(naturalPlants.getQuestion(), naturalPlants.getQuestionPartId(), texts.get(position)));
        });
        vhPersonalDecoration.setListener(position -> {
            ivPhoto.setImageResource(R.drawable.tomadailuminacao);
            vhPersonalDecoration.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(personalDecoration.getQuestion(), personalDecoration.getQuestionPartId(), texts.get(position)));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            if (getActivity() != null) {
                setAnswers();
                ((AboutYouActivity) getActivity()).addFragment(UnityMadeChanges.newInstance());
            }
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
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}