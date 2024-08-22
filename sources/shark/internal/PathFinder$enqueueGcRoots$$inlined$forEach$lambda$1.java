package shark.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import shark.HeapField;
import shark.HeapObject;
import shark.HeapValue;
import shark.internal.PathFinder;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "shark/internal/PathFinder$enqueueGcRoots$1$threadName$1"}, k = 3, mv = {1, 4, 1})
/* compiled from: PathFinder.kt */
final class PathFinder$enqueueGcRoots$$inlined$forEach$lambda$1 extends Lambda implements Function0<String> {
    final /* synthetic */ PathFinder.State $this_enqueueGcRoots$inlined;
    final /* synthetic */ HeapObject.HeapInstance $threadInstance;
    final /* synthetic */ Map $threadNames$inlined;
    final /* synthetic */ Map $threadsBySerialNumber$inlined;
    final /* synthetic */ PathFinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PathFinder$enqueueGcRoots$$inlined$forEach$lambda$1(HeapObject.HeapInstance heapInstance, PathFinder pathFinder, PathFinder.State state, Map map, Map map2) {
        super(0);
        this.$threadInstance = heapInstance;
        this.this$0 = pathFinder;
        this.$this_enqueueGcRoots$inlined = state;
        this.$threadsBySerialNumber$inlined = map;
        this.$threadNames$inlined = map2;
    }

    public final String invoke() {
        String name;
        HeapValue value;
        HeapField heapField = this.$threadInstance.get((KClass<? extends Object>) Reflection.getOrCreateKotlinClass(Thread.class), "name");
        if (heapField == null || (value = heapField.getValue()) == null || (name = value.readAsJavaString()) == null) {
            name = "";
        }
        this.$threadNames$inlined.put(this.$threadInstance, name);
        return name;
    }
}
