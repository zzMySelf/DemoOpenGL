package androidx.activity;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"androidx/activity/OnBackPressedDispatcherKt$addCallback$callback$1", "Landroidx/activity/OnBackPressedCallback;", "", "handleOnBackPressed", "()V", "activity-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class OnBackPressedDispatcherKt$addCallback$callback$1 extends OnBackPressedCallback {
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ Function1 $onBackPressed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnBackPressedDispatcherKt$addCallback$callback$1(Function1 function1, boolean z, boolean z2) {
        super(z2);
        this.$onBackPressed = function1;
        this.$enabled = z;
    }

    public void handleOnBackPressed() {
        this.$onBackPressed.invoke(this);
    }
}
