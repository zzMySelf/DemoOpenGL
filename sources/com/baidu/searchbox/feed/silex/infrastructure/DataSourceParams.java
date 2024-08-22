package com.baidu.searchbox.feed.silex.infrastructure;

import com.baidu.searchbox.feed.list.domain.DataSource;
import com.baidu.searchbox.feed.list.domain.states.SourceState;
import com.baidu.searchbox.feed.silex.config.RequestConfig;
import com.baidu.searchbox.feed.silex.infrastructure.localdata.policy.DataFeedbackGRManager;
import com.baidu.searchbox.feed.silex.infrastructure.remotedata.request.SilexConnectPolicy;
import com.baidu.searchbox.feed.silex.refresh.domain.PolicyState;
import com.baidu.searchbox.feed.silex.refresh.domain.RefreshState;

public class DataSourceParams extends DataSource.AbsParam {
    public static final String TYPE_LOCAL = "type_local";
    public static final String TYPE_REMOTE = "type_remote";
    public String assignID;
    public SilexConnectPolicy connectPolicy;
    public DataFeedbackGRManager grManager;
    public boolean isColdRefreshFromDB = false;
    public int loadDBSize = -1;
    public PolicyState policyState;
    public RefreshState refreshState;
    public RequestConfig requestConfig;
    public SourceState sourceState;
    public String type;

    public DataSourceParams(String type2, SourceState state) {
        this.type = type2;
        this.sourceState = state;
    }

    public DataSourceParams(String assignID2, String type2, boolean isColdRefreshFromDB2, SourceState state, DataSource.Callback callback) {
        this.assignID = assignID2;
        this.type = type2;
        this.isColdRefreshFromDB = isColdRefreshFromDB2;
        this.sourceState = state;
        this.asyncCallback = callback;
    }

    public DataSourceParams(String assignID2, String type2, int dbSize, SourceState state, DataSource.Callback callback) {
        this.assignID = assignID2;
        this.type = type2;
        this.loadDBSize = dbSize;
        this.sourceState = state;
        this.asyncCallback = callback;
    }

    public DataSourceParams(String assignID2, String type2, SourceState state, RefreshState refreshState2, PolicyState policyState2, RequestConfig requestConfig2, DataFeedbackGRManager feedbackGRManager, SilexConnectPolicy connectPolicy2, DataSource.Callback callback) {
        this.assignID = assignID2;
        this.type = type2;
        this.sourceState = state;
        this.policyState = policyState2;
        this.refreshState = refreshState2;
        this.requestConfig = requestConfig2;
        this.grManager = feedbackGRManager;
        this.asyncCallback = callback;
        this.connectPolicy = connectPolicy2;
    }

    public int getLoadDBSize() {
        int i2 = this.loadDBSize;
        if (i2 > 0) {
            return i2;
        }
        return this.isColdRefreshFromDB ? 10 : 20;
    }
}
