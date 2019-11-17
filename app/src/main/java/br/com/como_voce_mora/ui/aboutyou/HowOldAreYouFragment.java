package br.com.como_voce_mora.ui.aboutyou;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.custom.VolumeVertical;
import butterknife.BindView;
import butterknife.OnClick;

public class HowOldAreYouFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;

    private List<Integer> ages;

    public static HowOldAreYouFragment newInstance() {
        return new HowOldAreYouFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_how_old_are_you;
    }

    @Override
    public void init() {
        super.init();

        ages = new ArrayList<>();
        ages.add(R.drawable.ic_mr_clipboard_down_15);
        ages.add(R.drawable.ic_mr_clipboard_15a20);
        ages.add(R.drawable.ic_mr_clipboard_21a30);
        ages.add(R.drawable.ic_mr_clipboard_31a40);
        ages.add(R.drawable.ic_mr_clipboard_41a50);
        ages.add(R.drawable.ic_mr_clipboard_51a60);
        ages.add(R.drawable.ic_mr_clipboard_61a70);
        ages.add(R.drawable.ic_mr_clipboard_up_70);
        Collections.reverse(ages);

        mVolume.setListener(this);
        mVolume.setMax(ages.size() - 1);
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(ages.get(position));
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(SchoolingFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
