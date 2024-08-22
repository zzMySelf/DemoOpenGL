package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lshark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: AndroidReferenceMatchers.kt */
final class AndroidReferenceMatchers$TEXT_TO_SPEECH$add$2 extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
    public static final AndroidReferenceMatchers$TEXT_TO_SPEECH$add$2 INSTANCE = new AndroidReferenceMatchers$TEXT_TO_SPEECH$add$2();

    AndroidReferenceMatchers$TEXT_TO_SPEECH$add$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
    }

    public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
        Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
        return $this$instanceFieldLeak.getSdkInt() == 24;
    }
}
