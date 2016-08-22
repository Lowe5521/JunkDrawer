package com.jonkoester.junkdrawer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jonkoester.junkdrawer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.act_main_overlay_popup_button)
    Button overlayPopupButton;
    @BindView(R.id.act_main_screen_overlay_button)
    Button screenOverlayButton;
    @BindView(R.id.act_main_screen_overlay_screen_and_popups)
    Button overlayAndPopupButton;

    private enum ActivityName {
        OVERLAY_POPUP, OVERLAY_SCREEN, OVERLAY_SCREEN_AND_POPUP
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void moveToScreen(ActivityName overlayFun) {
        switch (overlayFun) {
            case OVERLAY_POPUP:
                startActivity(new Intent(this, HelperPopupActivity.class));
                break;

            case OVERLAY_SCREEN:
                startActivity(new Intent(this, ScreenOverlayActivity.class));
                break;

            case OVERLAY_SCREEN_AND_POPUP:
                startActivity(new Intent(this, OverlayAndPopupActivity.class));
                break;

            default:
                break;
        }
    }

    @OnClick(R.id.act_main_overlay_popup_button)
    void onPopUpClick() {
        moveToScreen(ActivityName.OVERLAY_POPUP);
    }

    @OnClick(R.id.act_main_screen_overlay_button)
    void onOverlayClick() {
        moveToScreen(ActivityName.OVERLAY_SCREEN);

    }

    @OnClick(R.id.act_main_screen_overlay_screen_and_popups)
    void onOverlayAndPopupClick() {
        moveToScreen(ActivityName.OVERLAY_SCREEN_AND_POPUP);
    }
}