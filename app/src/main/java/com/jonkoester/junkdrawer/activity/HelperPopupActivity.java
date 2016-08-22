package com.jonkoester.junkdrawer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import com.jonkoester.junkdrawer.HelperPopup;
import com.jonkoester.junkdrawer.R;

import java.util.ArrayList;

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
    @BindView(R.id.act_overlay_clear_button)
    Button clearButton;
    @BindView(R.id.act_overlay_above_left_button)
    Button aboveLeftButton;
    @BindView(R.id.act_overlay_above_right_button)
    Button aboveRightButton;
    @BindView(R.id.act_overlay_below_left_button)
    Button belowLeftButton;
    @BindView(R.id.act_overlay_below_right_button)
    Button belowRightButton;

    private FrameLayout root;
    private ArrayList<HelperPopup> helperPopups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_popup);
        ButterKnife.bind(this);

        root = (FrameLayout) findViewById(R.id.overlay_fun_activity);
        helperPopups = new ArrayList<>();
    }

    @OnClick(R.id.act_overlay_above_button)
    void overlayAbove() {
        HelperPopup helperPopup = new HelperPopup(this, "Above!", "Look at me! I'm up above!");
        helperPopup.aboveCenterView(aboveButton, root);
        helperPopups.add(helperPopup);
    }

    @OnClick(R.id.act_overlay_above_left_button)
    void overlayAboveLeft() {
        HelperPopup helperPopup = new HelperPopup(this, "Above Left!", "Look at me! I'm up above left!");
        helperPopup.aboveLeftView(aboveLeftButton, root);
        helperPopups.add(helperPopup);
    }

    @OnClick(R.id.act_overlay_above_right_button)
    void overlayAboveRight() {
        HelperPopup helperPopup = new HelperPopup(this, "Above right!", "Look at me! I'm up above right!");
        helperPopup.aboveRightView(aboveRightButton, root);
        helperPopups.add(helperPopup);
    }

    @OnClick(R.id.act_overlay_left_button)
    void overlayToLeft() {
        HelperPopup helperPopup = new HelperPopup(this, "Left!", "Look at me! I'm to the left!");
        helperPopup.toLeftOf(leftButton, root);
        helperPopups.add(helperPopup);
    }

    @OnClick(R.id.act_overlay_right_button)
    void overlayToRight() {
        HelperPopup helperPopup = new HelperPopup(this, "Right!", "Look at me! I'm to the right!");
        helperPopup.toRightOf(rightButton, root);
        helperPopups.add(helperPopup);
    }

    @OnClick(R.id.act_overlay_below_button)
    void overlayBelow() {
        HelperPopup helperPopup = new HelperPopup(this, "Below!", "Look at me! I'm down below!");
        helperPopup.belowCenterView(belowButton, root);
        helperPopups.add(helperPopup);
    }

    @OnClick(R.id.act_overlay_below_left_button)
    void overlayBelowLeft() {
        HelperPopup helperPopup = new HelperPopup(this, "Below left!", "Look at me! I'm down below left!");
        helperPopup.belowLeftView(belowLeftButton, root);
        helperPopups.add(helperPopup);
    }

    @OnClick(R.id.act_overlay_below_right_button)
    void overlayBelowRight() {
        HelperPopup helperPopup = new HelperPopup(this, "Below right!", "Look at me! I'm down below right!");
        helperPopup.belowRightView(belowRightButton, root);
        helperPopups.add(helperPopup);
    }

    @OnClick(R.id.act_overlay_clear_button)
    void clearOverlays() {
        HelperPopup.dismissOverlays(helperPopups);
    }
}
