package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.sustainablehabits.SustainableHabitsIntroFragment;
import butterknife.BindView;
import butterknife.OnClick;

import static br.com.como_voce_mora.model.UnityAnswer.KITCHEN_ACTIVITIES;

public class UnityRoomsSunlightFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.csvServico)
    CustomSelectedView csvServico;
    @BindView(R.id.csvBanheiro)
    CustomSelectedView csvBanheiro;
    @BindView(R.id.csvCasal)
    CustomSelectedView csvCasal;
    @BindView(R.id.csvSolteiro)
    CustomSelectedView csvSolteiro;
    @BindView(R.id.csvSala)
    CustomSelectedView csvSala;
    @BindView(R.id.csvCopa)
    CustomSelectedView csvCopa;
    @BindView(R.id.csvVaranda)
    CustomSelectedView csvVaranda;
    @BindView(R.id.csvCozinha)
    CustomSelectedView csvCozinha;


    StringBuilder answerRequests = new StringBuilder();
    UnityAnswer unityAnswer = UnityAnswer.BETTER_SUN;
    private boolean anyOptionChecked = false;

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_rooms_sunlight;
    }

    public static UnityRoomsSunlightFragment newInstance(List<UnityAnswer> room) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
        UnityRoomsSunlightFragment fragment = new UnityRoomsSunlightFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        tvQuestion.setText(unityAnswer.getQuestion());
    }

    @OnClick({R.id.csvServico, R.id.csvBanheiro, R.id.csvCasal,
            R.id.csvSolteiro, R.id.csvSala, R.id.csvCopa, R.id.csvVaranda, R.id.csvCozinha})
    void onClickViews(View view) {
        switch (view.getId()) {
            case R.id.csvServico:
                if (!csvServico.isChecked()) {
                    anyOptionChecked = true;
                    csvServico.setChecked(true);
                    answerRequests.append(csvServico.getText());
                    answerRequests.append(";");
                    break;
                } else {
                    csvServico.setChecked(false);
                    break;
                }
            case R.id.csvBanheiro:
                if (!csvBanheiro.isChecked()) {
                    anyOptionChecked = true;
                    csvBanheiro.setChecked(true);
                    answerRequests.append(csvBanheiro.getText());
                    answerRequests.append(";");
                    break;
                } else {
                    csvBanheiro.setChecked(false);
                    break;
                }
            case R.id.csvCasal:
                if (!csvCasal.isChecked()) {
                    anyOptionChecked = true;
                    csvCasal.setChecked(true);
                    answerRequests.append(csvCasal.getText());
                    answerRequests.append(";");
                    break;
                } else {
                    csvCasal.setChecked(false);
                    break;
                }
            case R.id.csvSolteiro:
                if (!csvSolteiro.isChecked()) {
                    anyOptionChecked = true;
                    csvSolteiro.setChecked(true);
                    answerRequests.append(csvSolteiro.getText());
                    answerRequests.append(";");
                    break;
                } else {
                    csvSolteiro.setChecked(false);
                    break;
                }

            case R.id.csvSala:
                if (!csvSala.isChecked()) {
                    anyOptionChecked = true;
                    csvSala.setChecked(true);
                    answerRequests.append(csvSala.getText());
                    answerRequests.append(";");
                    break;
                } else {
                    csvSala.setChecked(false);
                    break;
                }

            case R.id.csvCopa:
                if (!csvCopa.isChecked()) {
                    anyOptionChecked = true;
                    csvCopa.setChecked(true);
                    answerRequests.append(csvCopa.getText());
                    answerRequests.append(";");
                    break;
                } else {
                    csvCopa.setChecked(false);
                    break;
                }

            case R.id.csvVaranda:
                if (!csvVaranda.isChecked()) {
                    anyOptionChecked = true;
                    csvVaranda.setChecked(true);
                    answerRequests.append(csvVaranda.getText());
                    answerRequests.append(";");
                    break;
                } else {
                    csvVaranda.setChecked(false);
                    break;
                }
            case R.id.csvCozinha:
                if (!csvCozinha.isChecked()) {
                    anyOptionChecked = true;
                    csvCozinha.setChecked(true);
                    answerRequests.append(csvCozinha.getText());
                    answerRequests.append(";");
                    break;
                } else {
                    csvCozinha.setChecked(false);
                }
        }
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            setAnswer();
            ((AboutYouActivity) requireActivity()).addFragment(UnityActivitiesByRoom.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
        }
    }

    private void setAnswer() {
        ResearchFlow.addAnswer(new AnswerRequest(unityAnswer.getQuestion(),
                unityAnswer.getQuestionPartId(), answerRequests.toString()), this);
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
