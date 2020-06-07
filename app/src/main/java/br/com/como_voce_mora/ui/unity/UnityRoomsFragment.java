package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.currentresidence.WhatsYourSatisfactionFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityRoomsFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    List<AnswerRequest> answerRequests = new ArrayList<>();

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_rooms;
    }

    public static UnityRoomsFragment newInstance() {

        Bundle args = new Bundle();

        UnityRoomsFragment fragment = new UnityRoomsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        tvQuestion.setText("Muito bem. Agora selecione os cômodos ou espaços que existem na sua moradia e sua quantidade.");
    }

    @OnClick({R.id.csvServico, R.id.csvBanheiro, R.id.csvCasal,
            R.id.csvSolteiro, R.id.csvSala, R.id.csvCopa, R.id.csvVaranda, R.id.csvCozinha})
    void onClickViews(View view) {
        CustomSelectedView csv = (CustomSelectedView) view;
        switch (view.getId()) {
            case R.id.csvServico:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
//                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
//                            currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                    break;
                }
            case R.id.csvBanheiro:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
//                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
//                            currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                }
            case R.id.csvCasal:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
//                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
//                            currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                }
            case R.id.csvSolteiro:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
//                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
//                            currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                }

            case R.id.csvSala:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
//                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
//                            currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                }

            case R.id.csvCopa:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
//                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
//                            currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                }

            case R.id.csvVaranda:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
//                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
//                            currentResidenceAnswer.getQuestionPartId(), csv.getText()));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(csv.getText());
                }
            case R.id.csvCozinha:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
//                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
//                            currentResidenceAnswer.getQuestionPartId(), csv.getText()));
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
//        setAnswer();
        ((AboutYouActivity) requireActivity()).addFragment(UnityRateRoomsFragment.newInstance());
    }

//    private void setAnswer() {
//        AnswerRequest answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), "");
//        ResearchFlow.addAnswer(currentResidenceAnswer.getQuestion(), answerRequest);
//        for (AnswerRequest r : answerRequests) {
//            ResearchFlow.addAnswer(r.getDwellerId(), r);
//        }
//    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

}
