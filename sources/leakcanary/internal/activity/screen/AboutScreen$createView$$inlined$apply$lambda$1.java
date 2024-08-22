package leakcanary.internal.activity.screen;

import android.widget.CompoundButton;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.InternalLeakCanary;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "checked", "", "onCheckedChanged", "leakcanary/internal/activity/screen/AboutScreen$createView$1$1"}, k = 3, mv = {1, 4, 1})
/* compiled from: AboutScreen.kt */
final class AboutScreen$createView$$inlined$apply$lambda$1 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ TextView $heapDumpTextView;
    final /* synthetic */ AboutScreen this$0;

    AboutScreen$createView$$inlined$apply$lambda$1(TextView textView, AboutScreen aboutScreen) {
        this.$heapDumpTextView = textView;
        this.this$0 = aboutScreen;
    }

    public final void onCheckedChanged(CompoundButton $noName_0, boolean checked) {
        InternalLeakCanary.INSTANCE.setDumpEnabledInAboutScreen$leakcanary_android_core_release(checked);
        AboutScreen aboutScreen = this.this$0;
        TextView textView = this.$heapDumpTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView, "heapDumpTextView");
        aboutScreen.updateHeapDumpTextView(textView);
    }
}
