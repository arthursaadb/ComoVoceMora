package br.com.como_voce_mora.ui.aboutyou;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.widget.Volume;
import butterknife.BindView;
import butterknife.OnClick;

public class HowOldAreYouFragment extends BaseFragment implements Volume.OnListener {
    @BindView(R.id.volume)
    Volume mVolume;
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

        mVolume.setListener(this);
        mVolume.setMax(ages.size() - 1);
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(ages.get(position));
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
