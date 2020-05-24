package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CepResponse;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.Utils;
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
    @BindView(R.id.etSince)
    EditText etSince;
    @BindView(R.id.etAp)
    EditText etAp;


    CepPresenter mPresenter;
    CurrentResidenceAnswer cityAnswer = CurrentResidenceAnswer.CITY;
    CurrentResidenceAnswer neighborhood = CurrentResidenceAnswer.NEIGHBORHOOD;
    CurrentResidenceAnswer cep = CurrentResidenceAnswer.CEP;
    CurrentResidenceAnswer address = CurrentResidenceAnswer.HOUSE_NUMEBR;
    CurrentResidenceAnswer apartament = CurrentResidenceAnswer.APARTAMENT_NUMBBER;
    CurrentResidenceAnswer timeLiving = CurrentResidenceAnswer.TIME_LIVING;
    List<AnswerRequest> answerRequests = new ArrayList<>();


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
                    Utils.hideKeyboard(getActivity());
                }
            }
        });
    }


    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        setAnswer();
    }

    private void setAnswer() {
        if (validate()) {
            answerRequests.add(new AnswerRequest(cityAnswer.getQuestion(),
                    cityAnswer.getQuestionPartId(), etCity.getText().toString()));
            answerRequests.add(new AnswerRequest(neighborhood.getQuestion(),
                    neighborhood.getQuestionPartId(), etBairro.getText().toString()));
            answerRequests.add(new AnswerRequest(cep.getQuestion(),
                    cep.getQuestionPartId(), etCep.getText().toString()));
            answerRequests.add(new AnswerRequest(address.getQuestion(),
                    address.getQuestionPartId(), etAdress.getText().toString()));
            answerRequests.add(new AnswerRequest(timeLiving.getQuestion(),
                    timeLiving.getQuestionPartId(), etSince.getText().toString()));
            if (!etSince.getText().toString().equals("")) {
                answerRequests.add(new AnswerRequest(apartament.getQuestion(),
                        apartament.getQuestionPartId(), etAp.getText().toString()));
            }
            for (AnswerRequest r : answerRequests) {
                ResearchFlow.addAnswer(r.getDwellerId(), r);
            }
            ((AboutYouActivity) getActivity()).addFragment(EquipamentsFragment.newInstance());
        } else {
            Toast.makeText(getContext(), "Você precisa preencher os campos, para continuar!", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validate() {

        if (etAdress.getText().toString().equals("")) {
            Toast.makeText(getContext(), "Adicione um endereço.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (etBairro.getText().toString().equals("")) {
            Toast.makeText(getContext(), "Adicione um bairro.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (etCep.getText().toString().equals("")) {
            Toast.makeText(getContext(), "Adicione um cep.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (etCity.getText().toString().equals("")) {
            Toast.makeText(getContext(), "Adicione uma cidade.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (etSince.getText().toString().equals("")) {
            Toast.makeText(getContext(), "Adicione desde quando você mora nessa residencia.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
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
