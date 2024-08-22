package com.tera.scan.business.textrecognition;

import com.baidu.aiscan.R;
import com.tera.scan.vip.ui.view.PrivilegeBannerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tera/scan/vip/ui/view/PrivilegeBannerView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivity$privilegeBannerView$2 extends Lambda implements Function0<PrivilegeBannerView> {
    public final /* synthetic */ TextRecognitionResultActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivity$privilegeBannerView$2(TextRecognitionResultActivity textRecognitionResultActivity) {
        super(0);
        this.this$0 = textRecognitionResultActivity;
    }

    public final PrivilegeBannerView invoke() {
        return (PrivilegeBannerView) this.this$0.findViewById(R.id.privilege_banner_view);
    }
}
