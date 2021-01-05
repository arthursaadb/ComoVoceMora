package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
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

public class UnityReformDificult extends BaseFragment {
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
    private UnityAnswer furnishingsPosition = UnityAnswer.CHANGE_FURNISHINGS_POSITION;
    private UnityAnswer eletronicsPositions = UnityAnswer.CAHNGE_ELETRONICS_POSITIONS;
    private UnityAnswer naturalPlants = UnityAnswer.NATURAL_PLANTS;
    private UnityAnswer personalDecoration = UnityAnswer.PERSONAL_DECORATION;
    private List<String> texts = new ArrayList<>();

    private boolean anyOptionChecked1 = false;
    private boolean anyOptionChecked2 = false;
    private boolean anyOptionChecked3 = false;
    private boolean anyOptionChecked4 = false;

    public static UnityReformDificult newInstance(List<UnityAnswer> room) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
        UnityReformDificult fragment = new UnityReformDificult();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.unity_reform_dificult;
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
            anyOptionChecked1 = true;
            ivPhoto.setImageResource(R.drawable.posmoveis);
            vhFurnishingsPosition.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(furnishingsPosition.getQuestion(), furnishingsPosition.getQuestionPartId(), texts.get(position)));
        });
        vhEletronicsPositions.setListener(position -> {
            anyOptionChecked2 = true;
            vhEletronicsPositions.setInfo(texts.get(position));
            ivPhoto.setImageResource(R.drawable.poseletro);
            answerRequests.add(new AnswerRequest(eletronicsPositions.getQuestion(), eletronicsPositions.getQuestionPartId(), texts.get(position)));
        });
        vhNaturalPlants.setListener(position -> {
            anyOptionChecked3 = true;
            ivPhoto.setImageResource(R.drawable.plantasflores);
            vhNaturalPlants.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(naturalPlants.getQuestion(), naturalPlants.getQuestionPartId(), texts.get(position)));
        });
        vhPersonalDecoration.setListener(position -> {
            anyOptionChecked4 = true;
            ivPhoto.setImageResource(R.drawable.decoracao);
            vhPersonalDecoration.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(personalDecoration.getQuestion(), personalDecoration.getQuestionPartId(), texts.get(position)));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked1 && anyOptionChecked2 && anyOptionChecked3 && anyOptionChecked4) {
            if (getActivity() != null) {
                setAnswers();
                    ((AboutYouActivity) getActivity()).addFragment(UnityReformProblems.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
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
            ResearchFlow.addAnswer(r,this);
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}