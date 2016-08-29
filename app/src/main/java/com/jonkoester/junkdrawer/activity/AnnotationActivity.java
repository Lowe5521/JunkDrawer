package com.jonkoester.junkdrawer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jonkoester.junkdrawer.AnnotationsUtility;
import com.jonkoester.junkdrawer.CustomAnnotation;
import com.jonkoester.junkdrawer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnnotationActivity extends Activity {

    @CustomAnnotation(R.id.act_annotations_tv1)
    @BindView(R.id.act_annotations_tv1)
    TextView textView1;

    @BindView(R.id.act_annotations_tv2)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_annotations);
        ButterKnife.bind(this);

        textView1.setText("Unmodified 1");
        textView2.setText("Unmodified 2");
        AnnotationsUtility.modifyAnnotatedTextViews(this);
    }
}
