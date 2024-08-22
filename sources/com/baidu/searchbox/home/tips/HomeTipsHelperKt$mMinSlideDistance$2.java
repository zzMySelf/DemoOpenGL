package com.baidu.searchbox.home.tips;

import android.util.Log;
import android.view.ViewConfiguration;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeTipsHelper.kt */
final class HomeTipsHelperKt$mMinSlideDistance$2 extends Lambda implements Function0<Integer> {
    public static final HomeTipsHelperKt$mMinSlideDistance$2 INSTANCE = new HomeTipsHelperKt$mMinSlideDistance$2();

    HomeTipsHelperKt$mMinSlideDistance$2() {
        super(0);
    }

    public final Integer invoke() {
        int distance = ViewConfiguration.getTouchSlop();
        if (AppConfig.isDebug()) {
            Log.d("HomeTipsHelper", " mMinSlideDistance= " + distance);
        }
        return Integer.valueOf(distance);
    }
}
