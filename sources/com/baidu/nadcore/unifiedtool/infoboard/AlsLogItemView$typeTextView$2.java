package com.baidu.nadcore.unifiedtool.infoboard;

import android.widget.TextView;
import com.baidu.nadcore.unifiedtool.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: InfoBoard.kt */
final class AlsLogItemView$typeTextView$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ AlsLogItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlsLogItemView$typeTextView$2(AlsLogItemView alsLogItemView) {
        super(0);
        this.this$0 = alsLogItemView;
    }

    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(R.id.nad_als_log_item_log_type);
    }
}
