package com.tera.scan.scanner.ocr.control;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/ImageView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsTakingControl$setListener$2 extends Lambda implements Function1<ImageView, Unit> {
    public final /* synthetic */ ScanIdCardsTakingControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanIdCardsTakingControl$setListener$2(ScanIdCardsTakingControl scanIdCardsTakingControl) {
        super(1);
        this.this$0 = scanIdCardsTakingControl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ImageView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "it");
        if (this.this$0.vvv() != 1) {
            ScanIdCardsTakingControl scanIdCardsTakingControl = this.this$0;
            scanIdCardsTakingControl.c(scanIdCardsTakingControl.ddd(), "take_photos");
        }
    }
}
