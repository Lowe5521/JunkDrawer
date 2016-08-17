package com.jonkoester.junkdrawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.ButterKnife;

public class ScreenOverlay extends RelativeLayout {

    private ArrayList<View> viewList;
    private RectF rect = new RectF();
    private Path clipPath = new Path();

    public ScreenOverlay(Context context) {
        super(context);
    }

    public ScreenOverlay(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScreenOverlay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    public ScreenOverlay(Context context, View... views) {
        this(context);

        init(context, views);
    }

    private void init(Context context, View... views) {
        inflate(context, R.layout.screen_overlay, this);
        setWillNotDraw(false);
        ButterKnife.bind(this);

        viewList = new ArrayList<>();
        Collections.addAll(viewList, views);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (View v: viewList) {
            v.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            float x = v.getX();
            float y = v.getY();
            float x2 = v.getX() + v.getMeasuredWidth();
            float y2 = v.getY() + v.getMeasuredHeight();
            rect.set(x, y, x2, y2);

            clipPath.addRoundRect(rect, 15f, 15f, Path.Direction.CW);
            canvas.clipPath(clipPath, Region.Op.DIFFERENCE);
        }
    }
}
