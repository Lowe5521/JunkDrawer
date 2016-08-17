package com.jonkoester.junkdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.act_main_overlay_button)
    Button overlayButton;

    private enum ActivityName {
        OVERLAY_FUN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        overlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToScreen(ActivityName.OVERLAY_FUN);
            }
        });
    }

    private void moveToScreen(ActivityName overlayFun) {
        switch (overlayFun) {
            case OVERLAY_FUN:
                startActivity(new Intent(this, HelperPopupActivity.class));
                break;

            default:
                break;
        }
    }
}
