package com.tera.scan.scanner.ocr.control;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.aiscan.R;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.model.CropInfo;
import com.tera.scan.model.ImageCropPredictor;
import com.tera.scan.model.PointInfo;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl;
import com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel;
import com.tera.scan.scanner.ocr.widget.ScanIdCardsFrameView;
import com.tera.scan.ui.view.layout.UIConstraintLayout;
import com.terascan.algo.Point;
import fe.ggg.ad.qw.fe.ad.de;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.th.qw.th.pf;
import fe.mmm.qw.th.qw.th.yj;
import fe.mmm.qw.tt.ad.when.aaa;
import fe.mmm.qw.tt.ad.when.f;
import fe.mmm.qw.tt.ad.when.uk;
import fe.rg.qw.rg;
import fe.vvv.qw.xxx.ad;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B~\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012*\b\u0002\u0010\n\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f0\u000b\u0012!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\u0002\u0010\u0015J>\u0010F\u001a\u00020\u00142*\b\u0002\u0010G\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f0\u000b2\b\b\u0002\u0010H\u001a\u00020\rH\u0002J6\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020MH\u0002J \u0010N\u001a\u0012\u0012\u0004\u0012\u00020O0\u000bj\b\u0012\u0004\u0012\u00020O`P2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020\u0007H\u0002J\b\u0010T\u001a\u00020\u0007H\u0002J\"\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010Z\u001a\u00020\u0014H\u0016J\b\u0010[\u001a\u00020\u0014H\u0016J:\u0010\\\u001a\u00020\u00142(\u0010G\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f0\u000b2\u0006\u0010H\u001a\u00020\rH\u0002J \u0010]\u001a\u00020\u00142\u0016\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000bj\b\u0012\u0004\u0012\u00020\r`PH\u0002J\u0010\u0010_\u001a\u00020\u00142\u0006\u0010`\u001a\u00020\u0003H\u0016J \u0010a\u001a\u00020\u00142\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\u0007H\u0016J\u0010\u0010f\u001a\u00020\u00142\u0006\u0010g\u001a\u00020hH\u0016J\u0016\u0010i\u001a\u00020\u00142\u0006\u0010j\u001a\u00020R2\u0006\u0010k\u001a\u00020\rJ\u0010\u0010i\u001a\u00020\u00142\u0006\u0010l\u001a\u00020mH\u0016J \u0010n\u001a\u00020\u00142\u0016\u0010o\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000bj\b\u0012\u0004\u0012\u00020\r`PH\u0002J\b\u0010p\u001a\u00020\u0014H\u0016J\u0006\u0010q\u001a\u00020\u0014J8\u0010q\u001a\u00020\u00142\u0006\u0010l\u001a\u00020m2&\u0010r\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fH\u0002J\u0006\u0010s\u001a\u00020\u0014J\b\u0010t\u001a\u00020\u0014H\u0016J\u000e\u0010u\u001a\b\u0012\u0004\u0012\u00020\r0vH\u0016J\u0018\u0010w\u001a\u00020\u00142\u0006\u0010x\u001a\u00020\r2\u0006\u0010j\u001a\u00020RH\u0002J\b\u0010y\u001a\u00020\u0014H\u0002JB\u0010z\u001a\u00020\u00142\b\u0010{\u001a\u0004\u0018\u00010\r2\u0006\u0010x\u001a\u00020\r2&\u0010r\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fH\u0002J\u0010\u0010|\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010}\u001a\u00020\u0014H\u0002J\u0006\u0010~\u001a\u00020\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R)\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00140\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R6\u0010\n\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f0\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0014\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0010\u0010*\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010+\u001a\u0004\u0018\u00010,8@X\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u001c\u0010;\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u0010\u0010>\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/ScanIdCardsTakingControl;", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoControl;", "activity", "Landroid/app/Activity;", "ocrTakePhotoView", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "pdfMod", "", "subIndex", "category", "images", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroid/app/Activity;Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;IIILjava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getActivity$scanner_aiscanConfigRelease", "()Landroid/app/Activity;", "bottomRecyclerView", "Landroid/view/View;", "getCategory$scanner_aiscanConfigRelease", "()I", "setCategory$scanner_aiscanConfigRelease", "(I)V", "clTakeContainer", "Lcom/tera/scan/ui/view/layout/UIConstraintLayout;", "imagePreview", "Landroid/widget/ImageView;", "getImages$scanner_aiscanConfigRelease", "()Ljava/util/ArrayList;", "ivImageBadgeRight", "ivPhotoImage", "llCardsFrame", "Landroid/widget/LinearLayout;", "getPdfMod$scanner_aiscanConfigRelease", "getSubIndex$scanner_aiscanConfigRelease", "takePhotoButtonView", "takePhotoViewModel", "Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "getTakePhotoViewModel$scanner_aiscanConfigRelease", "()Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "takePhotoViewModel$delegate", "Lkotlin/Lazy;", "tvGallery", "Landroid/widget/TextView;", "tvIDCardTips", "getTvIDCardTips$scanner_aiscanConfigRelease", "()Landroid/widget/TextView;", "setTvIDCardTips$scanner_aiscanConfigRelease", "(Landroid/widget/TextView;)V", "tvPassportTipsBottom", "getTvPassportTipsBottom$scanner_aiscanConfigRelease", "setTvPassportTipsBottom$scanner_aiscanConfigRelease", "tvPassportTipsTop", "getTvPassportTipsTop$scanner_aiscanConfigRelease", "setTvPassportTipsTop$scanner_aiscanConfigRelease", "tvPhotoImageCount", "tvTitle", "viewCardsFrame", "Lcom/tera/scan/scanner/ocr/widget/ScanIdCardsFrameView;", "getViewCardsFrame$scanner_aiscanConfigRelease", "()Lcom/tera/scan/scanner/ocr/widget/ScanIdCardsFrameView;", "setViewCardsFrame$scanner_aiscanConfigRelease", "(Lcom/tera/scan/scanner/ocr/widget/ScanIdCardsFrameView;)V", "checkTakePhoto", "list", "docResourceFrom", "cropInfoToMap", "info", "Lcom/tera/scan/model/CropInfo;", "nullPoints", "", "getHollowingOutPoints", "Lcom/terascan/algo/Point;", "Lkotlin/collections/ArrayList;", "photoBitmap", "Landroid/graphics/Bitmap;", "getMaxCount", "getTitleContentByCategory", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClear", "onDestroy", "onDoneBusiness", "onGalleryResultOk", "destPathList", "onInitView", "view", "onPicturePreview", "frame", "Lcom/otaliastudios/cameraview/frame/Frame;", "cameraViewWidth", "cameraViewHeight", "onPictureSizeChanged", "size", "Lcom/otaliastudios/cameraview/size/Size;", "onPictureTake", "bitmap", "outPutPath", "pic", "Ljava/io/File;", "onResult", "pathList", "onSelect", "onTakePhotoBusiness", "map", "onTakePhotoButtonClick", "onUnSelect", "pictures", "", "preViewCrop", "destPathStr", "setListener", "showPreViewCrop", "cropDestPathStr", "updateContentView", "updateTakePhotoData", "updateViewAfterRemoveLastImage", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsTakingControl implements IOCRTakePhotoControl {
    @NotNull
    public final Lazy aaa = LazyKt__LazyJVMKt.lazy(new ScanIdCardsTakingControl$takePhotoViewModel$2(this));
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final IOCRTakePhotoView f7251ad;
    @Nullable
    public TextView ddd;

    /* renamed from: de  reason: collision with root package name */
    public final int f7252de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f7253fe;
    @Nullable
    public ImageView ggg;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public TextView f7254i;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public TextView f308if;
    @Nullable
    public ScanIdCardsFrameView mmm;
    @Nullable
    public LinearLayout nn;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public ImageView f7255o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public TextView f7256pf;
    @Nullable
    public ImageView ppp;
    @NotNull
    public final Activity qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f7257rg;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public View f309switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final ArrayList<HashMap<String, Object>> f7258th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public UIConstraintLayout f7259uk;
    @Nullable
    public TextView vvv;
    @Nullable
    public View when;
    @Nullable
    public TextView xxx;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Function1<Integer, Unit> f7260yj;

    public static final class qw implements Observer<String> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ScanIdCardsTakingControl f7261ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Bitmap f7262th;

        public qw(ScanIdCardsTakingControl scanIdCardsTakingControl, Bitmap bitmap) {
            this.f7261ad = scanIdCardsTakingControl;
            this.f7262th = bitmap;
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
            this.f7261ad.l(str, this.f7262th);
        }
    }

    public ScanIdCardsTakingControl(@NotNull Activity activity, @NotNull IOCRTakePhotoView iOCRTakePhotoView, int i2, int i3, int i4, @NotNull ArrayList<HashMap<String, Object>> arrayList, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(iOCRTakePhotoView, "ocrTakePhotoView");
        Intrinsics.checkNotNullParameter(arrayList, "images");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.qw = activity;
        this.f7251ad = iOCRTakePhotoView;
        this.f7252de = i2;
        this.f7253fe = i3;
        this.f7257rg = i4;
        this.f7258th = arrayList;
        this.f7260yj = function1;
        f(activity);
    }

    public static final void d(ScanIdCardsTakingControl scanIdCardsTakingControl) {
        Intrinsics.checkNotNullParameter(scanIdCardsTakingControl, "this$0");
        scanIdCardsTakingControl.f7260yj.invoke(Integer.valueOf(scanIdCardsTakingControl.f7257rg));
        scanIdCardsTakingControl.uk();
    }

    public static final void m(ScanIdCardsTakingControl scanIdCardsTakingControl, String str, CropInfo cropInfo, String str2) {
        Intrinsics.checkNotNullParameter(scanIdCardsTakingControl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$destPathStr");
        Intrinsics.checkNotNullParameter(cropInfo, "$cropInfo");
        scanIdCardsTakingControl.q(str2, str, ppp(scanIdCardsTakingControl, cropInfo, false, 2, (Object) null));
    }

    public static /* synthetic */ HashMap ppp(ScanIdCardsTakingControl scanIdCardsTakingControl, CropInfo cropInfo, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return scanIdCardsTakingControl.when(cropInfo, z);
    }

    /* renamed from: switch  reason: not valid java name */
    public static /* synthetic */ void m906switch(ScanIdCardsTakingControl scanIdCardsTakingControl, ArrayList arrayList, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = new ArrayList();
        }
        if ((i2 & 2) != 0) {
            str = "take_photos";
        }
        scanIdCardsTakingControl.m907if(arrayList, str);
    }

    @Nullable
    public final TextView a() {
        return this.xxx;
    }

    public final int aaa() {
        return this.f7253fe;
    }

    public void ad() {
        this.f7258th.clear();
        r(this.f7257rg);
        UIConstraintLayout uIConstraintLayout = this.f7259uk;
        if (uIConstraintLayout != null) {
            uIConstraintLayout.setVisibility(0);
        }
        View view = this.when;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f7251ad.setZoom(0.1f);
    }

    @Nullable
    public final ScanIdCardsFrameView b() {
        return this.mmm;
    }

    public final void c(ArrayList<HashMap<String, Object>> arrayList, String str) {
        String str2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            HashMap hashMap = (HashMap) it.next();
            String str3 = (String) hashMap.get("crop_path");
            if (str3 == null || str3.length() == 0) {
                z = true;
            }
            if (z) {
                str2 = String.valueOf(hashMap.get("source_path"));
            } else {
                str2 = String.valueOf(hashMap.get("crop_path"));
            }
            arrayList2.add(str2);
        }
        ArrayList qw2 = de.qw(arrayList2);
        if (this.f7252de == 0) {
            new pf("id_card", new String[0]).qw();
            new fe.mmm.qw.p024if.p025if.qw.qw().yj(this.qw, qw2, 14, this.f7257rg, str);
            UIConstraintLayout uIConstraintLayout = this.f7259uk;
            if (uIConstraintLayout != null) {
                uIConstraintLayout.postDelayed(new uk(this), 500);
                return;
            }
            return;
        }
        h(qw2);
    }

    @NotNull
    public final ArrayList<HashMap<String, Object>> ddd() {
        return this.f7258th;
    }

    public void de() {
        this.f7258th.clear();
        UIConstraintLayout uIConstraintLayout = this.f7259uk;
        if (uIConstraintLayout != null) {
            uIConstraintLayout.setVisibility(8);
        }
        LinearLayout linearLayout = this.nn;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        this.mmm = null;
        this.f7251ad.setZoom(0.0f);
    }

    public final void e(ArrayList<String> arrayList) {
        int size = (this.f7258th.size() + arrayList.size()) - nn();
        if (size > 0 && arrayList.size() - size > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = arrayList.iterator();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str = (String) next;
                if (i2 >= arrayList.size() - size) {
                    z = false;
                }
                if (z) {
                    arrayList2.add(next);
                }
                i2 = i3;
            }
            arrayList.clear();
            arrayList.addAll(arrayList2);
            StringBuilder sb = new StringBuilder();
            sb.append("选择图片数量超过最多数量限制 getMaxCount()：");
            sb.append(nn());
            sb.append(" images.size:");
            sb.append(this.f7258th.size());
            sb.append(Ascii.CASE_MASK);
            sb.append((String) LoggerKt.d$default("list.size: " + arrayList.size(), (Object) null, 1, (Object) null));
            sb.toString();
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (String cropInfo : arrayList) {
            arrayList3.add(ppp(this, new CropInfo("", CollectionsKt__CollectionsKt.emptyList(), 0, cropInfo, 0.0f, 0.0f), false, 2, (Object) null));
        }
        this.f7258th.addAll(de.qw(arrayList3));
        f.qw(this);
        c(this.f7258th, "photo_import");
    }

    public final int eee() {
        int i2 = this.f7257rg;
        if (i2 == 1) {
            return R.string.id_card_tab;
        }
        if (i2 != 2) {
            return i2 != 6 ? R.string.id_card_tab : R.string.id_card_tab_type_passport;
        }
        return R.string.id_card_tab_type_others;
    }

    public void f(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        this.f7259uk = (UIConstraintLayout) activity.findViewById(R.id.cl_scan_id_cards_taking_container);
        this.f7254i = (TextView) activity.findViewById(R.id.tv_scan_id_cards_taking_gallery);
        ImageView imageView = (ImageView) activity.findViewById(R.id.iv_scan_id_cards_taking_image);
        this.f7255o = imageView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        this.f7256pf = (TextView) activity.findViewById(R.id.tv_scan_id_cards_taking_badge);
        this.f308if = (TextView) activity.findViewById(R.id.tv_scan_type_title);
        this.vvv = (TextView) activity.findViewById(R.id.tv_scan_id_cards_picture_tips);
        this.nn = (LinearLayout) activity.findViewById(R.id.ll_cards_frame);
        this.xxx = (TextView) activity.findViewById(R.id.tv_scan_id_cards_passport_tips_top);
        this.ddd = (TextView) activity.findViewById(R.id.tv_scan_id_cards_passport_tips_bottom);
        this.ggg = (ImageView) activity.findViewById(R.id.scan_id_card_right);
        this.f309switch = activity.findViewById(R.id.ocr_bottom_recyclerview);
        this.when = activity.findViewById(R.id.take_photo_button);
        this.ppp = (ImageView) activity.findViewById(R.id.taking_photo_preview);
        p();
        TextView textView = this.f308if;
        if (textView != null) {
            textView.setText(this.qw.getResources().getString(eee()));
        }
    }

    public void fe(@NotNull ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "size");
    }

    public final void g(@NotNull Bitmap bitmap, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "outPutPath");
        if (this.f7258th.size() == nn()) {
            o.uk(this.qw.getString(R.string.max_picture_notice, new Object[]{String.valueOf(nn())}));
            return;
        }
        fe.mmm.qw.h.fe.qw.ad(bitmap, str, new qw(this, bitmap));
    }

    @NotNull
    public final Activity ggg() {
        return this.qw;
    }

    public final void h(ArrayList<String> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("extra_result_files", arrayList);
        intent.putExtra(OCRTakePhotoActivity.EXTRA_RESULT_CATEGORY, this.f7257rg);
        this.qw.setResult(-1, intent);
        this.qw.finish();
    }

    /* renamed from: if  reason: not valid java name */
    public final void m907if(ArrayList<HashMap<String, Object>> arrayList, String str) {
        this.f7258th.addAll(arrayList);
        f.qw(this);
        if (this.f7258th.size() < nn()) {
            s();
        } else {
            c(this.f7258th, str);
        }
    }

    public final void j(File file, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(hashMap);
            m906switch(this, arrayList, (String) null, 2, (Object) null);
        }
    }

    public final void k() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "camera_id_cards_confirm_take_photos_click", (List) null, 2, (Object) null);
    }

    public final void l(String str, Bitmap bitmap) {
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        ArrayList arrayList = new ArrayList();
        for (Point point : xxx(bitmap)) {
            arrayList.add(new PointInfo(point.getX(), point.getY()));
        }
        try {
            File file = new File(str);
            CropInfo cropInfo = new CropInfo(file.getParent() + "/crop_" + file.getName(), arrayList, 0, str, width, height);
            ImageCropPredictor.f7026o.qw().vvv(this.qw, cropInfo, new aaa(this, str, cropInfo));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
    }

    public final int mmm() {
        return this.f7252de;
    }

    public final void n(int i2) {
        this.f7257rg = i2;
    }

    public final int nn() {
        if (this.f7252de != 0) {
            return 1;
        }
        int i2 = this.f7257rg;
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
        }
        return 20;
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        boolean z = true;
        if (i2 == 1 && i3 == -1) {
            ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("extra_result_files") : null;
            if (stringArrayListExtra == null || !(!stringArrayListExtra.isEmpty())) {
                z = false;
            }
            if (z) {
                e(stringArrayListExtra);
            }
        }
    }

    public void onDestroy() {
    }

    public void onResume() {
        IOCRTakePhotoControl.qw.de(this);
    }

    public void onStop() {
        IOCRTakePhotoControl.qw.fe(this);
    }

    public final void p() {
        TextView textView = this.f7254i;
        if (textView != null) {
            yj.de(textView, 0, new ScanIdCardsTakingControl$setListener$1(this), 1, (Object) null);
        }
        ImageView imageView = this.f7255o;
        if (imageView != null) {
            yj.de(imageView, 0, new ScanIdCardsTakingControl$setListener$2(this), 1, (Object) null);
        }
    }

    public final void q(String str, String str2, HashMap<String, Object> hashMap) {
        j(new File(str2), hashMap);
    }

    @Nullable
    public final OCRTakePhotoViewModel qqq() {
        return (OCRTakePhotoViewModel) this.aaa.getValue();
    }

    public void qw(@NotNull fe.vvv.qw.o.qw qwVar, int i2, int i3) {
        Intrinsics.checkNotNullParameter(qwVar, "frame");
    }

    public final void r(int i2) {
        LinearLayout linearLayout;
        this.f7257rg = i2;
        TextView textView = this.f308if;
        if (textView != null) {
            textView.setText(this.qw.getResources().getString(eee()));
        }
        LinearLayout linearLayout2 = this.nn;
        if ((linearLayout2 != null ? linearLayout2.getChildCount() : 0) > 0 && (linearLayout = this.nn) != null) {
            linearLayout.removeAllViews();
        }
        ScanIdCardsFrameView scanIdCardsFrameView = new ScanIdCardsFrameView(this.qw);
        this.mmm = scanIdCardsFrameView;
        if (scanIdCardsFrameView != null) {
            scanIdCardsFrameView.setScanInCardsCategory(i2);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            LinearLayout linearLayout3 = this.nn;
            if (linearLayout3 != null) {
                linearLayout3.addView(scanIdCardsFrameView, layoutParams);
            }
        }
        this.f7258th.clear();
        View view = this.f309switch;
        if (view != null) {
            view.setVisibility(4);
        }
        TextView textView2 = this.f7254i;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        f.qw(this);
    }

    @Nullable
    public final TextView rrr() {
        return this.vvv;
    }

    public final void s() {
        if (!this.f7258th.isEmpty()) {
            if (this.f7257rg == 1) {
                TextView textView = this.f7254i;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else {
                TextView textView2 = this.f7254i;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
            }
            ImageView imageView = this.f7255o;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            HashMap hashMap = (HashMap) CollectionsKt___CollectionsKt.lastOrNull(this.f7258th);
            String str = null;
            Object obj = hashMap != null ? hashMap.get("crop_path") : null;
            String str2 = obj instanceof String ? (String) obj : null;
            if (!fe.mmm.qw.j.xxx.ad.xxx(str2)) {
                HashMap hashMap2 = (HashMap) CollectionsKt___CollectionsKt.lastOrNull(this.f7258th);
                Object obj2 = hashMap2 != null ? hashMap2.get("source_path") : null;
                if (obj2 instanceof String) {
                    str = (String) obj2;
                }
                str2 = str;
            }
            ImageView imageView2 = this.f7255o;
            if (str2 == null || imageView2 == null) {
                TextView textView3 = this.f7256pf;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                TextView textView4 = this.f7256pf;
                if (textView4 != null) {
                    textView4.setText(String.valueOf(this.f7258th.size()));
                }
                if (this.f7257rg == 1) {
                    ImageView imageView3 = this.ggg;
                    if (imageView3 != null) {
                        imageView3.setVisibility(8);
                        return;
                    }
                    return;
                }
                ImageView imageView4 = this.ggg;
                if (imageView4 != null) {
                    imageView4.setVisibility(0);
                    return;
                }
                return;
            }
            fe.rg.qw.when.ad w = new fe.rg.qw.when.ad().E(true).yj(fe.rg.qw.o.fe.yj.qw).w(R.drawable.icon_list_large_image_no_shadow);
            Intrinsics.checkNotNullExpressionValue(w, "RequestOptions().skipMem…st_large_image_no_shadow)");
            rg<Drawable> ppp2 = fe.rg.qw.ad.nn(this.qw).ppp(new File(str2.toString()));
            ppp2.de(w);
            ppp2.m317switch(imageView2);
            TextView textView5 = this.f7256pf;
            if (textView5 != null) {
                textView5.setText(String.valueOf(this.f7258th.size()));
            }
            TextView textView6 = this.f7256pf;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            if (this.f7257rg == 1) {
                ImageView imageView5 = this.ggg;
                if (imageView5 != null) {
                    imageView5.setVisibility(8);
                    return;
                }
                return;
            }
            ImageView imageView6 = this.ggg;
            if (imageView6 != null) {
                imageView6.setVisibility(0);
                return;
            }
            return;
        }
        ImageView imageView7 = this.f7255o;
        if (imageView7 != null) {
            imageView7.setVisibility(4);
        }
        TextView textView7 = this.f7256pf;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        ImageView imageView8 = this.ggg;
        if (imageView8 != null) {
            imageView8.setVisibility(8);
        }
        TextView textView8 = this.f7254i;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
    }

    public final void t() {
        if (this.f7258th.isEmpty()) {
            ImageView imageView = this.f7255o;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            TextView textView = this.f7256pf;
            if (textView != null) {
                textView.setText("");
            }
            TextView textView2 = this.f7256pf;
            if (textView2 != null) {
                textView2.setVisibility(4);
            }
        }
        s();
    }

    public void th(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "pic");
    }

    @Nullable
    public final TextView tt() {
        return this.ddd;
    }

    public void uk() {
        this.f7258th.clear();
        ImageView imageView = this.f7255o;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        TextView textView = this.f7256pf;
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = this.f7256pf;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        s();
    }

    public final int vvv() {
        return this.f7257rg;
    }

    public final HashMap<String, Object> when(CropInfo cropInfo, boolean z) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = (r1 = r1.getResources()).getDisplayMetrics();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.terascan.algo.Point> xxx(android.graphics.Bitmap r11) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            fe.mmm.qw.ppp.qw$qw r1 = fe.mmm.qw.ppp.qw.qw
            android.content.Context r1 = r1.qw()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x001e
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x001e
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            if (r1 == 0) goto L_0x001e
            float r1 = r1.density
            goto L_0x0020
        L_0x001e:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x0020:
            com.tera.scan.scanner.ocr.control.IOCRTakePhotoView r3 = r10.f7251ad
            android.graphics.Rect r3 = r3.getPreviewRect()
            int r4 = r3.left
            int r5 = r3.top
            r6 = 2
            int[] r6 = new int[r6]
            com.tera.scan.scanner.ocr.widget.ScanIdCardsFrameView r7 = r10.mmm
            if (r7 == 0) goto L_0x0034
            r7.getLocationInWindow(r6)
        L_0x0034:
            r7 = 1
            r6 = r6[r7]
            com.tera.scan.scanner.ocr.widget.ScanIdCardsFrameView r7 = r10.mmm
            if (r7 == 0) goto L_0x0040
            android.graphics.RectF r7 = r7.getCardsFrameRect()
            goto L_0x0041
        L_0x0040:
            r7 = 0
        L_0x0041:
            r8 = 0
            if (r7 == 0) goto L_0x0047
            float r9 = r7.left
            goto L_0x0048
        L_0x0047:
            r9 = 0
        L_0x0048:
            if (r7 == 0) goto L_0x004c
            float r8 = r7.top
        L_0x004c:
            float r6 = (float) r6
            float r8 = r8 + r6
            float r4 = (float) r4
            float r9 = r9 - r4
            float r9 = r9 * r1
            float r4 = (float) r5
            float r8 = r8 - r4
            float r8 = r8 * r1
            if (r7 == 0) goto L_0x005d
            float r4 = r7.width()
            goto L_0x005f
        L_0x005d:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x005f:
            float r4 = r4 * r1
            if (r7 == 0) goto L_0x0067
            float r2 = r7.height()
        L_0x0067:
            float r2 = r2 * r1
            int r5 = r3.width()
            float r5 = (float) r5
            float r5 = r5 * r1
            int r3 = r3.height()
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = r11.getWidth()
            float r1 = (float) r1
            float r1 = r1 / r5
            int r5 = r11.getHeight()
            float r5 = (float) r5
            float r5 = r5 / r3
            float r9 = r9 * r1
            int r3 = (int) r9
            float r8 = r8 * r5
            int r6 = (int) r8
            float r4 = r4 * r1
            int r1 = (int) r4
            float r2 = r2 * r5
            int r2 = (int) r2
            r4 = 0
            int r3 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r3, (int) r4)
            int r4 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r6, (int) r4)
            int r5 = r11.getWidth()
            int r5 = r5 - r3
            int r1 = kotlin.ranges.RangesKt___RangesKt.coerceAtMost((int) r1, (int) r5)
            int r11 = r11.getHeight()
            int r11 = r11 - r4
            int r11 = kotlin.ranges.RangesKt___RangesKt.coerceAtMost((int) r2, (int) r11)
            com.terascan.algo.Point r2 = new com.terascan.algo.Point
            float r5 = (float) r3
            float r6 = (float) r4
            r2.<init>(r5, r6)
            com.terascan.algo.Point r7 = new com.terascan.algo.Point
            int r3 = r3 + r1
            float r1 = (float) r3
            r7.<init>(r1, r6)
            com.terascan.algo.Point r3 = new com.terascan.algo.Point
            int r4 = r4 + r11
            float r11 = (float) r4
            r3.<init>(r5, r11)
            com.terascan.algo.Point r4 = new com.terascan.algo.Point
            r4.<init>(r1, r11)
            r0.add(r2)
            r0.add(r3)
            r0.add(r4)
            r0.add(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.control.ScanIdCardsTakingControl.xxx(android.graphics.Bitmap):java.util.ArrayList");
    }

    @NotNull
    public List<String> yj() {
        String str;
        ArrayList<HashMap<String, Object>> arrayList = this.f7258th;
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
}
