package com.baidu.nadcore.structuretag;

import com.baidu.nadcore.business.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadStructureTagView2.kt */
final class NadStructureTagView2$containerPaddingStart$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ NadStructureTagView2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadStructureTagView2$containerPaddingStart$2(NadStructureTagView2 nadStructureTagView2) {
        super(0);
        this.this$0 = nadStructureTagView2;
    }

    public final Integer invoke() {
        return Integer.valueOf(this.this$0.getResources().getDimensionPixelSize(R.dimen.structure_tag_container_padding_start_2));
    }
}
