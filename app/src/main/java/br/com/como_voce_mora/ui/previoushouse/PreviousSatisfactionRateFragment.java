package br.com.como_voce_mora.ui.previoushouse;

import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.VolumeHorizontal;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.PreviousHouseAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.aboutyou.SplashAboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousSatisfactionRateFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
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
    @BindView(R.id.volume5)
    VolumeHorizontal vhTamanho;
    @BindView(R.id.ivImage)
    ImageView ivPhoto;
    private List<String> texts = new ArrayList<>();

    private boolean anyOptionChecked1 = false;
    private boolean anyOptionChecked2 = false;
    private boolean anyOptionChecked3 = false;
    private boolean anyOptionChecked4 = false;
    private boolean anyOptionChecked5 = false;

    private PreviousHouseAnswer previous = PreviousHouseAnswer.PREVIUS_HOUSE_SATISFACTION;
    private PreviousHouseAnswer generalAspects = PreviousHouseAnswer.GENERAL_ASPECTS;
    private PreviousHouseAnswer costBenefit = PreviousHouseAnswer.COST_BENEFIT;
    private PreviousHouseAnswer finishhing = PreviousHouseAnswer.FINISHHING;
    private PreviousHouseAnswer location = PreviousHouseAnswer.LOCATION;
    private PreviousHouseAnswer size = PreviousHouseAnswer.SIZE;
    private List<AnswerRequest> answerRequests = new ArrayList<>();

    public static PreviousSatisfactionRateFragment newInstance() {
        return new PreviousSatisfactionRateFragment();
    }

    @Override
    public void init() {
        tvQuestion.setText(previous.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
        texts.add("Muito Ruim");
        texts.add("Ruim");
        texts.add("Regular");
        texts.add("Bom");
        texts.add("Muito Bom");
        vhAcessibilidade.setMax(texts.size() - 1);
        vhAparencia.setMax(texts.size() - 1);
        vhConstrucao.setMax(texts.size() - 1);
        vhLimpeza.setMax(texts.size() - 1);
        vhTamanho.setMax(texts.size() - 1);
        initVolumes();
    }

    private void initVolumes() {
        vhAcessibilidade.setListener(position -> {
            ivPhoto.setImageResource(R.drawable.rate_aspecto_geral);
            anyOptionChecked1 = true;
            vhAcessibilidade.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(generalAspects.getQuestion(), generalAspects.getQuestionPartId(), texts.get(position)));
        });
        vhConstrucao.setListener(position -> {
            ivPhoto.setImageResource(R.drawable.rate_gasto);
            anyOptionChecked2 = true;
            vhConstrucao.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(costBenefit.getQuestion(), costBenefit.getQuestionPartId(), texts.get(position)));
        });
        vhAparencia.setListener(position -> {
            ivPhoto.setImageResource(R.drawable.rate_acabamento);
            anyOptionChecked3 = true;
            vhAparencia.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(finishhing.getQuestion(), finishhing.getQuestionPartId(), texts.get(position)));
        });
        vhLimpeza.setListener(position -> {
            ivPhoto.setImageResource(R.drawable.rate_localizacao);
            anyOptionChecked4 = true;
            vhLimpeza.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(location.getQuestion(), location.getQuestionPartId(), texts.get(position)));
        });
        vhTamanho.setListener(position -> {
            ivPhoto.setImageResource(R.drawable.rate_tamanho);
            anyOptionChecked5 = true;
            vhTamanho.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(size.getQuestion(), size.getQuestionPartId(), texts.get(position)));
        });

    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_satisfaction_rate;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked1 && anyOptionChecked2 && anyOptionChecked3 && anyOptionChecked4 && anyOptionChecked5) {
            setAnswers();
            ((AboutYouActivity) requireActivity()).addFragment(PreviousHouseTimeFragment.newInstance());
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
        Intent intent = new Intent(getActivity(), SplashAboutYouActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

}
