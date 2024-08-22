package fe.mmm.qw.ggg.ad.yj;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static int f7836ad;

    /* renamed from: de  reason: collision with root package name */
    public static boolean f7837de = true;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public static final MutableLiveData<Boolean> f7838fe = new MutableLiveData<>();
    @NotNull
    public static final List<FragmentActivity> qw = new ArrayList();

    public static final boolean i(@NotNull String str) {
        T t;
        Intrinsics.checkNotNullParameter(str, "activityName");
        Iterator<T> it = qw.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual((Object) ((FragmentActivity) t).getClass().getName(), (Object) str)) {
                break;
            }
        }
        return t != null;
    }

    public static final boolean o() {
        return f7836ad > 0;
    }

    public static final void th(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "toActivityName");
        if (!qw.isEmpty()) {
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(qw);
            while (-1 < lastIndex) {
                FragmentActivity fragmentActivity = qw.get(lastIndex);
                if (!Intrinsics.areEqual((Object) fragmentActivity.getClass().getName(), (Object) str)) {
                    fragmentActivity.finish();
                    lastIndex--;
                } else {
                    return;
                }
            }
        }
    }

    @Nullable
    public static final FragmentActivity uk() {
        if (!(!qw.isEmpty())) {
            return null;
        }
        List<FragmentActivity> list = qw;
        return list.get(list.size() - 1);
    }

    @NotNull
    public static final MutableLiveData<Boolean> yj() {
        return f7838fe;
    }
}
