package com.baidu.awareness.impl;

import com.baidu.awareness.state.ActivityState;

public class DetectedActivityFenceRule extends FenceRule<ActivityState> {
    public DetectedActivityFenceRule(int activity) {
        this.mFeatureState = new ActivityState();
        ((ActivityState) this.mFeatureState).activity = activity;
    }

    public static DetectedActivityFenceRule duringRule(int activity) {
        return new DetectedActivityFenceRule(activity);
    }

    public boolean match(ActivityState activityState) {
        if (activityState != null && activityState.activity == ((ActivityState) this.mFeatureState).activity) {
            return true;
        }
        return false;
    }
}
