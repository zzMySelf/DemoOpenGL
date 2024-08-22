package com.baidu.netdisk.transfer.task;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.netdisk.BaseApplication;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.base.utils.NetConfigUtil;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.kernel.util.network.ConnectivityState;
import com.baidu.netdisk.kernel.util.network.NetWorkVerifier;
import com.baidu.netdisk.kernel.util.storage.DeviceStorageUtils;
import com.baidu.netdisk.statistics.ThreadJob;
import com.baidu.netdisk.transfer.base.UploadPrivilegeFilter;
import com.baidu.netdisk.transfer.config.TransferGlobalConfig;
import com.baidu.netdisk.transfer.storage.db.TransferContract;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MultiTaskScheduler implements Handler.Callback, Runnable {
    private static final int ACTION_RUN_TRANSMITTER = 0;
    private static final int ACTION_UPDATE_PROGRESS = 1;
    public static final int DEFAULT_MULTI_TASK_COUNT = 2;
    private static final String TAG = "MultiTaskScheduler";
    private final Context mContext;
    private volatile long mInstantRate;
    private volatile int mInstantRunningCount;
    private boolean mIsWaitingForConfirm2G;
    private double mLastProgress;
    private volatile long mLastRate;
    private int mMultiTaskCount = 2;
    private final PendingTaskObserver mPendingTaskObserver;
    /* access modifiers changed from: private */
    public final ContentResolver mResolver;
    protected final List<TransferTask> mTaskCache;
    private final AbstractSchedulerFactory mTransferFactory;
    private Handler mUpdateHandler;
    private HandlerThread mUpdateThread;
    private final Uri mUri;

    private final class PendingTaskObserver extends ContentObserver {
        PendingTaskObserver() {
            super(new Handler(Looper.getMainLooper()));
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean selfChange) {
            NetDiskLog.d(MultiTaskScheduler.TAG, "【Upload-SDK】【上传流程二】启动调度器MultiTaskScheduler 开始");
            MultiTaskScheduler.this.sendUpdateFromProviderMessage();
        }
    }

    public MultiTaskScheduler(Context context, AbstractSchedulerFactory transferFactory) {
        this.mContext = context;
        this.mResolver = context.getContentResolver();
        this.mTransferFactory = transferFactory;
        this.mUri = transferFactory.createUpdateUri();
        this.mPendingTaskObserver = new PendingTaskObserver();
        this.mTaskCache = Collections.synchronizedList(new LinkedList());
        this.mLastProgress = -1.0d;
    }

    public void start() {
        this.mResolver.registerContentObserver(this.mUri, true, this.mPendingTaskObserver);
        this.mIsWaitingForConfirm2G = false;
        NetWorkVerifier.reset();
        HandlerThread handlerThread = new HandlerThread("MultiTaskScheduler-UpdateThread");
        this.mUpdateThread = handlerThread;
        handlerThread.start();
        new Thread(this).start();
    }

    public void restart() {
        NetDiskLog.d(TAG, "【Upload-SDK】 重启调度器 restart()");
        NetWorkVerifier.reset();
        this.mIsWaitingForConfirm2G = false;
        sendUpdateFromProviderMessage();
    }

    public void stop(boolean isPauseTask) {
        NetDiskLog.d(TAG, "stop isPauseTask:" + isPauseTask);
        this.mResolver.unregisterContentObserver(this.mPendingTaskObserver);
        Handler handler = this.mUpdateHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mUpdateThread.quit();
        if (isPauseTask) {
            pauseAllTask();
        }
    }

    /* access modifiers changed from: private */
    public void sendUpdateFromProviderMessage() {
        if (this.mUpdateHandler != null) {
            NetDiskLog.d(TAG, "【Upload-SDK】 启动调试器 发送广播");
            this.mUpdateHandler.sendEmptyMessage(0);
        }
    }

    private void sendUpdateProgressMessage() {
        Handler handler = this.mUpdateHandler;
        if (handler != null) {
            handler.removeMessages(1);
            this.mUpdateHandler.sendEmptyMessageDelayed(1, 200);
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        Looper looper = this.mUpdateThread.getLooper();
        if (looper != null) {
            this.mUpdateHandler = new Handler(looper, this);
            NetDiskLog.d(TAG, "【Upload-SDK】 是否自动上传 " + TransferGlobalConfig.getInstance().isAutoUpload());
            if (TransferGlobalConfig.getInstance().isAutoUpload()) {
                sendUpdateFromProviderMessage();
            }
        }
    }

    public boolean handleMessage(Message msg) {
        Process.setThreadPriority(10);
        switch (msg.what) {
            case 0:
                syncCache();
                return true;
            case 1:
                return true;
            default:
                return true;
        }
    }

    private synchronized void syncCache() {
        NetDiskLog.d(TAG, "【Upload-SDK】 syncCache start");
        long start = System.currentTimeMillis();
        Cursor cursor = queryDB();
        if (cursor == null) {
            NetDiskLog.d(TAG, "【Upload-SDK】syncCache cursor == null");
            return;
        }
        Set<Integer> tempData = initInvalidTaskSearcherData();
        syncCacheInfo(cursor, tempData);
        clearCache(tempData);
        NetDiskLog.d(TAG, "【Upload-SDK】 同步结束,耗时:" + ((System.currentTimeMillis() - start) / 1000));
        NetDiskLog.d(TAG, "【Upload-SDK】【上传流程二】启动调度器MultiTaskScheduler 结束");
    }

    private Cursor queryDB() {
        NetDiskLog.w(TAG, "【Upload-SDK】 queryDB mUri " + this.mUri);
        try {
            return this.mResolver.query(this.mUri, this.mTransferFactory.createProjection(), buildSql() + "state" + "=" + String.valueOf(100) + " OR " + "state" + "=" + String.valueOf(104), (String[]) null, "CASE WHEN state=105 THEN 0 WHEN state=104 THEN 1 WHEN state=100 THEN 2 ELSE 3 END," + this.mTransferFactory.createOrderBy());
        } catch (IllegalStateException ignore) {
            NetDiskLog.w(TAG, "【Upload-SDK】 数据库关闭时query", ignore);
            return null;
        } catch (Exception e2) {
            NetDiskLog.w(TAG, "【Upload-SDK】 数据库关闭时query", e2);
            return null;
        }
    }

    private Set<Integer> initInvalidTaskSearcherData() {
        HashSet<Integer> tempData = new HashSet<>(this.mTaskCache.size());
        for (TransferTask task : this.mTaskCache) {
            tempData.add(Integer.valueOf(task.mTaskId));
        }
        return tempData;
    }

    /* access modifiers changed from: protected */
    public void clearCache(final Set<Integer> tempData) {
        final Uri uri = this.mTransferFactory.createClearTaskUri();
        if (!tempData.isEmpty() && uri != null) {
            NetDiskLog.d(TAG, "【Upload-SDK】 删除任务:" + tempData.size());
            Cursor cursor = null;
            try {
                cursor = this.mResolver.query(uri, new String[]{"_id"}, "is_delete_file=?", new String[]{String.valueOf(1)}, (String) null);
            } catch (IllegalStateException e2) {
                NetDiskLog.e(TAG, "ignore", e2);
            }
            try {
                for (Integer id : tempData) {
                    if (id != null) {
                        Iterator<TransferTask> iterator = this.mTaskCache.iterator();
                        while (iterator.hasNext()) {
                            TransferTask task = iterator.next();
                            if (task.mTaskId == id.intValue()) {
                                iterator.remove();
                                if (104 == task.mState) {
                                    boolean isDeleteFile = false;
                                    if (cursor != null && cursor.moveToFirst()) {
                                        while (true) {
                                            if (cursor.getInt(0) != id.intValue()) {
                                                if (!cursor.moveToNext()) {
                                                    break;
                                                }
                                            } else {
                                                isDeleteFile = true;
                                                break;
                                            }
                                        }
                                    }
                                    task.performRemove(isDeleteFile);
                                }
                            }
                        }
                    }
                }
                new ThreadJob("ClearCacheRunnable") {
                    /* access modifiers changed from: protected */
                    public void performExecute() throws Exception {
                        Process.setThreadPriority(19);
                        MultiTaskScheduler.this.mResolver.delete(uri, "_id IN(" + TextUtils.join(",", tempData) + ")", (String[]) null);
                    }
                }.start();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    private void syncCacheInfo(Cursor cursor, Set<Integer> tempData) {
        int runningTaskCount = 0;
        try {
            if (cursor.getCount() <= 0) {
                NetDiskLog.d(TAG, "【Upload-SDK】 syncCacheInfo cursor count 0");
                cursor.close();
                return;
            }
            if (this.mTaskCache.isEmpty()) {
                NetDiskLog.d(TAG, "【Upload-SDK】 syncCacheInfo mTaskCache.isEmpty() true");
                if (cursor.moveToFirst()) {
                    do {
                        TransferTask newTask = this.mTransferFactory.createTask(this.mContext, cursor);
                        runningTaskCount = syncState(newTask, runningTaskCount);
                        add(newTask);
                    } while (cursor.moveToNext());
                    if (runningTaskCount == 0) {
                        NetDiskLog.d(TAG, "【Upload-SDK】 mTaskCache is null runningTaskCount 0");
                    }
                }
            } else {
                NetDiskLog.d(TAG, "【Upload-SDK】 syncCacheInfo mTaskCache.isEmpty() false");
                if (cursor.moveToFirst()) {
                    do {
                        int id = cursor.getInt(cursor.getColumnIndex("_id"));
                        Iterator<TransferTask> it = this.mTaskCache.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                TransferTask newTask2 = this.mTransferFactory.createTask(this.mContext, cursor);
                                runningTaskCount = syncState(newTask2, runningTaskCount);
                                add(newTask2);
                                break;
                            }
                            TransferTask taskInfo = it.next();
                            if (id == taskInfo.mTaskId) {
                                this.mTransferFactory.syncTaskInfo(taskInfo, cursor);
                                runningTaskCount = syncState(taskInfo, runningTaskCount);
                                tempData.remove(Integer.valueOf(taskInfo.mTaskId));
                                break;
                            }
                        }
                    } while (cursor.moveToNext() != 0);
                    if (runningTaskCount == 0) {
                        NetDiskLog.d(TAG, "mTaskCache size > 0 runningTaskCount 0");
                    }
                }
            }
            cursor.close();
        } catch (IllegalStateException ignore) {
            NetDiskLog.w(TAG, "数据库关闭时query", ignore);
        } catch (Exception e2) {
            NetDiskLog.w(TAG, "数据库关闭时query", e2);
        } catch (Throwable th2) {
            cursor.close();
            throw th2;
        }
    }

    private int syncState(TransferTask task, int runningTaskCount) {
        switch (task.mState) {
            case 100:
                if (runningTaskCount >= this.mMultiTaskCount || isBreakCondition() || !checkTransferEnable(task)) {
                    return runningTaskCount;
                }
                if (task.transmitter != null) {
                    task.transmitter.stop();
                }
                if (task.extraInfoNum == 8) {
                    Uri processingUri = TransferContract.UploadTasks.buildProcessingUri(AccountUtils.getInstance().getBduss());
                    ContentValues contentValue = new ContentValues();
                    contentValue.put("state", 106);
                    this.mResolver.update(ContentUris.withAppendedId(this.mUri, (long) task.mTaskId), contentValue, (String) null, (String[]) null);
                    this.mResolver.update(ContentUris.withAppendedId(processingUri, (long) task.mTaskId), contentValue, (String) null, (String[]) null);
                    task.mState = 106;
                    return runningTaskCount;
                }
                ContentValues values = new ContentValues(2);
                values.put("state", 104);
                values.put(TransferContract.TasksColumns.EXTRA_INFO_NUM, 0);
                this.mResolver.update(ContentUris.withAppendedId(this.mUri, (long) task.mTaskId), values, (String) null, (String[]) null);
                notifyUIWhenPendingToRunning(task, this.mUri);
                task.performStart(this.mResolver);
                task.mState = 104;
                int runningTaskCount2 = runningTaskCount + 1;
                if (!this.mTransferFactory.isSupportNotification()) {
                    return runningTaskCount2;
                }
                sendUpdateProgressMessage();
                return runningTaskCount2;
            case 104:
                if (runningTaskCount >= this.mMultiTaskCount) {
                    NetDiskLog.d(TAG, "【Upload-SDK】 syncState STATE_RUNNING runningTaskCount >= mMultiTaskCount runningTaskCount " + runningTaskCount);
                    return runningTaskCount;
                }
                if (task.transmitter == null) {
                    if (isBreakCondition()) {
                        NetDiskLog.d(TAG, "【Upload-SDK】 syncState STATE_RUNNING isBreakCondition() true");
                        ContentValues values2 = new ContentValues(2);
                        values2.put("state", 100);
                        values2.put(TransferContract.TasksColumns.EXTRA_INFO_NUM, 0);
                        this.mResolver.update(ContentUris.withAppendedId(this.mUri, (long) task.mTaskId), values2, (String) null, (String[]) null);
                        return runningTaskCount;
                    } else if (!checkTransferEnable(task)) {
                        NetDiskLog.d(TAG, "【Upload-SDK】 syncState STATE_RUNNING checkTransferEnable() false");
                        ContentValues values3 = new ContentValues(2);
                        values3.put("state", 100);
                        values3.put(TransferContract.TasksColumns.EXTRA_INFO_NUM, 0);
                        this.mResolver.update(ContentUris.withAppendedId(this.mUri, (long) task.mTaskId), values3, (String) null, (String[]) null);
                        return runningTaskCount;
                    } else {
                        task.performStart(this.mResolver);
                        if (this.mTransferFactory.isSupportNotification()) {
                            sendUpdateProgressMessage();
                        }
                    }
                } else if (this.mIsWaitingForConfirm2G) {
                    NetDiskLog.d(TAG, "【Upload-SDK】 syncState STATE_RUNNING mIsWaitingForConfirm2G true");
                    task.transmitter.pause();
                    ContentValues values4 = new ContentValues(1);
                    values4.put("state", 100);
                    this.mResolver.update(ContentUris.withAppendedId(this.mUri, (long) task.mTaskId), values4, (String) null, (String[]) null);
                    NetDiskLog.i(TAG, "【Upload-SDK】 因流量保护弹窗而停止");
                }
                return runningTaskCount + 1;
            case 105:
                if (task.transmitter == null) {
                    return runningTaskCount;
                }
                task.performPause();
                return runningTaskCount;
            case 106:
                if (task.transmitter == null) {
                    return runningTaskCount;
                }
                task.transmitter = null;
                return runningTaskCount;
            default:
                return runningTaskCount;
        }
    }

    /* access modifiers changed from: protected */
    public void notifyUIWhenPendingToRunning(TransferTask taskInfo, Uri uri) {
    }

    private void add(TransferTask newTask) {
        this.mTaskCache.add(newTask);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateProgress() {
        /*
            r26 = this;
            r0 = r26
            r1 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            java.util.LinkedList r13 = new java.util.LinkedList
            java.util.List<com.baidu.netdisk.transfer.task.TransferTask> r14 = r0.mTaskCache
            r13.<init>(r14)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Iterator r15 = r13.iterator()
        L_0x001e:
            boolean r16 = r15.hasNext()
            r17 = 0
            if (r16 == 0) goto L_0x00b3
            java.lang.Object r16 = r15.next()
            r19 = r13
            r13 = r16
            com.baidu.netdisk.transfer.task.TransferTask r13 = (com.baidu.netdisk.transfer.task.TransferTask) r13
            r16 = r15
            int r15 = r13.mState
            switch(r15) {
                case 100: goto L_0x0080;
                case 104: goto L_0x0056;
                case 105: goto L_0x0051;
                case 106: goto L_0x004e;
                case 110: goto L_0x003c;
                default: goto L_0x0037;
            }
        L_0x0037:
            r20 = r7
            r21 = r8
            goto L_0x0091
        L_0x003c:
            int r7 = r7 + 1
            java.lang.String r15 = r13.mFileName
            java.lang.String r15 = com.baidu.netdisk.kernel.util.file.FileUtils.getExtension(r15)
            boolean r20 = r14.contains(r15)
            if (r20 != 0) goto L_0x0095
            r14.add(r15)
            goto L_0x0095
        L_0x004e:
            int r8 = r8 + 1
            goto L_0x0095
        L_0x0051:
            r20 = r7
            r21 = r8
            goto L_0x0091
        L_0x0056:
            int r5 = r5 + 1
            com.baidu.netdisk.transfer.transmitter.Transmitter r15 = r13.transmitter
            if (r15 == 0) goto L_0x007b
            com.baidu.netdisk.transfer.transmitter.Transmitter r15 = r13.transmitter
            r20 = r7
            r21 = r8
            long r7 = r15.getOffsetSize()
            r13.mOffset = r7
            com.baidu.netdisk.transfer.transmitter.Transmitter r7 = r13.transmitter
            long r7 = r7.getRate()
            long r9 = r9 + r7
            com.baidu.netdisk.transfer.transmitter.Transmitter r7 = r13.transmitter
            long r7 = r7.getInstantSpeed()
            long r11 = r11 + r7
            r7 = r20
            r8 = r21
            goto L_0x0095
        L_0x007b:
            r20 = r7
            r21 = r8
            goto L_0x0095
        L_0x0080:
            r20 = r7
            r21 = r8
            int r6 = r6 + 1
            long r7 = r13.mOffset
            long r1 = r1 + r7
            long r7 = r13.mSize
            long r3 = r3 + r7
            r7 = r20
            r8 = r21
            goto L_0x0095
        L_0x0091:
            r7 = r20
            r8 = r21
        L_0x0095:
            r15 = r5
            r20 = r6
            long r5 = r13.mOffset
            int r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r5 <= 0) goto L_0x00aa
            r5 = 100
            int r6 = r13.mState
            if (r5 == r6) goto L_0x00aa
            long r5 = r13.mOffset
            long r1 = r1 + r5
            long r5 = r13.mSize
            long r3 = r3 + r5
        L_0x00aa:
            r5 = r15
            r15 = r16
            r13 = r19
            r6 = r20
            goto L_0x001e
        L_0x00b3:
            r20 = r7
            r21 = r8
            r19 = r13
            long r7 = r0.mInstantRate
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x00c1
            r0.mInstantRate = r11
        L_0x00c1:
            int r7 = r0.mInstantRunningCount
            if (r7 == r5) goto L_0x00c7
            r0.mInstantRunningCount = r5
        L_0x00c7:
            if (r5 != 0) goto L_0x00d6
            if (r6 != 0) goto L_0x00d6
            java.util.List<com.baidu.netdisk.transfer.task.TransferTask> r7 = r0.mTaskCache
            r7.clear()
            r22 = r1
            r17 = r5
            r13 = r6
            goto L_0x012e
        L_0x00d6:
            r7 = 0
            int r13 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            r15 = 4636737291354636288(0x4059000000000000, double:100.0)
            if (r13 <= 0) goto L_0x00e9
            r17 = r5
            r13 = r6
            double r5 = (double) r1
            double r5 = r5 * r15
            r22 = r1
            double r1 = (double) r3
            double r7 = r5 / r1
            goto L_0x00ee
        L_0x00e9:
            r22 = r1
            r17 = r5
            r13 = r6
        L_0x00ee:
            r1 = 0
            r5 = 4502148214488346440(0x3e7ad7f29abcaf48, double:1.0E-7)
            double r15 = r7 - r15
            double r15 = java.lang.Math.abs(r15)
            r24 = 4502148214488346440(0x3e7ad7f29abcaf48, double:1.0E-7)
            int r2 = (r15 > r24 ? 1 : (r15 == r24 ? 0 : -1))
            if (r2 < 0) goto L_0x0119
            r15 = r1
            double r1 = r0.mLastProgress
            double r1 = r7 - r1
            double r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r24 ? 1 : (r1 == r24 ? 0 : -1))
            if (r1 > 0) goto L_0x011a
            long r1 = r0.mLastRate
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0117
            goto L_0x011a
        L_0x0117:
            r1 = 0
            goto L_0x011f
        L_0x0119:
            r15 = r1
        L_0x011a:
            r0.mLastProgress = r7
            r0.mLastRate = r9
            r1 = r15
        L_0x011f:
            if (r1 != 0) goto L_0x0125
            r26.sendUpdateProgressMessage()
            goto L_0x012e
        L_0x0125:
            r15 = r1
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r0.mLastProgress = r1
            r1 = -1
            r0.mLastRate = r1
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.transfer.task.MultiTaskScheduler.updateProgress():void");
    }

    private String buildSql() {
        if (this.mTaskCache.isEmpty()) {
            return "";
        }
        StringBuilder where = new StringBuilder();
        where.append("_id").append(" IN (");
        int i2 = 0;
        for (TransferTask taskInfo : this.mTaskCache) {
            int i3 = i2 + 1;
            if (i2 > 0) {
                where.append(",");
            }
            where.append(String.valueOf(taskInfo.mTaskId));
            i2 = i3;
        }
        where.append(")");
        return where.toString() + " OR ";
    }

    private boolean isBreakCondition() {
        NetDiskLog.d(TAG, "isBreakCondition 判断任务是否满足调度的要求");
        boolean isConnected = ConnectivityState.isConnected(BaseApplication.getInstance());
        boolean isNoNetwork = NetWorkVerifier.isNoNetwork();
        boolean isWiFiOnlyChecked = NetConfigUtil.getInstance().isWiFiOnlyChecked();
        boolean isWifi = ConnectivityState.isWifi(BaseApplication.getInstance());
        boolean isLogin = TextUtils.isEmpty(AccountUtils.getInstance().getBduss());
        boolean isSDCardExists = DeviceStorageUtils.isSDCardExists();
        NetDiskLog.d(TAG, "isBreakCondition isConnected:" + isConnected + ",isNoNetwork:" + isNoNetwork + ",isWiFiOnlyChecked:" + isWiFiOnlyChecked + ",isWifi:" + isWifi + ",isLogin:" + isLogin + ",isSDCardExists:" + isSDCardExists + ",mIsWaitingForConfirm2G:" + this.mIsWaitingForConfirm2G + " ,isNotifyTask:" + this.mTransferFactory.isSupportWifiOnly());
        return !isConnected || isNoNetwork || (isWiFiOnlyChecked && !isWifi && this.mTransferFactory.isSupportWifiOnly()) || isLogin || !isSDCardExists || this.mIsWaitingForConfirm2G;
    }

    public void setWaitingForConfirm2G(boolean isWaitingForConfirm2G) {
        this.mIsWaitingForConfirm2G = isWaitingForConfirm2G;
        NetDiskLog.d(TAG, "set isWaitingForConfirm2G=" + isWaitingForConfirm2G);
    }

    private synchronized void pauseAllTask() {
        for (TransferTask taskInfo : this.mTaskCache) {
            if (104 == taskInfo.mState) {
                taskInfo.performPause();
            }
        }
    }

    private synchronized boolean checkTransferEnable(TransferTask taskInfo) {
        NetDiskLog.d(TAG, "checkTransferEnable 检查是否有文件的传输能力（视频特权检查）");
        if (!taskInfo.mLocalFileMeta.isVideo()) {
            return true;
        }
        if (UploadPrivilegeFilter.checkBusinessTransferEnable()) {
            NetDiskLog.d(TAG, "【Upload-SDK】 业务已授权, 可以上传视频");
            return true;
        }
        NetDiskLog.d(TAG, "【Upload-SDK】 业务未授权, 是否允许上传视频 " + this.mTransferFactory.transferVideoEnable());
        return this.mTransferFactory.transferVideoEnable();
    }

    public void setMultiTaskCount(int count) {
        this.mMultiTaskCount = count;
    }

    public static MultiTaskScheduler getUploadMultiTaskScheduler(Context context, String bduss, String uid) {
        return new MultiTaskScheduler(context, new UploadSchedulerFactory(context.getContentResolver(), bduss, uid));
    }
}
