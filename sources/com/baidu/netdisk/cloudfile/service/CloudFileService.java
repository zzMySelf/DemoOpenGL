package com.baidu.netdisk.cloudfile.service;

import com.baidu.netdisk.base.service.ISchedulerService;
import com.baidu.netdisk.executor.job.PriorityScheduler;

public class CloudFileService implements ISchedulerService {
    public static int FILE_MANAGER_ASYNC = 2;
    public static int FILE_MANAGER_AUTO = 1;
    public static int FILE_MANAGER_SYNC = 0;
    public static String ONDUP_FAIL = "fail";
    public static String ONDUP_NEWCOPY = "newcopy";
    public static String ONDUP_OVER_WRITE = "overwrite";
    public static String ONDUP_SKIP = "skip";
    public static String ON_NEST_FAIL = "fail";
    private static final String TAG = "CloudFileService";
    static final int TASK_FAILED = -1;
    static final int TASK_SUCCESS = 1;
    static final int TASK_TODO = 0;
    static final int TASK_TYPE_BACKUP_PHOTO = 9;
    static final int TASK_TYPE_LOGIN = 7;
    private PriorityScheduler scheduler;

    public CloudFileService(PriorityScheduler scheduler2) {
        this.scheduler = scheduler2;
    }

    /* access modifiers changed from: protected */
    public boolean supportEmptyBdussAction(String action) {
        return Actions.ACTION_QUERY_ACTIVITY.equals(action);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        if (r7.equals(com.baidu.netdisk.cloudfile.service.Actions.ACTION_FILE_PATH_EXISTS) != false) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r14, android.content.Context r15) {
        /*
            r13 = this;
            java.lang.String r0 = "com.baidu.netdisk.extra.BDUSS"
            java.lang.String r0 = r14.getStringExtra(r0)
            java.lang.String r7 = r14.getAction()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001e
            com.baidu.netdisk.account.AccountUtils r3 = com.baidu.netdisk.account.AccountUtils.getInstance()
            java.lang.String r3 = r3.getBduss()
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x001e
            r3 = r1
            goto L_0x001f
        L_0x001e:
            r3 = r2
        L_0x001f:
            r8 = r3
            java.lang.String r3 = "com.baidu.netdisk.extra.RESULT_RECEIVER"
            android.os.Parcelable r3 = r14.getParcelableExtra(r3)
            r9 = r3
            android.os.ResultReceiver r9 = (android.os.ResultReceiver) r9
            java.lang.String r3 = "CloudFileService"
            if (r8 != 0) goto L_0x00ee
            com.baidu.netdisk.account.AccountUtils r4 = com.baidu.netdisk.account.AccountUtils.getInstance()
            boolean r4 = r4.isLogin()
            if (r4 != 0) goto L_0x003f
            boolean r4 = r13.supportEmptyBdussAction(r7)
            if (r4 != 0) goto L_0x003f
            goto L_0x00ee
        L_0x003f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "trace onHandleIntent:"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r4 = r4.toString()
            com.baidu.netdisk.kernel.architecture.debug.NetDiskLog.d(r3, r4)
            java.lang.String r3 = "com.baidu.netdisk.extra.UID"
            java.lang.String r10 = r14.getStringExtra(r3)
            r3 = -1
            int r4 = r7.hashCode()
            switch(r4) {
                case -1992007046: goto L_0x0082;
                case -101449925: goto L_0x0078;
                case 96372371: goto L_0x006e;
                case 1323569832: goto L_0x0065;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x008c
        L_0x0065:
            java.lang.String r2 = "com.baidu.netdisk.ACTION_FILE_PATH_EXISTS"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0064
            goto L_0x008d
        L_0x006e:
            java.lang.String r1 = "com.baidu.netdisk.ACTION_CREATE_TASK"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x0064
            r1 = 2
            goto L_0x008d
        L_0x0078:
            java.lang.String r1 = "com.baidu.netdisk.ACTION_GET_FILEMETAS_BY_IDS"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x0064
            r1 = 3
            goto L_0x008d
        L_0x0082:
            java.lang.String r1 = "com.baidu.netdisk.ACTION_GET_QUOTA"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x0064
            r1 = r2
            goto L_0x008d
        L_0x008c:
            r1 = r3
        L_0x008d:
            switch(r1) {
                case 0: goto L_0x00dc;
                case 1: goto L_0x00cb;
                case 2: goto L_0x00ba;
                case 3: goto L_0x00a9;
                default: goto L_0x0090;
            }
        L_0x0090:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " unhandled"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00a9:
            com.baidu.netdisk.executor.job.PriorityScheduler r11 = r13.scheduler
            com.baidu.netdisk.cloudfile.service.GetFileMetasByIdsJob r12 = new com.baidu.netdisk.cloudfile.service.GetFileMetasByIdsJob
            r1 = r12
            r2 = r15
            r3 = r14
            r4 = r9
            r5 = r0
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            r11.addJobWithHigh(r12)
            goto L_0x00ed
        L_0x00ba:
            com.baidu.netdisk.executor.job.PriorityScheduler r11 = r13.scheduler
            com.baidu.netdisk.cloudfile.service.CreateTaskJob r12 = new com.baidu.netdisk.cloudfile.service.CreateTaskJob
            r1 = r12
            r2 = r15
            r3 = r14
            r4 = r9
            r5 = r0
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            r11.addJobWithLow(r12)
            goto L_0x00ed
        L_0x00cb:
            com.baidu.netdisk.executor.job.PriorityScheduler r11 = r13.scheduler
            com.baidu.netdisk.cloudfile.service.IsFilePathExistJob r12 = new com.baidu.netdisk.cloudfile.service.IsFilePathExistJob
            r1 = r12
            r2 = r15
            r3 = r14
            r4 = r9
            r5 = r0
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            r11.addJobWithHigh(r12)
            goto L_0x00ed
        L_0x00dc:
            com.baidu.netdisk.executor.job.PriorityScheduler r11 = r13.scheduler
            com.baidu.netdisk.cloudfile.service.GetQuotaJob r12 = new com.baidu.netdisk.cloudfile.service.GetQuotaJob
            r1 = r12
            r2 = r15
            r3 = r14
            r4 = r9
            r5 = r0
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            r11.addJobWithLow(r12)
        L_0x00ed:
            return
        L_0x00ee:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r2 = " cancel"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.baidu.netdisk.kernel.architecture.debug.NetDiskLog.d(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.cloudfile.service.CloudFileService.onHandleIntent(android.content.Intent, android.content.Context):void");
    }
}
