package com.tera.scan.scanner.ocr.control;

import android.app.Application;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.aiscan.R;
import com.google.common.net.MediaType;
import com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel;
import fe.mmm.qw.th.qw.rg.fe.de.qw;
import fe.mmm.qw.tt.ad.i;
import fe.mmm.qw.tt.ad.when.Cif;
import fe.mmm.qw.tt.ad.when.de;
import fe.mmm.qw.tt.ad.when.fe;
import fe.mmm.qw.tt.ad.when.th;
import fe.mmm.qw.tt.ad.when.when;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BR\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tera/scan/scanner/ocr/control/TakeSingleOrMultipleView;", "", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "findViewById", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "resId", "Landroid/view/View;", "application", "Landroid/app/Application;", "pdfMode", "category", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroid/app/Application;II)V", "singleOrMultiLayout", "takeMultipleButton", "takePhotoViewModel", "Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "getTakePhotoViewModel", "()Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "takePhotoViewModel$delegate", "Lkotlin/Lazy;", "takeSingleButton", "changeSingleOrMultiple", "", "isSingle", "", "init", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TakeSingleOrMultipleView {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final LifecycleOwner f7263ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Function1<Integer, View> f7264de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f7265fe;
    @NotNull
    public final ViewModelStoreOwner qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public View f7266rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public View f7267th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final Lazy f7268uk = LazyKt__LazyJVMKt.lazy(new TakeSingleOrMultipleView$takePhotoViewModel$2(this));
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public View f7269yj;

    public TakeSingleOrMultipleView(@NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super Integer, ? extends View> function1, @NotNull Application application, int i2, int i3) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(function1, "findViewById");
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        this.qw = viewModelStoreOwner;
        this.f7263ad = lifecycleOwner;
        this.f7264de = function1;
        this.f7265fe = i3;
        fe();
    }

    public static final void i(TakeSingleOrMultipleView takeSingleOrMultipleView, i iVar) {
        Intrinsics.checkNotNullParameter(takeSingleOrMultipleView, "this$0");
        if (iVar.rg()) {
            View view = takeSingleOrMultipleView.f7266rg;
            if (view != null) {
                qw.fe(view);
                return;
            }
            return;
        }
        View view2 = takeSingleOrMultipleView.f7266rg;
        if (view2 != null) {
            qw.qw(view2);
        }
    }

    public static final void rg(TakeSingleOrMultipleView takeSingleOrMultipleView, View view) {
        Intrinsics.checkNotNullParameter(takeSingleOrMultipleView, "this$0");
        takeSingleOrMultipleView.ad(true);
        fe.mmm.qw.tt.fe.qw.ad("S&MPhotos_clk", "CameraPage", (String) null, takeSingleOrMultipleView.de().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(takeSingleOrMultipleView.f7265fe)), TuplesKt.to("singleOrMulti", "single")), 4, (Object) null);
    }

    public static final void th(TakeSingleOrMultipleView takeSingleOrMultipleView, View view) {
        Intrinsics.checkNotNullParameter(takeSingleOrMultipleView, "this$0");
        takeSingleOrMultipleView.ad(false);
        fe.mmm.qw.tt.fe.qw.ad("S&MPhotos_clk", "CameraPage", (String) null, takeSingleOrMultipleView.de().getUbcSource$scanner_aiscanConfigRelease(), MapsKt__MapsKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(takeSingleOrMultipleView.f7265fe)), TuplesKt.to("singleOrMulti", "multi")), 4, (Object) null);
    }

    public static final void uk(TakeSingleOrMultipleView takeSingleOrMultipleView, Boolean bool) {
        Intrinsics.checkNotNullParameter(takeSingleOrMultipleView, "this$0");
        if (takeSingleOrMultipleView.de().supportSingleMode()) {
            Intrinsics.checkNotNullExpressionValue(bool, "takingMode");
            if (!bool.booleanValue() || takeSingleOrMultipleView.de().isSingleMode()) {
                View view = takeSingleOrMultipleView.f7266rg;
                if (view != null) {
                    qw.fe(view);
                    return;
                }
                return;
            }
        }
        View view2 = takeSingleOrMultipleView.f7266rg;
        if (view2 != null) {
            qw.qw(view2);
        }
    }

    public static final void yj(TakeSingleOrMultipleView takeSingleOrMultipleView, Boolean bool) {
        Intrinsics.checkNotNullParameter(takeSingleOrMultipleView, "this$0");
        View view = takeSingleOrMultipleView.f7267th;
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "isSingle");
            view.setSelected(bool.booleanValue());
        }
        View view2 = takeSingleOrMultipleView.f7269yj;
        if (view2 != null) {
            view2.setSelected(!bool.booleanValue());
        }
    }

    public final void ad(boolean z) {
        if (!de().isTakingMode()) {
            de().setIsTakeSingle(z);
        }
    }

    public final OCRTakePhotoViewModel de() {
        return (OCRTakePhotoViewModel) this.f7268uk.getValue();
    }

    public final void fe() {
        this.f7266rg = this.f7264de.invoke(Integer.valueOf(R.id.single_or_multi_mode));
        if (!de().supportSingleMode()) {
            View view = this.f7266rg;
            if (view != null) {
                qw.qw(view);
            }
        } else {
            View view2 = this.f7266rg;
            if (view2 != null) {
                qw.fe(view2);
            }
        }
        View invoke = this.f7264de.invoke(Integer.valueOf(R.id.take_single));
        this.f7267th = invoke;
        if (invoke != null) {
            invoke.setSelected(true);
        }
        View view3 = this.f7267th;
        if (view3 != null) {
            view3.setOnClickListener(new th(this));
        }
        View invoke2 = this.f7264de.invoke(Integer.valueOf(R.id.take_multiple));
        this.f7269yj = invoke2;
        if (invoke2 != null) {
            invoke2.setSelected(false);
        }
        View view4 = this.f7269yj;
        if (view4 != null) {
            view4.setOnClickListener(new Cif(this));
        }
        de().isTakeSingle().observe(this.f7263ad, new de(this));
        de().isTakingMode$scanner_aiscanConfigRelease().observe(this.f7263ad, new fe(this));
        de().getCurrentBottomTab$scanner_aiscanConfigRelease().observe(this.f7263ad, new when(this));
    }
}
