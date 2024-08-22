package shark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import shark.HeapObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lshark/ObjectReporter;", "instance", "Lshark/HeapObject$HeapInstance;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$MORTAR_SCOPE$inspect$1 extends Lambda implements Function2<ObjectReporter, HeapObject.HeapInstance, Unit> {
    public static final AndroidObjectInspectors$MORTAR_SCOPE$inspect$1 INSTANCE = new AndroidObjectInspectors$MORTAR_SCOPE$inspect$1();

    AndroidObjectInspectors$MORTAR_SCOPE$inspect$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ObjectReporter $this$whenInstanceOf, HeapObject.HeapInstance instance) {
        Intrinsics.checkParameterIsNotNull($this$whenInstanceOf, "$receiver");
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        Boolean asBoolean = AndroidObjectInspectorsKt.getOrThrow(instance, "mortar.MortarScope", "dead").getValue().getAsBoolean();
        if (asBoolean == null) {
            Intrinsics.throwNpe();
        }
        boolean dead = asBoolean.booleanValue();
        String scopeName = AndroidObjectInspectorsKt.getOrThrow(instance, "mortar.MortarScope", "name").getValue().readAsJavaString();
        if (dead) {
            $this$whenInstanceOf.getLeakingReasons().add("mortar.MortarScope.dead is true for scope " + scopeName);
        } else {
            $this$whenInstanceOf.getNotLeakingReasons().add("mortar.MortarScope.dead is false for scope " + scopeName);
        }
    }
}
