package com.baidu.searchbox.download.center.ui.video.vulcan;

import android.app.Activity;
import android.view.MotionEvent;
import com.baidu.searchbox.player.callback.SimpleBaseVideoPlayerCallback;
import com.baidu.searchbox.player.control.layer.VulcanControlSlotLayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/download/center/ui/video/vulcan/DownloadVulcanVideoPlayer$setPlayerListener$1", "Lcom/baidu/searchbox/player/callback/SimpleBaseVideoPlayerCallback;", "onGestureDoubleClick", "", "event", "Landroid/view/MotionEvent;", "onPanelVisibilityChanged", "", "isVisible", "onVideoSwitchToFloating", "oldPlayMode", "", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadVulcanVideoPlayer.kt */
public final class DownloadVulcanVideoPlayer$setPlayerListener$1 extends SimpleBaseVideoPlayerCallback {
    final /* synthetic */ DownloadVulcanVideoPlayer this$0;

    DownloadVulcanVideoPlayer$setPlayerListener$1(DownloadVulcanVideoPlayer $receiver) {
        this.this$0 = $receiver;
    }

    public boolean onGestureDoubleClick(MotionEvent event) {
        DownloadVulcanControlLayer downloadVulcanControlLayer = null;
        if (this.this$0.isPlaying()) {
            this.this$0.pause();
            DownloadVulcanControlLayer access$getMControlLayer$p = this.this$0.mControlLayer;
            if (access$getMControlLayer$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mControlLayer");
                access$getMControlLayer$p = null;
            }
            VulcanControlSlotLayer.togglePanelVisible$default(access$getMControlLayer$p, true, false, false, 6, (Object) null);
            DownloadVulcanControlLayer access$getMControlLayer$p2 = this.this$0.mControlLayer;
            if (access$getMControlLayer$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mControlLayer");
            } else {
                downloadVulcanControlLayer = access$getMControlLayer$p2;
            }
            downloadVulcanControlLayer.clearHidePanelMessage();
            return true;
        } else if (!this.this$0.isPause()) {
            return true;
        } else {
            this.this$0.resume();
            DownloadVulcanControlLayer access$getMControlLayer$p3 = this.this$0.mControlLayer;
            if (access$getMControlLayer$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mControlLayer");
            } else {
                downloadVulcanControlLayer = access$getMControlLayer$p3;
            }
            VulcanControlSlotLayer.togglePanelVisible$default(downloadVulcanControlLayer, true, false, false, 6, (Object) null);
            return true;
        }
    }

    public void onPanelVisibilityChanged(boolean isVisible) {
        if (isVisible && this.this$0.isPause()) {
            DownloadVulcanControlLayer access$getMControlLayer$p = this.this$0.mControlLayer;
            if (access$getMControlLayer$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mControlLayer");
                access$getMControlLayer$p = null;
            }
            access$getMControlLayer$p.clearHidePanelMessage();
        }
    }

    public void onVideoSwitchToFloating(String oldPlayMode) {
        if (this.this$0.getContext() instanceof Activity) {
            ((Activity) this.this$0.getContext()).finish();
        }
    }
}
