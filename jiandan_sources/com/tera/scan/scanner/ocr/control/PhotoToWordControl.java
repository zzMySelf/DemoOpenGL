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
import fe.mmm.qw.tt.ad.when.mmm;
import fe.mmm.qw.tt.ad.when.rrr;
import fe.mmm.qw.tt.ad.when.tt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJf\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2D\u0010*\u001a@\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020%0+H\u0002J.\u00100\u001a\u0002012\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0007H\u0002J&\u00104\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u00105\u001a\u0002012\b\b\u0002\u00106\u001a\u00020\u000fH\u0002J\u0010\u00107\u001a\u00020%2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\fH\u0016J\u0010\u0010;\u001a\u00020%2\u0006\u00108\u001a\u000209H\u0016J\"\u0010<\u001a\u00020%2\u0018\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007H\u0002J\"\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020%H\u0016J\b\u0010D\u001a\u00020%H\u0016J\u0010\u0010E\u001a\u00020%2\u0006\u00108\u001a\u000209H\u0016J\u0018\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\tH\u0016J\u0016\u0010J\u001a\u00020%2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016J\b\u0010L\u001a\u00020%H\u0016J&\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020O2\u0014\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0002J\b\u0010Q\u001a\u00020%H\u0016J\u000e\u0010R\u001a\b\u0012\u0004\u0012\u00020\t0SH\u0016J(\u0010T\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010\t2\u0006\u0010U\u001a\u00020\t2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020%0WH\u0002J\b\u0010X\u001a\u00020%H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/PhotoToWordControl;", "Lcom/tera/scan/scanner/ocr/control/OCRAutoScanControl;", "activity", "Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;", "ocrTakePhotoView", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "images", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "", "", "pdfMode", "", "(Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;Ljava/util/ArrayList;I)V", "autoScanSwitchOpen", "", "getAutoScanSwitchOpen", "()Z", "bgEdgeImage", "Landroid/widget/FrameLayout;", "btnClick", "Lcom/tera/scan/widget/ButtonClickCtrlUtil;", "container", "Landroid/view/View;", "edgeImage", "Landroid/widget/ImageView;", "gallery", "Landroid/widget/TextView;", "image", "imageBadge", "imagePreview", "imageToWordImageRight", "getImages$scanner_aiscanConfigRelease", "()Ljava/util/ArrayList;", "takePhotoButtonView", "tip", "autoCrop", "", "sourcePath", "width", "", "height", "cropCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cropDestPathStr", "cropInfo", "buildCropInfo", "Lcom/tera/scan/model/CropInfo;", "points", "Lcom/terascan/algo/Point;", "cropInfoToMap", "info", "nullPoints", "findViews", "view", "Landroid/app/Activity;", "getMaxCount", "initOnClickListener", "jumpToConvertWord", "imageList", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClear", "onDoneViewClick", "onInitView", "onPictureTake", "bitmap", "Landroid/graphics/Bitmap;", "outPutPath", "onReqGalleryOkBusiness", "destPathList", "onSelect", "onTakePhotoBusiness", "pic", "Ljava/io/File;", "map", "onUnSelect", "pictures", "", "showCropPreview", "destPathStr", "onPreviewFinish", "Lkotlin/Function0;", "updateView", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("PhotoToWordControl")
public class PhotoToWordControl extends OCRAutoScanControl {
    @Nullable
    public ImageView aaa;
    @Nullable
    public View ddd;
    @Nullable
    public TextView ggg;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final OCRTakePhotoActivity f7230i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final fe.mmm.qw.n.qw f304if;
    @Nullable
    public FrameLayout mmm;
    @Nullable
    public ImageView nn;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final IOCRTakePhotoView f7231o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final ArrayList<HashMap<String, Object>> f7232pf;
    @Nullable
    public ImageView ppp;
    public final boolean qqq;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public View f305switch;
    @Nullable
    public ImageView vvv;
    @Nullable
    public TextView when;
    @Nullable
    public TextView xxx;

    public static final class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ PhotoToWordControl f7233ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f7234th;

        public ad(PhotoToWordControl photoToWordControl, Function0<Unit> function0) {
            this.f7233ad = photoToWordControl;
            this.f7234th = function0;
        }

