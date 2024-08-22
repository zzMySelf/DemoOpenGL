package fe.fe.when.qw.qw.yj;

import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de {
    public static final void ad(@NotNull MutableLiveData<ad> mutableLiveData, int i2, @Nullable String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        mutableLiveData.setValue(new ad(Integer.valueOf(i2), str));
    }

    public static final void de(@NotNull MutableLiveData<ad> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        ad(mutableLiveData, 1005, "msg not support");
    }

    public static final void qw(@NotNull MutableLiveData<ad> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        ad(mutableLiveData, 1003, "purchase err");
    }
}
