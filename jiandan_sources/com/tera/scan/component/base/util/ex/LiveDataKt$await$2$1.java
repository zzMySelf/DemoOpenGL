package com.tera.scan.component.base.util.ex;

import androidx.lifecycle.LiveData;
import com.mars.kotlin.service.Result;
import fe.mmm.qw.th.qw.th.p031switch.ad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LiveDataKt$await$2$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ LiveDataKt$await$2$observer$1 $observer;
    public final /* synthetic */ LiveData<Result<T>> $this_await;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDataKt$await$2$1(LiveData<Result<T>> liveData, LiveDataKt$await$2$observer$1 liveDataKt$await$2$observer$1) {
        super(1);
        this.$this_await = liveData;
        this.$observer = liveDataKt$await$2$observer$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        ad.qw(this.$this_await, this.$observer);
    }
}
