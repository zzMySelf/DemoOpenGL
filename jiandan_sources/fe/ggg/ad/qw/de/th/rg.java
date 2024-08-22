package fe.ggg.ad.qw.de.th;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.mars.united.core.os.livedata.SingleObserver;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rg {
    public static final void ad(LiveData liveData, Observer observer) {
        Intrinsics.checkNotNullParameter(liveData, "$this_observerForeverSafe");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        liveData.observeForever(observer);
    }

    public static final <T> void de(@NotNull LiveData<T> liveData, @NotNull Observer<T> observer) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(observer, "observer");
        WeakReference weakReference = new WeakReference(observer);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            liveData.removeObserver(observer);
        } else {
            new Handler(Looper.getMainLooper()).post(new de(weakReference, liveData));
        }
    }

    public static final void fe(WeakReference weakReference, LiveData liveData) {
        Intrinsics.checkNotNullParameter(weakReference, "$observerRef");
        Intrinsics.checkNotNullParameter(liveData, "$this_removeObserverSafe");
        Observer observer = (Observer) weakReference.get();
        if (observer != null) {
            liveData.removeObserver(observer);
        }
    }

    public static final <T> void qw(@NotNull LiveData<T> liveData, @NotNull Observer<T> observer) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            liveData.observeForever(observer);
        } else {
            new Handler(Looper.getMainLooper()).post(new ad(liveData, observer));
        }
    }

    public static final <T> void rg(@NotNull LiveData<T> liveData, @Nullable LifecycleOwner lifecycleOwner, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(function1, "result");
        new SingleObserver().ad(liveData, lifecycleOwner, function1);
    }

    public static /* synthetic */ void th(LiveData liveData, LifecycleOwner lifecycleOwner, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lifecycleOwner = null;
        }
        rg(liveData, lifecycleOwner, function1);
    }

    public static final <T> void yj(@NotNull MutableLiveData<? super T> mutableLiveData, T t) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }
}
