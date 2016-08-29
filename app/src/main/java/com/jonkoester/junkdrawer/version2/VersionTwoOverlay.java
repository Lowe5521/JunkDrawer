package com.jonkoester.junkdrawer.version2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.jonkoester.junkdrawer.R;
import com.jonkoester.junkdrawer.TutorialDialogModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VersionTwoOverlay extends RelativeLayout {

    @BindView(R.id.vTwo_overlay_next_button)
    Button nextButton;

    private RectF rectF = new RectF();
    private Path clipPath = new Path();
    private int[] screenPos = new int[2];
    private int[] screenOffset;
    private TutorialDialogModel tutorialDialogModel;
    private VersionTwoHelper versionTwoHelper;

    public VersionTwoOverlay(Context context) {
        super(context);
    }

    public VersionTwoOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VersionTwoOverlay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //region programmatic constructor for drawing the stuff

    public VersionTwoOverlay(Context context, TutorialDialogModel tutorialDialogModel) {
        super(context);

        inflate(context, R.layout.version_two_overlay, this);
        setWillNotDraw(false);
        ButterKnife.bind(this);

        this.tutorialDialogModel = tutorialDialogModel;
    }

    //endregion

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        initScreenPositionAndOffsets();
        unMaskView(canvas, tutorialDialogModel.getHighLightedView());
        createAndPositionHelper();
    }

    private void initScreenPositionAndOffsets() {
        if (screenOffset == null) {
            tutorialDialogModel.getHighLightedView().getLocationOnScreen(screenPos);

            screenOffset = new int[2];
            getLocationOnScreen(screenOffset);
        }
    }

    private void unMaskView(Canvas canvas, View view) {
        if (view != null) {
            rectF.set(getXOffset(), getYOffset(), getXOffset() + view.getWidth(), getYOffset() + view.getHeight());
            clipPath.addRoundRect(rectF, 15f, 15f, Path.Direction.CW);
            canvas.clipPath(clipPath, Region.Op.DIFFERENCE);
        }
    }

    private void createAndPositionHelper() {
        if (versionTwoHelper == null) {
            versionTwoHelper = new VersionTwoHelper(getContext(), tutorialDialogModel.getHelperTitle(), tutorialDialogModel.getHelperDescription());
            versionTwoHelper.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            versionTwoHelper.setX(getXOffset());
            versionTwoHelper.setY(getYOffset() - versionTwoHelper.getMeasuredHeight());
            addView(versionTwoHelper);
        }
    }

    /**
     * @return the x-coordinate to account for any views on the screen not included in the window
     */
    private float getXOffset() {
        float xOffset = 0;
        if (screenOffset != null) {
            xOffset = screenPos[0] - screenOffset[0];
        }

        return xOffset;
    }

    /**
     * @return the y-coordinate to account for any views on the screen not included in the window
     */
    private float getYOffset() {
        float yOffset = 0;
        if (screenOffset != null) {
            yOffset = screenPos[1] - screenOffset[1];
        }

        return yOffset;
    }

    @OnClick(R.id.vTwo_overlay_next_button)
    void onNextClick() {
        ((ViewGroup) getParent()).removeView(this);
    }
}
