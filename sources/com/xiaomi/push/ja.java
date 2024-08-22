package com.xiaomi.push;

public enum ja {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f631a;

    private ja(int i2) {
        this.f631a = i2;
    }

    public int a() {
        return this.f631a;
    }

    public static ja a(int i2) {
        switch (i2) {
            case 0:
                return RegIdExpired;
            case 1:
                return PackageUnregistered;
            case 2:
                return Init;
            default:
                return null;
        }
    }
}
