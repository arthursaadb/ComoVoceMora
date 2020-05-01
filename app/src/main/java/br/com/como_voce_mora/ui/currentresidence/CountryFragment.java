package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeVertical;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class CountryFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;
    @BindView(R.id.tv_age)
    TextView mTvAge;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;

    private List<Integer> images;
    private List<String> names;
    private AnswerRequest answerRequest;
//    private CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.STATE;

    public static CountryFragment newInstance() {

        Bundle args = new Bundle();

        CountryFragment fragment = new CountryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_country;
    }

    @Override
    public void init() {
        super.init();
//        tvQuestion.setText(currentResidenceAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ACTUAL_RESIDENCE);
        images = new ArrayList<>();
        names = new ArrayList<>();
        images.add(R.drawable.estado_acre);
        names.add("Acre");
        images.add(R.drawable.estado_alagoas);
        names.add("Alagoas");
        images.add(R.drawable.estado_amapa);
        names.add("Amapa");
        images.add(R.drawable.estado_amazonas);
        names.add("Amazonas");
        images.add(R.drawable.estado_bahia);
        names.add("Bahia");
        images.add(R.drawable.estado_ceara);
        names.add("Ceara");
        images.add(R.drawable.estado_distrito_federal);
        names.add("Distrito Federal");
        images.add(R.drawable.estado_espirito_santo);
        names.add("Espirito Santo");
        images.add(R.drawable.estado_goias);
        names.add("Goais");
        images.add(R.drawable.estado_maranhao);
        names.add("Maranhao");
        images.add(R.drawable.estado_mato_grosso);
        names.add("Mato Grosso");
        images.add(R.drawable.estado_mato_grosso_do_sul);
        names.add("Mato Grosso do Sul");
        images.add(R.drawable.estado_minas_gerais);
        names.add("Minas Gerais");
        images.add(R.drawable.estado_para);
        names.add("Para");
        images.add(R.drawable.estado_paraiba);
        names.add("Paraiba");
        images.add(R.drawable.estado_parana);
        names.add("Parana");
        images.add(R.drawable.estado_pernambuco);
        names.add("Pernambuco");
        images.add(R.drawable.estado_piaui);
        names.add("Piaui");
        images.add(R.drawable.estado_rio_de_janeiro);
        names.add("Rio de Janeiro");
        images.add(R.drawable.estado_rio_grande_do_norte);
        names.add("Rio Grande do Norte");
        images.add(R.drawable.estado_rio_grande_do_sul);
        names.add("Rio Grande do Sul");
        images.add(R.drawable.estado_rondonia);
        names.add("Rondonia");
        images.add(R.drawable.estado_roraima);
        names.add("Roraima");
        images.add(R.drawable.estado_sao_paulo);
        names.add("Sao Paulo");
        images.add(R.drawable.estado_santa_catarina);
        names.add("Santa Catarina");
        images.add(R.drawable.estado_sergipe);
        names.add("Sergipe");
        images.add(R.drawable.estado_tocantins);
        names.add("Tocantins");

        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);
//        answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), names.get(12));
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(images.get(position));
        mTvAge.setText(names.get(position));
        mTvAge.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
//        ResearchFlow.addAnswer(currentResidenceAnswer.getQuestion(), answerRequest);
        ((AboutYouActivity) requireActivity()).addFragment(WhatsYourAddressFragment.newInstance());
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
