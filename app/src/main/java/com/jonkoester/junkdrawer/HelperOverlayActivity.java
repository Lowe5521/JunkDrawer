package com.jonkoester.junkdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HelperOverlayActivity extends Activity {

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

    private ViewGroup root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_overlay);
        ButterKnife.bind(this);

        root = (ViewGroup) findViewById(R.id.overlay_fun_activity);
    }

    @OnClick(R.id.act_overlay_above_button)
    void overlayAbove() {
        HelperOverlay helperOverlay = new HelperOverlay(this);
        helperOverlay.setTitle("Above!");
        helperOverlay.setMessage("Look at me! I'm up top!");
        helperOverlay.aboveView(aboveButton, root);
    }

    @OnClick(R.id.act_overlay_left_button)
    void overlayToLeft() {
        HelperOverlay helperOverlay = new HelperOverlay(this);
        helperOverlay.setTitle("Left!");
        helperOverlay.setMessage("Look at me! I'm to the left!");
        helperOverlay.toLeftOf(leftButton, root);
    }

    @OnClick(R.id.act_overlay_right_button)
    void overlayToRight() {
        HelperOverlay helperOverlay = new HelperOverlay(this);
        helperOverlay.setTitle("Right!");
        helperOverlay.setMessage("Look at me! I'm to the right!");
        helperOverlay.toRightOf(rightButton, root);
    }

    @OnClick(R.id.act_overlay_below_button)
    void overlayBelow() {
        HelperOverlay helperOverlay = new HelperOverlay(this);
        helperOverlay.setTitle("Below!");
        helperOverlay.setMessage("Look at me! I'm down below!");
        helperOverlay.belowView(belowButton, root);
    }
}
