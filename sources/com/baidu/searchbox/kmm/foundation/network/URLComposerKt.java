package com.baidu.searchbox.kmm.foundation.network;

import com.baidu.searchbox.config.HostConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u001a\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a\u001a\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¨\u0006\u0006"}, d2 = {"getHost", "", "makeFullURL", "apiPath", "customHost", "makeFullURLWithBDP", "com.baidu.searchbox.kmm.foundation.network"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: URLComposer.kt */
public final class URLComposerKt {
    public static final String makeFullURL(String apiPath) {
        Intrinsics.checkNotNullParameter(apiPath, "apiPath");
        return makeFullURL(apiPath, (String) null);
    }

    public static /* synthetic */ String makeFullURL$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return makeFullURL(str, str2);
    }

    public static final String makeFullURL(String apiPath, String customHost) {
        Intrinsics.checkNotNullParameter(apiPath, "apiPath");
        CharSequence charSequence = customHost;
        if (charSequence == null || charSequence.length() == 0) {
            return getHost() + apiPath;
        }
        return customHost + apiPath;
    }

    public static /* synthetic */ String makeFullURLWithBDP$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return makeFullURLWithBDP(str, str2);
    }

    public static final String makeFullURLWithBDP(String apiPath, String customHost) {
        Intrinsics.checkNotNullParameter(apiPath, "apiPath");
        return makeFullURL(apiPath, customHost);
    }

    public static final String getHost() {
        String searchboxHostForHttps = HostConfig.getSearchboxHostForHttps();
        Intrinsics.checkNotNullExpressionValue(searchboxHostForHttps, "getSearchboxHostForHttps()");
        return searchboxHostForHttps;
    }
}
