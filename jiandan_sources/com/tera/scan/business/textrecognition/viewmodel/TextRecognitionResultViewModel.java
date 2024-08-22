package com.tera.scan.business.textrecognition.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.baidu.netdisk.trade.privilege.MemberProduct;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.google.common.net.MediaType;
import com.tera.scan.vip.model.PrivilegeType;
import com.tera.scan.vip.util.VipRightsManager;
import fe.mmm.qw.rg.de.tt.qw;
import fe.mmm.qw.th.qw.th.p031switch.ad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J-\u0010\u0012\u001a\u00020\u00112%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/tera/scan/business/textrecognition/viewmodel/TextRecognitionResultViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_freeCount", "Landroidx/lifecycle/MutableLiveData;", "", "_privilegeBannerViewVisibility", "", "freeCount", "Landroidx/lifecycle/LiveData;", "getFreeCount", "()Landroidx/lifecycle/LiveData;", "privilegeBannerViewVisibility", "getPrivilegeBannerViewVisibility", "closePrivilegeBannerView", "", "consumeOncePrivilege", "onResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "initPrivilegeBannerViewVisibility", "privilegeEnable", "queryPrivilegeFreeCount", "syncUserPrivilege", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultViewModel extends AndroidViewModel {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final LiveData<Boolean> f6825ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final MutableLiveData<Integer> f6826de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final LiveData<Integer> f6827fe;
    @NotNull
    public final MutableLiveData<Boolean> qw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.FALSE);
        this.qw = mutableLiveData;
        this.f6825ad = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this.f6826de = mutableLiveData2;
        this.f6827fe = mutableLiveData2;
    }

    public static final void ad(TextRecognitionResultViewModel textRecognitionResultViewModel, Boolean bool) {
        Intrinsics.checkNotNullParameter(textRecognitionResultViewModel, "this$0");
        textRecognitionResultViewModel.initPrivilegeBannerViewVisibility();
        textRecognitionResultViewModel.queryPrivilegeFreeCount();
    }

    public static /* synthetic */ void consumeOncePrivilege$default(TextRecognitionResultViewModel textRecognitionResultViewModel, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = null;
        }
        textRecognitionResultViewModel.consumeOncePrivilege(function1);
    }

    public static final void qw(Ref.IntRef intRef, TextRecognitionResultViewModel textRecognitionResultViewModel, Boolean bool) {
        Intrinsics.checkNotNullParameter(intRef, "$count");
        Intrinsics.checkNotNullParameter(textRecognitionResultViewModel, "this$0");
        int rg2 = VipRightsManager.qw.rg(PrivilegeType.recognitionText.getValue());
        intRef.element = rg2;
        if (rg2 < 0) {
            intRef.element = VipRightsManager.qw.de(PrivilegeType.recognitionText.getValue());
        }
        ad.de(textRecognitionResultViewModel.f6826de, Integer.valueOf(intRef.element));
    }

    public final void closePrivilegeBannerView() {
        ad.de(this.qw, Boolean.FALSE);
    }

    public final void consumeOncePrivilege(@Nullable Function1<? super Boolean, Unit> function1) {
        VipRightsManager.qw.ad(PrivilegeType.recognitionText.getValue(), new TextRecognitionResultViewModel$consumeOncePrivilege$1(function1, this));
    }

    @NotNull
    public final LiveData<Integer> getFreeCount() {
        return this.f6827fe;
    }

    @NotNull
    public final LiveData<Boolean> getPrivilegeBannerViewVisibility() {
        return this.f6825ad;
    }

    public final void initPrivilegeBannerViewVisibility() {
        ad.de(this.qw, Boolean.valueOf(!TradeAccount.f913rg.o(MemberProduct.SCAN_VIP)));
    }

    public final boolean privilegeEnable() {
        Integer value = this.f6826de.getValue();
        if (value == null) {
            value = 0;
        }
        int intValue = value.intValue();
        if (TradeAccount.f913rg.o(MemberProduct.SCAN_VIP) || intValue > 0) {
            return true;
        }
        return false;
    }

    public final void queryPrivilegeFreeCount() {
        Ref.IntRef intRef = new Ref.IntRef();
        int rg2 = VipRightsManager.qw.rg(PrivilegeType.recognitionText.getValue());
        intRef.element = rg2;
        if (rg2 >= 0) {
            ad.de(this.f6826de, Integer.valueOf(rg2));
        } else {
            TradeAccount.f913rg.uk(new qw(intRef, this));
        }
    }

    public final void syncUserPrivilege() {
        TradeAccount.f913rg.uk(new fe.mmm.qw.rg.de.tt.ad(this));
    }
}
