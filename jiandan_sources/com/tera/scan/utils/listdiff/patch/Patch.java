package com.tera.scan.utils.listdiff.patch;

import com.tera.scan.utils.listdiff.patch.delta.AbstractDelta;
import com.tera.scan.utils.listdiff.patch.delta.ChangeDelta;
import com.tera.scan.utils.listdiff.patch.delta.DeleteDelta;
import com.tera.scan.utils.listdiff.patch.delta.DeltaType;
import com.tera.scan.utils.listdiff.patch.delta.EqualDelta;
import com.tera.scan.utils.listdiff.patch.delta.InsertDelta;
import com.tera.scan.utils.listdiff.patch.exception.PatchFailedException;
import com.tera.scan.utils.listdiff.updatecallback.ListUpdateCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u0017*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002J*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0010J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tera/scan/utils/listdiff/patch/Patch;", "T", "Ljava/io/Serializable;", "estimatedPatchSize", "", "(I)V", "CONFLICT_PRODUCES_EXCEPTION", "Lcom/tera/scan/utils/listdiff/patch/ConflictOutput;", "conflictOutput", "deltas", "", "Lcom/tera/scan/utils/listdiff/patch/delta/AbstractDelta;", "addDelta", "", "delta", "applyTo", "", "target", "updateCallback", "Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateCallback;", "getDeltas", "toString", "", "Companion", "x-util_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Patch<T> implements Serializable {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public final ConflictOutput<T> CONFLICT_PRODUCES_EXCEPTION;
    @NotNull
    public final ConflictOutput<T> conflictOutput;
    @NotNull
    public final List<AbstractDelta<T>> deltas;

    public static final class ad<T> implements Comparator {
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((AbstractDelta) t).getSource().getPosition()), Integer.valueOf(((AbstractDelta) t2).getSource().getPosition()));
        }
    }

    public static final class qw {

        public static final class ad<T> implements Comparator {
            public final int compare(T t, T t2) {
                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((fe.mmm.qw.j.nn.ad.qw) t).f7970ad), Integer.valueOf(((fe.mmm.qw.j.nn.ad.qw) t2).f7970ad));
            }
        }

        /* renamed from: com.tera.scan.utils.listdiff.patch.Patch$qw$qw  reason: collision with other inner class name */
        public /* synthetic */ class C0271qw {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DeltaType.values().length];
                iArr[DeltaType.DELETE.ordinal()] = 1;
                iArr[DeltaType.INSERT.ordinal()] = 2;
                iArr[DeltaType.CHANGE.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T> Patch<T> ad(@NotNull List<? extends T> list, @NotNull List<? extends T> list2, @NotNull List<fe.mmm.qw.j.nn.ad.qw> list3, boolean z) {
            Intrinsics.checkNotNullParameter(list, "original");
            Intrinsics.checkNotNullParameter(list2, "revised");
            Intrinsics.checkNotNullParameter(list3, "_changes");
            Patch<T> patch = new Patch<>(list3.size());
            if (z) {
                ArrayList arrayList = new ArrayList(list3);
                CollectionsKt___CollectionsKt.sortedWith(arrayList, new ad());
                list3 = arrayList;
            }
            int i2 = 0;
            int i3 = 0;
            for (fe.mmm.qw.j.nn.ad.qw next : list3) {
                DeltaType qw = next.qw();
                int ad2 = next.ad();
                int de2 = next.de();
                int fe2 = next.fe();
                int rg2 = next.rg();
                if (z && i2 < ad2) {
                    patch.addDelta(new EqualDelta(qw(i2, ad2, list), qw(i3, fe2, list2)));
                }
                Chunk<T> qw2 = qw(ad2, de2, list);
                Chunk<T> qw3 = qw(fe2, rg2, list2);
                int i4 = C0271qw.$EnumSwitchMapping$0[qw.ordinal()];
                if (i4 == 1) {
                    patch.addDelta(new DeleteDelta(qw2, qw3));
                } else if (i4 == 2) {
                    patch.addDelta(new InsertDelta(qw2, qw3));
                } else if (i4 == 3) {
                    patch.addDelta(new ChangeDelta(qw2, qw3));
                }
                i3 = rg2;
                i2 = de2;
            }
            if (z && i2 < list.size()) {
                patch.addDelta(new EqualDelta(qw(i2, list.size(), list), qw(i3, list2.size(), list2)));
            }
            return patch;
        }

        public final <T> Chunk<T> qw(int i2, int i3, List<? extends T> list) {
            return new Chunk<>(i2, new ArrayList(list.subList(i2, i3)), (List<Integer>) null);
        }
    }

    public Patch(int i2) {
        Patch$CONFLICT_PRODUCES_EXCEPTION$1 patch$CONFLICT_PRODUCES_EXCEPTION$1 = new Patch$CONFLICT_PRODUCES_EXCEPTION$1();
        this.CONFLICT_PRODUCES_EXCEPTION = patch$CONFLICT_PRODUCES_EXCEPTION$1;
        this.conflictOutput = patch$CONFLICT_PRODUCES_EXCEPTION$1;
        this.deltas = new ArrayList(i2);
    }

    /* access modifiers changed from: private */
    public final void addDelta(AbstractDelta<T> abstractDelta) {
        this.deltas.add(abstractDelta);
    }

    @NotNull
    public final List<T> applyTo(@Nullable List<? extends T> list, @NotNull ListUpdateCallback<T> listUpdateCallback) throws PatchFailedException {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        ArrayList arrayList = new ArrayList(list);
        ListIterator listIterator = getDeltas().listIterator(this.deltas.size());
        while (listIterator.hasPrevious()) {
            AbstractDelta abstractDelta = (AbstractDelta) listIterator.previous();
            VerifyChunk verifyAntApplyTo = abstractDelta.verifyAntApplyTo(arrayList, listUpdateCallback);
            if (verifyAntApplyTo != VerifyChunk.OK) {
                this.conflictOutput.processConflict(verifyAntApplyTo, abstractDelta, arrayList);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<AbstractDelta<T>> getDeltas() {
        List<AbstractDelta<T>> list = this.deltas;
        if (list.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(list, new ad());
        }
        return this.deltas;
    }

    @NotNull
    public String toString() {
        return "Patch{deltas=" + this.deltas + ExtendedMessageFormat.END_FE;
    }
}
