package br.com.como_voce_mora.ui.unity;

import android.view.View;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityResidentsFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvPartner)
    CustomSelectedView csvPartner;
    @BindView(R.id.csvGrandFather)
    CustomSelectedView csvGrandFather;
    @BindView(R.id.csvSon)
    CustomSelectedView csvSon;
    @BindView(R.id.csvSister)
    CustomSelectedView csvSister;
    @BindView(R.id.csvFather)
    CustomSelectedView csvFahter;
    @BindView(R.id.csvOther)
    CustomSelectedView csvOther;


    public static UnityResidentsFragment newInstance() {
        return new UnityResidentsFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_residents;
    }

    @Override
    public void init() {

    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null)
            ((AboutYouActivity) getActivity()).addFragment(UnityUsedSpaceFragment.newInstance());
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick({R.id.csvPartner, R.id.csvGrandFather, R.id.csvSon, R.id.csvSister,
        R.id.csvFather, R.id.csvOther})
    public void onClickViews(View view) {
        switch (view.getId()) {
            case R.id.csvPartner:
                csvPartner.setChecked(true);
                csvGrandFather.setChecked(false);
                csvSon.setChecked(false);
                csvSister.setChecked(false);
                csvFahter.setChecked(false);
                csvOther.setChecked(false);
                break;
            case R.id.csvGrandFather:
                csvPartner.setChecked(false);
                csvGrandFather.setChecked(true);
                csvSon.setChecked(false);
                csvSister.setChecked(false);
                csvFahter.setChecked(false);
                csvOther.setChecked(false);
                break;
            case R.id.csvSon:
                csvPartner.setChecked(false);
                csvGrandFather.setChecked(false);
                csvSon.setChecked(true);
                csvSister.setChecked(false);
                csvFahter.setChecked(false);
                csvOther.setChecked(false);
                break;
            case R.id.csvSister:
                csvPartner.setChecked(false);
                csvGrandFather.setChecked(false);
                csvSon.setChecked(false);
                csvSister.setChecked(true);
                csvFahter.setChecked(false);
                csvOther.setChecked(false);
                break;
            case R.id.csvFather:
                csvPartner.setChecked(false);
                csvGrandFather.setChecked(false);
                csvSon.setChecked(false);
                csvSister.setChecked(false);
                csvFahter.setChecked(true);
                csvOther.setChecked(false);
                break;
            case R.id.csvOther:
                csvPartner.setChecked(false);
                csvGrandFather.setChecked(false);
                csvSon.setChecked(false);
                csvSister.setChecked(false);
                csvFahter.setChecked(false);
                csvOther.setChecked(true);
                break;
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}
