package com.baidu.searchbox.newpersonalcenter.viewholder;

import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.baidu.android.util.devices.DeviceUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/newpersonalcenter/viewholder/SwanCardViewHolder$populate$5", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanCardViewHolder.kt */
public final class SwanCardViewHolder$populate$5 extends ViewOutlineProvider {
    final /* synthetic */ Context $context;

    SwanCardViewHolder$populate$5(Context $context2) {
        this.$context = $context2;
    }

    public void getOutline(View view2, Outline outline) {
        if (view2 != null && outline != null) {
            outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), DeviceUtils.ScreenInfo.dp2pxf(this.$context, 14.0f));
        }
    }
}
