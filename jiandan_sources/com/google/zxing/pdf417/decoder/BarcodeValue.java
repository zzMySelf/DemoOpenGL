package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class BarcodeValue {
    public final Map<Integer, Integer> values = new HashMap();

    public Integer getConfidence(int i2) {
        return this.values.get(Integer.valueOf(i2));
    }

    public int[] getValue() {
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (Map.Entry next : this.values.entrySet()) {
            if (((Integer) next.getValue()).intValue() > i2) {
                i2 = ((Integer) next.getValue()).intValue();
                arrayList.clear();
                arrayList.add(next.getKey());
            } else if (((Integer) next.getValue()).intValue() == i2) {
                arrayList.add(next.getKey());
            }
        }
        return PDF417Common.toIntArray(arrayList);
    }

    public void setValue(int i2) {
        Integer num = this.values.get(Integer.valueOf(i2));
        if (num == null) {
            num = 0;
        }
        this.values.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
    }
}
