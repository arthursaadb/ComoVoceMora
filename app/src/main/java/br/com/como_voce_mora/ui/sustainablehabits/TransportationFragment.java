package br.com.como_voce_mora.ui.sustainablehabits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeHorizontal;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.SustainableHabitsAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.currentresidence.ClassifyAspectesFragment;
import br.com.como_voce_mora.ui.currentresidence.WhatsYourSatisfactionFragment;
import br.com.como_voce_mora.ui.unity.UnitySplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransportationFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.volume1)
    VolumeHorizontal volume1;
    @BindView(R.id.volume2)
    VolumeHorizontal volume2;
    @BindView(R.id.volume3)
    VolumeHorizontal volume3;
    @BindView(R.id.volume4)
    VolumeHorizontal volume4;
    @BindView(R.id.water_iv)
    ImageView ivPhoto;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private SustainableHabitsAnswer currentResidenceAnswer = SustainableHabitsAnswer.TRANSPORTATION;
    private SustainableHabitsAnswer segurancaCurrentResidenceAnswer = SustainableHabitsAnswer.  TRANSPORTATION_1;
    private SustainableHabitsAnswer qualidadeCurrentResidenceAnswer = SustainableHabitsAnswer.TRANSPORTATION_2;
    private SustainableHabitsAnswer quantidadeCurrentResidenceAnswer = SustainableHabitsAnswer.TRANSPORTATION_3;
    private SustainableHabitsAnswer acessoCurrentResidenceAnswer = SustainableHabitsAnswer.TRANSPORTATION_4;
    private List<String> texts = new ArrayList<>();
    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private boolean anyOptionChecked1 = false;
    private boolean anyOptionChecked2 = false;
    private boolean anyOptionChecked3 = false;
    private boolean anyOptionChecked4 = false;

    public static TransportationFragment newInstance() {

        return new TransportationFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_transportation;
    }

    @Override
    public void init() {
        tvQuestion.setText(currentResidenceAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
        texts.add("A pé");
        texts.add("Bicicleta");
        texts.add("Transporte coletivo");
        texts.add("Moto");
        texts.add("Automóvel");

        volume1.setMax(texts.size() - 1);
        volume2.setMax(texts.size() - 1);
        volume3.setMax(texts.size() - 1);
        volume4.setMax(texts.size() - 1);
        initVolumes();
    }

    private void initVolumes() {
        volume1.setListener(position -> {
            anyOptionChecked1 = true;
            volume1.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(acessoCurrentResidenceAnswer.getQuestion(), acessoCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });
        volume2.setListener(position -> {
            anyOptionChecked2 = true;
            volume2.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(quantidadeCurrentResidenceAnswer.getQuestion(), quantidadeCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });
        volume3.setListener(position -> {
            anyOptionChecked3 = true;
            volume3.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(qualidadeCurrentResidenceAnswer.getQuestion(), qualidadeCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });
        volume4.setListener(position -> {
            anyOptionChecked4 = true;
            volume4.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(segurancaCurrentResidenceAnswer.getQuestion(), segurancaCurrentResidenceAnswer.getQuestionPartId(), texts.get(position)));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked1 && anyOptionChecked2 && anyOptionChecked3 && anyOptionChecked4) {
            setAnswers();
            ((AboutYouActivity) requireActivity()).addFragment(TransportationReasonFragment.newInstance());
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
            ((AboutYouActivity) requireActivity()).addFragment(UnitySplashFragment.newInstance());
        }
    }
}
