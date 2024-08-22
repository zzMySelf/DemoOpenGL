package com.baidu.searchbox.noveladapter.appframework;

import android.view.View;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.toolbar.BaseToolBarItem;

public class NovelBaseToolBarItemWarpper implements NoProGuard {
    private BaseToolBarItem mBaseToolBarItem;

    public NovelBaseToolBarItemWarpper(int itemId) {
        this.mBaseToolBarItem = new BaseToolBarItem(itemId);
    }

    public NovelBaseToolBarItemWarpper(int itemId, View itemView) {
        this.mBaseToolBarItem = new BaseToolBarItem(itemId, itemView);
    }

    public NovelBaseToolBarItemWarpper(int itemId, boolean isCustomClick) {
        this.mBaseToolBarItem = new BaseToolBarItem(itemId, isCustomClick);
    }

    public NovelBaseToolBarItemWarpper(int itemId, View itemView, boolean isCustomClick) {
        this.mBaseToolBarItem = new BaseToolBarItem(itemId, itemView, isCustomClick);
    }

    public NovelBaseToolBarItemWarpper(BaseToolBarItem item) {
        this.mBaseToolBarItem = item;
    }

    public BaseToolBarItem getBaseToolBarItem() {
        return this.mBaseToolBarItem;
    }

    public int getItemId() {
        BaseToolBarItem baseToolBarItem = this.mBaseToolBarItem;
        if (baseToolBarItem != null) {
            return baseToolBarItem.getItemId();
        }
        return 0;
    }

    public View getItemView() {
        BaseToolBarItem baseToolBarItem = this.mBaseToolBarItem;
        if (baseToolBarItem != null) {
            return baseToolBarItem.getItemView();
        }
        return null;
    }

    public void setItemView(View itemView) {
        BaseToolBarItem baseToolBarItem = this.mBaseToolBarItem;
        if (baseToolBarItem != null) {
            baseToolBarItem.setItemView(itemView);
        }
    }

    public boolean isCustomClick() {
        BaseToolBarItem baseToolBarItem = this.mBaseToolBarItem;
        if (baseToolBarItem != null) {
            return baseToolBarItem.isCustomClick();
        }
        return false;
    }
}
