package br.com.como_voce_mora.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

import br.com.como_voce_mora.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomPodium extends RelativeLayout {

    @BindView(R.id.leftContainer)
    LinearLayout leftContainer;
    @BindView(R.id.rightContainer)
    LinearLayout rightContainer;
    @BindView(R.id.btFirstPlace)
    Button btFirstPlace;
    @BindView(R.id.btSecondPlace)
    Button btSecondPlace;
    @BindView(R.id.btThirdPlace)
    Button btThirdPlace;
    @BindView(R.id.btFourthPlace)
    Button btFourthPlace;
    @BindView(R.id.btFirstOption)
    Button btFirstOption;
    @BindView(R.id.btSecondOption)
    Button btSecondOption;
    @BindView(R.id.btThirdOption)
    Button btThirdOption;
    @BindView(R.id.btForthOption)
    Button btForthOption;
    @BindView(R.id.btFifthOption)
    Button btFifthOption;
    @BindView(R.id.btSixOption)
    Button btSixOption;
    @BindView(R.id.btSevenOption)
    Button btSevenOption;
    @BindView(R.id.btEightOption)
    Button btEightOption;
    @BindView(R.id.btNineOption)
    Button btNineOption;
    @BindView(R.id.btTenOption)
    Button btTenOption;

    String firstPos, secPos, thridPos, fourthPos;
    List<String> options;


    public CustomPodium(Context context) {
        super(context);
        init(context);
    }

    public CustomPodium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomPodium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View v = inflate(context, R.layout.custom_podium, this);
        ButterKnife.bind(this, v);
    }

    private void setOptions(List<String> options) {
        initClick();
        this.options = options;
        if (this.options.size() > 8) {
            btFirstOption.setText(options.get(0));
            btSecondOption.setText(options.get(1));
            btThirdOption.setText(options.get(2));
            btForthOption.setText(options.get(3));
            btFifthOption.setText(options.get(4));
            btSixOption.setText(options.get(5));
            btSevenOption.setText(options.get(6));
            btEightOption.setText(options.get(7));
            btNineOption.setText(options.get(8));
            btTenOption.setText(options.get(9));
        } else {
            btFirstOption.setText(options.get(0));
            btSecondOption.setText(options.get(1));
            btThirdOption.setText(options.get(2));
            btForthOption.setText(options.get(3));
            btFifthOption.setText(options.get(4));
            btSixOption.setText(options.get(5));
            btSevenOption.setText(options.get(6));
            btEightOption.setText(options.get(7));
            btNineOption.setVisibility(View.INVISIBLE);
            btTenOption.setVisibility(View.INVISIBLE);
        }
    }

    private void initClick() {

    }

}
