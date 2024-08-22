package fe.mmm.qw.d.fe;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull
    public static final qw qw = new qw();

    public final void ad(@NotNull Context context, @Nullable Bundle bundle) {
        Object obj;
        Set<String> keySet;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            if (bundle != null && qw()) {
                bundle.setClassLoader(context.getClass().getClassLoader());
                Bundle bundle2 = bundle.getBundle(SavedStateRegistry.SAVED_COMPONENTS_KEY);
                if (!(bundle2 == null || (keySet = bundle2.keySet()) == null)) {
                    Intrinsics.checkNotNullExpressionValue(keySet, "keySet()");
                    for (String str : keySet) {
                        Object obj2 = bundle2.get(str);
                        Bundle bundle3 = obj2 instanceof Bundle ? (Bundle) obj2 : null;
                        if (bundle3 != null) {
                            bundle3.setClassLoader(context.getClass().getClassLoader());
                        }
                    }
                }
            }
            obj = Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r4 = Result.m1158exceptionOrNullimpl(obj);
        if (r4 != null) {
            r4.printStackTrace();
        }
    }

    public final boolean qw() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 29 || i2 == 28;
    }
}
