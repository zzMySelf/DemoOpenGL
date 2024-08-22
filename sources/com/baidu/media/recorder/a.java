package com.baidu.media.recorder;

import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Integer, Integer> f15352a;

    /* renamed from: b  reason: collision with root package name */
    private int f15353b = 4;

    static {
        HashMap hashMap = new HashMap();
        f15352a = hashMap;
        hashMap.put(2, 256);
        f15352a.put(4, 8);
        f15352a.put(8, 286);
        f15352a.put(16, 294);
        f15352a.put(32, 326);
        f15352a.put(64, 422);
        f15352a.put(128, 326);
        f15352a.put(256, 20);
    }

    public int a() {
        return this.f15353b;
    }

    public int a(int i2) {
        int i3 = this.f15353b;
        if (i3 == i2) {
            return 0;
        }
        if (i2 != (f15352a.get(Integer.valueOf(i3)).intValue() & i2)) {
            return -1;
        }
        this.f15353b = i2;
        return 1;
    }
}
