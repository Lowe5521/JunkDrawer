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

    private enum Direction {
        LEFT, RIGHT, ABOVE, BELOW
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
    public void aboveView(View view, FrameLayout root) {
        positionOverlay(Direction.ABOVE, view, root);
    }

    public void toLeftOf(View view, FrameLayout root) {
        positionOverlay(Direction.LEFT, view, root);
    }

    public void toRightOf(View view, FrameLayout root) {
        positionOverlay(Direction.RIGHT, view, root);
    }

    public void belowView(View view, FrameLayout root) {
        positionOverlay(Direction.BELOW, view, root);
    }
    //endregion

    /**
     * Method that detects and places helper popup
     *
     * @param direction This enum denotes whether the helper popup will be above, below, left or right of the view
     * @param view The view that will act as the anchor for the helper popup
     * @param root This is the top level view of the activity/fragment
     */
    private void positionOverlay(Direction direction, View view, FrameLayout root) {
        root.addView(this);

        view.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        Rect offsetViewBounds = new Rect();
        view.getDrawingRect(offsetViewBounds);
        root.offsetDescendantRectToMyCoords(view, offsetViewBounds);

        int relativeLeft = offsetViewBounds.left;
        int relativeTop = offsetViewBounds.top;

        switch (direction) {
            case ABOVE:
                drawAtCoords(relativeLeft, relativeTop - getMeasuredHeight());
                break;
            case LEFT:
                drawAtCoords(relativeLeft - getMeasuredWidth(), relativeTop);
                break;
            case RIGHT:
                drawAtCoords(relativeLeft + view.getMeasuredWidth(), relativeTop);
                break;
            case BELOW:
                drawAtCoords(relativeLeft, relativeTop + view.getMeasuredHeight());
                break;
            default:
                break;
        }

    }

    public void drawAtCoords(float x, float y) {
        setTranslationX(x);
        setTranslationY(y);
    }

    @OnClick(R.id.view_helper_overlay_button)
    void dismissOverlay() {
        ((ViewGroup) getParent()).removeView(this);
    }
}
