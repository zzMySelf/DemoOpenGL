package com.baidu.searchbox.flex.textbuilder;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

class StaticLayoutHelper {
    StaticLayoutHelper() {
    }

    private static StaticLayout getStaticLayoutMaybeMaxLines(CharSequence text, int start, int end, TextPaint paint, int width, Layout.Alignment alignment, float spacingMult, float spacingAdd, boolean includePadding, TextUtils.TruncateAt ellipsize, int ellipsisWidth, int maxLines) {
        return getStaticLayoutNoMaxLines(text, start, end, paint, width, alignment, spacingMult, spacingAdd, includePadding, ellipsize, ellipsisWidth);
    }

    private static StaticLayout getStaticLayoutNoMaxLines(CharSequence text, int start, int end, TextPaint paint, int width, Layout.Alignment alignment, float spacingMult, float spacingAdd, boolean includePadding, TextUtils.TruncateAt ellipsize, int ellipsisWidth) {
        return new StaticLayout(text, start, end, paint, width, alignment, spacingMult, spacingAdd, includePadding, ellipsize, ellipsisWidth);
    }

    public static StaticLayout make(CharSequence text, int start, int end, TextPaint paint, int width, Layout.Alignment alignment, float spacingMult, float spacingAdd, boolean includePadding, TextUtils.TruncateAt ellipsize, int ellipsisWidth, int maxLines) {
        if (Build.VERSION.SDK_INT >= 23) {
            return StaticLayout.Builder.obtain(text, start, end, paint, width).setAlignment(alignment).setLineSpacing(spacingAdd, spacingMult).setIncludePad(includePadding).setEllipsize(ellipsize).setEllipsizedWidth(ellipsisWidth).setMaxLines(maxLines).build();
        }
        return getStaticLayoutMaybeMaxLines(text, start, end, paint, width, alignment, spacingMult, spacingAdd, includePadding, ellipsize, ellipsisWidth, maxLines);
    }
}
