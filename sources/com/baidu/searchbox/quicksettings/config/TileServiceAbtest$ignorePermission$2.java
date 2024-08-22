package com.baidu.searchbox.quicksettings.config;

import com.baidu.searchbox.abtest.ioc.AbTestService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TileServiceAbtest.kt */
final class TileServiceAbtest$ignorePermission$2 extends Lambda implements Function0<Boolean> {
    public static final TileServiceAbtest$ignorePermission$2 INSTANCE = new TileServiceAbtest$ignorePermission$2();

    TileServiceAbtest$ignorePermission$2() {
        super(0);
    }

    public final Boolean invoke() {
        AbTestService access$getAbtestService = TileServiceAbtest.INSTANCE.getAbtestService();
        boolean z = false;
        if (access$getAbtestService != null) {
            z = access$getAbtestService.getSwitch("search_android_qs_ignore_permission", false);
        }
        return Boolean.valueOf(z);
    }
}
