package com.tera.scan.scanner.ocr;

import android.widget.TextView;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import fe.mmm.qw.ggg.qw;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OCRTakePhotoActivity$initListeners$3 extends Lambda implements Function1<TextView, Unit> {
    public final /* synthetic */ OCRTakePhotoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRTakePhotoActivity$initListeners$3(OCRTakePhotoActivity oCRTakePhotoActivity) {
        super(1);
        this.this$0 = oCRTakePhotoActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "it");
        ScanAnalyticsBaseEvent.qw.qw(qw.qw, "camera_id_cards_last_step_click", (List) null, 2, (Object) null);
        if (!OCRTakePhotoActivity.isCertificateTakingType$scanner_aiscanConfigRelease$default(this.this$0, false, 1, (Object) null)) {
            this.this$0.exitTakingModeWithConfirm(true, AnonymousClass1.INSTANCE);
        }
    }
}
