package com.baidu.nadcore.structuretag;

import android.text.TextPaint;
import com.baidu.nadcore.business.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/text/TextPaint;", "BUTTON", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadStructureTagBaseView.kt */
final class NadStructureTagBaseView$titlePaint$2 extends Lambda implements Function0<TextPaint> {
    final /* synthetic */ NadStructureTagBaseView<BUTTON> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadStructureTagBaseView$titlePaint$2(NadStructureTagBaseView<BUTTON> nadStructureTagBaseView) {
        super(0);
        this.this$0 = nadStructureTagBaseView;
    }

    public final TextPaint invoke() {
        TextPaint $this$invoke_u24lambda_u2d0 = new TextPaint();
        $this$invoke_u24lambda_u2d0.setTextSize((float) this.this$0.getResources().getDimensionPixelSize(R.dimen.structure_tag_title_size));
        return $this$invoke_u24lambda_u2d0;
    }
}
