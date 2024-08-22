package com.baidu.searchbox.video.channel.tab.h5;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreReducer;
import com.baidu.searchbox.feed.detail.arch.ext.InterceptorToChildReducer;
import com.baidu.searchbox.feed.detail.arch.ext.InterceptorToParentReducer;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.channel.tab.hotlaunch.ChannelHotLaunchRefreshFlowMiddleware;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.common.IntentDataReducer;
import com.baidu.searchbox.video.feedflow.detail.night.NightModeReducer;
import com.baidu.searchbox.video.feedflow.detail.search.SearchMiddleware;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeReducer;
import com.baidu.searchbox.video.feedflow.flow.h5.FlowH5CommonReducer;
import com.baidu.searchbox.video.feedflow.flow.innerouteractiontransform.InnerOuterActionTransformMiddleware;
import com.baidu.searchbox.video.feedflow.flow.more.adapter.H5MoreFlowReducerAdapterMiddleware;
import com.baidu.searchbox.video.feedflow.flow.nid.FirstJumpNidState;
import com.baidu.searchbox.video.feedflow.tab.FlowTabState;
import com.baidu.searchbox.video.feedflow.tab.TabInfoModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u0002\u001a\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0001H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002¨\u0006\t"}, d2 = {"collectReducer", "", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "collectionMiddleware", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "initState", "", "state", "video-channel_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelH5CommonFlowStore.kt */
public final class ChannelH5CommonFlowStoreKt {
    /* access modifiers changed from: private */
    public static final void initState(CommonState state) {
        state.put(new FlowTabState((TabInfoModel) null, 0, (MutableLiveData) null, 7, (DefaultConstructorMarker) null));
        state.put(new FirstJumpNidState((String) null, (String) null, (IntentData) null, 7, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public static final List<Middleware<CommonState>> collectionMiddleware() {
        List arrayList = new ArrayList();
        List $this$collectionMiddleware_u24lambda_u2d0 = arrayList;
        $this$collectionMiddleware_u24lambda_u2d0.add(new InnerOuterActionTransformMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new SearchMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ChannelHotLaunchRefreshFlowMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new H5MoreFlowReducerAdapterMiddleware());
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final List<Reducer<CommonState>> collectReducer() {
        List arrayList = new ArrayList();
        List $this$collectReducer_u24lambda_u2d1 = arrayList;
        $this$collectReducer_u24lambda_u2d1.add(new CoreReducer());
        $this$collectReducer_u24lambda_u2d1.add(new IntentDataReducer());
        $this$collectReducer_u24lambda_u2d1.add(new FlowH5CommonReducer());
        $this$collectReducer_u24lambda_u2d1.add(new InterceptorToChildReducer());
        $this$collectReducer_u24lambda_u2d1.add(new InterceptorToParentReducer());
        $this$collectReducer_u24lambda_u2d1.add(new FontSizeReducer());
        $this$collectReducer_u24lambda_u2d1.add(new NightModeReducer());
        return arrayList;
    }
}
