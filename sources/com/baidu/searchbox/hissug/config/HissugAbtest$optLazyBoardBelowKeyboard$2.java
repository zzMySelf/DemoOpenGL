package com.baidu.searchbox.hissug.config;

import com.baidu.searchbox.abtest.ioc.AbTestService;
import com.baidu.searchbox.hissug.data.utils.debug.HissugDebugConfigKt;
import com.baidu.searchbox.nacomp.extension.debug.DebugExtConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HissugAbtest.kt */
final class HissugAbtest$optLazyBoardBelowKeyboard$2 extends Lambda implements Function0<Boolean> {
    public static final HissugAbtest$optLazyBoardBelowKeyboard$2 INSTANCE = new HissugAbtest$optLazyBoardBelowKeyboard$2();

    HissugAbtest$optLazyBoardBelowKeyboard$2() {
        super(0);
    }

    public final Boolean invoke() {
        boolean z = true;
        if (!HissugAbtestKt.DEBUG || DebugExtConfig.INSTANCE.getIntConfig(HissugDebugConfigKt.DEBUG_OPT_LAZY_BOARD_BELOW_KEYBOARD, 0) != 1) {
            if (!HissugAbtestKt.DEBUG || DebugExtConfig.INSTANCE.getIntConfig(HissugDebugConfigKt.DEBUG_OPT_LAZY_BOARD_BELOW_KEYBOARD, 0) != -1) {
                AbTestService access$getAbService = HissugAbtest.INSTANCE.getAbService();
                z = access$getAbService != null ? access$getAbService.getSwitch("search_tti_opt_lazy_board_below_keyboard", false) : false;
            } else {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
