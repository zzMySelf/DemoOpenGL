package com.baidu.nadcore.structuretag;

import android.widget.LinearLayout;
import com.baidu.nadcore.business.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "BUTTON", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadStructureTagBaseView.kt */
final class NadStructureTagBaseView$linear$2 extends Lambda implements Function0<LinearLayout> {
    final /* synthetic */ NadStructureTagBaseView<BUTTON> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadStructureTagBaseView$linear$2(NadStructureTagBaseView<BUTTON> nadStructureTagBaseView) {
        super(0);
        this.this$0 = nadStructureTagBaseView;
    }

    public final LinearLayout invoke() {
        return (LinearLayout) this.this$0.findViewById(R.id.nad_structure_tag_holder);
    }
}
