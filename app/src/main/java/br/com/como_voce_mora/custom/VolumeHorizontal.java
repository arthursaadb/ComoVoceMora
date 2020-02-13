package br.com.como_voce_mora.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class VolumeHorizontal extends RelativeLayout implements View.OnTouchListener {
    @BindView(R.id.rl_root_view)
    RelativeLayout mRlRootView;
    @BindView(R.id.tv_min)
    TextView mTvMin;
    @BindView(R.id.tv_max)
    TextView mTvMax;
    @BindView(R.id.view_circle)
    View mViewCircle;
    @BindView(R.id.view_line_fake)
    View mViewLineFake;
    @BindView(R.id.view_line)
    View mViewLine;
    @BindView(R.id.rl_volume)
    RelativeLayout rlVolume;
    @BindView(R.id.tv_info)
    TextView tvInfo;

    private float mMinRange;
    private float mMaxRange;
    private float mWidthRange;
    private int mMax;

    private OnListener mListener;

    public VolumeHorizontal(Context context) {
        super(context);

        init(context, null);
    }

    public VolumeHorizontal(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.layout_volume_horizontal, this);
        ButterKnife.bind(view, this);

        mViewLineFake.setOnTouchListener(this);
        mViewCircle.setX(mViewLineFake.getX());

        mViewLineFake.post(() -> {
            mMinRange = mViewLineFake.getX();
            mMaxRange = mViewLineFake.getWidth() + mViewLineFake.getX() - mViewCircle.getWidth();
            mWidthRange = mMaxRange - mMinRange;
        });

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomVolume, 0, 0);
        int background = typedArray.getColor(R.styleable.CustomVolume_backgroundVolume, getResources().getColor(R.color.colorBege));
        int lineColor = typedArray.getColor(R.styleable.CustomVolume_lineColorVolume, getResources().getColor(R.color.colorBlack));
        int textColor = typedArray.getColor(R.styleable.CustomVolume_textColorVolume, getResources().getColor(R.color.colorBlack));
        int resCircleSelected = typedArray.getResourceId(R.styleable.CustomVolume_circleSelectedVolume, R.drawable.bg_circle_volume);
        String textMin = getResources().getString(typedArray.getResourceId(R.styleable.CustomVolume_textMin, R.string.a));
        String textMax = getResources().getString(typedArray.getResourceId(R.styleable.CustomVolume_textMax, R.string.z));

//        mRlRootView.setBackgroundColor(background);
        rlVolume.setBackgroundColor(background);
        mViewLine.setBackgroundColor(lineColor);
        mTvMin.setTextColor(textColor);
        mTvMax.setTextColor(textColor);
        mViewCircle.setBackgroundResource(resCircleSelected);

        mTvMin.setText(textMin);
        mTvMax.setText(textMax);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() + mViewLineFake.getX());

        if (x < mMinRange) {
            x = (int) mMinRange;
        }

        if (x > mMaxRange) {
            x = (int) mMaxRange;
        }

        if (x >= mMinRange && x <= mMaxRange) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_MOVE:
                    mViewCircle.setX(x);
                    updatePosition(x);
                    break;
            }
        }

        return true;
    }

    private void updatePosition(int x) {
        x = (int) (x - mMinRange);
        int position = Math.round((x / mWidthRange) * mMax);

        if (mListener != null) {
            mListener.positionVolume(position);
        }
    }

    public void setMax(int max) {
        mMax = max;
    }

    public void setListener(OnListener listener) {
        mListener = listener;
    }

    public void setInfo(String text) {
        tvInfo.setVisibility(VISIBLE);
        tvInfo.setText(text);
    }

    public interface OnListener {
        void positionVolume(int position);
    }
}