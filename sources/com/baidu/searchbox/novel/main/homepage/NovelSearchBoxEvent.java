package com.baidu.searchbox.novel.main.homepage;

import com.baidu.searchbox.NoProGuard;

public class NovelSearchBoxEvent implements NoProGuard {
    public boolean isShow;

    public NovelSearchBoxEvent(boolean isShow2) {
        this.isShow = isShow2;
    }
}
