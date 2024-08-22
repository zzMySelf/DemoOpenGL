package com.baidu.lcp.sdk.pb;

import com.google.protobuf.Internal;

public enum RpcMetaPb$CompressType implements Internal.EnumLite {
    COMPRESS_NONE(0, 0),
    COMPRESS_GZIP(1, 1);
    
    public static final int COMPRESS_GZIP_VALUE = 1;
    public static final int COMPRESS_NONE_VALUE = 0;
    public static Internal.EnumLiteMap<RpcMetaPb$CompressType> internalValueMap;
    public final int value;

    public class qw implements Internal.EnumLiteMap<RpcMetaPb$CompressType> {
        /* renamed from: qw */
        public RpcMetaPb$CompressType findValueByNumber(int i2) {
            return RpcMetaPb$CompressType.valueOf(i2);
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new qw();
    }

    /* access modifiers changed from: public */
    RpcMetaPb$CompressType(int i2, int i3) {
        this.value = i3;
    }

    public static Internal.EnumLiteMap<RpcMetaPb$CompressType> internalGetValueMap() {
        return internalValueMap;
    }

    public final int getNumber() {
        return this.value;
    }

    public static RpcMetaPb$CompressType valueOf(int i2) {
        if (i2 == 0) {
            return COMPRESS_NONE;
        }
        if (i2 != 1) {
            return null;
        }
        return COMPRESS_GZIP;
    }
}
