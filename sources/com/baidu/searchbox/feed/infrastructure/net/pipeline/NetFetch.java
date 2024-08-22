package com.baidu.searchbox.feed.infrastructure.net.pipeline;

import androidx.core.util.Pair;
import com.baidu.searchbox.feed.infrastructure.net.FetchState;
import com.baidu.searchbox.feed.infrastructure.net.adapter.CallbackAdapter;
import com.baidu.searchbox.feed.infrastructure.net.adapter.IResponse;
import com.baidu.searchbox.feed.infrastructure.net.callback.ColdPrefetchCallback;
import com.baidu.searchbox.feed.infrastructure.net.pipeline.context.CallbackResult;
import com.baidu.searchbox.feed.infrastructure.net.pipeline.context.ChainContext;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.texas.context.pipeline.base.Result;

public class NetFetch extends BaseSourceStage<Result, Boolean> implements BaselineStage {
    private CallbackAdapter<FeedFlowModel> mCallback = new CallbackAdapter<FeedFlowModel>() {
        public FeedFlowModel parseResponse(IResponse response, int statusCode) throws Exception {
            NetFetch.this.mChainContext.setResult(new CallbackResult(statusCode, response, NetFetch.this.mState));
            NetFetch.this.mChain.proceed(NetFetch.this.mChainContext);
            FeedFlowModel feedFlowModel = (FeedFlowModel) CallbackResult.extractPayload(NetFetch.this.mChainContext, FeedFlowModel.EMPTY);
            if (feedFlowModel == FeedFlowModel.EMPTY) {
                return null;
            }
            return feedFlowModel;
        }

        public void onSuccess(FeedFlowModel feedFlowModel, int statusCode) {
            CallbackResult.ensureForSuccess(NetFetch.this.mChainContext, statusCode, feedFlowModel, NetFetch.this.mState);
            NetFetch.this.mChain.proceed(NetFetch.this.mChainContext);
        }

        public void onFail(Exception e2) {
            CallbackResult.ensureForFail(NetFetch.this.mChainContext, e2, NetFetch.this.mState);
            NetFetch.this.mChain.proceed(NetFetch.this.mChainContext);
        }
    };
    private final boolean mIsPreFetch;
    private ColdPrefetchCallback<CallbackAdapter<FeedFlowModel>> mPrefetchCallback = new ColdPrefetchCallback<CallbackAdapter<FeedFlowModel>>() {
        public void sendSuccessResult(CallbackAdapter<FeedFlowModel> nextCallback, FeedFlowModel feedFlowModel, int code) {
            NetFetch.this.mChainContext.sendPrefetchResult(nextCallback, Result.forResult(new Pair(feedFlowModel, Integer.valueOf(code))));
        }

        public void sendFailResult(CallbackAdapter<FeedFlowModel> nextCallback, Exception e2) {
            NetFetch.this.mChainContext.sendPrefetchResult(nextCallback, Result.forError(e2));
        }
    };
    /* access modifiers changed from: private */
    public FetchState mState;

    public NetFetch(boolean isPreFetch) {
        super(Result.class);
        this.mIsPreFetch = isPreFetch;
    }

    /* access modifiers changed from: protected */
    public Boolean runWith(ChainContext context, Result result) {
        ChainContext chainContext = context;
        FetchState fetchState = (FetchState) result.getOrDefault(new FetchState(this.mChainContext.callResult, this.mChainContext));
        this.mState = fetchState;
        fetchState.isPreFetch = this.mIsPreFetch;
        if (!this.mIsPreFetch) {
            this.mState.finalStart = System.currentTimeMillis();
        }
        FeedUtil.refreshLog("NetFetch", String.format("runWith result-fail=%s, prefetch=%s", new Object[]{Boolean.valueOf(!result.isSuccess()), Boolean.valueOf(this.mIsPreFetch)}));
        if (!result.isSuccess()) {
            if (this.mIsPreFetch) {
                this.mPrefetchCallback.sendFailResult(this.mCallback, (Exception) result.getFailCause());
            }
            return false;
        }
        if (this.mIsPreFetch) {
            context.getRequester().getFeedFlowWithStatSync(this.mState.tabId, this.mState.getParams(), this.mState.postParams(), this.mState.connectTimeout, this.mState.readTimeout, this.mPrefetchCallback, this.mCallback, this.mState.needPreConnect);
        } else {
            context.getRequester().getFeedFlowWithStat(this.mState.tabId, this.mState.getParams(), this.mState.postParams(), this.mState.connectTimeout, this.mState.readTimeout, this.mCallback, this.mState.needPreConnect);
        }
        if (chainContext.connectionPolicy != null && !chainContext.connectionPolicy.isRetried()) {
            FeedStatisticCenter.ubcRefreshReliability(this.mState.tabId);
        }
        return false;
    }
}
