package com.tera.scan.vip;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.service.Result;
import com.tera.scan.vip.network.model.UserInfoResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tera/scan/vip/VipInfoManager$refreshUserInfoDelayAndRepeat$1$isVip$1$1", "Landroidx/lifecycle/Observer;", "Lcom/mars/kotlin/service/Result;", "Lcom/tera/scan/vip/network/model/UserInfoResponse;", "onChanged", "", "result", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VipInfoManager$refreshUserInfoDelayAndRepeat$1$isVip$1$1 implements Observer<Result<UserInfoResponse>> {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Boolean> f7461ad;
    public final /* synthetic */ LiveData<Result<UserInfoResponse>> qw;

    public VipInfoManager$refreshUserInfoDelayAndRepeat$1$isVip$1$1(LiveData<Result<UserInfoResponse>> liveData, CancellableContinuation<? super Boolean> cancellableContinuation) {
        this.qw = liveData;
        this.f7461ad = cancellableContinuation;
    }

    public void onChanged(@Nullable Result<UserInfoResponse> result) {
        Object obj;
        this.qw.removeObserver(this);
        CancellableContinuation<Boolean> cancellableContinuation = this.f7461ad;
        try {
            Result.Companion companion = kotlin.Result.Companion;
            Result.Companion companion2 = kotlin.Result.Companion;
            cancellableContinuation.resumeWith(kotlin.Result.m1155constructorimpl(Boolean.valueOf(VipInfoManager.qw.uk(result))));
            obj = kotlin.Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion3 = kotlin.Result.Companion;
            obj = kotlin.Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r3 = kotlin.Result.m1158exceptionOrNullimpl(obj);
        if (r3 != null) {
            LoggerKt.d$default("refreshUserInfoDelayAndRepeat resumeWith fail " + r3.getMessage(), (Object) null, 1, (Object) null);
        }
    }
}
