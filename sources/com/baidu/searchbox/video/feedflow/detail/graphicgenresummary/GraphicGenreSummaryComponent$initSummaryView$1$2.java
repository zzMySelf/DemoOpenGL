package com.baidu.searchbox.video.feedflow.detail.graphicgenresummary;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.graphicgenresummary.FlowExpandableTextView;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/graphicgenresummary/GraphicGenreSummaryComponent$initSummaryView$1$2", "Lcom/baidu/searchbox/video/feedflow/detail/graphicgenresummary/FlowExpandableTextView$IOnExpandStateChangeListener;", "onExpandContainerClick", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicGenreSummaryComponent.kt */
public final class GraphicGenreSummaryComponent$initSummaryView$1$2 implements FlowExpandableTextView.IOnExpandStateChangeListener {
    final /* synthetic */ GraphicGenreSummaryComponent this$0;

    GraphicGenreSummaryComponent$initSummaryView$1$2(GraphicGenreSummaryComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onCollapse() {
        FlowExpandableTextView.IOnExpandStateChangeListener.DefaultImpls.onCollapse(this);
    }

    public void onExpand() {
        FlowExpandableTextView.IOnExpandStateChangeListener.DefaultImpls.onExpand(this);
    }

    public void onExpandContainerClick() {
        MutableLiveData<SummaryModel> summaryData;
        SummaryModel value;
        Store $this$select$iv = this.this$0.getStore();
        String str = null;
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            GraphicGenreSummaryState graphicGenreSummaryState = (GraphicGenreSummaryState) (commonState != null ? commonState.select(GraphicGenreSummaryState.class) : null);
            if (!(graphicGenreSummaryState == null || (summaryData = graphicGenreSummaryState.getSummaryData()) == null || (value = summaryData.getValue()) == null)) {
                str = value.getDetailsCmd();
            }
        }
        if (str == null) {
            str = "";
        }
        String cmd = str;
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new FlowExpandableClickAction(cmd));
        }
    }
}
