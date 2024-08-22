package com.baidu.searchbox.music.ext.album.detail.comp.songlist.album;

import com.baidu.searchbox.music.ext.model.ISong;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/album/FetchFirstNAActionAfter;", "Lrx/functions/Action1;", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "h5Song", "(Lcom/baidu/searchbox/music/ext/model/ISong;)V", "firstNASong", "getFirstNASong", "()Lcom/baidu/searchbox/music/ext/model/ISong;", "setFirstNASong", "call", "", "list", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumHelper.kt */
public final class FetchFirstNAActionAfter implements Action1<List<? extends ISong>> {
    private ISong firstNASong;
    private final ISong h5Song;

    public FetchFirstNAActionAfter(ISong h5Song2) {
        Intrinsics.checkNotNullParameter(h5Song2, "h5Song");
        this.h5Song = h5Song2;
    }

    public final ISong getFirstNASong() {
        return this.firstNASong;
    }

    public final void setFirstNASong(ISong iSong) {
        this.firstNASong = iSong;
    }

    public void call(List<? extends ISong> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (this.firstNASong == null) {
            this.firstNASong = AlbumHelper.INSTANCE.getFirstNASongAfter(this.h5Song, list);
        }
    }
}
