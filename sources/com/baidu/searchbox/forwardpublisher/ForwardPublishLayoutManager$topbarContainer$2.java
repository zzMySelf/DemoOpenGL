package com.baidu.searchbox.forwardpublisher;

import android.widget.FrameLayout;
import com.baidu.searchbox.dynamicpublisher.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ForwardPublishLayoutManager.kt */
final class ForwardPublishLayoutManager$topbarContainer$2 extends Lambda implements Function0<FrameLayout> {
    final /* synthetic */ ForwardPublishLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ForwardPublishLayoutManager$topbarContainer$2(ForwardPublishLayoutManager forwardPublishLayoutManager) {
        super(0);
        this.this$0 = forwardPublishLayoutManager;
    }

    public final FrameLayout invoke() {
        return (FrameLayout) this.this$0.getContainer().findViewById(R.id.dynamic_publisher_topbar_container);
    }
}
