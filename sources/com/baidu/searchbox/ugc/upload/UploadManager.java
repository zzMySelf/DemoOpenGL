package com.baidu.searchbox.ugc.upload;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.publisher.controller.IPublisherManagerInterface;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.ugc.upload.HttpRequestTokenModule;
import com.baidu.searchbox.ugc.upload.UploadFileTask;
import com.baidu.searchbox.ugc.upload.producer.CompressProducer;
import com.baidu.searchbox.ugc.upload.producer.CompressProducerExt;
import com.baidu.searchbox.ugc.upload.producer.UploadProducer;
import com.baidu.searchbox.ugc.upload.producer.UploadProducerExt;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.http.DefaultRetryPolicy;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadManager {
    private static final int CANCEL_TIMEOUT = 50;
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final int RETRY_DELAY = 3000;
    private static final int RETRY_MAX = 2;
    private static final String TAG = UploadManager.class.getSimpleName();
    private static volatile UploadManager instance;
    /* access modifiers changed from: private */
    public static String mBosEndpoint = "https://bj.bcebos.com";
    /* access modifiers changed from: private */
    public UploadCallback mCallback;
    /* access modifiers changed from: private */
    public ProcessTasksCallable mCurrCallable;
    /* access modifiers changed from: private */
    public String mFrom = "";
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public IPublisherManagerInterface mPublisherManagerInterface = ((IPublisherManagerInterface) ServiceManager.getService(IPublisherManagerInterface.SERVICE_REFERENCE));
    /* access modifiers changed from: private */
    public int mSourceType = 0;
    /* access modifiers changed from: private */
    public UploadFileTask.TaskCallback mTaskCallback = new UploadFileTask.TaskCallback() {
        private long currentProgress = -1;

        public void onProgress(UploadFileTask task, long progressValue, long progressMax) {
            if (progressValue > this.currentProgress) {
                this.currentProgress = progressValue;
                final UploadFileTask uploadFileTask = task;
                final long j2 = progressValue;
                final long j3 = progressMax;
                UploadManager.this.mHandler.post(new Runnable() {
                    public void run() {
                        if (UploadManager.this.mCallback != null) {
                            UploadManager.this.mCallback.onProgress(uploadFileTask, j2, j3);
                        }
                    }
                });
            }
        }

        public void onStart(final UploadFileTask task) {
            if (UploadManager.DEBUG) {
                Log.e("PublishManager", "上传开始1：" + Thread.currentThread().getName());
            }
            this.currentProgress = -1;
            UploadManager.this.mHandler.post(new Runnable() {
                public void run() {
                    if (UploadManager.this.mCallback != null) {
                        UploadManager.this.mCallback.onStart(task);
                    }
                }
            });
        }

        public void onSuccess(final UploadFileTask task) {
            if (UploadManager.DEBUG) {
                Log.e("PublishManager", "上传成功1：" + Thread.currentThread().getName() + ": mCallback: " + UploadManager.this.mCallback);
            }
            this.currentProgress = -1;
            UploadManager.this.mHandler.post(new Runnable() {
                public void run() {
                    if (UploadManager.this.mCallback != null) {
                        UploadManager.this.mCallback.onSuccess(task);
                    }
                }
            });
        }

        public void onFailed(final UploadFileTask task) {
            if (UploadManager.DEBUG) {
                Log.e("PublishManager", "上传失败1：" + Thread.currentThread().getName());
            }
            this.currentProgress = -1;
            UploadManager.this.mHandler.post(new Runnable() {
                public void run() {
                    if (UploadManager.this.mCallback != null) {
                        UploadManager.this.mCallback.onFailed(task);
                    }
                }
            });
        }

        public void onStop(UploadFileTask task) {
            if (UploadManager.DEBUG) {
                Log.e("PublishManager", "上传取消1：" + Thread.currentThread().getName());
            }
            this.currentProgress = -1;
            if (UploadManager.this.mCallback != null) {
                UploadManager.this.mCallback.onStop(task);
            }
        }
    };
    private ThreadPoolExecutor sThreadPool;

    public interface UploadCallback extends UploadFileTask.TaskCallback {
        void onError(String str);
    }

    public static UploadManager getInstance() {
        if (instance == null) {
            synchronized (UploadManager.class) {
                if (instance == null) {
                    instance = new UploadManager();
                }
            }
        }
        return instance;
    }

    private UploadManager() {
    }

    public void startAll(List<UploadFileTask> tasks, int sourceType, String from) {
        startAll(tasks, sourceType, from, (String) null);
    }

    public void startAll(List<UploadFileTask> tasks, int sourceType, String from, String bosEndpoint) {
        if (DEBUG) {
            Log.e("PublishManager", "startAll - " + Thread.currentThread().getName());
        }
        if (tasks != null && tasks.size() != 0) {
            if (!TextUtils.isEmpty(bosEndpoint)) {
                mBosEndpoint = bosEndpoint;
            }
            this.mSourceType = sourceType;
            this.mFrom = from;
            List<UploadFileTask> newTasks = new ArrayList<>(tasks);
            if (this.sThreadPool == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                    private final AtomicInteger mCount = new AtomicInteger(1);

                    public Thread newThread(Runnable r) {
                        return new Thread(r, "UploadManager #" + this.mCount.getAndIncrement());
                    }
                });
                this.sThreadPool = threadPoolExecutor;
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            stopAll();
            startProcessTasks(newTasks);
        }
    }

    private void startProcessTasks(List<UploadFileTask> tasks) {
        if (tasks != null && tasks.size() != 0) {
            ProcessTasksCallable processTasksCallable = new ProcessTasksCallable(tasks);
            this.mCurrCallable = processTasksCallable;
            ThreadPoolExecutor threadPoolExecutor = this.sThreadPool;
            if (threadPoolExecutor != null) {
                processTasksCallable.setFuture(threadPoolExecutor.submit(processTasksCallable));
            }
        }
    }

    public void stopAll() {
        if (DEBUG) {
            Log.e("PublishManager", "stopAll - " + Thread.currentThread().getName());
        }
        ProcessTasksCallable processTasksCallable = this.mCurrCallable;
        if (processTasksCallable != null) {
            processTasksCallable.cancel();
            try {
                Future future = this.mCurrCallable.mFuture;
                if (future != null) {
                    future.get(50, TimeUnit.MILLISECONDS);
                }
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void release() {
        releaseExceptExecutor();
        ThreadPoolExecutor threadPoolExecutor = this.sThreadPool;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
        }
        this.sThreadPool = null;
    }

    public void releaseExceptExecutor() {
        if (DEBUG) {
            Log.e("PublishManager", "releaseExceptExecutor");
        }
        this.mCallback = null;
        this.mHandler.removeCallbacksAndMessages((Object) null);
        stopAll();
        FileUtils.deleteAllFiles(FileUtils.getUploadCacheDir());
    }

    public void setUploadCallback(UploadCallback callback) {
        if (callback != null || !isUploadTaskRunning()) {
            this.mCallback = callback;
        }
    }

    public UploadFileTask getUploadingTask() {
        ProcessTasksCallable processTasksCallable = this.mCurrCallable;
        if (processTasksCallable != null) {
            return processTasksCallable.getUploadingTask();
        }
        return null;
    }

    private boolean isUploadTaskRunning() {
        ProcessTasksCallable processTasksCallable = this.mCurrCallable;
        if (processTasksCallable != null) {
            return processTasksCallable.isUploadTaskRunning();
        }
        return false;
    }

    private class ProcessTasksCallable implements Callable<Void> {
        /* access modifiers changed from: private */
        public Future mFuture;
        private List<UploadFileTask> mTasks;

        public void setFuture(Future future) {
            this.mFuture = future;
        }

        public void cancel() {
            Future future = this.mFuture;
            if (future != null) {
                future.cancel(true);
            }
            List<UploadFileTask> list = this.mTasks;
            if (list != null && list.size() != 0) {
                for (UploadFileTask task : this.mTasks) {
                    if (task != null && task.getStatus() == 2) {
                        task.setCanceled(true);
                        task.stop();
                    }
                }
                UploadManager.this.mHandler.removeCallbacksAndMessages((Object) null);
            }
        }

        public boolean isCanceled() {
            Future future = this.mFuture;
            if (future != null) {
                return future.isCancelled();
            }
            return false;
        }

        public UploadFileTask getUploadingTask() {
            List<UploadFileTask> list = this.mTasks;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (UploadFileTask task : this.mTasks) {
                if (task != null && task.getStatus() == 2) {
                    return task;
                }
            }
            return null;
        }

        public boolean isUploadTaskRunning() {
            List<UploadFileTask> list = this.mTasks;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (UploadFileTask task : this.mTasks) {
                if (task != null && task.getStatus() == 2) {
                    return true;
                }
            }
            return false;
        }

        public ProcessTasksCallable(List<UploadFileTask> tasks) {
            this.mTasks = tasks;
        }

        public Void call() {
            boolean isVideo;
            if (UploadManager.DEBUG) {
                Log.e("PublishManager", "处理线程开始执行");
            }
            List<UploadFileTask> list = this.mTasks;
            Void voidR = null;
            if (list == null) {
                return null;
            }
            if (list.size() == 0) {
                return null;
            }
            IPublisherSboxVideoInterface publisherSboxVideoManager = (IPublisherSboxVideoInterface) ServiceManager.getService(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
            boolean z = false;
            if (publisherSboxVideoManager != null) {
                isVideo = publisherSboxVideoManager.isVideoTask(this.mTasks.get(0));
            } else {
                isVideo = false;
            }
            if (isVideo || (this.mTasks.get(0) instanceof UploadVideosTask)) {
                z = true;
            }
            CompressProducer compressTransferProducer = startCompressProducer(z);
            int fileNum = this.mTasks.size();
            List<UploadFileTask> compressFailedTask = new ArrayList<>();
            long originSize = 0;
            long compressSize = 0;
            for (UploadFileTask task : this.mTasks) {
                originSize += task.getOriginSize();
                if (isCanceled()) {
                    UploadFileTask uploadFileTask = task;
                    List<UploadFileTask> list2 = compressFailedTask;
                    endCompressProducer(fileNum, originSize, 0, compressTransferProducer, "cancel", "0", (String) null, isVideo);
                    return voidR;
                }
                task.setCallback(UploadManager.this.mTaskCallback);
                if (!task.handleCompress()) {
                    UploadFileTask task2 = task;
                    List<UploadFileTask> compressFailedTask2 = compressFailedTask;
                    endCompressProducer(fileNum, originSize, 0, compressTransferProducer, "fail", "1", (String) null, isVideo);
                    if (task2.isSilenceMode()) {
                        compressFailedTask2.add(task2);
                        compressFailedTask = compressFailedTask2;
                        voidR = null;
                    } else {
                        notifyError("压缩失败！");
                        return null;
                    }
                } else {
                    List<UploadFileTask> list3 = compressFailedTask;
                    compressSize += task.getCompressSize();
                    voidR = null;
                }
            }
            List<UploadFileTask> compressFailedTask3 = compressFailedTask;
            if (compressFailedTask3.size() > 0) {
                this.mTasks.removeAll(compressFailedTask3);
            }
            if (isCanceled()) {
                if (UploadManager.DEBUG) {
                    Log.e("PublishManager", "取消-结束压缩");
                }
                endCompressProducer(fileNum, originSize, compressSize, compressTransferProducer, "success", "2", (String) null, isVideo);
                return null;
            }
            endCompressProducer(fileNum, originSize, compressSize, compressTransferProducer, "success", "0", (String) null, isVideo);
            if (UploadManager.DEBUG) {
                Log.e("PublishManager", "开始上传-isVideo-" + isVideo);
            }
            if (isVideo) {
                uploadVideo(this.mTasks, fileNum, compressSize, UploadManager.this.mSourceType, UploadManager.this.mFrom);
                return null;
            }
            uploadImage(this.mTasks, fileNum, compressSize, UploadManager.this.mSourceType, UploadManager.this.mFrom);
            return null;
        }

        private CompressProducer startCompressProducer(boolean isVideo) {
            CompressProducer compressTransferProducer = null;
            if (!(UploadManager.this.mPublisherManagerInterface == null || UploadManager.this.mPublisherManagerInterface.getUgcEventListener() == null)) {
                compressTransferProducer = new CompressProducer();
                compressTransferProducer.setStartTime(System.currentTimeMillis());
                compressTransferProducer.setProducerSubType(isVideo ? "video" : "image");
                UploadManager.this.mPublisherManagerInterface.getUgcEventListener().startCompressTranscoder();
            }
            return compressTransferProducer;
        }

        private void endCompressProducer(int fileNum, long originSize, long compressSize, CompressProducer compressProducer, String result, String errCode, String errMsg, boolean isVideo) {
            if (UploadManager.this.mPublisherManagerInterface != null && compressProducer != null && UploadManager.this.mPublisherManagerInterface.getUgcEventListener() != null) {
                CompressProducerExt compressProducerExt = new CompressProducerExt();
                compressProducerExt.setFileNum(fileNum);
                compressProducerExt.setOriginSize(FileUtils.convertKB(originSize));
                compressProducerExt.setCompressSize(FileUtils.convertKB(compressSize));
                compressProducer.setUgcProducerExtra(compressProducerExt);
                compressProducer.setEndTime(System.currentTimeMillis());
                compressProducer.setCostTime(compressProducer.getEndTime() - compressProducer.getStartTime());
                compressProducer.setResult(result);
                if (!TextUtils.equals(errCode, "0")) {
                    compressProducer.setErrCode(errCode);
                }
                if (errMsg != null) {
                    compressProducer.setErrMsg(errMsg);
                }
                UploadManager.this.mPublisherManagerInterface.getUgcEventListener().endCompressTranscoder(compressProducer);
            }
        }

        private void uploadVideo(List<UploadFileTask> tasks, int fileNum, long size, int sourceType, String from) {
            UploadProducer uploadProducer = startUploadProducer(true);
            List<String> arrayList = new ArrayList<>();
            for (UploadFileTask task : tasks) {
                arrayList.add(task.getCompressFileName());
            }
            HttpRequestTokenModule httpRequestTokenModule = new HttpRequestTokenModule();
            String tokenResult = httpRequestTokenModule.requestToken(arrayList, true, sourceType, from, tasks.get(0).authUrl);
            if (TextUtils.isEmpty(tokenResult)) {
                ArrayList arrayList2 = arrayList;
                endUploadProducer(uploadProducer, "fail", "2", httpRequestTokenModule.getErrorMsg(), fileNum, size, (String) null);
                notifyError((String) null);
                return;
            }
            List<String> fileNameList = arrayList;
            try {
                JSONObject jsonObject = new JSONObject(tokenResult);
                int errno = jsonObject.optInt("errno", -1);
                if (errno != 0) {
                    String errmsg = jsonObject.optString("errmsg");
                    JSONObject jSONObject = jsonObject;
                    endUploadProducer(uploadProducer, "fail", String.valueOf(errno), errmsg, fileNum, size, (String) null);
                    notifyError(errmsg);
                    return;
                }
                HttpRequestTokenModule.STSInfo stsInfo = httpRequestTokenModule.parseTokenResponse(tokenResult);
                if (!httpRequestTokenModule.checkIfSTSValid(stsInfo, true)) {
                    HttpRequestTokenModule.STSInfo sTSInfo = stsInfo;
                    endUploadProducer(uploadProducer, "fail", "3", (String) null, fileNum, size, tokenResult);
                    notifyError((String) null);
                    return;
                }
                HttpRequestTokenModule.STSInfo stsInfo2 = stsInfo;
                BosClient bosClient = createBosClient(stsInfo2.ak, stsInfo2.sk, stsInfo2.token);
                for (UploadFileTask task2 : tasks) {
                    task2.setBosClient(bosClient);
                    task2.setSTSInfo(stsInfo2);
                    if (isCanceled()) {
                        UploadFileTask uploadFileTask = task2;
                        endUploadProducer(uploadProducer, "cancel", "0", (String) null, fileNum, size, (String) null);
                        return;
                    }
                    UploadFileTask task3 = task2;
                    if (!task3.startSync()) {
                        if (isCanceled()) {
                            endUploadProducer(uploadProducer, "cancel", "0", (String) null, fileNum, size, (String) null);
                            return;
                        }
                        endUploadProducer(uploadProducer, "fail", "4", task3.getErrorMsg(), fileNum, size, (String) null);
                        return;
                    }
                }
                endUploadProducer(uploadProducer, "success", "0", (String) null, fileNum, size, (String) null);
            } catch (JSONException e2) {
                e2.printStackTrace();
                endUploadProducer(uploadProducer, "fail", "1", e2.toString(), fileNum, size, tokenResult);
            }
        }

        private void uploadImage(List<UploadFileTask> tasks, int fileNum, long size, int sourceType, String from) {
            UploadProducer uploadProducer = startUploadProducer(false);
            List<String> arrayList = new ArrayList<>();
            for (UploadFileTask task : tasks) {
                arrayList.add(task.getCompressFileName());
            }
            HttpRequestTokenModule httpRequestTokenModule = new HttpRequestTokenModule();
            String tokenResult = httpRequestTokenModule.requestToken(arrayList, false, sourceType, from, tasks.get(0).authUrl);
            if (TextUtils.isEmpty(tokenResult)) {
                ArrayList arrayList2 = arrayList;
                endUploadProducer(uploadProducer, "fail", "2", httpRequestTokenModule.getErrorMsg(), fileNum, size, (String) null);
                notifyError((String) null);
                return;
            }
            List<String> fileNameList = arrayList;
            try {
                JSONObject jsonObject = new JSONObject(tokenResult);
                int errno = jsonObject.optInt("errno", -1);
                if (errno != 0) {
                    String errmsg = jsonObject.optString("errmsg");
                    JSONObject jSONObject = jsonObject;
                    endUploadProducer(uploadProducer, "fail", String.valueOf(errno), errmsg, fileNum, size, (String) null);
                    notifyError(errmsg);
                    return;
                }
                HttpRequestTokenModule.STSInfo stsInfo = httpRequestTokenModule.parseTokenResponse(tokenResult);
                if (!httpRequestTokenModule.checkIfSTSValid(stsInfo, false)) {
                    HttpRequestTokenModule.STSInfo sTSInfo = stsInfo;
                    endUploadProducer(uploadProducer, "fail", "3", (String) null, fileNum, size, tokenResult);
                    notifyError((String) null);
                    return;
                }
                HttpRequestTokenModule.STSInfo stsInfo2 = stsInfo;
                BosClient bosClient = createBosClient(stsInfo2.ak, stsInfo2.sk, stsInfo2.token);
                for (UploadFileTask task2 : tasks) {
                    HttpRequestTokenModule.STSInfo.BosInfo bosInfo = stsInfo2.map.get(task2.getCompressFileName());
                    if (bosInfo != null) {
                        task2.setUrl(bosInfo.url);
                        task2.setBosKey(bosInfo.bosobject);
                        task2.setBucketName(stsInfo2.bucket);
                        task2.setBosClient(bosClient);
                        task2.setSTSInfo(stsInfo2);
                        if (isCanceled()) {
                            HttpRequestTokenModule.STSInfo.BosInfo bosInfo2 = bosInfo;
                            UploadFileTask uploadFileTask = task2;
                            endUploadProducer(uploadProducer, "cancel", "0", (String) null, fileNum, size, (String) null);
                            return;
                        }
                        UploadFileTask task3 = task2;
                        if (task3.startSync()) {
                            continue;
                        } else if (isCanceled()) {
                            endUploadProducer(uploadProducer, "cancel", "0", (String) null, fileNum, size, (String) null);
                            return;
                        } else {
                            endUploadProducer(uploadProducer, "fail", "4", task3.getErrorMsg(), fileNum, size, (String) null);
                            if (!task3.isSilenceMode()) {
                                return;
                            }
                        }
                    }
                }
                endUploadProducer(uploadProducer, "success", "0", (String) null, fileNum, size, (String) null);
            } catch (JSONException e2) {
                e2.printStackTrace();
                endUploadProducer(uploadProducer, "fail", "1", e2.toString(), fileNum, size, tokenResult);
            }
        }

        private UploadProducer startUploadProducer(boolean isVideo) {
            UploadProducer uploadProducer = null;
            if (!(UploadManager.this.mPublisherManagerInterface == null || UploadManager.this.mPublisherManagerInterface.getUgcEventListener() == null)) {
                uploadProducer = new UploadProducer();
                uploadProducer.setStartTime(System.currentTimeMillis());
                uploadProducer.setProducerSubType(isVideo ? "video" : "image");
                UploadManager.this.mPublisherManagerInterface.getUgcEventListener().startUploadFile();
            }
            return uploadProducer;
        }

        private void endUploadProducer(UploadProducer uploadProducer, String result, String errCode, String errMsg, int fileNum, long size, String errorResponse) {
            if (UploadManager.this.mPublisherManagerInterface != null && uploadProducer != null && UploadManager.this.mPublisherManagerInterface.getUgcEventListener() != null) {
                UploadProducerExt uploadProducerExt = new UploadProducerExt();
                uploadProducerExt.setUploadFileNum(fileNum);
                uploadProducerExt.setTotalSize(FileUtils.convertKB(size));
                uploadProducer.setUgcProducerExtra(uploadProducerExt);
                uploadProducer.setEndTime(System.currentTimeMillis());
                uploadProducer.setResult(result);
                uploadProducer.setCostTime(uploadProducer.getEndTime() - uploadProducer.getStartTime());
                if (!TextUtils.isEmpty(errCode) && !"0".equals(errCode)) {
                    uploadProducer.setErrCode(errCode);
                    if (!TextUtils.isEmpty(errorResponse)) {
                        uploadProducerExt.setErrorResponse(errorResponse);
                    }
                    uploadProducerExt.setTimeStamp(String.valueOf(System.currentTimeMillis()));
                }
                if (!TextUtils.isEmpty(errMsg)) {
                    uploadProducer.setErrMsg(errMsg);
                }
                UploadManager.this.mPublisherManagerInterface.getUgcEventListener().endUploadFile(uploadProducer);
                if ("fail".equals(result)) {
                    UploadManager.this.mPublisherManagerInterface.getUgcEventListener().exitPublisherView("pub_fail");
                }
            }
        }

        private void notifyError(final String msg) {
            List<UploadFileTask> tasks;
            UploadManager.this.mHandler.post(new Runnable() {
                public void run() {
                    if (!ProcessTasksCallable.this.isCanceled() && UploadManager.this.mCallback != null) {
                        UploadManager.this.mCallback.onError(msg);
                    }
                }
            });
            if (UploadManager.this.mCurrCallable != null && (tasks = UploadManager.this.mCurrCallable.mTasks) != null && tasks.size() > 0) {
                for (UploadFileTask task : this.mTasks) {
                    task.stopPlayProgress();
                    if (task instanceof UploadFileTask) {
                        task.releaseTranscoder();
                    }
                }
            }
        }

        public BosClient createBosClient(String ak, String sk, String token) {
            BosClientConfiguration configuration = new BosClientConfiguration();
            configuration.setCredentials(new DefaultBceSessionCredentials(ak, sk, token));
            configuration.setEndpoint(UploadManager.mBosEndpoint);
            configuration.setRetryPolicy(new DefaultRetryPolicy(2, 3000));
            return new BosClient(configuration);
        }
    }
}
