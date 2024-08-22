package com.baidu.searchbox.music.ext.album.repo;

import com.baidu.searchbox.music.ext.model.ISong;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/repo/SongListCache;", "Lcom/baidu/searchbox/music/ext/album/repo/AbstractItemListCache;", "Lcom/baidu/searchbox/music/ext/model/ISong;", "()V", "canPlayNum", "", "getCanPlayNum", "()I", "setCanPlayNum", "(I)V", "payCount", "getPayCount", "setPayCount", "totalCount", "getTotalCount", "setTotalCount", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SongListCache.kt */
public final class SongListCache extends AbstractItemListCache<ISong> {
    private int canPlayNum = -1;
    private int payCount = -1;
    private int totalCount = -1;

    public SongListCache() {
        super(new LinkedList());
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final void setTotalCount(int i2) {
        this.totalCount = i2;
    }

    public final int getPayCount() {
        return this.payCount;
    }

    public final void setPayCount(int i2) {
        this.payCount = i2;
    }

    public final int getCanPlayNum() {
        return this.canPlayNum;
    }

    public final void setCanPlayNum(int i2) {
        this.canPlayNum = i2;
    }
}
