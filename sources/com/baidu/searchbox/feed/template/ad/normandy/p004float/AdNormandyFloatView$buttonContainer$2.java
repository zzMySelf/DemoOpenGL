package com.baidu.searchbox.feed.template.ad.normandy.p004float;

import android.widget.RelativeLayout;
import com.baidu.searchbox.feed.template.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.baidu.searchbox.feed.template.ad.normandy.float.AdNormandyFloatView$buttonContainer$2  reason: invalid package */
/* compiled from: AdNormandyFloatView.kt */
final class AdNormandyFloatView$buttonContainer$2 extends Lambda implements Function0<RelativeLayout> {
    final /* synthetic */ AdNormandyFloatView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdNormandyFloatView$buttonContainer$2(AdNormandyFloatView adNormandyFloatView) {
        super(0);
        this.this$0 = adNormandyFloatView;
    }

    public final RelativeLayout invoke() {
        return (RelativeLayout) this.this$0.findViewById(R.id.ad_normandy_operate_button_container);
    }
}
