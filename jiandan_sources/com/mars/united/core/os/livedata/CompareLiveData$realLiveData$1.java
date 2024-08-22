package com.mars.united.core.os.livedata;

import androidx.lifecycle.MutableLiveData;
import fe.ggg.ad.qw.de.th.fe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"com/mars/united/core/os/livedata/CompareLiveData$realLiveData$1", "Landroidx/lifecycle/MutableLiveData;", "setValue", "", "value", "(Ljava/lang/Object;)V", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CompareLiveData$realLiveData$1 extends MutableLiveData<T> {
    public final /* synthetic */ fe<T> qw;

    public void setValue(T t) {
        if (Intrinsics.areEqual(this.qw.qw, getValue())) {
            super.setValue(t);
        }
    }
}
