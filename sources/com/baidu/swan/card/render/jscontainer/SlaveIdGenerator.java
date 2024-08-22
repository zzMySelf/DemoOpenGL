package com.baidu.swan.card.render.jscontainer;

import java.util.concurrent.atomic.AtomicInteger;

public class SlaveIdGenerator {
    private static final AtomicInteger SID = new AtomicInteger(500);

    public static String next() {
        return String.valueOf(SID.getAndIncrement());
    }
}
