package com.baidu.searchbox.flex.core;

public class FlexLayoutData {
    public final int currentLayoutStateId;
    public final int height;
    public final InterStagePropsContainer interStagePropsContainer;
    public final int previousLayoutStateId;
    public final int width;

    public FlexLayoutData(int width2, int height2, int currentLayoutStateId2, int previousLayoutStateId2, InterStagePropsContainer interStagePropsContainer2) {
        this.width = width2;
        this.height = height2;
        this.currentLayoutStateId = currentLayoutStateId2;
        this.previousLayoutStateId = previousLayoutStateId2;
        this.interStagePropsContainer = interStagePropsContainer2;
    }
}
