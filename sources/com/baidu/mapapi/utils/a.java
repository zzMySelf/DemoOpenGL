package com.baidu.mapapi.utils;

import com.baidu.mapapi.utils.CoordinateConverter;

/* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f14704a;

    static {
        int[] iArr = new int[CoordinateConverter.CoordType.values().length];
        f14704a = iArr;
        try {
            iArr[CoordinateConverter.CoordType.COMMON.ordinal()] = 1;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f14704a[CoordinateConverter.CoordType.GPS.ordinal()] = 2;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f14704a[CoordinateConverter.CoordType.BD09LL.ordinal()] = 3;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f14704a[CoordinateConverter.CoordType.BD09MC.ordinal()] = 4;
        } catch (NoSuchFieldError e5) {
        }
    }
}
