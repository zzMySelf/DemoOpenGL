package com.baidu.searchbox.video.feedflow.tab.viewpager;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/viewpager/IViewPagerListener;", "", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IViewPagerListener.kt */
public interface IViewPagerListener {
    void onPageScrollStateChanged(int i2);

    void onPageScrolled(int i2, float f2, int i3);

    void onPageSelected(int i2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IViewPagerListener.kt */
    public static final class DefaultImpls {
        public static void onPageScrolled(IViewPagerListener iViewPagerListener, int position, float positionOffset, int positionOffsetPixels) {
        }

        public static void onPageScrollStateChanged(IViewPagerListener iViewPagerListener, int state) {
        }
    }
}
