package com.jonkoester.junkdrawer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jonkoester.junkdrawer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.act_main_overlay_popup_button)
    Button overlayPopupButton;
    @BindView(R.id.act_main_screen_overlay_button)
    Button screenOverlayButton;

    private enum ActivityName {
        OVERLAY_POPUP, OVERLAY_SCREEN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        overlayPopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToScreen(ActivityName.OVERLAY_POPUP);
            }
        });

        screenOverlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToScreen(ActivityName.OVERLAY_SCREEN);
            }
        });
    }

    private void moveToScreen(ActivityName overlayFun) {
        switch (overlayFun) {
            case OVERLAY_POPUP:
                startActivity(new Intent(this, HelperPopupActivity.class));
                break;

            case OVERLAY_SCREEN:
                startActivity(new Intent(this, ScreenOverlayActivity.class));
                break;

            default:
                break;
        }
    }
}
