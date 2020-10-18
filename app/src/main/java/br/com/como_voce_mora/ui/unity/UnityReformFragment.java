package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

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
import br.com.como_voce_mora.ui.building.BuildingFloorFragment;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityReformFragment extends BaseFragment implements View.OnClickListener {

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


    public static UnityReformFragment newInstance(List<UnityAnswer> room) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
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
        mRb1.setOnClickListener(this);
        mRb2.setOnClickListener(this);
        mRb3.setOnClickListener(this);
        mRb4.setOnClickListener(this);
        mRb6.setOnClickListener(this);
        mRb5.setOnClickListener(this);
        mRb7.setOnClickListener(this);
        mRb8.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        CustomRadioButton  option = (CustomRadioButton) v;
        if (v.isPressed()) {
            none = false;
            mRb8.setChecked(false);
            switch (option.getId()) {
                case R.id.rbAcabamento:
                    acabamento = (String) option.getText();
                    updateRbs();
                    break;
                case R.id.rbPortas:
                    portas = (String) option.getText();
                    updateRbs();
                    break;
                case R.id.rbGesso:
                    gesso = (String) option.getText();
                    updateRbs();
                    break;
                case R.id.rbPintura:
                    pintura = (String) option.getText();
                    updateRbs();
                    break;
                case R.id.rbArmario:
                    armario = (String) option.getText();
                    updateRbs();
                    break;
                case R.id.rbParedes:
                    paredes = (String) option.getText();
                    updateRbs();
                    break;
                case R.id.rbRachaduras:
                    paredes = (String) option.getText();
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
                    nenhuma = (String) option.getText();
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
                ((AboutYouActivity) requireActivity()).addFragment(UnityReformssNeeds.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
            } else {
                ((AboutYouActivity) getActivity()).addFragment(UnityReformReasonFragment.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
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
        ResearchFlow.addAnswer(answerRequest, this);
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
