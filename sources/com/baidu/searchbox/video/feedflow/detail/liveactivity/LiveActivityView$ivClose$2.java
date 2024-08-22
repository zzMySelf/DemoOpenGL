package com.baidu.searchbox.video.feedflow.detail.liveactivity;

import android.widget.ImageView;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveActivityView.kt */
final class LiveActivityView$ivClose$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ LiveActivityView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveActivityView$ivClose$2(LiveActivityView liveActivityView) {
        super(0);
        this.this$0 = liveActivityView;
    }

    public final ImageView invoke() {
        return (ImageView) this.this$0.findViewById(R.id.iv_close);
    }
}
