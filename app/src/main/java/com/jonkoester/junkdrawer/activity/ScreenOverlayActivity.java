package com.jonkoester.junkdrawer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jonkoester.junkdrawer.R;
import com.jonkoester.junkdrawer.ScreenOverlay;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScreenOverlayActivity extends Activity {

    @BindView(R.id.overlay_fun_tv)
    TextView overlayFunTV;
    @BindView(R.id.overlay_fun_tv1)
    TextView overlayFunTV1;
    @BindView(R.id.overlay_fun_tv2)
    TextView overlayFunTV2;
    @BindView(R.id.overlay_fun_tv3)
    TextView overlayFunTV3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_overlay);
        ButterKnife.bind(this);

        addContentView(new ScreenOverlay(this, overlayFunTV, overlayFunTV1, overlayFunTV2, overlayFunTV3), new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
