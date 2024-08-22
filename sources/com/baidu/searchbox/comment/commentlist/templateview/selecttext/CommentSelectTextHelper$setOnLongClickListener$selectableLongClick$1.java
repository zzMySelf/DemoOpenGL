package com.baidu.searchbox.comment.commentlist.templateview.selecttext;

import android.view.View;
import com.baidu.android.widget.textselect.listener.SelectableTextLongClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/comment/commentlist/templateview/selecttext/CommentSelectTextHelper$setOnLongClickListener$selectableLongClick$1", "Lcom/baidu/android/widget/textselect/listener/SelectableTextLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentSelectTextHelper.kt */
public final class CommentSelectTextHelper$setOnLongClickListener$selectableLongClick$1 implements SelectableTextLongClickListener {
    final /* synthetic */ View.OnLongClickListener $longClickListener;

    CommentSelectTextHelper$setOnLongClickListener$selectableLongClick$1(View.OnLongClickListener $longClickListener2) {
        this.$longClickListener = $longClickListener2;
    }

    public void onLongClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        View.OnLongClickListener onLongClickListener = this.$longClickListener;
        if (onLongClickListener != null) {
            onLongClickListener.onLongClick(view2);
        }
    }
}
