package br.com.como_voce_mora.ui.aboutyou;

import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AboutYouAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class WithWhomYouLiveFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private AboutYouAnswer aboutYouAnswer = AboutYouAnswer.NUMBER_OF_PERSON;


    public static WithWhomYouLiveFragment newInstance() {
        return new WithWhomYouLiveFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_withwhomyoulive;
    }

    @Override
    public void init() {
        tvQuestion.setText(aboutYouAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ABOUT_YOU);
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
