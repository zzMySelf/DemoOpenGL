package fe.mmm.qw.tt.ad;

import android.content.Context;
import android.content.Intent;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoView;
import com.tera.scan.scanner.ocr.control.OCRRemoveWatermarkControl;
import com.tera.scan.scanner.ocr.control.OCRToPDFControl;
import com.tera.scan.scanner.ocr.control.OCRToPaperRemoveHandWrittenControl;
import com.tera.scan.scanner.ocr.control.OCRToWordControl;
import com.tera.scan.scanner.ocr.control.PhotoToWordControl;
import com.tera.scan.scanner.ocr.control.ScanIdCardsControl;
import com.tera.scan.scanner.ocr.qrscan.OcrScannerControl;
import fe.mmm.qw.th.qw.th.uk;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.tt.ad.switch  reason: invalid class name */
public final class Cswitch {

    /* renamed from: ad  reason: collision with root package name */
    public final int f8418ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f8419de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f8420fe;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final Function0<IOCRTakePhotoView> f8421i;

    /* renamed from: if  reason: not valid java name */
    public int f345if;

    /* renamed from: o  reason: collision with root package name */
    public int f8422o;

    /* renamed from: pf  reason: collision with root package name */
    public int f8423pf;
    public final int qw;

    /* renamed from: rg  reason: collision with root package name */
    public final int f8424rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Context f8425th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final Function0<OCRTakePhotoActivity> f8426uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public final Intent f8427yj;

    public Cswitch(int i2, int i3, int i4, int i5, int i6, @NotNull Context context, @Nullable Intent intent, @NotNull Function0<OCRTakePhotoActivity> function0, @NotNull Function0<? extends IOCRTakePhotoView> function02) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "getActivity");
        Intrinsics.checkNotNullParameter(function02, "getOcrTakePhotoView");
        this.qw = i2;
        this.f8418ad = i3;
        this.f8419de = i4;
        this.f8420fe = i5;
        this.f8424rg = i6;
        this.f8425th = context;
        this.f8427yj = intent;
        this.f8426uk = function0;
        this.f8421i = function02;
        int i7 = 0;
        if (i4 == 1) {
            this.f8422o = intent != null ? intent.getIntExtra(OCRTakePhotoActivity.EXTRA_PDF_RE_CHOOSE_PAGE, 0) : i7;
        } else if (i4 == 2 || i4 == 3) {
            Intent intent2 = this.f8427yj;
            this.f8423pf = intent2 != null ? intent2.getIntExtra(OCRTakePhotoActivity.EXTRA_PDF_ADD_COUNT, 0) : i7;
        }
    }

    public static /* synthetic */ i i(Cswitch switchR, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return switchR.uk(z, z2);
    }

    public final i ad(boolean z) {
        if (this.f8419de != 0 || z) {
            return null;
        }
        String string = this.f8425th.getResources().getString(R.string.to_word_tab);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(R.string.to_word_tab)");
        return new i(6, string, "", new PhotoToWordControl(this.f8426uk.invoke(), this.f8421i.invoke(), (ArrayList) null, this.f8419de, 4, (DefaultConstructorMarker) null), !z, 12);
    }

    public final i de(boolean z) {
        if ((!z || this.f8420fe != 9) && this.f8419de != 0) {
            return null;
        }
        String string = this.f8425th.getResources().getString(R.string.scan_tab_remove_water_maker);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…n_tab_remove_water_maker)");
        OCRRemoveWatermarkControl oCRRemoveWatermarkControl = new OCRRemoveWatermarkControl(this.f8426uk.invoke(), this.f8419de, this.f8422o, this.f8423pf, this.f8424rg, this.f8421i.invoke(), 15, (ArrayList) null, (ArrayList) null, 384, (DefaultConstructorMarker) null);
        oCRRemoveWatermarkControl.E(this.f345if);
        return new i(9, string, "", oCRRemoveWatermarkControl, !z, 15);
    }

    public final i fe(boolean z) {
        if (this.f8419de != 0 && (3 != this.f8420fe || !z)) {
            return null;
        }
        ScanIdCardsControl scanIdCardsControl = new ScanIdCardsControl(this.f8426uk.invoke(), this.f8421i.invoke(), this.f8419de, this.qw, this.f8418ad, (ArrayList) null, 32, (DefaultConstructorMarker) null);
        String string = this.f8425th.getResources().getString(R.string.id_card_tab_type_id_cards);
        int i2 = this.qw;
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.id_card_tab_type_id_cards)");
        return new i(3, string, "", scanIdCardsControl, false, i2);
    }

    public final i qw(boolean z) {
        if (this.f8419de != 0 || z) {
            return null;
        }
        String string = this.f8425th.getResources().getString(R.string.word_ocr);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(R.string.word_ocr)");
        return new i(1, string, "", new OCRToWordControl(this.f8426uk.invoke(), this.f8424rg, this.f8421i.invoke()), false, 11);
    }

    public final i rg(boolean z) {
        if (this.f8419de != 0 || z) {
            return null;
        }
        return new i(0, uk.ad(R.string.scan_qr_login), "", new OcrScannerControl(this.f8426uk.invoke(), this.f8424rg, this.f8421i.invoke()), false, -2);
    }

    public final i th(boolean z) {
        if (this.f8419de != 0 && (!z || this.f8420fe != 4)) {
            return null;
        }
        return new i(4, uk.ad(R.string.scan_tab_wipe_hand_write), "", new OCRToPaperRemoveHandWrittenControl(this.f8426uk.invoke(), this.f8421i.invoke(), 21, this.f8419de, this.f8423pf, this.f8422o), !z, 21);
    }

    public final i uk(boolean z, boolean z2) {
        if (this.f8420fe != 2 && ((this.f8419de != 0 || z) && !z2)) {
            return null;
        }
        String string = this.f8425th.getResources().getString(R.string.ocr_image_to_pdf);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr….string.ocr_image_to_pdf)");
        OCRToPDFControl oCRToPDFControl = new OCRToPDFControl(this.f8426uk.invoke(), this.f8419de, this.f8422o, this.f8423pf, this.f8424rg, this.f8421i.invoke(), 0, (ArrayList) null, (ArrayList) null, 384, (DefaultConstructorMarker) null);
        oCRToPDFControl.E(this.f345if);
        return new i(2, string, "", oCRToPDFControl, !z, 0);
    }

    @NotNull
    public final List<i> yj() {
        IOCRTakePhotoControl ad2;
        int i2 = this.f8419de;
        boolean z = i2 == 1 || i2 == 2 || i2 == 3;
        List<i> listOf = CollectionsKt__CollectionsKt.listOf(rg(z), de(z), th(z), i(this, z, false, 2, (Object) null), ad(z), qw(z), fe(z));
        for (i iVar : listOf) {
            StringBuilder sb = new StringBuilder();
            sb.append("add ");
            sb.append(iVar != null ? iVar.getClass() : null);
            sb.append(" ocrToPDFControl hash ");
            sb.append((iVar == null || (ad2 = iVar.ad()) == null) ? null : Integer.valueOf(ad2.hashCode()));
            LoggerKt.d(sb.toString(), "OCRBottomTab");
        }
        return CollectionsKt___CollectionsKt.filterNotNull(listOf);
    }
}
