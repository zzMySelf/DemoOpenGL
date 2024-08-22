package com.baidu.searchbox.feed.widget;

import android.content.Context;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.flow.util.AdjustableTextView;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/flow/util/AdjustableTextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedFloatItemView.kt */
final class FeedFloatItemView$textView$2 extends Lambda implements Function0<AdjustableTextView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ FeedFloatItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedFloatItemView$textView$2(FeedFloatItemView feedFloatItemView, Context context) {
        super(0);
        this.this$0 = feedFloatItemView;
        this.$context = context;
    }

    public final AdjustableTextView invoke() {
        View findViewById = this.this$0.findViewById(R.id.float_item_view_text);
        ViewExtensionsKt.enableBold((AdjustableTextView) findViewById, DeviceUtils.ScreenInfo.dp2pxf(this.$context, 0.3f));
        return (AdjustableTextView) findViewById;
    }
}
