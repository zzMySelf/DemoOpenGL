package com.baidu.searchbox.smartmenu.views;

import android.widget.TextView;
import com.baidu.searchbox.smartmenu.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuFavorHisItemView.kt */
final class SmartMenuFavorHisItemView$redirectBtn$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ SmartMenuFavorHisItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmartMenuFavorHisItemView$redirectBtn$2(SmartMenuFavorHisItemView smartMenuFavorHisItemView) {
        super(0);
        this.this$0 = smartMenuFavorHisItemView;
    }

    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(R.id.btn_redirect);
    }
}
