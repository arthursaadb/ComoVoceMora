package br.com.como_voce_mora.ui.unity;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import java.util.ArrayList;
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

import static br.com.como_voce_mora.model.UnityAnswer.KEEP_FURNISHINGS_WHY;

public class UnityActualHouseLivingFragment extends BaseFragment implements View.OnClickListener {

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
    @BindView(R.id.rbExcesso)
    CustomRadioButton mRbExcesso;

    private AnswerRequest answerRequest;
    private List<AnswerRequest> answerRequest2 = new ArrayList<>();
    private UnityAnswer unityAnswer = UnityAnswer.KEEP_FURNISHINGS;
    private boolean anyOptionChecked = false;

    public static UnityActualHouseLivingFragment newInstance() {
        return new UnityActualHouseLivingFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_actual_living;
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
        mRbExcesso.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CustomRadioButton option = (CustomRadioButton) v;
        anyOptionChecked = true;
        if (v.isPressed()) {
            switch (option.getId()) {
                case R.id.rbYes:
                    mRb1.setChecked(true);
                    mRb2.setChecked(false);
                    mScrollView.setVisibility(View.GONE);
                    mRbEletroPequeno.setChecked(false);
                    mRbEletroGrande.setChecked(false);
                    rbMoveisPequenos.setChecked(false);
                    rbMoveisGrandes.setChecked(false);
                    mRbPortas.setChecked(false);
                    mRbPosicaoRuim.setChecked(false);
                    mRbMoveisNovos.setChecked(false);
                    mRbExcesso.setChecked(false);
                    answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), option.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbNo:
                    mRb1.setChecked(false);
                    mRb2.setChecked(true);
                    mRbEletroPequeno.setChecked(false);
                    mRbEletroGrande.setChecked(false);
                    rbMoveisPequenos.setChecked(false);
                    rbMoveisGrandes.setChecked(false);
                    mRbPortas.setChecked(false);
                    mRbPosicaoRuim.setChecked(false);
                    mRbMoveisNovos.setChecked(false);
                    mRbExcesso.setChecked(false);
                    mScrollView.setVisibility(View.VISIBLE);
                    answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), option.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbEletroPequeno:
                    mRbEletroGrande.setChecked(true);
                    answerRequest2.add(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbEletroGrande:
                    mRbEletroPequeno.setChecked(true);
                    answerRequest2.add(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbMoveisPequeno:
                    rbMoveisPequenos.setChecked(true);
                    answerRequest2.add(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbMoveisGrandes:
                    rbMoveisGrandes.setChecked(true);
                    answerRequest2.add(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbPortas:
                    mRbPortas.setChecked(true);
                    answerRequest2.add(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbPosicaoRuim:
                    mRbPosicaoRuim.setChecked(true);
                    answerRequest2.add(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbMoveisNovos:
                    mRbMoveisNovos.setChecked(true);
                    answerRequest2.add(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbExcesso:
                    mRbExcesso.setChecked(true);
                    answerRequest2.add(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
            }
        } else {
            switch (option.getId()) {
                case R.id.rbEletroPequeno:
                    mRbEletroGrande.setChecked(false);
                    answerRequest2.remove(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbEletroGrande:
                    mRbEletroPequeno.setChecked(false);
                    answerRequest2.remove(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbMoveisPequeno:
                    rbMoveisPequenos.setChecked(false);
                    answerRequest2.remove(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbMoveisGrandes:
                    rbMoveisGrandes.setChecked(false);
                    answerRequest2.remove(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbPortas:
                    mRbPortas.setChecked(false);
                    answerRequest2.remove(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbPosicaoRuim:
                    mRbPosicaoRuim.setChecked(false);
                    answerRequest2.remove(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbMoveisNovos:
                    mRbMoveisNovos.setChecked(false);
                    answerRequest2.remove(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
                case R.id.rbExcesso:
                    mRbExcesso.setChecked(false);
                    answerRequest2.remove(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), option.getText().toString()));
                    updateRbs();
                    break;
            }
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
        mRbExcesso.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            if (getActivity() != null) {
                ResearchFlow.addAnswer(answerRequest, this);
                for (AnswerRequest r : answerRequest2) {
                    ResearchFlow.addAnswer(r, this);
                }
                ((AboutYouActivity) getActivity()).addFragment(UnityExtraIncomeFragment.newInstance());
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
