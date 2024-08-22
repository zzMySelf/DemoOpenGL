package com.baidu.spswitch.handler;

import android.view.View;

public class SPSwitchFSPanelLayoutHandler {
    private boolean isSoftInputShowing;
    private final View mPanelLayout;

    public SPSwitchFSPanelLayoutHandler(View panelLayout) {
        this.mPanelLayout = panelLayout;
    }

    public void onSoftInputShowing(boolean showing) {
        this.isSoftInputShowing = showing;
        if (!showing && this.mPanelLayout.getVisibility() == 4) {
            this.mPanelLayout.setVisibility(8);
        }
    }
}
