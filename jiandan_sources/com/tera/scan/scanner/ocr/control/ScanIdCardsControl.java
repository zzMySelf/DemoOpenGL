package com.tera.scan.scanner.ocr.control;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import fe.mmm.qw.ggg.qw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\b\u0011\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00120\b\u0002\u0010\n\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f`\u000f¢\u0006\u0002\u0010\u0010J&\u00107\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u0017H\u0002J\u0006\u0010;\u001a\u00020\u0007J\u0010\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020>H\u0016J\"\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u00020*H\u0016J\u0010\u0010E\u001a\u00020*2\u0006\u0010=\u001a\u00020>H\u0016J\u0018\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\rH\u0016J\b\u0010J\u001a\u00020*H\u0016J\u0006\u0010K\u001a\u00020*J\b\u0010L\u001a\u00020*H\u0016J\u000e\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0NH\u0016J\u0006\u0010O\u001a\u00020*J\u0015\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020\u0017H\u0000¢\u0006\u0002\bRJ\b\u0010S\u001a\u00020*H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R<\u0010\n\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f`\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R7\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0004\u0012\u00020*\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/ScanIdCardsControl;", "Lcom/tera/scan/scanner/ocr/control/OCRAutoScanControl;", "activity", "Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;", "ocrTakePhotoView", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "pdfMode", "", "category", "subIndex", "images", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/ArrayList;", "(Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;IIILjava/util/ArrayList;)V", "bottomRecyclerView", "Landroid/view/View;", "btnClick", "Lcom/tera/scan/widget/ButtonClickCtrlUtil;", "container", "enableGuide", "", "getEnableGuide$scanner_aiscanConfigRelease", "()Z", "setEnableGuide$scanner_aiscanConfigRelease", "(Z)V", "guideControl", "Lcom/tera/scan/scanner/ocr/control/ScanIdCardsGuideControl;", "getImages$scanner_aiscanConfigRelease", "()Ljava/util/ArrayList;", "isGuideType", "isGuideType$scanner_aiscanConfigRelease", "setGuideType$scanner_aiscanConfigRelease", "scanHistory", "Landroid/widget/TextView;", "scanHistoryTip", "showTypeChangeCallBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getShowTypeChangeCallBack$scanner_aiscanConfigRelease", "()Lkotlin/jvm/functions/Function1;", "setShowTypeChangeCallBack$scanner_aiscanConfigRelease", "(Lkotlin/jvm/functions/Function1;)V", "takePhotoButtonView", "takingControl", "Lcom/tera/scan/scanner/ocr/control/ScanIdCardsTakingControl;", "getTakingControl$scanner_aiscanConfigRelease", "()Lcom/tera/scan/scanner/ocr/control/ScanIdCardsTakingControl;", "setTakingControl$scanner_aiscanConfigRelease", "(Lcom/tera/scan/scanner/ocr/control/ScanIdCardsTakingControl;)V", "tip", "cropInfoToMap", "info", "Lcom/tera/scan/model/CropInfo;", "nullPoints", "currentSelectCategory", "findViews", "view", "Landroid/app/Activity;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClear", "onInitView", "onPictureTake", "bitmap", "Landroid/graphics/Bitmap;", "outPutPath", "onSelect", "onTakePhotoButtonClick", "onUnSelect", "pictures", "", "previousClearAllImagesAndRestart", "updateContentView", "tmpGuideType", "updateContentView$scanner_aiscanConfigRelease", "updateView", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("ScanIdCardsControl")
public class ScanIdCardsControl extends OCRAutoScanControl {
    public boolean aaa;
    public boolean ddd;
    @Nullable
    public View ggg;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final OCRTakePhotoActivity f7239i;

    /* renamed from: if  reason: not valid java name */
    public int f306if;
    @Nullable
    public ScanIdCardsTakingControl mmm;
    @Nullable
    public ScanIdCardsGuideControl nn;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final IOCRTakePhotoView f7240o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f7241pf;
    @Nullable
    public View ppp;
    @Nullable
    public Function1<? super Boolean, Unit> qqq;

