package com.hihonor.push.sdk;

public class HonorPushDataMsg {
    public static final int TYPE_MSG_NOTIFICATION = 1;
    public static final int TYPE_MSG_PASS = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f4672a = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f4673b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f4674c;

    /* renamed from: d  reason: collision with root package name */
    public String f4675d;

    public String getData() {
        return this.f4675d;
    }

    public long getMsgId() {
        return this.f4674c;
    }

    public int getType() {
        return this.f4673b;
    }

    public int getVersion() {
        return this.f4672a;
    }

    public void setData(String str) {
        this.f4675d = str;
    }

    public void setMsgId(long j2) {
        this.f4674c = j2;
    }

    public void setType(int i2) {
        this.f4673b = i2;
    }

    public void setVersion(int i2) {
        this.f4672a = i2;
    }
}
