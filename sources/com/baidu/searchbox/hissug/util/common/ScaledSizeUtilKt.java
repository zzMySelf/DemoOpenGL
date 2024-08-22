package com.baidu.searchbox.hissug.util.common;

import com.baidu.searchbox.config.FontSizeHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"HISSUG_FONT_SIZE_TYPE", "", "getScaledSize", "", "size", "fixed", "lib_hissug_frame_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScaledSizeUtil.kt */
public final class ScaledSizeUtilKt {
    public static final int HISSUG_FONT_SIZE_TYPE = 0;

    public static final float getScaledSize(float size) {
        return FontSizeHelper.getScaledSize(0, size);
    }

    public static final float getScaledSize(int size) {
        return getScaledSize((float) size);
    }

    public static final float getScaledSize(int size, int fixed) {
        return getScaledSize((float) (size - fixed)) + ((float) fixed);
    }
}
