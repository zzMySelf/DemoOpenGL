package com.baidu.wallet.paysdk.ui.widget.compliance.view;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

public class NumberWheelView extends WheelView {
    public NumberWheelView(Context context) {
        super(context);
    }

    public List<?> generatePreviewData() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 <= 10; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    @Deprecated
    public void setData(List<?> list) {
        if (isInEditMode()) {
            super.setData(generatePreviewData());
            return;
        }
        throw new UnsupportedOperationException("Use setRange instead");
    }

    public void setRange(int i2, int i3, int i4) {
        int min = Math.min(i2, i3);
        int max = Math.max(i2, i3);
        ArrayList arrayList = new ArrayList((max - min) / i4);
        while (min <= max) {
            arrayList.add(Integer.valueOf(min));
            min += i4;
        }
        super.setData(arrayList);
    }

    public NumberWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NumberWheelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setRange(float f, float f2, float f3) {
        float min = Math.min(f, f2);
        float max = Math.max(f, f2);
        ArrayList arrayList = new ArrayList((int) ((max - min) / f3));
        while (min <= max) {
            arrayList.add(Float.valueOf(min));
            min += f3;
        }
        super.setData(arrayList);
    }
}
