package com.baidu.searchbox.newhome.extend;

import android.view.View;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"setAutoScrollViewOppositeV1", "", "Landroid/view/View;", "businessId", "", "lib-homepage-interface_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeScrollStateEvent.kt */
public final class NewHomeScrollStateEventKt {
    @StableApi
    public static final void setAutoScrollViewOppositeV1(View $this$setAutoScrollViewOppositeV1, String businessId) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        if ($this$setAutoScrollViewOppositeV1 != null) {
            View $this$setAutoScrollViewOppositeV1_u24lambda_u2d1 = $this$setAutoScrollViewOppositeV1;
            INewHomeApi it = INewHomeApi.Companion.getNewHomeApi();
            if (it != null && it.isHideV1TabWhenScroll()) {
                it.setAutoScrollViewOppositeV1(businessId, $this$setAutoScrollViewOppositeV1_u24lambda_u2d1);
            }
        }
    }
}
