package com.tera.scan.scanner.ocr.control;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl;
import com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel;
import fe.mmm.qw.ggg.qw;
import fe.mmm.qw.tt.ad.when.xxx;
import fe.vvv.qw.xxx.ad;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\"\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016J \u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128@X\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/OCRToWordControl;", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoControl;", "activity", "Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;", "source", "", "ocrTakePhotoView", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "(Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;ILcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;)V", "container", "Landroid/view/View;", "gallery", "Landroid/widget/TextView;", "isFromGallery", "", "reportShowTag", "takePhotoButtonView", "takePhotoViewModel", "Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "getTakePhotoViewModel$scanner_aiscanConfigRelease", "()Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "takePhotoViewModel$delegate", "Lkotlin/Lazy;", "tip", "cropImage", "", "path", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onInitView", "view", "Landroid/app/Activity;", "onPicturePreview", "frame", "Lcom/otaliastudios/cameraview/frame/Frame;", "cameraViewWidth", "cameraViewHeight", "onPictureTake", "pic", "Ljava/io/File;", "onSelect", "onUnSelect", "setScanHistoryVisibility", "visible", "Companion", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRToWordControl implements IOCRTakePhotoControl {

    /* renamed from: ad  reason: collision with root package name */
    public final int f7222ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final IOCRTakePhotoView f7223de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f7224fe;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final Lazy f7225i = LazyKt__LazyJVMKt.lazy(new OCRToWordControl$takePhotoViewModel$2(this));
    @NotNull
    public final OCRTakePhotoActivity qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public View f7226rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public TextView f7227th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public View f7228uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public TextView f7229yj;

    public OCRToWordControl(@NotNull OCRTakePhotoActivity oCRTakePhotoActivity, int i2, @NotNull IOCRTakePhotoView iOCRTakePhotoView) {
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(iOCRTakePhotoView, "ocrTakePhotoView");
        this.qw = oCRTakePhotoActivity;
        this.f7222ad = i2;
        this.f7223de = iOCRTakePhotoView;
        pf(oCRTakePhotoActivity);
    }

    /* renamed from: if  reason: not valid java name */
    public static final void m902if(OCRToWordControl oCRToWordControl, View view) {
        Intrinsics.checkNotNullParameter(oCRToWordControl, "this$0");
        ad pictureSize = oCRToWordControl.f7223de.getPictureSize();
        if (pictureSize == null) {
            pictureSize = new ad(4500, 4500);
        }
        LocalImageSelectActivity.qw.fe(LocalImageSelectActivity.Companion, oCRToWordControl.qw, 1, RangesKt___RangesKt.coerceAtLeast(pictureSize.rg(), pictureSize.fe()), 1, 0, oCRToWordControl.o().getUbcSource$scanner_aiscanConfigRelease(), 16, (Object) null);
        qw.qw.qw("take_pictures_page_import_photos_click", CollectionsKt__CollectionsJVMKt.listOf(fe.mmm.qw.tt.ad.nn.qw.fe(oCRToWordControl.qw.getCurrentTab())));
    }

    public void ad() {
        View view = this.f7226rg;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.f7227th;
        if (textView != null) {
            textView.setVisibility(0);
        }
        OCRTakePhotoActivity oCRTakePhotoActivity = this.qw;
        if (!(oCRTakePhotoActivity instanceof OCRTakePhotoActivity)) {
            oCRTakePhotoActivity = null;
        }
        if (oCRTakePhotoActivity != null) {
            oCRTakePhotoActivity.showTipView((int) R.string.change_tab_to_ocr);
        }
        this.f7223de.setCarmeSize(-2);
        View view2 = this.f7228uk;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (this.f7222ad != 2 || this.f7224fe) {
            qw.qw.qw("ocr_scanning_page_show", CollectionsKt__CollectionsJVMKt.listOf("camera"));
        } else {
            this.f7224fe = true;
        }
        fe.mmm.qw.tt.fe.qw.ad("CameraPage", "CameraPage", (String) null, o().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(11))), 4, (Object) null);
    }

    public void de() {
        View view = this.f7226rg;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView = this.f7227th;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void fe(@NotNull ad adVar) {
        IOCRTakePhotoControl.qw.ad(this, adVar);
    }

    public final void i(String str) {
        String docSavePath;
        OCRTakePhotoActivity oCRTakePhotoActivity = this.qw;
        String str2 = "";
        if ((oCRTakePhotoActivity instanceof OCRTakePhotoActivity) && (docSavePath = oCRTakePhotoActivity.getDocSavePath()) != null) {
            str2 = docSavePath;
        }
        new fe.mmm.qw.p024if.p025if.qw.qw().ad(this.qw, str, 1, 11, 2, str2, o().getUbcSource$scanner_aiscanConfigRelease());
    }

    @NotNull
    public final OCRTakePhotoViewModel o() {
        return (OCRTakePhotoViewModel) this.f7225i.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r12, int r13, @org.jetbrains.annotations.Nullable android.content.Intent r14) {
        /*
            r11 = this;
            r0 = 1
            r1 = -1
            r2 = 0
            if (r12 == r0) goto L_0x006f
            r0 = 2
            if (r12 == r0) goto L_0x000a
            goto L_0x0089
        L_0x000a:
            if (r13 != r1) goto L_0x0089
            if (r14 == 0) goto L_0x0015
            java.lang.String r12 = "extra_file"
            java.lang.String r12 = r14.getStringExtra(r12)
            goto L_0x0016
        L_0x0015:
            r12 = r2
        L_0x0016:
            if (r14 == 0) goto L_0x001f
            java.lang.String r13 = "isConfirm"
            java.lang.String r13 = r14.getStringExtra(r13)
            goto L_0x0020
        L_0x001f:
            r13 = r2
        L_0x0020:
            java.lang.String r14 = "0"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x0029
            return
        L_0x0029:
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity r13 = r11.qw
            boolean r14 = r13 instanceof com.tera.scan.scanner.ocr.OCRTakePhotoActivity
            if (r14 == 0) goto L_0x0033
            java.lang.String r13 = r13.getDocSavePath()
        L_0x0033:
            if (r12 == 0) goto L_0x0064
            fe.mmm.qw.ggg.qw r13 = fe.mmm.qw.ggg.qw.qw
            java.lang.String r14 = "ocr_scanning_loading_page"
            com.tera.scan.libanalytics.ScanAnalyticsBaseEvent.qw.qw(r13, r14, r2, r0, r2)
            com.tera.scan.business.textrecognition.TextRecognitionActivity$qw r3 = com.tera.scan.business.textrecognition.TextRecognitionActivity.Companion
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity r13 = r11.qw
            android.content.Context r4 = r13.getContext()
            java.lang.String r13 = "activity.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r13)
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r12)
            r7 = 0
            com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel r12 = r11.o()
            java.lang.String r8 = r12.getUbcSource$scanner_aiscanConfigRelease()
            r9 = 8
            r10 = 0
            java.lang.String r6 = "text_ocr"
            android.content.Intent r12 = com.tera.scan.business.textrecognition.TextRecognitionActivity.qw.ad(r3, r4, r5, r6, r7, r8, r9, r10)
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity r13 = r11.qw
            r13.startActivity(r12)
        L_0x0064:
            int r12 = r11.f7222ad
            r13 = 6
            if (r12 != r13) goto L_0x0089
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity r12 = r11.qw
            r12.finish()
            goto L_0x0089
        L_0x006f:
            if (r13 != r1) goto L_0x0089
            if (r14 == 0) goto L_0x007a
            java.lang.String r12 = "extra_result_files"
            java.util.ArrayList r12 = r14.getStringArrayListExtra(r12)
            goto L_0x007b
        L_0x007a:
            r12 = r2
        L_0x007b:
            if (r12 == 0) goto L_0x0084
            java.lang.Object r12 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r12)
            r2 = r12
            java.lang.String r2 = (java.lang.String) r2
        L_0x0084:
            if (r2 == 0) goto L_0x0089
            r11.i(r2)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.control.OCRToWordControl.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onDestroy() {
        LoggerKt.d$default("enterDestroy", (Object) null, 1, (Object) null);
    }

    public void onResume() {
        IOCRTakePhotoControl.qw.de(this);
    }

    public void onStop() {
        IOCRTakePhotoControl.qw.fe(this);
    }

    public void pf(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        this.f7226rg = activity.findViewById(R.id.to_word_container);
        this.f7227th = (TextView) activity.findViewById(R.id.to_word_gallery);
        m903switch(false);
        this.f7229yj = (TextView) activity.findViewById(R.id.take_photo_tip);
        this.f7228uk = activity.findViewById(R.id.take_photo_button);
        TextView textView = this.f7227th;
        if (textView != null) {
            textView.setOnClickListener(new xxx(this));
        }
    }

    public void qw(@NotNull fe.vvv.qw.o.qw qwVar, int i2, int i3) {
        Intrinsics.checkNotNullParameter(qwVar, "frame");
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m903switch(boolean z) {
    }

    public void th(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "pic");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "pic.absolutePath");
        i(absolutePath);
    }

    public void uk() {
        IOCRTakePhotoControl.qw.qw(this);
    }

    @NotNull
    public List<String> yj() {
        return IOCRTakePhotoControl.qw.rg(this);
    }
}
