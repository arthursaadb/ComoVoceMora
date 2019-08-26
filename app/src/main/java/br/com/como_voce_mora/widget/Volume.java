package br.com.como_voce_mora.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Volume extends RelativeLayout implements View.OnTouchListener {
    @BindView(R.id.tv_min)
    TextView mTvMin;
    @BindView(R.id.tv_max)
    TextView mTvMax;
    @BindView(R.id.view_circle)
    View mViewCircle;
    @BindView(R.id.view_line_fake)
    View mViewLineFake;

    private float mMinRange;
    private float mMaxRange;
    private float mHeightRange;
    private int mMax;

    private OnListener mListener;

    public Volume(Context context) {
        super(context);

        init();
    }

    public Volume(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.layout_volume, this);
        ButterKnife.bind(view, this);

        mViewLineFake.setOnTouchListener(this);
        mViewCircle.setY(mViewLineFake.getY());

        mViewLineFake.post(() -> {
            mMinRange = mViewLineFake.getY();
            mMaxRange = mViewLineFake.getHeight() + mViewLineFake.getY() - mViewCircle.getHeight();
            mHeightRange = mMaxRange - mMinRange;
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int y = (int) (motionEvent.getY() + mViewLineFake.getY());

        if (y < mMinRange) {
            y = (int) mMinRange;
        }

        if (y > mMaxRange) {
            y = (int) mMaxRange;
        }

        if (y >= mMinRange && y <= mMaxRange) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_UP:
                    mViewCircle.setY(y);
                    updatePosition(y);
                    break;
                case MotionEvent.ACTION_MOVE:
                    mViewCircle.setY(y);
                    updatePosition(y);
                    break;
            }
        }

        return true;
    }

    private void updatePosition(int y) {
        int position = Math.round(y / mHeightRange);
        mListener.positionVolume(position);
    }

    public interface OnListener {
        void positionVolume(int position);
    }
}