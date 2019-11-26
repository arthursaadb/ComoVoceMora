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
import br.com.como_voce_mora.ui.atualresidence.PublicAreaFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingFeelWellFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;

    @BindView(R.id.progressBar)
    HowYouLiveProgressBar progressBar;

    private List<Integer> images;

    public static BuildingFeelWellFragment newInstance() {

        Bundle args = new Bundle();

        BuildingFeelWellFragment fragment = new BuildingFeelWellFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_feel_well;
    }

    @Override
    public void init() {
        super.init();
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        images = new ArrayList<>();
        images.add(R.drawable.ic_droiosdodroios);
        images.add(R.drawable.ic_droios);
        images.add(R.drawable.ic_mec);
        images.add(R.drawable.ic_suave);
        images.add(R.drawable.ic_supersuave);


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
            ((AboutYouActivity) getActivity()).addFragment(BuildingPublicAreaFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
