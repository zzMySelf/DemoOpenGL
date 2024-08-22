package com.baidu.searchbox.video.channel.flow.pageview.drawer;

import android.view.KeyEvent;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\u001a\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\fH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\fH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\fH&J\u001d\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/pageview/drawer/IChannelDrawer;", "", "closeDrawer", "", "drawer", "Lcom/baidu/searchbox/video/channel/flow/pageview/drawer/Drawer;", "closeDrawer-CiM4tho", "(Ljava/lang/String;)V", "handleLifecycleEvent", "event", "Landroidx/lifecycle/Lifecycle$Event;", "isDrawerOpen", "", "onFontSizeChange", "onKeyDown", "keyCode", "", "Landroid/view/KeyEvent;", "onNightModeChanged", "isNightMode", "onUserVisibleHint", "isVisibleToUser", "onViewWindowFocusChanged", "hasWindowFocus", "openDrawer", "openDrawer-CiM4tho", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IChannelDrawer.kt */
public interface IChannelDrawer {
    /* renamed from: closeDrawer-CiM4tho  reason: not valid java name */
    void m4905closeDrawerCiM4tho(String str);

    void handleLifecycleEvent(Lifecycle.Event event);

    boolean isDrawerOpen();

    void onFontSizeChange();

    boolean onKeyDown(int i2, KeyEvent keyEvent);

    void onNightModeChanged(boolean z);

    void onUserVisibleHint(boolean z);

    void onViewWindowFocusChanged(boolean z);

    /* renamed from: openDrawer-CiM4tho  reason: not valid java name */
    void m4906openDrawerCiM4tho(String str);
}
