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
    private StringBuilder answer = new StringBuilder();

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
            ResearchFlow.addAnswer(new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), answer.toString()), this);
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
                if (!csv1.isChecked()) {
                    answer.append(csv1.getText());
                    answer.append(";");
                    csv1.setChecked(true);
                } else {
                    csv1.setChecked(false);
                }
                break;
            case R.id.csv2:
                if (!csv2.isChecked()) {
                    answer.append(csv2.getText());
                    answer.append(";");
                    csv2.setChecked(true);
                } else {
                    csv2.setChecked(false);
                }
                break;
            case R.id.csv3:
                if (!csv3.isChecked()) {
                    answer.append(csv3.getText());
                    answer.append(";");
                    csv3.setChecked(true);
                } else {
                    csv3.setChecked(false);
                }
                break;
            case R.id.csv4:
                if (!csv4.isChecked()) {
                    answer.append(csv4.getText());
                    answer.append(";");
                    csv4.setChecked(true);
                } else {
                    csv4.setChecked(false);
                }
                break;
            case R.id.csv5:
                if (!csv5.isChecked()) {
                    answer.append(csv5.getText());
                    answer.append(";");
                    csv5.setChecked(true);
                } else {
                    csv5.setChecked(false);
                }
                break;
            case R.id.csv6:
                if (!csv6.isChecked()) {
                    answer.append(csv6.getText());
                    answer.append(";");
                    csv6.setChecked(true);
                } else {
                    csv6.setChecked(false);
                }
                break;
            case R.id.csv7:
                if (!csv7.isChecked()) {
                    answer.append(csv7.getText());
                    answer.append(";");
                    csv7.setChecked(true);
                } else {
                    csv7.setChecked(false);
                }
                break;
            case R.id.csv8:
                if (!csv8.isChecked()) {
                    answer.append(csv8.getText());
                    answer.append(";");
                    csv8.setChecked(true);
                } else {
                    csv8.setChecked(false);
                }
                break;
            case R.id.csv9:
                if (!csv9.isChecked()) {
                    answer.append(csv9.getText());
                    answer.append(";");
                    csv9.setChecked(true);
                } else {
                    csv9.setChecked(false);
                }
                break;
            case R.id.csv10:
                if (!csv10.isChecked()) {
                    answer.append(csv10.getText());
                    answer.append(";");
                    csv10.setChecked(true);
                } else {
                    csv10.setChecked(false);
                }
                break;
            case R.id.csv11:
                if (!csv11.isChecked()) {
                    answer.append(csv11.getText());
                    answer.append(";");
                    csv11.setChecked(true);
                } else {
                    csv11.setChecked(false);
                }
                break;
            case R.id.csv12:
                if (!csv12.isChecked()) {
                    answer.append(csv12.getText());
                    answer.append(";");
                    csv12.setChecked(true);
                } else {
                    csv12.setChecked(false);
                }
                break;
            case R.id.csv13:
                if (!csv13.isChecked()) {
                    answer.append(csv13.getText());
                    answer.append(";");
                    csv13.setChecked(true);
                } else {
                    csv13.setChecked(false);
                }
                break;
        }

    }
}
