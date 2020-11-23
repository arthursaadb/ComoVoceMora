package br.com.como_voce_mora.ui.aboutyou;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AboutYouAnswer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class WithWhomYouLiveFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.csv1)
    CustomSelectedView csv1;
    @BindView(R.id.csv2)
    CustomSelectedView csv2;
    @BindView(R.id.csv3)
    CustomSelectedView csv3;
    @BindView(R.id.csv4)
    CustomSelectedView csv4;
    @BindView(R.id.csv5)
    CustomSelectedView csv5;
    @BindView(R.id.csv6)
    CustomSelectedView csv6;
    @BindView(R.id.csv7)
    CustomSelectedView csv7;
    @BindView(R.id.csv8)
    CustomSelectedView csv8;
    @BindView(R.id.csv9)
    CustomSelectedView csv9;
    @BindView(R.id.csv10)
    CustomSelectedView csv10;
    @BindView(R.id.csv11)
    CustomSelectedView csv11;
    @BindView(R.id.csv12)
    CustomSelectedView csv12;
    @BindView(R.id.csv13)
    CustomSelectedView csv13;

    private AboutYouAnswer aboutYouAnswer = AboutYouAnswer.NUMBER_OF_PERSON;
    private List<AnswerRequest> answerRequests = new ArrayList<>();


    public static WithWhomYouLiveFragment newInstance() {
        return new WithWhomYouLiveFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_withwhomyoulive;
    }

    @Override
    public void init() {
        tvQuestion.setText(aboutYouAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ABOUT_YOU);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            for (AnswerRequest r : answerRequests) {
                ResearchFlow.addAnswer(r, this);
            }

            ((AboutYouActivity) getActivity()).addFragment(FamilyIncomeFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick({R.id.csv1, R.id.csv2, R.id.csv3, R.id.csv4, R.id.csv5,
            R.id.csv6, R.id.csv7, R.id.csv8, R.id.csv9, R.id.csv10,
            R.id.csv11, R.id.csv12, R.id.csv13})
    public void onClickViews(View view) {
        switch (view.getId()) {
            case R.id.csv1:
                AnswerRequest answerRequest1 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv1.getText());
                if (!csv1.isChecked()) {
                    answerRequests.add(answerRequest1);
                    csv1.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest1);
                    csv1.setChecked(false);
                }
                break;
            case R.id.csv2:
                AnswerRequest answerRequest2 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv2.getText());
                if (!csv2.isChecked()) {
                    answerRequests.add(answerRequest2);
                    csv2.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest2);
                    csv2.setChecked(false);
                }
                break;
            case R.id.csv3:
                AnswerRequest answerRequest3 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv3.getText());
                if (!csv3.isChecked()) {
                    answerRequests.add(answerRequest3);
                    csv3.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest3);
                    csv3.setChecked(false);
                }
                break;
            case R.id.csv4:
                AnswerRequest answerRequest4 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv4.getText());
                if (!csv4.isChecked()) {
                    answerRequests.add(answerRequest4);
                    csv4.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest4);
                    csv4.setChecked(false);
                }
                break;
            case R.id.csv5:
                AnswerRequest answerRequest5 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv5.getText());
                if (!csv5.isChecked()) {
                    answerRequests.add(answerRequest5);
                    csv5.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest5);
                    csv5.setChecked(false);
                }
                break;
            case R.id.csv6:
                AnswerRequest answerRequest6 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv6.getText());
                if (!csv6.isChecked()) {
                    answerRequests.add(answerRequest6);
                    csv6.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest6);
                    csv6.setChecked(false);
                }
                break;
            case R.id.csv7:
                AnswerRequest answerRequest7 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv7.getText());
                if (!csv7.isChecked()) {
                    answerRequests.add(answerRequest7);
                    csv7.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest7);
                    csv7.setChecked(false);
                }
                break;
            case R.id.csv8:
                AnswerRequest answerRequest8 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv8.getText());
                if (!csv8.isChecked()) {
                    answerRequests.add(answerRequest8);
                    csv8.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest8);
                    csv8.setChecked(false);
                }
                break;
            case R.id.csv9:
                AnswerRequest answerRequest9 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv9.getText());
                if (!csv9.isChecked()) {
                    answerRequests.add(answerRequest9);
                    csv9.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest9);
                    csv9.setChecked(false);
                }
                break;
            case R.id.csv10:
                AnswerRequest answerRequest10 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv10.getText());
                if (!csv10.isChecked()) {
                    answerRequests.add(answerRequest10);
                    csv10.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest10);
                    csv10.setChecked(false);
                }
                break;
            case R.id.csv11:
                AnswerRequest answerRequest11 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv11.getText());
                if (!csv11.isChecked()) {
                    answerRequests.add(answerRequest11);
                    csv11.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest11);
                    csv11.setChecked(false);
                }
                break;
            case R.id.csv12:
                AnswerRequest answerRequest12 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv12.getText());
                if (!csv12.isChecked()) {
                    answerRequests.add(answerRequest12);
                    csv12.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest12);
                    csv12.setChecked(false);
                }
                break;
            case R.id.csv13:
                AnswerRequest answerRequest13 = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), csv1.getText());
                if (!csv13.isChecked()) {
                    answerRequests.add(answerRequest13);
                    csv13.setChecked(true);
                } else {
                    answerRequests.remove(answerRequest13);
                    csv13.setChecked(false);
                }
                break;
        }

    }
}
