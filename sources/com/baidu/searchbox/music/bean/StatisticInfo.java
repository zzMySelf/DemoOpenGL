package com.baidu.searchbox.music.bean;

import com.baidu.pyramid.annotation.tekes.StableApi;
import java.io.Serializable;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010$\u001a\u00020%R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/music/bean/StatisticInfo;", "Ljava/io/Serializable;", "()V", "dataReplace", "", "getDataReplace", "()I", "setDataReplace", "(I)V", "fetchUrlFail", "", "getFetchUrlFail", "()J", "setFetchUrlFail", "(J)V", "fetchUrlStart", "getFetchUrlStart", "setFetchUrlStart", "fetchUrlSuccess", "getFetchUrlSuccess", "setFetchUrlSuccess", "invokeType", "getInvokeType", "setInvokeType", "playStart", "getPlayStart", "setPlayStart", "prefetchType", "getPrefetchType", "setPrefetchType", "prevStart", "getPrevStart", "setPrevStart", "scheduleStart", "getScheduleStart", "setScheduleStart", "hasAnyData", "", "lib-bdmedia-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StatisticInfo.kt */
public final class StatisticInfo implements Serializable {
    private int dataReplace = -1;
    private long fetchUrlFail = -1;
    private long fetchUrlStart = -1;
    private long fetchUrlSuccess = -1;
    private int invokeType = -1;
    private long playStart = -1;
    private long prefetchType = -1;
    private long prevStart = -1;
    private long scheduleStart = -1;

    public final long getPrefetchType() {
        return this.prefetchType;
    }

    public final void setPrefetchType(long j2) {
        this.prefetchType = j2;
    }

    public final long getPrevStart() {
        return this.prevStart;
    }

    public final void setPrevStart(long j2) {
        this.prevStart = j2;
    }

    public final long getFetchUrlStart() {
        return this.fetchUrlStart;
    }

    public final void setFetchUrlStart(long j2) {
        this.fetchUrlStart = j2;
    }

    public final long getScheduleStart() {
        return this.scheduleStart;
    }

    public final void setScheduleStart(long j2) {
        this.scheduleStart = j2;
    }

    public final long getFetchUrlSuccess() {
        return this.fetchUrlSuccess;
    }

    public final void setFetchUrlSuccess(long j2) {
        this.fetchUrlSuccess = j2;
    }

    public final long getFetchUrlFail() {
        return this.fetchUrlFail;
    }

    public final void setFetchUrlFail(long j2) {
        this.fetchUrlFail = j2;
    }

    public final long getPlayStart() {
        return this.playStart;
    }

    public final void setPlayStart(long j2) {
        this.playStart = j2;
    }

    public final int getInvokeType() {
        return this.invokeType;
    }

    public final void setInvokeType(int i2) {
        this.invokeType = i2;
    }

    public final int getDataReplace() {
        return this.dataReplace;
    }

    public final void setDataReplace(int i2) {
        this.dataReplace = i2;
    }

    public final boolean hasAnyData() {
        return (this.prevStart == -1 && this.fetchUrlStart == -1 && this.scheduleStart == -1 && this.fetchUrlSuccess == -1 && this.fetchUrlFail == -1 && this.playStart == -1 && this.prefetchType == -1 && this.invokeType == -1 && this.dataReplace == -1) ? false : true;
    }
}
