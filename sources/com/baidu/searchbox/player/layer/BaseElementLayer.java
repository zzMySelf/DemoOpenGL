package com.baidu.searchbox.player.layer;

import android.app.Activity;
import android.view.ViewGroup;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.layer.BaseElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/player/layer/BaseElementLayer;", "VG", "Landroid/view/ViewGroup;", "BE", "Lcom/baidu/searchbox/player/layer/BaseElement;", "Lcom/baidu/searchbox/player/layer/ElementLayer;", "()V", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getBindPlayer", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "lib-player-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseElementLayer.kt */
public abstract class BaseElementLayer<VG extends ViewGroup, BE extends BaseElement> extends ElementLayer<VG, BE> {
    public BaseElementLayer() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseElementLayer(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public BaseVideoPlayer getBindPlayer() {
        BDVideoPlayer bindPlayer = super.getBindPlayer();
        if (bindPlayer != null) {
            return (BaseVideoPlayer) bindPlayer;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.player.BaseVideoPlayer");
    }
}
