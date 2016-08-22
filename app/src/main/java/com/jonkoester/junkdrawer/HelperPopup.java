package com.jonkoester.junkdrawer;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HelperPopup extends LinearLayout {

    @BindView(R.id.view_helper_overlay_title)
    TextView titleTV;
    @BindView(R.id.view_helper_overlay_message)
    TextView messageTV;
    @BindView(R.id.view_helper_overlay_button)
    Button dismissButton;

    private enum DirectionX {
        LEFT, CENTER, RIGHT
    }

    private enum DirectionY {
        ABOVE, CENTER, BELOW
    }

    public HelperPopup(Context context) {
        this(context, null);
    }

    public HelperPopup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HelperPopup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);

        init(context);
    }

    public HelperPopup(Context context, String title, String message) {
        super(context);

        init(context);
        setTitle(title);
        setMessage(message);
    }

    private void init(Context context) {
        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        inflate(context, R.layout.view_helper_popup, this);
        ButterKnife.bind(this);
    }

    public void setTitle(String title) {
        titleTV.setText(title);
    }

    public void setMessage(String message) {
        messageTV.setText(message);
    }

    //region Helper methods for positioning the helper overlay
    public void aboveCenterView(View view, FrameLayout root) {
        positionOverlay(DirectionX.CENTER, DirectionY.ABOVE, view, root);
    }

    public void aboveLeftView(View view, FrameLayout root) {
        positionOverlay(DirectionX.LEFT, DirectionY.ABOVE, view, root);
    }

    public void aboveRightView(View view, FrameLayout root) {
        positionOverlay(DirectionX.RIGHT, DirectionY.ABOVE, view, root);
    }

    public void toLeftOf(View view, FrameLayout root) {
        positionOverlay(DirectionX.LEFT, DirectionY.CENTER, view, root);
    }

    public void toRightOf(View view, FrameLayout root) {
        positionOverlay(DirectionX.RIGHT, DirectionY.CENTER, view, root);
    }

    public void belowCenterView(View view, FrameLayout root) {
        positionOverlay(DirectionX.CENTER, DirectionY.BELOW, view, root);
    }

    public void belowLeftView(View view, FrameLayout root) {
        positionOverlay(DirectionX.LEFT, DirectionY.BELOW, view, root);
    }

    public void belowRightView(View view, FrameLayout root) {
        positionOverlay(DirectionX.RIGHT, DirectionY.BELOW, view, root);
    }
    //endregion

    /**
     * Method that detects and places helper popup
     *
     * @param xDirection This enum denotes whether the helper popup will be to the left, the right, or centered with the view
     * @param yDirection This enum denotes whether the helper popup will be above, below, or centered with the view
     * @param view The view that will act as the anchor for the helper popup
     * @param root This is the top level view of the activity/fragment
     */
    private void positionOverlay(DirectionX xDirection, DirectionY yDirection, View view, FrameLayout root) {
        root.addView(this);
        measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        Rect offsetViewBounds = new Rect();
        view.getDrawingRect(offsetViewBounds);
        root.offsetDescendantRectToMyCoords(view, offsetViewBounds);

        int relativeLeft = offsetViewBounds.left;
        int relativeTop = offsetViewBounds.top;

        switch (xDirection) {
            case LEFT:
                relativeLeft = relativeLeft - getMeasuredWidth();
                break;
            case RIGHT:
                relativeLeft = relativeLeft + view.getWidth();
                break;
            case CENTER:
                relativeLeft = relativeLeft + findCenterOffset(view.getWidth(), getMeasuredWidth());
                break;
            default:
                break;
        }

        switch (yDirection) {
            case ABOVE:
                relativeTop = relativeTop - getMeasuredHeight();
                break;
            case BELOW:
                relativeTop = relativeTop + view.getHeight();
                break;
            case CENTER:
                relativeTop = relativeTop + findCenterOffset(view.getWidth(), getMeasuredWidth());
                break;
            default:
                break;
        }

        drawAtCoords(relativeLeft, relativeTop);
    }

    public void drawAtCoords(float x, float y) {
        setTranslationX(x);
        setTranslationY(y);
    }

    @OnClick(R.id.view_helper_overlay_button)
    void dismissOverlay() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private int findCenterOffset(float viewHeight, float helperHeight) {
        return Math.round((viewHeight / 2) - (helperHeight / 2));
    }

    public static void dismissOverlays(ArrayList<HelperPopup> helperPopups) {
        if (helperPopups != null) {
            for (HelperPopup helperPopup : helperPopups) {
                helperPopup.dismissOverlay();
            }
            helperPopups.clear();
        }
    }
}
