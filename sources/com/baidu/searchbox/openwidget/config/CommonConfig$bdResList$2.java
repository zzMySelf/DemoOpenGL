package com.baidu.searchbox.openwidget.config;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonConfig.kt */
final class CommonConfig$bdResList$2 extends Lambda implements Function0<Set<? extends String>> {
    public static final CommonConfig$bdResList$2 INSTANCE = new CommonConfig$bdResList$2();

    CommonConfig$bdResList$2() {
        super(0);
    }

    public final Set<String> invoke() {
        return CommonConfig.INSTANCE.loadBdResList();
    }
}
