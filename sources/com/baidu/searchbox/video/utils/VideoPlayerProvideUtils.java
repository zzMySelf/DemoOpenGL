package com.baidu.searchbox.video.utils;

import android.content.Context;
import com.baidu.searchbox.player.SearchVideoPlayer;
import com.baidu.searchbox.player.ShortVideoPlayer;
import com.baidu.searchbox.player.layer.ControlLayer;
import com.baidu.searchbox.player.layer.KernelLayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0006\u0010\f\u001a\u00020\t¨\u0006\r"}, d2 = {"getFeedVideoDetailPlayer", "Lcom/baidu/searchbox/player/ShortVideoPlayer;", "context", "Landroid/content/Context;", "kernelLayer", "Lcom/baidu/searchbox/player/layer/KernelLayer;", "nid", "", "getFeedVideoDetailPlayerControlLayer", "Lcom/baidu/searchbox/player/layer/ControlLayer;", "getSearchVideoDetailPlayer", "Lcom/baidu/searchbox/player/SearchVideoPlayer;", "getSearchVideoDetailPlayerControlLayer", "lib-detail-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPlayerProvideUtils.kt */
public final class VideoPlayerProvideUtils {
    public static final ShortVideoPlayer getFeedVideoDetailPlayer(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "nid");
        return getFeedVideoDetailPlayer$default(context, (KernelLayer) null, str, 2, (Object) null);
    }

    public static final ShortVideoPlayer getFeedVideoDetailPlayer(String str) {
        Intrinsics.checkNotNullParameter(str, "nid");
        return getFeedVideoDetailPlayer$default((Context) null, (KernelLayer) null, str, 3, (Object) null);
    }

    public static /* synthetic */ ShortVideoPlayer getFeedVideoDetailPlayer$default(Context context, KernelLayer kernelLayer, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = null;
        }
        if ((i2 & 2) != 0) {
            kernelLayer = null;
        }
        return getFeedVideoDetailPlayer(context, kernelLayer, str);
    }

    public static final ShortVideoPlayer getFeedVideoDetailPlayer(Context context, KernelLayer kernelLayer, String nid) {
        Intrinsics.checkNotNullParameter(nid, "nid");
        if (kernelLayer == null) {
            return new VideoPlayerProvideUtils$getFeedVideoDetailPlayer$1(context, nid);
        }
        return new VideoPlayerProvideUtils$getFeedVideoDetailPlayer$2(context, kernelLayer, nid);
    }

    public static final SearchVideoPlayer getSearchVideoDetailPlayer(String nid) {
        Intrinsics.checkNotNullParameter(nid, "nid");
        return new VideoPlayerProvideUtils$getSearchVideoDetailPlayer$1(nid);
    }

    public static final ControlLayer getFeedVideoDetailPlayerControlLayer() {
        return new VideoPlayerProvideUtils$getFeedVideoDetailPlayerControlLayer$1();
    }

    public static final ControlLayer getSearchVideoDetailPlayerControlLayer() {
        return new VideoPlayerProvideUtils$getSearchVideoDetailPlayerControlLayer$1();
    }
}
