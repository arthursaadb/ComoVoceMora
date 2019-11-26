package br.com.como_voce_mora.ui.previoushouse;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.atualresidence.CurrentHomeFragment;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousHouseTimeFragment extends BaseFragment {
    @BindView(R.id.progressBar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.view_1)
    CustomSelectedView mView1;
    @BindView(R.id.view_2)
    CustomSelectedView mView2;
    @BindView(R.id.view_3)
    CustomSelectedView mView3;
    @BindView(R.id.view_4)
    CustomSelectedView mView4;
    @BindView(R.id.view_5)
    CustomSelectedView mView5;

    public static PreviousHouseTimeFragment newInstance() {
        return new PreviousHouseTimeFragment();
    }


    @OnClick({R.id.view_1, R.id.view_2, R.id.view_3, R.id.view_4, R.id.view_5})
    public void onClickViews(View view) {
        switch (view.getId()) {
            case R.id.view_1:
                mView1.setChecked(true);
                mView2.setChecked(false);
                mView3.setChecked(false);
                mView4.setChecked(false);
                mView5.setChecked(false);
                break;
            case R.id.view_2:
                mView1.setChecked(false);
                mView2.setChecked(true);
                mView3.setChecked(false);
                mView4.setChecked(false);
                mView5.setChecked(false);
                break;
            case R.id.view_3:
                mView1.setChecked(false);
                mView2.setChecked(false);
                mView3.setChecked(true);
                mView4.setChecked(false);
                mView5.setChecked(false);
                break;
            case R.id.view_4:
                mView1.setChecked(false);
                mView2.setChecked(false);
                mView3.setChecked(false);
                mView4.setChecked(true);
                mView5.setChecked(false);
                break;
            case R.id.view_5:
                mView1.setChecked(false);
                mView2.setChecked(false);
                mView3.setChecked(false);
                mView4.setChecked(false);
                mView5.setChecked(true);
                break;
        }
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_previous_house_time;
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
    }
}
