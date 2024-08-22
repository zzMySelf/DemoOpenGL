package com.baidu.searchbox.video.collectiondetail.list;

import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.ToastRightAreaStyle;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.component.R;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.collectiondetail.list.CollectionDetailAction;
import com.baidu.searchbox.video.collectiondetail.service.ICollectionDetailLayoutService;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.toast.ToastAction;
import com.baidu.searchbox.video.detail.export.IVideoNetWorkUtils;
import com.baidu.searchbox.video.feedflow.flow.collection.view.collectionpages.CollectionPagesAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/collectiondetail/list/CollectionScrollListComponent$initCollectionPagesView$1", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/collectionpages/CollectionPagesAdapter$PageItemClickListener;", "onItemClick", "", "page", "", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionScrollListComponent.kt */
public final class CollectionScrollListComponent$initCollectionPagesView$1 implements CollectionPagesAdapter.PageItemClickListener {
    final /* synthetic */ CollectionScrollListComponent this$0;

    CollectionScrollListComponent$initCollectionPagesView$1(CollectionScrollListComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemClick(int page) {
        ICollectionDetailLayoutService iCollectionDetailLayoutService;
        int i2 = page;
        if (!IVideoNetWorkUtils.Impl.get().isConnected(this.this$0.getContext())) {
            CollectionPagesAdapter pageAdapter = this.this$0.getPageAdapter();
            if (pageAdapter != null) {
                pageAdapter.setPageItemCanResponseClick(true);
            }
            Store access$getStore = this.this$0.getStore();
            if (access$getStore != null) {
                StoreExtKt.post(access$getStore, new ToastAction.SolidShow(R.string.video_component_network_error, (CharSequence) null, 0, ToastAction.App.INSTANCE, (ToastLocation) null, (ToastTemplate) null, 0, 0, (CharSequence) null, (ToastRightAreaStyle) null, (Action) null, IMConstants.IM_MSG_TYPE_DIAMOND, (DefaultConstructorMarker) null));
                return;
            }
            return;
        }
        CollectionPagesAdapter pageAdapter2 = this.this$0.getPageAdapter();
        if (pageAdapter2 != null) {
            pageAdapter2.updatePageTabPositionFromPage(i2);
        }
        Store $this$select$iv = this.this$0.getStore();
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(CollectionDetailState.class);
            }
            CollectionDetailState collectionDetailState = (CollectionDetailState) obj;
            if (collectionDetailState != null) {
                CollectionDetailState $this$onItemClick_u24lambda_u2d0 = collectionDetailState;
                $this$onItemClick_u24lambda_u2d0.setHasClickPageTab(true);
                $this$onItemClick_u24lambda_u2d0.setClickPageTabRequestPage(i2 * 10);
            }
        }
        Store access$getStore2 = this.this$0.getStore();
        if (access$getStore2 != null) {
            StoreExtKt.post(access$getStore2, new CollectionDetailAction.OnPagesTabClickedAction(i2));
        }
        if (!Intrinsics.areEqual((Object) this.this$0.getCollectionPagesView().getParent(), (Object) this.this$0.getFlContainer()) && (iCollectionDetailLayoutService = (ICollectionDetailLayoutService) this.this$0.getManager().getService(ICollectionDetailLayoutService.class)) != null) {
            iCollectionDetailLayoutService.scrollPagesContainerBelowCeilingTop();
        }
    }
}
