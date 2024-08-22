package com.baidu.iknow.android.advisorysdk.config.debug;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "key", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdvisoryDebugProvider.kt */
final class AdvisoryDebugProvider$getChildItemList$clearSpecifySPValueItem$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ AdvisoryDebugProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdvisoryDebugProvider$getChildItemList$clearSpecifySPValueItem$1(AdvisoryDebugProvider advisoryDebugProvider) {
        super(1);
        this.this$0 = advisoryDebugProvider;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((String) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        DebugConfigHelper.INSTANCE.getRemovePluginSP().invoke(key);
        this.this$0.toast(key + " 已清除");
    }
}
