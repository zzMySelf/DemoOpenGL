package com.baidu.browser.components.httpdns;

import com.baidu.android.util.UniKV;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/android/util/UniKV;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpDnsOptWhiteListListener.kt */
final class HttpDnsOptWhiteListListener$Companion$spInstance$2 extends Lambda implements Function0<UniKV> {
    public static final HttpDnsOptWhiteListListener$Companion$spInstance$2 INSTANCE = new HttpDnsOptWhiteListListener$Companion$spInstance$2();

    HttpDnsOptWhiteListListener$Companion$spInstance$2() {
        super(0);
    }

    public final UniKV invoke() {
        return new UniKV("http_dns_opt_config");
    }
}
