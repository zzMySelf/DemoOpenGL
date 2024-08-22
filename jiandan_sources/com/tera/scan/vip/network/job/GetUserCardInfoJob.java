package com.tera.scan.vip.network.job;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.vip.network.model.UserCardInfoResponse;
import fe.mmm.qw.k.uk.qw;
import fe.mmm.qw.nn.qw.qw.i;
import i.qw.Cif;
import i.qw.i0;
import i.qw.u;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0002J\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/tera/scan/vip/network/job/GetUserCardInfoJob;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "execute", "", "livedata", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tera/scan/vip/network/model/UserCardInfoResponse;", "getUserCardInfo", "Landroidx/lifecycle/LiveData;", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetUserCardInfoJob {
    @NotNull
    public final Context qw;

    public GetUserCardInfoJob(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw = context;
    }

    public final void ad(MutableLiveData<UserCardInfoResponse> mutableLiveData) {
        if (!i.rg(this.qw)) {
            mutableLiveData.postValue(null);
            return;
        }
        Either<Pair<String, Integer>, UserCardInfoResponse> i2 = new qw().i();
        if (i2 instanceof Either.Right) {
            mutableLiveData.postValue(((Either.Right) i2).getValue());
        } else {
            mutableLiveData.postValue(null);
        }
    }

    @NotNull
    public final LiveData<UserCardInfoResponse> de() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        Job unused = Cif.fe(i0.f6136ad, u.ad(), (CoroutineStart) null, new GetUserCardInfoJob$getUserCardInfo$1(this, mutableLiveData, (Continuation<? super GetUserCardInfoJob$getUserCardInfo$1>) null), 2, (Object) null);
        return mutableLiveData;
    }
}
