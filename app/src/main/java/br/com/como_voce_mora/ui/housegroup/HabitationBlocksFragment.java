package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.widget.Volume;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationBlocksFragment extends BaseFragment implements Volume.OnListener {

    @BindView(R.id.volume)
    Volume mVolume;
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.iv_blocks)
    ImageView mIvBlocks;

    private List<Integer> blocks = new ArrayList<>();

    public static HabitationBlocksFragment newInstance() {
        return new HabitationBlocksFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_blocks;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null)
            ((AboutYouActivity) getActivity()).addFragment(HabitationEquipamentsFragment.newInstance());
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);

        blocks.add(R.drawable.blocos_12);
        blocks.add(R.drawable.blocos_11);
        blocks.add(R.drawable.blocos_10);
        blocks.add(R.drawable.blocos_9);
        blocks.add(R.drawable.blocos_8);
        blocks.add(R.drawable.blocos_7);
        blocks.add(R.drawable.blocos_6);
        blocks.add(R.drawable.blocos_5);
        blocks.add(R.drawable.blocos_4);
        blocks.add(R.drawable.blocos_3);
        blocks.add(R.drawable.blocos_2);
        blocks.add(R.drawable.blocos_1);

        mVolume.setListener(this);
        mVolume.setMax(blocks.size() - 1);
    }

    @Override
    public void positionVolume(int position) {
        mIvBlocks.setImageResource(blocks.get(position));
    }
}
