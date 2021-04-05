package br.com.como_voce_mora.ui.unity;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import java.util.ArrayList;
import java.util.Collections;
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

public class UnityActualHouseLivingFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

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
    private List<String> answerList = new ArrayList<>();
    private StringBuilder answer = new StringBuilder();
    private UnityAnswer unityAnswer = UnityAnswer.KEEP_FURNISHINGS;
    private boolean anyOptionCheckedNo = false;
    private boolean anyOptionCheckedYes = false;
    private boolean anyOptionCheckedNoDetails = false;

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
        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
        mRbEletroPequeno.setOnCheckedChangeListener(this);
        mRbEletroGrande.setOnCheckedChangeListener(this);
        rbMoveisPequenos.setOnCheckedChangeListener(this);
        rbMoveisGrandes.setOnCheckedChangeListener(this);
        mRbPortas.setOnCheckedChangeListener(this);
        mRbPosicaoRuim.setOnCheckedChangeListener(this);
        mRbMoveisNovos.setOnCheckedChangeListener(this);
        mRbExcesso.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbYes:
                    anyOptionCheckedYes = true;
                    anyOptionCheckedNo = false;
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
                    answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbNo:
                    anyOptionCheckedYes = false;
                    anyOptionCheckedNo = true;
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
                    answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbEletroPequeno:
                    anyOptionCheckedNoDetails = true;
                    mRbEletroPequeno.setChecked(true);
                    answerList.add(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbEletroGrande:
                    anyOptionCheckedNoDetails = true;
                    mRbEletroGrande.setChecked(true);
                    answerList.add(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbMoveisPequeno:
                    anyOptionCheckedNoDetails = true;
                    rbMoveisPequenos.setChecked(true);
                    answerList.add(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbMoveisGrandes:
                    anyOptionCheckedNoDetails = true;
                    rbMoveisGrandes.setChecked(true);
                    answerList.add(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbPortas:
                    anyOptionCheckedNoDetails = true;
                    mRbPortas.setChecked(true);
                    answerList.add(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbPosicaoRuim:
                    anyOptionCheckedNoDetails = true;
                    mRbPosicaoRuim.setChecked(true);
                    answerList.add(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbMoveisNovos:
                    anyOptionCheckedNoDetails = true;
                    mRbMoveisNovos.setChecked(true);
                    answerList.add(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbExcesso:
                    anyOptionCheckedNoDetails = true;
                    mRbExcesso.setChecked(true);
                    answerList.add(buttonView.getText().toString());
                    updateRbs();
                    break;
            }
        } else {
            switch (buttonView.getId()) {
                case R.id.rbEletroPequeno:
                    mRbEletroPequeno.setChecked(false);
                    answerList.remove(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbEletroGrande:
                    mRbEletroGrande.setChecked(false);
                    answerList.remove(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbMoveisPequeno:
                    rbMoveisPequenos.setChecked(false);
                    answerList.remove(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbMoveisGrandes:
                    rbMoveisGrandes.setChecked(false);
                    answerList.remove(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbPortas:
                    mRbPortas.setChecked(false);
                    answerList.remove(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbPosicaoRuim:
                    mRbPosicaoRuim.setChecked(false);
                    answerList.remove(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbMoveisNovos:
                    mRbMoveisNovos.setChecked(false);
                    answerList.remove(buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbExcesso:
                    mRbExcesso.setChecked(false);
                    answerList.remove(buttonView.getText().toString());
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
        if(answerList.size() > 0){
            for(String value: answerList){
                answer.append(value);
                answer.append(";");
            }
        }

        if (anyOptionCheckedYes) {
            if (getActivity() != null) {
                ResearchFlow.addAnswer(answerRequest, this);
                ResearchFlow.addAnswer(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), answer.toString()), this);
                ((AboutYouActivity) getActivity()).addFragment(UnityExtraIncomeFragment.newInstance());
            }
        } else {
            if (anyOptionCheckedNo && anyOptionCheckedNoDetails) {
                if (getActivity() != null) {
                    ResearchFlow.addAnswer(answerRequest, this);
                    ResearchFlow.addAnswer(new AnswerRequest(KEEP_FURNISHINGS_WHY.getQuestion(), KEEP_FURNISHINGS_WHY.getQuestionPartId(), answer.toString()), this);
                    ((AboutYouActivity) getActivity()).addFragment(UnityExtraIncomeFragment.newInstance());
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

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}
