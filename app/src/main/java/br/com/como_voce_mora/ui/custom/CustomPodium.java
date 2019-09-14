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

    boolean firstPos = false, secPos = false, thridPos = false, fourthPos = false;
    String step;
    Button optionClicked;
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

    public void setOptions(List<String> options) {
        initClick();
        initPodiumClick();
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
            btFirstOption.setVisibility(VISIBLE);
            btSecondOption.setVisibility(VISIBLE);
            btThirdOption.setVisibility(VISIBLE);
            btForthOption.setVisibility(VISIBLE);
            btFifthOption.setVisibility(VISIBLE);
            btSixOption.setVisibility(VISIBLE);
            btSevenOption.setVisibility(VISIBLE);
            btEightOption.setVisibility(VISIBLE);
            btNineOption.setVisibility(VISIBLE);
            btTenOption.setVisibility(VISIBLE);
        } else {
            btFirstOption.setText(options.get(0));
            btSecondOption.setText(options.get(1));
            btThirdOption.setText(options.get(2));
            btForthOption.setText(options.get(3));
            btFifthOption.setText(options.get(4));
            btSixOption.setText(options.get(5));
            btSevenOption.setText(options.get(6));
            btEightOption.setText(options.get(7));
            btFirstOption.setVisibility(VISIBLE);
            btSecondOption.setVisibility(VISIBLE);
            btThirdOption.setVisibility(VISIBLE);
            btForthOption.setVisibility(VISIBLE);
            btFifthOption.setVisibility(VISIBLE);
            btSixOption.setVisibility(VISIBLE);
            btSevenOption.setVisibility(VISIBLE);
            btEightOption.setVisibility(VISIBLE);
        }
    }

    private void initClick() {
        btFirstOption.setOnClickListener(view -> {
            step = btFirstOption.getText().toString();
            optionClicked = btFirstOption;
            btFirstOption.setVisibility(INVISIBLE);
        });
        btSecondOption.setOnClickListener(view -> {
            step = btSecondOption.getText().toString();
            optionClicked = btSecondOption;
            btSecondOption.setVisibility(INVISIBLE);
        });
        btThirdOption.setOnClickListener(view -> {
            step = btThirdOption.getText().toString();
            optionClicked = btThirdOption;
            btThirdOption.setVisibility(INVISIBLE);
        });
        btForthOption.setOnClickListener(view -> {
            step = btForthOption.getText().toString();
            optionClicked = btForthOption;
            btForthOption.setVisibility(INVISIBLE);
        });
        btFifthOption.setOnClickListener(view -> {
            step = btFifthOption.getText().toString();
            optionClicked = btFifthOption;
            btFifthOption.setVisibility(INVISIBLE);
        });
        btSixOption.setOnClickListener(view -> {
            step = btSixOption.getText().toString();
            optionClicked = btSixOption;
            btSixOption.setVisibility(INVISIBLE);
        });
        btSevenOption.setOnClickListener(view -> {
            step = btSevenOption.getText().toString();
            optionClicked = btSevenOption;
            btSevenOption.setVisibility(INVISIBLE);
        });

        btEightOption.setOnClickListener(view -> {
            step = btEightOption.getText().toString();
            optionClicked = btEightOption;
            btEightOption.setVisibility(INVISIBLE);
        });
        btNineOption.setOnClickListener(view -> {
            step = btNineOption.getText().toString();
            optionClicked = btNineOption;
            btNineOption.setVisibility(INVISIBLE);
        });
        btTenOption.setOnClickListener(view -> {
            step = btTenOption.getText().toString();
            optionClicked = btTenOption;
            btTenOption.setVisibility(INVISIBLE);
        });
    }

    private void initPodiumClick() {
        btFirstPlace.setOnClickListener(view -> {
            if (!firstPos) {
                btFirstPlace.setText(step);
                btFirstPlace.setVisibility(VISIBLE);
                step = "";
                firstPos = true;
            } else {
                optionClicked.setVisibility(VISIBLE);
                firstPos = false;
                btFirstPlace.setText("");
            }

        });
        btSecondPlace.setOnClickListener(view -> {
            if (!secPos) {
                btSecondPlace.setText(step);
                btSecondPlace.setVisibility(VISIBLE);
                step = "";
                secPos = true;
            } else {
                optionClicked.setVisibility(VISIBLE);
                secPos = false;
                btSecondPlace.setText("");
            }
        });
        btThirdPlace.setOnClickListener(view -> {
            if (!thridPos) {
                btThirdPlace.setText(step);
                btThirdPlace.setVisibility(VISIBLE);
                step = "";
                thridPos = true;
            } else {
                optionClicked.setVisibility(VISIBLE);
                thridPos = false;
                btThirdPlace.setText("");
            }
        });
        btFourthPlace.setOnClickListener(view -> {
            if (!fourthPos) {
                btFourthPlace.setText(step);
                btFourthPlace.setVisibility(VISIBLE);
                step = "";
            } else {
                optionClicked.setVisibility(VISIBLE);
                fourthPos = false;
                btFourthPlace.setText("");
            }
        });
    }

}
