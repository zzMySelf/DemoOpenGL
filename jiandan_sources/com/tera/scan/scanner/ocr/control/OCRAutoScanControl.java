package com.tera.scan.scanner.ocr.control;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.common.base.Ascii;
import com.google.gson.Gson;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.model.ImageBytePredictorCallback;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl;
import com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel;
import com.tera.scan.scanner.ui.cameranew.AutoScanRectView;
import com.terascan.algo.DocumentResult;
import com.terascan.algo.Point;
import fe.mmm.qw.ddd.o;
import fe.mmm.qw.j.ddd.de;
import fe.mmm.qw.tt.ad.when.eee;
import fe.mmm.qw.tt.ad.when.nn;
import fe.mmm.qw.tt.ad.when.pf;
import fe.mmm.qw.tt.ad.when.rg;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\nJ\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\bH\u0016J\b\u0010)\u001a\u00020$H\u0002J\"\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020$H\u0016J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0016J \u00103\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u00106\u001a\u00020$2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0010\u00106\u001a\u00020$2\u0006\u0010;\u001a\u00020'H\u0016J\b\u0010<\u001a\u00020$H\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u0010;\u001a\u00020'H\u0016J\b\u0010>\u001a\u00020$H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8@X\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006?"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/OCRAutoScanControl;", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoControl;", "activity", "Lcom/tera/scan/framework/BaseActivity;", "ocrTakePhotoView", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "(Lcom/tera/scan/framework/BaseActivity;Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;)V", "autoScanCallback", "Lcom/tera/scan/model/ImageBytePredictorCallback;", "autoScanSwitchOpen", "", "getAutoScanSwitchOpen", "()Z", "cameraViewHeight", "", "cameraViewWidth", "imageBytePredictor", "Lcom/tera/scan/model/ImageBytePredictor;", "isNeedNext", "setNeedNext", "(Z)V", "lastScanTime", "", "scanRect", "Lcom/tera/scan/scanner/ui/cameranew/AutoScanRectView;", "getScanRect$scanner_aiscanConfigRelease", "()Lcom/tera/scan/scanner/ui/cameranew/AutoScanRectView;", "setScanRect$scanner_aiscanConfigRelease", "(Lcom/tera/scan/scanner/ui/cameranew/AutoScanRectView;)V", "takePhotoViewModel", "Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "getTakePhotoViewModel$scanner_aiscanConfigRelease", "()Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "takePhotoViewModel$delegate", "Lkotlin/Lazy;", "clearScanRect", "", "showEdge", "getAutoScanFile", "Ljava/io/File;", "getScanCallback", "observerAutoScanSwitch", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onInitView", "view", "Landroid/app/Activity;", "onPicturePreview", "frame", "Lcom/otaliastudios/cameraview/frame/Frame;", "onPictureTake", "bitmap", "Landroid/graphics/Bitmap;", "outPutPath", "", "pic", "onSelect", "onTakePhotoBusiness", "onUnSelect", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("OCRAutoScanControl")
public class OCRAutoScanControl implements IOCRTakePhotoControl {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final IOCRTakePhotoView f7187ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public AutoScanRectView f7188de;

    /* renamed from: fe  reason: collision with root package name */
    public long f7189fe;
    @NotNull
    public final BaseActivity qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public o f7190rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Lazy f7191th = LazyKt__LazyJVMKt.lazy(new OCRAutoScanControl$takePhotoViewModel$2(this));

    /* renamed from: uk  reason: collision with root package name */
    public boolean f7192uk = true;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final ImageBytePredictorCallback f7193yj = new qw(this);

    public static final class ad implements Observer<String> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ OCRAutoScanControl f7194ad;

