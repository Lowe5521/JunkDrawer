package com.jonkoester.junkdrawer.version2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.jonkoester.junkdrawer.R;

import butterknife.ButterKnife;

public class VersionTwoOverlay extends RelativeLayout {

    private View view;
    private RectF rectF = new RectF();
    private Path clipPath = new Path();
    private int[] windowPos;

    // Casing the null as an AttributeSet seems really really dirty. I'll come back
    // to this if the rest of my stuff works
    public VersionTwoOverlay(Context context) {
        this(context, (AttributeSet) null);
    }

    public VersionTwoOverlay(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VersionTwoOverlay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.version_two_overlay, this);
        ButterKnife.bind(this);
    }

    //region programmatic constructor for drawing the stuff

    public VersionTwoOverlay(Context context, View view) {
        super(context);

        inflate(context, R.layout.version_two_overlay, this);
        setWillNotDraw(false);
        ButterKnife.bind(this);

        this.view = view;
    }

    //endregion

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        unMaskView(canvas, view);

        VersionTwoHelper versionTwoHelper = new VersionTwoHelper(getContext());
        addView(versionTwoHelper);
        versionTwoHelper.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        versionTwoHelper.setX(view.getX());
        versionTwoHelper.setY(view.getY() - versionTwoHelper.getMeasuredHeight());
    }

    private void unMaskView(Canvas canvas, View view) {
        if (view != null) {
            view.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            rectF.set(view.getX(), view.getY(), view.getX() + view.getMeasuredWidth(), view.getY() + view.getMeasuredHeight());
            clipPath.addRoundRect(rectF, 15f, 15f, Path.Direction.CW);
            canvas.clipPath(clipPath, Region.Op.DIFFERENCE);
        }
    }
}
