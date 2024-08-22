package fe.mmm.qw.th.qw.th.p031switch;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: fe.mmm.qw.th.qw.th.switch.ad  reason: invalid package */
public final class ad {
    public static final void ad(WeakReference weakReference, LiveData liveData) {
        Intrinsics.checkNotNullParameter(weakReference, "$observerRef");
        Intrinsics.checkNotNullParameter(liveData, "$this_removeObserverSafe");
        Observer observer = (Observer) weakReference.get();
        if (observer != null) {
            liveData.removeObserver(observer);
        }
    }

    public static final <T> void de(@NotNull MutableLiveData<? super T> mutableLiveData, T t) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        if (fe.ad()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }

    public static final <T> void qw(@NotNull LiveData<T> liveData, @NotNull Observer<T> observer) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(observer, "observer");
        WeakReference weakReference = new WeakReference(observer);
        if (fe.ad()) {
            liveData.removeObserver(observer);
        } else {
            new Handler(Looper.getMainLooper()).post(new qw(weakReference, liveData));
        }
    }
}
