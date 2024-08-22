package com.baidu.ar.imu;

public enum b {
    WORLD(0),
    RELATIVE(1);
    

    /* renamed from: a  reason: collision with root package name */
    private int f9724a;

    private b(int i2) {
        this.f9724a = i2;
    }

    public static b a(int i2) {
        for (b bVar : values()) {
            if (bVar.a() == i2) {
                return bVar;
            }
        }
        return null;
    }

    public int a() {
        return this.f9724a;
    }
}
