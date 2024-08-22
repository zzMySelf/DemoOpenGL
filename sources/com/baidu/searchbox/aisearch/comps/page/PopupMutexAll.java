package com.baidu.searchbox.aisearch.comps.page;

import com.baidu.searchbox.aisearch.comps.common.IPopupComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/page/PopupMutexAll;", "Lcom/baidu/searchbox/aisearch/comps/page/PopupMutexRules;", "()V", "shallMutex", "", "currPopups", "", "Lcom/baidu/searchbox/aisearch/comps/common/IPopupComponent;", "newPopup", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PopupCompManager.kt */
public final class PopupMutexAll implements PopupMutexRules {
    public boolean shallMutex(List<? extends IPopupComponent> currPopups, IPopupComponent newPopup) {
        Intrinsics.checkNotNullParameter(currPopups, "currPopups");
        Intrinsics.checkNotNullParameter(newPopup, "newPopup");
        return true;
    }
}
