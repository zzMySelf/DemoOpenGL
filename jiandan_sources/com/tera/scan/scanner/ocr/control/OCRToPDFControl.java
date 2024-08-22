package com.tera.scan.scanner.ocr.control;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.model.CropInfo;
import com.tera.scan.model.ImageCropPredictor;
import com.tera.scan.model.PointInfo;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import com.tera.scan.scanner.ocr.extension.ImageViewKt;
import com.tera.scan.scanner.ui.cameranew.AutoScanRectView;
import com.terascan.algo.Point;
import fe.ggg.ad.qw.fe.ad.de;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.th.qw.th.pf;
import fe.mmm.qw.tt.ad.when.a;
import fe.mmm.qw.tt.ad.when.b;
import fe.mmm.qw.tt.ad.when.ddd;
import fe.rg.qw.o.fe.yj;
import fe.rg.qw.rg;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002Bq\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\u0010\u0013J\u001c\u0010Q\u001a\u00020R2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016Jf\u0010T\u001a\u00020R2\u0006\u0010U\u001a\u00020\u00102\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2D\u0010Y\u001a@\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020R0ZH\u0002J.\u0010_\u001a\u00020`2\u0006\u0010U\u001a\u00020\u00102\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020b0\u000eH\u0002J&\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010d\u001a\u00020`2\b\b\u0002\u0010e\u001a\u00020fH\u0002J\b\u0010g\u001a\u00020RH\u0016J\u0010\u0010h\u001a\u00020R2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020\u0006H\u0016J(\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e2\u0018\u0010m\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eH\u0002J\u0010\u0010n\u001a\u00020R2\u0006\u0010i\u001a\u00020jH\u0016J\"\u0010o\u001a\u00020R2\u0006\u0010p\u001a\u00020\u00062\u0006\u0010q\u001a\u00020\u00062\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\b\u0010t\u001a\u00020RH\u0016J\b\u0010u\u001a\u00020RH\u0016J\u0010\u0010v\u001a\u00020R2\u0006\u0010i\u001a\u00020jH\u0016J\u0018\u0010w\u001a\u00020R2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020\u0010H\u0016J\u0016\u0010{\u001a\u00020R2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00100\u000eH\u0016J\"\u0010}\u001a\u00020R2\u0018\u0010~\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eH\u0016J\u0018\u0010\u001a\u00020R2\u000e\u0010~\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0016J\t\u0010\u0001\u001a\u00020RH\u0016J*\u0010\u0001\u001a\u00020R2\b\u0010\u0001\u001a\u00030\u00012\u0015\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u0002J\t\u0010\u0001\u001a\u00020RH\u0016J$\u0010\u0001\u001a\u00020R2\u0019\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eH\u0016J\t\u0010\u0001\u001a\u00020RH\u0002J\u0010\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00100\u0001H\u0016J\t\u0010\u0001\u001a\u00020RH\u0016J\u0012\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020fH\u0002J,\u0010\u0001\u001a\u00020R2\b\u0010]\u001a\u0004\u0018\u00010\u00102\u0007\u0010\u0001\u001a\u00020\u00102\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020R0\u0001H\u0002J\t\u0010\u0001\u001a\u00020\u0006H\u0016J\t\u0010\u0001\u001a\u00020RH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0017R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010.\"\u0004\b:\u00100R\u001c\u0010;\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u001c\u0010>\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010.\"\u0004\b@\u00100R\u001c\u0010A\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010.\"\u0004\bC\u00100R&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010ER\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0017R\u001c\u0010K\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010$\"\u0004\bM\u0010&R\u001c\u0010N\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00105\"\u0004\bP\u00107¨\u0006\u0001"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/OCRToPDFControl;", "Lcom/tera/scan/scanner/ocr/control/OCRAutoScanControl;", "Lcom/tera/scan/scanner/ocr/control/IPrepareProcessing;", "activity", "Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;", "pdfMode", "", "reChoosePage", "addCount", "from", "ocrTakePhotoView", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "category", "images", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "", "", "ocrResultDataList", "(Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;IIIILcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;ILjava/util/ArrayList;Ljava/util/ArrayList;)V", "getActivity", "()Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;", "getAddCount", "()I", "bgEdgeImage", "Landroid/widget/FrameLayout;", "getBgEdgeImage", "()Landroid/widget/FrameLayout;", "setBgEdgeImage", "(Landroid/widget/FrameLayout;)V", "btnClick", "Lcom/tera/scan/widget/ButtonClickCtrlUtil;", "getCategory", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "docScanFilterIndex", "getDocScanFilterIndex", "setDocScanFilterIndex", "(I)V", "edgeImage", "Landroid/widget/ImageView;", "getEdgeImage", "()Landroid/widget/ImageView;", "setEdgeImage", "(Landroid/widget/ImageView;)V", "getFrom", "gallery", "Landroid/widget/TextView;", "getGallery", "()Landroid/widget/TextView;", "setGallery", "(Landroid/widget/TextView;)V", "image", "getImage", "setImage", "imageBadge", "getImageBadge", "setImageBadge", "imagePreview", "getImagePreview", "setImagePreview", "imageToPdfImageRight", "getImageToPdfImageRight", "setImageToPdfImageRight", "getImages$scanner_aiscanConfigRelease", "()Ljava/util/ArrayList;", "getOcrResultDataList", "getOcrTakePhotoView", "()Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "getPdfMode", "getReChoosePage", "takePhotoButtonView", "getTakePhotoButtonView", "setTakePhotoButtonView", "tip", "getTip", "setTip", "addPreProcessingTask", "", "task", "autoCrop", "sourcePath", "width", "", "height", "cropCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cropDestPathStr", "cropInfo", "buildCropInfo", "Lcom/tera/scan/model/CropInfo;", "points", "Lcom/terascan/algo/Point;", "cropInfoToMap", "info", "nullPoints", "", "enterTakeMode", "findViews", "view", "Landroid/app/Activity;", "getMaxCount", "getPictures", "mapList", "initOnClickListener", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClear", "onDoneViewClick", "onInitView", "onPictureTake", "bitmap", "Landroid/graphics/Bitmap;", "outPutPath", "onReqGalleryOkBusiness", "destPathList", "onResult", "path", "onResultForList", "onSelect", "onTakePhotoBusiness", "pic", "Ljava/io/File;", "map", "onUnSelect", "openImageProcessPage", "tokenImages", "pdfTabGalleryUbc", "pictures", "", "removePreProcessingTask", "setScanHistoryVisibility", "visible", "showCropPreview", "destPathStr", "onPreviewFinish", "Lkotlin/Function0;", "ubcTab", "updateView", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("OCRToPDFControl")
public class OCRToPDFControl extends OCRAutoScanControl implements IPrepareProcessing {
    @Nullable
    public View aaa;
    @Nullable
    public TextView ddd;
    @Nullable
    public ImageView eee;
    @Nullable
    public View ggg;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final OCRTakePhotoActivity f7204i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final IOCRTakePhotoView f300if;
    @Nullable
    public TextView mmm;
    @Nullable
    public ImageView nn;

    /* renamed from: o  reason: collision with root package name */
    public final int f7205o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f7206pf;
    @NotNull
    public final fe.mmm.qw.n.qw ppp;
    public int qqq;
    @Nullable
    public FrameLayout rrr;

    /* renamed from: switch  reason: not valid java name */
    public final int f301switch;
    @Nullable
    public ImageView tt;
    @Nullable
    public TextView vvv;
    @NotNull
    public final ArrayList<HashMap<String, Object>> when;
    @Nullable
    public ImageView xxx;

    public static final class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ OCRToPDFControl f7207ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f7208th;

        public ad(OCRToPDFControl oCRToPDFControl, Function0<Unit> function0) {
            this.f7207ad = oCRToPDFControl;
            this.f7208th = function0;
        }

        public final void run() {
            FrameLayout l = this.f7207ad.l();
            if (l != null) {
                l.setVisibility(8);
            }
            this.f7208th.invoke();
        }
    }

    public static final class qw extends TimerTask {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ OCRToPDFControl f7211ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Function0 f7212th;

        public qw(OCRToPDFControl oCRToPDFControl, Function0 function0) {
            this.f7211ad = oCRToPDFControl;
            this.f7212th = function0;
        }

        public void run() {
            this.f7211ad.k().runOnUiThread(new ad(this.f7211ad, this.f7212th));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OCRToPDFControl(com.tera.scan.scanner.ocr.OCRTakePhotoActivity r14, int r15, int r16, int r17, int r18, com.tera.scan.scanner.ocr.control.IOCRTakePhotoView r19, int r20, java.util.ArrayList r21, java.util.ArrayList r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = 0
            goto L_0x000a
        L_0x0009:
            r5 = r15
        L_0x000a:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0010
            r6 = 0
            goto L_0x0012
        L_0x0010:
            r6 = r16
        L_0x0012:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0018
            r7 = 0
            goto L_0x001a
        L_0x0018:
            r7 = r17
        L_0x001a:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0020
            r10 = 0
            goto L_0x0022
        L_0x0020:
            r10 = r20
        L_0x0022:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002d
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r11 = r1
            goto L_0x002f
        L_0x002d:
            r11 = r21
        L_0x002f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x003a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r12 = r0
            goto L_0x003c
        L_0x003a:
            r12 = r22
        L_0x003c:
            r3 = r13
            r4 = r14
            r8 = r18
            r9 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.control.OCRToPDFControl.<init>(com.tera.scan.scanner.ocr.OCRTakePhotoActivity, int, int, int, int, com.tera.scan.scanner.ocr.control.IOCRTakePhotoView, int, java.util.ArrayList, java.util.ArrayList, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static final void H(OCRToPDFControl oCRToPDFControl, String str) {
        Intrinsics.checkNotNullParameter(oCRToPDFControl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$url");
        ImageView imageView = oCRToPDFControl.tt;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = oCRToPDFControl.tt;
        if (imageView2 != null) {
            File file = new File(str);
            if (file.exists()) {
                Context context = oCRToPDFControl.f7204i.getContext();
                fe.rg.qw.when.ad yj2 = new fe.rg.qw.when.ad().E(true).yj(yj.qw);
                Intrinsics.checkNotNullExpressionValue(yj2, "RequestOptions()\n       …y(DiskCacheStrategy.NONE)");
                rg<Drawable> ppp2 = fe.rg.qw.ad.mmm(context).ppp(file);
                ppp2.de(yj2);
                ppp2.m317switch(imageView2);
            }
        }
    }

    public static final void e(Function2 function2, OCRToPDFControl oCRToPDFControl, CropInfo cropInfo, String str) {
        Intrinsics.checkNotNullParameter(function2, "$cropCallback");
        Intrinsics.checkNotNullParameter(oCRToPDFControl, "this$0");
        Intrinsics.checkNotNullParameter(cropInfo, "$cropInfo");
        function2.invoke(str, h(oCRToPDFControl, cropInfo, false, 2, (Object) null));
    }

    public static /* synthetic */ HashMap h(OCRToPDFControl oCRToPDFControl, CropInfo cropInfo, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return oCRToPDFControl.g(cropInfo, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cropInfoToMap");
    }

    public static final void v(OCRToPDFControl oCRToPDFControl, View view) {
        Intrinsics.checkNotNullParameter(oCRToPDFControl, "this$0");
        fe.vvv.qw.xxx.ad pictureSize = oCRToPDFControl.f300if.getPictureSize();
        if (pictureSize == null) {
            pictureSize = new fe.vvv.qw.xxx.ad(4500, 4500);
        }
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(pictureSize.rg(), pictureSize.fe());
        LocalImageSelectActivity.qw.fe(LocalImageSelectActivity.Companion, oCRToPDFControl.f7204i, oCRToPDFControl.s() - oCRToPDFControl.when.size(), coerceAtLeast, 1, 0, oCRToPDFControl.xxx().getUbcSource$scanner_aiscanConfigRelease(), 16, (Object) null);
        fe.mmm.qw.ggg.qw.qw.qw("take_pictures_page_import_photos_click", CollectionsKt__CollectionsJVMKt.listOf(fe.mmm.qw.tt.ad.nn.qw.fe(oCRToPDFControl.f7204i.getCurrentTab())));
        fe.mmm.qw.tt.fe.qw.ad("AlbumIn_clk", "CameraPage", (String) null, oCRToPDFControl.xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(oCRToPDFControl.f301switch))), 4, (Object) null);
        oCRToPDFControl.D();
    }

    public static final void w(OCRToPDFControl oCRToPDFControl, View view) {
        Intrinsics.checkNotNullParameter(oCRToPDFControl, "this$0");
        oCRToPDFControl.x();
    }

    public void A(@Nullable ArrayList<String> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("extra_result_files", arrayList);
        intent.putExtra(OCRTakePhotoActivity.EXTRA_RESULT_CATEGORY, this.f301switch);
        intent.putExtra("doc_scan_mode", xxx().autoScanSwitchValue());
        intent.putExtra("doc_scan_filter_index", this.qqq);
        this.f7204i.setResult(-1, intent);
        this.f7204i.finish();
    }

    public final void B(File file, HashMap<String, Object> hashMap) {
        if (this.f7205o == 1) {
            if (hashMap != null) {
                z(CollectionsKt__CollectionsKt.arrayListOf(hashMap));
            }
        } else if (xxx().isSingleMode() && hashMap != null) {
            C(CollectionsKt__CollectionsKt.arrayListOf(hashMap));
        } else if (this.when.size() >= s()) {
            View view = this.aaa;
            if (view != null) {
                view.setEnabled(true);
            }
        } else if (hashMap != null) {
            this.when.add(hashMap);
            c(hashMap);
            I();
            if (this.when.size() == 1) {
                ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "take_pictures_page_continue_shoot_show", (List) null, 2, (Object) null);
                o.yj(this.f7204i, fe.mmm.qw.p030switch.th.de.ad.ad.qw(R.string.multi_shooting_tip));
            }
        }
    }

    public void C(@NotNull ArrayList<HashMap<String, Object>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "tokenImages");
        String docSavePath = this.f7204i.getDocSavePath();
        if (docSavePath == null) {
            docSavePath = "";
        }
        new pf("doc_scan", new String[0]).qw();
        ArrayList<HashMap<String, Object>> arrayList2 = arrayList;
        new fe.mmm.qw.p024if.p025if.qw.qw().fe(this.f7204i, arrayList2, 14, this.f301switch, xxx().autoScanSwitchValue(), this.qqq, "", docSavePath, xxx().getUbcSource$scanner_aiscanConfigRelease());
        uk();
    }

    public final void D() {
    }

    public final void E(int i2) {
        this.qqq = i2;
    }

    public final void F(boolean z) {
    }

    public final void G(String str, String str2, Function0<Unit> function0) {
        LoggerKt.d("showPreViewCrop hash " + hashCode(), "OCRBottomTab");
        if (str == null) {
            str = str2;
        }
        this.f7204i.runOnUiThread(new b(this, str));
        new Timer().schedule(new qw(this, function0), 500);
    }

    public void I() {
        Object obj;
        if (this.f7205o == 1) {
            View view = this.aaa;
            if (view != null) {
                view.setEnabled(true);
            }
        } else if (!this.when.isEmpty()) {
            ImageView imageView = this.xxx;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.eee;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            HashMap hashMap = (HashMap) CollectionsKt___CollectionsKt.lastOrNull(this.when);
            Object obj2 = null;
            if (hashMap == null || (obj = hashMap.get("crop_path")) == null) {
                HashMap hashMap2 = (HashMap) CollectionsKt___CollectionsKt.lastOrNull(this.when);
                Object obj3 = hashMap2 != null ? hashMap2.get("source_path") : null;
                if (obj3 instanceof String) {
                    obj2 = (String) obj3;
                }
            } else {
                obj2 = obj;
            }
            ImageView imageView3 = this.xxx;
            if (obj2 == null || imageView3 == null) {
                TextView textView = this.ddd;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                ImageView imageView4 = this.nn;
                if (imageView4 != null) {
                    imageView4.setVisibility(0);
                }
                TextView textView2 = this.ddd;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(this.when.size()));
                }
                View view2 = this.aaa;
                if (view2 != null) {
                    view2.setEnabled(true);
                }
            } else if (!xxx().isAutoScanSwitchOpen()) {
                ImageViewKt.qw(this.eee, obj2.toString(), imageView3, new OCRToPDFControl$updateView$1(this, obj2, imageView3));
            } else {
                ImageViewKt.qw(this.tt, obj2.toString(), imageView3, new OCRToPDFControl$updateView$2(this, obj2, imageView3));
            }
            TextView textView3 = this.mmm;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        } else {
            F(true);
            ImageView imageView5 = this.xxx;
            if (imageView5 != null) {
                imageView5.setVisibility(4);
            }
            TextView textView4 = this.ddd;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            ImageView imageView6 = this.nn;
            if (imageView6 != null) {
                imageView6.setVisibility(8);
            }
            TextView textView5 = this.mmm;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            View view3 = this.aaa;
            if (view3 != null) {
                view3.setEnabled(true);
            }
        }
    }

    public void aaa(@NotNull Bitmap bitmap, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "outPutPath");
        LoggerKt.d("onPictureTake hash " + hashCode(), "OCRBottomTab");
        F(false);
        if (this.when.size() == s()) {
            View view = this.aaa;
            if (view != null) {
                view.setEnabled(true);
            }
            o.uk(this.f7204i.getString(R.string.max_picture_notice, new Object[]{String.valueOf(s())}));
            return;
        }
        super.aaa(bitmap, str);
        fe.mmm.qw.h.fe.qw.ad(bitmap, str, new OCRToPDFControl$onPictureTake$1(this, bitmap));
    }

    public void ad() {
        super.ad();
        View view = this.ggg;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.vvv;
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (this.f7205o != 1) {
            OCRTakePhotoActivity oCRTakePhotoActivity = this.f7204i;
            if (!(oCRTakePhotoActivity instanceof OCRTakePhotoActivity)) {
                oCRTakePhotoActivity = null;
            }
            if (oCRTakePhotoActivity != null) {
                oCRTakePhotoActivity.showTipView((int) R.string.change_tab_to_pdf);
            }
        }
        this.f300if.setCarmeSize(-2);
        View view2 = this.aaa;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        fe.mmm.qw.tt.fe.qw.ad("CameraPage", "CameraPage", (String) null, xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(this.f301switch))), 4, (Object) null);
    }

    public void c(@NotNull HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "task");
        if (this.f301switch == 0) {
            new fe.mmm.qw.p024if.p025if.qw.qw().qw(this.f7204i.getApplication(), CollectionsKt__CollectionsJVMKt.listOf(hashMap), this.f301switch);
        }
    }

    public final void d(String str, float f, float f2, Function2<? super String, ? super HashMap<String, Object>, Unit> function2) {
        ArrayList<Point> arrayList;
        ArrayList<Point> points;
        try {
            AutoScanRectView vvv2 = vvv();
            if (vvv2 == null || (arrayList = vvv2.getPoints()) == null) {
                arrayList = new ArrayList<>();
            }
            CropInfo f3 = f(str, f, f2, arrayList);
            AutoScanRectView vvv3 = vvv();
            boolean z = false;
            if ((vvv3 != null ? vvv3.getPoints() : null) != null) {
                AutoScanRectView vvv4 = vvv();
                if (!((vvv4 == null || (points = vvv4.getPoints()) == null || points.size() != 0) ? false : true)) {
                    if (f * ((float) 4) == f2 * ((float) 3)) {
                        z = true;
                    }
                    if (!z) {
                        function2.invoke(str, g(f3, true));
                    } else {
                        ImageCropPredictor.f7026o.qw().vvv(this.f7204i, f3, new fe.mmm.qw.tt.ad.when.qw(function2, this, f3));
                    }
                    ExpectKt.success(Unit.INSTANCE);
                }
            }
            function2.invoke(str, h(this, f3, false, 2, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
    }

    public void de() {
        super.de();
        View view = this.ggg;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView = this.ddd;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.ddd;
        if (textView2 != null) {
            textView2.setText((CharSequence) null);
        }
        ImageView imageView = this.eee;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.nn;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        TextView textView3 = this.vvv;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    public final CropInfo f(String str, float f, float f2, ArrayList<Point> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        float rg2 = f / ((float) fe.mmm.qw.p030switch.th.de.ad.qw.rg());
        for (Point point : arrayList) {
            arrayList2.add(new PointInfo(point.getX() * rg2, point.getY() * rg2));
        }
        File file = new File(str);
        return new CropInfo(file.getParent() + "/crop_" + file.getName(), arrayList2, 0, str, f, f2);
    }

    public final HashMap<String, Object> g(CropInfo cropInfo, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("source_path", cropInfo.getSrc());
        if (cropInfo.getPoints().isEmpty() || z) {
            return hashMap;
        }
        hashMap.put("crop_path", cropInfo.getDest());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("top_left_x", Float.valueOf(cropInfo.getPoints().get(0).getDx()));
        hashMap2.put("top_left_y", Float.valueOf(cropInfo.getPoints().get(0).getDy()));
        hashMap2.put("bottom_left_x", Float.valueOf(cropInfo.getPoints().get(1).getDx()));
        hashMap2.put("bottom_left_y", Float.valueOf(cropInfo.getPoints().get(1).getDy()));
        hashMap2.put("bottom_right_x", Float.valueOf(cropInfo.getPoints().get(2).getDx()));
        hashMap2.put("bottom_right_y", Float.valueOf(cropInfo.getPoints().get(2).getDy()));
        hashMap2.put("top_right_x", Float.valueOf(cropInfo.getPoints().get(3).getDx()));
        hashMap2.put("top_right_y", Float.valueOf(cropInfo.getPoints().get(3).getDy()));
        hashMap.put("points", hashMap2);
        hashMap.put("src_width", Float.valueOf(cropInfo.getWidth()));
        hashMap.put("src_height", Float.valueOf(cropInfo.getHeight()));
        return hashMap;
    }

    public void j(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        this.ggg = activity.findViewById(R.id.to_pdf_container);
        this.vvv = (TextView) activity.findViewById(R.id.to_pdf_gallery);
        rrr((AutoScanRectView) activity.findViewById(R.id.auto_scan_rect));
        ImageView imageView = (ImageView) activity.findViewById(R.id.to_pdf_image);
        this.xxx = imageView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        this.eee = (ImageView) activity.findViewById(R.id.taking_photo_preview);
        this.ddd = (TextView) activity.findViewById(R.id.to_pdf_image_badge);
        this.nn = (ImageView) activity.findViewById(R.id.iv_to_pdf_image_right);
        this.mmm = (TextView) activity.findViewById(R.id.take_photo_tip);
        this.aaa = activity.findViewById(R.id.take_photo_button);
        this.rrr = (FrameLayout) activity.findViewById(R.id.bg_to_take_shot_edge_image);
        this.tt = (ImageView) activity.findViewById(R.id.to_take_shot_edge_image);
    }

    @NotNull
    public final OCRTakePhotoActivity k() {
        return this.f7204i;
    }

    @Nullable
    public final FrameLayout l() {
        return this.rrr;
    }

    @Nullable
    public final ImageView m() {
        return this.tt;
    }

    public void mmm(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        super.mmm(activity);
        j(activity);
        u(activity);
        I();
    }

    @Nullable
    public final TextView n() {
        return this.ddd;
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        boolean z = true;
        if (i2 == 1 && i3 == -1) {
            ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("extra_result_files") : null;
            if (stringArrayListExtra == null || !(!stringArrayListExtra.isEmpty())) {
                z = false;
            }
            if (z) {
                y(stringArrayListExtra);
            }
        }
    }

    @Nullable
    public final ImageView p() {
        return this.eee;
    }

    @Nullable
    public final ImageView q() {
        return this.nn;
    }

    @NotNull
    public final ArrayList<HashMap<String, Object>> r() {
        return this.when;
    }

    public void rg() {
        if (this.f301switch == 0 && (!this.when.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.when);
            new fe.mmm.qw.p024if.p025if.qw.qw().uk(this.f7204i.getApplication(), arrayList);
        }
    }

    public int s() {
        int i2 = this.f7205o;
        if (i2 != 0) {
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return this.f7206pf;
            }
        }
        return 20;
    }

    @Nullable
    public final View t() {
        return this.aaa;
    }

    public void u(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        TextView textView = this.vvv;
        if (textView != null) {
            textView.setOnClickListener(new ddd(this));
        }
        ImageView imageView = this.xxx;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
        }
    }

    public void uk() {
        this.when.clear();
        I();
        xxx().setIsTakingMode(false);
    }

    public void x() {
        if (!this.ppp.qw()) {
            if (this.f7205o == 0) {
                C(this.when);
            } else {
                z(this.when);
            }
            fe.mmm.qw.tt.fe.qw.ad("CamD_clk", "CameraPage", (String) null, xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(this.f301switch)), TuplesKt.to("PicNum", Integer.valueOf(this.when.size()))), 4, (Object) null);
        }
    }

    public void y(@NotNull ArrayList<String> arrayList) {
        String docSavePath;
        Intrinsics.checkNotNullParameter(arrayList, "destPathList");
        if (this.f7205o != 0) {
            ArrayList<HashMap<String, Object>> arrayList2 = this.when;
            ArrayList arrayList3 = new ArrayList();
            for (HashMap hashMap : arrayList2) {
                Object obj = hashMap.get("source_path");
                String str = obj instanceof String ? (String) obj : null;
                if (str != null) {
                    arrayList3.add(str);
                }
            }
            arrayList.addAll(arrayList3);
            A(arrayList);
            return;
        }
        OCRTakePhotoActivity oCRTakePhotoActivity = this.f7204i;
        String str2 = "";
        if ((oCRTakePhotoActivity instanceof OCRTakePhotoActivity) && (docSavePath = oCRTakePhotoActivity.getDocSavePath()) != null) {
            str2 = docSavePath;
        }
        String str3 = str2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (String cropInfo : arrayList) {
            arrayList4.add(h(this, new CropInfo("", CollectionsKt__CollectionsKt.emptyList(), 0, cropInfo, 0.0f, 0.0f), false, 2, (Object) null));
        }
        ArrayList qw2 = de.qw(arrayList4);
        qw2.addAll(0, this.when);
        new pf("doc_scan", new String[0]).qw();
        new fe.mmm.qw.p024if.p025if.qw.qw().fe(this.f7204i, qw2, 14, this.f301switch, xxx().autoScanSwitchValue(), this.qqq, "", str3, xxx().getUbcSource$scanner_aiscanConfigRelease());
        uk();
    }

    @NotNull
    public List<String> yj() {
        String str;
        ArrayList<HashMap<String, Object>> arrayList = this.when;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (HashMap hashMap : arrayList) {
            String str2 = (String) hashMap.get("crop_path");
            if (str2 == null || str2.length() == 0) {
                str = String.valueOf(hashMap.get("source_path"));
            } else {
                str = String.valueOf(hashMap.get("crop_path"));
            }
            arrayList2.add(str);
        }
        return CollectionsKt___CollectionsKt.toList(arrayList2);
    }

    public void z(@NotNull ArrayList<HashMap<String, Object>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "path");
        Intent intent = new Intent();
        intent.putExtra("extra_result_files", arrayList);
        intent.putExtra(OCRTakePhotoActivity.EXTRA_RESULT_CATEGORY, this.f301switch);
        intent.putExtra("doc_scan_mode", xxx().autoScanSwitchValue());
        intent.putExtra("doc_scan_filter_index", this.qqq);
        this.f7204i.setResult(-1, intent);
        this.f7204i.finish();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRToPDFControl(@NotNull OCRTakePhotoActivity oCRTakePhotoActivity, int i2, int i3, int i4, int i5, @NotNull IOCRTakePhotoView iOCRTakePhotoView, int i6, @NotNull ArrayList<HashMap<String, Object>> arrayList, @NotNull ArrayList<String> arrayList2) {
        super(oCRTakePhotoActivity, iOCRTakePhotoView);
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(iOCRTakePhotoView, "ocrTakePhotoView");
        Intrinsics.checkNotNullParameter(arrayList, "images");
        Intrinsics.checkNotNullParameter(arrayList2, "ocrResultDataList");
        this.f7204i = oCRTakePhotoActivity;
        this.f7205o = i2;
        this.f7206pf = i4;
        this.f300if = iOCRTakePhotoView;
        this.f301switch = i6;
        this.when = arrayList;
        this.ppp = new fe.mmm.qw.n.qw();
        mmm(this.f7204i);
    }
}
