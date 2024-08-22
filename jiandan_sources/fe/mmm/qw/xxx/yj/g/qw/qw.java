package fe.mmm.qw.xxx.yj.g.qw;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tera.scan.main.home.BaseViewHolder;
import com.tera.scan.main.home.bean.recordwrapper.RecordWrapper;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class qw<T extends RecordWrapper<?>> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public Context f8690ad;
    @NotNull
    public final MainActivityViewModel qw;

    public qw(@NotNull MainActivityViewModel mainActivityViewModel) {
        Intrinsics.checkNotNullParameter(mainActivityViewModel, "viewModel");
        this.qw = mainActivityViewModel;
        this.f8690ad = mainActivityViewModel.getApplication();
    }

    @NotNull
    public final Context ad() {
        return this.f8690ad;
    }

    @NotNull
    public abstract List<T> de();

    public abstract int fe();

    public final void ggg() {
        this.qw.updateSelectItemCount(uk().size());
    }

    @NotNull
    public final MainActivityViewModel i() {
        return this.qw;
    }

    @Nullable
    /* renamed from: if  reason: not valid java name */
    public abstract Object m1010if(@NotNull Context context, @NotNull List<Integer> list, @NotNull Continuation<? super Boolean> continuation);

    public abstract void o(@NotNull Activity activity, int i2);

    @Nullable
    public abstract Object pf(@NotNull Context context, int i2, @NotNull String str, @NotNull Continuation<? super Boolean> continuation);

    public abstract void ppp(@NotNull Context context);

    public final void qw() {
        uk().clear();
        this.qw.updateSelectItemCount(uk().size());
    }

    @NotNull
    public abstract LiveData<List<T>> rg();

    /* renamed from: switch  reason: not valid java name */
    public final void m1011switch() {
        CollectionsKt__MutableCollectionsKt.addAll(uk(), RangesKt___RangesKt.until(0, de().size()));
        this.qw.updateSelectItemCount(uk().size());
    }

    @NotNull
    public final MutableLiveData<Integer> th() {
        return this.qw.getSelectFileCount();
    }

    @NotNull
    public final Set<Integer> uk() {
        return this.qw.getSelectItemList();
    }

    public abstract void when(@NotNull BaseViewHolder baseViewHolder, @NotNull RecordWrapper<?> recordWrapper);

    public final int yj() {
        Integer value = th().getValue();
        if (value == null) {
            return 0;
        }
        return value.intValue();
    }
}
