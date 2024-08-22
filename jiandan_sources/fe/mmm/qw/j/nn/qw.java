package fe.mmm.qw.j.nn;

import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.utils.listdiff.algorithm.DiffAlgorithmFactory;
import com.tera.scan.utils.listdiff.algorithm.DiffAlgorithmI;
import com.tera.scan.utils.listdiff.algorithm.DiffAlgorithmListener;
import com.tera.scan.utils.listdiff.algorithm.myers.MeyersDiffWithLinearSpace;
import com.tera.scan.utils.listdiff.patch.Patch;
import com.tera.scan.utils.listdiff.patch.exception.PatchFailedException;
import com.tera.scan.utils.listdiff.updatecallback.ListUpdateCallback;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull
    public static final DiffAlgorithmFactory qw = MeyersDiffWithLinearSpace.qw.qw();

    @NotNull
    public static final <T> Patch<T> ad(@NotNull List<? extends T> list, @NotNull List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(list2, "revised");
        return de(list, list2, qw.qw(), (DiffAlgorithmListener) null);
    }

    @NotNull
    public static final <T> Patch<T> de(@NotNull List<? extends T> list, @NotNull List<? extends T> list2, @NotNull DiffAlgorithmI<T> diffAlgorithmI, @Nullable DiffAlgorithmListener diffAlgorithmListener) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(list2, "revised");
        Intrinsics.checkNotNullParameter(diffAlgorithmI, "algorithm");
        return fe(list, list2, diffAlgorithmI, diffAlgorithmListener, false);
    }

    @NotNull
    public static final <T> Patch<T> fe(@NotNull List<? extends T> list, @NotNull List<? extends T> list2, @NotNull DiffAlgorithmI<T> diffAlgorithmI, @Nullable DiffAlgorithmListener diffAlgorithmListener, boolean z) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(list2, "revised");
        Intrinsics.checkNotNullParameter(diffAlgorithmI, "algorithm");
        return Patch.Companion.ad(list, list2, diffAlgorithmI.qw(list, list2, diffAlgorithmListener), z);
    }

    @NotNull
    public static final <T> Either qw(@NotNull List<? extends T> list, @NotNull List<? extends T> list2, @NotNull ListUpdateCallback<T> listUpdateCallback) {
        Intrinsics.checkNotNullParameter(list, "old");
        Intrinsics.checkNotNullParameter(list2, "new");
        Intrinsics.checkNotNullParameter(listUpdateCallback, "callback");
        Patch<T> ad2 = ad(list, list2);
        if (ad2.getDeltas().isEmpty()) {
            return ExpectKt.getFAILURE();
        }
        return ExpectKt.success(rg(ad2, list, listUpdateCallback));
    }

    @NotNull
    public static final <T> List<T> rg(@NotNull Patch<T> patch, @Nullable List<? extends T> list, @NotNull ListUpdateCallback<T> listUpdateCallback) throws PatchFailedException {
        Intrinsics.checkNotNullParameter(patch, "<this>");
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        return patch.applyTo(list, listUpdateCallback);
    }
}
