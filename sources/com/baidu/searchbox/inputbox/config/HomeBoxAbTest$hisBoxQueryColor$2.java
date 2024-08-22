package com.baidu.searchbox.inputbox.config;

import com.baidu.searchbox.inputbox.debug.InputBoxDebugConfigKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeBoxAbTest.kt */
final class HomeBoxAbTest$hisBoxQueryColor$2 extends Lambda implements Function0<Pair<? extends Integer, ? extends Integer>> {
    public static final HomeBoxAbTest$hisBoxQueryColor$2 INSTANCE = new HomeBoxAbTest$hisBoxQueryColor$2();

    HomeBoxAbTest$hisBoxQueryColor$2() {
        super(0);
    }

    public final Pair<Integer, Integer> invoke() {
        return HomeBoxAbTest.INSTANCE.getBoxAbColor("search_his_box_query_color_and", InputBoxDebugConfigKt.DEBUG_HIS_BOX_QUERY_COLOR, InputBoxDebugConfigKt.ENABLE_DEBUG_HIS_BOX_QUERY_COLOR);
    }
}