        public ad(OCRAutoScanControl oCRAutoScanControl) {
            this.f7194ad = oCRAutoScanControl;
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
            Intrinsics.checkNotNullParameter(str, "destPathStr");
            LoggerKt.d$default("destPathStr " + str + Ascii.CASE_MASK, (Object) null, 1, (Object) null);
            this.f7194ad.qqq(new File(str));
        }
    }

    public static final class qw implements ImageBytePredictorCallback {
        public final /* synthetic */ OCRAutoScanControl qw;

        public qw(OCRAutoScanControl oCRAutoScanControl) {
            this.qw = oCRAutoScanControl;
        }

        public static final void ad(AutoScanRectView autoScanRectView, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(autoScanRectView, "$this_apply");
            if (!Intrinsics.areEqual((Object) autoScanRectView.getPoints(), (Object) arrayList)) {
                autoScanRectView.setPoints(arrayList);
                autoScanRectView.show();
            }
        }

        public void qw(int i2, @Nullable DocumentResult documentResult) {
            this.qw.eee(true);
            if (!this.qw.ppp()) {
                OCRAutoScanControl.pf(this.qw, false, 1, (Object) null);
                return;
            }
            LoggerKt.d$default("predictorResult byteHashCode:" + i2 + " documentResult:" + new Gson().toJson((Object) documentResult), (Object) null, 1, (Object) null);
            if (documentResult == null || documentResult.getCode() != 0) {
                OCRAutoScanControl.pf(this.qw, false, 1, (Object) null);
                return;
            }
            ArrayList<Point> points = documentResult.getPoints();
            AutoScanRectView vvv = this.qw.vvv();
            if (vvv != null) {
                vvv.post(new eee(vvv, points));
            }
        }
    }

    public OCRAutoScanControl(@NotNull BaseActivity baseActivity, @NotNull IOCRTakePhotoView iOCRTakePhotoView) {
        Intrinsics.checkNotNullParameter(baseActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(iOCRTakePhotoView, "ocrTakePhotoView");
        this.qw = baseActivity;
        this.f7187ad = iOCRTakePhotoView;
    }

    /* renamed from: if  reason: not valid java name */
    public static final void m900if(OCRAutoScanControl oCRAutoScanControl) {
        Intrinsics.checkNotNullParameter(oCRAutoScanControl, "this$0");
        AutoScanRectView autoScanRectView = oCRAutoScanControl.f7188de;
        if (autoScanRectView != null) {
            autoScanRectView.clear();
        }
    }

    public static final void nn(OCRAutoScanControl oCRAutoScanControl, Boolean bool) {
        Intrinsics.checkNotNullParameter(oCRAutoScanControl, "this$0");
        if (!bool.booleanValue()) {
            pf(oCRAutoScanControl, false, 1, (Object) null);
        }
    }

    public static /* synthetic */ void pf(OCRAutoScanControl oCRAutoScanControl, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            oCRAutoScanControl.o(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearScanRect");
    }

    /* renamed from: switch  reason: not valid java name */
    public static final void m901switch(OCRAutoScanControl oCRAutoScanControl) {
        Intrinsics.checkNotNullParameter(oCRAutoScanControl, "this$0");
        AutoScanRectView autoScanRectView = oCRAutoScanControl.f7188de;
        if (autoScanRectView != null) {
            autoScanRectView.show();
        }
    }

    public void aaa(@NotNull Bitmap bitmap, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "outPutPath");
    }

    public void ad() {
    }

    public final void ddd() {
        xxx().getAutoScanSwitch().observe(this.qw, new rg(this));
    }

    public void de() {
        pf(this, false, 1, (Object) null);
    }

    public final void eee(boolean z) {
        this.f7192uk = z;
    }

    public void fe(@NotNull fe.vvv.qw.xxx.ad adVar) {
        IOCRTakePhotoControl.qw.ad(this, adVar);
    }

    @NotNull
    public ImageBytePredictorCallback ggg() {
        return this.f7193yj;
    }

    public void mmm(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        ddd();
    }

    public final void o(boolean z) {
        AutoScanRectView autoScanRectView;
        ArrayList<Point> points;
        AutoScanRectView autoScanRectView2;
        if (!z && (autoScanRectView2 = this.f7188de) != null) {
            autoScanRectView2.post(new pf(this));
        }
        AutoScanRectView autoScanRectView3 = this.f7188de;
        boolean z2 = true;
        if (autoScanRectView3 == null || (points = autoScanRectView3.getPoints()) == null || !points.isEmpty()) {
            z2 = false;
        }
        if (!z2) {
            AutoScanRectView autoScanRectView4 = this.f7188de;
            if (autoScanRectView4 != null) {
                autoScanRectView4.setPoints(new ArrayList());
            }
            if (z && (autoScanRectView = this.f7188de) != null) {
                autoScanRectView.post(new nn(this));
            }
        }
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
    }

    public void onDestroy() {
        LoggerKt.d$default("onDestroy", (Object) null, 1, (Object) null);
        o oVar = this.f7190rg;
        if (oVar != null) {
            oVar.uk();
        }
        this.f7190rg = null;
    }

    public void onResume() {
        IOCRTakePhotoControl.qw.de(this);
    }

    public void onStop() {
        IOCRTakePhotoControl.qw.fe(this);
    }

    public boolean ppp() {
        return xxx().isAutoScanSwitchOpen();
    }

    public void qqq(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "pic");
    }

    public void qw(@NotNull fe.vvv.qw.o.qw qwVar, int i2, int i3) {
        ByteBuffer buffer;
        Intrinsics.checkNotNullParameter(qwVar, "frame");
        LoggerKt.d$default("onPicturePreview ", (Object) null, 1, (Object) null);
        if (ppp() && this.f7188de != null && this.f7192uk) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f7189fe >= 300) {
                this.f7189fe = currentTimeMillis;
                if (this.f7190rg == null) {
                    this.f7190rg = o.f327if.qw();
                }
                int rg2 = qwVar.th().rg();
                int fe2 = qwVar.th().fe();
                if (rg2 > 0 && fe2 > 0) {
                    AutoScanRectView autoScanRectView = this.f7188de;
                    if (autoScanRectView != null) {
                        autoScanRectView.setCameraHeight(i3);
                    }
                    if (qwVar.fe() == 17 && Intrinsics.areEqual((Object) qwVar.de(), (Object) byte[].class)) {
                        Object ad2 = qwVar.ad();
                        Intrinsics.checkNotNullExpressionValue(ad2, "frame.getData()");
                        byte[] bArr = (byte[]) ad2;
                        fe.mmm.qw.ddd.pf.qw qwVar2 = new fe.mmm.qw.ddd.pf.qw(rg2, fe2, qwVar.rg(), i2, i3);
                        o oVar = this.f7190rg;
                        if (oVar != null) {
                            oVar.vvv(this.qw, bArr, qwVar2, rg2, fe2, true, ggg());
                        }
                    } else if (Intrinsics.areEqual((Object) qwVar.de(), (Object) Image.class) && (buffer = ((Image) qwVar.ad()).getPlanes()[0].getBuffer()) != null) {
                        int remaining = buffer.remaining();
                        byte[] bArr2 = new byte[remaining];
                        buffer.get(bArr2);
                        LoggerKt.d$default("Image bytes.size= " + remaining, (Object) null, 1, (Object) null);
                        byte[] uk2 = de.uk(bArr2, rg2, fe2, when(), 35);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Image jpegByteArray == null ");
                        sb.append(uk2 == null);
                        LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
                        this.f7192uk = false;
                        fe.mmm.qw.ddd.pf.qw qwVar3 = new fe.mmm.qw.ddd.pf.qw(rg2, fe2, qwVar.rg(), i2, i3);
                        o oVar2 = this.f7190rg;
                        if (oVar2 != null) {
                            BaseActivity baseActivity = this.qw;
                            Intrinsics.checkNotNullExpressionValue(uk2, "jpegByteArray");
                            oVar2.vvv(baseActivity, uk2, qwVar3, rg2, fe2, false, ggg());
                        }
                    }
                }
            }
        }
    }

    public final void rrr(@Nullable AutoScanRectView autoScanRectView) {
        this.f7188de = autoScanRectView;
    }

    public void th(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "pic");
        String fe2 = de.fe(file.getAbsolutePath(), de.de(this.qw));
        fe.vvv.qw.xxx.ad pictureSize = this.f7187ad.getPictureSize();
        if (pictureSize == null) {
            pictureSize = new fe.vvv.qw.xxx.ad(4500, 4500);
        }
        fe.mmm.qw.h.fe.qw.fe(file.getAbsolutePath(), fe2, pictureSize.rg(), pictureSize.fe(), new ad(this));
    }

    public void uk() {
        IOCRTakePhotoControl.qw.qw(this);
    }

    @Nullable
    public final AutoScanRectView vvv() {
        return this.f7188de;
    }

    public final File when() {
        File file = new File(BaseApplication.getInstance().getCacheDir(), "auto_scan_file_dir");
        if (!file.exists()) {
            file.mkdirs();
        }
        LoggerKt.d$default("getAutoScanFile  = " + file.getAbsolutePath() + Ascii.CASE_MASK, (Object) null, 1, (Object) null);
        return new File(file, "auto_scan_file.jpeg");
    }

    @NotNull
    public final OCRTakePhotoViewModel xxx() {
        return (OCRTakePhotoViewModel) this.f7191th.getValue();
    }

    @NotNull
    public List<String> yj() {
        return IOCRTakePhotoControl.qw.rg(this);
    }
}
