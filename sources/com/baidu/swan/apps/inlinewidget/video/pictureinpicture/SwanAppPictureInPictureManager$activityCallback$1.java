package com.baidu.swan.apps.inlinewidget.video.pictureinpicture;

import android.util.Log;
import com.baidu.swan.apps.framework.DefaultActivityCallback;
import com.baidu.swan.apps.ioc.interfaces.ISwanAppVideoPlayer;
import com.baidu.swan.apps.llm.api.AbsSwanLLMApiKt;
import com.baidu.swan.apps.media.video.SwanAppVideoPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/swan/apps/inlinewidget/video/pictureinpicture/SwanAppPictureInPictureManager$activityCallback$1", "Lcom/baidu/swan/apps/framework/DefaultActivityCallback;", "onActivityDestroyed", "", "onActivityPaused", "onActivityResumed", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanAppPictureInPictureManager.kt */
public final class SwanAppPictureInPictureManager$activityCallback$1 extends DefaultActivityCallback {
    SwanAppPictureInPictureManager$activityCallback$1() {
    }

    public void onActivityResumed() {
        SwanAppVideoPlayer miniPlayer;
        ISwanAppVideoPlayer player;
        if (AbsSwanLLMApiKt.getDEBUG()) {
            Log.d(SwanAppPictureInPictureManager.TAG, "onPictureInPictureResume()");
        }
        if (SwanAppPictureInPictureManager.INSTANCE.isShowing() && (miniPlayer = SwanAppPictureInPictureManager.miniVideoPlayer) != null && (player = miniPlayer.getPlayer()) != null) {
            Intrinsics.checkNotNullExpressionValue(player, "miniPlayer.player ?: return");
            if (!player.isPlaying() && !player.isEnd()) {
                player.resume();
                if (AbsSwanLLMApiKt.getDEBUG()) {
                    Log.d(SwanAppPictureInPictureManager.TAG, "miniVideoPlayer " + player.hashCode() + ", execute resume()");
                }
            }
        }
    }

    public void onActivityPaused() {
        if (AbsSwanLLMApiKt.getDEBUG()) {
            Log.d(SwanAppPictureInPictureManager.TAG, "onPictureInPicturePause()");
        }
        SwanAppVideoPlayer it = SwanAppPictureInPictureManager.miniVideoPlayer;
        if (it != null) {
            ISwanAppVideoPlayer player = it.getPlayer();
            if (player != null) {
                player.pause();
            }
            if (AbsSwanLLMApiKt.getDEBUG()) {
                StringBuilder append = new StringBuilder().append("miniVideoPlayer ");
                ISwanAppVideoPlayer player2 = it.getPlayer();
                Log.d(SwanAppPictureInPictureManager.TAG, append.append(player2 != null ? Integer.valueOf(player2.hashCode()) : null).append(",execute pause()").toString());
            }
        }
    }

    public void onActivityDestroyed() {
        SwanAppPictureInPictureManager.INSTANCE.closePictureInPicture();
        SwanAppPictureInPictureManager.INSTANCE.releasePictureInPicture();
    }
}
