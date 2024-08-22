package com.tera.scan.scanner.ocr.control;

import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "cropDestPath", "", "cropInfo", "Ljava/util/HashMap;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OCRRemoveWatermarkControl$onPictureTake$1$onNext$1 extends Lambda implements Function2<String, HashMap<String, Object>, Unit> {
    public final /* synthetic */ String $destPathStr;
    public final /* synthetic */ OCRRemoveWatermarkControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRRemoveWatermarkControl$onPictureTake$1$onNext$1(OCRRemoveWatermarkControl oCRRemoveWatermarkControl, String str) {
        super(2);
        this.this$0 = oCRRemoveWatermarkControl;
        this.$destPathStr = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (HashMap<String, Object>) (HashMap) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str, @NotNull final HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "cropInfo");
        if (!this.this$0.xxx().isAutoScanSwitchOpen()) {
            this.this$0.B(new File(this.$destPathStr), hashMap);
        } else if (this.this$0.xxx().isSingleMode()) {
            this.this$0.B(new File(this.$destPathStr), hashMap);
        } else {
            final OCRRemoveWatermarkControl oCRRemoveWatermarkControl = this.this$0;
            final String str2 = this.$destPathStr;
            oCRRemoveWatermarkControl.F(str, str2, new Function0<Unit>() {
                public final void invoke() {
                    oCRRemoveWatermarkControl.B(new File(str2), hashMap);
                }
            });
        }
    }
}
