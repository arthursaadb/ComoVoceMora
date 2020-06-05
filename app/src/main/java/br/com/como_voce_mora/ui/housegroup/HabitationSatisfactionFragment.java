package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.HouseGroupAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingWhichDivisionFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationSatisfactionFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    HouseGroupAnswer houseGroupAnswer = HouseGroupAnswer.EQUIPMENTS_TO_ADD;

    public static HabitationSatisfactionFragment newInstance() {

        Bundle args = new Bundle();

        HabitationSatisfactionFragment fragment = new HabitationSatisfactionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_satisfaction;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
        tvQuestion.setText(houseGroupAnswer.getQuestion());
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(HabitationEquipmentsMeaningFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
