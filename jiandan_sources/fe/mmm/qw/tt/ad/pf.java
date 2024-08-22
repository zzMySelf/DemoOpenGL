package fe.mmm.qw.tt.ad;

import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class pf {
    public static final void ad(@NotNull OCRTakePhotoActivity oCRTakePhotoActivity, boolean z, int i2, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, "<this>");
        Intrinsics.checkNotNullParameter(function1, "callback");
        oCRTakePhotoActivity.exitTakingMode();
        function1.invoke(Boolean.valueOf(!oCRTakePhotoActivity.isCertificateTakingType$scanner_aiscanConfigRelease(false)));
    }

    public static final void qw(@NotNull OCRTakePhotoActivity oCRTakePhotoActivity, boolean z) {
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, "<this>");
        LoggerKt.d$default("退出拍摄中模式 exit = " + z, (Object) null, 1, (Object) null);
    }
}
