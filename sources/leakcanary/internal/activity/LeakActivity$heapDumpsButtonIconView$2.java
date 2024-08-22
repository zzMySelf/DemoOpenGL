package leakcanary.internal.activity;

import android.view.View;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: LeakActivity.kt */
final class LeakActivity$heapDumpsButtonIconView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ LeakActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LeakActivity$heapDumpsButtonIconView$2(LeakActivity leakActivity) {
        super(0);
        this.this$0 = leakActivity;
    }

    public final View invoke() {
        return this.this$0.findViewById(R.id.leak_canary_navigation_button_heap_dumps_icon);
    }
}
