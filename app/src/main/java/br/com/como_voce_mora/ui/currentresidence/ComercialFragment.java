package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.widget.EditText;
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

public class ComercialFragment extends BaseFragment implements VolumeHorizontal.OnListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.tv_question2)
    TextView tvQuestion2;
    @BindView(R.id.volume)
    VolumeHorizontal mVolume;
    @BindView(R.id.etCity)
    EditText etCity;

    List<String> texts;
    AnswerRequest answerRequest;
    AnswerRequest answerRequest2;
    CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.COMMERCE;
    CurrentResidenceAnswer currentResidenceAnswer2 = CurrentResidenceAnswer.COMMERCE_TYPE_MISSING;


    public static ComercialFragment newInstance() {
        Bundle args = new Bundle();

        ComercialFragment fragment = new ComercialFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_comercial;
    }

    @Override
    public void init() {
        super.init();
        tvQuestion.setText(currentResidenceAnswer.getQuestion());
        tvQuestion2.setText(currentResidenceAnswer2.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ACTUAL_RESIDENCE);

        texts = new ArrayList<>();
        texts.add("Muito mal servido");
        texts.add("Mal servido");
        texts.add("Regultar");
        texts.add("Bem servido");
        texts.add("Muito bem servido");

        mVolume.setListener(this);
        mVolume.setMax(texts.size() - 1);
        answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), texts.get(2));
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (!etCity.getText().toString().isEmpty()) {
            answerRequest2 = new AnswerRequest(currentResidenceAnswer2.getQuestion(), currentResidenceAnswer2.getQuestionPartId(), etCity.getText().toString());
            ResearchFlow.addAnswer(currentResidenceAnswer.getQuestion(), answerRequest);
            ResearchFlow.addAnswer(currentResidenceAnswer2.getQuestion(), answerRequest2);
            ((AboutYouActivity) requireActivity()).addFragment(PublicAreaFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void positionVolume(int position) {
        mVolume.setInfo(texts.get(position));
        answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), texts.get(position));
    }
}
