package com.jonkoester.junkdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HelperPopupActivity extends Activity {

    @BindView(R.id.act_overlay_above_button)
    Button aboveButton;
    @BindView(R.id.act_overlay_left_button)
    Button leftButton;
    @BindView(R.id.act_overlay_right_button)
    Button rightButton;
    @BindView(R.id.act_overlay_below_button)
    Button belowButton;
    @BindView(R.id.act_overlay_table_layout)
    TableLayout tableLayout;

    private FrameLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_overlay);
        ButterKnife.bind(this);

        root = (FrameLayout) findViewById(R.id.overlay_fun_activity);
    }

    @OnClick(R.id.act_overlay_above_button)
    void overlayAbove() {
        HelperPopup helperPopup = new HelperPopup(this, "Above!", "Look at me! I'm up above!");
        helperPopup.aboveView(aboveButton, root);
    }

    @OnClick(R.id.act_overlay_left_button)
    void overlayToLeft() {
        HelperPopup helperPopup = new HelperPopup(this, "Left!", "Look at me! I'm to the left!");
        helperPopup.toLeftOf(leftButton, root);
    }

    @OnClick(R.id.act_overlay_right_button)
    void overlayToRight() {
        HelperPopup helperPopup = new HelperPopup(this, "Right!", "Look at me! I'm to the right!");
        helperPopup.toRightOf(rightButton, root);
    }

    @OnClick(R.id.act_overlay_below_button)
    void overlayBelow() {
        HelperPopup helperPopup = new HelperPopup(this, "Below!", "Look at me! I'm down below!");
        helperPopup.belowView(belowButton, root);
    }
}