    /* renamed from: switch  reason: not valid java name */
    public final int f307switch;
    @Nullable
    public TextView vvv;
    @NotNull
    public final ArrayList<HashMap<String, Object>> when;
    @Nullable
    public View xxx;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScanIdCardsControl(OCRTakePhotoActivity oCRTakePhotoActivity, IOCRTakePhotoView iOCRTakePhotoView, int i2, int i3, int i4, ArrayList arrayList, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(oCRTakePhotoActivity, iOCRTakePhotoView, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 1 : i3, (i5 & 16) != 0 ? 0 : i4, (i5 & 32) != 0 ? new ArrayList() : arrayList);
    }

    @Nullable
    public final ScanIdCardsTakingControl a() {
        return this.mmm;
    }

    public void aaa(@NotNull Bitmap bitmap, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "outPutPath");
        View view = this.ggg;
        if (view != null) {
            view.setEnabled(true);
        }
        if (this.ddd) {
            ScanIdCardsGuideControl scanIdCardsGuideControl = this.nn;
            if (scanIdCardsGuideControl != null) {
                scanIdCardsGuideControl.m905switch(bitmap, str);
                return;
            }
            return;
        }
        ScanIdCardsTakingControl scanIdCardsTakingControl = this.mmm;
        if (scanIdCardsTakingControl != null) {
            scanIdCardsTakingControl.g(bitmap, str);
        }
    }

    public void ad() {
        super.ad();
        View view = this.ppp;
        if (view != null) {
            view.setVisibility(0);
        }
        OCRTakePhotoActivity oCRTakePhotoActivity = this.f7239i;
        if (!(oCRTakePhotoActivity instanceof OCRTakePhotoActivity)) {
            oCRTakePhotoActivity = null;
        }
        if (oCRTakePhotoActivity != null) {
            oCRTakePhotoActivity.hideTipView();
        }
        this.f7240o.setCarmeSize(-2);
        View view2 = this.ggg;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ScanAnalyticsBaseEvent.qw.qw(qw.qw, "photo_translate_page_show", (List) null, 2, (Object) null);
        TextView textView = this.vvv;
        if (textView != null) {
            textView.setVisibility(8);
        }
        boolean z = this.aaa;
        this.ddd = z;
        f(z);
        fe.mmm.qw.tt.fe.qw.ad("CameraPage", "CameraPage", (String) null, xxx().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(1))), 4, (Object) null);
    }

    public final boolean b() {
        return this.ddd;
    }

    public final void c() {
        ScanIdCardsTakingControl scanIdCardsTakingControl;
        if (!this.ddd && (scanIdCardsTakingControl = this.mmm) != null) {
            scanIdCardsTakingControl.k();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        if ((r1 != null && r1.vvv() == 2) != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r5 = this;
            java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r5.when
            int r0 = r0.size()
            com.tera.scan.scanner.ocr.control.ScanIdCardsTakingControl r1 = r5.mmm
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0015
            int r1 = r1.vvv()
            r4 = 6
            if (r1 != r4) goto L_0x0015
            r1 = 1
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            if (r1 != 0) goto L_0x0028
            com.tera.scan.scanner.ocr.control.ScanIdCardsTakingControl r1 = r5.mmm
            if (r1 == 0) goto L_0x0025
            int r1 = r1.vvv()
            r4 = 2
            if (r1 != r4) goto L_0x0025
            r1 = 1
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            if (r1 == 0) goto L_0x0037
        L_0x0028:
            if (r0 <= r2) goto L_0x0037
            java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r5.when
            kotlin.collections.CollectionsKt__MutableCollectionsKt.removeLastOrNull(r0)
            com.tera.scan.scanner.ocr.control.ScanIdCardsTakingControl r0 = r5.mmm
            if (r0 == 0) goto L_0x0046
            r0.t()
            goto L_0x0046
        L_0x0037:
            java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r5.when
            r0.clear()
            com.tera.scan.scanner.ocr.control.ScanIdCardsTakingControl r0 = r5.mmm
            if (r0 == 0) goto L_0x0043
            r0.uk()
        L_0x0043:
            r5.f(r3)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.control.ScanIdCardsControl.d():void");
    }

    public void de() {
        super.de();
        View view = this.ppp;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.ppp;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        ScanIdCardsGuideControl scanIdCardsGuideControl = this.nn;
        if (scanIdCardsGuideControl != null) {
            scanIdCardsGuideControl.de();
        }
    }

    public final void e(@Nullable Function1<? super Boolean, Unit> function1) {
        this.qqq = function1;
    }

    public final void f(boolean z) {
        boolean z2 = z && this.f7241pf == 0;
        this.ddd = z2;
        if (z2) {
            ScanIdCardsGuideControl scanIdCardsGuideControl = this.nn;
            if (scanIdCardsGuideControl != null) {
                scanIdCardsGuideControl.ad();
            }
            ScanIdCardsTakingControl scanIdCardsTakingControl = this.mmm;
            if (scanIdCardsTakingControl != null) {
                scanIdCardsTakingControl.de();
            }
            View view = this.xxx;
            if (view != null) {
                view.setVisibility(0);
            }
            this.f7240o.setCarmeSize(-1);
        } else {
            ScanIdCardsGuideControl scanIdCardsGuideControl2 = this.nn;
            if (scanIdCardsGuideControl2 != null) {
                scanIdCardsGuideControl2.de();
            }
            ScanIdCardsTakingControl scanIdCardsTakingControl2 = this.mmm;
            if (scanIdCardsTakingControl2 != null) {
                scanIdCardsTakingControl2.ad();
            }
            View view2 = this.xxx;
            if (view2 != null) {
                view2.setVisibility(4);
            }
            this.f7240o.setCarmeSize(-1);
        }
        Function1<? super Boolean, Unit> function1 = this.qqq;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this.ddd));
        }
    }

    public void g() {
    }

    public void mmm(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        super.mmm(activity);
        tt(activity);
        g();
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ScanIdCardsTakingControl scanIdCardsTakingControl = this.mmm;
        if (scanIdCardsTakingControl != null) {
            scanIdCardsTakingControl.onActivityResult(i2, i3, intent);
        }
    }

    public void tt(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        this.ppp = activity.findViewById(R.id.scan_id_card_container);
        this.ggg = activity.findViewById(R.id.take_photo_button);
        ScanIdCardsGuideControl scanIdCardsGuideControl = new ScanIdCardsGuideControl(activity, this.f306if, new ScanIdCardsControl$findViews$1(this));
        this.nn = scanIdCardsGuideControl;
        this.mmm = new ScanIdCardsTakingControl(activity, this.f7240o, this.f7241pf, this.f307switch, scanIdCardsGuideControl != null ? scanIdCardsGuideControl.o() : this.f306if, this.when, new ScanIdCardsControl$findViews$2(this));
    }

    public void uk() {
        this.when.clear();
        ScanIdCardsTakingControl scanIdCardsTakingControl = this.mmm;
        if (scanIdCardsTakingControl != null) {
            scanIdCardsTakingControl.uk();
        }
        g();
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanIdCardsControl(@NotNull OCRTakePhotoActivity oCRTakePhotoActivity, @NotNull IOCRTakePhotoView iOCRTakePhotoView, int i2, int i3, int i4, @NotNull ArrayList<HashMap<String, Object>> arrayList) {
        super(oCRTakePhotoActivity, iOCRTakePhotoView);
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(iOCRTakePhotoView, "ocrTakePhotoView");
        Intrinsics.checkNotNullParameter(arrayList, "images");
        this.f7239i = oCRTakePhotoActivity;
        this.f7240o = iOCRTakePhotoView;
        this.f7241pf = i2;
        this.f306if = i3;
        this.f307switch = i4;
        this.when = arrayList;
        mmm(this.f7239i);
        this.ddd = true;
        this.aaa = true;
    }
}
