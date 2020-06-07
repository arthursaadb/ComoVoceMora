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
import butterknife.BindView;
import butterknife.OnClick;

public class UnitySunLightFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.rbManha)
    CustomRadioButton rbManha;
    @BindView(R.id.rbTarde)
    CustomRadioButton rbTarde;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private UnityAnswer unityAnswer = UnityAnswer.SUN_RECEIVE;

    public static UnitySunLightFragment newInstance() {

        Bundle args = new Bundle();

        UnitySunLightFragment fragment = new UnitySunLightFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_sunlight;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        mTvQuestion.setText(unityAnswer.getQuestion());

        rbManha.setOnCheckedChangeListener(this);
        rbTarde.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        anyOptionChecked = true;
        setAnswer(buttonView.getText().toString());
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbManha:
                    rbManha.setChecked(true);
                    rbTarde.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbTarde:
                    rbManha.setChecked(false);
                    rbTarde.setChecked(true);
                    updateRbs();
                    break;
            }
        }
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), text);
    }

    private void updateRbs() {
        rbTarde.updateView();
        rbManha.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(unityAnswer.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(UnityRoomsSunlightFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

}
