package com.baidu.searchbox.theme.skin.utils;

import com.baidu.searchbox.config.HostConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"getSkinGetUrl", "", "lib-home-skincenter_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SkinUrlConfig.kt */
public final class SkinUrlConfigKt {
    public static final String getSkinGetUrl() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/searchbox?action=publicsrv&type=operate", Arrays.copyOf(new Object[]{HostConfig.getSearchboxHostForHttps()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
