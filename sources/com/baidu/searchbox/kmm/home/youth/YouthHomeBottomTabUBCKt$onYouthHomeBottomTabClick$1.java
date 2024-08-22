package com.baidu.searchbox.kmm.home.youth;

import com.baidu.searchbox.kmm.services.ubc.UBCUtils;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHomeBottomTabUBC.kt */
final class YouthHomeBottomTabUBCKt$onYouthHomeBottomTabClick$1 extends Lambda implements Function0<Unit> {
    public static final YouthHomeBottomTabUBCKt$onYouthHomeBottomTabClick$1 INSTANCE = new YouthHomeBottomTabUBCKt$onYouthHomeBottomTabClick$1();

    YouthHomeBottomTabUBCKt$onYouthHomeBottomTabClick$1() {
        super(0);
    }

    public final void invoke() {
        UBCUtils.ubcEvent("505", MapsKt.mapOf(TuplesKt.to("from", "home"), TuplesKt.to("type", "tab_clk_home"), TuplesKt.to("source", "home"), TuplesKt.to("value", "home_refresh"), TuplesKt.to("page", "youth_mode")));
    }
}
