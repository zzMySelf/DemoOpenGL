package com.baidu.searchbox.live.imp;

import com.baidu.cyberplayer.sdk.dlna.DuMediaCtrlPointProvider;
import com.baidu.searchbox.live.interfaces.player.IDuMediaPnPController;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/live/imp/ILiveDuMediaServiceImpl$getCtrlPoint$1$setListener$1", "Lcom/baidu/cyberplayer/sdk/dlna/DuMediaCtrlPointProvider$CtrlPointListener;", "onComplete", "", "onError", "p0", "", "p1", "onInfo", "p2", "", "onPrepared", "onSeekCompleted", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ILiveDuMediaServiceImpl.kt */
public final class ILiveDuMediaServiceImpl$getCtrlPoint$1$setListener$1 implements DuMediaCtrlPointProvider.CtrlPointListener {
    final /* synthetic */ IDuMediaPnPController.CtrlPointListener $listener;

    ILiveDuMediaServiceImpl$getCtrlPoint$1$setListener$1(IDuMediaPnPController.CtrlPointListener $listener2) {
        this.$listener = $listener2;
    }

    public void onComplete() {
        this.$listener.onComplete();
    }

    public void onPrepared() {
        this.$listener.onPrepared();
    }

    public void onError(int p0, int p1) {
        this.$listener.onError(p0, p1);
    }

    public void onInfo(int p0, int p1, Object p2) {
        this.$listener.onInfo(p0, p1, p2);
    }

    public void onSeekCompleted(int p0, int p1) {
        this.$listener.onSeekCompleted(p0, p1);
    }
}
