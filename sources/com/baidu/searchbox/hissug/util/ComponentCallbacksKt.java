package com.baidu.searchbox.hissug.util;

import com.baidu.searchbox.hissug.ubc.IShowStatComp;
import com.baidu.searchbox.nacomp.mvvm.IComponent;
import com.baidu.searchbox.nacomp.mvvm.IComponentGroup;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a\u0018\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¨\u0006\u0006"}, d2 = {"dispatchCalculateShowPercent", "", "Lcom/baidu/searchbox/nacomp/mvvm/IComponent;", "dispatchHisPageScroll", "", "scrollY", "lib_hissug_frame_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComponentCallbacks.kt */
public final class ComponentCallbacksKt {
    public static final void dispatchHisPageScroll(IComponent<?> $this$dispatchHisPageScroll, int scrollY) {
        Intrinsics.checkNotNullParameter($this$dispatchHisPageScroll, "<this>");
        if ($this$dispatchHisPageScroll instanceof IShowStatComp) {
            ((IShowStatComp) $this$dispatchHisPageScroll).onHisPageScrollChange(scrollY);
        }
        if ($this$dispatchHisPageScroll instanceof IComponentGroup) {
            List<IComponent> $this$forEach$iv = ((IComponentGroup) $this$dispatchHisPageScroll).getChildren();
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "children");
            for (IComponent child : $this$forEach$iv) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                dispatchHisPageScroll(child, scrollY);
            }
        }
    }

    public static final int dispatchCalculateShowPercent(IComponent<?> $this$dispatchCalculateShowPercent) {
        int result;
        Intrinsics.checkNotNullParameter($this$dispatchCalculateShowPercent, "<this>");
        if ($this$dispatchCalculateShowPercent instanceof IShowStatComp) {
            result = ((IShowStatComp) $this$dispatchCalculateShowPercent).calculateShowPercent();
        } else {
            result = 0;
        }
        if ($this$dispatchCalculateShowPercent instanceof IComponentGroup) {
            List<IComponent> $this$forEach$iv = ((IComponentGroup) $this$dispatchCalculateShowPercent).getChildren();
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "children");
            for (IComponent child : $this$forEach$iv) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                dispatchCalculateShowPercent(child);
            }
        }
        return result;
    }
}
