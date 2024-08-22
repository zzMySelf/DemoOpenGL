package com.tera.scan.scanner.ocr.control;

import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.LoggerKt;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/tera/scan/scanner/ocr/control/OCRToPDFControl$onPictureTake$1", "Lio/reactivex/Observer;", "", "onComplete", "", "onError", "e", "", "onNext", "destPathStr", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRToPDFControl$onPictureTake$1 implements Observer<String> {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OCRToPDFControl f7209ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Bitmap f7210th;

    public OCRToPDFControl$onPictureTake$1(OCRToPDFControl oCRToPDFControl, Bitmap bitmap) {
        this.f7209ad = oCRToPDFControl;
        this.f7210th = bitmap;
    }

    public void onComplete() {
        LoggerKt.d$default("onComplete ", (Object) null, 1, (Object) null);
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        LoggerKt.d$default("onError " + th2, (Object) null, 1, (Object) null);
    }

    public void onSubscribe(@NotNull Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        LoggerKt.d$default("onSubscribe ", (Object) null, 1, (Object) null);
    }

    /* renamed from: qw */
    public void onNext(@NotNull String str) {
        FrameLayout l;
        Intrinsics.checkNotNullParameter(str, "destPathStr");
        LoggerKt.d$default("destPathStr " + str + Ascii.CASE_MASK, (Object) null, 1, (Object) null);
        if (this.f7209ad.xxx().isAutoScanSwitchOpen() && (l = this.f7209ad.l()) != null) {
            l.setVisibility(0);
        }
        this.f7209ad.d(str, (float) this.f7210th.getWidth(), (float) this.f7210th.getHeight(), new OCRToPDFControl$onPictureTake$1$onNext$1(this.f7209ad, str));
    }
}
