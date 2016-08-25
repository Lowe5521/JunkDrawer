package com.jonkoester.junkdrawer.version2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.jonkoester.junkdrawer.R;

import butterknife.ButterKnife;

public class VersionTwoHelper extends LinearLayout {

    public VersionTwoHelper(Context context) {
        this(context, null);
    }

    public VersionTwoHelper(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VersionTwoHelper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.version_two_helper, this);
        setWillNotDraw(false);
        ButterKnife.bind(this);
    }
}
