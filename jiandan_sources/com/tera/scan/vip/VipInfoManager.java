package com.tera.scan.vip;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.service.Result;
import com.tera.scan.vip.network.model.MemberInfo;
import com.tera.scan.vip.network.model.ProductInfo;
import com.tera.scan.vip.network.model.UserInfoData;
import com.tera.scan.vip.network.model.UserInfoResponse;
import fe.mmm.qw.k.de;
import fe.mmm.qw.k.qw;
import i.qw.Cif;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010\u0017\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010\"\u001a\u00020#J\u0018\u0010$\u001a\u00020#2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0002J\"\u0010(\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006+"}, d2 = {"Lcom/tera/scan/vip/VipInfoManager;", "", "()V", "DEFAULT_REFRESH_USER_REPEAT_COUNT", "", "DEFAULT_REFRESH_USER_TIMES", "", "TAG", "", "VIP_NUMBER_OF_EQUITY", "_userInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tera/scan/vip/network/model/MemberInfo;", "_vipProductList", "", "Lcom/tera/scan/vip/network/model/ProductInfo;", "_vipState", "Lcom/tera/scan/vip/VipStates;", "continuousMonthlyDiscount", "Landroidx/lifecycle/LiveData;", "getContinuousMonthlyDiscount", "()Landroidx/lifecycle/LiveData;", "userInfo", "getUserInfo", "vipProductList", "getVipProductList", "vipState", "getVipState", "clearData", "", "getProducts", "context", "Landroid/content/Context;", "init", "isVip", "", "parseUserInfo", "result", "Lcom/mars/kotlin/service/Result;", "Lcom/tera/scan/vip/network/model/UserInfoResponse;", "refreshUserInfoDelayAndRepeat", "delayTime", "repeatCount", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VipInfoManager {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final MutableLiveData<de> f7454ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static final LiveData<de> f7455de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public static final MutableLiveData<MemberInfo> f7456fe;
    @NotNull
    public static final VipInfoManager qw = new VipInfoManager();
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public static final LiveData<MemberInfo> f7457rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public static final MutableLiveData<List<ProductInfo>> f7458th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public static final LiveData<Integer> f7459uk;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public static final LiveData<List<ProductInfo>> f7460yj;

    static {
        MutableLiveData<de> mutableLiveData = new MutableLiveData<>();
        f7454ad = mutableLiveData;
        f7455de = mutableLiveData;
        MutableLiveData<MemberInfo> mutableLiveData2 = new MutableLiveData<>();
        f7456fe = mutableLiveData2;
        f7457rg = mutableLiveData2;
        MutableLiveData<List<ProductInfo>> mutableLiveData3 = new MutableLiveData<>();
        f7458th = mutableLiveData3;
        f7460yj = mutableLiveData3;
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(f7458th, new qw(mediatorLiveData));
        f7459uk = mediatorLiveData;
    }

    public static final void de(MediatorLiveData mediatorLiveData, List list) {
        ProductInfo productInfo;
        Intrinsics.checkNotNullParameter(mediatorLiveData, "$this_apply");
        List value = f7460yj.getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            for (Object next : value) {
                if (Intrinsics.areEqual((Object) ((ProductInfo) next).isRecommend(), (Object) Boolean.TRUE)) {
                    arrayList.add(next);
                }
            }
            productInfo = (ProductInfo) CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
        } else {
            productInfo = null;
        }
        mediatorLiveData.setValue(productInfo != null ? Integer.valueOf(productInfo.getSavePercentage()) : 0);
    }

    public static /* synthetic */ void o(VipInfoManager vipInfoManager, Context context, long j, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j = ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS;
        }
        if ((i3 & 4) != 0) {
            i2 = 3;
        }
        vipInfoManager.i(context, j, i2);
    }

    @NotNull
    public final LiveData<Integer> fe() {
        return f7459uk;
    }

    public final void i(@NotNull Context context, long j, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        LoggerKt.d("刷新用户信息 ", "");
        Job unused = Cif.fe(fe.mmm.qw.p030switch.th.ad.qw.qw.qw(), (CoroutineContext) null, (CoroutineStart) null, new VipInfoManager$refreshUserInfoDelayAndRepeat$1(i2, j, context, (Continuation<? super VipInfoManager$refreshUserInfoDelayAndRepeat$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<MemberInfo> rg() {
        return f7457rg;
    }

    @NotNull
    public final LiveData<de> th() {
        return f7455de;
    }

    public final boolean uk(Result<UserInfoResponse> result) {
        UserInfoData data;
        MemberInfo memberInfo;
        UserInfoData data2;
        UserInfoData data3;
        if (!(result == null || result.getData() == null)) {
            UserInfoResponse data4 = result.getData();
            MemberInfo memberInfo2 = null;
            if ((data4 != null ? data4.getData() : null) != null) {
                UserInfoResponse data5 = result.getData();
                if (((data5 == null || (data3 = data5.getData()) == null) ? null : data3.getMemberInfo()) != null) {
                    MutableLiveData<MemberInfo> mutableLiveData = f7456fe;
                    UserInfoResponse data6 = result.getData();
                    if (!(data6 == null || (data2 = data6.getData()) == null)) {
                        memberInfo2 = data2.getMemberInfo();
                    }
                    mutableLiveData.postValue(memberInfo2);
                    UserInfoResponse data7 = result.getData();
                    if (data7 == null || (data = data7.getData()) == null || (memberInfo = data.getMemberInfo()) == null) {
                        return false;
                    }
                    String vipStatus = memberInfo.getVipStatus();
                    if (Intrinsics.areEqual((Object) vipStatus, (Object) "1")) {
                        f7454ad.postValue(de.C0284de.qw);
                        return true;
                    } else if (Intrinsics.areEqual((Object) vipStatus, (Object) "2")) {
                        f7454ad.postValue(de.ad.qw);
                        return false;
                    } else {
                        f7454ad.postValue(de.qw.qw);
                        return false;
                    }
                }
            }
        }
        f7454ad.postValue(de.qw.qw);
        return false;
    }

    public final boolean yj() {
        return Intrinsics.areEqual((Object) f7455de.getValue(), (Object) de.C0284de.qw);
    }
}
