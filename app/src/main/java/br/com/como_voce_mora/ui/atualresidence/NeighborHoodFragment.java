package br.com.como_voce_mora.ui.atualresidence;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.custom.VolumeVertical;
import butterknife.BindView;
import butterknife.OnClick;

public class NeighborHoodFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;

    private List<Integer> images;

    public static NeighborHoodFragment newInstance() {

        Bundle args = new Bundle();

        NeighborHoodFragment fragment = new NeighborHoodFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_neighborhood;
    }

    @Override
    public void init() {
        super.init();
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ATUAL_RESIDENCE);
        images = new ArrayList<>();
        images.add(R.drawable.ic_bom);
        images.add(R.drawable.ic_muito_bom);
        images.add(R.drawable.ic_regular);
        images.add(R.drawable.ic_ruim);
        images.add(R.drawable.ic_muito_bom);

        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(images.get(position));
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(EquipamentsFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
