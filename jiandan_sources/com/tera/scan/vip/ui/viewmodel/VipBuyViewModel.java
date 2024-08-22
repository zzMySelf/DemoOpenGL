package com.tera.scan.vip.ui.viewmodel;

import android.app.Application;
import android.app.Dialog;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.baidu.aiscan.R;
import com.google.common.net.MediaType;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.component.base.ui.widget.LoadingDialog;
import com.tera.scan.vip.util.VipSellerCodeReview;
import fe.mmm.qw.th.qw.th.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0007J(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tera/scan/vip/ui/viewmodel/VipBuyViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_loginResultLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "loadingDialog", "Landroid/app/Dialog;", "buy", "Landroidx/lifecycle/LiveData;", "Lcom/tera/scan/vip/model/VipBuyResult;", "seller", "Lcom/tera/scan/vip/util/VipSellerCodeReview;", "acceptProgressState", "login", "activity", "Landroidx/fragment/app/FragmentActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "loginFromStat", "", "needLogin", "Companion", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("VipBuyViewModel")
public final class VipBuyViewModel extends AndroidViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public Dialog f7470ad;
    @NotNull
    public final MutableLiveData<Boolean> qw = new MutableLiveData<>();

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VipBuyViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
    }

    public static /* synthetic */ LiveData buy$default(VipBuyViewModel vipBuyViewModel, VipSellerCodeReview vipSellerCodeReview, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return vipBuyViewModel.buy(vipSellerCodeReview, z);
    }

    public static /* synthetic */ LiveData login$default(VipBuyViewModel vipBuyViewModel, FragmentActivity fragmentActivity, Fragment fragment, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fragment = null;
        }
        return vipBuyViewModel.login(fragmentActivity, fragment, str);
    }

    public static final void qw(boolean z, VipBuyViewModel vipBuyViewModel, MutableLiveData mutableLiveData, fe.mmm.qw.k.yj.qw qwVar) {
        Intrinsics.checkNotNullParameter(vipBuyViewModel, "this$0");
        Intrinsics.checkNotNullParameter(mutableLiveData, "$buyResultLiveData");
        if (!qwVar.fe() && !TextUtils.isEmpty(qwVar.qw())) {
            o.uk(qwVar.qw());
        }
        if (z) {
            Dialog dialog = vipBuyViewModel.f7470ad;
            if (dialog != null) {
                dialog.dismiss();
            }
            mutableLiveData.postValue(qwVar);
        } else if (!qwVar.de()) {
            Dialog dialog2 = vipBuyViewModel.f7470ad;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            mutableLiveData.postValue(qwVar);
        }
    }

    @NotNull
    public final LiveData<fe.mmm.qw.k.yj.qw> buy(@NotNull VipSellerCodeReview vipSellerCodeReview, boolean z) {
        Intrinsics.checkNotNullParameter(vipSellerCodeReview, "seller");
        MutableLiveData mutableLiveData = new MutableLiveData();
        Object obj = vipSellerCodeReview.fe().get();
        FragmentActivity fragmentActivity = obj instanceof FragmentActivity ? (FragmentActivity) obj : null;
        if (fragmentActivity == null) {
            return mutableLiveData;
        }
        if (this.f7470ad == null) {
            Dialog build = LoadingDialog.build(fragmentActivity, fragmentActivity.getString(R.string.vip_pay_create_order_ing));
            build.setCancelable(false);
            this.f7470ad = build;
        }
        Dialog dialog = this.f7470ad;
        if (dialog != null) {
            dialog.show();
        }
        vipSellerCodeReview.ad().observe(fragmentActivity, new fe.mmm.qw.k.pf.o.qw(z, this, mutableLiveData));
        return mutableLiveData;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.LiveData<java.lang.Boolean> login(@org.jetbrains.annotations.NotNull androidx.fragment.app.FragmentActivity r3, @org.jetbrains.annotations.Nullable androidx.fragment.app.Fragment r4, @org.jetbrains.annotations.NotNull java.lang.String r5) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "loginFromStat"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            fe.mmm.qw.qw.qw r0 = fe.mmm.qw.qw.qw.qw
            if (r4 != 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r3 = r4
        L_0x0010:
            r4 = 1
            com.tera.scan.vip.ui.viewmodel.VipBuyViewModel$login$1 r1 = new com.tera.scan.vip.ui.viewmodel.VipBuyViewModel$login$1
            r1.<init>(r2)
            r0.vvv(r3, r5, r4, r1)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r3 = r2.qw
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.vip.ui.viewmodel.VipBuyViewModel.login(androidx.fragment.app.FragmentActivity, androidx.fragment.app.Fragment, java.lang.String):androidx.lifecycle.LiveData");
    }

    public final boolean needLogin() {
        return !fe.mmm.qw.qw.qw.qw.pf();
    }
}
