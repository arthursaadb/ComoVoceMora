package br.com.como_voce_mora.ui.aboutyou;

import android.view.View;
import android.widget.RadioGroup;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class WorkForYouFragment extends BaseFragment {
    @BindView(R.id.rg_yes_or_no)
    RadioGroup mRgYesOrNo;
    @BindView(R.id.rg_other)
    RadioGroup mRgOther;

    public static WorkForYouFragment newInstance() {
        return new WorkForYouFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_work_for_you;
    }

    @Override
    public void init() {
        super.init();

        mRgYesOrNo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.btYes) {
                    mRgOther.setVisibility(View.VISIBLE);
                } else {
                    mRgOther.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(FamilyIncomeFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
