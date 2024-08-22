package com.baidu.searchbox.newhome.callback;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/newhome/callback/HomeV1TabContainerEventCallback;", "", "onContentPageScrollIdle", "", "from", "", "to", "onContentPageScrollStateChanged", "state", "onContentPageScrolled", "fromProgress", "", "onContentPageSelected", "lib-homepage-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeV1TabContainerEventCallback.kt */
public interface HomeV1TabContainerEventCallback {
    void onContentPageScrollIdle(int i2, int i3);

    void onContentPageScrollStateChanged(int i2);

    void onContentPageScrolled(int i2, int i3, float f2);

    void onContentPageSelected(int i2, int i3);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HomeV1TabContainerEventCallback.kt */
    public static final class DefaultImpls {
        public static void onContentPageScrolled(HomeV1TabContainerEventCallback homeV1TabContainerEventCallback, int from, int to, float fromProgress) {
        }

        public static void onContentPageSelected(HomeV1TabContainerEventCallback homeV1TabContainerEventCallback, int from, int to) {
        }

        public static void onContentPageScrollIdle(HomeV1TabContainerEventCallback homeV1TabContainerEventCallback, int from, int to) {
        }

        public static void onContentPageScrollStateChanged(HomeV1TabContainerEventCallback homeV1TabContainerEventCallback, int state) {
        }
    }
}
