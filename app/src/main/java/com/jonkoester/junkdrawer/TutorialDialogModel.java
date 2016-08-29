package com.jonkoester.junkdrawer;

import android.view.View;

public class TutorialDialogModel {
    private View highLightedView;
    private String helperTitle;
    private String helperMessage;
    private Direction helperDirection;

    public enum Direction {
        TOP, RIGHT, BOTTOM, LEFT
    }

    public TutorialDialogModel(View highLightedView, String helperTitle, String helperMessage, Direction helperDirection) {
        super();

        this.highLightedView = highLightedView;
        this.helperTitle = helperTitle;
        this.helperMessage = helperMessage;
        this.helperDirection = helperDirection;
    }

    public View getHighLightedView() {
        return highLightedView;
    }

    public void setHighLightedView(View highLightedView) {
        this.highLightedView = highLightedView;
    }

    public String getHelperTitle() {
        return helperTitle;
    }

    public void setHelperTitle(String helperTitle) {
        this.helperTitle = helperTitle;
    }

    public String getHelperMessage() {
        return helperMessage;
    }

    public void setHelperMessage(String helperMessage) {
        this.helperMessage = helperMessage;
    }

    public Direction getHelperDirection() {
        return helperDirection;
    }

    public void setHelperDirection(Direction helperDirection) {
        this.helperDirection = helperDirection;
    }
}
