package com.tera.scan.scanner.ocr.control;

import android.app.Activity;
import android.widget.TextView;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel;
import fe.mmm.qw.ggg.qw;
import fe.vvv.qw.xxx.ad;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsTakingControl$setListener$1 extends Lambda implements Function1<TextView, Unit> {
    public final /* synthetic */ ScanIdCardsTakingControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanIdCardsTakingControl$setListener$1(ScanIdCardsTakingControl scanIdCardsTakingControl) {
        super(1);
        this.this$0 = scanIdCardsTakingControl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextView textView) {
        String str;
        Intrinsics.checkNotNullParameter(textView, "it");
        ScanAnalyticsBaseEvent.qw.qw(qw.qw, "camera_id_cards_import_photos_click", (List) null, 2, (Object) null);
        ad pictureSize = this.this$0.f7251ad.getPictureSize();
        if (pictureSize == null) {
            pictureSize = new ad(4500, 4500);
        }
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(pictureSize.rg(), pictureSize.fe());
        int i2 = this.this$0.vvv() == 1 ? 2 : 0;
        LocalImageSelectActivity.qw qwVar = LocalImageSelectActivity.Companion;
        Activity ggg = this.this$0.ggg();
        int rg2 = this.this$0.nn() - this.this$0.ddd().size();
        OCRTakePhotoViewModel qqq = this.this$0.qqq();
        if (qqq == null || (str = qqq.getUbcSource$scanner_aiscanConfigRelease()) == null) {
            str = "";
        }
        qwVar.de(ggg, rg2, coerceAtLeast, 1, i2, str);
    }
}
