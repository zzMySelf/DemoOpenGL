package com.baidu.map.poipage.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PoiDetailDebugProvider.kt */
final class PoiDetailDebugProvider$getChildItemList$1$1 extends Lambda implements Function1<Integer, Unit> {
    public static final PoiDetailDebugProvider$getChildItemList$1$1 INSTANCE = new PoiDetailDebugProvider$getChildItemList$1$1();

    PoiDetailDebugProvider$getChildItemList$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int it) {
        PoiDetailDebugProvider.prefs.edit().putInt("KEY_POI_DETAIL_INF_URL", it).apply();
    }
}
