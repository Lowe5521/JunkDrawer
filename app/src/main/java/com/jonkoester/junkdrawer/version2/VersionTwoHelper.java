package com.jonkoester.junkdrawer.version2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jonkoester.junkdrawer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VersionTwoHelper extends LinearLayout {

    @BindView(R.id.vTwo_helper_title)
    TextView helperTitleTV;
    @BindView(R.id.vTwo_helper_description)
    TextView helperDescriptionTV;

    public VersionTwoHelper(Context context) {
        super(context);
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

    public VersionTwoHelper(Context context, String titleText, String descriptionText) {
        super(context);

        inflate(context, R.layout.version_two_helper, this);
        setWillNotDraw(false);
        ButterKnife.bind(this);

        helperTitleTV.setText(titleText);
        helperDescriptionTV.setText(descriptionText);
    }
}
