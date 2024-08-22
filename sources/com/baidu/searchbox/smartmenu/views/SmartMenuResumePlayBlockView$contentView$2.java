package com.baidu.searchbox.smartmenu.views;

import android.widget.LinearLayout;
import com.baidu.searchbox.smartmenu.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuResumePlayBlockView.kt */
final class SmartMenuResumePlayBlockView$contentView$2 extends Lambda implements Function0<LinearLayout> {
    final /* synthetic */ SmartMenuResumePlayBlockView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmartMenuResumePlayBlockView$contentView$2(SmartMenuResumePlayBlockView smartMenuResumePlayBlockView) {
        super(0);
        this.this$0 = smartMenuResumePlayBlockView;
    }

    public final LinearLayout invoke() {
        return (LinearLayout) this.this$0.findViewById(R.id.favor_his_list);
    }
}
