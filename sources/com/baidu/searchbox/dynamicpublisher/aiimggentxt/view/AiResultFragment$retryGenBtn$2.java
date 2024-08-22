package com.baidu.searchbox.dynamicpublisher.aiimggentxt.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.publishercomponent.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiResultFragment.kt */
final class AiResultFragment$retryGenBtn$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ AiResultFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiResultFragment$retryGenBtn$2(AiResultFragment aiResultFragment) {
        super(0);
        this.this$0 = aiResultFragment;
    }

    public final TextView invoke() {
        View access$getRootView$p = this.this$0.rootView;
        if (access$getRootView$p != null) {
            return (TextView) access$getRootView$p.findViewById(R.id.img_gen_txt_tab_retry_gen_btn);
        }
        return null;
    }
}
