package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.SustainableHabitsAnswer;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

import static br.com.como_voce_mora.model.UnityAnswer.MADE_LIST_CHANGES_NO;
import static br.com.como_voce_mora.model.UnityAnswer.MADE_LIST_CHANGES_YES;

public class UnityMadeChanges extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
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
    private boolean anyOptionDetailsChecked = false;
    boolean isYesOption = false;
    private AnswerRequest answerRequest;
    private StringBuilder answerRequestYes = new StringBuilder();
    private StringBuilder answerRequestNo = new StringBuilder();
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
        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
        mRbEletroPequeno.setOnCheckedChangeListener(this);
        mRbEletroGrande.setOnCheckedChangeListener(this);
        rbMoveisPequenos.setOnCheckedChangeListener(this);
        rbMoveisGrandes.setOnCheckedChangeListener(this);
        mRbPortas.setOnCheckedChangeListener(this);
        mRbPosicaoRuim.setOnCheckedChangeListener(this);
        mRbMoveisNovos.setOnCheckedChangeListener(this);
        mRbIlumination.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.rbYes:
                if (isChecked) {
                    anyOptionDetailsChecked = false;
                    anyOptionChecked = true;
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
                    answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), "Sim");
                    isYesOption = true;
                }
                updateRbs();
                break;
            case R.id.rbNo:
                if (isChecked) {
                    anyOptionDetailsChecked = false;
                    anyOptionChecked = true;
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
                    answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), "Não");
                    isYesOption = false;
                }
                updateRbs();
                break;
            case R.id.rbEletroPequeno:
                anyOptionDetailsChecked = true;
                mRbEletroPequeno.setChecked(isChecked);
                setAnswers("Variar posição dos móveis", "Limitações financeiras", isChecked, isYesOption);
                updateRbs();
                break;
            case R.id.rbEletroGrande:
                anyOptionDetailsChecked = true;
                mRbEletroGrande.setChecked(isChecked);
                setAnswers("Variar posição dos eletrodomésticos", "Já estou satisfeita(o)", isChecked, isYesOption);
                updateRbs();
                break;
            case R.id.rbMoveisPequeno:
                anyOptionDetailsChecked = true;
                rbMoveisPequenos.setChecked(isChecked);
                setAnswers("Inserir flores e plantas naturais", "Falta de assistência profissional", isChecked, isYesOption);
                updateRbs();
                break;
            case R.id.rbPortas:
                anyOptionDetailsChecked = true;
                mRbPortas.setChecked(isChecked);
                setAnswers("Pintar e/ou usar papel de parede", "Não tenho esses objetos", isChecked, isYesOption);
                updateRbs();
                break;
            case R.id.rbPosicaoRuim:
                anyOptionDetailsChecked = true;
                mRbPosicaoRuim.setChecked(isChecked);
                setAnswers("Abrir vãos e/ou derrubar paredes", "Vou me mudar em breve", isChecked, isYesOption);
                updateRbs();
                break;
            case R.id.rbMoveisNovos:
                anyOptionDetailsChecked = true;
                mRbMoveisNovos.setChecked(isChecked);
                setAnswers("Colocar forro de gesso", "Moro de aluguel", isChecked, isYesOption);
                updateRbs();
                break;
            case R.id.rbMoveisGrandes:
                anyOptionDetailsChecked = true;
                rbMoveisGrandes.setChecked(isChecked);
                setAnswers("Inserir objetos decorativos", "Não gosto desses objetos", isChecked, isYesOption);
                updateRbs();
                break;
            case R.id.rbIlumination:
                anyOptionDetailsChecked = true;
                mRbIlumination.setChecked(isChecked);
                setAnswers("Acrescentar iluminação", "Mudei recentemente", isChecked, isYesOption);
                updateRbs();
                break;
        }
    }

    private void setAnswers(String textYes, String textNo, boolean isChecked, boolean isYesOption) {
        if (isChecked) {
            if (isYesOption) {
                answerRequestYes.append(textYes);
                answerRequestYes.append(";");
            } else {
                answerRequestNo.append(textNo);
                answerRequestNo.append(";");
            }
        }
    }

    private void setAnswer() {
        ResearchFlow.addAnswer(answerRequest, this);

        if (answerRequestYes.length() != 0) {
            ResearchFlow.addAnswer(new AnswerRequest(MADE_LIST_CHANGES_YES.getQuestion(), MADE_LIST_CHANGES_YES.getQuestionPartId(), answerRequestYes.toString()), this);
        }

        if (answerRequestNo.length() != 0) {
            ResearchFlow.addAnswer(new AnswerRequest(MADE_LIST_CHANGES_NO.getQuestion(), MADE_LIST_CHANGES_NO.getQuestionPartId(), answerRequestNo.toString()), this);
        }
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
                setAnswer();
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
