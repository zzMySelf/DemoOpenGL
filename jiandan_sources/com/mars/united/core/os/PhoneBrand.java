package com.mars.united.core.os;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/mars/united/core/os/PhoneBrand;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "HUAWEI", "XIAOMI", "VIVO", "OPPO", "OTHER", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum PhoneBrand {
    HUAWEI(0),
    XIAOMI(1),
    VIVO(2),
    OPPO(3),
    OTHER(4);
    
    public final int value;

    /* access modifiers changed from: public */
    PhoneBrand(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
