package com.baidu.searchbox.flex.textbuilder;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;

public class LayoutMeasureUtil {
    public static int getWidth(Layout layout) {
        if (layout == null) {
            return 0;
        }
        int count = layout.getLineCount();
        int maxWidth = 0;
        for (int i2 = 0; i2 < count; i2++) {
            maxWidth = Math.max(maxWidth, (int) layout.getLineRight(i2));
        }
        return maxWidth;
    }

    public static int getHeight(Layout layout) {
        if (layout == null) {
            return 0;
        }
        int extra = 0;
        if (Build.VERSION.SDK_INT < 20 && (layout instanceof StaticLayout)) {
            int line = Math.max(0, layout.getLineCount() - 1);
            int above = layout.getLineAscent(line);
            int below = layout.getLineDescent(line);
            float ex = ((float) (below - above)) - ((((float) (below - above)) - layout.getSpacingAdd()) / layout.getSpacingMultiplier());
            extra = ex >= 0.0f ? (int) (((double) ex) + 0.5d) : -((int) (((double) (-ex)) + 0.5d));
        }
        return layout.getHeight() - extra;
    }
}
