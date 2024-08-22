package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001aB\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\b¢\u0006\u0004\b\u0007\u0010\b\u001aH\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0005H\b¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"X", "Landroidx/lifecycle/LiveData;", "distinctUntilChanged", "(Landroidx/lifecycle/LiveData;)Landroidx/lifecycle/LiveData;", "Y", "Lkotlin/Function1;", "transform", "map", "(Landroidx/lifecycle/LiveData;Lkotlin/Function1;)Landroidx/lifecycle/LiveData;", "switchMap", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class TransformationsKt {
    @NotNull
    public static final <X> LiveData<X> distinctUntilChanged(@NotNull LiveData<X> liveData) {
        LiveData<X> distinctUntilChanged = Transformations.distinctUntilChanged(liveData);
        Intrinsics.checkExpressionValueIsNotNull(distinctUntilChanged, "Transformations.distinctUntilChanged(this)");
        return distinctUntilChanged;
    }

    @NotNull
    public static final <X, Y> LiveData<Y> map(@NotNull LiveData<X> liveData, @NotNull Function1<? super X, ? extends Y> function1) {
        LiveData<Y> map = Transformations.map(liveData, new TransformationsKt$map$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(map, "Transformations.map(this) { transform(it) }");
        return map;
    }

    @NotNull
    public static final <X, Y> LiveData<Y> switchMap(@NotNull LiveData<X> liveData, @NotNull Function1<? super X, ? extends LiveData<Y>> function1) {
        LiveData<Y> switchMap = Transformations.switchMap(liveData, new TransformationsKt$switchMap$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMap(this) { transform(it) }");
        return switchMap;
    }
}
