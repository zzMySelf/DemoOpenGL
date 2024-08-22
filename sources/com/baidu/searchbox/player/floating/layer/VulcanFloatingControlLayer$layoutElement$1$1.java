package com.baidu.searchbox.player.floating.layer;

import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintSet;
import com.baidu.searchbox.player.floating.element.VulcanFloatingLastButtonElement;
import com.baidu.searchbox.player.floating.element.VulcanFloatingNextButtonElement;
import com.baidu.searchbox.player.utils.ViewUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/constraintlayout/widget/ConstraintSet;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanFloatingControlLayer.kt */
final class VulcanFloatingControlLayer$layoutElement$1$1 extends Lambda implements Function1<ConstraintSet, Unit> {
    final /* synthetic */ int $playId;
    final /* synthetic */ VulcanFloatingControlLayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VulcanFloatingControlLayer$layoutElement$1$1(VulcanFloatingControlLayer vulcanFloatingControlLayer, int i2) {
        super(1);
        this.this$0 = vulcanFloatingControlLayer;
        this.$playId = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ConstraintSet) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ConstraintSet $this$layout) {
        ImageView contentView;
        ImageView contentView2;
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        VulcanFloatingLastButtonElement lastElement = this.this$0.getLastElement();
        if (!(lastElement == null || (contentView2 = lastElement.getContentView()) == null)) {
            int lastId = contentView2.getId();
            int i2 = this.$playId;
            $this$layout.connect(lastId, 2, i2, 1, ViewUtil.dp2px(29.0f));
            $this$layout.connect(lastId, 3, i2, 3);
            $this$layout.connect(lastId, 4, i2, 4);
        }
        VulcanFloatingNextButtonElement nextElement = this.this$0.getNextElement();
        if (nextElement != null && (contentView = nextElement.getContentView()) != null) {
            int nextId = contentView.getId();
            int i3 = this.$playId;
            $this$layout.connect(nextId, 1, i3, 2, ViewUtil.dp2px(29.0f));
            $this$layout.connect(nextId, 3, i3, 3);
            $this$layout.connect(nextId, 4, i3, 4);
        }
    }
}
