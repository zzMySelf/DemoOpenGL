package com.baidu.titan.sdk.runtime;

public class InterceptResult {
    private static final int MAX_POOL_SIZE = 50;
    private static InterceptResult sPool;
    private static int sPoolSize = 0;
    private static final Object sPoolSync = new Object();
    public boolean booleanValue;
    public byte byteValue;
    public char charValue;
    public double doubleValue;
    public int flags;
    public float floatValue;
    public int intValue;
    public Interceptable interceptor;
    public long longValue;
    private InterceptResult next;
    public Object objValue;
    public short shortValue;

    public static InterceptResult obtain() {
        synchronized (sPoolSync) {
            InterceptResult r = sPool;
            if (r == null) {
                return new InterceptResult();
            }
            sPool = r.next;
            r.next = null;
            sPoolSize--;
            return r;
        }
    }

    public void recycle() {
        this.objValue = null;
        this.interceptor = null;
        synchronized (sPoolSync) {
            int i2 = sPoolSize;
            if (i2 < 50) {
                this.next = sPool;
                sPool = this;
                sPoolSize = i2 + 1;
            }
        }
    }
}
