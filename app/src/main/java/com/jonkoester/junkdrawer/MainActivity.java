package com.jonkoester.junkdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.act_main_recycler_view_button)
    Button recycleViewButton;
    @BindView(R.id.act_main_overlay_button)
    Button overlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recycleViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToRecyclerViewActivity();
            }
        });

        overlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayOverlayHelpers();
            }
        });
    }

    protected void moveToRecyclerViewActivity() {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    protected void displayOverlayHelpers() {
        addContentView(new HelperOverlay(this), new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}
