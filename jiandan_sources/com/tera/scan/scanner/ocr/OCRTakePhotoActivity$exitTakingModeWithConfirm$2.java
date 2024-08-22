package com.tera.scan.scanner.ocr;

import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import fe.mmm.qw.ggg.qw;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OCRTakePhotoActivity$exitTakingModeWithConfirm$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function1<Boolean, Unit> $callback;
    public final /* synthetic */ boolean $isIdCardsControl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRTakePhotoActivity$exitTakingModeWithConfirm$2(boolean z, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$isIdCardsControl = z;
        this.$callback = function1;
    }

    public final void invoke() {
        if (this.$isIdCardsControl) {
            ScanAnalyticsBaseEvent.qw.qw(qw.qw, "camera_id_cards_discard_content_cancel_click", (List) null, 2, (Object) null);
        }
        this.$callback.invoke(Boolean.FALSE);
    }
}
