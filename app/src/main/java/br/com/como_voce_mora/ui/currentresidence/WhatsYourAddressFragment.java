package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.CepResponse;
import br.com.como_voce_mora.presenter.cep.CepContract;
import br.com.como_voce_mora.presenter.cep.CepPresenter;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class WhatsYourAddressFragment extends BaseFragment implements CepContract.View {


    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.etCity)
    EditText etCity;
    @BindView(R.id.etAddress)
    EditText etAdress;
    @BindView(R.id.etBairro)
    EditText etBairro;
    @BindView(R.id.etCep)
    EditText etCep;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    CepPresenter mPresenter;


    public static WhatsYourAddressFragment newInstance() {

        Bundle args = new Bundle();

        WhatsYourAddressFragment fragment = new WhatsYourAddressFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_whatsyouraddress;
    }

    @Override
    public void init() {
        super.init();
        tvQuestion.setText("Seu endereço:");
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ACTUAL_RESIDENCE);
        mPresenter = new CepPresenter(this);
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ACTUAL_RESIDENCE);
        etCep.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 8) {
                    mPresenter.getCep(editable.toString());
                }
            }
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(NeighborHoodFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void showLaoding() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void presentData(CepResponse cepResponse) {
        etAdress.setText(cepResponse.getLogradouro());
        etBairro.setText(cepResponse.getBairro());
        etCity.setText(cepResponse.getLocalidade());
    }
}
