package com.jonkoester.junkdrawer;

import android.view.View;

public class TutorialDialogModel {
    private View highLightedView;
    private String helperTitle;
    private String helperDescription;
    private Direction helperDirection;

    public enum Direction {
        TOP, RIGHT, BOTTOM, LEFT
    }

    public TutorialDialogModel(View highLightedView, String helperTitle, String helperDescription, Direction helperDirection) {
        super();

        this.highLightedView = highLightedView;
        this.helperTitle = helperTitle;
        this.helperDescription = helperDescription;
        this.helperDirection = helperDirection;
    }

    public View getHighLightedView() {
        return highLightedView;
    }

    public String getHelperTitle() {
        return helperTitle;
    }

    public String getHelperDescription() {
        return helperDescription;
    }

    public Direction getHelperDirection() {
        return helperDirection;
    }
}
