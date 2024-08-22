package com.baidu.searchbox.video.feedflow.flow.comonlistpanel.view.listviewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/view/listviewholder/HotTopicItemCreator;", "Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/view/listviewholder/HotTopicBaseItemCreator;", "Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/HotListItemDataModel;", "()V", "itemViewHolder", "Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/view/listviewholder/HotTopicItemViewHolder;", "bindData", "", "data", "", "style", "", "createItemView", "Landroid/view/View;", "context", "Landroid/content/Context;", "createItemViewHolder", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotTopicItemCreator.kt */
public final class HotTopicItemCreator implements HotTopicBaseItemCreator<HotListItemDataModel> {
    private HotTopicItemViewHolder itemViewHolder;

    public View createItemView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View $this$createItemView_u24lambda_u2d0 = View.inflate(context, R.layout.video_flow_hot_topic_item_view, (ViewGroup) null);
        $this$createItemView_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNullExpressionValue($this$createItemView_u24lambda_u2d0, "inflate(context, R.layou…s.WRAP_CONTENT)\n        }");
        return $this$createItemView_u24lambda_u2d0;
    }

    public HotTopicItemViewHolder createItemViewHolder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HotTopicItemViewHolder hotTopicItemViewHolder = new HotTopicItemViewHolder(createItemView(context));
        this.itemViewHolder = hotTopicItemViewHolder;
        Intrinsics.checkNotNull(hotTopicItemViewHolder);
        return hotTopicItemViewHolder;
    }

    public void bindData(Object data, int style) {
        HotTopicItemViewHolder hotTopicItemViewHolder = this.itemViewHolder;
        if (hotTopicItemViewHolder != null) {
            hotTopicItemViewHolder.onBindData(data instanceof HotListItemDataModel ? (HotListItemDataModel) data : null, style);
        }
    }
}
