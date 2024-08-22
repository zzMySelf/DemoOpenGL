package com.baidu.searchbox.inputbox.config;

import android.util.Log;
import com.baidu.searchbox.abtest.ioc.AbTestService;
import com.baidu.searchbox.inputbox.debug.InputBoxDebugConfigKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeBoxAbTest.kt */
final class HomeBoxAbTest$needHotTagSuffix$2 extends Lambda implements Function0<Boolean> {
    public static final HomeBoxAbTest$needHotTagSuffix$2 INSTANCE = new HomeBoxAbTest$needHotTagSuffix$2();

    HomeBoxAbTest$needHotTagSuffix$2() {
        super(0);
    }

    public final Boolean invoke() {
        boolean z = true;
        if (!HomeBoxAbTestKt.DEBUG || InputBoxDebugConfigKt.getIntConfig(InputBoxDebugConfigKt.DEBUG_HOT_TAG_SUFFIX, Integer.MIN_VALUE) != 1) {
            if (!HomeBoxAbTestKt.DEBUG || InputBoxDebugConfigKt.getIntConfig(InputBoxDebugConfigKt.DEBUG_HOT_TAG_SUFFIX, Integer.MIN_VALUE) != 0) {
                AbTestService access$getAbService = HomeBoxAbTest.INSTANCE.getAbService();
                z = access$getAbService != null ? access$getAbService.getSwitch("search_hot_tag_suffix_and", false) : false;
            } else {
                z = false;
            }
        }
        boolean z2 = z;
        if (HomeBoxAbTestKt.DEBUG) {
            Log.d("HomeBoxAbTest", "needHotTagSuffix: " + z2);
        }
        return Boolean.valueOf(z2);
    }
}
