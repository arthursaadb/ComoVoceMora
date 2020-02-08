package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeVertical;
import butterknife.BindView;
import butterknife.OnClick;

public class NeighborHoodFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;
    @BindView(R.id.tv_age)
    TextView mTvAge;

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;

    private List<Integer> images;
    private List<String> texts;

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
        texts = new ArrayList<>();
        images.add(R.drawable.ic_muito_bom);
        texts.add("Muito Bom");
        images.add(R.drawable.ic_bom);
        texts.add("Bom");
        images.add(R.drawable.ic_regular);
        texts.add("Regular");
        images.add(R.drawable.ic_ruim);
        texts.add("Ruim");
        images.add(R.drawable.ic_muito_ruim);
        texts.add("Muito Ruim");

        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(images.get(position));
        mTvAge.setText(texts.get(position));

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
