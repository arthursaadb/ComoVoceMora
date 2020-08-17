package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.previoushouse.PreviousHomeSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class PublicAreaFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    List<AnswerRequest> answerRequests = new ArrayList<>();
    CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.DEFAULT_PULIC_AREA;


    public static PublicAreaFragment newInstance() {

        Bundle args = new Bundle();

        PublicAreaFragment fragment = new PublicAreaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_public_area;
    }

    @Override
    public void init() {
        tvQuestion.setText(currentResidenceAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ACTUAL_RESIDENCE);
    }

    @OnClick({R.id.csvPraca, R.id.csvParque, R.id.csvAcademia,
        R.id.csvQuadra})
    void onClickViews(View view) {
        CustomSelectedView csv = (CustomSelectedView) view;
        switch (view.getId()) {
            case R.id.csvPraca:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                        currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                    break;
                }
            case R.id.csvParque:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                        currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                }
            case R.id.csvAcademia:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                        currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                }
            case R.id.csvQuadra:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                        currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                }
        }
    }

    private void removeItem(String question) {
        int cont = 0;
        int pos = cont;
        if (!answerRequests.isEmpty()) {
            for (AnswerRequest r : answerRequests) {
                if (r.getDwellerId().equals(question)) {
                    pos = cont;
                }
                cont++;
            }
            answerRequests.remove(pos);
        }
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        setAnswer();
        ((AboutYouActivity) requireActivity()).addFragment(WhatsYourSatisfactionFragment.newInstance());
    }

    private void setAnswer() {
        AnswerRequest answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), "");
        ResearchFlow.addAnswer(answerRequest, this);
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r, this);
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
            ((AboutYouActivity) requireActivity()).addFragment(PreviousHomeSplashFragment.newInstance());
        }
    }
}
