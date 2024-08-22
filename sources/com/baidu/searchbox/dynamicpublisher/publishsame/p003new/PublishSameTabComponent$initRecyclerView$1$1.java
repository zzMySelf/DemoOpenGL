package com.baidu.searchbox.dynamicpublisher.publishsame.p003new;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.dynamicpublisher.publishsame.p003new.PublishSameTabAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/dynamicpublisher/publishsame/new/PublishSameTabComponent$initRecyclerView$1$1", "Lcom/baidu/searchbox/dynamicpublisher/publishsame/new/PublishSameTabAdapter$OnItemClickListener;", "onPublishClickListener", "", "id", "", "scheme", "sourceFrom", "type", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.baidu.searchbox.dynamicpublisher.publishsame.new.PublishSameTabComponent$initRecyclerView$1$1  reason: invalid package */
/* compiled from: PublishSameTabComponent.kt */
public final class PublishSameTabComponent$initRecyclerView$1$1 implements PublishSameTabAdapter.OnItemClickListener {
    final /* synthetic */ RecyclerView $this_run;
    final /* synthetic */ PublishSameTabComponent this$0;

    PublishSameTabComponent$initRecyclerView$1$1(RecyclerView $receiver, PublishSameTabComponent $receiver2) {
        this.$this_run = $receiver;
        this.this$0 = $receiver2;
    }

    public void onPublishClickListener(String id, String scheme, String sourceFrom, String type) {
        CharSequence charSequence = scheme;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Router.invoke(this.$this_run.getContext(), this.this$0.getNewScheme(scheme));
            this.this$0.sendClickPublishLog(type, id, sourceFrom);
            this.this$0.reportServerItemPlSerayClick(id, type);
        }
    }
}
