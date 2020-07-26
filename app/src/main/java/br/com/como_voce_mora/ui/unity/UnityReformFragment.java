package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingFloorFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityReformFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;
    @BindView(R.id.rbAcabamento)
    CustomRadioButton mRb1;
    @BindView(R.id.rbPortas)
    CustomRadioButton mRb2;
    @BindView(R.id.rbGesso)
    CustomRadioButton mRb3;
    @BindView(R.id.rbPintura)
    CustomRadioButton mRb4;
    @BindView(R.id.rbArmario)
    CustomRadioButton mRb5;
    @BindView(R.id.rbParedes)
    CustomRadioButton mRb6;
    @BindView(R.id.rbRachaduras)
    CustomRadioButton mRb7;
    @BindView(R.id.rbNenhuma)
    CustomRadioButton mRb8;

    private UnityAnswer unityAnswer = UnityAnswer.REFORM_MADE;
    private AnswerRequest answerRequest;
    private String acabamento = "";
    private String portas = "";
    private String gesso = "";
    private String pintura = "";
    private String armario = "";
    private String paredes = "";
    private String rachaduras = "";
    private String nenhuma = "";
    private String answer = "";
    private  Boolean none = false;


    public static UnityReformFragment newInstance() {

        Bundle args = new Bundle();

        UnityReformFragment fragment = new UnityReformFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_reform;
    }

    @Override
    public void init() {
        mTvQuestion.setText(unityAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
        mRb3.setOnCheckedChangeListener(this);
        mRb4.setOnCheckedChangeListener(this);
        mRb6.setOnCheckedChangeListener(this);
        mRb5.setOnCheckedChangeListener(this);
        mRb7.setOnCheckedChangeListener(this);
        mRb8.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
        none = false;
            switch (buttonView.getId()) {
                case R.id.rbAcabamento:
                    mRb1.setChecked(true);
                    acabamento = (String) buttonView.getText();
                    updateRbs();
                    break;
                case R.id.rbPortas:
                    mRb2.setChecked(true);
                    portas = (String) buttonView.getText();
                    updateRbs();
                    break;
                case R.id.rbGesso:
                    mRb3.setChecked(true);
                    gesso = (String) buttonView.getText();
                    updateRbs();
                    break;
                case R.id.rbPintura:
                    mRb4.setChecked(true);
                    pintura = (String) buttonView.getText();
                    updateRbs();
                    break;
                case R.id.rbArmario:
                    mRb5.setChecked(true);
                    armario = (String) buttonView.getText();
                    updateRbs();
                    break;
                case R.id.rbParedes:
                    mRb6.setChecked(true);
                    paredes = (String) buttonView.getText();
                    updateRbs();
                    break;
                case R.id.rbRachaduras:
                    mRb7.setChecked(true);
                    paredes = (String) buttonView.getText();
                    updateRbs();
                    break;
                case R.id.rbNenhuma:
                    none = true;
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    mRb5.setChecked(false);
                    mRb6.setChecked(false);
                    mRb7.setChecked(false);
                    mRb8.setChecked(true);
                    nenhuma = (String) buttonView.getText();
                    updateRbs();
                    break;
            }
        }
    }

    private void updateRbs() {
        mRb1.updateView();
        mRb2.updateView();
        mRb3.updateView();
        mRb4.updateView();
        mRb5.updateView();
        mRb6.updateView();
        mRb7.updateView();
        mRb8.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            setAnswer();
            if (none) {

            } else {
                ((AboutYouActivity) getActivity()).addFragment(UnityReformReasonFragment.newInstance());
            }
        }
    }

    private void setAnswer() {
        if (!acabamento.equals("")) {
            answer += acabamento;
        }
        if (!portas.equals("")) {
            answer += portas;
        }
        if (!gesso.equals("")) {
            answer += gesso;
        }
        if (!pintura.equals("")) {
            answer += pintura;
        }
        if (!armario.equals("")) {
            answer += armario;
        }
        if (!paredes.equals("")) {
            answer += paredes;
        }
        if (!rachaduras.equals("")) {
            answer += rachaduras;
        }
        if (!nenhuma.equals("")) {
            answer += nenhuma;
        }

        answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), answer);
        ResearchFlow.addAnswer(unityAnswer.getQuestion(), answerRequest);
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
