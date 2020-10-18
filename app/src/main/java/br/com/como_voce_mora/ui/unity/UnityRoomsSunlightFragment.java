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


    List<AnswerRequest> answerRequests = new ArrayList<>();
    UnityAnswer unityAnswer = UnityAnswer.BETTER_SUN;

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
                    csvServico.setChecked(true);
                    answerRequests.add(new AnswerRequest(unityAnswer.getQuestion(),
                            unityAnswer.getQuestionPartId(), csvServico.getText()));
                    break;
                } else {
                    csvServico.setChecked(false);
                    removeItem(csvServico.getText());
                    break;
                }
            case R.id.csvBanheiro:
                if (!csvBanheiro.isChecked()) {
                    csvBanheiro.setChecked(true);
                    answerRequests.add(new AnswerRequest(unityAnswer.getQuestion(),
                            unityAnswer.getQuestionPartId(), csvBanheiro.getText()));
                    break;
                } else {
                    csvBanheiro.setChecked(false);
                    removeItem(csvBanheiro.getText());
                    break;
                }
            case R.id.csvCasal:
                if (!csvCasal.isChecked()) {
                    csvCasal.setChecked(true);
                    answerRequests.add(new AnswerRequest(unityAnswer.getQuestion(),
                            unityAnswer.getQuestionPartId(), csvCasal.getText()));
                    break;
                } else {
                    csvCasal.setChecked(false);
                    removeItem(csvCasal.getText());
                    break;
                }
            case R.id.csvSolteiro:
                if (!csvSolteiro.isChecked()) {
                    csvSolteiro.setChecked(true);
                    answerRequests.add(new AnswerRequest(unityAnswer.getQuestion(),
                            unityAnswer.getQuestionPartId(), csvSolteiro.getText()));
                    break;
                } else {
                    csvSolteiro.setChecked(false);
                    removeItem(csvSolteiro.getText());
                    break;
                }

            case R.id.csvSala:
                if (!csvSala.isChecked()) {
                    csvSala.setChecked(true);
                    answerRequests.add(new AnswerRequest(unityAnswer.getQuestion(),
                            unityAnswer.getQuestionPartId(), csvSala.getText()));
                    break;
                } else {
                    csvSala.setChecked(false);
                    removeItem(csvSala.getText());
                    break;
                }

            case R.id.csvCopa:
                if (!csvCopa.isChecked()) {
                    csvCopa.setChecked(true);
                    answerRequests.add(new AnswerRequest(unityAnswer.getQuestion(),
                            unityAnswer.getQuestionPartId(), csvCopa.getText()));
                    break;
                } else {
                    csvCopa.setChecked(false);
                    removeItem(csvCopa.getText());
                    break;
                }

            case R.id.csvVaranda:
                if (!csvVaranda.isChecked()) {
                    csvVaranda.setChecked(true);
                    answerRequests.add(new AnswerRequest(unityAnswer.getQuestion(),
                            unityAnswer.getQuestionPartId(), csvVaranda.getText()));
                    break;
                } else {
                    csvVaranda.setChecked(false);
                    removeItem(csvVaranda.getText());
                    break;
                }
            case R.id.csvCozinha:
                if (!csvCozinha.isChecked()) {
                    csvCozinha.setChecked(true);
                    answerRequests.add(new AnswerRequest(unityAnswer.getQuestion(),
                            unityAnswer.getQuestionPartId(), csvCozinha.getText()));
                    break;
                } else {
                    csvCozinha.setChecked(false);
                    removeItem(csvCozinha.getText());
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
        ((AboutYouActivity) requireActivity()).addFragment(UnityActivitiesByRoom.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
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

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }

}
