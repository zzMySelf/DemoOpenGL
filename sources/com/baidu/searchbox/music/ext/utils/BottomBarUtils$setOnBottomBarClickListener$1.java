package com.baidu.searchbox.music.ext.utils;

import android.view.View;
import com.baidu.searchbox.unifiedtoolbar.base.BarElementClickContext;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import com.baidu.searchbox.unifiedtoolbar.base.OnBottomBarElementClickListener;
import com.baidu.searchbox.unifiedtoolbar.templates.UnifiedBottomBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/music/ext/utils/BottomBarUtils$setOnBottomBarClickListener$1", "Lcom/baidu/searchbox/unifiedtoolbar/base/OnBottomBarElementClickListener;", "onBottomBarElementClick", "", "context", "Lcom/baidu/searchbox/unifiedtoolbar/base/BarElementClickContext;", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBarUtils.kt */
public final class BottomBarUtils$setOnBottomBarClickListener$1 implements OnBottomBarElementClickListener {
    final /* synthetic */ Function1<View, Unit> $onBarClick;
    final /* synthetic */ UnifiedBottomBar $this_setOnBottomBarClickListener;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BottomBarUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomBarElementID.values().length];
            iArr[BottomBarElementID.ELEMENT_ID_BACK.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    BottomBarUtils$setOnBottomBarClickListener$1(Function1<? super View, Unit> $onBarClick2, UnifiedBottomBar $receiver) {
        this.$onBarClick = $onBarClick2;
        this.$this_setOnBottomBarClickListener = $receiver;
    }

    public boolean onBottomBarElementClick(BarElementClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (WhenMappings.$EnumSwitchMapping$0[context.getElementId().ordinal()] != 1) {
            return false;
        }
        this.$onBarClick.invoke(this.$this_setOnBottomBarClickListener);
        return true;
    }
}
