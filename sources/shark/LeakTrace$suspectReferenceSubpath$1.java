package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "index", "", "<anonymous parameter 1>", "Lshark/LeakTraceReference;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: LeakTrace.kt */
final class LeakTrace$suspectReferenceSubpath$1 extends Lambda implements Function2<Integer, LeakTraceReference, Boolean> {
    final /* synthetic */ LeakTrace this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LeakTrace$suspectReferenceSubpath$1(LeakTrace leakTrace) {
        super(2);
        this.this$0 = leakTrace;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(invoke(((Number) obj).intValue(), (LeakTraceReference) obj2));
    }

    public final boolean invoke(int index, LeakTraceReference $noName_1) {
        Intrinsics.checkParameterIsNotNull($noName_1, "<anonymous parameter 1>");
        return this.this$0.referencePathElementIsSuspect(index);
    }
}
