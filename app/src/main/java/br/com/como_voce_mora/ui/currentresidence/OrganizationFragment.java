package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.widget.CompoundButton;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class OrganizationFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.rbYes)
    CustomRadioButton mRbFemale;
    @BindView(R.id.rbNo)
    CustomRadioButton mRbMale;
    @BindView(R.id.rbOther)
    CustomRadioButton mRbOther;

    public static OrganizationFragment newInstance() {

        Bundle args = new Bundle();

        OrganizationFragment fragment = new OrganizationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_organization;
    }

    @Override
    public void init() {
        super.init();
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ATUAL_RESIDENCE);
        mRbFemale.setOnCheckedChangeListener(this);
        mRbMale.setOnCheckedChangeListener(this);
        mRbOther.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbFemale:
                    mRbFemale.setChecked(true);
                    mRbMale.setChecked(false);
                    mRbOther.setChecked(false);

                    updateRbs();
                    break;
                case R.id.rbMale:
                    mRbFemale.setChecked(false);
                    mRbMale.setChecked(true);
                    mRbOther.setChecked(false);

                    updateRbs();
                    break;
                case R.id.rbOther:
                    mRbFemale.setChecked(false);
                    mRbMale.setChecked(false);
                    mRbOther.setChecked(true);

                    updateRbs();
                    break;
            }
        }
    }

    private void updateRbs() {
        mRbFemale.updateView();
        mRbMale.updateView();
        mRbOther.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(CityIntegrationFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
