package com.baidu.searchbox.history.adapter;

import android.view.View;
import com.baidu.searchbox.history.webvideo.HistoryWebVideoModel;
import com.baidu.searchbox.history.webvideo.OnHistoryWebVideoItemClickListener;
import com.baidu.searchbox.userassetsaggr.container.template.ITemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/history/adapter/NewHistoryWebVideoAdapter$onBindViewHolder$4", "Lcom/baidu/searchbox/userassetsaggr/container/template/ITemplate$OnChildClickListener;", "onClick", "", "view", "Landroid/view/View;", "lib-history_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHistoryWebVideoAdapter.kt */
public final class NewHistoryWebVideoAdapter$onBindViewHolder$4 implements ITemplate.OnChildClickListener {
    final /* synthetic */ HistoryWebVideoModel $webVideoModel;
    final /* synthetic */ NewHistoryWebVideoAdapter this$0;

    NewHistoryWebVideoAdapter$onBindViewHolder$4(NewHistoryWebVideoAdapter $receiver, HistoryWebVideoModel $webVideoModel2) {
        this.this$0 = $receiver;
        this.$webVideoModel = $webVideoModel2;
    }

    public void onClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        OnHistoryWebVideoItemClickListener access$getMItemClick$p = this.this$0.mItemClick;
        if (access$getMItemClick$p != null) {
            access$getMItemClick$p.onNetDiskClick(this.$webVideoModel);
        }
    }
}
