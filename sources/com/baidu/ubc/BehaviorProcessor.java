package com.baidu.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.AppProcessManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.BehaviorModel;
import com.baidu.ubc.UBCApiCollector;
import com.baidu.ubc.bypass.BypassConstants;
import com.baidu.ubc.bypass.FunnelHelper;
import com.baidu.ubc.constants.EnumConstants;
import com.baidu.ubc.task.PriorityTask;
import com.baidu.ubc.utils.LogIdUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class BehaviorProcessor {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = UBCHelper.isDebug();
    private static final int FLOW_HANDLE_BUFFER = 10;
    private static final int HIGH_PRIORITY_SAVE_TYPE_0 = 0;
    private static final int HIGH_PRIORITY_SAVE_TYPE_1 = 1;
    private static final int HIGH_PRIORITY_SAVE_TYPE_2 = 2;
    private static final String TAG = "UBCBehaviorProcessor";
    private static volatile BehaviorProcessor mInstance;
    private long lastRequireTokenTime = SystemClock.elapsedRealtime();
    /* access modifiers changed from: private */
    public BehaviorModel mBehaviorModel;
    /* access modifiers changed from: private */
    public BehaviorRuleManager mBehaviorRule;
    /* access modifiers changed from: private */
    public Context mContext;
    public ExecutorService mExecutorService;
    /* access modifiers changed from: private */
    public AtomicInteger mGlobalFlowHandle;
    /* access modifiers changed from: private */
    public int mHighPrioritySaveType;
    /* access modifiers changed from: private */
    public IUbcLogStore mLogManager;
    /* access modifiers changed from: private */
    public boolean mUBCLogInit;
    private ExecutorService mUploadService;
    private boolean mUploaded = false;

    private BehaviorProcessor() {
        FunnelHelper.collectInitFunnel(BypassConstants.Funnel.INIT_START);
        YalogHelper.saveRuntimeLogWithMsg("clockTime:" + SystemClock.elapsedRealtime(), EnumConstants.RunTime.INIT_START);
        init(UBCHelper.getAppContext());
    }

    public static BehaviorProcessor getInstance() {
        if (mInstance == null) {
            synchronized (BehaviorProcessor.class) {
                if (mInstance == null) {
                    mInstance = new BehaviorProcessor();
                }
            }
        }
        return mInstance;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            AtomicInteger atomicInteger = new AtomicInteger(UBCHelper.getFlowHandleFromConfig() + 10);
            this.mGlobalFlowHandle = atomicInteger;
            try {
                UBCHelper.saveFlowHandleToConfig(atomicInteger.get());
            } catch (Throwable th2) {
            }
            int highPrioritySaveType = UBCHelper.getUBCABTest().getHighPrioritySaveType();
            this.mHighPrioritySaveType = highPrioritySaveType;
            if (highPrioritySaveType == 2) {
                this.mExecutorService = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 10, TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
            } else {
                this.mExecutorService = Executors.newSingleThreadScheduledExecutor();
            }
            FunnelHelper.collectInitFunnel(BypassConstants.Funnel.INIT_THREAD_SUCC);
            YalogHelper.saveRuntimeLogWithMsg("init thread success", EnumConstants.RunTime.INIT_MESSAGE);
            executeHighPriorityTask(new InitRunnable());
            this.mUploadService = Executors.newSingleThreadExecutor();
            FunnelHelper.collectInitFunnel(BypassConstants.Funnel.INIT_UPLOAD_THREAD_SUCC);
            YalogHelper.saveRuntimeLogWithMsg("init upload thread success", EnumConstants.RunTime.INIT_MESSAGE);
        }
    }

    private void executeHighPriorityTask(Runnable runnable) {
        if (this.mHighPrioritySaveType == 2) {
            this.mExecutorService.execute(new PriorityTask(runnable, 10, new BehaviorProcessor$$ExternalSyntheticLambda0(this)));
        } else {
            executeMiddlePriorityTask(runnable);
        }
    }

    private void executeMiddlePriorityTask(Runnable runnable) {
        int i2 = this.mHighPrioritySaveType;
        if (i2 == 2) {
            this.mExecutorService.execute(new PriorityTask(runnable, 5, new BehaviorProcessor$$ExternalSyntheticLambda1(this, runnable)));
        } else if (i2 == 1) {
            this.mExecutorService.execute(new CatchExceptionRunnable(runnable));
        } else {
            this.mExecutorService.execute(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$executeMiddlePriorityTask$1$com-baidu-ubc-BehaviorProcessor  reason: not valid java name */
    public /* synthetic */ void m8151lambda$executeMiddlePriorityTask$1$combaiduubcBehaviorProcessor(Runnable runnable, Runnable runnable1, Throwable throwable) {
        m8150lambda$executeHighPriorityTask$0$combaiduubcBehaviorProcessor(runnable, throwable);
    }

    /* access modifiers changed from: package-private */
    public void processEvent(String eventId, String value, int option) {
        executeHighPriorityTask(new EventRunnable(eventId, value, option));
    }

    /* access modifiers changed from: package-private */
    public void processEvent(String eventId, String value, int option, String bizInfo) {
        executeHighPriorityTask(new EventRunnable(eventId, value, option, bizInfo));
    }

    /* access modifiers changed from: package-private */
    public void processEvent(String eventId, JSONObject value, int option) {
        executeHighPriorityTask(new EventRunnable(eventId, value, option));
    }

    /* access modifiers changed from: package-private */
    public void processEvent(String eventId, JSONObject value, int option, String bizInfo) {
        executeHighPriorityTask(new EventRunnable(eventId, value, option, bizInfo));
    }

    /* access modifiers changed from: package-private */
    public void multiProcessEvent(String eventId, String value, String fileName, int option) {
        UBCApiCollector.getInstance().collect(eventId, 0, UBCApiCollector.ApiType.MULTI_PROCESS_EVENT);
        EventRunnable eventRunnable = new EventRunnable(eventId, value, option);
        if (!TextUtils.isEmpty(fileName)) {
            eventRunnable.setSaveFileName(fileName);
        }
        executeHighPriorityTask(eventRunnable);
    }

    public void processFlowEvent(String flowId, String eventId, int flowHandle, String value, int option) {
        executeHighPriorityTask(new EventRunnable(flowId, eventId, flowHandle, value, option));
    }

    public void processFlowEvent(String flowId, String eventId, int flowHandle, String value, long eventDate, int option) {
        executeHighPriorityTask(new EventRunnable(this, flowId, eventId, flowHandle, value, eventDate, option));
    }

    /* access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String flowId, String value, int option) {
        Flow flow;
        flow = createFlow(flowId, option);
        if (flow != null && flow.getValid()) {
            DoubleLogStatistics.getInstance().saveDoubleLogFlow(flow, value);
            FlowCreateRunnable flowCreateRunnable = new FlowCreateRunnable(flow, value);
            BehaviorRuleManager behaviorRuleManager = this.mBehaviorRule;
            if (behaviorRuleManager != null && behaviorRuleManager.isLastLimit(flowId)) {
                flowCreateRunnable.setControl(true);
                YalogHelper.saveRuntimeLogWithFlow(flowId, flow.getHandle(), flow.getUUID(), EnumConstants.RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
            }
            executeHighPriorityTask(flowCreateRunnable);
        }
        return flow;
    }

    /* access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String flowId, String value, int option, String bizInfo) {
        Flow flow;
        flow = createFlow(flowId, option);
        if (flow != null && flow.getValid()) {
            DoubleLogStatistics.getInstance().saveDoubleLogFlow(flow, value);
            FlowCreateRunnable flowCreateRunnable = new FlowCreateRunnable(flow, value, bizInfo);
            BehaviorRuleManager behaviorRuleManager = this.mBehaviorRule;
            if (behaviorRuleManager != null && behaviorRuleManager.isLastLimit(flowId)) {
                flowCreateRunnable.setControl(true);
                YalogHelper.saveRuntimeLogWithFlow(flowId, flow.getHandle(), flow.getUUID(), EnumConstants.RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
            }
            executeHighPriorityTask(flowCreateRunnable);
        }
        return flow;
    }

    /* access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String flowId, String value, int option, long customStartTime) {
        Flow flow;
        flow = createFlow(flowId, option, customStartTime);
        if (flow != null && flow.getValid()) {
            DoubleLogStatistics.getInstance().saveDoubleLogFlow(flow, value);
            FlowCreateRunnable flowCreateRunnable = new FlowCreateRunnable(flow, value);
            BehaviorRuleManager behaviorRuleManager = this.mBehaviorRule;
            if (behaviorRuleManager != null && behaviorRuleManager.isLastLimit(flowId)) {
                flowCreateRunnable.setControl(true);
                YalogHelper.saveRuntimeLogWithFlow(flowId, flow.getHandle(), flow.getUUID(), EnumConstants.RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
            }
            executeHighPriorityTask(flowCreateRunnable);
        }
        return flow;
    }

    /* access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String flowId, String value, int option, long customStartTime, String bizInfo) {
        Flow flow;
        flow = createFlow(flowId, option, customStartTime);
        if (flow != null && flow.getValid()) {
            DoubleLogStatistics.getInstance().saveDoubleLogFlow(flow, value);
            FlowCreateRunnable flowCreateRunnable = new FlowCreateRunnable(flow, value, bizInfo);
            BehaviorRuleManager behaviorRuleManager = this.mBehaviorRule;
            if (behaviorRuleManager != null && behaviorRuleManager.isLastLimit(flowId)) {
                flowCreateRunnable.setControl(true);
                YalogHelper.saveRuntimeLogWithFlow(flowId, flow.getHandle(), flow.getUUID(), EnumConstants.RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
            }
            executeHighPriorityTask(flowCreateRunnable);
        }
        return flow;
    }

    /* access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String flowId, JSONObject value, int option) {
        Flow flow;
        flow = createFlow(flowId, option);
        if (flow != null && flow.getValid()) {
            DoubleLogStatistics.getInstance().saveDoubleLogFlow(flow, value != null ? value.toString() : "");
            FlowCreateRunnable flowCreateRunnable = new FlowCreateRunnable(flow, value);
            BehaviorRuleManager behaviorRuleManager = this.mBehaviorRule;
            if (behaviorRuleManager != null && behaviorRuleManager.isLastLimit(flowId)) {
                flowCreateRunnable.setControl(true);
                YalogHelper.saveRuntimeLogWithFlow(flowId, flow.getHandle(), flow.getUUID(), EnumConstants.RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
            }
            executeHighPriorityTask(flowCreateRunnable);
        }
        return flow;
    }

    /* access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String flowId, JSONObject value, int option, String bizInfo) {
        Flow flow;
        flow = createFlow(flowId, option);
        if (flow != null && flow.getValid()) {
            DoubleLogStatistics.getInstance().saveDoubleLogFlow(flow, value != null ? value.toString() : "");
            FlowCreateRunnable flowCreateRunnable = new FlowCreateRunnable(flow, value, bizInfo);
            BehaviorRuleManager behaviorRuleManager = this.mBehaviorRule;
            if (behaviorRuleManager != null && behaviorRuleManager.isLastLimit(flowId)) {
                flowCreateRunnable.setControl(true);
                YalogHelper.saveRuntimeLogWithFlow(flowId, flow.getHandle(), flow.getUUID(), EnumConstants.RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
            }
            executeHighPriorityTask(flowCreateRunnable);
        }
        return flow;
    }

    /* access modifiers changed from: package-private */
    public Flow createFlow(String flowId, int option) {
        if ((option & 4) != 0) {
            option ^= 4;
        }
        Flow flow = new Flow(flowId, this.mGlobalFlowHandle, option);
        flow.setUUID(UBCUtil.getLogUUID());
        BehaviorRuleManager behaviorRuleManager = this.mBehaviorRule;
        if (behaviorRuleManager != null && !behaviorRuleManager.checkRecord(flowId, option)) {
            flow.setValid(false);
            return flow;
        } else if ((option & 16) == 0 || UBCHelper.getUBCContext().isSampled(flowId)) {
            BehaviorRuleManager behaviorRuleManager2 = this.mBehaviorRule;
            if (behaviorRuleManager2 == null || !behaviorRuleManager2.checkSample(flowId)) {
                BehaviorRuleManager behaviorRuleManager3 = this.mBehaviorRule;
                if (behaviorRuleManager3 == null || !behaviorRuleManager3.isControl(flowId)) {
                    BehaviorRuleManager behaviorRuleManager4 = this.mBehaviorRule;
                    if (behaviorRuleManager4 == null || behaviorRuleManager4.isNeedCache(flowId)) {
                        FunnelHelper.collectLogFunnel(BypassConstants.Funnel.SAMPLE_FLOW, flow.getId(), System.currentTimeMillis());
                        return flow;
                    }
                    flow.setValid(false);
                    return flow;
                }
                flow.setValid(false);
                return flow;
            }
            flow.setValid(false);
            return flow;
        } else {
            flow.setValid(false);
            return flow;
        }
    }

    /* access modifiers changed from: package-private */
    public Flow createFlow(String flowId, int option, long customStartTime) {
        if ((option & 4) != 0) {
            option ^= 4;
        }
        Flow flow = new Flow(flowId, this.mGlobalFlowHandle, option, customStartTime);
        flow.setUUID(UBCUtil.getLogUUID());
        BehaviorRuleManager behaviorRuleManager = this.mBehaviorRule;
        if (behaviorRuleManager != null && !behaviorRuleManager.checkRecord(flowId, option)) {
            flow.setValid(false);
            return flow;
        } else if ((option & 16) == 0 || UBCHelper.getUBCContext().isSampled(flowId)) {
            BehaviorRuleManager behaviorRuleManager2 = this.mBehaviorRule;
            if (behaviorRuleManager2 == null || !behaviorRuleManager2.checkSample(flowId)) {
                BehaviorRuleManager behaviorRuleManager3 = this.mBehaviorRule;
                if (behaviorRuleManager3 == null || !behaviorRuleManager3.isControl(flowId)) {
                    BehaviorRuleManager behaviorRuleManager4 = this.mBehaviorRule;
                    if (behaviorRuleManager4 == null || behaviorRuleManager4.isNeedCache(flowId)) {
                        FunnelHelper.collectLogFunnel(BypassConstants.Funnel.SAMPLE_FLOW, flow.getId(), System.currentTimeMillis());
                        return flow;
                    }
                    flow.setValid(false);
                    return flow;
                }
                flow.setValid(false);
                return flow;
            }
            flow.setValid(false);
            return flow;
        } else {
            flow.setValid(false);
            return flow;
        }
    }

    public void updateFlowValue(String flowId, int flowHandle, String value, long endTime) {
        executeHighPriorityTask(new FlowUpdateContentRunnable(flowId, flowHandle, value, endTime));
    }

    public void updateFlowValue(String flowId, int flowHandle, String value) {
        executeHighPriorityTask(new FlowUpdateContentRunnable(flowId, flowHandle, value, 0));
    }

    public void endFlow(String flowId, int flowHandle, String uuid, JSONArray jsonArray, long endTime) {
        endFlow(flowId, flowHandle, uuid, 0, jsonArray, endTime);
    }

    public void endFlow(String flowId, int flowHandle, String uuid, int option, JSONArray jsonArray, long endTime) {
        executeHighPriorityTask(new FlowEndRunnable(flowId, flowHandle, uuid, option, jsonArray, endTime));
    }

    public void cancelFlow(String flowId, int flowHandle) {
        executeHighPriorityTask(new FlowCancelRunnable(flowId, flowHandle));
    }

    /* access modifiers changed from: package-private */
    public String getUploadType(String eventId) {
        int uploadType;
        BehaviorModel behaviorModel = this.mBehaviorModel;
        if (behaviorModel == null || (uploadType = behaviorModel.getUploadType(eventId)) == -1) {
            return "";
        }
        return String.valueOf(uploadType);
    }

    /* access modifiers changed from: package-private */
    public void uploadLocalData() {
        executeMiddlePriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    BehaviorProcessor.this.mBehaviorModel.uploadLocalDatas(false);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void upload() {
        if (!this.mUploaded) {
            this.mUploaded = true;
            executeMiddlePriorityTask(new Runnable() {
                public void run() {
                    if (BehaviorProcessor.this.mBehaviorModel != null) {
                        if (Math.abs(System.currentTimeMillis() - UbcSpUtil.getInstance().getLong("ubc_last_upload_all_time", 0)) >= 3600000) {
                            BehaviorProcessor.this.mBehaviorModel.uploadLocalDatas(true);
                            long lastUploadDataTime = System.currentTimeMillis();
                            UbcSpUtil.getInstance().putLong("ubc_last_upload_all_time", lastUploadDataTime);
                            UbcSpUtil.getInstance().putLong("ubc_last_upload_non_real", lastUploadDataTime);
                        }
                    } else if (BehaviorProcessor.DEBUG) {
                        Log.d(BehaviorProcessor.TAG, "upload#ubc init not finish");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void uploadBackLog(final EnumConstants.Trigger trigger) {
        if (AppProcessManager.isServerProcess()) {
            Runnable uploadBackLogRunnable = new Runnable() {
                public void run() {
                    if (BehaviorProcessor.this.mBehaviorModel != null) {
                        BehaviorProcessor.this.mBehaviorModel.uploadBackLog(trigger);
                    }
                }
            };
            if (EnumConstants.Trigger.LOG_TOO_MANY.equals(trigger)) {
                executeHighPriorityTask(uploadBackLogRunnable);
            } else {
                executeMiddlePriorityTask(uploadBackLogRunnable);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateConfig(OriginalConfigData configData, boolean isAscVersion, IUBCStatisticCallback statisticCallback) {
        executeMiddlePriorityTask(new ConfigUpdateRunnable(configData, isAscVersion, statisticCallback));
    }

    /* access modifiers changed from: package-private */
    public void flush() {
        executeHighPriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    BehaviorProcessor.this.mBehaviorModel.flush();
                } else if (BehaviorProcessor.DEBUG) {
                    Log.d(BehaviorProcessor.TAG, "saveCache#ubc init not finish");
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void uploadData(JSONObject uploadData) {
        uploadData(uploadData, (String) null, System.currentTimeMillis(), 1);
    }

    /* access modifiers changed from: package-private */
    public void uploadData(JSONObject uploadData, String fileName, long packageTime, int uploadIndex) {
        uploadData(uploadData, fileName, (EventData) null, packageTime, uploadIndex, (IUBCUploadCallback) null);
    }

    /* access modifiers changed from: package-private */
    public void uploadData(JSONObject uploadData, EventData data, long packageTime, int uploadIndex, IUBCUploadCallback callback) {
        uploadData(uploadData, (String) null, data, packageTime, uploadIndex, callback);
    }

    private void uploadData(JSONObject uploadData, String fileName, EventData data, long packageTime, int uploadIndex, IUBCUploadCallback callback) {
        if (DEBUG) {
            Log.d(TAG, "uploadData:" + fileName);
            Log.d("UBCDEBUG", uploadData.toString());
        }
        boolean isOptionUploadBeforeAgreePrivacy = (data == null || (data.getOption() & 128) == 0) ? false : true;
        if (!UBCHelper.shouldInterceptUpload(isOptionUploadBeforeAgreePrivacy)) {
            final BehaviorModel.UploadMetaData metaData = new BehaviorModel.UploadMetaData();
            metaData.dataInFile = false;
            metaData.uploadJson = uploadData;
            metaData.backupFileName = fileName;
            metaData.useNoPrivacyParam = isOptionUploadBeforeAgreePrivacy;
            metaData.uploadEvent = data;
            metaData.callback = callback;
            metaData.packageTime = packageTime;
            metaData.uploadTime = System.currentTimeMillis();
            metaData.uploadIndex = uploadIndex;
            this.mUploadService.execute(new Runnable() {
                public void run() {
                    if (BehaviorProcessor.this.mBehaviorModel != null) {
                        BehaviorProcessor.this.waitATokenOrTimeout(metaData.uploadIndex > 1, metaData.packageTime, metaData.uploadTime);
                        BehaviorProcessor.this.mBehaviorModel.uploadData(metaData);
                    } else if (BehaviorProcessor.DEBUG) {
                        Log.d(BehaviorProcessor.TAG, "uploadData#ubc init not finish");
                    }
                }
            });
        } else if (callback != null) {
            callback.uploadCompletion(false, data);
        }
    }

    /* access modifiers changed from: package-private */
    public void uploadData(final UploadData uploadData, String fileName) {
        if (UBCHelper.shouldInterceptUpload(uploadData.isUploadBeforeAgreePrivacy())) {
            BehaviorModel behaviorModel = this.mBehaviorModel;
            if (behaviorModel != null) {
                behaviorModel.uploadFileFail(fileName);
                return;
            }
            return;
        }
        final BehaviorModel.UploadMetaData metaData = new BehaviorModel.UploadMetaData();
        metaData.dataInFile = uploadData.isDataInFile();
        if (metaData.dataInFile) {
            metaData.uploadFile = uploadData.getDataFile();
            metaData.uploadContentLen = uploadData.getContentLen();
        } else {
            metaData.uploadJson = uploadData.getUploadData();
        }
        metaData.useNoPrivacyParam = uploadData.isUploadBeforeAgreePrivacy();
        metaData.backupFileName = fileName;
        metaData.packageTime = uploadData.getPackageTime();
        metaData.uploadTime = uploadData.getUploadTime();
        metaData.uploadIndex = uploadData.getUploadIndex();
        UBCUploadTimingManager.getInstance().onStartUpload();
        this.mUploadService.execute(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    BehaviorProcessor behaviorProcessor = BehaviorProcessor.this;
                    boolean z = true;
                    if (metaData.uploadIndex <= 1) {
                        z = false;
                    }
                    behaviorProcessor.waitATokenOrTimeout(z, metaData.packageTime, metaData.uploadTime);
                    if (BehaviorProcessor.DEBUG) {
                        Log.d(BehaviorProcessor.TAG, "uploadData isDataInFile:" + uploadData.isDataInFile());
                        if (uploadData.isDataInFile()) {
                            uploadData.printDebugInfo("UBCDEBUG");
                        } else {
                            Log.d("UBCDEBUG", metaData.uploadJson.toString());
                        }
                    }
                    BehaviorProcessor.this.mBehaviorModel.uploadData(metaData);
                } else if (BehaviorProcessor.DEBUG) {
                    Log.d(BehaviorProcessor.TAG, "uploadData#ubc init not finish");
                }
            }
        });
    }

    public void waitATokenOrTimeout(boolean isRetry, long packageTime, long uploadTime) {
        BehaviorRuleManager behaviorRuleManager = this.mBehaviorRule;
        if (behaviorRuleManager != null && behaviorRuleManager.getUploadLimiter() != null) {
            FunnelHelper.collectUploadFunnel(BypassConstants.Funnel.UPLOAD_TOKEN_GET_START, isRetry, packageTime, uploadTime);
            YalogHelper.saveRuntimeLogWithMsg("acquireToken_interval:" + (SystemClock.elapsedRealtime() - this.lastRequireTokenTime), EnumConstants.RunTime.ACQUIRE_UPLOAD_TOKEN);
            int waitTime = this.mBehaviorRule.getUploadLimiter().tryAcquire(((long) this.mBehaviorRule.getUploadLimiterTokenIntervalMillis()) * 2, TimeUnit.MILLISECONDS);
            this.lastRequireTokenTime = SystemClock.elapsedRealtime();
            FunnelHelper.collectUploadFunnel(BypassConstants.Funnel.UPLOAD_TOKEN_GET_SUCCESS, isRetry, packageTime, uploadTime);
            YalogHelper.saveRuntimeLogWithMsg("acquireToken_waitOrTimeout:" + waitTime, EnumConstants.RunTime.ACQUIRE_UPLOAD_TOKEN_OVER);
            if (waitTime > 0) {
                FunnelHelper.collectUploadFunnel(BypassConstants.Funnel.UPLOAD_TOKEN_WAIT, isRetry, packageTime, uploadTime);
            } else if (waitTime < 0) {
                FunnelHelper.collectUploadFunnel(BypassConstants.Funnel.UPLOAD_TOKEN_NONE, isRetry, packageTime, uploadTime);
            }
            if (DEBUG) {
                Log.d(TAG, "uploadData waitATokenOrTimeout() token get time = " + waitTime);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void processOneFailedData() {
        executeMiddlePriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    BehaviorProcessor.this.mBehaviorModel.processOneFailedData();
                } else if (BehaviorProcessor.DEBUG) {
                    Log.d(BehaviorProcessor.TAG, "processOneFailedData#ubc init not finish");
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void processFailedData() {
        if (AppProcessManager.isServerProcess()) {
            executeMiddlePriorityTask(new Runnable() {
                public void run() {
                    if (BehaviorProcessor.this.mBehaviorModel != null) {
                        BehaviorProcessor.this.mBehaviorModel.processFailedData();
                    } else if (BehaviorProcessor.DEBUG) {
                        Log.d(BehaviorProcessor.TAG, "uploadFailedData#ubc init not finish");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void sendQualityData() {
        executeMiddlePriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    BehaviorProcessor.this.mBehaviorModel.sendQualityData();
                } else if (BehaviorProcessor.DEBUG) {
                    Log.d(BehaviorProcessor.TAG, "sendQualityData#ubc init not finish");
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void sendArrivalData() {
        if (AppProcessManager.isServerProcess()) {
            executeMiddlePriorityTask(new Runnable() {
                public void run() {
                    if (BehaviorProcessor.this.mBehaviorModel == null) {
                        if (BehaviorProcessor.DEBUG) {
                            Log.d(BehaviorProcessor.TAG, "sendArrivalData#ubc init not finish");
                        }
                    } else if (BehaviorProcessor.this.mBehaviorModel.checkArrivalDataUpload()) {
                        BehaviorProcessor.this.mBehaviorModel.sendArrivalData();
                    } else if (BehaviorProcessor.DEBUG) {
                        Log.d(BehaviorProcessor.TAG, "sendArrivalData too often");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void sendApiCollectorData() {
        if (AppProcessManager.isServerProcess()) {
            if (DEBUG) {
                Log.d(TAG, "send api collector data");
            }
            UBCApiCollector.getInstance().sendApiCollectorData();
        }
    }

    /* access modifiers changed from: package-private */
    public void uploadFileFinish(final String fileName, final boolean successful) {
        executeMiddlePriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    if (successful) {
                        BehaviorProcessor.this.mBehaviorModel.uploadFileSuccess(fileName);
                    } else {
                        BehaviorProcessor.this.mBehaviorModel.uploadFileFail(fileName);
                    }
                    UBCUploadTimingManager.getInstance().onUploadFinish(successful);
                } else if (BehaviorProcessor.DEBUG) {
                    Log.d(BehaviorProcessor.TAG, "uploadFailedData#ubc init not finish");
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void scheduleTimer(Runnable runnable, long delay) {
        ExecutorService executorService = this.mExecutorService;
        if (!(executorService instanceof ScheduledThreadPoolExecutor)) {
            return;
        }
        if (this.mHighPrioritySaveType == 1) {
            ((ScheduledThreadPoolExecutor) executorService).schedule(new CatchExceptionRunnable(runnable), delay, TimeUnit.MILLISECONDS);
        } else {
            ((ScheduledThreadPoolExecutor) executorService).schedule(runnable, delay, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: package-private */
    public void registerBizParamData(final BizParamData bizParamData) {
        executeMiddlePriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorRule != null) {
                    BehaviorProcessor.this.mBehaviorRule.registerParamData(bizParamData);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void uploadFlowBeforeAgreePrivacy(final String flowId) {
        executeMiddlePriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    BehaviorProcessor.this.mBehaviorModel.uploadFlowBeforeAgreePrivacy(flowId);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void checkUploadNonRealTimedData(final boolean isRealTime) {
        executeMiddlePriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    BehaviorProcessor.this.mBehaviorModel.checkUploadNonRealTime(isRealTime);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void uploadWhenSaveDBError(final boolean isRealTimeEvent, final EventData... eventDataArray) {
        executeMiddlePriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    BehaviorProcessor.this.mBehaviorModel.uploadWhenSaveDBError(isRealTimeEvent, eventDataArray);
                }
            }
        });
    }

    public void checkUploadFromEvent(final EventData data, final boolean isRealEvent) {
        executeMiddlePriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    BehaviorProcessor.this.mBehaviorModel.checkUploadFromEvent(data, isRealEvent);
                }
            }
        });
    }

    public void checkUploadFromFlow(String id, final boolean isRealFlow) {
        executeMiddlePriorityTask(new Runnable() {
            public void run() {
                if (BehaviorProcessor.this.mBehaviorModel != null) {
                    BehaviorProcessor.this.mBehaviorModel.checkUploadFromFlow(isRealFlow);
                }
            }
        });
    }

    private class InitRunnable implements Runnable {
        private InitRunnable() {
        }

        /* Debug info: failed to restart local var, previous not found, register: 5 */
        public void run() {
            FunnelHelper.collectInitFunnel(BypassConstants.Funnel.INIT_INNER_START);
            YalogHelper.saveRuntimeLogWithMsg("init inner start", EnumConstants.RunTime.INIT_MESSAGE);
            YalogHelper.saveRuntimeLogWithMsg("init inner start", EnumConstants.RunTime.INIT_MESSAGE);
            Process.setThreadPriority(10);
            try {
                BehaviorRuleManager unused = BehaviorProcessor.this.mBehaviorRule = BehaviorRuleManager.getInstance();
                BehaviorProcessor.this.mBehaviorRule.setHighPrioritySave(BehaviorProcessor.this.mHighPrioritySaveType == 2);
                BehaviorModel unused2 = BehaviorProcessor.this.mBehaviorModel = new BehaviorModel(BehaviorProcessor.this.mContext);
                BehaviorProcessor.this.mBehaviorModel.setSentFileState();
                if (BehaviorProcessor.this.mBehaviorModel == null || BehaviorProcessor.this.mBehaviorRule == null) {
                    FunnelHelper.collectInitFunnel(BypassConstants.Funnel.INIT_FAIL);
                    YalogHelper.saveRuntimeLogWithMsg("init fail", EnumConstants.RunTime.INIT_MESSAGE);
                    return;
                }
                FunnelHelper.collectInitFunnel(BypassConstants.Funnel.INIT_SUCCESS);
                YalogHelper.saveRuntimeLogWithMsg("init success", EnumConstants.RunTime.INIT_MESSAGE);
            } catch (Throwable t) {
                if (BehaviorProcessor.this.mBehaviorModel == null || BehaviorProcessor.this.mBehaviorRule == null) {
                    FunnelHelper.collectInitFunnel(BypassConstants.Funnel.INIT_FAIL);
                    YalogHelper.saveRuntimeLogWithMsg("init fail", EnumConstants.RunTime.INIT_MESSAGE);
                } else {
                    FunnelHelper.collectInitFunnel(BypassConstants.Funnel.INIT_SUCCESS);
                    YalogHelper.saveRuntimeLogWithMsg("init success", EnumConstants.RunTime.INIT_MESSAGE);
                }
                throw t;
            }
        }
    }

    private class EventRunnable implements Runnable {
        private EventData mData;
        /* access modifiers changed from: private */
        public String mLogId;

        EventRunnable(String id, String value, int option) {
            this.mData = new EventData(id, value, option);
            this.mLogId = id;
        }

        EventRunnable(String id, String value, int option, String bizInfo) {
            EventData eventData = new EventData(id, value, option);
            this.mData = eventData;
            this.mLogId = id;
            eventData.setBizInfo(bizInfo);
        }

        EventRunnable(String id, JSONObject value, int option) {
            this.mData = new EventData(id, value, option);
            this.mLogId = id;
        }

        EventRunnable(String id, JSONObject value, int option, String bizInfo) {
            EventData eventData = new EventData(id, value, option);
            this.mData = eventData;
            this.mLogId = id;
            eventData.setBizInfo(bizInfo);
        }

        EventRunnable(String flowId, String id, int flowHandle, String value, int option) {
            this.mData = new EventData(flowId, id, flowHandle, value, option);
            this.mLogId = flowId;
        }

        EventRunnable(BehaviorProcessor behaviorProcessor, String flowId, String id, int flowHandle, String value, long eventDate, int option) {
            BehaviorProcessor.this = behaviorProcessor;
            this.mData = new EventData(flowId, id, flowHandle, value, eventDate, option);
            this.mLogId = flowId;
        }

        EventRunnable(String flowId, String id, int flowHandle, JSONObject value, int option) {
            this.mData = new EventData(flowId, id, flowHandle, value, option);
            this.mLogId = flowId;
        }

        public void setControl(boolean control) {
            EventData eventData = this.mData;
            if (eventData != null) {
                eventData.setControl(control);
            }
        }

        public void setSaveFileName(String name) {
            EventData eventData = this.mData;
            if (eventData != null) {
                eventData.setFileName(name);
            }
        }

        public void run() {
            if (BehaviorProcessor.this.mBehaviorModel == null) {
                FunnelHelper.collectLogFunnel(BypassConstants.Funnel.INNER_EVENT_ERROR, this.mData.getId(), this.mData.getTime());
                YalogHelper.saveRuntimeLogWithEvent(this.mData.getLogIdentifier(), EnumConstants.RunTime.EVENT_ERROR_INIT_UNFINISH);
                if (BehaviorProcessor.DEBUG) {
                    Log.d(BehaviorProcessor.TAG, "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (this.mData.getFlowHandle() == -1) {
                FunnelHelper.collectLogFunnel(BypassConstants.Funnel.INNER_EVENT, this.mData.getId(), this.mData.getTime());
            }
            if (!BehaviorProcessor.this.mUBCLogInit) {
                if (BehaviorProcessor.this.mLogManager == null) {
                    IUbcLogStore unused = BehaviorProcessor.this.mLogManager = (IUbcLogStore) ServiceManager.getService(IUbcLogStore.SERVICE_REFERENCE);
                }
                boolean unused2 = BehaviorProcessor.this.mUBCLogInit = true;
            }
            if (BehaviorProcessor.this.mBehaviorRule != null && BehaviorProcessor.this.mBehaviorRule.checkLocalCache(this.mLogId) == 1) {
                YalogHelper.saveUbcToYalog(this.mData);
            }
            EventData eventData = this.mData;
            if (eventData != null) {
                if (eventData.getFlowHandle() == -1) {
                    if (needRecordEvent(this.mData.getId(), this.mData.getOption())) {
                        FunnelHelper.collectLogFunnel(BypassConstants.Funnel.SAMPLE_EVENT, this.mData.getId(), this.mData.getTime());
                        if (BehaviorProcessor.this.mBehaviorRule != null && BehaviorProcessor.this.mBehaviorRule.isLastLimit(this.mData.getId())) {
                            setControl(true);
                            YalogHelper.saveRuntimeLogWithEvent(this.mData.getLogIdentifier(), EnumConstants.RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
                        }
                        this.mData.setUUID(UBCUtil.getLogUUID());
                        if (BehaviorProcessor.this.mBehaviorRule != null) {
                            this.mData.setAppVersion(BehaviorProcessor.this.mBehaviorRule.getCurrentAppVersion());
                            this.mData.setUbcSessionId(BehaviorProcessor.this.mBehaviorRule.getCurrentSessionId());
                        }
                    } else {
                        return;
                    }
                }
                this.mData.setExpInfo();
                String id = this.mData.getId();
                if (!TextUtils.isEmpty(id)) {
                    if (BehaviorProcessor.this.mBehaviorRule != null) {
                        String category = BehaviorProcessor.this.mBehaviorRule.getCategory(id);
                        if (!TextUtils.isEmpty(category)) {
                            this.mData.setCategory(category);
                        }
                        this.mData.setBizParam(BehaviorProcessor.this.mBehaviorRule.getBizParamValue(id));
                    }
                    if (UBCArrivalStatics.getInstance().canRecordArrivalDataAndLogId() && this.mData.getFlowHandle() == -1) {
                        UBCArrivalStatics.getInstance().addUBCRecord(this.mData.getId(), true);
                        this.mData.setLogId(LogIdUtils.getInstance().getLogId(this.mData.getId(), this.mData.getUUID(), true));
                    }
                    YalogHelper.saveRuntimeLogWithEvent(this.mData.getLogIdentifier(), EnumConstants.RunTime.ON_EVENT);
                    if (BehaviorProcessor.this.mBehaviorRule != null && BehaviorProcessor.this.mBehaviorRule.checkLocalCache(this.mLogId) == 2) {
                        YalogHelper.saveUbcToYalog(this.mData);
                    }
                    if (this.mData.getFlowHandle() == -1 && TextUtils.equals(id, UBCQualityStatics.UBC_QUALITY_ID)) {
                        BehaviorProcessor.this.mBehaviorModel.saveQualityEvent(this.mData);
                    } else if ((this.mData.getOption() & 8) != 0) {
                        BehaviorProcessor.this.mBehaviorModel.saveEventFile(this.mData);
                    } else if ((this.mData.getOption() & 128) != 0) {
                        BehaviorProcessor.this.mBehaviorModel.saveEvent(this.mData);
                    } else {
                        BehaviorProcessor.this.mBehaviorModel.saveEvent(this.mData);
                    }
                }
            }
        }

        private boolean needRecordEvent(String eventId, int option) {
            if ((option & 16) != 0 && !UBCHelper.getUBCContext().isSampled(eventId)) {
                return false;
            }
            if (BehaviorProcessor.this.mBehaviorRule != null && !BehaviorProcessor.this.mBehaviorRule.checkRecord(eventId, option)) {
                return false;
            }
            if (BehaviorProcessor.this.mBehaviorRule != null && BehaviorProcessor.this.mBehaviorRule.isControl(eventId)) {
                return false;
            }
            if (BehaviorProcessor.this.mBehaviorRule != null && BehaviorProcessor.this.mBehaviorRule.checkSample(eventId)) {
                return false;
            }
            if (BehaviorProcessor.this.mBehaviorRule == null || !BehaviorProcessor.this.mBehaviorRule.checkPassiveId(eventId)) {
                return true;
            }
            return false;
        }
    }

    private class FlowCreateRunnable implements Runnable {
        private FlowData mData;

        FlowCreateRunnable(Flow flow, String value) {
            FlowData flowData = new FlowData(flow.getId(), flow.getHandle(), value, flow.getOption());
            this.mData = flowData;
            flowData.setBeginTime(flow.getStartTime());
            this.mData.setState("1");
            this.mData.setUUID(flow.getUUID());
        }

        FlowCreateRunnable(Flow flow, String value, String bizInfo) {
            FlowData flowData = new FlowData(flow.getId(), flow.getHandle(), value, flow.getOption());
            this.mData = flowData;
            flowData.setBeginTime(flow.getStartTime());
            this.mData.setState("1");
            this.mData.setBizInfo(bizInfo);
            this.mData.setUUID(flow.getUUID());
        }

        FlowCreateRunnable(Flow flow, JSONObject value) {
            FlowData flowData = new FlowData(flow.getId(), flow.getHandle(), value, flow.getOption());
            this.mData = flowData;
            flowData.setBeginTime(flow.getStartTime());
            this.mData.setState("1");
            this.mData.setUUID(flow.getUUID());
        }

        FlowCreateRunnable(Flow flow, JSONObject value, String bizInfo) {
            FlowData flowData = new FlowData(flow.getId(), flow.getHandle(), value, flow.getOption());
            this.mData = flowData;
            flowData.setBeginTime(flow.getStartTime());
            this.mData.setState("1");
            this.mData.setBizInfo(bizInfo);
            this.mData.setUUID(flow.getUUID());
        }

        public void setControl(boolean control) {
            FlowData flowData = this.mData;
            if (flowData != null) {
                flowData.setControl(control);
            }
        }

        public void run() {
            if (BehaviorProcessor.this.mBehaviorModel != null) {
                YalogHelper.saveRuntimeLogWithFlow(this.mData.getId(), this.mData.getFlowHandle(), this.mData.getUUID(), EnumConstants.RunTime.ON_FLOW_START);
                FunnelHelper.collectLogFunnel(BypassConstants.Funnel.INNER_BEGIN_FLOW, this.mData.getId(), System.currentTimeMillis());
                this.mData.setExpInfo();
                if (BehaviorProcessor.this.mBehaviorRule != null) {
                    this.mData.setAppVersion(BehaviorProcessor.this.mBehaviorRule.getCurrentAppVersion());
                    this.mData.setUbcSessionId(BehaviorProcessor.this.mBehaviorRule.getCurrentSessionId());
                    this.mData.setBizParam(BehaviorProcessor.this.mBehaviorRule.getBizParamValue(this.mData.getId()));
                    if (!TextUtils.isEmpty(BehaviorProcessor.this.mBehaviorRule.getCategory(this.mData.getId()))) {
                        this.mData.setCategory(BehaviorProcessor.this.mBehaviorRule.getCategory(this.mData.getId()));
                    }
                }
                BehaviorProcessor.this.mBehaviorModel.startFlow(this.mData);
                UBCHelper.saveFlowHandleToConfig(BehaviorProcessor.this.mGlobalFlowHandle.get());
            } else if (BehaviorProcessor.DEBUG) {
                Log.d(BehaviorProcessor.TAG, "FlowCreateRunnable#ubc init not finish");
            }
        }
    }

    private class FlowUpdateContentRunnable implements Runnable {
        private long mEndTime;
        private int mFlowHandle;
        private String mFlowId;
        private String mValue;

        FlowUpdateContentRunnable(String flowId, int flowHandle, String value, long endTime) {
            this.mFlowId = flowId;
            this.mFlowHandle = flowHandle;
            this.mValue = value;
            this.mEndTime = endTime;
        }

        public void run() {
            if (BehaviorProcessor.this.mBehaviorModel != null) {
                BehaviorProcessor.this.mBehaviorModel.updateFlowValue(this.mFlowId, this.mFlowHandle, this.mValue, this.mEndTime);
            } else if (BehaviorProcessor.DEBUG) {
                Log.d(BehaviorProcessor.TAG, "FlowUpdateRunnable#ubc init not finish");
            }
        }
    }

    private class FlowEndRunnable implements Runnable {
        private long mEndTime;
        private int mFlowHandle;
        private String mFlowId;
        private int mOption;
        private JSONArray mSlotArray;
        private String mUUID;

        FlowEndRunnable(String flowId, int flowHandle, String uuid, int option, JSONArray slotArray, long endTime) {
            this.mFlowId = flowId;
            this.mFlowHandle = flowHandle;
            this.mUUID = uuid;
            this.mOption = option;
            this.mEndTime = endTime == 0 ? System.currentTimeMillis() : endTime;
            this.mSlotArray = slotArray;
        }

        public void run() {
            if (BehaviorProcessor.this.mBehaviorModel == null) {
                FunnelHelper.collectLogFunnel(BypassConstants.Funnel.INNER_FLOW_ERROR, this.mFlowId, this.mEndTime);
                YalogHelper.saveRuntimeLogWithFlow(this.mFlowId, this.mFlowHandle, this.mUUID, EnumConstants.RunTime.FLOW_ERROR_INIT_UNFINISH);
                if (BehaviorProcessor.DEBUG) {
                    Log.d(BehaviorProcessor.TAG, "FlowEndRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            FunnelHelper.collectLogFunnel(BypassConstants.Funnel.INNER_FLOW, this.mFlowId, this.mEndTime);
            YalogHelper.saveRuntimeLogWithFlow(this.mFlowId, this.mFlowHandle, this.mUUID, EnumConstants.RunTime.ON_FLOW_END);
            String logId = null;
            if (UBCArrivalStatics.getInstance().canRecordArrivalDataAndLogId()) {
                UBCArrivalStatics.getInstance().addUBCRecord(this.mFlowId, true);
                logId = LogIdUtils.getInstance().getLogId(this.mFlowId, String.valueOf(this.mFlowHandle), false);
            }
            BehaviorProcessor.this.mBehaviorModel.endFlow(this.mFlowId, this.mFlowHandle, this.mUUID, this.mOption, this.mEndTime, this.mSlotArray, logId);
        }
    }

    private class FlowCancelRunnable implements Runnable {
        private int mFlowHandle;
        private String mFlowId;

        FlowCancelRunnable(String flowId, int flowHandle) {
            this.mFlowId = flowId;
            this.mFlowHandle = flowHandle;
        }

        public void run() {
            if (BehaviorProcessor.this.mBehaviorModel != null) {
                FunnelHelper.collectLogFunnel(BypassConstants.Funnel.INNER_CANCEL_FLOW, this.mFlowId, System.currentTimeMillis());
                BehaviorProcessor.this.mBehaviorModel.cancelFlow(this.mFlowId, this.mFlowHandle);
            } else if (BehaviorProcessor.DEBUG) {
                Log.d(BehaviorProcessor.TAG, "FlowCancelRunnable#ubc init not finish");
            }
        }
    }

    private class ConfigUpdateRunnable implements Runnable {
        private OriginalConfigData mConfigData;
        private boolean mIsAscVersion;
        private IUBCStatisticCallback mStatisticCallback;

        ConfigUpdateRunnable(OriginalConfigData configData, boolean isAscVersion, IUBCStatisticCallback callback) {
            this.mConfigData = configData;
            this.mIsAscVersion = isAscVersion;
            this.mStatisticCallback = callback;
        }

        public void run() {
            if (BehaviorProcessor.this.mBehaviorModel != null) {
                BehaviorProcessor.this.mBehaviorModel.updateConfig(this.mConfigData, this.mIsAscVersion, this.mStatisticCallback);
            } else if (BehaviorProcessor.DEBUG) {
                Log.d(BehaviorProcessor.TAG, "ConfigUpdateRunnable#ubc init not finish");
            }
        }
    }

    private class CatchExceptionRunnable implements Runnable {
        private final Runnable task;

        public CatchExceptionRunnable(Runnable task2) {
            this.task = task2;
        }

        public void run() {
            Runnable runnable = this.task;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable e2) {
                    e2.printStackTrace();
                    BehaviorProcessor.this.m8150lambda$executeHighPriorityTask$0$combaiduubcBehaviorProcessor(this, e2);
                }
            }
        }
    }

    public static void multiProcessSaveEvent(String eventId, String value, String fileName, int option) {
        EventData data = new EventData(eventId, value, option);
        data.setFileName(fileName);
        new BehaviorFileAdapter(UBCHelper.getAppContext()).saveEvent(data, BehaviorRuleManager.getInstance().checkRealTimeUpload(data.getId()));
    }

    /* access modifiers changed from: private */
    /* renamed from: onUBCCatchException */
    public void m8150lambda$executeHighPriorityTask$0$combaiduubcBehaviorProcessor(Runnable runnable, Throwable ex) {
        int i2;
        BypassConstants.Funnel funnel;
        if (runnable != null && ex != null && (i2 = this.mHighPrioritySaveType) != 0) {
            boolean isHighPrioritySave = i2 == 2;
            if (isHighPrioritySave) {
                try {
                    funnel = BypassConstants.Funnel.CATCH_EXCEPTION;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            } else {
                funnel = BypassConstants.Funnel.CATCH_EXCEPTION_OLD;
            }
            FunnelHelper.collectExFunnel(funnel);
            if (!(runnable instanceof EventRunnable) || !TextUtils.equals(((EventRunnable) runnable).mLogId, UBCQualityStatics.UBC_QUALITY_ID)) {
                try {
                    UBCQualityStatics.getInstance().onLogUBCExceptionInfo(ex.getClass().getName(), Log.getStackTraceString(ex), isHighPrioritySave);
                } catch (Exception e3) {
                    FunnelHelper.collectUBCExceptionInfo(ex.getClass().getName(), Log.getStackTraceString(ex), isHighPrioritySave);
                }
            } else if (DEBUG) {
                Log.d(TAG, "onUBCCatchException: 1876点位UBC线程抛出异常，记录数据漏斗，不上报");
            }
        }
    }
}
