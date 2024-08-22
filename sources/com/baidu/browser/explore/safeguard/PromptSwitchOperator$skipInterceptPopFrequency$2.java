package com.baidu.browser.explore.safeguard;

import com.baidu.searchbox.abtest.ioc.AbTestService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PromptSwitchOperator.kt */
final class PromptSwitchOperator$skipInterceptPopFrequency$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ PromptSwitchOperator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptSwitchOperator$skipInterceptPopFrequency$2(PromptSwitchOperator promptSwitchOperator) {
        super(0);
        this.this$0 = promptSwitchOperator;
    }

    public final Integer invoke() {
        AbTestService access$getAbTestService = this.this$0.getAbTestService();
        int i2 = 0;
        if (access$getAbTestService != null) {
            i2 = access$getAbTestService.getSwitch("search_safeguard_skip_intercept_pop_frequency", 0);
        }
        return Integer.valueOf(i2);
    }
}
