package com.baidu.searchbox.introduction.revisit;

import com.baidu.searchbox.launch.restore.data.RevisitConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/introduction/revisit/IHomeRevisitDialog;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeRevisitReminder.kt */
final class HomeRevisitReminder$showDialog$constructor$3 extends Lambda implements Function1<IHomeRevisitDialog, Unit> {
    final /* synthetic */ RevisitConfig $config;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeRevisitReminder$showDialog$constructor$3(RevisitConfig revisitConfig) {
        super(1);
        this.$config = revisitConfig;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((IHomeRevisitDialog) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(IHomeRevisitDialog it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Function0<Unit> showCallback = this.$config.getShowCallback();
        if (showCallback != null) {
            showCallback.invoke();
        }
    }
}
