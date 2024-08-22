package com.baidu.searchbox.aipersonal.viewholder;

import android.view.View;
import com.baidu.android.util.devices.DeviceUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "T", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiBaseViewHolder.kt */
final class AiBaseViewHolder$dp14$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ View $itemView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiBaseViewHolder$dp14$2(View view2) {
        super(0);
        this.$itemView = view2;
    }

    public final Float invoke() {
        return Float.valueOf(DeviceUtils.ScreenInfo.dp2pxf(this.$itemView.getContext(), 14.0f));
    }
}
