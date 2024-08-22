package com.baidu.assistant.debug.activity;

import android.widget.TextView;
import com.baidu.assistant.debug.R;
import com.baidu.assistant.debug.assistant.autoutil.ModelAutoTestProxy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/assistant/debug/activity/AssistantModelAutoTestActivity$initAutoManager$1", "Lcom/baidu/assistant/debug/assistant/autoutil/ModelAutoTestProxy$ListCounterListener;", "allCounter", "", "readyCount", "", "totalCount", "failCounter", "count", "lib-assistant-debug_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssistantModelAutoTestActivity.kt */
public final class AssistantModelAutoTestActivity$initAutoManager$1 implements ModelAutoTestProxy.ListCounterListener {
    final /* synthetic */ AssistantModelAutoTestActivity this$0;

    AssistantModelAutoTestActivity$initAutoManager$1(AssistantModelAutoTestActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void failCounter(int count) {
        TextView access$getTvFail$p = this.this$0.tvFail;
        if (access$getTvFail$p != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.this$0.getString(R.string.assistant_auto_test_fail_text);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.assistant_auto_test_fail_text)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(count)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            access$getTvFail$p.setText(format);
        }
    }

    public void allCounter(int readyCount, int totalCount) {
        TextView access$getTvTotal$p = this.this$0.tvTotal;
        if (access$getTvTotal$p != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.this$0.getString(R.string.assistant_auto_test_total_text);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.assistant_auto_test_total_text)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(readyCount), Integer.valueOf(totalCount)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            access$getTvTotal$p.setText(format);
        }
    }
}
