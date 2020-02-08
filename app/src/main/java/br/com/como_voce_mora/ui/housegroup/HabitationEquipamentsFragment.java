package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.RateBuildingFragment;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationEquipamentsFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvGamesRoom)
    CustomSelectedView csvGamesRoom;
    @BindView(R.id.csvGym)
    CustomSelectedView csvGymRoom;
    @BindView(R.id.csvPartyRoom)
    CustomSelectedView csvPartyRoom;
    @BindView(R.id.csvPoolPlusEighteen)
    CustomSelectedView csvPoolPlusEighteen;
    @BindView(R.id.csvGourmet)
    CustomSelectedView csvGourmet;
    @BindView(R.id.csvPlayGround)
    CustomSelectedView csvPlayGround;
    @BindView(R.id.csvSqaure)
    CustomSelectedView csvSquare;
    @BindView(R.id.csvChildPool)
    CustomSelectedView csvChildPool;


    public static HabitationEquipamentsFragment newInstance() {
        return new HabitationEquipamentsFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_equipaments;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        ((AboutYouActivity) getActivity()).addFragment(RateBuildingFragment.newInstance());
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }


    @OnClick({R.id.csvGamesRoom, R.id.csvGym, R.id.csvPartyRoom, R.id.csvPoolPlusEighteen, R.id.csvGourmet,
        R.id.csvPlayGround, R.id.csvSqaure, R.id.csvChildPool})
    public void onClickViews(View view) {
        switch (view.getId()) {
            case R.id.csvGamesRoom:
                csvGamesRoom.setChecked(true);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvGym:
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(true);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvPartyRoom:
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(true);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvPoolPlusEighteen:
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(true);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvGourmet:
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(true);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvPlayGround:
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(true);
                break;
            case R.id.csvSqaure:
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(true);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvChildPool:
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(true);
                csvPlayGround.setChecked(false);
                break;
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
    }
}
