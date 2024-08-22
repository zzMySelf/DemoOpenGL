package com.tera.scan.utils.listdiff.algorithm.myers;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.baidu.ubc.UBCManager;
import com.tera.scan.utils.listdiff.algorithm.DiffAlgorithmFactory;
import com.tera.scan.utils.listdiff.algorithm.DiffAlgorithmI;
import com.tera.scan.utils.listdiff.algorithm.DiffAlgorithmListener;
import com.tera.scan.utils.listdiff.patch.delta.DeltaType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J_\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f0\u0007R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH\u0002JD\u0010\u0012\u001a\f0\u0013R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\u0010\u0006\u001a\f0\u0007R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J4\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\b\u0010\r\u001a\u0004\u0018\u00010\u001bH\u0016JF\u0010\u001c\u001a\u000e\u0018\u00010\u0013R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\u0010\u0006\u001a\f0\u0007R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¨\u0006 "}, d2 = {"Lcom/tera/scan/utils/listdiff/algorithm/myers/MeyersDiffWithLinearSpace;", "T", "Lcom/tera/scan/utils/listdiff/algorithm/DiffAlgorithmI;", "()V", "buildScript", "", "data", "Lcom/tera/scan/utils/listdiff/algorithm/myers/MeyersDiffWithLinearSpace$DiffData;", "start1", "", "end1", "start2", "end2", "progress", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "idx", "buildSnake", "Lcom/tera/scan/utils/listdiff/algorithm/myers/MeyersDiffWithLinearSpace$Snake;", "start", "diag", "computeDiff", "", "Lcom/tera/scan/utils/listdiff/algorithm/Change;", "source", "target", "Lcom/tera/scan/utils/listdiff/algorithm/DiffAlgorithmListener;", "getMiddleSnake", "Companion", "DiffData", "Snake", "x-util_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MeyersDiffWithLinearSpace<T> implements DiffAlgorithmI<T> {
    @NotNull
    public static final qw qw = new qw((DefaultConstructorMarker) null);

    public final class ad {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final List<T> f7446ad;

        /* renamed from: de  reason: collision with root package name */
        public final int f7447de;
        @NotNull

        /* renamed from: fe  reason: collision with root package name */
        public final int[] f7448fe;
        @NotNull
        public final List<T> qw;
        @NotNull

        /* renamed from: rg  reason: collision with root package name */
        public final int[] f7449rg;
        @NotNull

        /* renamed from: th  reason: collision with root package name */
        public final List<fe.mmm.qw.j.nn.ad.qw> f7450th = new ArrayList();

        public ad(@NotNull MeyersDiffWithLinearSpace meyersDiffWithLinearSpace, @NotNull List<? extends T> list, List<? extends T> list2) {
            Intrinsics.checkNotNullParameter(list, UBCManager.CONTENT_KEY_SOURCE);
            Intrinsics.checkNotNullParameter(list2, AnimatedVectorDrawableCompat.TARGET);
            this.qw = list;
            this.f7446ad = list2;
            int size = list.size() + this.f7446ad.size() + 2;
            this.f7447de = size;
            this.f7448fe = new int[size];
            this.f7449rg = new int[size];
        }

        @NotNull
        public final List<T> ad() {
            return this.qw;
        }

        @NotNull
        public final List<T> de() {
            return this.f7446ad;
        }

        @NotNull
        public final int[] fe() {
            return this.f7448fe;
        }

        @NotNull
        public final List<fe.mmm.qw.j.nn.ad.qw> qw() {
            return this.f7450th;
        }

        @NotNull
        public final int[] rg() {
            return this.f7449rg;
        }
    }

    public final class de {

        /* renamed from: ad  reason: collision with root package name */
        public final int f7451ad;

        /* renamed from: de  reason: collision with root package name */
        public final int f7452de;
        public final int qw;

        public de(MeyersDiffWithLinearSpace meyersDiffWithLinearSpace, int i2, int i3, int i4) {
            this.qw = i2;
            this.f7451ad = i3;
            this.f7452de = i4;
        }

        public final int ad() {
            return this.f7451ad;
        }

        public final int de() {
            return this.qw;
        }

        public final int qw() {
            return this.f7452de;
        }
    }

    public static final class qw {

        /* renamed from: com.tera.scan.utils.listdiff.algorithm.myers.MeyersDiffWithLinearSpace$qw$qw  reason: collision with other inner class name */
        public static final class C0270qw implements DiffAlgorithmFactory {
            @NotNull
            public <T> DiffAlgorithmI<T> qw() {
                return new MeyersDiffWithLinearSpace();
            }
        }

        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffAlgorithmFactory qw() {
            return new C0270qw();
        }
    }

    public final void ad(MeyersDiffWithLinearSpace<T>.ad adVar, int i2, int i3, int i4, int i5, Function1<? super Integer, Unit> function1) {
        int i6 = i2;
        int i7 = i3;
        int i8 = i5;
        Function1<? super Integer, Unit> function12 = function1;
        if (function12 != null) {
            function12.invoke(Integer.valueOf(((i7 - i6) / 2) + ((i8 - i4) / 2)));
        }
        MeyersDiffWithLinearSpace<T>.de fe2 = fe(adVar, i2, i3, i4, i5);
        if (fe2 == null || ((fe2.de() == i7 && fe2.qw() == i7 - i8) || (fe2.ad() == i6 && fe2.qw() == i6 - i4))) {
            int i9 = i4;
            int i10 = i6;
            while (true) {
                if (i10 < i7 || i9 < i8) {
                    if (i10 < i7 && i9 < i8 && Intrinsics.areEqual(adVar.ad().get(i10), adVar.de().get(i9))) {
                        i10++;
                    } else if (i7 - i6 > i8 - i4) {
                        if (!adVar.qw().isEmpty() && adVar.qw().get(adVar.qw().size() - 1).f7971de == i10 && adVar.qw().get(adVar.qw().size() - 1).qw == DeltaType.DELETE) {
                            adVar.qw().set(adVar.qw().size() - 1, adVar.qw().get(adVar.qw().size() - 1).th(i10 + 1));
                        } else {
                            adVar.qw().add(new fe.mmm.qw.j.nn.ad.qw(DeltaType.DELETE, i10, i10 + 1, i9, i9));
                        }
                        i10++;
                    } else if (!adVar.qw().isEmpty() && adVar.qw().get(adVar.qw().size() - 1).f7973rg == i9 && adVar.qw().get(adVar.qw().size() - 1).qw == DeltaType.INSERT) {
                        adVar.qw().set(adVar.qw().size() - 1, adVar.qw().get(adVar.qw().size() - 1).yj(i9 + 1));
                    } else {
                        adVar.qw().add(new fe.mmm.qw.j.nn.ad.qw(DeltaType.INSERT, i10, i10, i9, i9 + 1));
                    }
                    i9++;
                } else {
                    return;
                }
            }
        } else {
            Function1<? super Integer, Unit> function13 = function1;
            ad(adVar, i2, fe2.de(), i4, fe2.de() - fe2.qw(), function13);
            ad(adVar, fe2.ad(), i3, fe2.ad() - fe2.qw(), i5, function13);
        }
    }

    public final MeyersDiffWithLinearSpace<T>.de de(MeyersDiffWithLinearSpace<T>.ad adVar, int i2, int i3, int i4, int i5) {
        int i6 = i2;
        while (true) {
            int i7 = i6 - i3;
            if (i7 < i5 && i6 < i4 && Intrinsics.areEqual(adVar.ad().get(i6), adVar.de().get(i7))) {
                i6++;
            }
        }
        return new de(this, i2, i6, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0174, code lost:
        if (r2 == r3) goto L_0x017a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tera.scan.utils.listdiff.algorithm.myers.MeyersDiffWithLinearSpace<T>.de fe(com.tera.scan.utils.listdiff.algorithm.myers.MeyersDiffWithLinearSpace<T>.ad r16, int r17, int r18, int r19, int r20) {
        /*
            r15 = this;
            r0 = r17
            r4 = r18
            r1 = r19
            r5 = r20
            int r2 = r4 - r0
            int r3 = r5 - r1
            if (r2 == 0) goto L_0x0182
            if (r3 != 0) goto L_0x0012
            goto L_0x0182
        L_0x0012:
            int r6 = r2 - r3
            int r3 = r3 + r2
            int r2 = r3 % 2
            if (r2 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            int r3 = r3 + 1
        L_0x001c:
            int r3 = r3 / 2
            int[] r2 = r16.fe()
            int r7 = r3 + 1
            r2[r7] = r0
            int[] r2 = r16.rg()
            int r8 = r4 + 1
            r2[r7] = r8
            r2 = 0
            if (r3 < 0) goto L_0x017a
        L_0x0031:
            int r7 = -r2
            r8 = r7
        L_0x0033:
            if (r8 > r2) goto L_0x00d1
            int r9 = r8 + r3
            if (r8 == r7) goto L_0x005f
            if (r8 == r2) goto L_0x004e
            int[] r10 = r16.fe()
            int r11 = r9 + -1
            r10 = r10[r11]
            int[] r11 = r16.fe()
            int r12 = r9 + 1
            r11 = r11[r12]
            if (r10 >= r11) goto L_0x004e
            goto L_0x005f
        L_0x004e:
            int[] r10 = r16.fe()
            int[] r11 = r16.fe()
            int r12 = r9 + -1
            r11 = r11[r12]
            int r11 = r11 + 1
            r10[r9] = r11
            goto L_0x006d
        L_0x005f:
            int[] r10 = r16.fe()
            int[] r11 = r16.fe()
            int r12 = r9 + 1
            r11 = r11[r12]
            r10[r9] = r11
        L_0x006d:
            int[] r10 = r16.fe()
            r10 = r10[r9]
            int r11 = r10 - r0
            int r11 = r11 + r1
            int r11 = r11 - r8
        L_0x0077:
            if (r10 >= r4) goto L_0x009c
            if (r11 >= r5) goto L_0x009c
            java.util.List r12 = r16.ad()
            java.lang.Object r12 = r12.get(r10)
            java.util.List r13 = r16.de()
            java.lang.Object r13 = r13.get(r11)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x009c
            int[] r12 = r16.fe()
            int r10 = r10 + 1
            r12[r9] = r10
            int r11 = r11 + 1
            goto L_0x0077
        L_0x009c:
            int r10 = r6 % 2
            if (r10 == 0) goto L_0x00cd
            int r10 = r6 - r2
            if (r10 > r8) goto L_0x00cd
            int r10 = r6 + r2
            if (r8 > r10) goto L_0x00cd
            int[] r10 = r16.rg()
            int r11 = r9 - r6
            r10 = r10[r11]
            int[] r12 = r16.fe()
            r9 = r12[r9]
            if (r10 > r9) goto L_0x00cd
            int[] r2 = r16.rg()
            r2 = r2[r11]
            int r8 = r8 + r0
            int r3 = r8 - r1
            r0 = r15
            r1 = r16
            r4 = r18
            r5 = r20
            com.tera.scan.utils.listdiff.algorithm.myers.MeyersDiffWithLinearSpace$de r0 = r0.de(r1, r2, r3, r4, r5)
            return r0
        L_0x00cd:
            int r8 = r8 + 2
            goto L_0x0033
        L_0x00d1:
            int r8 = r6 - r2
            r9 = r8
        L_0x00d4:
            int r10 = r6 + r2
            if (r9 > r10) goto L_0x0174
            int r11 = r9 + r3
            int r11 = r11 - r6
            if (r9 == r8) goto L_0x0101
            if (r9 == r10) goto L_0x00f2
            int[] r10 = r16.rg()
            int r12 = r11 + 1
            r10 = r10[r12]
            int[] r12 = r16.rg()
            int r13 = r11 + -1
            r12 = r12[r13]
            if (r10 > r12) goto L_0x00f2
            goto L_0x0101
        L_0x00f2:
            int[] r10 = r16.rg()
            int[] r12 = r16.rg()
            int r13 = r11 + -1
            r12 = r12[r13]
            r10[r11] = r12
            goto L_0x0111
        L_0x0101:
            int[] r10 = r16.rg()
            int[] r12 = r16.rg()
            int r13 = r11 + 1
            r12 = r12[r13]
            int r12 = r12 + -1
            r10[r11] = r12
        L_0x0111:
            int[] r10 = r16.rg()
            r10 = r10[r11]
            int r10 = r10 + -1
            int r12 = r10 - r0
            int r12 = r12 + r1
            int r12 = r12 - r9
        L_0x011d:
            if (r10 < r0) goto L_0x0143
            if (r12 < r1) goto L_0x0143
            java.util.List r13 = r16.ad()
            java.lang.Object r13 = r13.get(r10)
            java.util.List r14 = r16.de()
            java.lang.Object r14 = r14.get(r12)
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x0143
            int[] r13 = r16.rg()
            int r14 = r10 + -1
            r13[r11] = r10
            int r12 = r12 + -1
            r10 = r14
            goto L_0x011d
        L_0x0143:
            int r10 = r6 % 2
            if (r10 != 0) goto L_0x0170
            if (r7 > r9) goto L_0x0170
            if (r9 > r2) goto L_0x0170
            int[] r10 = r16.rg()
            r10 = r10[r11]
            int[] r12 = r16.fe()
            int r13 = r11 + r6
            r12 = r12[r13]
            if (r10 > r12) goto L_0x0170
            int[] r2 = r16.rg()
            r2 = r2[r11]
            int r9 = r9 + r0
            int r3 = r9 - r1
            r0 = r15
            r1 = r16
            r4 = r18
            r5 = r20
            com.tera.scan.utils.listdiff.algorithm.myers.MeyersDiffWithLinearSpace$de r0 = r0.de(r1, r2, r3, r4, r5)
            return r0
        L_0x0170:
            int r9 = r9 + 2
            goto L_0x00d4
        L_0x0174:
            if (r2 == r3) goto L_0x017a
            int r2 = r2 + 1
            goto L_0x0031
        L_0x017a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "could not find a diff path"
            r0.<init>(r1)
            throw r0
        L_0x0182:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.utils.listdiff.algorithm.myers.MeyersDiffWithLinearSpace.fe(com.tera.scan.utils.listdiff.algorithm.myers.MeyersDiffWithLinearSpace$ad, int, int, int, int):com.tera.scan.utils.listdiff.algorithm.myers.MeyersDiffWithLinearSpace$de");
    }

    @NotNull
    public List<fe.mmm.qw.j.nn.ad.qw> qw(@NotNull List<? extends T> list, @NotNull List<? extends T> list2, @Nullable DiffAlgorithmListener diffAlgorithmListener) {
        Intrinsics.checkNotNullParameter(list, UBCManager.CONTENT_KEY_SOURCE);
        Intrinsics.checkNotNullParameter(list2, AnimatedVectorDrawableCompat.TARGET);
        if (diffAlgorithmListener != null) {
            diffAlgorithmListener.qw();
        }
        ad adVar = new ad(this, list, list2);
        ad(adVar, 0, list.size(), 0, list2.size(), new MeyersDiffWithLinearSpace$computeDiff$1(diffAlgorithmListener, list.size() + list2.size()));
        if (diffAlgorithmListener != null) {
            diffAlgorithmListener.de();
        }
        return adVar.qw();
    }
}
