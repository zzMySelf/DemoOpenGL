package com.baidu.searchbox.live.host2live.video;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H&J\u001e\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bH&¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;", "", "cancelAutoPlay", "", "controlAutoPlay", "isPause", "", "destroyLive", "enablePageScroll", "dirs", "", "Lcom/baidu/searchbox/live/host2live/video/ScrollDir;", "enable", "finishActivity", "notifyLiveEnd", "scrollToNext", "scrollToNextNoDelete", "dir", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ILiveToListInvokeAbility.kt */
public interface ILiveToListInvokeAbility {
    void cancelAutoPlay();

    void controlAutoPlay(boolean z);

    void destroyLive();

    void enablePageScroll(List<? extends ScrollDir> list, boolean z);

    void finishActivity();

    void notifyLiveEnd();

    void scrollToNext();

    void scrollToNextNoDelete(ScrollDir scrollDir);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* compiled from: ILiveToListInvokeAbility.kt */
    public static final class DefaultImpls {
        public static void cancelAutoPlay(ILiveToListInvokeAbility $this) {
        }

        public static void controlAutoPlay(ILiveToListInvokeAbility $this, boolean isPause) {
        }

        public static void notifyLiveEnd(ILiveToListInvokeAbility $this) {
        }
    }
}
