package br.com.como_voce_mora.ui.aboutyou;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.custom.VolumeVertical;
import butterknife.BindView;
import butterknife.OnClick;

public class HowOldAreYouFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;
    @BindView(R.id.tv_age)
    TextView mTvAge;

    private List<Integer> agesImage;
    private List<String> agesText;

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

        agesImage = new ArrayList<>();
        agesImage.add(R.drawable.ic_mr_clipboard_up_70);
        agesImage.add(R.drawable.ic_mr_clipboard_61a70);
        agesImage.add(R.drawable.ic_mr_clipboard_51a60);
        agesImage.add(R.drawable.ic_mr_clipboard_41a50);
        agesImage.add(R.drawable.ic_mr_clipboard_31a40);
        agesImage.add(R.drawable.ic_mr_clipboard_21a30);
        agesImage.add(R.drawable.ic_mr_clipboard_15a20);
        agesImage.add(R.drawable.ic_mr_clipboard_down_15);

        agesText = new ArrayList<>();
        agesText.add("Mais de 70");
        agesText.add("de 61 a 70");
        agesText.add("de 51 a 60");
        agesText.add("de 41 a 50");
        agesText.add("de 31 a 40");
        agesText.add("de 21 a 30");
        agesText.add("de 15 a 20");
        agesText.add("Menos de 15");

        mVolume.setListener(this);
        mVolume.setMax(agesImage.size() - 1);
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(agesImage.get(position));
        mTvAge.setText(agesText.get(position));
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(SchoolingFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
