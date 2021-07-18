package br.com.como_voce_mora.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import br.com.como_voce_mora.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomPodium extends RelativeLayout {

    @BindView(R.id.btFirstPlace)
    Button btFirstPlace;
    @BindView(R.id.btSecondPlace)
    Button btSecondPlace;
    @BindView(R.id.btThirdPlace)
    Button btThirdPlace;
    @BindView(R.id.btFourthPlace)
    Button btFourthPlace;

    String[] podium = new String[4];
    OnPodiumListener onPodiumListener;
    Boolean[] availablePosition = new Boolean[4];

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
        initPodium();
        initPodiumClick();
    }

    private void initPodium() {
        podium[0] = "";
        podium[1] = "";
        podium[2] = "";
        podium[3] = "";

    }

    public void putOnPodium(String xqdl) {
        if (podium[0].equals("")) {
            putOnPosition(0, xqdl);
        } else if (podium[1].equals("")) {
            putOnPosition(1, xqdl);
        } else if (podium[2].equals("")) {
            putOnPosition(2, xqdl);
        } else if (podium[3].equals("")) {
            putOnPosition(3, xqdl);
        } else {
            String[] temp = new String[3];
            temp[0] = podium[0];
            temp[1] = podium[1];
            temp[2] = podium[2];

            putOnPosition(0, xqdl);
            putOnPosition(1, temp[0]);
            putOnPosition(2, temp[1]);
            putOnPosition(3, temp[2]);

        }
    }

    private void putOnPosition(int pos, String xqdl) {
        switch (pos) {
            case 0:
                podium[pos] = xqdl;
                btFirstPlace.setVisibility(VISIBLE);
                btFirstPlace.setText(xqdl);
                break;

            case 1:
                podium[pos] = xqdl;
                btSecondPlace.setVisibility(VISIBLE);
                btSecondPlace.setText(xqdl);
                break;

            case 2:
                podium[pos] = xqdl;
                btThirdPlace.setVisibility(VISIBLE);
                btThirdPlace.setText(xqdl);
                break;

            case 3:
                podium[pos] = xqdl;
                btFourthPlace.setVisibility(VISIBLE);
                btFourthPlace.setText(xqdl);
                break;
        }
    }

    private void initPodiumClick() {
        btFirstPlace.setOnClickListener(view -> {
            onPodiumListener.onPositionClicked(btFirstPlace.getText().toString());
            btFirstPlace.setText("");
            podium[0] = "";
            btFirstPlace.setVisibility(INVISIBLE);

        });
        btSecondPlace.setOnClickListener(view -> {
            onPodiumListener.onPositionClicked(btSecondPlace.getText().toString());
            btSecondPlace.setText("");
            podium[1] = "";
            btSecondPlace.setVisibility(INVISIBLE);
        });
        btThirdPlace.setOnClickListener(view -> {
            onPodiumListener.onPositionClicked(btThirdPlace.getText().toString());
            btThirdPlace.setText("");
            podium[2] = "";
            btThirdPlace.setVisibility(INVISIBLE);

        });
        btFourthPlace.setOnClickListener(view -> {
            onPodiumListener.onPositionClicked(btFourthPlace.getText().toString());
            btFourthPlace.setText("");
            podium[3] = "";
            btFourthPlace.setVisibility(INVISIBLE);
        });
    }

    public void setOnPodiumListener(OnPodiumListener onPodiumListener) {
        this.onPodiumListener = onPodiumListener;
    }

    public String[] getPodium() {
        return podium;
    }

    public interface OnPodiumListener {
        void onPositionClicked(String xqdl);
    }

}
