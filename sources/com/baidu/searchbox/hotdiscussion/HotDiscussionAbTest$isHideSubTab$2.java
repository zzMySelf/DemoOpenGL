package com.baidu.searchbox.hotdiscussion;

import com.baidu.searchbox.abtest.ioc.AbTestService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotDiscussionAbTest.kt */
final class HotDiscussionAbTest$isHideSubTab$2 extends Lambda implements Function0<Boolean> {
    public static final HotDiscussionAbTest$isHideSubTab$2 INSTANCE = new HotDiscussionAbTest$isHideSubTab$2();

    HotDiscussionAbTest$isHideSubTab$2() {
        super(0);
    }

    public final Boolean invoke() {
        AbTestService access$getAbTest$p = HotDiscussionAbTest.abTest;
        boolean z = true;
        if (access$getAbTest$p != null) {
            z = access$getAbTest$p.getSwitch("search_hotdiscussion_subtab_hide_switch_and", true);
        }
        return Boolean.valueOf(z);
    }
}
