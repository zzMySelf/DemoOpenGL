package com.mars.united.international.pay;

import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.SequenceKt;
import fe.de.qw.qw.Cif;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "inAppResult", "", "Lcom/android/billingclient/api/Purchase;", "subResult"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class PayProxy$queryPurchasesWithFilter$1 extends Lambda implements Function2<List<? extends Cif>, List<? extends Cif>, Unit> {
    public final /* synthetic */ Function1<ArrayList<String>, Unit> $inAppResultList;
    public final /* synthetic */ Function0<Unit> $onFinish;
    public final /* synthetic */ Function1<String, Boolean> $subResultJsonFilter;
    public final /* synthetic */ Function1<ArrayList<String>, Unit> $subResultList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayProxy$queryPurchasesWithFilter$1(Function0<Unit> function0, Function1<? super ArrayList<String>, Unit> function1, Function1<? super String, Boolean> function12, Function1<? super ArrayList<String>, Unit> function13) {
        super(2);
        this.$onFinish = function0;
        this.$inAppResultList = function1;
        this.$subResultJsonFilter = function12;
        this.$subResultList = function13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((List<? extends Cif>) (List) obj, (List<? extends Cif>) (List) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable List<? extends Cif> list, @Nullable List<? extends Cif> list2) {
        Sequence<T> asSequence;
        Sequence<R> map;
        ArrayList<R> arrayList;
        Sequence<T> asSequence2;
        Sequence<T> filter;
        Sequence<R> map2;
        ArrayList<R> arrayList2;
        if (!(list == null || (asSequence2 = CollectionsKt___CollectionsKt.asSequence(list)) == null || (filter = SequencesKt___SequencesKt.filter(asSequence2, AnonymousClass1.INSTANCE)) == null || (map2 = SequencesKt___SequencesKt.map(filter, AnonymousClass2.INSTANCE)) == null || (arrayList2 = SequenceKt.toArrayList(map2)) == null)) {
            this.$inAppResultList.invoke(arrayList2);
        }
        if (!(list2 == null || (asSequence = CollectionsKt___CollectionsKt.asSequence(list2)) == null)) {
            final Function1<String, Boolean> function1 = this.$subResultJsonFilter;
            Sequence<T> filter2 = SequencesKt___SequencesKt.filter(asSequence, new Function1<Cif, Boolean>() {
                @NotNull
                public final Boolean invoke(@NotNull Cif ifVar) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(ifVar, "it");
                    LoggerKt.d$default(ifVar, (Object) null, 1, (Object) null);
                    if (ifVar.rg() == 1) {
                        Function1<String, Boolean> function1 = function1;
                        String de2 = ifVar.de();
                        Intrinsics.checkNotNullExpressionValue(de2, "it.originalJson");
                        z = function1.invoke(de2).booleanValue();
                    } else {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            });
            if (!(filter2 == null || (map = SequencesKt___SequencesKt.map(filter2, AnonymousClass5.INSTANCE)) == null || (arrayList = SequenceKt.toArrayList(map)) == null)) {
                this.$subResultList.invoke(arrayList);
            }
        }
        this.$onFinish.invoke();
    }
}
