package com.baidu.searchbox.kmm.home.operation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/kmm/home/operation/HomeOperationResourceProcessor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeBottomBarOperationMgr.kt */
final class HomeBottomBarOperationMgr$resourceProcessor$2 extends Lambda implements Function0<HomeOperationResourceProcessor> {
    public static final HomeBottomBarOperationMgr$resourceProcessor$2 INSTANCE = new HomeBottomBarOperationMgr$resourceProcessor$2();

    HomeBottomBarOperationMgr$resourceProcessor$2() {
        super(0);
    }

    public final HomeOperationResourceProcessor invoke() {
        return new HomeOperationResourceProcessor("KMM-底bar运营", "home_bottom_bar_operation", AnonymousClass1.INSTANCE);
    }
}
