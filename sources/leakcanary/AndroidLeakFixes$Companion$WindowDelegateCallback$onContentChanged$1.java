package leakcanary;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "callback", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: AndroidLeakFixes.kt */
final class AndroidLeakFixes$Companion$WindowDelegateCallback$onContentChanged$1 extends Lambda implements Function1<Function0<? extends Boolean>, Boolean> {
    public static final AndroidLeakFixes$Companion$WindowDelegateCallback$onContentChanged$1 INSTANCE = new AndroidLeakFixes$Companion$WindowDelegateCallback$onContentChanged$1();

    AndroidLeakFixes$Companion$WindowDelegateCallback$onContentChanged$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Function0<Boolean>) (Function0) obj));
    }

    public final boolean invoke(Function0<Boolean> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        return !callback.invoke().booleanValue();
    }
}
