package com.tera.scan.scanner.ocr.qrscan;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.Image;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.baidu.aiscan.R;
import com.google.zxing.BarcodeFormat;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoView;
import com.tera.scan.scanner.ocr.decode.ScannerCallback;
import com.tera.scan.scanner.ocr.decode.ScannerHandler;
import com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel;
import com.tera.scan.scanner.ui.cameranew.ScanRectView;
import com.tera.scan.ui.lottie.NetdiskLottieView;
import com.tera.scan.ui.view.widget.UITextView;
import fe.mmm.qw.th.qw.rg.fe.de.qw;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.tt.ad.ddd.de;
import fe.mmm.qw.tt.ad.ddd.fe;
import fe.mmm.qw.tt.ad.ddd.rg;
import fe.vvv.qw.xxx.ad;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u000208H\u0002J\u0012\u0010:\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\u0006H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\b\u0010A\u001a\u000208H\u0002J\"\u0010B\u001a\u0002082\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u000208H\u0016J\u0010\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020JH\u0016J \u0010K\u001a\u0002082\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0006H\u0016J\u0010\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u000208H\u0016J\b\u0010T\u001a\u000208H\u0016J\b\u0010U\u001a\u000208H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8@X\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u001b\u00102\u001a\u0002038BX\u0002¢\u0006\f\n\u0004\b6\u0010/\u001a\u0004\b4\u00105¨\u0006V"}, d2 = {"Lcom/tera/scan/scanner/ocr/qrscan/OcrScannerControl;", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoControl;", "Lcom/tera/scan/scanner/ocr/decode/ScannerCallback;", "activity", "Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;", "from", "", "crTakePhotoView", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "(Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;ILcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;)V", "ocrTakePhotoView", "(Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;)V", "container", "Landroidx/constraintlayout/widget/ConstraintLayout;", "gallery", "Landroid/widget/TextView;", "inAnim", "Landroid/view/animation/Animation;", "getInAnim", "()Landroid/view/animation/Animation;", "setInAnim", "(Landroid/view/animation/Animation;)V", "isNeedNext", "", "localPath", "", "outAnim", "getOutAnim", "setOutAnim", "progressLottie", "Lcom/tera/scan/ui/lottie/NetdiskLottieView;", "qrcodeResultClose", "Landroid/view/View;", "qrcodeResultContent", "qrcodeResultCopy", "qrcodeResultLayout", "scanHandler", "Lcom/tera/scan/scanner/ocr/decode/ScannerHandler;", "scanRect", "Lcom/tera/scan/scanner/ui/cameranew/ScanRectView;", "takePhoto", "Landroid/widget/ImageView;", "takePhotoViewModel", "Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "getTakePhotoViewModel$scanner_aiscanConfigRelease", "()Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "takePhotoViewModel$delegate", "Lkotlin/Lazy;", "tip", "Lcom/tera/scan/ui/view/widget/UITextView;", "viewModel", "Lcom/tera/scan/scanner/ocr/qrscan/QrScanViewModel;", "getViewModel", "()Lcom/tera/scan/scanner/ocr/qrscan/QrScanViewModel;", "viewModel$delegate", "cancelLottie", "", "copyQRResult", "decodeSuccess", "result", "Lcom/google/zxing/Result;", "getPreviewRect", "Landroid/graphics/Rect;", "getRootViewHeight", "getRootViewWidth", "initObserver", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onInitView", "view", "Landroid/app/Activity;", "onPicturePreview", "frame", "Lcom/otaliastudios/cameraview/frame/Frame;", "cameraViewWidth", "cameraViewHeight", "onPictureTake", "pic", "Ljava/io/File;", "onSelect", "onUnSelect", "startLottie", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("OcrScannerControl")
public final class OcrScannerControl implements IOCRTakePhotoControl, ScannerCallback {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final IOCRTakePhotoView f7277ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Lazy f7278de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public ScannerHandler f7279fe;
    @NotNull
    public final Lazy ggg;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public ImageView f7280i;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public TextView f310if;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public NetdiskLottieView f7281o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public View f7282pf;
    public boolean ppp;
    @NotNull
    public final OCRTakePhotoActivity qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public ConstraintLayout f7283rg;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public View f311switch;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public ScanRectView f7284th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public UITextView f7285uk;
    @Nullable
    public Animation vvv;
    @Nullable
    public View when;
    @Nullable
    public Animation xxx;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public TextView f7286yj;

    public OcrScannerControl(@NotNull OCRTakePhotoActivity oCRTakePhotoActivity, @NotNull IOCRTakePhotoView iOCRTakePhotoView) {
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(iOCRTakePhotoView, "ocrTakePhotoView");
        this.qw = oCRTakePhotoActivity;
        this.f7277ad = iOCRTakePhotoView;
        this.f7278de = LazyKt__LazyJVMKt.lazy(new OcrScannerControl$viewModel$2(this));
        xxx(this.qw);
        ggg();
        this.ppp = true;
        this.ggg = LazyKt__LazyJVMKt.lazy(new OcrScannerControl$takePhotoViewModel$2(this));
    }

    public static final void aaa(OcrScannerControl ocrScannerControl, View view) {
        Intrinsics.checkNotNullParameter(ocrScannerControl, "this$0");
        View view2 = ocrScannerControl.f7282pf;
        if (view2 != null) {
            qw.qw(view2);
        }
    }

    public static final void ddd(OcrScannerControl ocrScannerControl, View view) {
        Intrinsics.checkNotNullParameter(ocrScannerControl, "this$0");
        LocalImageSelectActivity.qw.fe(LocalImageSelectActivity.Companion, ocrScannerControl.qw, 1, 3000, 1, 0, ocrScannerControl.when().getUbcSource$scanner_aiscanConfigRelease(), 16, (Object) null);
        fe.mmm.qw.ggg.qw.qw.qw("take_pictures_page_import_photos_click", CollectionsKt__CollectionsJVMKt.listOf(fe.mmm.qw.tt.ad.nn.qw.fe(ocrScannerControl.qw.getCurrentTab())));
    }

    public static final void mmm(OcrScannerControl ocrScannerControl, View view) {
        Intrinsics.checkNotNullParameter(ocrScannerControl, "this$0");
        ocrScannerControl.m910switch();
    }

    public static final void nn(OcrScannerControl ocrScannerControl, View view) {
        Intrinsics.checkNotNullParameter(ocrScannerControl, "this$0");
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "ts_qr_result_click", (List) null, 2, (Object) null);
        TextView textView = ocrScannerControl.f310if;
        CharSequence text = textView != null ? textView.getText() : null;
        if (!(text == null || text.length() == 0)) {
            if (StringsKt__StringsKt.startsWith$default(text, (CharSequence) "https://", false, 2, (Object) null) || StringsKt__StringsKt.startsWith$default(text, (CharSequence) "http://", false, 2, (Object) null)) {
                try {
                    Result.Companion companion = Result.Companion;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(text.toString()));
                    intent.putExtra("com.android.browser.application_id", ocrScannerControl.qw.getPackageName());
                    ocrScannerControl.qw.startActivity(intent);
                    Result.m1155constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m1155constructorimpl(ResultKt.createFailure(th2));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if ((r0.length() == 0) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void vvv(com.tera.scan.scanner.ocr.qrscan.OcrScannerControl r2, fe.mmm.qw.tt.ad.xxx.qw r3) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.google.zxing.Result r0 = r3.ad()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getText()
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 == 0) goto L_0x001e
            int r1 = r0.length()
            if (r1 != 0) goto L_0x001b
            r1 = 1
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            if (r1 == 0) goto L_0x002a
        L_0x001e:
            boolean r3 = r3.qw()
            if (r3 == 0) goto L_0x002a
            r3 = 2131886393(0x7f120139, float:1.9407364E38)
            fe.mmm.qw.th.qw.th.o.rg(r3)
        L_0x002a:
            if (r0 != 0) goto L_0x002d
            return
        L_0x002d:
            android.view.View r3 = r2.f7282pf
            if (r3 == 0) goto L_0x0034
            fe.mmm.qw.th.qw.rg.fe.de.qw.fe(r3)
        L_0x0034:
            android.widget.TextView r2 = r2.f310if
            if (r2 != 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            r2.setText(r0)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.qrscan.OcrScannerControl.vvv(com.tera.scan.scanner.ocr.qrscan.OcrScannerControl, fe.mmm.qw.tt.ad.xxx.qw):void");
    }

    public void ad() {
        ConstraintLayout constraintLayout = this.f7283rg;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        TextView textView = this.f7286yj;
        if (textView != null) {
            textView.setVisibility(0);
        }
        ImageView imageView = this.f7280i;
        if (imageView != null) {
            imageView.setAlpha(0.4f);
        }
        ImageView imageView2 = this.f7280i;
        if (imageView2 != null) {
            imageView2.setEnabled(false);
        }
        UITextView uITextView = this.f7285uk;
        if (uITextView != null) {
            uITextView.setVisibility(0);
        }
        UITextView uITextView2 = this.f7285uk;
        if (uITextView2 != null) {
            uITextView2.setText(this.qw.getResources().getString(R.string.change_tab_to_qrcode));
        }
        OCRTakePhotoActivity oCRTakePhotoActivity = this.qw;
        if (!(oCRTakePhotoActivity instanceof OCRTakePhotoActivity)) {
            oCRTakePhotoActivity = null;
        }
        if (oCRTakePhotoActivity != null) {
            oCRTakePhotoActivity.hideTipView();
        }
        qqq();
        this.f7277ad.setCarmeSize(-2);
        this.f7277ad.setZoom(0.15f);
        if (this.vvv == null) {
            this.vvv = AnimationUtils.loadAnimation(this.qw, R.anim.anim_scan_record_translate);
        }
        if (this.xxx == null) {
            this.xxx = AnimationUtils.loadAnimation(this.qw, R.anim.anim_scan_record_alpha);
        }
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "ts_qr_result_show", (List) null, 2, (Object) null);
        fe.mmm.qw.tt.fe.qw.ad("CameraPage", "CameraPage", (String) null, when().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", "code")), 4, (Object) null);
    }

    public void de() {
        ConstraintLayout constraintLayout = this.f7283rg;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        TextView textView = this.f7286yj;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f7280i;
        if (imageView != null) {
            imageView.setEnabled(true);
        }
        ImageView imageView2 = this.f7280i;
        if (imageView2 != null) {
            imageView2.setAlpha(1.0f);
        }
        UITextView uITextView = this.f7285uk;
        if (uITextView != null) {
            uITextView.setVisibility(8);
        }
        m909if();
        this.f7277ad.setZoom(0.0f);
    }

    public void fe(@NotNull ad adVar) {
        IOCRTakePhotoControl.qw.ad(this, adVar);
    }

    @Nullable
    public Rect getPreviewRect() {
        RectF scanRect;
        Rect rect = null;
        if (this.f7283rg == null) {
            return null;
        }
        ScanRectView scanRectView = this.f7284th;
        if (!(scanRectView == null || (scanRect = scanRectView.getScanRect()) == null)) {
            rect = new Rect();
            scanRect.roundOut(rect);
        }
        int i2 = 0;
        int i3 = rect != null ? rect.left : 0;
        if (rect != null) {
            i2 = rect.top;
        }
        return new Rect(i3, i2, rect != null ? rect.right : o(), rect != null ? rect.bottom : rg());
    }

    public final void ggg() {
        ppp().getDecodeResult().observe(this.qw, new fe.mmm.qw.tt.ad.ddd.ad(this));
    }

    public void i(@Nullable com.google.zxing.Result result) {
        BarcodeFormat barcodeFormat;
        StringBuilder sb = new StringBuilder();
        sb.append("decodeSuccess decodeResult: ");
        sb.append(result != null ? result.getText() : null);
        sb.append(", resultType: ");
        sb.append((result == null || (barcodeFormat = result.getBarcodeFormat()) == null) ? null : barcodeFormat.name());
        LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
        if (!this.qw.isFinishing() && !this.qw.isDestroying() && this.ppp && result != null && !TextUtils.isEmpty(result.getText())) {
            ppp().getDecodeResult().postValue(new fe.mmm.qw.tt.ad.xxx.qw(result, false));
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m909if() {
        NetdiskLottieView netdiskLottieView = this.f7281o;
        if (netdiskLottieView != null && netdiskLottieView.isAnimating()) {
            netdiskLottieView.cancelAnimation();
            netdiskLottieView.setVisibility(4);
        }
    }

    public int o() {
        ConstraintLayout constraintLayout = this.f7283rg;
        if (constraintLayout != null) {
            return constraintLayout.getWidth();
        }
        return 0;
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        String str;
        if (i2 == 1 && i3 == -1) {
            ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("extra_result_files") : null;
            if (stringArrayListExtra != null && (str = (String) CollectionsKt___CollectionsKt.firstOrNull(stringArrayListExtra)) != null) {
                ppp().decodeLocalImage(this.qw, str);
            }
        }
    }

    public void onDestroy() {
        ScannerHandler scannerHandler = this.f7279fe;
        if (scannerHandler != null) {
            scannerHandler.ad();
        }
    }

    public void onResume() {
        IOCRTakePhotoControl.qw.de(this);
    }

    public void onStop() {
        IOCRTakePhotoControl.qw.fe(this);
    }

    public final QrScanViewModel ppp() {
        return (QrScanViewModel) this.f7278de.getValue();
    }

    public final void qqq() {
        NetdiskLottieView netdiskLottieView = this.f7281o;
        if (netdiskLottieView != null) {
            if (netdiskLottieView.isAnimating()) {
                netdiskLottieView.cancelAnimation();
            }
            netdiskLottieView.setAnimation("ocr/ocr_image_to_word_progress.json");
            netdiskLottieView.setImageAssetsFolder("ocr/");
            netdiskLottieView.setVisibility(0);
            netdiskLottieView.loop(true);
            netdiskLottieView.playAnimation();
        }
    }

    public void qw(@NotNull fe.vvv.qw.o.qw qwVar, int i2, int i3) {
        ByteBuffer buffer;
        Intrinsics.checkNotNullParameter(qwVar, "frame");
        if (this.f7284th != null && this.ppp) {
            int rg2 = qwVar.th().rg();
            int fe2 = qwVar.th().fe();
            if (rg2 > 0 && fe2 > 0) {
                if (qwVar.fe() == 17 && Intrinsics.areEqual((Object) qwVar.de(), (Object) byte[].class)) {
                    ScannerHandler scannerHandler = this.f7279fe;
                    if (scannerHandler != null) {
                        scannerHandler.qw((byte[]) qwVar.ad(), rg2, fe2);
                    }
                } else if (Intrinsics.areEqual((Object) qwVar.de(), (Object) Image.class) && (buffer = ((Image) qwVar.ad()).getPlanes()[0].getBuffer()) != null) {
                    byte[] bArr = new byte[buffer.remaining()];
                    buffer.get(bArr);
                    ScannerHandler scannerHandler2 = this.f7279fe;
                    if (scannerHandler2 != null) {
                        scannerHandler2.qw(bArr, rg2, fe2);
                    }
                }
            }
        }
    }

    public int rg() {
        ConstraintLayout constraintLayout = this.f7283rg;
        if (constraintLayout != null) {
            return constraintLayout.getHeight();
        }
        return 0;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m910switch() {
        CharSequence text;
        String str = null;
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "ts_qr_result_copy", (List) null, 2, (Object) null);
        TextView textView = this.f310if;
        if (!(textView == null || (text = textView.getText()) == null)) {
            str = text.toString();
        }
        if (str != null) {
            Context applicationContext = this.qw.getApplicationContext();
            ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(applicationContext, ClipboardManager.class);
            ClipData newUri = ClipData.newUri(applicationContext.getContentResolver(), str, Uri.parse(str));
            Intrinsics.checkNotNullExpressionValue(newUri, "newUri(context.contentRe…r, text, Uri.parse(text))");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newUri);
            }
            o.rg(R.string.copy_link_success);
        }
    }

    public void th(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "pic");
    }

    public void uk() {
        IOCRTakePhotoControl.qw.qw(this);
    }

    @NotNull
    public final OCRTakePhotoViewModel when() {
        return (OCRTakePhotoViewModel) this.ggg.getValue();
    }

    public void xxx(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        this.f7283rg = (ConstraintLayout) activity.findViewById(R.id.scan_qr_code_container);
        this.f7284th = (ScanRectView) activity.findViewById(R.id.scan_rect);
        TextView textView = (TextView) activity.findViewById(R.id.qr_code_gallery);
        this.f7286yj = textView;
        if (textView != null) {
            textView.setOnClickListener(new de(this));
        }
        this.f7285uk = (UITextView) activity.findViewById(R.id.take_photo_tip_scanner);
        this.f7280i = (ImageView) activity.findViewById(R.id.take_photo_button);
        this.f7281o = (NetdiskLottieView) activity.findViewById(R.id.ocr_progress_lottie);
        this.f7279fe = new ScannerHandler(this);
        this.f7282pf = activity.findViewById(R.id.qrcode_content_layout);
        TextView textView2 = (TextView) activity.findViewById(R.id.qrcode_result_content);
        this.f310if = textView2;
        if (textView2 != null) {
            textView2.setLinksClickable(false);
        }
        TextView textView3 = this.f310if;
        if (textView3 != null) {
            textView3.setOnClickListener(new fe.mmm.qw.tt.ad.ddd.qw(this));
        }
        View findViewById = activity.findViewById(R.id.qrcode_result_copy);
        this.f311switch = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new fe(this));
        }
        View findViewById2 = activity.findViewById(R.id.qrcode_result_close);
        this.when = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new rg(this));
        }
    }

    @NotNull
    public List<String> yj() {
        return IOCRTakePhotoControl.qw.rg(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OcrScannerControl(@NotNull OCRTakePhotoActivity oCRTakePhotoActivity, int i2, @NotNull IOCRTakePhotoView iOCRTakePhotoView) {
        this(oCRTakePhotoActivity, iOCRTakePhotoView);
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(iOCRTakePhotoView, "crTakePhotoView");
    }
}
