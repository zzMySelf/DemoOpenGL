package com.tera.scan.component.base.util.ex;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.mars.kotlin.service.Result;
import fe.mmm.qw.th.qw.th.p031switch.ad;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/tera/scan/component/base/util/ex/LiveDataKt$await$2$observer$1", "Landroidx/lifecycle/Observer;", "Lcom/mars/kotlin/service/Result;", "onChanged", "", "t", "component-base_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LiveDataKt$await$2$observer$1 implements Observer<Result<T>> {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<T> f6867ad;
    public final /* synthetic */ LiveData<Result<T>> qw;

    public void onChanged(@Nullable Result<T> result) {
        ad.qw(this.qw, this);
        T data = result != null ? result.getData() : null;
        if (data != null) {
            CancellableContinuation<T> cancellableContinuation = this.f6867ad;
            Result.Companion companion = kotlin.Result.Companion;
            cancellableContinuation.resumeWith(kotlin.Result.m1155constructorimpl(data));
            return;
        }
        CancellableContinuation<T> cancellableContinuation2 = this.f6867ad;
        Result.Companion companion2 = kotlin.Result.Companion;
        cancellableContinuation2.resumeWith(kotlin.Result.m1155constructorimpl(ResultKt.createFailure(new NullPointerException())));
    }
}