        public final void run() {
            FrameLayout b = this.f7233ad.mmm;
            if (b != null) {
                b.setVisibility(8);
            }
            this.f7234th.invoke();
        }
    }

    public static final class qw extends TimerTask {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ PhotoToWordControl f7237ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Function0 f7238th;

        public qw(PhotoToWordControl photoToWordControl, Function0 function0) {
            this.f7237ad = photoToWordControl;
            this.f7238th = function0;
        }

        public void run() {
            this.f7237ad.f7230i.runOnUiThread(new ad(this.f7237ad, this.f7238th));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoToWordControl(OCRTakePhotoActivity oCRTakePhotoActivity, IOCRTakePhotoView iOCRTakePhotoView, ArrayList arrayList, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(oCRTakePhotoActivity, iOCRTakePhotoView, (i3 & 4) != 0 ? new ArrayList() : arrayList, i2);
    }

    public static final void B(PhotoToWordControl photoToWordControl, String str) {
        Intrinsics.checkNotNullParameter(photoToWordControl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$url");
        ImageView imageView = photoToWordControl.aaa;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = photoToWordControl.aaa;
        if (imageView2 != null) {
            File file = new File(str);
            if (file.exists()) {
                Context context = photoToWordControl.f7230i.getContext();
                fe.rg.qw.when.ad yj2 = new fe.rg.qw.when.ad().E(true).yj(yj.qw);
                Intrinsics.checkNotNullExpressionValue(yj2, "RequestOptions().skipMem…y(DiskCacheStrategy.NONE)");
                rg<Drawable> ppp2 = fe.rg.qw.ad.mmm(context).ppp(file);
                ppp2.de(yj2);
                ppp2.m317switch(imageView2);
            }
        }
    }

    public static final void l(Function2 function2, PhotoToWordControl photoToWordControl, CropInfo cropInfo, String str) {
        Intrinsics.checkNotNullParameter(function2, "$cropCallback");
        Intrinsics.checkNotNullParameter(photoToWordControl, "this$0");
        Intrinsics.checkNotNullParameter(cropInfo, "$cropInfo");
        function2.invoke(str, p(photoToWordControl, cropInfo, false, 2, (Object) null));
    }

    public static /* synthetic */ HashMap p(PhotoToWordControl photoToWordControl, CropInfo cropInfo, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return photoToWordControl.n(cropInfo, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cropInfoToMap");
    }

    public static final void u(PhotoToWordControl photoToWordControl, View view) {
        Intrinsics.checkNotNullParameter(photoToWordControl, "this$0");
        fe.vvv.qw.xxx.ad pictureSize = photoToWordControl.f7231o.getPictureSize();
        if (pictureSize == null) {
            pictureSize = new fe.vvv.qw.xxx.ad(4500, 4500);
        }
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(pictureSize.rg(), pictureSize.fe());
        LocalImageSelectActivity.qw.fe(LocalImageSelectActivity.Companion, photoToWordControl.f7230i, photoToWordControl.s() - photoToWordControl.f7232pf.size(), coerceAtLeast, 1, 0, photoToWordControl.xxx().getUbcSource$scanner_aiscanConfigRelease(), 16, (Object) null);
        fe.mmm.qw.ggg.qw.qw.qw("take_pictures_page_import_photos_click", CollectionsKt__CollectionsJVMKt.listOf(fe.mmm.qw.tt.ad.nn.qw.fe(photoToWordControl.f7230i.getCurrentTab())));
        fe.mmm.qw.tt.fe.qw.ad("AlbumIn_clk", "CameraPage", (String) null, photoToWordControl.xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(12))), 4, (Object) null);
    }

    public static final void v(PhotoToWordControl photoToWordControl, View view) {
        Intrinsics.checkNotNullParameter(photoToWordControl, "this$0");
        photoToWordControl.x();
    }

    public final void A(String str, String str2, Function0<Unit> function0) {
        if (str == null) {
            str = str2;
        }
        this.f7230i.runOnUiThread(new tt(this, str));
        new Timer().schedule(new qw(this, function0), 500);
    }

    public void C() {
        Object obj;
        if (!this.f7232pf.isEmpty()) {
            ImageView imageView = this.ppp;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.nn;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            HashMap hashMap = (HashMap) CollectionsKt___CollectionsKt.lastOrNull(this.f7232pf);
            Object obj2 = null;
            if (hashMap == null || (obj = hashMap.get("crop_path")) == null) {
                HashMap hashMap2 = (HashMap) CollectionsKt___CollectionsKt.lastOrNull(this.f7232pf);
                Object obj3 = hashMap2 != null ? hashMap2.get("source_path") : null;
                if (obj3 instanceof String) {
                    obj2 = (String) obj3;
                }
            } else {
                obj2 = obj;
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            T t = this.ppp;
            objectRef.element = t;
            if (obj2 == null || t == null) {
                TextView textView = this.ggg;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                ImageView imageView3 = this.vvv;
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                }
                TextView textView2 = this.ggg;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(this.f7232pf.size()));
                }
                View view = this.ddd;
                if (view != null) {
                    view.setEnabled(true);
                }
            } else if (!xxx().isAutoScanSwitchOpen()) {
                ImageViewKt.qw(this.nn, obj2.toString(), objectRef.element, new PhotoToWordControl$updateView$1(this, obj2, objectRef));
            } else {
                ImageViewKt.qw(this.aaa, obj2.toString(), objectRef.element, new PhotoToWordControl$updateView$2(this, obj2, objectRef));
            }
            TextView textView3 = this.xxx;
            if (textView3 != null) {
                textView3.setVisibility(8);
                return;
            }
            return;
        }
        ImageView imageView4 = this.ppp;
        if (imageView4 != null) {
            imageView4.setVisibility(4);
        }
        TextView textView4 = this.ggg;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        ImageView imageView5 = this.vvv;
        if (imageView5 != null) {
            imageView5.setVisibility(8);
        }
        TextView textView5 = this.xxx;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        View view2 = this.ddd;
        if (view2 != null) {
            view2.setEnabled(true);
        }
    }

    public void aaa(@NotNull Bitmap bitmap, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "outPutPath");
        if (this.f7232pf.size() == s()) {
            View view = this.ddd;
            if (view != null) {
                view.setEnabled(true);
            }
            o.uk(this.f7230i.getString(R.string.max_picture_notice, new Object[]{String.valueOf(s())}));
            return;
        }
        super.aaa(bitmap, str);
        fe.mmm.qw.h.fe.qw.ad(bitmap, str, new PhotoToWordControl$onPictureTake$1(this, bitmap));
    }

    public void ad() {
        super.ad();
        View view = this.f305switch;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.when;
        if (textView != null) {
            textView.setVisibility(0);
        }
        OCRTakePhotoActivity oCRTakePhotoActivity = this.f7230i;
        if (!(oCRTakePhotoActivity instanceof OCRTakePhotoActivity)) {
            oCRTakePhotoActivity = null;
        }
        if (oCRTakePhotoActivity != null) {
            oCRTakePhotoActivity.showTipView((int) R.string.convert_word_translate_tips);
        }
        this.f7231o.setCarmeSize(-2);
        View view2 = this.ddd;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "photo_translate_page_show", (List) null, 2, (Object) null);
        fe.mmm.qw.tt.fe.qw.ad("CameraPage", "CameraPage", (String) null, xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(12))), 4, (Object) null);
    }

    public void de() {
        super.de();
        View view = this.f305switch;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView = this.ggg;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.ggg;
        if (textView2 != null) {
            textView2.setText((CharSequence) null);
        }
        ImageView imageView = this.nn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.vvv;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        TextView textView3 = this.when;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    public final void k(String str, float f, float f2, Function2<? super String, ? super HashMap<String, Object>, Unit> function2) {
        ArrayList<Point> arrayList;
        ArrayList<Point> points;
        try {
            AutoScanRectView vvv2 = vvv();
            if (vvv2 == null || (arrayList = vvv2.getPoints()) == null) {
                arrayList = new ArrayList<>();
            }
            CropInfo m = m(str, f, f2, arrayList);
            AutoScanRectView vvv3 = vvv();
            boolean z = false;
            if ((vvv3 != null ? vvv3.getPoints() : null) != null) {
                AutoScanRectView vvv4 = vvv();
                if (!((vvv4 == null || (points = vvv4.getPoints()) == null || points.size() != 0) ? false : true)) {
                    if (f * ((float) 4) == f2 * ((float) 3)) {
                        z = true;
                    }
                    if (!z) {
                        function2.invoke(str, n(m, true));
                    } else {
                        ImageCropPredictor.f7026o.qw().vvv(this.f7230i, m, new fe.mmm.qw.tt.ad.when.ad(function2, this, m));
                    }
                    ExpectKt.success(Unit.INSTANCE);
                }
            }
            function2.invoke(str, p(this, m, false, 2, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
    }

    public final CropInfo m(String str, float f, float f2, ArrayList<Point> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        float rg2 = f / ((float) fe.mmm.qw.p030switch.th.de.ad.qw.rg());
        for (Point point : arrayList) {
            arrayList2.add(new PointInfo(point.getX() * rg2, point.getY() * rg2));
        }
        File file = new File(str);
        return new CropInfo(file.getParent() + "/crop_" + file.getName(), arrayList2, 0, str, f, f2);
    }

    public void mmm(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        super.mmm(activity);
        q(activity);
        t(activity);
        C();
    }

    public final HashMap<String, Object> n(CropInfo cropInfo, boolean z) {
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

    public boolean ppp() {
        return this.qqq;
    }

    public void q(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        this.f305switch = activity.findViewById(R.id.convert_word_translate_container);
        this.when = (TextView) activity.findViewById(R.id.to_convert_word_translate_gallery);
        rrr((AutoScanRectView) activity.findViewById(R.id.auto_convert_word_scan_rect));
        ImageView imageView = (ImageView) activity.findViewById(R.id.to_convert_word_translate_image);
        this.ppp = imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.nn = (ImageView) activity.findViewById(R.id.taking_photo_preview);
        this.ggg = (TextView) activity.findViewById(R.id.to_convert_word_image_badge);
        this.vvv = (ImageView) activity.findViewById(R.id.iv_to_convert_word_image_right);
        this.xxx = (TextView) activity.findViewById(R.id.take_photo_tip);
        this.ddd = activity.findViewById(R.id.take_photo_button);
        this.mmm = (FrameLayout) activity.findViewById(R.id.bg_to_take_shot_edge_image);
        this.aaa = (ImageView) activity.findViewById(R.id.to_take_shot_edge_image);
    }

    @NotNull
    public final ArrayList<HashMap<String, Object>> r() {
        return this.f7232pf;
    }

    public int s() {
        return 20;
    }

    public void t(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        TextView textView = this.when;
        if (textView != null) {
            textView.setOnClickListener(new rrr(this));
        }
        ImageView imageView = this.ppp;
        if (imageView != null) {
            imageView.setOnClickListener(new mmm(this));
        }
    }

    public void uk() {
        this.f7232pf.clear();
        C();
    }

    public final void w(ArrayList<HashMap<String, Object>> arrayList) {
        String str;
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
        ArrayList qw2 = de.qw(arrayList2);
        if (!qw2.isEmpty()) {
            new fe.mmm.qw.p024if.p025if.qw.qw().de(this.f7230i, qw2, 14, Boolean.TRUE, "from_shot", "", xxx().getUbcSource$scanner_aiscanConfigRelease());
            uk();
        }
    }

    public void x() {
        if (!this.f304if.qw()) {
            w(this.f7232pf);
            fe.mmm.qw.tt.fe.qw.ad("CamD_clk", "CameraPage", (String) null, xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(12)), TuplesKt.to("PicNum", Integer.valueOf(this.f7232pf.size()))), 4, (Object) null);
        }
    }

    public void y(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "destPathList");
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (String cropInfo : arrayList) {
            arrayList2.add(p(this, new CropInfo("", CollectionsKt__CollectionsKt.emptyList(), 0, cropInfo, 0.0f, 0.0f), false, 2, (Object) null));
        }
        ArrayList qw2 = de.qw(arrayList2);
        qw2.addAll(0, this.f7232pf);
        w(qw2);
    }

    @NotNull
    public List<String> yj() {
        String str;
        ArrayList<HashMap<String, Object>> arrayList = this.f7232pf;
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

    public final void z(File file, HashMap<String, Object> hashMap) {
        if (xxx().isSingleMode() && hashMap != null) {
            w(CollectionsKt__CollectionsKt.arrayListOf(hashMap));
        } else if (this.f7232pf.size() >= s()) {
            View view = this.ddd;
            if (view != null) {
                view.setEnabled(true);
            }
        } else if (hashMap != null) {
            this.f7232pf.add(hashMap);
            C();
            if (this.f7232pf.size() == 1) {
                o.yj(this.f7230i, fe.mmm.qw.p030switch.th.de.ad.ad.qw(R.string.continuous_shooting));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoToWordControl(@NotNull OCRTakePhotoActivity oCRTakePhotoActivity, @NotNull IOCRTakePhotoView iOCRTakePhotoView, @NotNull ArrayList<HashMap<String, Object>> arrayList, int i2) {
        super(oCRTakePhotoActivity, iOCRTakePhotoView);
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(iOCRTakePhotoView, "ocrTakePhotoView");
        Intrinsics.checkNotNullParameter(arrayList, "images");
        this.f7230i = oCRTakePhotoActivity;
        this.f7231o = iOCRTakePhotoView;
        this.f7232pf = arrayList;
        this.f304if = new fe.mmm.qw.n.qw();
        mmm(this.f7230i);
    }
}
