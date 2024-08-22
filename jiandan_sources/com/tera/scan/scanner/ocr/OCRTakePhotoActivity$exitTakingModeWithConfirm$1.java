package com.tera.scan.scanner.ocr;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OCRTakePhotoActivity$exitTakingModeWithConfirm$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function1<Boolean, Unit> $callback;
    public final /* synthetic */ boolean $isIdCardsControl;
    public final /* synthetic */ boolean $isPrevious;
    public final /* synthetic */ List<String> $pictures;
    public final /* synthetic */ OCRTakePhotoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRTakePhotoActivity$exitTakingModeWithConfirm$1(boolean z, OCRTakePhotoActivity oCRTakePhotoActivity, boolean z2, List<String> list, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$isIdCardsControl = z;
        this.this$0 = oCRTakePhotoActivity;
        this.$isPrevious = z2;
        this.$pictures = list;
        this.$callback = function1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        r0 = r0.getCurrentTabItem();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r4 = this;
            boolean r0 = r4.$isIdCardsControl
            r1 = 0
            if (r0 == 0) goto L_0x000d
            fe.mmm.qw.ggg.qw r0 = fe.mmm.qw.ggg.qw.qw
            r2 = 2
            java.lang.String r3 = "camera_id_cards_discard_content_discard_click"
            com.tera.scan.libanalytics.ScanAnalyticsBaseEvent.qw.qw(r0, r3, r1, r2, r1)
        L_0x000d:
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity r0 = r4.this$0
            com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = r0.getBottomUIAdapter$scanner_aiscanConfigRelease()
            if (r0 == 0) goto L_0x0020
            fe.mmm.qw.tt.ad.i r0 = r0.getCurrentTabItem()
            if (r0 == 0) goto L_0x0020
            com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl r0 = r0.ad()
            goto L_0x0021
        L_0x0020:
            r0 = r1
        L_0x0021:
            boolean r2 = r0 instanceof com.tera.scan.scanner.ocr.control.IPrepareProcessing
            if (r2 == 0) goto L_0x0028
            r1 = r0
            com.tera.scan.scanner.ocr.control.IPrepareProcessing r1 = (com.tera.scan.scanner.ocr.control.IPrepareProcessing) r1
        L_0x0028:
            if (r1 == 0) goto L_0x002d
            r1.rg()
        L_0x002d:
            boolean r0 = r4.$isIdCardsControl
            if (r0 == 0) goto L_0x0041
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity r0 = r4.this$0
            boolean r1 = r4.$isPrevious
            java.util.List<java.lang.String> r2 = r4.$pictures
            int r2 = r2.size()
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r3 = r4.$callback
            fe.mmm.qw.tt.ad.o.ad(r0, r1, r2, r3)
            goto L_0x0046
        L_0x0041:
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity r0 = r4.this$0
            r0.exitTakingMode()
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity$exitTakingModeWithConfirm$1.invoke():void");
    }
}
