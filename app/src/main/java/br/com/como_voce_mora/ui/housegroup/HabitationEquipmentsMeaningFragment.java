package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomPodium;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingFloorFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class HabitationEquipmentsMeaningFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.cpPodium)
    CustomPodium customPodium;
    @BindViews({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption})
    List<Button> mButtons;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    public static HabitationEquipmentsMeaningFragment newInstance() {

        Bundle args = new Bundle();

        HabitationEquipmentsMeaningFragment fragment = new HabitationEquipmentsMeaningFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_equipments_meaning;
    }

    @Override
    public void init() {
        tvQuestion.setText("Para você, o que significa a presença de equipamentos de uso comum em um edifcio?");
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        customPodium.setOnPodiumListener(xqdl -> {
            for (Button b : mButtons) {
                if (b.getText().equals(xqdl)) {
                    b.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(HabitationGreenAreaFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption, R.id.btEightOption})
    public void onClickOptions(View view) {
        Button textView = (Button) view;
        customPodium.putOnPodium(textView.getText().toString());
        textView.setVisibility(View.INVISIBLE);
    }

}