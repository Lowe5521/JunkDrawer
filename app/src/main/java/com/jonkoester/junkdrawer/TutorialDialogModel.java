package com.jonkoester.junkdrawer;

import android.view.View;

public class TutorialDialogModel {
    private View highLightedView;
    private String helperTitle;
    private String helperDescription;
    private Direction helperDirection;
    private XAlignment helperXAlignment;
    private YAlignment helperYAlignment;

    public enum Direction {
        TOP, RIGHT, BOTTOM, LEFT
    }

    public enum XAlignment {
        LEFT, RIGHT, CENTER
    }

    public enum YAlignment {
        TOP, BOTTOM, CENTER
    }

    public TutorialDialogModel(View highLightedView, String helperTitle, String helperDescription, Direction helperDirection) {
        this(highLightedView, helperTitle, helperDescription, helperDirection, null, null);
    }

    public TutorialDialogModel(View highLightedView, String helperTitle, String helperDescription, Direction helperDirection, XAlignment xAlignment, YAlignment yAlignment) {
        super();

        this.highLightedView = highLightedView;
        this.helperTitle = helperTitle;
        this.helperDescription = helperDescription;
        this.helperDirection = helperDirection;
        this.helperXAlignment = xAlignment;
        this.helperYAlignment = yAlignment;
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

    public XAlignment getHelperXAlignment() {
        return helperXAlignment;
    }

    public YAlignment getHelperYAlignment() {
        return helperYAlignment;
    }
}
