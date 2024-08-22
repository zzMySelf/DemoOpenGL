package com.baidu.searchbox.comment.input;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.comment.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentQuickInputBar.kt */
final class CommentQuickInputBar$recyclerView$2 extends Lambda implements Function0<RecyclerView> {
    final /* synthetic */ CommentQuickInputBar this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommentQuickInputBar$recyclerView$2(CommentQuickInputBar commentQuickInputBar) {
        super(0);
        this.this$0 = commentQuickInputBar;
    }

    public final RecyclerView invoke() {
        return (RecyclerView) this.this$0.findViewById(R.id.comment_quick_input_scroll);
    }
}
