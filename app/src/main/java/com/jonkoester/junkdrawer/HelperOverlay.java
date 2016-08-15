package com.jonkoester.junkdrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class HelperOverlay extends RelativeLayout {

    public HelperOverlay(Context context) {
        this(context, null);
    }

    public HelperOverlay(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HelperOverlay(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public HelperOverlay(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
