package com.baidu.apollon.downloadmanager;

import android.annotation.SuppressLint;

public class DownloadItemInfo {
    public final long a;
    public long b;
    public long c;
    public long d;
    @SuppressLint({"InlinedApi"})
    public int e = 1;

    public DownloadItemInfo(long j) {
        this.a = j;
    }

    public long getCurrentBytes() {
        return this.b;
    }

    public long getDownloadId() {
        return this.a;
    }

    public int getDownloadState() {
        return this.e;
    }

    public long getSpeed() {
        return this.d;
    }

    public long getTotalBytes() {
        return this.c;
    }

    public void setCurrentBytes(long j) {
        this.b = j;
    }

    public void setDownloadState(int i2) {
        this.e = i2;
    }

    public void setSpeed(long j) {
        this.d = j;
    }

    public void setTotalBytes(long j) {
        this.c = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.a);
        sb.append(", current bytes: " + this.b);
        sb.append(", total bytes: " + this.c);
        sb.append(", speed: " + this.d);
        sb.append(", state: " + this.e);
        sb.append(")");
        return sb.toString();
    }
}
