package com.jonkoester.junkdrawer.version2;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jonkoester.junkdrawer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VersionTwoActivity extends Activity {

    @BindView(R.id.act_vTwo_tv1)
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.version_two_activity);
        ButterKnife.bind(this);

        doTheOverlayStuff();
    }

    private void doTheOverlayStuff() {
        addContentView(new VersionTwoOverlay(this, textView1), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
