package com.baidu.searchbox.kmm.home.lv1tab;

import com.baidu.searchbox.kmm.services.ubc.UBCUtils;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeLv1TabUBCUtils.kt */
final class HomeLv1TabUBCUtilsKt$onTabShowEvent$1 extends Lambda implements Function0<Unit> {
    public static final HomeLv1TabUBCUtilsKt$onTabShowEvent$1 INSTANCE = new HomeLv1TabUBCUtilsKt$onTabShowEvent$1();

    HomeLv1TabUBCUtilsKt$onTabShowEvent$1() {
        super(0);
    }

    public final void invoke() {
        UBCUtils.ubcEvent("5981", MapsKt.mapOf(TuplesKt.to("type", "show"), TuplesKt.to("page", CollectionsKt.joinToString$default(HomeLv1TabDataMgr.getDisplayHomeLv1Tabs(), "_", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, HomeLv1TabUBCUtilsKt$onTabShowEvent$1$page$1.INSTANCE, 30, (Object) null))));
    }
}
