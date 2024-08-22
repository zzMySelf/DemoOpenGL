package com.baidu.searchbox.search.tab.implement.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/model/NextPlayPosition;", "", "listItemPosition", "", "compilationItemPosition", "(II)V", "getCompilationItemPosition", "()I", "setCompilationItemPosition", "(I)V", "getListItemPosition", "setListItemPosition", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NextPlayPosition.kt */
public final class NextPlayPosition {
    private int compilationItemPosition;
    private int listItemPosition;

    public NextPlayPosition(int listItemPosition2, int compilationItemPosition2) {
        this.listItemPosition = listItemPosition2;
        this.compilationItemPosition = compilationItemPosition2;
    }

    public final int getCompilationItemPosition() {
        return this.compilationItemPosition;
    }

    public final int getListItemPosition() {
        return this.listItemPosition;
    }

    public final void setCompilationItemPosition(int i2) {
        this.compilationItemPosition = i2;
    }

    public final void setListItemPosition(int i2) {
        this.listItemPosition = i2;
    }
}
