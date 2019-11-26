package br.com.como_voce_mora.ui.atualresidence;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeVertical;
import butterknife.BindView;
import butterknife.OnClick;

public class CountryFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;

    @BindView(R.id.progressBar)
    HowYouLiveProgressBar progressBar;

    private List<Integer> images;

    public static CountryFragment newInstance() {

        Bundle args = new Bundle();

        CountryFragment fragment = new CountryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_country;
    }

    @Override
    public void init() {
        super.init();
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ATUAL_RESIDENCE);
        images = new ArrayList<>();
        images.add(R.drawable.estado_acre);
        images.add(R.drawable.estado_alagoas);
        images.add(R.drawable.estado_amapa);
        images.add(R.drawable.estado_amazonas);
        images.add(R.drawable.estado_bahia);
        images.add(R.drawable.estado_ceara);
        images.add(R.drawable.estado_distrito_federal);
        images.add(R.drawable.estado_espirito_santo);
        images.add(R.drawable.estado_goias);
        images.add(R.drawable.estado_maranhao);
        images.add(R.drawable.estado_mato_grosso);
        images.add(R.drawable.estado_mato_grosso_do_sul);
        images.add(R.drawable.estado_para);
        images.add(R.drawable.estado_paraiba);
        images.add(R.drawable.estado_parana);
        images.add(R.drawable.estado_pernambuco);
        images.add(R.drawable.estado_piaui);
        images.add(R.drawable.estado_rio_de_janeiro);
        images.add(R.drawable.estado_rio_grande_do_norte);
        images.add(R.drawable.estado_rio_grande_do_sul);
        images.add(R.drawable.estado_rondonia);
        images.add(R.drawable.estado_roraima);
        images.add(R.drawable.estado_sao_paulo);
        images.add(R.drawable.estado_santa_catarina);
        images.add(R.drawable.estado_sergipe);
        images.add(R.drawable.estado_tocantins);

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
            ((AboutYouActivity) getActivity()).addFragment(WhatsYourAddressFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
