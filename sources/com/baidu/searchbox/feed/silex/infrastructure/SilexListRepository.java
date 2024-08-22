package com.baidu.searchbox.feed.silex.infrastructure;

import com.baidu.searchbox.feed.list.domain.DataSource;
import com.baidu.searchbox.feed.list.domain.ListRepository;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.silex.config.SilexFlowConfig;
import com.baidu.searchbox.feed.silex.infrastructure.localdata.policy.DataFeedbackGRManager;
import java.util.List;
import java.util.Map;

public class SilexListRepository implements ListRepository<FeedBaseModel, DataSourceParams> {
    private String mAssignID = "";
    private DataFeedbackGRManager mFeedbackGRManager;
    private SilexFlowConfig mSilexConfig;

    public SilexListRepository(String assignId) {
        this.mAssignID = assignId;
    }

    public void getSource(DataSourceParams dataSourceParams) {
        DataSourceFactory.createDataSource(dataSourceParams.type).getSourceAsync(dataSourceParams);
    }

    public DataFeedbackGRManager getFeedbackGRManager() {
        if (this.mFeedbackGRManager == null) {
            this.mFeedbackGRManager = new DataFeedbackGRManager(this.mAssignID);
        }
        return this.mFeedbackGRManager;
    }

    public SilexFlowConfig getSilexConfig() {
        if (this.mSilexConfig == null) {
            this.mSilexConfig = new SilexFlowConfig.FlowConfigBuilder().build();
        }
        return this.mSilexConfig;
    }

    public void setSilexConfig(SilexFlowConfig silexConfig) {
        this.mSilexConfig = silexConfig;
    }

    public void save(List<FeedBaseModel> entities) {
        if (getSilexConfig().needListCacheSaveToDB) {
            DataSourceFactory.createLocalDataSource().saveData(entities, this.mAssignID);
        }
    }

    public void save(List<FeedBaseModel> list, List<FeedBaseModel> list2) {
    }

    public void saveAfterClear(List<FeedBaseModel> list) {
    }

    public boolean delete(FeedBaseModel entity) {
        DataSourceFactory.createLocalDataSource().deleteData(entity, this.mAssignID);
        return true;
    }

    public void delete(FeedBaseModel entity, boolean notifyDeleteResult) {
        DataSourceFactory.createLocalDataSource().deleteData(entity, this.mAssignID);
    }

    public void delete(List<FeedBaseModel> entities) {
        DataSourceFactory.createLocalDataSource().deleteData(entities, this.mAssignID);
    }

    public void update(String id, FeedBaseModel entity) {
        DataSourceFactory.createLocalDataSource().updateData(entity, this.mAssignID);
    }

    public void update(List<FeedBaseModel> entities) {
        DataSourceFactory.createLocalDataSource().updateData(entities, this.mAssignID);
    }

    public void clear() {
        DataSourceFactory.createLocalDataSource().clear(this.mAssignID);
    }

    public void clearByLimit(int maxLimitNum) {
    }

    public void consume(boolean isRead, FeedBaseModel entity) {
    }

    public void display(boolean isDisplay, FeedBaseModel entity) {
    }

    public void fillDataMap(Map<String, FeedBaseModel> map, List<FeedBaseModel> list) {
    }

    public DataSource.Holder getHolder() {
        return new DataSource.Holder() {
            public void bindCallback(DataSource.Callback callback) {
            }

            public DataSource.Callback getCallback() {
                return null;
            }

            public void unbindCallback() {
            }
        };
    }
}
