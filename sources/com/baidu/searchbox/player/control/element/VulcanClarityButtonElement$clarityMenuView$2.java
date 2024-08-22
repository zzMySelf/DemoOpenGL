package com.baidu.searchbox.player.control.element;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.player.widget.VideoVulcanClarityMenuView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/player/widget/VideoVulcanClarityMenuView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanClarityButtonElement.kt */
final class VulcanClarityButtonElement$clarityMenuView$2 extends Lambda implements Function0<VideoVulcanClarityMenuView> {
    final /* synthetic */ VulcanClarityButtonElement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VulcanClarityButtonElement$clarityMenuView$2(VulcanClarityButtonElement vulcanClarityButtonElement) {
        super(0);
        this.this$0 = vulcanClarityButtonElement;
    }

    public final VideoVulcanClarityMenuView invoke() {
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        VideoVulcanClarityMenuView videoVulcanClarityMenuView = new VideoVulcanClarityMenuView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        VulcanClarityButtonElement vulcanClarityButtonElement = this.this$0;
        VideoVulcanClarityMenuView $this$invoke_u24lambda_u2d0 = videoVulcanClarityMenuView;
        $this$invoke_u24lambda_u2d0.setVisibility(8);
        $this$invoke_u24lambda_u2d0.setClarityChangedListener(vulcanClarityButtonElement);
        $this$invoke_u24lambda_u2d0.setVisibleListener(vulcanClarityButtonElement);
        return videoVulcanClarityMenuView;
    }
}
