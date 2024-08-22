package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import shark.HeapObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "heapObject", "Lshark/HeapObject;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$SERVICE$leakingObjectFilter$1 extends Lambda implements Function1<HeapObject, Boolean> {
    public static final AndroidObjectInspectors$SERVICE$leakingObjectFilter$1 INSTANCE = new AndroidObjectInspectors$SERVICE$leakingObjectFilter$1();

    AndroidObjectInspectors$SERVICE$leakingObjectFilter$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapObject) obj));
    }

    public final boolean invoke(HeapObject heapObject) {
        Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
        return (heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf("android.app.Service") && !AndroidServices.INSTANCE.getAliveAndroidServiceObjectIds(heapObject.getGraph()).contains(Long.valueOf(heapObject.getObjectId()));
    }
}
