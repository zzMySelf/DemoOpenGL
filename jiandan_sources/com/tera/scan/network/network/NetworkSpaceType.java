package com.tera.scan.network.network;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/tera/scan/network/network/NetworkSpaceType;", "", "typeValue", "", "(Ljava/lang/String;II)V", "getTypeValue", "()I", "DEFAULT", "WORK_SPACE", "ENTERPRISE", "lib-network_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum NetworkSpaceType {
    DEFAULT(0),
    WORK_SPACE(1),
    ENTERPRISE(2);
    
    public final int typeValue;

    /* access modifiers changed from: public */
    NetworkSpaceType(int i2) {
        this.typeValue = i2;
    }

    public final int getTypeValue() {
        return this.typeValue;
    }
}
