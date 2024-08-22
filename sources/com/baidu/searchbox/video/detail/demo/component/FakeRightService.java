package com.baidu.searchbox.video.detail.demo.component;

import android.view.View;
import com.baidu.searchbox.video.detail.service.adapter.RightServiceAdapter;

public class FakeRightService extends RightServiceAdapter {
    FakeRightComponent mComponent;

    public FakeRightService(FakeRightComponent component) {
        this.mComponent = component;
    }

    public View getRootView() {
        return this.mComponent.getContentView();
    }
}
