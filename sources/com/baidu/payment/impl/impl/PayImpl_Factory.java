package com.baidu.payment.impl.impl;

public class PayImpl_Factory {
    private static volatile PayImpl instance;

    private PayImpl_Factory() {
    }

    public static synchronized PayImpl get() {
        PayImpl payImpl;
        synchronized (PayImpl_Factory.class) {
            if (instance == null) {
                instance = new PayImpl();
            }
            payImpl = instance;
        }
        return payImpl;
    }
}
