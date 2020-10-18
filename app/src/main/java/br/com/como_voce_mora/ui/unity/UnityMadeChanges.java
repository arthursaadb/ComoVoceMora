package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import java.io.Serializable;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityMadeChanges extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.rbYes)
    CustomRadioButton mRb1;
    @BindView(R.id.rbNo)
    CustomRadioButton mRb2;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.scrollView)
    NestedScrollView mScrollView;
    @BindView(R.id.rbEletroPequeno)
    CustomRadioButton mRbEletroPequeno;
    @BindView(R.id.rbEletroGrande)
    CustomRadioButton mRbEletroGrande;
    @BindView(R.id.rbMoveisPequeno)
    CustomRadioButton rbMoveisPequenos;
    @BindView(R.id.rbMoveisGrandes)
    CustomRadioButton rbMoveisGrandes;
    @BindView(R.id.rbPortas)
    CustomRadioButton mRbPortas;
    @BindView(R.id.rbPosicaoRuim)
    CustomRadioButton mRbPosicaoRuim;
    @BindView(R.id.rbMoveisNovos)
    CustomRadioButton mRbMoveisNovos;
    @BindView(R.id.rbIlumination)
    CustomRadioButton mRbIlumination;


    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private UnityAnswer unityAnswer = UnityAnswer.MADE_LIST_CHANGES;

    public static UnityMadeChanges newInstance(List<UnityAnswer> room) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
        UnityMadeChanges fragment = new UnityMadeChanges();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.unity_made_change;
    }

    @Override
    public void init() {
        tvQuestion.setText(unityAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        mRb1.setOnClickListener(this);
        mRb2.setOnClickListener(this);
        mRbEletroPequeno.setOnClickListener(this);
        mRbEletroGrande.setOnClickListener(this);
        rbMoveisPequenos.setOnClickListener(this);
        rbMoveisGrandes.setOnClickListener(this);
        mRbPortas.setOnClickListener(this);
        mRbPosicaoRuim.setOnClickListener(this);
        mRbMoveisNovos.setOnClickListener(this);
        mRbIlumination.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CustomRadioButton  option = (CustomRadioButton) v;
        if (v.isPressed()) {
            anyOptionChecked = true;
            setAnswer(option.getText().toString());
            switch (option.getId()) {
                case R.id.rbYes:
                    mRb1.setChecked(true);
                    mRb2.setChecked(false);
                    mRbEletroPequeno.setText("Variar posição dos móveis");
                    mRbEletroGrande.setText("Variar posição dos eletrodomésticos");
                    rbMoveisPequenos.setText("Inserir flores e plantas naturais");
                    rbMoveisGrandes.setText("Inserir objetos decorativos");
                    mRbPortas.setText("Pintar e/ou usar papel de parede");
                    mRbPosicaoRuim.setText("Abrir vãos e/ou derrubar paredes");
                    mRbMoveisNovos.setText("Colocar forro de gesso");
                    mRbIlumination.setText("Acrescentar iluminação");
                    mScrollView.setVisibility(View.VISIBLE);
                    mRbEletroPequeno.setChecked(false);
                    mRbEletroGrande.setChecked(false);
                    rbMoveisPequenos.setChecked(false);
                    rbMoveisGrandes.setChecked(false);
                    mRbPortas.setChecked(false);
                    mRbPosicaoRuim.setChecked(false);
                    mRbMoveisNovos.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbNo:
                    mRb1.setChecked(false);
                    mRb2.setChecked(true);
                    mRbEletroPequeno.setText("Limitações financeiras");
                    mRbEletroGrande.setText("Já estou satisfeita(o)");
                    rbMoveisPequenos.setText("Falta de assistência profissional");
                    rbMoveisGrandes.setText("Não gosto desses objetos");
                    mRbPortas.setText("Não tenho esses objetos");
                    mRbPosicaoRuim.setText("Vou me mudar em breve");
                    mRbMoveisNovos.setText("Moro de aluguel");
                    mRbIlumination.setText("Mudei recentemente");
                    mRbEletroPequeno.setChecked(false);
                    mRbEletroGrande.setChecked(false);
                    rbMoveisPequenos.setChecked(false);
                    rbMoveisGrandes.setChecked(false);
                    mRbPortas.setChecked(false);
                    mRbPosicaoRuim.setChecked(false);
                    mRbMoveisNovos.setChecked(false);
                    mRbIlumination.setChecked(false);
                    mScrollView.setVisibility(View.VISIBLE);
                    updateRbs();
                    break;
            }
        }
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), text);
    }

    private void updateRbs() {
        mRb1.updateView();
        mRb2.updateView();
        mRbEletroPequeno.updateView();
        mRbEletroGrande.updateView();
        rbMoveisPequenos.updateView();
        rbMoveisGrandes.updateView();
        mRbPortas.updateView();
        mRbPosicaoRuim.updateView();
        mRbMoveisNovos.updateView();
        mRbIlumination.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            if (getActivity() != null) {
                ResearchFlow.addAnswer(answerRequest, this);
                ((AboutYouActivity) getActivity()).addFragment(UnitySunLightFragment.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
            }
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
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}
