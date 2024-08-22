package com.baidu.searchbox.video.linkageflow.container;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/linkageflow/container/OnLinkageContainerListener;", "", "onItemScrolled", "", "position", "", "positionOffset", "", "positionOffsetPixels", "onPageScrolled", "state", "dx", "dy", "onScrollStateChanged", "linkage-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowLinkageContainer.kt */
public interface OnLinkageContainerListener {
    void onItemScrolled(int i2, float f2, int i3);

    void onPageScrolled(int i2, int i3, int i4);

    void onScrollStateChanged(int i2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoFlowLinkageContainer.kt */
    public static final class DefaultImpls {
        public static void onScrollStateChanged(OnLinkageContainerListener onLinkageContainerListener, int state) {
        }

        public static void onPageScrolled(OnLinkageContainerListener onLinkageContainerListener, int state, int dx, int dy) {
        }

        public static void onItemScrolled(OnLinkageContainerListener onLinkageContainerListener, int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
