package com.tencent.mm.opensdk.diffdev.a;

import com.baidu.sapi2.activity.BindVerifyActivity;

public enum d {
    UUID_EXPIRED(BindVerifyActivity.J),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(BindVerifyActivity.M),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);
    
    public int a;

    /* access modifiers changed from: public */
    d(int i2) {
        this.a = i2;
    }

    public int a() {
        return this.a;
    }

    public String toString() {
        return "UUIDStatusCode:" + this.a;
    }
}
