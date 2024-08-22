package com.baidu.searchbox.weather.util;

import android.graphics.Typeface;
import com.baidu.searchbox.bdpfont.utils.BDPFont;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"getNumberFontType", "Landroid/graphics/Typeface;", "lib-weather-landing_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FontUtil.kt */
public final class FontUtilKt {
    public static final Typeface getNumberFontType() {
        return BDPFont.INSTANCE.getBDPFontTypeFace(BDPFont.NUMBER_FONT_NAME);
    }
}
