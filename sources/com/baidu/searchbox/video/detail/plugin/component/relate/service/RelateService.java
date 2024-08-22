package com.baidu.searchbox.video.detail.plugin.component.relate.service;

import com.baidu.searchbox.video.detail.plugin.component.relate.RelateComponent;
import com.baidu.searchbox.video.detail.service.adapter.RelateServiceAdapter;

public class RelateService extends RelateServiceAdapter {
    private RelateComponent mComponent;

    public RelateService(RelateComponent component) {
        this.mComponent = component;
    }

    public boolean isBound() {
        return this.mComponent.isBound();
    }

    public void notifyDataSetChanged() {
        this.mComponent.notifyDataSetChanged();
    }

    public void onTopViewIn() {
    }

    public void resumeOrPauseNextPlay() {
        this.mComponent.resumeOrPauseNextPlay();
    }

    public boolean hasAutoGotoComment() {
        return this.mComponent.hasAutoGotoComment();
    }
}
