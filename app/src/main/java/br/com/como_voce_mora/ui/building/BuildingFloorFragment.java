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
import br.com.como_voce_mora.ui.atualresidence.WhatsYourAddressFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingFloorFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;

    @BindView(R.id.progressBar)
    HowYouLiveProgressBar progressBar;

    private List<Integer> images;

    public static BuildingFloorFragment newInstance() {

        Bundle args = new Bundle();

        BuildingFloorFragment fragment = new BuildingFloorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_floor_building;
    }

    @Override
    public void init() {
        super.init();
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        images = new ArrayList<>();
        images.add(R.drawable.andar_qtd_2);
        images.add(R.drawable.andar_qtd_3);
        images.add(R.drawable.andar_qtd_4);
        images.add(R.drawable.andar_qtd_5);
        images.add(R.drawable.andar_qtd_6);
        images.add(R.drawable.andar_qtd_7);
        images.add(R.drawable.andar_qtd_8);
        images.add(R.drawable.andar_qtd_9);
        images.add(R.drawable.andar_qtd_10);
        images.add(R.drawable.andar_qtd_11);
        images.add(R.drawable.andar_qtd_12);
        images.add(R.drawable.andar_qtd_13);
        images.add(R.drawable.andar_qtd_14);
        images.add(R.drawable.andar_qtd_15);
        images.add(R.drawable.andar_qtd_16);
        images.add(R.drawable.andar_qtd_17);
        images.add(R.drawable.andar_qtd_18);
        images.add(R.drawable.andar_qtd_19);
        images.add(R.drawable.andar_qtd_20);

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
            ((AboutYouActivity) getActivity()).addFragment(BuildingApartamentPerFloorFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
