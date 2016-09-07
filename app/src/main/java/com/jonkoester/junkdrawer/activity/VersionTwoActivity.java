package com.jonkoester.junkdrawer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.jonkoester.junkdrawer.R;
import com.jonkoester.junkdrawer.TutorialDialogModel;
import com.jonkoester.junkdrawer.version2.VersionTwoOverlay;

import java.util.LinkedList;
import java.util.Queue;

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
    @BindView(R.id.act_vTwo_bdayTV)
    TextView bdayTV;
    @BindView(R.id.act_vTwo_zipTV)
    TextView zipTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_two);
        ButterKnife.bind(this);

        doTheOverlayStuff();
    }

    private void doTheOverlayStuff() {
        Queue<TutorialDialogModel> testQ = new LinkedList<>();
        testQ.add(new TutorialDialogModel(firstNameTV, "First Name!", "This is obviously where you put the first name", TutorialDialogModel.Direction.BOTTOM, TutorialDialogModel.XAlignment.RIGHT, null));
        testQ.add(new TutorialDialogModel(genderTV, "Gender", "I remember the days when there were only two options", TutorialDialogModel.Direction.RIGHT, null, TutorialDialogModel.YAlignment.CENTER));
        testQ.add(new TutorialDialogModel(testTwo, "Test TV", "This is off in East Jesus for convenience", TutorialDialogModel.Direction.RIGHT, null, TutorialDialogModel.YAlignment.BOTTOM));
        testQ.add(new TutorialDialogModel(personalTableLayout, "Section Test", "Holy shit look at this section of the app!", TutorialDialogModel.Direction.BOTTOM, TutorialDialogModel.XAlignment.CENTER, null));
        testQ.add(new TutorialDialogModel(bdayTV, "Birthday!", "Look everyone! My birthday is on March 30th!", TutorialDialogModel.Direction.LEFT, null, TutorialDialogModel.YAlignment.TOP));
        testQ.add(new TutorialDialogModel(zipTV, "Zip Code", "This is my zip code. It is boring", TutorialDialogModel.Direction.LEFT, null, TutorialDialogModel.YAlignment.CENTER));

        addContentView(new VersionTwoOverlay(this, testQ), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
