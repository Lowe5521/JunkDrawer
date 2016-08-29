package com.jonkoester.junkdrawer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.jonkoester.junkdrawer.R;
import com.jonkoester.junkdrawer.version2.VersionTwoOverlay;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VersionTwoActivity extends Activity {

    @BindView(R.id.act_vTwo_fNameTV)
    TextView firstNameTV;
    @BindView(R.id.act_vTwo_genderTV)
    TextView genderTV;
    @BindView(R.id.act_vTwo_personalTableLayout)
    TableLayout personalTableLayout;
    @BindView(R.id.act_vTwo_tv2)
    TextView testTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_two);
        ButterKnife.bind(this);

        doTheOverlayStuff();
    }

    private void doTheOverlayStuff() {
//        addContentView(new VersionTwoOverlay(this, genderTV), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        addContentView(new VersionTwoOverlay(this, personalTableLayout), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addContentView(new VersionTwoOverlay(this, testTwo), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
