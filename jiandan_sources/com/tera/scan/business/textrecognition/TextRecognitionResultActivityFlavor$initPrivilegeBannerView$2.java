package com.tera.scan.business.textrecognition;

import fe.mmm.qw.rg.de.aaa.ad;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivityFlavor$initPrivilegeBannerView$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ TextRecognitionResultActivity $this_initPrivilegeBannerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivityFlavor$initPrivilegeBannerView$2(TextRecognitionResultActivity textRecognitionResultActivity) {
        super(0);
        this.$this_initPrivilegeBannerView = textRecognitionResultActivity;
    }

    public final void invoke() {
        this.$this_initPrivilegeBannerView.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().closePrivilegeBannerView();
        ad.ad("Close_clk", "Trial_Guide", (String) null, (String) null, (Map) null, 28, (Object) null);
    }
}
