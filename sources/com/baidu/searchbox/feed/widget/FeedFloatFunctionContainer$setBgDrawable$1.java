package com.baidu.searchbox.feed.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.baidu.android.util.devices.DeviceUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/feed/widget/FeedFloatFunctionContainer$setBgDrawable$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedFloatFunctionContainer.kt */
public final class FeedFloatFunctionContainer$setBgDrawable$1 extends ViewOutlineProvider {
    final /* synthetic */ FeedFloatFunctionContainer this$0;

    FeedFloatFunctionContainer$setBgDrawable$1(FeedFloatFunctionContainer $receiver) {
        this.this$0 = $receiver;
    }

    public void getOutline(View view2, Outline outline) {
        float radius = DeviceUtils.ScreenInfo.dp2pxf(this.this$0.getContext(), 7.0f);
        if (outline != null) {
            int i2 = 0;
            int width = view2 != null ? view2.getWidth() : 0;
            if (view2 != null) {
                i2 = view2.getHeight();
            }
            outline.setRoundRect(0, 0, width, i2, radius);
        }
    }
}
