package com.baidu.searchbox.hissug.config;

import com.baidu.searchbox.abtest.ioc.AbTestService;
import com.baidu.searchbox.hissug.data.utils.debug.HissugDebugConfigKt;
import com.baidu.searchbox.search.debug.SearchDebugConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HissugAbtest.kt */
final class HissugAbtest$hisCollapsedRowConfigValue$2 extends Lambda implements Function0<Integer> {
    public static final HissugAbtest$hisCollapsedRowConfigValue$2 INSTANCE = new HissugAbtest$hisCollapsedRowConfigValue$2();

    HissugAbtest$hisCollapsedRowConfigValue$2() {
        super(0);
    }

    public final Integer invoke() {
        int i2 = 3;
        if (!HissugAbtestKt.DEBUG || !SearchDebugConfig.getBooleanConfig(HissugDebugConfigKt.ENABLE_DEBUG_HIS_COLLAPSED_ROW, false)) {
            AbTestService access$getAbService = HissugAbtest.INSTANCE.getAbService();
            if (access$getAbService != null) {
                i2 = access$getAbService.getSwitch("search_his_collapsed_row_and", 3);
            }
        } else {
            i2 = SearchDebugConfig.getIntConfig(HissugDebugConfigKt.DEBUG_HIS_COLLAPSED_ROW, 3);
        }
        return Integer.valueOf(i2);
    }
}
