package com.baidu.searchbox.widget.template;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.widget.NotifyHorizontalSwipeItemEvent;
import com.baidu.searchbox.widget.template.WidgetOperateTemplateFactory;
import com.baidu.searchbox.widget.utils.WidgetUiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/widget/template/WidgetOperateTemplateFactory$HorizontalSwipeTemplate$initWidgetRv$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetOperateTemplateFactory.kt */
public final class WidgetOperateTemplateFactory$HorizontalSwipeTemplate$initWidgetRv$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ WidgetOperateTemplateFactory.HorizontalSwipeTemplate this$0;

    WidgetOperateTemplateFactory$HorizontalSwipeTemplate$initWidgetRv$2(WidgetOperateTemplateFactory.HorizontalSwipeTemplate $receiver) {
        this.this$0 = $receiver;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        View findSnapView;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState == 0 && (findSnapView = this.this$0.getPagerSnapHelper().findSnapView(recyclerView.getLayoutManager())) != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int position = layoutManager != null ? layoutManager.getPosition(findSnapView) : -1;
            if (AppConfig.isDebug()) {
                Log.d(WidgetUiUtils.TAG, "current position is ---> " + position);
            }
            if (position >= 0) {
                BdEventBus.Companion.getDefault().post(new NotifyHorizontalSwipeItemEvent(position));
            }
        }
    }
}
