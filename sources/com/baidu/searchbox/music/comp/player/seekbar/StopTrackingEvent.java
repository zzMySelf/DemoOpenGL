package com.baidu.searchbox.music.comp.player.seekbar;

import com.baidu.searchbox.music.bean.Song;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/music/comp/player/seekbar/StopTrackingEvent;", "", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "percent", "", "progress", "", "song", "Lcom/baidu/searchbox/music/bean/Song;", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;IJLcom/baidu/searchbox/music/bean/Song;)V", "getPercent", "()I", "getProgress", "()J", "getSong", "()Lcom/baidu/searchbox/music/bean/Song;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StopTrackingEvent.kt */
public final class StopTrackingEvent {
    private final int percent;
    private final long progress;
    private final Song song;
    private final UniqueId token;

    public StopTrackingEvent(UniqueId token2, int percent2, long progress2, Song song2) {
        Intrinsics.checkNotNullParameter(token2, "token");
        this.token = token2;
        this.percent = percent2;
        this.progress = progress2;
        this.song = song2;
    }

    public final UniqueId getToken() {
        return this.token;
    }

    public final int getPercent() {
        return this.percent;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final Song getSong() {
        return this.song;
    }
}
