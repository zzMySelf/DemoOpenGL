package com.baidu.searchbox.aisearch.comps.conversationmanager.item.normalitem;

import android.graphics.drawable.Drawable;
import com.baidu.searchbox.aisearch.R;
import com.baidu.searchbox.aisearch.utils.ResExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NormalItemComp.kt */
final class NormalItemComp$selectedDrawable$2 extends Lambda implements Function0<Drawable> {
    public static final NormalItemComp$selectedDrawable$2 INSTANCE = new NormalItemComp$selectedDrawable$2();

    NormalItemComp$selectedDrawable$2() {
        super(0);
    }

    public final Drawable invoke() {
        return ResExtKt.getDrawable(R.drawable.conversation_item_selected_bg);
    }
}
