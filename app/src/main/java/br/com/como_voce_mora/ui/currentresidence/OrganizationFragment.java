package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class OrganizationFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.rbYes)
    CustomRadioButton mRbFemale;
    @BindView(R.id.rbNo)
    CustomRadioButton mRbMale;
    @BindView(R.id.rbOther)
    CustomRadioButton mRbOther;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.etAddress)
    EditText etAdress;
    @BindView(R.id.tvCity)
    TextView tvCity;

    List<AnswerRequest> answerRequestList = new ArrayList<>();
    CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.NEIGHBORHOOD_ORGANIZATION;
    CurrentResidenceAnswer currentResidenceAnswerIfYes = CurrentResidenceAnswer.NEIGHBORHOOD_ORGANIZATION_TYPE;

    public static OrganizationFragment newInstance() {

        Bundle args = new Bundle();

        OrganizationFragment fragment = new OrganizationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_organization;
    }

    @Override
    public void init() {
        tvQuestion.setText(currentResidenceAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ACTUAL_RESIDENCE);
        mRbFemale.setOnCheckedChangeListener(this);
        mRbMale.setOnCheckedChangeListener(this);
        mRbOther.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbYes:
                    mRbFemale.setChecked(true);
                    mRbMale.setChecked(false);
                    mRbOther.setChecked(false);
                    answerRequestList.clear();
                    answerRequestList.add(new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), mRbFemale.getText().toString()));

                    show();
                    updateRbs();
                    break;
                case R.id.rbNo:
                    mRbFemale.setChecked(false);
                    mRbMale.setChecked(true);
                    mRbOther.setChecked(false);
                    answerRequestList.clear();
                    answerRequestList.add(new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), mRbMale.getText().toString()));
                    hide();
                    updateRbs();
                    break;
                case R.id.rbOther:
                    mRbFemale.setChecked(false);
                    mRbMale.setChecked(false);
                    mRbOther.setChecked(true);
                    answerRequestList.clear();
                    answerRequestList.add(new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), mRbOther.getText().toString()));
                    hide();
                    updateRbs();
                    break;
            }
        }
    }

    private void hide() {
        tvCity.setVisibility(View.INVISIBLE);
        etAdress.setVisibility(View.INVISIBLE);
    }

    private void show() {
        tvCity.setVisibility(View.VISIBLE);
        etAdress.setVisibility(View.VISIBLE);
    }

    private void updateRbs() {
        mRbFemale.updateView();
        mRbMale.updateView();
        mRbOther.updateView();

    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        answerRequestList.add(new AnswerRequest(currentResidenceAnswerIfYes.getQuestion(), currentResidenceAnswerIfYes.getQuestionPartId(), etAdress.getText().toString()));
        setAnswer();
        ((AboutYouActivity) requireActivity()).addFragment(CityIntegrationFragment.newInstance());

    }

    private void setAnswer() {
        AnswerRequest answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), "");
        ResearchFlow.addAnswer(currentResidenceAnswer.getQuestion(), answerRequest);
        for (AnswerRequest r : answerRequestList) {
            ResearchFlow.addAnswer(r.getDwellerId(), r);
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
