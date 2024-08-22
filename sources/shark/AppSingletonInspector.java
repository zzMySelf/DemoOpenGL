package shark;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import shark.HeapObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"Lshark/AppSingletonInspector;", "Lshark/ObjectInspector;", "singletonClasses", "", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "inspect", "", "reporter", "Lshark/ObjectReporter;", "shark"}, k = 1, mv = {1, 4, 1})
/* compiled from: AppSingletonInspector.kt */
public final class AppSingletonInspector implements ObjectInspector {
    private final String[] singletonClasses;

    public AppSingletonInspector(String... singletonClasses2) {
        Intrinsics.checkParameterIsNotNull(singletonClasses2, "singletonClasses");
        this.singletonClasses = singletonClasses2;
    }

    public void inspect(ObjectReporter reporter) {
        Intrinsics.checkParameterIsNotNull(reporter, "reporter");
        if (reporter.getHeapObject() instanceof HeapObject.HeapInstance) {
            for (HeapObject.HeapClass heapClass : ((HeapObject.HeapInstance) reporter.getHeapObject()).getInstanceClass().getClassHierarchy()) {
                if (ArraysKt.contains((T[]) this.singletonClasses, heapClass.getName())) {
                    reporter.getNotLeakingReasons().add(heapClass.getName() + " is an app singleton");
                }
            }
        }
    }
}
