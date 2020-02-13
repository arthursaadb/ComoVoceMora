package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.presenter.cep.CepPresenter;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class PublicAreaFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    List<AnswerRequest> answerRequests = new ArrayList<>();
    CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.PUBBLIC_SPACE;
    CurrentResidenceAnswer pracaCurrentResidenceAnswer = CurrentResidenceAnswer.SQUARE;
    CurrentResidenceAnswer parqueCurrentResidenceAnswer = CurrentResidenceAnswer.PARK;
    CurrentResidenceAnswer academiaCurrentResidenceAnswer = CurrentResidenceAnswer.GYM;
    CurrentResidenceAnswer esporteCurrentResidenceAnswer = CurrentResidenceAnswer.SPORTS_PLACE;


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
        super.init();
        tvQuestion.setText(currentResidenceAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ATUAL_RESIDENCE);
    }

    @OnClick({R.id.csvPraca, R.id.csvParque, R.id.csvAcademia,
        R.id.csvQuadra})
    void onClickViews(View view) {
        CustomSelectedView csv = (CustomSelectedView) view;
        switch (view.getId()) {
            case R.id.csvPraca:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerRequests.add(new AnswerRequest(pracaCurrentResidenceAnswer.getQuestion(),
                        pracaCurrentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(pracaCurrentResidenceAnswer.getQuestion());
                    break;
                }
            case R.id.csvParque:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerRequests.add(new AnswerRequest(parqueCurrentResidenceAnswer.getQuestion(),
                        parqueCurrentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(parqueCurrentResidenceAnswer.getQuestion());
                }
            case R.id.csvAcademia:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerRequests.add(new AnswerRequest(academiaCurrentResidenceAnswer.getQuestion(),
                        academiaCurrentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(academiaCurrentResidenceAnswer.getQuestion());
                }
            case R.id.csvQuadra:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerRequests.add(new AnswerRequest(esporteCurrentResidenceAnswer.getQuestion(),
                        esporteCurrentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(esporteCurrentResidenceAnswer.getQuestion());
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
        ResearchFlow.addAnswer(currentResidenceAnswer.getQuestion(), answerRequest);
        for (AnswerRequest r : answerRequests) {
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
