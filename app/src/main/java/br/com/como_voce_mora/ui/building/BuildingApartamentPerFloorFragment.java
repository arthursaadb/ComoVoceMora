package br.com.como_voce_mora.ui.building;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeVertical;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingApartamentPerFloorFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;

    @BindView(R.id.progressBar)
    HowYouLiveProgressBar progressBar;

    private List<Integer> images;

    public static BuildingApartamentPerFloorFragment newInstance() {

        Bundle args = new Bundle();

        BuildingApartamentPerFloorFragment fragment = new BuildingApartamentPerFloorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_apartament_floor_building;
    }

    @Override
    public void init() {
        super.init();
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        images = new ArrayList<>();
        images.add(R.drawable.ic_apto_por_andar_1);
        images.add(R.drawable.ic_apto_por_andar_2);
        images.add(R.drawable.ic_apto_por_andar_3);
        images.add(R.drawable.ic_apto_por_andar_4);
        images.add(R.drawable.ic_apto_por_andar_5);
        images.add(R.drawable.ic_apto_por_andar_6);
        images.add(R.drawable.ic_apto_por_andar_7);
        images.add(R.drawable.ic_apto_por_andar_8);
        images.add(R.drawable.ic_apto_por_andar_9);
        images.add(R.drawable.ic_apto_por_andar_10);

        Collections.reverse(images);
        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(images.get(position));
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(BuildingAspectesFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
