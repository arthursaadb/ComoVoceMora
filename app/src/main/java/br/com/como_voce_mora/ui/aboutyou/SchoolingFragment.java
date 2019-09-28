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

public class SchoolingFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;

    private List<Integer> images;

    public static SchoolingFragment newInstance() {
        return new SchoolingFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_schooling;
    }

    @Override
    public void init() {
        super.init();

        images = new ArrayList<>();
        images.add(R.drawable.ic_escola_nunca_fui);
        images.add(R.drawable.ic_escola_fundamental_incompleto_1);
        images.add(R.drawable.ic_escola_fundamental_completo_1);
        images.add(R.drawable.ic_escola_fundamental_incompleto_2);
        images.add(R.drawable.ic_escola_fundamental_completo_2);
        images.add(R.drawable.ic_escola_fundamental_incompleto_3);
        images.add(R.drawable.ic_escola_fundamental_completo_3);
        images.add(R.drawable.ic_escola_fundamental_incompleto_4);
        images.add(R.drawable.ic_escola_fundamental_completo_4);
        images.add(R.drawable.ic_escola_fundamental_incompleto_5);
        images.add(R.drawable.ic_escola_fundamental_completo_5);
        images.add(R.drawable.ic_escola_fundamental_incompleto_6);
        images.add(R.drawable.ic_escola_fundamental_completo_6);
        images.add(R.drawable.ic_escola_fundamental_incompleto_7);
        images.add(R.drawable.ic_escola_fundamental_completo_7);
        images.add(R.drawable.ic_escola_fundamental_incompleto_8);
        images.add(R.drawable.ic_escola_fundamental_completo_8);
        images.add(R.drawable.ic_escola_fundamental_incompleto_9);
        images.add(R.drawable.ic_escola_fundamental_completo_9);
        images.add(R.drawable.ic_escola_medio_incompleto_1);
        images.add(R.drawable.ic_escola_media_completo_1);
        images.add(R.drawable.ic_escola_medio_incompleto_2);
        images.add(R.drawable.ic_escola_media_completo_2);
        images.add(R.drawable.ic_escola_medio_incompleto_3);
        images.add(R.drawable.ic_escola_media_completo_3);
        images.add(R.drawable.ic_escola_superior_incompleto);
        images.add(R.drawable.ic_escola_superior_completo);
        Collections.reverse(images);


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
            ((AboutYouActivity) getActivity()).addFragment(WithWhomYouLiveFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
