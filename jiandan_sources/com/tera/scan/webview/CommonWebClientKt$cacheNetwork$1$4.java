package com.tera.scan.webview;

import com.baidu.sapi2.activity.LoginActivity;
import fe.mmm.qw.yj.de;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CommonWebClientKt$cacheNetwork$1$4 extends Lambda implements Function1<String, Unit> {
    public static final CommonWebClientKt$cacheNetwork$1$4 INSTANCE = new CommonWebClientKt$cacheNetwork$1$4();

    public CommonWebClientKt$cacheNetwork$1$4() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, LoginActivity.EXTRA_PARAM_THIRD_VERIFY_RESPONSE);
        de.ppp().m1013switch("operation_entries_data_cache", str);
    }
}
