package com.baidu.searchbox.elasticthread.statistic;

import android.os.SystemClock;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.ElasticDataUploader;
import com.baidu.searchbox.elasticthread.executor.BaseDredgeExecutorCell;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.queue.ElasticQueue;
import com.baidu.searchbox.elasticthread.queue.QueueManager;
import com.baidu.searchbox.elasticthread.scheduler.ArteryManager;
import com.baidu.searchbox.elasticthread.scheduler.DredgeManager;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.feed.controller.FeedDisasterManager;
import com.baidu.searchbox.player.preboot.policy.PlayPolicyKt;
import org.json.JSONException;
import org.json.JSONObject;

public class StatisticRecorder implements Recordable {
    private static final boolean DEBUG = false;
    private static final String TAG = "ElasticRecord";
    public static final long UPLOAD_DATA_TIME_THRESHOLD = 30000;
    private volatile long lastRecordBeginTime = 0;
    private volatile long lastRecordEndTime = 0;
    private volatile Recordable.RecordStatus mRecordStatus = Recordable.RecordStatus.UNINITIATED;

    public long getRecordElapseTime() {
        if (this.mRecordStatus == Recordable.RecordStatus.RECORD_END) {
            return this.lastRecordEndTime - this.lastRecordBeginTime;
        }
        return -1;
    }

    public void onRecordBegin() {
        this.mRecordStatus = Recordable.RecordStatus.RECORDING;
        this.lastRecordBeginTime = SystemClock.elapsedRealtime();
        this.lastRecordEndTime = 0;
    }

    public void onRecordEnd() {
        this.mRecordStatus = Recordable.RecordStatus.RECORD_END;
        this.lastRecordEndTime = SystemClock.elapsedRealtime();
    }

    public Recordable.RecordStatus getRecordStatus() {
        return this.mRecordStatus;
    }

    public void uploadData() {
        if (this.mRecordStatus == Recordable.RecordStatus.RECORD_END) {
            try {
                ElasticTaskScheduler elasticTaskScheduler = ElasticTaskScheduler.getInstance();
                JSONObject rootData = new JSONObject();
                rootData.put(PlayPolicyKt.JSON_KEY_RECORD_TIME, getRecordElapseTime());
                JSONObject executorData = new JSONObject();
                JSONObject arteryExecutorData = new JSONObject();
                ArteryManager arteryManager = elasticTaskScheduler.getArteryManager();
                arteryExecutorData.put("first", loadArteryExecutorData(arteryManager.getUserRelatedArteryExecutor()));
                arteryExecutorData.put("second", loadArteryExecutorData(arteryManager.getInTimeArteryExecutor()));
                arteryExecutorData.put("third", loadArteryExecutorData(arteryManager.getBackgroundArteryExecutor()));
                executorData.put("artery", arteryExecutorData);
                JSONObject dredgeExecutorData = new JSONObject();
                DredgeManager dredgeManager = elasticTaskScheduler.getDredgeManager();
                dredgeExecutorData.put("first", loadDredgeExecutorData(dredgeManager.getFirstDredgeExecutor(), ElasticConfig.DREDGE_CONFIG_FIRST_CORE_POOL_SIZE));
                dredgeExecutorData.put("second", loadDredgeExecutorData(dredgeManager.getSecondDredgeExecutor(), ElasticConfig.DREDGE_CONFIG_SECOND_CORE_POOL_SIZE));
                dredgeExecutorData.put(FeedDisasterManager.DISASTER, loadDredgeExecutorData(dredgeManager.getDisasterDredgeExecutor(), ElasticConfig.DREDGE_CONFIG_DISASTER_MAX_POOL_SIZE));
                executorData.put("dredge", dredgeExecutorData);
                rootData.put("executor", executorData);
                JSONObject queueData = new JSONObject();
                QueueManager queueManager = elasticTaskScheduler.getQueueManager();
                queueData.put("immediate", loadSingleQueueData(queueManager.getQueue(0)));
                queueData.put("first", loadSingleQueueData(queueManager.getQueue(1)));
                queueData.put("second", loadSingleQueueData(queueManager.getQueue(2)));
                queueData.put("third", loadSingleQueueData(queueManager.getQueue(3)));
                rootData.put("queue", queueData);
                ElasticDataUploader.getInstance().uploadStatisticData(rootData);
            } catch (Exception e2) {
            }
        }
    }

    private JSONObject loadArteryExecutorData(BaseExecutorCell arteryExecutorCell) throws JSONException {
        JSONObject data = new JSONObject();
        if (arteryExecutorCell != null) {
            data.put("maxThreadNum", arteryExecutorCell.getMaxThreadNum());
            data.put("workTime", arteryExecutorCell.getWorkTimeInRecordLifeCycle());
            data.put("completedTaskCount", arteryExecutorCell.getCompletedTaskCountInRecordLifeCycle());
        }
        return data;
    }

    private JSONObject loadDredgeExecutorData(BaseDredgeExecutorCell dredgeExecutorCell, int defaultThreadNum) throws JSONException {
        JSONObject data = new JSONObject();
        if (dredgeExecutorCell != null) {
            data.put("maxThreadNum", dredgeExecutorCell.getMaxThreadNum());
            data.put("workTime", dredgeExecutorCell.getWorkTimeInRecordLifeCycle());
            data.put("completedTaskCount", dredgeExecutorCell.getCompletedTaskCountInRecordLifeCycle());
            data.put("openTime", dredgeExecutorCell.getOpenTimeInRecordLifeCycle());
            data.put("openCount", dredgeExecutorCell.getOpenCountInRecordLifeCycle());
        }
        return data;
    }

    private JSONObject loadSingleQueueData(ElasticQueue elasticQueue) throws JSONException {
        JSONObject data = new JSONObject();
        data.put("waitingTime", elasticQueue.getWaitingTimeInRecordLifeCycle());
        data.put("outputTaskCount", elasticQueue.getOutputTaskNumInRecordLifeCycle());
        return data;
    }
}
