package com.baidu.searchbox.video.feedflow.flow.comonlistpanel.view;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/view/HotTopicListOnBoundaryItemsShowListener;", "", "()V", "getNextLoadThreshold", "", "getPreLoadThreshold", "onFirstXItemShow", "", "itemCount", "fPosition", "lPosition", "isFirst", "", "onLastXItemShow", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotTopicListCommonView.kt */
public class HotTopicListOnBoundaryItemsShowListener {
    public void onFirstXItemShow(int itemCount, int fPosition, int lPosition, boolean isFirst) {
    }

    public void onLastXItemShow(int itemCount, int fPosition, int lPosition) {
    }

    public int getPreLoadThreshold() {
        return 10;
    }

    public int getNextLoadThreshold() {
        return 10;
    }
}
