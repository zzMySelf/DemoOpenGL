package com.tera.scan.business.textrecognition;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/tera/scan/business/textrecognition/TextRecognitionResultActivityFlavor$openHalfProductPage$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivityFlavor$openHalfProductPage$1 extends ResultReceiver {
    public final /* synthetic */ Function1<Boolean, Unit> $onResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivityFlavor$openHalfProductPage$1(Function1<? super Boolean, Unit> function1, Handler handler) {
        super(handler);
        this.$onResult = function1;
    }

    public void onReceiveResult(int i2, @Nullable Bundle bundle) {
        super.onReceiveResult(i2, bundle);
        Function1<Boolean, Unit> function1 = this.$onResult;
        boolean z = true;
        if (1 != i2) {
            z = false;
        }
        function1.invoke(Boolean.valueOf(z));
    }
}
