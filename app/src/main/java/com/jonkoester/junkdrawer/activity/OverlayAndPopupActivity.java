package com.jonkoester.junkdrawer.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jonkoester.junkdrawer.R;

import butterknife.ButterKnife;

public class OverlayAndPopupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_overlay_and_popup);
        ButterKnife.bind(this);
    }
}
