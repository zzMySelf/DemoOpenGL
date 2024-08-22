package com.tera.scan.scanner.ocr.control;

import android.app.Activity;
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
import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.model.CropInfo;
import com.tera.scan.model.ImageCropPredictor;
import com.tera.scan.model.PointInfo;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import com.tera.scan.scanner.ocr.extension.ImageViewKt;
import com.tera.scan.scanner.ui.cameranew.AutoScanRectView;
import com.terascan.algo.Point;
import fe.ggg.ad.qw.fe.ad.de;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.tt.ad.when.ggg;
import fe.mmm.qw.tt.ad.when.ppp;
import fe.mmm.qw.tt.ad.when.qqq;
import fe.rg.qw.o.fe.yj;
import fe.rg.qw.rg;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.LazyKt__LazyJVMKt;
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

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u001c\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*H\u0016Jf\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2D\u0010@\u001a@\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0004\u0012\u0002090AH\u0002J.\u0010F\u001a\u00020G2\u0006\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0)H\u0002J&\u0010J\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0006\u0010K\u001a\u00020G2\b\b\u0002\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u000209H\u0016J\b\u0010O\u001a\u00020\bH\u0002J\"\u0010P\u001a\u0002092\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\b2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010U\u001a\u000209H\u0016J\b\u0010V\u001a\u000209H\u0002J\u0010\u0010W\u001a\u0002092\u0006\u0010X\u001a\u00020YH\u0016J\u0018\u0010Z\u001a\u0002092\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020+H\u0016J\u0016\u0010^\u001a\u0002092\f\u0010_\u001a\b\u0012\u0004\u0012\u00020+0)H\u0002J\"\u0010`\u001a\u0002092\u0018\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*0)H\u0016J\u0016\u0010b\u001a\u0002092\f\u0010a\u001a\b\u0012\u0004\u0012\u00020+0)H\u0002J\b\u0010c\u001a\u000209H\u0016J&\u0010d\u001a\u0002092\u0006\u0010e\u001a\u00020f2\u0014\u0010g\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0018\u00010*H\u0002J\b\u0010h\u001a\u000209H\u0016J\"\u0010i\u001a\u0002092\u0018\u0010j\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*0)H\u0002J\u000e\u0010k\u001a\b\u0012\u0004\u0012\u00020+0lH\u0016J\b\u0010m\u001a\u000209H\u0016J\u0010\u0010n\u001a\u0002092\u0006\u0010X\u001a\u00020YH\u0002J(\u0010o\u001a\u0002092\b\u0010D\u001a\u0004\u0018\u00010+2\u0006\u0010p\u001a\u00020+2\f\u0010q\u001a\b\u0012\u0004\u0012\u0002090rH\u0002J\b\u0010s\u001a\u000209H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R&\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*0)X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020+0)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u0010\u00106\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/OCRToPaperRemoveHandWrittenControl;", "Lcom/tera/scan/scanner/ocr/control/OCRAutoScanControl;", "Lcom/tera/scan/scanner/ocr/control/IPrepareProcessing;", "activity", "Lcom/tera/scan/framework/BaseActivity;", "ocrTakePhotoView", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "category", "", "pdfMode", "paperAddCount", "paperReChoosePage", "(Lcom/tera/scan/framework/BaseActivity;Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;IIII)V", "bgEdgeImage", "Landroid/widget/FrameLayout;", "getBgEdgeImage", "()Landroid/widget/FrameLayout;", "setBgEdgeImage", "(Landroid/widget/FrameLayout;)V", "btnClick", "Lcom/tera/scan/widget/ButtonClickCtrlUtil;", "container", "Landroid/view/View;", "docScanFilterIndex", "getDocScanFilterIndex", "()I", "setDocScanFilterIndex", "(I)V", "done", "edgeImage", "Landroid/widget/ImageView;", "getEdgeImage", "()Landroid/widget/ImageView;", "setEdgeImage", "(Landroid/widget/ImageView;)V", "gallery", "Landroid/widget/TextView;", "image", "imageBadge", "imagePreview", "images", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "", "", "getImages$scanner_aiscanConfigRelease", "()Ljava/util/ArrayList;", "ocrResultDataList", "permissionPresenter", "Lcom/tera/scan/permission/PermissionPresenter;", "getPermissionPresenter", "()Lcom/tera/scan/permission/PermissionPresenter;", "permissionPresenter$delegate", "Lkotlin/Lazy;", "takePhotoButtonView", "tip", "addPreProcessingTask", "", "task", "autoCrop", "sourcePath", "width", "", "height", "cropCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cropDestPathStr", "cropInfo", "buildCropInfo", "Lcom/tera/scan/model/CropInfo;", "points", "Lcom/terascan/algo/Point;", "cropInfoToMap", "info", "nullPoints", "", "enterTakeMode", "getMaxCount", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClear", "onDoneViewClick", "onInitView", "view", "Landroid/app/Activity;", "onPictureTake", "bitmap", "Landroid/graphics/Bitmap;", "outPutPath", "onReqGalleryOkBusiness", "destPathList", "onResult", "path", "onResultForList", "onSelect", "onTakePhotoBusiness", "pic", "Ljava/io/File;", "map", "onUnSelect", "openImageProcessPage", "tokenImages", "pictures", "", "removePreProcessingTask", "setGalleryEvent", "showCropPreview", "destPathStr", "onPreviewFinish", "Lkotlin/Function0;", "updateView", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("OCRToPaperRemoveHandWrittenControl")
public final class OCRToPaperRemoveHandWrittenControl extends OCRAutoScanControl implements IPrepareProcessing {
    public int a;
    @Nullable
    public TextView aaa;
    @Nullable
    public View ddd;
    @Nullable
    public View eee;
    @NotNull
    public final fe.mmm.qw.n.qw ggg = new fe.mmm.qw.n.qw();
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final BaseActivity f7213i;

