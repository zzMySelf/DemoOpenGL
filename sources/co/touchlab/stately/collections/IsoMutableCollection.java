package co.touchlab.stately.collections;

import co.touchlab.stately.isolate.IsoStateKt;
import co.touchlab.stately.isolate.IsolateState;
import co.touchlab.stately.isolate.StateHolder;
import co.touchlab.stately.isolate.StateRunner;
import com.baidu.searchbox.ugc.utils.UgcPerformanceUbcUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\b\u0016\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0000\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u0016\u0010\u001a\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\u0013\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0002J\u0015\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u0016\u0010#\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\u0016\u0010$\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016R\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Lco/touchlab/stately/collections/IsoMutableCollection;", "T", "Lco/touchlab/stately/isolate/IsolateState;", "", "stateRunner", "Lco/touchlab/stately/isolate/StateRunner;", "producer", "Lkotlin/Function0;", "(Lco/touchlab/stately/isolate/StateRunner;Lkotlin/jvm/functions/Function0;)V", "stateHolder", "Lco/touchlab/stately/isolate/StateHolder;", "(Lco/touchlab/stately/isolate/StateHolder;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "equals", "other", "", "hashCode", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "stately-iso-collections"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IsoMutableCollection.kt */
public class IsoMutableCollection<T> extends IsolateState<Collection<T>> implements Collection<T>, KMutableCollection {
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, b.f11693j);
        return CollectionToArray.toArray(this, tArr);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IsoMutableCollection(StateHolder<? extends Collection<T>> stateHolder) {
        super(stateHolder);
        Intrinsics.checkNotNullParameter(stateHolder, "stateHolder");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IsoMutableCollection(StateRunner stateRunner, Function0<? extends Collection<T>> producer) {
        this(IsoStateKt.createState(stateRunner, producer));
        Intrinsics.checkNotNullParameter(producer, UgcPerformanceUbcUtils.UGC_PERFORMANCE_PRDUCER);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IsoMutableCollection(StateRunner stateRunner, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : stateRunner, function0);
    }

    public boolean equals(Object other) {
        return ((Boolean) access(new IsoMutableCollection$equals$1(other))).booleanValue();
    }

    public int hashCode() {
        return ((Number) access(IsoMutableCollection$hashCode$1.INSTANCE)).intValue();
    }

    public int getSize() {
        return ((Number) access(IsoMutableCollection$size$1.INSTANCE)).intValue();
    }

    public boolean contains(Object element) {
        return ((Boolean) access(new IsoMutableCollection$contains$1(element))).booleanValue();
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ((Boolean) access(new IsoMutableCollection$containsAll$1(elements))).booleanValue();
    }

    public boolean isEmpty() {
        return ((Boolean) access(IsoMutableCollection$isEmpty$1.INSTANCE)).booleanValue();
    }

    public boolean add(T element) {
        return ((Boolean) access(new IsoMutableCollection$add$1(element))).booleanValue();
    }

    public boolean addAll(Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ((Boolean) access(new IsoMutableCollection$addAll$1(elements))).booleanValue();
    }

    public void clear() {
        access(IsoMutableCollection$clear$1.INSTANCE);
    }

    public Iterator<T> iterator() {
        return (Iterator) access(new IsoMutableCollection$iterator$1(this));
    }

    public boolean remove(Object element) {
        return ((Boolean) access(new IsoMutableCollection$remove$1(element))).booleanValue();
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ((Boolean) access(new IsoMutableCollection$removeAll$1(elements))).booleanValue();
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ((Boolean) access(new IsoMutableCollection$retainAll$1(elements))).booleanValue();
    }
}
