package com.tera.scan.utils.listdiff.algorithm;

import fe.mmm.qw.j.nn.ad.qw;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/tera/scan/utils/listdiff/algorithm/DiffAlgorithmI;", "T", "", "computeDiff", "", "Lcom/tera/scan/utils/listdiff/algorithm/Change;", "source", "target", "progress", "Lcom/tera/scan/utils/listdiff/algorithm/DiffAlgorithmListener;", "x-util_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DiffAlgorithmI<T> {
    @NotNull
    List<qw> qw(@NotNull List<? extends T> list, @NotNull List<? extends T> list2, @Nullable DiffAlgorithmListener diffAlgorithmListener);
}
