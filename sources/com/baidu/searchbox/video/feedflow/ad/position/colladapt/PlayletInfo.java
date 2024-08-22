package com.baidu.searchbox.video.feedflow.ad.position.colladapt;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/position/colladapt/PlayletInfo;", "", "()V", "consumeSec", "", "getConsumeSec", "()I", "setConsumeSec", "(I)V", "endTs", "", "getEndTs", "()J", "setEndTs", "(J)V", "startTs", "getStartTs", "setStartTs", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntervalCollAdaptMgr.kt */
public final class PlayletInfo {
    private int consumeSec;
    private long endTs;
    private long startTs;

    public final long getStartTs() {
        return this.startTs;
    }

    public final void setStartTs(long j2) {
        this.startTs = j2;
    }

    public final long getEndTs() {
        return this.endTs;
    }

    public final void setEndTs(long j2) {
        this.endTs = j2;
    }

    public final int getConsumeSec() {
        return this.consumeSec;
    }

    public final void setConsumeSec(int i2) {
        this.consumeSec = i2;
    }
}
