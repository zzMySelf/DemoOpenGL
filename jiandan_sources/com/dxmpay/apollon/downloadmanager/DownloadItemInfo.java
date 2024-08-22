package com.dxmpay.apollon.downloadmanager;

import android.annotation.SuppressLint;

public class DownloadItemInfo {

    /* renamed from: ad  reason: collision with root package name */
    public long f3976ad;

    /* renamed from: de  reason: collision with root package name */
    public long f3977de;

    /* renamed from: fe  reason: collision with root package name */
    public long f3978fe;
    public final long qw;
    @SuppressLint({"InlinedApi"})

    /* renamed from: rg  reason: collision with root package name */
    public int f3979rg = 1;

    public DownloadItemInfo(long j) {
        this.qw = j;
    }

    public long getCurrentBytes() {
        return this.f3976ad;
    }

    public long getDownloadId() {
        return this.qw;
    }

    public int getDownloadState() {
        return this.f3979rg;
    }

    public long getSpeed() {
        return this.f3978fe;
    }

    public long getTotalBytes() {
        return this.f3977de;
    }

    public void setCurrentBytes(long j) {
        this.f3976ad = j;
    }

    public void setDownloadState(int i2) {
        this.f3979rg = i2;
    }

    public void setSpeed(long j) {
        this.f3978fe = j;
    }

    public void setTotalBytes(long j) {
        this.f3977de = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.qw);
        sb.append(", current bytes: " + this.f3976ad);
        sb.append(", total bytes: " + this.f3977de);
        sb.append(", speed: " + this.f3978fe);
        sb.append(", state: " + this.f3979rg);
        sb.append(")");
        return sb.toString();
    }
}
