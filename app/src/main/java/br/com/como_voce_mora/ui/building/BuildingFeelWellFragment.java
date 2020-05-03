package br.com.como_voce_mora.ui.building;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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

public class BuildingFeelWellFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_school)
    ImageView mIvAge;
    @BindView(R.id.tv_school)
    TextView mTvSchool;

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;

    private List<Integer> images;
    private List<String> texts;

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
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        images = new ArrayList<>();
        texts = new ArrayList<>();
        images.add(R.drawable.ic_droiosdodroios);
        texts.add("Muito Mal");
        images.add(R.drawable.ic_droios);
        texts.add("Mal");
        images.add(R.drawable.ic_mec);
        texts.add("Ok");
        images.add(R.drawable.ic_suave);
        texts.add("Bem");
        images.add(R.drawable.ic_supersuave);
        texts.add("Muito Bem");


        Collections.reverse(images);
        Collections.reverse(texts);
        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(images.get(position));
        mTvSchool.setText(texts.get(position));

    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(BuildingPublicAreaFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
