package com.baidu.searchbox.music.player;

import com.baidu.searchbox.music.bean.Song;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.model.SongExtraKt;
import com.baidu.searchbox.music.ext.model.SongFactory;
import com.baidu.searchbox.music.player.core.IActivateCondition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/music/player/VideoActivateCondition;", "Lcom/baidu/searchbox/music/player/core/IActivateCondition;", "()V", "shouldActivate", "", "data", "", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPlayerManager.kt */
public final class VideoActivateCondition implements IActivateCondition {
    public boolean shouldActivate(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof Song) {
            ISong wrapCompat = SongFactory.wrapCompat((Song) data);
            Intrinsics.checkNotNullExpressionValue(wrapCompat, "wrapCompat(data)");
            if (SongExtraKt.isSupportPlayVideo(wrapCompat)) {
                return true;
            }
        }
        return false;
    }
}
