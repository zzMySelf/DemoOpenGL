package com.baidu.searchbox.feed.widget.tabfloat;

import android.view.View;
import android.view.ViewParent;

public interface ITabFloatView {
    boolean getHasAdded();

    ViewParent getParent();

    String getShowingTabId();

    View getView();

    boolean hasParent();

    void hideWithAnim();

    void onViewAdd();

    void removeFromParent();

    void showWithAnim();

    void updateUI();
}
