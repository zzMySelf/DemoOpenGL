package com.tera.scan.scanner.ocr.qrscan;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.zxing.Result;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.framework.BaseActivity;
import fe.mmm.qw.a.uk.rg;
import fe.mmm.qw.tt.ad.ddd.th;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/scanner/ocr/qrscan/QrScanViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "decodeResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tera/scan/scanner/ocr/model/DecodeResult;", "getDecodeResult", "()Landroidx/lifecycle/MutableLiveData;", "setDecodeResult", "(Landroidx/lifecycle/MutableLiveData;)V", "decodeLocalImage", "", "activity", "Lcom/tera/scan/framework/BaseActivity;", "path", "", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("QrScanViewModel")
public final class QrScanViewModel extends ViewModel {
    @NotNull
    public MutableLiveData<fe.mmm.qw.tt.ad.xxx.qw> qw = new MutableLiveData<>();

    public static final class qw extends rg {
        public final /* synthetic */ String ddd;
        public final /* synthetic */ QrScanViewModel xxx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public qw(QrScanViewModel qrScanViewModel, String str) {
            super("DECODE_LOCAL_IMAGE");
            this.xxx = qrScanViewModel;
            this.ddd = str;
        }

        public void when() {
            Either either;
            MutableLiveData<fe.mmm.qw.tt.ad.xxx.qw> decodeResult = this.xxx.getDecodeResult();
            try {
                Result ad2 = new th().ad(this.ddd);
                StringBuilder sb = new StringBuilder();
                sb.append("Zxing 解码本地文件结果：");
                sb.append(ad2 != null ? ad2.getText() : null);
                fe.mmm.qw.i.qw.ad("qrcode_decode_path", sb.toString());
                either = ExpectKt.success(new fe.mmm.qw.tt.ad.xxx.qw(ad2, true));
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                either = ExpectKt.failure(th2);
            }
            decodeResult.postValue(ExpectKt.successOrNull(either));
        }
    }

    public final void decodeLocalImage(@NotNull BaseActivity baseActivity, @NotNull String str) {
        Intrinsics.checkNotNullParameter(baseActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, "path");
        new qw(this, str).mmm();
    }

    @NotNull
    public final MutableLiveData<fe.mmm.qw.tt.ad.xxx.qw> getDecodeResult() {
        return this.qw;
    }

    public final void setDecodeResult(@NotNull MutableLiveData<fe.mmm.qw.tt.ad.xxx.qw> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.qw = mutableLiveData;
    }
}
