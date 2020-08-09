package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.HouseGroupAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingWhichDivisionFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationSatisfactionFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.rbPiscina)
    CustomRadioButton rbPiscina;
    @BindView(R.id.rbSauna)
    CustomRadioButton rbSauna;
    @BindView(R.id.rbSalao)
    CustomRadioButton rbSalao;
    @BindView(R.id.rbEspaco)
    CustomRadioButton rbEspaco;
    @BindView(R.id.rbQuiosque)
    CustomRadioButton rbQuiosque;
    @BindView(R.id.rbQuadra)
    CustomRadioButton rbQuadra;
    @BindView(R.id.rbSalaoJogos)
    CustomRadioButton rbSalaoJogos;
    @BindView(R.id.rbPiscinaAdulto)
    CustomRadioButton rbPiscinaAdulto;
    @BindView(R.id.rbPlayground)
    CustomRadioButton rbPlayground;
    @BindView(R.id.rbAcademia)
    CustomRadioButton rbAcademia;
    @BindView(R.id.rbChurrasco)
    CustomRadioButton rbChurrasco;
    @BindView(R.id.rbOutro)
    CustomRadioButton rbOutro;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private AnswerRequest answerRequest;
    HouseGroupAnswer houseGroupAnswer = HouseGroupAnswer.EQUIPMENTS_TO_ADD;
    boolean anyOptionCheck = false;

    public static HabitationSatisfactionFragment newInstance() {

        Bundle args = new Bundle();

        HabitationSatisfactionFragment fragment = new HabitationSatisfactionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_satisfaction;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
        tvQuestion.setText(houseGroupAnswer.getQuestion());
        rbPiscina.setOnCheckedChangeListener(this);
        rbSauna.setOnCheckedChangeListener(this);
        rbSalao.setOnCheckedChangeListener(this);
        rbEspaco.setOnCheckedChangeListener(this);
        rbQuiosque.setOnCheckedChangeListener(this);
        rbQuadra.setOnCheckedChangeListener(this);
        rbSalaoJogos.setOnCheckedChangeListener(this);
        rbPiscinaAdulto.setOnCheckedChangeListener(this);
        rbPlayground.setOnCheckedChangeListener(this);
        rbAcademia.setOnCheckedChangeListener(this);
        rbChurrasco.setOnCheckedChangeListener(this);
        rbOutro.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null && anyOptionCheck) {
            ((AboutYouActivity) getActivity()).addFragment(HabitationEquipmentsMeaningFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        anyOptionCheck = true;
        setAnswer(compoundButton.getText().toString());
        updateRbs();
    }

    private void updateRbs() {
        rbPiscina.updateView();
        rbSauna.updateView();
        rbSalao.updateView();
        rbEspaco.updateView();
        rbQuiosque.updateView();
        rbQuadra.updateView();
        rbSalaoJogos.updateView();
        rbPiscinaAdulto.updateView();
        rbPlayground.updateView();
        rbAcademia.updateView();
        rbChurrasco.updateView();
        rbOutro.updateView();
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(houseGroupAnswer.getQuestion(), houseGroupAnswer.getQuestionPartId(), text);
    }
}
