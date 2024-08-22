package com.baidu.searchbox.aisearch.comps.conversationmanager.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/aisearch/comps/conversationmanager/item/ItemAnimHelper$dismissDeleteBtn$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemAnimHelper.kt */
public final class ItemAnimHelper$dismissDeleteBtn$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ View $flDelete;

    ItemAnimHelper$dismissDeleteBtn$1$1(View $flDelete2) {
        this.$flDelete = $flDelete2;
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$flDelete.setVisibility(8);
        this.$flDelete.setAlpha(1.0f);
    }
}
