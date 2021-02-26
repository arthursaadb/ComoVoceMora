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

import static br.com.como_voce_mora.model.UnityAnswer.USE_AS_EXTRA_YES;

public class UnityExtraIncomeFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
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

    private boolean anyOptionCheckedYes = false;
    private boolean anyOptionCheckedYesDetails = false;
    private boolean anyOptionCheckedNo = false;
    private AnswerRequest answerRequest;
    private StringBuilder answer = new StringBuilder();
    private UnityAnswer unityAnswer = UnityAnswer.USE_AS_EXTRA;

    public static UnityExtraIncomeFragment newInstance() {
        return new UnityExtraIncomeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_extra_incoming;
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
                    mScrollView.setVisibility(View.VISIBLE);
                    mRbEletroPequeno.setChecked(false);
                    mRbEletroGrande.setChecked(false);
                    rbMoveisPequenos.setChecked(false);
                    rbMoveisGrandes.setChecked(false);
                    mRbPortas.setChecked(false);
                    mRbPosicaoRuim.setChecked(false);
                    mRbMoveisNovos.setChecked(false);
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
                    mScrollView.setVisibility(View.GONE);
                    answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), buttonView.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbEletroPequeno:
                    anyOptionCheckedYesDetails = true;
                    mRbEletroPequeno.setChecked(true);
                    answer.append(buttonView.getText().toString());
                    answer.append(";");
                    updateRbs();
                    break;
                case R.id.rbEletroGrande:
                    anyOptionCheckedYesDetails = true;
                    mRbEletroGrande.setChecked(true);
                    answer.append(buttonView.getText().toString());
                    answer.append(";");
                    updateRbs();
                    break;
                case R.id.rbMoveisPequeno:
                    anyOptionCheckedYesDetails = true;
                    rbMoveisPequenos.setChecked(true);
                    answer.append(buttonView.getText().toString());
                    answer.append(";");
                    updateRbs();
                    break;
                case R.id.rbMoveisGrandes:
                    anyOptionCheckedYesDetails = true;
                    rbMoveisGrandes.setChecked(true);
                    answer.append(buttonView.getText().toString());
                    answer.append(";");
                    updateRbs();
                    break;
                case R.id.rbPortas:
                    anyOptionCheckedYesDetails = true;
                    mRbPortas.setChecked(true);
                    answer.append(buttonView.getText().toString());
                    answer.append(";");
                    updateRbs();
                    break;
                case R.id.rbPosicaoRuim:
                    anyOptionCheckedYesDetails = true;
                    mRbPosicaoRuim.setChecked(true);
                    answer.append(buttonView.getText().toString());
                    answer.append(";");
                    updateRbs();
                    break;
                case R.id.rbMoveisNovos:
                    anyOptionCheckedYesDetails = true;
                    mRbMoveisNovos.setChecked(true);
                    answer.append(buttonView.getText().toString());
                    answer.append(";");
                    updateRbs();
                    break;
            }
        } else {
            switch (buttonView.getId()) {
                case R.id.rbEletroPequeno:
                    mRbEletroPequeno.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbEletroGrande:
                    mRbEletroGrande.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbMoveisPequeno:
                    rbMoveisPequenos.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbMoveisGrandes:
                    rbMoveisGrandes.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbPortas:
                    mRbPortas.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbPosicaoRuim:
                    mRbPosicaoRuim.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbMoveisNovos:
                    mRbMoveisNovos.setChecked(false);
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
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionCheckedNo) {
            if (getActivity() != null) {
                ResearchFlow.addAnswer(answerRequest, this);

                ResearchFlow.addAnswer(new AnswerRequest(USE_AS_EXTRA_YES.getQuestion(),
                        USE_AS_EXTRA_YES.getQuestionPartId(), answer.toString()), this);

                ((AboutYouActivity) getActivity()).addFragment(UnityRateLivingFragment.newInstance());
            }
        } else {
            if (anyOptionCheckedYes && anyOptionCheckedYesDetails) {
                if (getActivity() != null) {
                    ResearchFlow.addAnswer(answerRequest, this);

                    ResearchFlow.addAnswer(new AnswerRequest(USE_AS_EXTRA_YES.getQuestion(),
                            USE_AS_EXTRA_YES.getQuestionPartId(), answer.toString()), this);

                    ((AboutYouActivity) getActivity()).addFragment(UnityRateLivingFragment.newInstance());
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
