package com.baidu.searchbox.video.detail.utils;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.player.BDVideoPlayer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"playerFitterLifecycle", "", "context", "Landroid/content/Context;", "player", "Lcom/baidu/searchbox/player/BDVideoPlayer;", "lib-support_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerLifecycleUtils.kt */
public final class PlayerLifecycleUtilsKt {
    public static final void playerFitterLifecycle(Context context, BDVideoPlayer player) {
        if (context instanceof LifecycleOwner) {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            boolean z = true;
            if (activity == null || !ActivityExtKt.isResume(activity)) {
                z = false;
            }
            if (!z && player != null) {
                player.pause();
            }
        }
    }
}
