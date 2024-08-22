package com.baidu.searchbox.video.feedflow.ad.topappinfo;

import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.searchbox.video.feedflow.ad.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadTopAppInfoComponent.kt */
final class NadTopAppInfoComponent$container$2 extends Lambda implements Function0<LinearLayout> {
    final /* synthetic */ NadTopAppInfoComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadTopAppInfoComponent$container$2(NadTopAppInfoComponent nadTopAppInfoComponent) {
        super(0);
        this.this$0 = nadTopAppInfoComponent;
    }

    public final LinearLayout invoke() {
        LinearLayout linearLayout = new LinearLayout(this.this$0.getContext());
        LinearLayout $this$invoke_u24lambda_u2d0 = linearLayout;
        LayoutInflater.from($this$invoke_u24lambda_u2d0.getContext()).inflate(R.layout.video_flow_ad_top_app_info_view, $this$invoke_u24lambda_u2d0);
        return linearLayout;
    }
}
