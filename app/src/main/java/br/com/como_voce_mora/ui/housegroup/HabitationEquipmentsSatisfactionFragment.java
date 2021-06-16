package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class HabitationEquipmentsSatisfactionFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.llVolume1)
    VolumeHorizontal vhAcessibilidade;
    @BindView(R.id.llVolume2)
    VolumeHorizontal vhConstrucao;
    @BindView(R.id.llVolume3)
    VolumeHorizontal vhAparencia;
    @BindView(R.id.llVolume4)
    VolumeHorizontal vhLimpeza;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private ArrayList<AnswerRequest> equipaments = new ArrayList<>();
    HouseGroupAnswer satisfaction = HouseGroupAnswer.SATISFACTION_OF_HOME_ASPECTS;
    HouseGroupAnswer acessibilidade = HouseGroupAnswer.ACCESSIBILITY;
    HouseGroupAnswer construction = HouseGroupAnswer.CONSTRUCTION_QUALITY_OF_HOME;
    HouseGroupAnswer general = HouseGroupAnswer.GENERAL_APARENCE;
    HouseGroupAnswer clean = HouseGroupAnswer.CLEANS_AND_PRESERVATION;
    private List<String> texts = new ArrayList<>();
    private boolean anyOptionChecked1 = false;
    private boolean anyOptionChecked2 = false;
    private boolean anyOptionChecked3 = false;
    private boolean anyOptionChecked4 = false;

    public static HabitationEquipmentsSatisfactionFragment newInstance(ArrayList<AnswerRequest> answerRequests) {

        Bundle args = new Bundle();
        args.putParcelableArrayList("key", answerRequests);
        HabitationEquipmentsSatisfactionFragment fragment = new HabitationEquipmentsSatisfactionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_equipments_satisfaction;
    }

    @Override
    public void init() {
        equipaments = getArguments().getParcelableArrayList("key");
        AnswerRequest answerRequest = equipaments.get(0);
        equipaments.remove(0);
        String question = String.format("Sobre %s, diga-me qual é a sua:", answerRequest.getDwellerId());
        tvQuestion.setText(question);
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
            answerRequests.add(new AnswerRequest(acessibilidade.getQuestion(), acessibilidade.getQuestionPartId(), texts.get(position)));
        });
        vhAparencia.setListener(position -> {
            anyOptionChecked2 = true;
            vhAparencia.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(general.getQuestion(), general.getQuestionPartId(), texts.get(position)));
        });
        vhConstrucao.setListener(position -> {
            anyOptionChecked3 = true;
            vhConstrucao.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(construction.getQuestion(), construction.getQuestionPartId(), texts.get(position)));
        });
        vhLimpeza.setListener(position -> {
            anyOptionChecked4 = true;
            vhLimpeza.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(clean.getQuestion(), clean.getQuestionPartId(), texts.get(position)));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked1 && anyOptionChecked2 && anyOptionChecked3 && anyOptionChecked4) {
            if (getActivity() != null) {
                setAnswers();
                if(equipaments.size() > 0){
                    ((AboutYouActivity) getActivity()).addFragment(HabitationEquipmentsSatisfactionFragment.newInstance(equipaments));
                } else {
                    ((AboutYouActivity) getActivity()).addFragment(HabitationAspectsFragment.newInstance());
                }
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
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }
}