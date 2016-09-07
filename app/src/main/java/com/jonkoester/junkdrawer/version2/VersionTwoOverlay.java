package com.jonkoester.junkdrawer.version2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.jonkoester.junkdrawer.R;
import com.jonkoester.junkdrawer.TutorialDialogModel;

import java.util.Queue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VersionTwoOverlay extends RelativeLayout {

    @BindView(R.id.vTwo_overlay_next_button)
    Button nextButton;

    private RectF clipRect = new RectF();
    private Path clipPath = new Path();
    private Path highlightPath = new Path();
    private Paint highlightPaint = new Paint();
    private boolean removeExistingPath = false;
    private int[] screenPos = new int[2];
    private int[] screenOffset;
    private TutorialDialogModel tutorialDialogModel;
    private VersionTwoHelper versionTwoHelper;
    private Queue<TutorialDialogModel> tutorialDialogModelQueue;

    private final static int CLIP_PATH_PADDING = 12;
    private final static int HIGHLIGHT_STROKE_WIDTH = 8;
    private final static int HELPER_SPACING = 16;
    private final static int CORNER_RADIUS = 12;

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

    public VersionTwoOverlay(Context context, Queue<TutorialDialogModel> tutorialDialogModelQueue) {
        super(context);

        inflate(context, R.layout.version_two_overlay, this);
        setWillNotDraw(false);
        ButterKnife.bind(this);

        this.tutorialDialogModelQueue = tutorialDialogModelQueue;

        if (tutorialDialogModelQueue != null &&
                !tutorialDialogModelQueue.isEmpty()) {

            tutorialDialogModel = tutorialDialogModelQueue.poll();
        }

        highlightPaint.setAntiAlias(true);
        int limeHighlight = ContextCompat.getColor(getContext(), R.color.material_lime_A700);
        highlightPaint.setColor(limeHighlight);
        highlightPaint.setStyle(Paint.Style.STROKE);
        highlightPaint.setStrokeWidth(HIGHLIGHT_STROKE_WIDTH);
    }

    //endregion

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        initScreenPositionAndOffsets();
        unMaskView(canvas);
        createAndPositionHelper();
    }

    private void initScreenPositionAndOffsets() {
        tutorialDialogModel.getHighLightedView().getLocationOnScreen(screenPos);

        if (screenOffset == null) {
            screenOffset = new int[2];
            getLocationOnScreen(screenOffset);
        }
    }

    private void unMaskView(Canvas canvas) {
        if (tutorialDialogModel.getHighLightedView() != null) {
            if (removeExistingPath) {
                canvas.clipPath(clipPath, Region.Op.UNION);
                clipPath.reset();
                highlightPath.reset();
                removeExistingPath = false;
            }

            clipRect.set(getXOffset() - CLIP_PATH_PADDING,
                    getYOffset() - CLIP_PATH_PADDING,
                    getXOffset() + tutorialDialogModel.getHighLightedView().getWidth() + CLIP_PATH_PADDING,
                    getYOffset() + tutorialDialogModel.getHighLightedView().getHeight() + CLIP_PATH_PADDING);
            clipPath.addRoundRect(clipRect, CORNER_RADIUS, CORNER_RADIUS, Path.Direction.CW);
            highlightPath.addRoundRect(clipRect, CORNER_RADIUS, CORNER_RADIUS, Path.Direction.CW);

            canvas.drawPath(highlightPath, highlightPaint);
            canvas.clipPath(clipPath, Region.Op.DIFFERENCE);
        }
    }

    private void createAndPositionHelper() {
        if (versionTwoHelper == null) {
            versionTwoHelper = new VersionTwoHelper(getContext(), tutorialDialogModel.getHelperTitle(), tutorialDialogModel.getHelperDescription());
            versionTwoHelper.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            positionHelper();
            addView(versionTwoHelper);
        }
    }

    private void positionHelper() {
        float x = getXOffset();
        float y = getYOffset();

        switch (tutorialDialogModel.getHelperDirection()) {
            case TOP:
                y -= versionTwoHelper.getMeasuredHeight() + HELPER_SPACING;
                break;
            case BOTTOM:
                y += tutorialDialogModel.getHighLightedView().getHeight() + HELPER_SPACING;
                break;
            case LEFT:
                x -= versionTwoHelper.getMeasuredWidth() + HELPER_SPACING;
                break;
            case RIGHT:
                x += tutorialDialogModel.getHighLightedView().getWidth() + HELPER_SPACING;
                break;
            default:
                break;
        }

        if (tutorialDialogModel.getHelperXAlignment() != null) {
            switch (tutorialDialogModel.getHelperXAlignment()) {
                case LEFT:
                    break;
                case RIGHT:
                    x += (tutorialDialogModel.getHighLightedView().getWidth() - versionTwoHelper.getMeasuredWidth() + CLIP_PATH_PADDING) > 0 ? (tutorialDialogModel.getHighLightedView().getWidth() - versionTwoHelper.getMeasuredWidth() + CLIP_PATH_PADDING) : 0;
                    break;
                case CENTER:
                    x += (tutorialDialogModel.getHighLightedView().getWidth() / 2) - (versionTwoHelper.getMeasuredWidth() / 2);
                    break;
                default:
                    break;
            }
        }

        if (tutorialDialogModel.getHelperYAlignment() != null) {
            switch (tutorialDialogModel.getHelperYAlignment()) {
                case TOP:
                    y -= CLIP_PATH_PADDING;
                    break;
                case BOTTOM:
                    y += tutorialDialogModel.getHighLightedView().getHeight() - versionTwoHelper.getMeasuredHeight() + CLIP_PATH_PADDING;
                    break;
                case CENTER:
                    y += (tutorialDialogModel.getHighLightedView().getHeight() / 2) - (versionTwoHelper.getMeasuredHeight() / 2);
                    break;
                default:
                    break;
            }
        }

        versionTwoHelper.setX(x);
        versionTwoHelper.setY(y);
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
        if (tutorialDialogModelQueue != null
                && !tutorialDialogModelQueue.isEmpty()) {

            // We remove and null out the helper to make sure it does not hang around in memory
            removeView(versionTwoHelper);
            versionTwoHelper = null;

            removeExistingPath = true;
            tutorialDialogModel = tutorialDialogModelQueue.poll();
            requestLayout();
        } else {
            ((ViewGroup) getParent()).removeView(this);
        }
    }
}