package com.tera.scan.scanner.ocr.control;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
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
import fe.mmm.qw.tt.ad.when.Cswitch;
import fe.mmm.qw.tt.ad.when.c;
import fe.mmm.qw.tt.ad.when.i;
import fe.mmm.qw.tt.ad.when.vvv;
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

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bq\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\u0010\u0013J\u001c\u0010+\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016Jf\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012D\u00103\u001a@\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020,04H\u0002J.\u00109\u001a\u00020:2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u000eH\u0002J&\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010>\u001a\u00020:2\b\b\u0002\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020,H\u0016J\u0010\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020\u0006H\u0002J(\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e2\u0018\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eH\u0002J\u0010\u0010H\u001a\u00020,2\u0006\u0010C\u001a\u00020DH\u0002J\"\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u00062\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020,H\u0016J\b\u0010O\u001a\u00020,H\u0002J\u0010\u0010P\u001a\u00020,2\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010Q\u001a\u00020,2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0010H\u0016J\u0016\u0010U\u001a\u00020,2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J\"\u0010W\u001a\u00020,2\u0018\u0010X\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eH\u0002J\u0018\u0010Y\u001a\u00020,2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0002J\b\u0010Z\u001a\u00020,H\u0016J&\u0010[\u001a\u00020,2\u0006\u0010\\\u001a\u00020]2\u0014\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u0002J\b\u0010_\u001a\u00020,H\u0016J\"\u0010`\u001a\u00020,2\u0018\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eH\u0002J\b\u0010b\u001a\u00020,H\u0002J\u000e\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00100dH\u0016J\b\u0010e\u001a\u00020,H\u0016J(\u0010f\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u00010\u00102\u0006\u0010g\u001a\u00020\u00102\f\u0010h\u001a\b\u0012\u0004\u0012\u00020,0iH\u0002J\b\u0010j\u001a\u00020,H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/OCRRemoveWatermarkControl;", "Lcom/tera/scan/scanner/ocr/control/OCRAutoScanControl;", "Lcom/tera/scan/scanner/ocr/control/IPrepareProcessing;", "activity", "Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;", "pdfMode", "", "reChoosePage", "addCount", "from", "ocrTakePhotoView", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "category", "images", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "", "", "ocrResultDataList", "(Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;IIIILcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;ILjava/util/ArrayList;Ljava/util/ArrayList;)V", "bgEdgeImage", "Landroid/widget/FrameLayout;", "btnClick", "Lcom/tera/scan/widget/ButtonClickCtrlUtil;", "container", "Landroid/view/View;", "docScanFilterIndex", "getDocScanFilterIndex$scanner_aiscanConfigRelease", "()I", "setDocScanFilterIndex$scanner_aiscanConfigRelease", "(I)V", "edgeImage", "Landroid/widget/ImageView;", "gallery", "Landroid/widget/TextView;", "image", "imageBadge", "imagePreview", "imageToPdfImageRight", "getImages$scanner_aiscanConfigRelease", "()Ljava/util/ArrayList;", "takePhotoButtonView", "tip", "addPreProcessingTask", "", "task", "autoCrop", "sourcePath", "width", "", "height", "cropCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cropDestPathStr", "cropInfo", "buildCropInfo", "Lcom/tera/scan/model/CropInfo;", "points", "Lcom/terascan/algo/Point;", "cropInfoToMap", "info", "nullPoints", "", "enterTakeMode", "findViews", "view", "Landroid/app/Activity;", "getMaxCount", "getPictures", "mapList", "initOnClickListener", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClear", "onDoneViewClick", "onInitView", "onPictureTake", "bitmap", "Landroid/graphics/Bitmap;", "outPutPath", "onReqGalleryOkBusiness", "destPathList", "onResult", "path", "onResultForList", "onSelect", "onTakePhotoBusiness", "pic", "Ljava/io/File;", "map", "onUnSelect", "openImageProcessPage", "tokenImages", "pdfTabGalleryUbc", "pictures", "", "removePreProcessingTask", "showCropPreview", "destPathStr", "onPreviewFinish", "Lkotlin/Function0;", "updateView", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("OCRRemoveWatermarkControl")
public final class OCRRemoveWatermarkControl extends OCRAutoScanControl implements IPrepareProcessing {
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
    public final OCRTakePhotoActivity f7195i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final IOCRTakePhotoView f298if;
    @Nullable
    public TextView mmm;
    @Nullable
    public ImageView nn;

    /* renamed from: o  reason: collision with root package name */
    public final int f7196o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f7197pf;
    @NotNull
    public final fe.mmm.qw.n.qw ppp;
    public int qqq;
    @Nullable
    public FrameLayout rrr;

    /* renamed from: switch  reason: not valid java name */
    public final int f299switch;
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
        public final /* synthetic */ OCRRemoveWatermarkControl f7198ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f7199th;

        public ad(OCRRemoveWatermarkControl oCRRemoveWatermarkControl, Function0<Unit> function0) {
            this.f7198ad = oCRRemoveWatermarkControl;
            this.f7199th = function0;
        }

        public final void run() {
            FrameLayout b = this.f7198ad.rrr;
            if (b != null) {
                b.setVisibility(8);
            }
            this.f7199th.invoke();
        }
    }

    public static final class qw extends TimerTask {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ OCRRemoveWatermarkControl f7202ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Function0 f7203th;

        public qw(OCRRemoveWatermarkControl oCRRemoveWatermarkControl, Function0 function0) {
            this.f7202ad = oCRRemoveWatermarkControl;
            this.f7203th = function0;
        }

        public void run() {
            this.f7202ad.f7195i.runOnUiThread(new ad(this.f7202ad, this.f7203th));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OCRRemoveWatermarkControl(com.tera.scan.scanner.ocr.OCRTakePhotoActivity r14, int r15, int r16, int r17, int r18, com.tera.scan.scanner.ocr.control.IOCRTakePhotoView r19, int r20, java.util.ArrayList r21, java.util.ArrayList r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
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
            if (r1 == 0) goto L_0x0023
            r1 = 15
            r10 = 15
            goto L_0x0025
        L_0x0023:
            r10 = r20
        L_0x0025:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0030
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r11 = r1
            goto L_0x0032
        L_0x0030:
            r11 = r21
        L_0x0032:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x003d
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r12 = r0
            goto L_0x003f
        L_0x003d:
            r12 = r22
        L_0x003f:
            r3 = r13
            r4 = r14
            r8 = r18
            r9 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.control.OCRRemoveWatermarkControl.<init>(com.tera.scan.scanner.ocr.OCRTakePhotoActivity, int, int, int, int, com.tera.scan.scanner.ocr.control.IOCRTakePhotoView, int, java.util.ArrayList, java.util.ArrayList, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static final void G(OCRRemoveWatermarkControl oCRRemoveWatermarkControl, String str) {
        Intrinsics.checkNotNullParameter(oCRRemoveWatermarkControl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$url");
        ImageView imageView = oCRRemoveWatermarkControl.tt;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = oCRRemoveWatermarkControl.tt;
        if (imageView2 != null) {
            File file = new File(str);
            if (file.exists()) {
                Context context = oCRRemoveWatermarkControl.f7195i.getContext();
                fe.rg.qw.when.ad yj2 = new fe.rg.qw.when.ad().E(true).yj(yj.qw);
                Intrinsics.checkNotNullExpressionValue(yj2, "RequestOptions()\n       …y(DiskCacheStrategy.NONE)");
                rg<Drawable> ppp2 = fe.rg.qw.ad.mmm(context).ppp(file);
                ppp2.de(yj2);
                ppp2.m317switch(imageView2);
            }
        }
    }

    public static final void m(Function2 function2, OCRRemoveWatermarkControl oCRRemoveWatermarkControl, CropInfo cropInfo, String str) {
        Intrinsics.checkNotNullParameter(function2, "$cropCallback");
        Intrinsics.checkNotNullParameter(oCRRemoveWatermarkControl, "this$0");
        Intrinsics.checkNotNullParameter(cropInfo, "$cropInfo");
        function2.invoke(str, q(oCRRemoveWatermarkControl, cropInfo, false, 2, (Object) null));
    }

    public static /* synthetic */ HashMap q(OCRRemoveWatermarkControl oCRRemoveWatermarkControl, CropInfo cropInfo, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return oCRRemoveWatermarkControl.p(cropInfo, z);
    }

    public static final void v(OCRRemoveWatermarkControl oCRRemoveWatermarkControl, View view) {
        Intrinsics.checkNotNullParameter(oCRRemoveWatermarkControl, "this$0");
        fe.vvv.qw.xxx.ad pictureSize = oCRRemoveWatermarkControl.f298if.getPictureSize();
        if (pictureSize == null) {
            pictureSize = new fe.vvv.qw.xxx.ad(4500, 4500);
        }
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(pictureSize.rg(), pictureSize.fe());
        LocalImageSelectActivity.qw.fe(LocalImageSelectActivity.Companion, oCRRemoveWatermarkControl.f7195i, oCRRemoveWatermarkControl.t() - oCRRemoveWatermarkControl.when.size(), coerceAtLeast, 1, 0, oCRRemoveWatermarkControl.xxx().getUbcSource$scanner_aiscanConfigRelease(), 16, (Object) null);
        fe.mmm.qw.ggg.qw.qw.qw("take_pictures_page_import_photos_click", CollectionsKt__CollectionsJVMKt.listOf(fe.mmm.qw.tt.ad.nn.qw.fe(oCRRemoveWatermarkControl.f7195i.getCurrentTab())));
        fe.mmm.qw.tt.fe.qw.ad("AlbumIn_clk", "CameraPage", (String) null, oCRRemoveWatermarkControl.xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(oCRRemoveWatermarkControl.f299switch))), 4, (Object) null);
        oCRRemoveWatermarkControl.D();
    }

    public static final void w(OCRRemoveWatermarkControl oCRRemoveWatermarkControl, View view) {
        Intrinsics.checkNotNullParameter(oCRRemoveWatermarkControl, "this$0");
        oCRRemoveWatermarkControl.x();
    }

    public final void A(ArrayList<String> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("extra_result_files", arrayList);
        intent.putExtra(OCRTakePhotoActivity.EXTRA_RESULT_CATEGORY, this.f299switch);
        intent.putExtra("doc_scan_mode", xxx().autoScanSwitchValue());
        intent.putExtra("doc_scan_filter_index", this.qqq);
        this.f7195i.setResult(-1, intent);
        this.f7195i.finish();
    }

    public final void B(File file, HashMap<String, Object> hashMap) {
        if (this.f7196o == 1) {
            if (hashMap != null) {
                z(CollectionsKt__CollectionsKt.arrayListOf(hashMap));
            }
        } else if (xxx().isSingleMode() && hashMap != null) {
            C(CollectionsKt__CollectionsKt.arrayListOf(hashMap));
        } else if (this.when.size() >= t()) {
            View view = this.aaa;
            if (view != null) {
                view.setEnabled(true);
            }
        } else if (hashMap != null) {
            this.when.add(hashMap);
            k(hashMap);
            H();
            if (this.when.size() == 1) {
                ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "take_pictures_page_continue_shoot_show", (List) null, 2, (Object) null);
                o.yj(this.f7195i, fe.mmm.qw.p030switch.th.de.ad.ad.qw(R.string.multi_shooting_tip));
            }
        }
    }

    public final void C(ArrayList<HashMap<String, Object>> arrayList) {
        String docSavePath = this.f7195i.getDocSavePath();
        if (docSavePath == null) {
            docSavePath = "";
        }
        new pf("doc_scan", new String[0]).qw();
        ArrayList<HashMap<String, Object>> arrayList2 = arrayList;
        new fe.mmm.qw.p024if.p025if.qw.qw().fe(this.f7195i, arrayList2, 14, this.f299switch, xxx().autoScanSwitchValue(), this.qqq, "", docSavePath, xxx().getUbcSource$scanner_aiscanConfigRelease());
        uk();
    }

    public final void D() {
    }

    public final void E(int i2) {
        this.qqq = i2;
    }

    public final void F(String str, String str2, Function0<Unit> function0) {
        LoggerKt.d("showPreViewCrop hash " + hashCode(), "OCRBottomTab");
        if (str == null) {
            str = str2;
        }
        this.f7195i.runOnUiThread(new vvv(this, str));
        new Timer().schedule(new qw(this, function0), 500);
    }

    public final void H() {
        Object obj;
        if (this.f7196o == 1) {
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
                ImageViewKt.qw(this.eee, obj2.toString(), imageView3, new OCRRemoveWatermarkControl$updateView$1(this, obj2, imageView3));
            } else {
                ImageViewKt.qw(this.tt, obj2.toString(), imageView3, new OCRRemoveWatermarkControl$updateView$2(this, obj2, imageView3));
            }
            TextView textView3 = this.mmm;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        } else {
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
        if (this.when.size() == t()) {
            View view = this.aaa;
            if (view != null) {
                view.setEnabled(true);
            }
            o.uk(this.f7195i.getString(R.string.max_picture_notice, new Object[]{String.valueOf(t())}));
            return;
        }
        super.aaa(bitmap, str);
        System.currentTimeMillis();
        fe.mmm.qw.h.fe.qw.ad(bitmap, str, new OCRRemoveWatermarkControl$onPictureTake$1(this, bitmap));
    }

    public void ad() {
        super.ad();
        mmm(this.f7195i);
        View view = this.ggg;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.vvv;
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (this.f7196o != 1) {
            OCRTakePhotoActivity oCRTakePhotoActivity = this.f7195i;
            if (!(oCRTakePhotoActivity instanceof OCRTakePhotoActivity)) {
                oCRTakePhotoActivity = null;
            }
            if (oCRTakePhotoActivity != null) {
                oCRTakePhotoActivity.showTipView((int) R.string.change_tab_to_remove_watermark);
            }
        }
        this.f298if.setCarmeSize(-2);
        View view2 = this.aaa;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        fe.mmm.qw.tt.fe.qw.ad("CameraPage", "CameraPage", (String) null, xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(this.f299switch))), 4, (Object) null);
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

    public void k(@NotNull HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "task");
        new fe.mmm.qw.p024if.p025if.qw.qw().qw(this.f7195i.getApplication(), CollectionsKt__CollectionsJVMKt.listOf(hashMap), this.f299switch);
    }

    public final void l(String str, float f, float f2, Function2<? super String, ? super HashMap<String, Object>, Unit> function2) {
        ArrayList<Point> arrayList;
        ArrayList<Point> points;
        LoggerKt.d("preViewCrop hash " + hashCode(), "OCRBottomTab");
        try {
            AutoScanRectView vvv2 = vvv();
            if (vvv2 == null || (arrayList = vvv2.getPoints()) == null) {
                arrayList = new ArrayList<>();
            }
            CropInfo n = n(str, f, f2, arrayList);
            AutoScanRectView vvv3 = vvv();
            boolean z = false;
            if ((vvv3 != null ? vvv3.getPoints() : null) != null) {
                AutoScanRectView vvv4 = vvv();
                if (!((vvv4 == null || (points = vvv4.getPoints()) == null || points.size() != 0) ? false : true)) {
                    if (f * ((float) 4) == f2 * ((float) 3)) {
                        z = true;
                    }
                    if (!z) {
                        function2.invoke(str, p(n, true));
                    } else {
                        ImageCropPredictor.f7026o.qw().vvv(this.f7195i, n, new c(function2, this, n));
                    }
                    ExpectKt.success(Unit.INSTANCE);
                }
            }
            function2.invoke(str, q(this, n, false, 2, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
    }

    public void mmm(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        super.mmm(activity);
        ViewStub viewStub = (ViewStub) activity.findViewById(R.id.stub_remove_watermark);
        if (viewStub != null) {
            viewStub.inflate();
            r(activity);
            u(activity);
            H();
        }
    }

    public final CropInfo n(String str, float f, float f2, ArrayList<Point> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        float rg2 = f / ((float) fe.mmm.qw.p030switch.th.de.ad.qw.rg());
        for (Point point : arrayList) {
            arrayList2.add(new PointInfo(point.getX() * rg2, point.getY() * rg2));
        }
        File file = new File(str);
        return new CropInfo(file.getParent() + "/crop_" + file.getName(), arrayList2, 0, str, f, f2);
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

    public final HashMap<String, Object> p(CropInfo cropInfo, boolean z) {
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

    public final void r(Activity activity) {
        this.ggg = activity.findViewById(R.id.remove_watermark_container);
        this.vvv = (TextView) activity.findViewById(R.id.remove_watermark_gallery);
        rrr((AutoScanRectView) activity.findViewById(R.id.remove_watermark_scan_rect));
        ImageView imageView = (ImageView) activity.findViewById(R.id.remove_watermark_image);
        this.xxx = imageView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        this.eee = (ImageView) activity.findViewById(R.id.taking_photo_preview);
        this.ddd = (TextView) activity.findViewById(R.id.remove_watermark_badge);
        this.nn = (ImageView) activity.findViewById(R.id.remove_watermark_right);
        this.mmm = (TextView) activity.findViewById(R.id.take_photo_tip);
        this.aaa = activity.findViewById(R.id.take_photo_button);
        this.rrr = (FrameLayout) activity.findViewById(R.id.bg_to_take_shot_edge_image);
        this.tt = (ImageView) activity.findViewById(R.id.to_take_shot_edge_image);
    }

    public void rg() {
        if (!this.when.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.when);
            new fe.mmm.qw.p024if.p025if.qw.qw().uk(this.f7195i.getApplication(), arrayList);
        }
    }

    @NotNull
    public final ArrayList<HashMap<String, Object>> s() {
        return this.when;
    }

    public final int t() {
        int i2 = this.f7196o;
        if (i2 != 0) {
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return this.f7197pf;
            }
        }
        return 20;
    }

    public final void u(Activity activity) {
        TextView textView = this.vvv;
        if (textView != null) {
            textView.setOnClickListener(new i(this));
        }
        ImageView imageView = this.xxx;
        if (imageView != null) {
            imageView.setOnClickListener(new Cswitch(this));
        }
    }

    public void uk() {
        this.when.clear();
        H();
        xxx().setIsTakingMode(false);
    }

    public final void x() {
        LoggerKt.d("onDoneViewClick hash " + hashCode(), "OCRBottomTab");
        if (!this.ppp.qw()) {
            if (this.f7196o == 0) {
                C(this.when);
            } else {
                z(this.when);
            }
            fe.mmm.qw.tt.fe.qw.ad("CamD_clk", "CameraPage", (String) null, xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(this.f299switch)), TuplesKt.to("PicNum", Integer.valueOf(this.when.size()))), 4, (Object) null);
        }
    }

    public final void y(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = arrayList;
        if (this.f7196o != 0) {
            ArrayList<HashMap<String, Object>> arrayList3 = this.when;
            ArrayList arrayList4 = new ArrayList();
            for (HashMap hashMap : arrayList3) {
                Object obj = hashMap.get("source_path");
                String str = obj instanceof String ? (String) obj : null;
                if (str != null) {
                    arrayList4.add(str);
                }
            }
            arrayList2.addAll(arrayList4);
            A(arrayList);
            return;
        }
        String docSavePath = this.f7195i.getDocSavePath();
        if (docSavePath == null) {
            docSavePath = "";
        }
        String str2 = docSavePath;
        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
        for (String cropInfo : arrayList) {
            arrayList5.add(q(this, new CropInfo("", CollectionsKt__CollectionsKt.emptyList(), 0, cropInfo, 0.0f, 0.0f), false, 2, (Object) null));
        }
        ArrayList qw2 = de.qw(arrayList5);
        qw2.addAll(0, this.when);
        new pf("doc_scan", new String[0]).qw();
        new fe.mmm.qw.p024if.p025if.qw.qw().fe(this.f7195i, qw2, 14, this.f299switch, xxx().autoScanSwitchValue(), this.qqq, "", str2, xxx().getUbcSource$scanner_aiscanConfigRelease());
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

    public final void z(ArrayList<HashMap<String, Object>> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("extra_result_files", arrayList);
        intent.putExtra(OCRTakePhotoActivity.EXTRA_RESULT_CATEGORY, this.f299switch);
        intent.putExtra("doc_scan_mode", xxx().autoScanSwitchValue());
        intent.putExtra("doc_scan_filter_index", this.qqq);
        this.f7195i.setResult(-1, intent);
        this.f7195i.finish();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRRemoveWatermarkControl(@NotNull OCRTakePhotoActivity oCRTakePhotoActivity, int i2, int i3, int i4, int i5, @NotNull IOCRTakePhotoView iOCRTakePhotoView, int i6, @NotNull ArrayList<HashMap<String, Object>> arrayList, @NotNull ArrayList<String> arrayList2) {
        super(oCRTakePhotoActivity, iOCRTakePhotoView);
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(iOCRTakePhotoView, "ocrTakePhotoView");
        Intrinsics.checkNotNullParameter(arrayList, "images");
        Intrinsics.checkNotNullParameter(arrayList2, "ocrResultDataList");
        this.f7195i = oCRTakePhotoActivity;
        this.f7196o = i2;
        this.f7197pf = i4;
        this.f298if = iOCRTakePhotoView;
        this.f299switch = i6;
        this.when = arrayList;
        this.ppp = new fe.mmm.qw.n.qw();
    }
}
