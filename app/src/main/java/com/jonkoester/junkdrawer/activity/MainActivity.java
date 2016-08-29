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

    @BindView(R.id.act_version_two_button)
    Button versionTwoButton;
    @BindView(R.id.act_annotation_button)
    Button annotationButton;

    private enum ActivityName {
        VERSION_TWO, ANNOTATION_FUN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void moveToScreen(ActivityName overlayFun) {
        switch (overlayFun) {
            case VERSION_TWO:
                startActivity(new Intent(this, VersionTwoActivity.class));
                break;

            case ANNOTATION_FUN:
                startActivity(new Intent(this, AnnotationActivity.class));

            default:
                break;
        }
    }

    @OnClick(R.id.act_version_two_button)
    void onVersionTwoClick() {
        moveToScreen(ActivityName.VERSION_TWO);
    }

    @OnClick(R.id.act_annotation_button)
    void onAnnotationClick() {
        moveToScreen(ActivityName.ANNOTATION_FUN);
    }
}