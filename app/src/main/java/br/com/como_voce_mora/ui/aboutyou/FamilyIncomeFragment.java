package br.com.como_voce_mora.ui.aboutyou;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.custom.VolumeVertical;
import butterknife.BindView;
import butterknife.OnClick;

public class FamilyIncomeFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;

    private List<Integer> images;

    public static FamilyIncomeFragment newInstance() {
        return new FamilyIncomeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_family_income;
    }

    @Override
    public void init() {
        super.init();

        images = new ArrayList<>();
        images.add(R.drawable.ic_1);
        images.add(R.drawable.ic_1_5);
        images.add(R.drawable.ic_2);
        images.add(R.drawable.ic_2_5);
        images.add(R.drawable.ic_3);
        images.add(R.drawable.ic_3_5);
        images.add(R.drawable.ic_4);
        images.add(R.drawable.ic_4_5);
        images.add(R.drawable.ic_5);
        images.add(R.drawable.ic_5_5);
        images.add(R.drawable.ic_6);
        images.add(R.drawable.ic_6_5);
        images.add(R.drawable.ic_7);
        images.add(R.drawable.ic_7_5);
        images.add(R.drawable.ic_8);
        images.add(R.drawable.ic_8_5);
        images.add(R.drawable.ic_9);
        images.add(R.drawable.ic_9_5);
        images.add(R.drawable.ic_10_ou_mais);
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
            ((AboutYouActivity) getActivity()).addFragment(YourProfessionFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
