package com.baidu.searchbox.ng.errorview.rec.view;

import android.widget.TextView;
import com.baidu.searchbox.ng.errorview.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseRecErrorView.kt */
final class BaseRecErrorView$checkNetworkBtn$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ BaseRecErrorView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseRecErrorView$checkNetworkBtn$2(BaseRecErrorView baseRecErrorView) {
        super(0);
        this.this$0 = baseRecErrorView;
    }

    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(R.id.browser_rec_error_view_check_network);
    }
}
