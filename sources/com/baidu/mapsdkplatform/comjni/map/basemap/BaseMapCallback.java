package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import android.util.LongSparseArray;

public class BaseMapCallback {

    /* renamed from: a  reason: collision with root package name */
    private static LongSparseArray<b> f15123a = new LongSparseArray<>();

    public static int ReqLayerData(Bundle bundle, long j2, int i2, Bundle bundle2) {
        int size = f15123a.size();
        for (int i3 = 0; i3 < size; i3++) {
            b valueAt = f15123a.valueAt(i3);
            if (valueAt != null && valueAt.a(j2)) {
                return valueAt.a(bundle, j2, i2, bundle2);
            }
        }
        return 0;
    }

    public static void addLayerDataInterface(long j2, b bVar) {
        f15123a.put(j2, bVar);
    }

    public static void removeLayerDataInterface(long j2) {
        f15123a.remove(j2);
    }
}
