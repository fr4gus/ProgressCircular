package com.fr4gus.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Visual indicator of progress of any operation. Displays a circle to the user and a stroke
 * that indicates how far an operation has progressed. There is also a text displayed either
 * indicating the percentage of the progress (e.g. 50%) or the current value of MAX (50/100)
 * Created by Franklin Garcia on 11/14/14.
 */
public class ProgressCircular extends TextView {

    int mCurrentColor;
    int mRemainingColor;

    float mStrokeWidth;
    int mTotal;
    int mCurrent;
    double mPercentage;
    int mStartAngle;

    boolean mShowPercentage;
    boolean mOverrideText;

    Paint mCurrentPaint;
    Paint mRemainingPaint;
    RectF mRectF;

    public ProgressCircular(Context context) {
        super(context);
        init();
    }

    public ProgressCircular(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomAttrs(context, attrs, 0);
        init();
    }

    public ProgressCircular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomAttrs(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mRectF.set(mStrokeWidth, mStrokeWidth, getWidth() - mStrokeWidth, getHeight() - mStrokeWidth);
        int degrees = (int) ((360.0 * mPercentage));
        canvas.drawOval(mRectF, mRemainingPaint);
        canvas.drawArc(mRectF, mStartAngle, degrees, false, mCurrentPaint);
        super.onDraw(canvas);
    }

    private void init() {
        mCurrentPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCurrentPaint.setStyle(Paint.Style.STROKE);
        mCurrentPaint.setColor(mCurrentColor);
        mCurrentPaint.setStrokeWidth(mStrokeWidth);

        mRemainingPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRemainingPaint.setStyle(Paint.Style.STROKE);
        mRemainingPaint.setColor(mRemainingColor);
        mRemainingPaint.setStrokeWidth(mStrokeWidth);

        mRectF = new RectF(mStrokeWidth, mStrokeWidth, getWidth() - mStrokeWidth, getHeight() - mStrokeWidth);

    }

    private void applyCustomAttrs(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a =
                context.obtainStyledAttributes(attrs, R.styleable.ProgressCircularStyle, 0, 0);

        try {
            mCurrentColor = a.getColor(R.styleable.ProgressCircularStyle_remainingColor, Color.RED);
            mRemainingColor = a.getColor(R.styleable.ProgressCircularStyle_currentColor, Color.DKGRAY);

            mStrokeWidth = a.getDimension(R.styleable.ProgressCircularStyle_strokeWidth, 3.0f);
            setProgress(a.getInt(R.styleable.ProgressCircularStyle_progress, 0));
            setTotal(a.getInt(R.styleable.ProgressCircularStyle_total, 100));
            setCurrent(a.getInt(R.styleable.ProgressCircularStyle_current, 0));
            mShowPercentage = a.getBoolean(R.styleable.ProgressCircularStyle_showPercentage, true);
            mOverrideText = a.getBoolean(R.styleable.ProgressCircularStyle_overrideText, false);
            mStartAngle = a.getInt(R.styleable.ProgressCircularStyle_startAngle, 180);
            setGravity(Gravity.CENTER);
        } finally {
            a.recycle();
        }

    }

    /**
     * Similar to progress, except that this value corresponds to current progress relative to total
     *
     * @param current
     */
    public void setCurrent(int current) {
        mCurrent = current;
        mPercentage = (double) mCurrent / (double) mTotal;
        updateText();
        invalidate();
    }

    /**
     * You can set any value to determine what's complete or 100% completion
     *
     * @param total
     */
    public void setTotal(int total) {
        mTotal = total;
        updateText();
        invalidate();
    }

    /**
     * Set current progress in percentage, e.g. 50 if progress is at 50%.
     * Values must range between 0 and 100.
     *
     * @param progress
     */
    public void setProgress(int progress) {
        mPercentage = (double) progress / 100.0;
        updateText();
        invalidate();
    }

    private void updateText() {
        if (!mOverrideText) {
            if (mShowPercentage) {
                String progress = new StringBuffer().append((int) (mPercentage * 100)).toString();
                setText(progress);
            } else {
                setText(getResources().getString(R.string.progress_format, mCurrent, mTotal));
            }
        }
    }
}
