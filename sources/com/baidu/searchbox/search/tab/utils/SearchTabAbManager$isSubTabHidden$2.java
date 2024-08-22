package com.baidu.searchbox.search.tab.utils;

import com.baidu.searchbox.abtest.AbTestManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchTabAbManager.kt */
final class SearchTabAbManager$isSubTabHidden$2 extends Lambda implements Function0<Boolean> {
    public static final SearchTabAbManager$isSubTabHidden$2 INSTANCE = new SearchTabAbManager$isSubTabHidden$2();

    SearchTabAbManager$isSubTabHidden$2() {
        super(0);
    }

    public final Boolean invoke() {
        return Boolean.valueOf(AbTestManager.getInstance().getSwitch("search_video_subtab_hide_switch_and", true));
    }
}
