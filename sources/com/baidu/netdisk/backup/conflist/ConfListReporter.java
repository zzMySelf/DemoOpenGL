package com.baidu.netdisk.backup.conflist;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.netdisk.BaseApplication;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.backup.constant.BackupConfKeyKt;
import com.baidu.netdisk.backup.constant.BackupType;
import com.baidu.netdisk.backup.db.provider.BackupProviderHelper;
import com.baidu.netdisk.backup.db.provider.BackupProviderHelperKt;
import com.baidu.netdisk.backup.model.BackupTask;
import com.baidu.netdisk.backup.network.api.BackupApi;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.kernel.util.CollectionUtils;
import com.baidu.netdisk.kernel.util.network.ConnectivityState;
import com.baidu.netdisk.statistics.ThreadJob;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/netdisk/backup/conflist/ConfListReporter;", "", "()V", "job", "Lcom/baidu/netdisk/statistics/ThreadJob;", "needRestart", "", "getConfKey", "", "type", "Lcom/baidu/netdisk/backup/constant/BackupType;", "report", "", "setUserConf", "key", "list", "", "Lcom/baidu/netdisk/backup/model/BackupTask;", "source", "", "tryReport", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfListReporter.kt */
public final class ConfListReporter {
    public static final ConfListReporter INSTANCE = new ConfListReporter();
    /* access modifiers changed from: private */
    public static volatile ThreadJob job;
    /* access modifiers changed from: private */
    public static volatile boolean needRestart;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfListReporter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackupType.values().length];
            iArr[BackupType.DOCUMENT.ordinal()] = 1;
            iArr[BackupType.PHOTO.ordinal()] = 2;
            iArr[BackupType.VIDEO.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ConfListReporter() {
    }

    public final void report() {
        NetDiskLog.d("ConfListReporter", "report");
        if (job != null) {
            needRestart = true;
            return;
        }
        needRestart = false;
        ConfListReporter$report$1 $this$report_u24lambda_u2d0 = new ConfListReporter$report$1();
        $this$report_u24lambda_u2d0.start();
        job = $this$report_u24lambda_u2d0;
    }

    /* access modifiers changed from: private */
    public final void tryReport() {
        List list;
        Object[] $this$forEach$iv;
        Context ctx;
        int source;
        int maxSize;
        NetDiskLog.d("ConfListReporter", "tryReport start");
        long start = SystemClock.elapsedRealtime();
        Context ctx2 = BaseApplication.mContext;
        if (ctx2 != null) {
            if (!ConnectivityState.isConnected(ctx2)) {
            } else if (!ConnectivityState.isWifiEnabled(ctx2)) {
                Context context = ctx2;
            } else {
                Object[] $this$forEach$iv2 = BackupType.values();
                int $i$f$forEach = 0;
                int length = $this$forEach$iv2.length;
                int i2 = 0;
                while (i2 < length) {
                    BackupType type = $this$forEach$iv2[i2];
                    BackupProviderHelper dbHelper = BackupProviderHelperKt.dbHelper();
                    if (dbHelper == null || (list = dbHelper.queryNeedReportTask(type)) == null) {
                        list = CollectionsKt.emptyList();
                    }
                    if (!list.isEmpty()) {
                        ConfListReporter confListReporter = INSTANCE;
                        String confKey = confListReporter.getConfKey(type);
                        if (confKey == null) {
                            ctx = ctx2;
                            $this$forEach$iv = $this$forEach$iv2;
                        } else {
                            if (WhenMappings.$EnumSwitchMapping$0[type.ordinal()] == 1) {
                                source = 1;
                            } else {
                                source = 0;
                            }
                            ctx = ctx2;
                            if (WhenMappings.$EnumSwitchMapping$0[type.ordinal()] == 1) {
                                maxSize = 5000;
                            } else {
                                maxSize = 200;
                            }
                            if (list.size() <= maxSize) {
                                confListReporter.setUserConf(confKey, list, source);
                                int i3 = maxSize;
                                $this$forEach$iv = $this$forEach$iv2;
                            } else {
                                List[] lists = CollectionUtils.split(list, maxSize);
                                if (lists == null) {
                                    $this$forEach$iv = $this$forEach$iv2;
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(lists, "CollectionUtils.split(li…axSize) ?: return@forEach");
                                    List[] listArr = lists;
                                    int i4 = maxSize;
                                    int maxSize2 = listArr.length;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    int i5 = 0;
                                    while (i5 < maxSize2) {
                                        int i6 = maxSize2;
                                        ConfListReporter confListReporter2 = INSTANCE;
                                        int $i$f$forEach2 = $i$f$forEach;
                                        List item = listArr[i5];
                                        int i7 = length;
                                        List list2 = item instanceof List ? item : null;
                                        if (list2 == null) {
                                            list2 = CollectionsKt.emptyList();
                                        }
                                        confListReporter2.setUserConf(confKey, list2, source);
                                        i5++;
                                        length = i7;
                                        maxSize2 = i6;
                                        $i$f$forEach = $i$f$forEach2;
                                    }
                                }
                            }
                        }
                    } else {
                        ctx = ctx2;
                        $this$forEach$iv = $this$forEach$iv2;
                    }
                    i2++;
                    ctx2 = ctx;
                    $this$forEach$iv2 = $this$forEach$iv;
                    length = length;
                    $i$f$forEach = $i$f$forEach;
                }
                Object[] objArr = $this$forEach$iv2;
                NetDiskLog.d("ConfListReporter", "tryReport end, spent time " + (SystemClock.elapsedRealtime() - start) + "ms");
            }
        }
    }

    private final boolean setUserConf(String key, List<BackupTask> list, int source) {
        String str = key;
        List<BackupTask> list2 = list;
        String bduss = AccountUtils.getInstance().getBduss();
        if (bduss == null) {
            return false;
        }
        String bduss2 = bduss;
        String uid = AccountUtils.getInstance().getUid();
        if (uid == null) {
            return false;
        }
        String uid2 = uid;
        Iterable<BackupTask> $this$map$iv = list2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (BackupTask task : $this$map$iv) {
            destination$iv$iv.add(task.getFilePath());
        }
        Iterable $this$filter$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((String) element$iv$iv).length() > 0) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Collection thisCollection$iv = (List) destination$iv$iv2;
        Collection collection = thisCollection$iv;
        Object[] array = thisCollection$iv.toArray(new String[0]);
        if (array != null) {
            String[] paths = (String[]) array;
            boolean succeed = false;
            try {
                Result.Companion companion = Result.Companion;
                BackupApi backupApi = new BackupApi(bduss2, uid2);
                String json = new Gson().toJson((Object) paths);
                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(paths)");
                try {
                    if (backupApi.setUserConf(str, json, source, 0)) {
                        BackupProviderHelper dbHelper = BackupProviderHelperKt.dbHelper();
                        if (dbHelper != null) {
                            dbHelper.updateReportTask(list2);
                        }
                        succeed = true;
                    }
                    Result.m8971constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion2 = Result.Companion;
                    Result.m8971constructorimpl(ResultKt.createFailure(th));
                    NetDiskLog.d("ConfListReporter", "setUserConf " + str + " succeed " + succeed);
                    return succeed;
                }
            } catch (Throwable th3) {
                th = th3;
                int i2 = source;
                Result.Companion companion22 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th));
                NetDiskLog.d("ConfListReporter", "setUserConf " + str + " succeed " + succeed);
                return succeed;
            }
            NetDiskLog.d("ConfListReporter", "setUserConf " + str + " succeed " + succeed);
            return succeed;
        }
        int i3 = source;
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final String getConfKey(BackupType type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return BackupConfKeyKt.DOCUMENT_BACKUP;
            case 2:
                return BackupConfKeyKt.OLD_ALBUM_BACKUP_PHOTOS_1;
            case 3:
                return BackupConfKeyKt.OLD_ALBUM_BACKUP_VIDEOS;
            default:
                return null;
        }
    }
}
