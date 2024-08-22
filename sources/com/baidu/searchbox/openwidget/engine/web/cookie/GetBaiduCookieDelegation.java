package com.baidu.searchbox.openwidget.engine.web.cookie;

import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/openwidget/engine/web/cookie/GetBaiduCookieDelegation;", "Lcom/baidu/searchbox/process/ipc/delegate/provider/ProviderDelegation;", "()V", "execCall", "Landroid/os/Bundle;", "params", "Companion", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetBaiduCookieDelegation.kt */
public final class GetBaiduCookieDelegation extends ProviderDelegation {
    public static final String BAIDU_COOKIE_KEY = "baidu_cookie";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public Bundle execCall(Bundle params) {
        if (GetBaiduCookieDelegationKt.DEBUG) {
            Log.d("OpenWidgetIPCDelegation", "start GetBaiduCookieDelegation " + Thread.currentThread().getName());
        }
        return (Bundle) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new GetBaiduCookieDelegation$execCall$1((Continuation<? super GetBaiduCookieDelegation$execCall$1>) null), 1, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/openwidget/engine/web/cookie/GetBaiduCookieDelegation$Companion;", "", "()V", "BAIDU_COOKIE_KEY", "", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GetBaiduCookieDelegation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