    /* renamed from: if  reason: not valid java name */
    public final int f302if;
    @Nullable
    public ImageView mmm;
    @Nullable
    public ImageView nn;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final IOCRTakePhotoView f7214o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f7215pf;
    @NotNull
    public final ArrayList<String> ppp = new ArrayList<>();
    @Nullable
    public TextView qqq;
    @Nullable
    public FrameLayout rrr;

    /* renamed from: switch  reason: not valid java name */
    public final int f303switch;
    @Nullable
    public ImageView tt;
    @Nullable
    public View vvv;
    @NotNull
    public final ArrayList<HashMap<String, Object>> when = new ArrayList<>();
    @Nullable
    public TextView xxx;

    public static final class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ OCRToPaperRemoveHandWrittenControl f7216ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f7217th;

        public ad(OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, Function0<Unit> function0) {
            this.f7216ad = oCRToPaperRemoveHandWrittenControl;
            this.f7217th = function0;
        }

        public final void run() {
            FrameLayout m = this.f7216ad.m();
            if (m != null) {
                m.setVisibility(8);
            }
            this.f7217th.invoke();
        }
    }

    public static final class qw extends TimerTask {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ OCRToPaperRemoveHandWrittenControl f7220ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Function0 f7221th;

        public qw(OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, Function0 function0) {
            this.f7220ad = oCRToPaperRemoveHandWrittenControl;
            this.f7221th = function0;
        }

        public void run() {
            this.f7220ad.f7213i.runOnUiThread(new ad(this.f7220ad, this.f7221th));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRToPaperRemoveHandWrittenControl(@NotNull BaseActivity baseActivity, @NotNull IOCRTakePhotoView iOCRTakePhotoView, int i2, int i3, int i4, int i5) {
        super(baseActivity, iOCRTakePhotoView);
        Intrinsics.checkNotNullParameter(baseActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(iOCRTakePhotoView, "ocrTakePhotoView");
        this.f7213i = baseActivity;
        this.f7214o = iOCRTakePhotoView;
        this.f7215pf = i2;
        this.f302if = i3;
        this.f303switch = i4;
        LazyKt__LazyJVMKt.lazy(new OCRToPaperRemoveHandWrittenControl$permissionPresenter$2(this));
    }

    public static final void A(OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, View view) {
        OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl2 = oCRToPaperRemoveHandWrittenControl;
        Intrinsics.checkNotNullParameter(oCRToPaperRemoveHandWrittenControl2, "this$0");
        fe.vvv.qw.xxx.ad pictureSize = oCRToPaperRemoveHandWrittenControl2.f7214o.getPictureSize();
        if (pictureSize == null) {
            pictureSize = new fe.vvv.qw.xxx.ad(4500, 4500);
        }
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(pictureSize.rg(), pictureSize.fe());
        LocalImageSelectActivity.qw.fe(LocalImageSelectActivity.Companion, oCRToPaperRemoveHandWrittenControl2.f7213i, oCRToPaperRemoveHandWrittenControl.q() - oCRToPaperRemoveHandWrittenControl2.when.size(), coerceAtLeast, 1, 0, oCRToPaperRemoveHandWrittenControl.xxx().getUbcSource$scanner_aiscanConfigRelease(), 16, (Object) null);
        fe.mmm.qw.tt.fe.qw.ad("AlbumIn_clk", "CameraPage", (String) null, oCRToPaperRemoveHandWrittenControl.xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(oCRToPaperRemoveHandWrittenControl2.f7215pf))), 4, (Object) null);
    }

    public static final void C(OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, String str) {
        Intrinsics.checkNotNullParameter(oCRToPaperRemoveHandWrittenControl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$url");
        ImageView imageView = oCRToPaperRemoveHandWrittenControl.tt;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = oCRToPaperRemoveHandWrittenControl.tt;
        if (imageView2 != null) {
            fe.rg.qw.when.ad yj2 = new fe.rg.qw.when.ad().E(true).yj(yj.qw);
            Intrinsics.checkNotNullExpressionValue(yj2, "RequestOptions().skipMem…y(DiskCacheStrategy.NONE)");
            rg<Drawable> ppp2 = fe.rg.qw.ad.qqq(oCRToPaperRemoveHandWrittenControl.f7213i).ppp(new File(str));
            ppp2.de(yj2);
            ppp2.m317switch(imageView2);
        }
    }

    public static final void h(Function2 function2, OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, CropInfo cropInfo, String str) {
        Intrinsics.checkNotNullParameter(function2, "$cropCallback");
        Intrinsics.checkNotNullParameter(oCRToPaperRemoveHandWrittenControl, "this$0");
        Intrinsics.checkNotNullParameter(cropInfo, "$cropInfo");
        function2.invoke(str, l(oCRToPaperRemoveHandWrittenControl, cropInfo, false, 2, (Object) null));
    }

    public static /* synthetic */ HashMap l(OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, CropInfo cropInfo, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return oCRToPaperRemoveHandWrittenControl.k(cropInfo, z);
    }

    public static final void s(OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, View view) {
        Intrinsics.checkNotNullParameter(oCRToPaperRemoveHandWrittenControl, "this$0");
        oCRToPaperRemoveHandWrittenControl.r();
    }

    public static final void t(OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, View view) {
        Intrinsics.checkNotNullParameter(oCRToPaperRemoveHandWrittenControl, "this$0");
        oCRToPaperRemoveHandWrittenControl.r();
    }

    public final void B(String str, String str2, Function0<Unit> function0) {
        if (str == null) {
            str = str2;
        }
        this.f7213i.runOnUiThread(new fe.mmm.qw.tt.ad.when.yj(this, str));
        new Timer().schedule(new qw(this, function0), 500);
    }

    public final void D() {
        Object obj;
        if (this.f302if == 1) {
            TextView textView = this.xxx;
            if (textView != null) {
                textView.setVisibility(0);
            }
            View view = this.eee;
            if (view != null) {
                view.setEnabled(true);
            }
        } else if (!this.when.isEmpty()) {
            ImageView imageView = this.nn;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            View view2 = this.ddd;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            ImageView imageView2 = this.mmm;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            HashMap hashMap = (HashMap) CollectionsKt___CollectionsKt.lastOrNull(this.when);
            String str = null;
            if (hashMap == null || (obj = hashMap.get("crop_path")) == null) {
                HashMap hashMap2 = (HashMap) CollectionsKt___CollectionsKt.lastOrNull(this.when);
                obj = hashMap2 != null ? hashMap2.get("source_path") : null;
            }
            if (obj instanceof String) {
                str = (String) obj;
            }
            ImageView imageView3 = this.nn;
            if (str == null || imageView3 == null) {
                TextView textView2 = this.aaa;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = this.aaa;
                if (textView3 != null) {
                    textView3.setText(String.valueOf(this.when.size()));
                }
                View view3 = this.eee;
                if (view3 != null) {
                    view3.setEnabled(true);
                }
            } else {
                ImageViewKt.qw(this.tt, str.toString(), imageView3, new OCRToPaperRemoveHandWrittenControl$updateView$1(this, str, imageView3));
            }
            TextView textView4 = this.qqq;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        } else {
            ImageView imageView4 = this.nn;
            if (imageView4 != null) {
                imageView4.setVisibility(4);
            }
            TextView textView5 = this.aaa;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            View view4 = this.ddd;
            if (view4 != null) {
                view4.setVisibility(4);
            }
            TextView textView6 = this.qqq;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            View view5 = this.eee;
            if (view5 != null) {
                view5.setEnabled(true);
            }
        }
    }

    public void aaa(@NotNull Bitmap bitmap, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "outPutPath");
        super.aaa(bitmap, str);
        if (this.when.size() == q()) {
            o.uk(this.f7213i.getString(R.string.story_add_picture_over_limit, new Object[]{Integer.valueOf(q())}));
            View view = this.eee;
            if (view != null) {
                view.setEnabled(true);
                return;
            }
            return;
        }
        System.currentTimeMillis();
        fe.mmm.qw.h.fe.qw.ad(bitmap, str, new OCRToPaperRemoveHandWrittenControl$onPictureTake$1(this, bitmap));
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [com.tera.scan.framework.BaseActivity] */
    /* JADX WARNING: type inference failed for: r0v13, types: [com.tera.scan.framework.BaseActivity] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ad() {
        /*
            r9 = this;
            super.ad()
            com.tera.scan.framework.BaseActivity r0 = r9.f7213i
            r9.mmm(r0)
            android.view.View r0 = r9.vvv
            r1 = 0
            if (r0 != 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0.setVisibility(r1)
        L_0x0011:
            int r0 = r9.f302if
            r2 = 1
            if (r0 == r2) goto L_0x0042
            java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r9.when
            int r0 = r0.size()
            r2 = 0
            if (r0 <= 0) goto L_0x0031
            com.tera.scan.framework.BaseActivity r0 = r9.f7213i
            boolean r3 = r0 instanceof com.tera.scan.scanner.ocr.OCRTakePhotoActivity
            if (r3 == 0) goto L_0x0028
            r2 = r0
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity r2 = (com.tera.scan.scanner.ocr.OCRTakePhotoActivity) r2
        L_0x0028:
            if (r2 == 0) goto L_0x0042
            r0 = 2131887031(0x7f1203b7, float:1.9408658E38)
            r2.showTipView((int) r0)
            goto L_0x0042
        L_0x0031:
            com.tera.scan.framework.BaseActivity r0 = r9.f7213i
            boolean r3 = r0 instanceof com.tera.scan.scanner.ocr.OCRTakePhotoActivity
            if (r3 == 0) goto L_0x003a
            r2 = r0
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity r2 = (com.tera.scan.scanner.ocr.OCRTakePhotoActivity) r2
        L_0x003a:
            if (r2 == 0) goto L_0x0042
            r0 = 2131887030(0x7f1203b6, float:1.9408656E38)
            r2.showTipView((int) r0)
        L_0x0042:
            com.tera.scan.scanner.ocr.control.IOCRTakePhotoView r0 = r9.f7214o
            r2 = -2
            r0.setCarmeSize(r2)
            android.view.View r0 = r9.eee
            if (r0 != 0) goto L_0x004d
            goto L_0x0050
        L_0x004d:
            r0.setVisibility(r1)
        L_0x0050:
            r4 = 0
            com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel r0 = r9.xxx()
            java.lang.String r5 = r0.getUbcSource$scanner_aiscanConfigRelease()
            int r0 = r9.f7215pf
            java.lang.String r0 = fe.mmm.qw.tt.qw.qw.qw(r0)
            java.lang.String r1 = "ScanButton"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r0)
            java.util.Map r6 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r0)
            r7 = 4
            r8 = 0
            java.lang.String r2 = "CameraPage"
            java.lang.String r3 = "CameraPage"
            fe.mmm.qw.tt.fe.qw.ad(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.control.OCRToPaperRemoveHandWrittenControl.ad():void");
    }

    public void de() {
        super.de();
        View view = this.vvv;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void f(@NotNull HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "task");
        new fe.mmm.qw.p024if.p025if.qw.qw().qw(this.f7213i.getApplication(), CollectionsKt__CollectionsJVMKt.listOf(hashMap), this.f7215pf);
    }

    public final void g(String str, float f, float f2, Function2<? super String, ? super HashMap<String, Object>, Unit> function2) {
        ArrayList<Point> arrayList;
        ArrayList<Point> points;
        try {
            AutoScanRectView vvv2 = vvv();
            if (vvv2 == null || (arrayList = vvv2.getPoints()) == null) {
                arrayList = new ArrayList<>();
            }
            CropInfo j = j(str, f, f2, arrayList);
            AutoScanRectView vvv3 = vvv();
            boolean z = false;
            if ((vvv3 != null ? vvv3.getPoints() : null) != null) {
                AutoScanRectView vvv4 = vvv();
                if (!((vvv4 == null || (points = vvv4.getPoints()) == null || points.size() != 0) ? false : true)) {
                    if (f * ((float) 4) == f2 * ((float) 3)) {
                        z = true;
                    }
                    if (!z) {
                        function2.invoke(str, k(j, true));
                    } else {
                        ImageCropPredictor.f7026o.qw().vvv(this.f7213i, j, new ggg(function2, this, j));
                    }
                    ExpectKt.success(Unit.INSTANCE);
                }
            }
            function2.invoke(str, l(this, j, false, 2, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
    }

    public final CropInfo j(String str, float f, float f2, ArrayList<Point> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        float rg2 = f / ((float) fe.mmm.qw.p030switch.th.de.ad.qw.rg());
        for (Point point : arrayList) {
            arrayList2.add(new PointInfo(point.getX() * rg2, point.getY() * rg2));
        }
        File file = new File(str);
        return new CropInfo(file.getParent() + "/crop_" + file.getName(), arrayList2, 0, str, f, f2);
    }

    public final HashMap<String, Object> k(CropInfo cropInfo, boolean z) {
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

    @Nullable
    public final FrameLayout m() {
        return this.rrr;
    }

    public void mmm(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        super.mmm(activity);
        ViewStub viewStub = (ViewStub) activity.findViewById(R.id.stub_remove_handwritten);
        if (viewStub != null) {
            viewStub.inflate();
            this.vvv = activity.findViewById(R.id.to_paper_container);
            this.xxx = (TextView) activity.findViewById(R.id.to_paper_gallery);
            View findViewById = activity.findViewById(R.id.to_paper_done);
            this.ddd = findViewById;
            if (findViewById != null) {
                findViewById.setVisibility(4);
            }
            ImageView imageView = (ImageView) activity.findViewById(R.id.to_paper_image);
            this.nn = imageView;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            this.mmm = (ImageView) activity.findViewById(R.id.taking_photo_preview);
            this.aaa = (TextView) activity.findViewById(R.id.to_paper_image_badge);
            this.qqq = (TextView) activity.findViewById(R.id.take_photo_tip);
            this.eee = activity.findViewById(R.id.take_photo_button);
            rrr((AutoScanRectView) activity.findViewById(R.id.to_paper_auto_scan_rect));
            this.rrr = (FrameLayout) activity.findViewById(R.id.bg_to_take_shot_edge_image);
            this.tt = (ImageView) activity.findViewById(R.id.to_take_shot_edge_image);
            z(activity);
            ImageView imageView2 = this.nn;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new ppp(this));
            }
            View view = this.ddd;
            if (view != null) {
                view.setOnClickListener(new fe.mmm.qw.tt.ad.when.o(this));
            }
            D();
        }
    }

    @Nullable
    public final ImageView n() {
        return this.tt;
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
                u(stringArrayListExtra);
            }
        }
    }

    @NotNull
    public final ArrayList<HashMap<String, Object>> p() {
        return this.when;
    }

    public final int q() {
        int i2 = this.f302if;
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 2) {
            return 20;
        }
        return this.f303switch;
    }

    public final void r() {
        if (!this.ggg.qw()) {
            if (this.f302if == 0) {
                y(this.when);
            } else {
                v(this.when);
            }
            LoggerKt.d$default("onDoneViewClick: " + this.f7213i + Ascii.CASE_MASK + this.f302if + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.when + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f7215pf + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.ppp, (Object) null, 1, (Object) null);
            fe.mmm.qw.tt.fe.qw.ad("CamD_clk", "CameraPage", (String) null, xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(this.f7215pf)), TuplesKt.to("PicNum", Integer.valueOf(this.when.size()))), 4, (Object) null);
        }
    }

    public void rg() {
        if (!this.when.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.when);
            new fe.mmm.qw.p024if.p025if.qw.qw().uk(this.f7213i.getApplication(), arrayList);
        }
    }

    public final void u(ArrayList<String> arrayList) {
        String docSavePath;
        if (this.f302if != 0) {
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
            w(arrayList);
            return;
        }
        BaseActivity baseActivity = this.f7213i;
        String str2 = "";
        if ((baseActivity instanceof OCRTakePhotoActivity) && (docSavePath = ((OCRTakePhotoActivity) baseActivity).getDocSavePath()) != null) {
            str2 = docSavePath;
        }
        String str3 = str2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (String cropInfo : arrayList) {
            arrayList4.add(l(this, new CropInfo("", CollectionsKt__CollectionsKt.emptyList(), 0, cropInfo, 0.0f, 0.0f), false, 2, (Object) null));
        }
        ArrayList qw2 = de.qw(arrayList4);
        qw2.addAll(0, this.when);
        new fe.mmm.qw.p024if.p025if.qw.qw().fe(this.f7213i, qw2, 14, this.f7215pf, xxx().autoScanSwitchValue(), this.a, "", str3, xxx().getUbcSource$scanner_aiscanConfigRelease());
        uk();
    }

    public void uk() {
        this.when.clear();
        D();
        xxx().setIsTakingMode(false);
    }

    public void v(@NotNull ArrayList<HashMap<String, Object>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "path");
        Intent intent = new Intent();
        intent.putExtra("extra_result_files", arrayList);
        intent.putExtra(OCRTakePhotoActivity.EXTRA_RESULT_CATEGORY, this.f7215pf);
        intent.putExtra("doc_scan_mode", xxx().autoScanSwitchValue());
        intent.putExtra("doc_scan_filter_index", this.a);
        this.f7213i.setResult(-1, intent);
        this.f7213i.finish();
    }

    public final void w(ArrayList<String> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("extra_result_files", arrayList);
        intent.putExtra(OCRTakePhotoActivity.EXTRA_RESULT_CATEGORY, this.f7215pf);
        intent.putExtra("doc_scan_mode", xxx().autoScanSwitchValue());
        intent.putExtra("doc_scan_filter_index", this.a);
        this.f7213i.setResult(-1, intent);
        this.f7213i.finish();
    }

    public final void x(File file, HashMap<String, Object> hashMap) {
        if (this.f302if == 1) {
            if (hashMap != null) {
                v(CollectionsKt__CollectionsKt.arrayListOf(hashMap));
            }
        } else if (xxx().isSingleMode() && hashMap != null) {
            y(CollectionsKt__CollectionsKt.arrayListOf(hashMap));
        } else if (this.when.size() >= q()) {
            o.uk(this.f7213i.getString(R.string.story_add_picture_over_limit, new Object[]{Integer.valueOf(q())}));
            View view = this.eee;
            if (view != null) {
                view.setEnabled(true);
            }
        } else if (hashMap != null) {
            this.when.add(hashMap);
            f(hashMap);
            D();
        }
    }

    public final void y(ArrayList<HashMap<String, Object>> arrayList) {
        String docSavePath;
        BaseActivity baseActivity = this.f7213i;
        String str = "";
        if ((baseActivity instanceof OCRTakePhotoActivity) && (docSavePath = ((OCRTakePhotoActivity) baseActivity).getDocSavePath()) != null) {
            str = docSavePath;
        }
        ArrayList<HashMap<String, Object>> arrayList2 = arrayList;
        new fe.mmm.qw.p024if.p025if.qw.qw().fe(this.f7213i, arrayList2, 14, this.f7215pf, xxx().autoScanSwitchValue(), this.a, "", str, xxx().getUbcSource$scanner_aiscanConfigRelease());
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

    public final void z(Activity activity) {
        TextView textView = this.xxx;
        if (textView != null) {
            textView.setOnClickListener(new qqq(this));
        }
    }
}
