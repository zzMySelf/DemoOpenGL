package com.baidu.searchbox.feed.dynamicdetail.silex;

import com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor;
import com.baidu.searchbox.feed.dynamicdetail.utils.DynamicUtilsKt;
import com.baidu.searchbox.feed.flow.FeedFlowContext;
import com.baidu.searchbox.feed.listpage.domain.Channel;
import com.baidu.searchbox.feed.listpage.infrastructure.ChannelRepo;
import com.baidu.searchbox.feed.silex.Silex;
import com.baidu.searchbox.feed.silex.config.RequestConfig;
import com.baidu.searchbox.feed.silex.config.SilexState;
import com.baidu.searchbox.feed.silex.infrastructure.DataSourceParams;
import com.baidu.searchbox.feed.silex.infrastructure.SilexListRepository;
import com.baidu.searchbox.feed.silex.infrastructure.remotedata.request.SilexConnectPolicy;
import com.baidu.searchbox.feed.silex.refresh.action.ServerFeedsResultAction;
import com.baidu.searchbox.feed.silex.refresh.domain.PolicyState;
import com.baidu.searchbox.feed.silex.refresh.domain.RefreshState;
import com.baidu.searchbox.feed.util.FeedSessionManager;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J.\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/silex/DynamicImmersivePreFetcher;", "Lcom/baidu/searchbox/feed/dynamicdetail/silex/RequestParamsHolder;", "()V", "curReqNid", "", "flowContext", "Lcom/baidu/searchbox/feed/flow/FeedFlowContext;", "isFinish", "Ljava/util/concurrent/atomic/AtomicBoolean;", "requestConfig", "Lcom/baidu/searchbox/feed/silex/config/RequestConfig;", "responseInfo", "Lcom/baidu/searchbox/feed/dynamicdetail/silex/DynamicImmersiveResponse;", "silex", "Lcom/baidu/searchbox/feed/silex/Silex;", "clearRecord", "", "getDynamicImmersiveSilex", "getRequestParamsMap", "", "obtain", "", "nid", "processContext", "prefetch", "sourceFrom", "strategyType", "authorId", "extRequest", "setRequestParamsListener", "listener", "Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveAdInsertProcessor$IRequestPostParamsListener;", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersivePreFetcher.kt */
public final class DynamicImmersivePreFetcher extends RequestParamsHolder {
    public static final DynamicImmersivePreFetcher INSTANCE = new DynamicImmersivePreFetcher();
    private static String curReqNid = "";
    /* access modifiers changed from: private */
    public static FeedFlowContext flowContext;
    /* access modifiers changed from: private */
    public static AtomicBoolean isFinish = new AtomicBoolean(false);
    private static RequestConfig requestConfig;
    /* access modifiers changed from: private */
    public static DynamicImmersiveResponse responseInfo;
    private static Silex silex;

    private DynamicImmersivePreFetcher() {
    }

    public final void prefetch(String nid, String sourceFrom, String strategyType, String authorId, String extRequest) {
        String str = nid;
        String str2 = sourceFrom;
        String str3 = strategyType;
        String str4 = authorId;
        String str5 = extRequest;
        Intrinsics.checkNotNullParameter(str, "nid");
        Intrinsics.checkNotNullParameter(str2, "sourceFrom");
        Intrinsics.checkNotNullParameter(str3, "strategyType");
        Intrinsics.checkNotNullParameter(str4, "authorId");
        Intrinsics.checkNotNullParameter(str5, IntentData.Protocol.KEY_EXT_REQUEST);
        clearRecord();
        String channelId = DynamicUtilsKt.getListAssignId(str2, str, str3);
        Channel channel = ChannelRepo.getChannel(channelId);
        RefreshState refreshState = new RefreshState(channelId);
        PolicyState policyState = new PolicyState(channelId);
        refreshState.setCurRefreshSource("4");
        refreshState.setRefreshType("pull");
        FeedSessionManager.getInstance().clearSessionRefreshCountByTabId(channelId);
        policyState.setSavePolicyStatus(false);
        SilexState silexState = new SilexState(refreshState, policyState);
        channel.setSilexState(silexState);
        Ref.ObjectRef listRepository = new Ref.ObjectRef();
        listRepository.element = new SilexListRepository(channelId);
        RequestConfig config = SilexCreateManagerKt.createRequestConfig(str, str4, str5, this);
        requestConfig = config;
        Ref.ObjectRef listRepository2 = listRepository;
        SilexState silexState2 = silexState;
        silex = SilexCreateManagerKt.createSilex((SilexListRepository) listRepository.element, config, channelId, nid, sourceFrom, strategyType, authorId, extRequest);
        curReqNid = str;
        Channel channel2 = channel;
        String str6 = channelId;
        ((SilexListRepository) listRepository2.element).getSource(new DataSourceParams(channelId, "type_remote", channel.getSourceState(), refreshState, policyState, requestConfig, ((SilexListRepository) listRepository2.element).getFeedbackGRManager(), new SilexConnectPolicy(), new DynamicImmersivePreFetcher$prefetch$sourceParams$1(refreshState, channel, listRepository2)));
    }

    public final boolean obtain(String nid, FeedFlowContext processContext) {
        Intrinsics.checkNotNullParameter(nid, "nid");
        if ((nid.length() == 0) || !Intrinsics.areEqual((Object) nid, (Object) curReqNid)) {
            return false;
        }
        DynamicImmersiveResponse $this$obtain_u24lambda_u2d0 = responseInfo;
        if ($this$obtain_u24lambda_u2d0 != null) {
            DynamicUtilsKt.dynamicOnLineLog("DynamicImmersivePreFetcher", "新中台初始化之前网络请求已返回：" + nid);
            if (processContext != null) {
                processContext.dispatchOnProcess(new ServerFeedsResultAction("pull", $this$obtain_u24lambda_u2d0.isSuccess(), $this$obtain_u24lambda_u2d0.getFeedFlowModel()));
            }
            return true;
        } else if (!isFinish.get()) {
            flowContext = processContext;
            return true;
        } else {
            DynamicUtilsKt.dynamicOnLineLog("DynamicImmersivePreFetcher", "动态沉浸式新中台提前请求状态异常");
            return false;
        }
    }

    public final Silex getDynamicImmersiveSilex() {
        return silex;
    }

    public final Map<String, String> getRequestParamsMap() {
        return getRequestParams();
    }

    public final void setRequestParamsListener(DynamicImmersiveAdInsertProcessor.IRequestPostParamsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        setParamsListener(listener);
    }

    public final void clearRecord() {
        curReqNid = "";
        responseInfo = null;
        flowContext = null;
        setRequestParams((Map<String, String>) null);
        isFinish.set(false);
    }
}
