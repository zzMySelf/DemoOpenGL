package com.baidu.searchbox.adjustment;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/adjustment/AdjustTriggerManager;", "Lcom/baidu/searchbox/adjustment/AdjustTrigger;", "()V", "adjustTriggers", "", "adjust", "", "type", "", "registerAdjustTrigger", "adjustTrigger", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: adjust.kt */
public class AdjustTriggerManager implements AdjustTrigger {
    private final Set<AdjustTrigger> adjustTriggers = new LinkedHashSet();

    public final void registerAdjustTrigger(AdjustTrigger adjustTrigger) {
        Intrinsics.checkNotNullParameter(adjustTrigger, "adjustTrigger");
        this.adjustTriggers.add(adjustTrigger);
    }

    public void adjust() {
        for (AdjustTrigger adjustTrigger : this.adjustTriggers) {
            adjustTrigger.adjust();
        }
    }

    public void adjust(int type) {
        for (AdjustTrigger adjustTrigger : this.adjustTriggers) {
            adjustTrigger.adjust(type);
        }
    }
}
