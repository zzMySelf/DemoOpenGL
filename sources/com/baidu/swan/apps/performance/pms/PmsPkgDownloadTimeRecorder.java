package com.baidu.swan.apps.performance.pms;

import com.baidu.swan.apps.performance.PerformanceObserverManager;
import com.baidu.swan.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSPkgMain;
import com.baidu.swan.pms.model.PMSPkgSub;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001a\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u001a\u0010\u001b\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001f\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001a\u0010 \u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010!\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\"\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010#\u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/swan/apps/performance/pms/PmsPkgDownloadTimeRecorder;", "", "()V", "DOWNLOAD_INTERVAL_THRESHOLD", "", "KEY_MAIN_DOWNLOAD_END", "", "KEY_MAIN_DOWNLOAD_SIZE", "KEY_MAIN_DOWNLOAD_START", "KEY_SUB_DOWNLOAD_END", "KEY_SUB_DOWNLOAD_SIZE", "KEY_SUB_DOWNLOAD_START", "mCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "mSubPkgName", "clearPkgDownloadInfo", "", "needRecordPkgDownloadInfo", "", "type", "Lcom/baidu/swan/pms/PMSDownloadType;", "recordAsyncSubPkgDownloadEnd", "sub", "Lcom/baidu/swan/pms/model/PMSPkgSub;", "recordAsyncSubPkgDownloadError", "recordAsyncSubPkgDownloadStart", "recordMainPkgDownloadEnd", "main", "Lcom/baidu/swan/pms/model/PMSPkgMain;", "recordMainPkgDownloadError", "recordMainPkgDownloadStart", "recordSubPkgDownloadEnd", "recordSubPkgDownloadError", "recordSubPkgDownloadStart", "sendMainPkgDownloadInfoToSwanJs", "sendSubPkgDownloadInfoToSwanJs", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PmsPkgDownloadTimeRecorder.kt */
public final class PmsPkgDownloadTimeRecorder {
    private static final int DOWNLOAD_INTERVAL_THRESHOLD = 30000;
    public static final PmsPkgDownloadTimeRecorder INSTANCE = new PmsPkgDownloadTimeRecorder();
    private static final String KEY_MAIN_DOWNLOAD_END = "__main_pkg_download_end__";
    private static final String KEY_MAIN_DOWNLOAD_SIZE = "__main_pkg_download_size__";
    private static final String KEY_MAIN_DOWNLOAD_START = "__main_pkg_download_start__";
    private static final String KEY_SUB_DOWNLOAD_END = "__sub_pkg_download_end__";
    private static final String KEY_SUB_DOWNLOAD_SIZE = "__sub_pkg_download_size__";
    private static final String KEY_SUB_DOWNLOAD_START = "__sub_pkg_download_start__";
    private static final ConcurrentHashMap<String, Long> mCacheMap = new ConcurrentHashMap<>();
    private static String mSubPkgName = "";

    private PmsPkgDownloadTimeRecorder() {
    }

    public final void recordAsyncSubPkgDownloadStart(PMSPkgSub sub) {
        if ((sub != null ? sub.pkgName : null) != null) {
            String str = sub.pkgName;
            Intrinsics.checkNotNullExpressionValue(str, "sub.pkgName");
            mCacheMap.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void recordAsyncSubPkgDownloadEnd(PMSPkgSub sub) {
        Long remove;
        if ((sub != null ? sub.pkgName : null) != null && (remove = mCacheMap.remove(sub.pkgName)) != null) {
            PerformanceObserverManager.INSTANCE.dispatchLoadPackageEvent(sub.size, remove.longValue(), System.currentTimeMillis(), sub.pkgName);
        }
    }

    public final void recordAsyncSubPkgDownloadError(PMSPkgSub sub) {
        if ((sub != null ? sub.pkgName : null) != null) {
            mCacheMap.remove(sub.pkgName);
        }
    }

    public final void clearPkgDownloadInfo() {
        mCacheMap.clear();
        mSubPkgName = "";
    }

    public final void recordMainPkgDownloadStart(PMSDownloadType type) {
        Boolean valueOf = Boolean.valueOf(needRecordPkgDownloadInfo(type));
        if (!valueOf.booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            mCacheMap.put(KEY_MAIN_DOWNLOAD_START, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void recordMainPkgDownloadError(PMSDownloadType type) {
        Boolean valueOf = Boolean.valueOf(needRecordPkgDownloadInfo(type));
        if (!valueOf.booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            mCacheMap.remove(KEY_MAIN_DOWNLOAD_START);
        }
    }

    public final void recordMainPkgDownloadEnd(PMSDownloadType type, PMSPkgMain main) {
        Boolean valueOf = Boolean.valueOf(needRecordPkgDownloadInfo(type));
        if (!valueOf.booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            if (main == null) {
                mCacheMap.remove(KEY_MAIN_DOWNLOAD_START);
                return;
            }
            ConcurrentHashMap<String, Long> concurrentHashMap = mCacheMap;
            concurrentHashMap.put(KEY_MAIN_DOWNLOAD_END, Long.valueOf(System.currentTimeMillis()));
            concurrentHashMap.put(KEY_MAIN_DOWNLOAD_SIZE, Long.valueOf(main.size));
            if (type == null) {
                sendMainPkgDownloadInfoToSwanJs();
            }
        }
    }

    public final void recordSubPkgDownloadStart(PMSDownloadType type) {
        Boolean valueOf = Boolean.valueOf(needRecordPkgDownloadInfo(type));
        if (!valueOf.booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            mCacheMap.put(KEY_SUB_DOWNLOAD_START, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void recordSubPkgDownloadError(PMSDownloadType type) {
        Boolean valueOf = Boolean.valueOf(needRecordPkgDownloadInfo(type));
        if (!valueOf.booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            mCacheMap.remove(KEY_SUB_DOWNLOAD_START);
        }
    }

    public final void recordSubPkgDownloadEnd(PMSDownloadType type, PMSPkgSub sub) {
        Boolean valueOf = Boolean.valueOf(needRecordPkgDownloadInfo(type));
        String str = null;
        if (!valueOf.booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            if (sub != null) {
                str = sub.pkgName;
            }
            if (str == null) {
                mCacheMap.remove(KEY_SUB_DOWNLOAD_START);
                return;
            }
            ConcurrentHashMap<String, Long> concurrentHashMap = mCacheMap;
            concurrentHashMap.put(KEY_SUB_DOWNLOAD_END, Long.valueOf(System.currentTimeMillis()));
            concurrentHashMap.put(KEY_SUB_DOWNLOAD_SIZE, Long.valueOf(sub.size));
            String str2 = sub.pkgName;
            Intrinsics.checkNotNullExpressionValue(str2, "sub.pkgName");
            mSubPkgName = str2;
            if (type == null) {
                sendMainPkgDownloadInfoToSwanJs();
            }
        }
    }

    private final boolean needRecordPkgDownloadInfo(PMSDownloadType type) {
        return type == null || type == PMSDownloadType.SYNC;
    }

    public final void sendMainPkgDownloadInfoToSwanJs() {
        ConcurrentHashMap<String, Long> concurrentHashMap = mCacheMap;
        Long remove = concurrentHashMap.remove(KEY_MAIN_DOWNLOAD_START);
        long j2 = 0L;
        if (remove == null) {
            remove = 0L;
        }
        long startTime = remove.longValue();
        Long remove2 = concurrentHashMap.remove(KEY_MAIN_DOWNLOAD_END);
        if (remove2 == null) {
            remove2 = 0L;
        }
        long endTime = remove2.longValue();
        Long remove3 = concurrentHashMap.remove(KEY_MAIN_DOWNLOAD_SIZE);
        if (remove3 != null) {
            j2 = remove3;
        }
        long size = j2.longValue();
        if (size > 0) {
            long j3 = endTime - startTime;
            boolean z = false;
            if (0 <= j3 && j3 < 30001) {
                z = true;
            }
            if (z) {
                PerformanceObserverManager.dispatchLoadPackageEvent$default(PerformanceObserverManager.INSTANCE, size, startTime, endTime, (String) null, 8, (Object) null);
            }
        }
    }

    public final void sendSubPkgDownloadInfoToSwanJs() {
        ConcurrentHashMap<String, Long> concurrentHashMap = mCacheMap;
        Long remove = concurrentHashMap.remove(KEY_SUB_DOWNLOAD_START);
        long j2 = 0L;
        if (remove == null) {
            remove = 0L;
        }
        long startTime = remove.longValue();
        Long remove2 = concurrentHashMap.remove(KEY_SUB_DOWNLOAD_END);
        if (remove2 == null) {
            remove2 = 0L;
        }
        long endTime = remove2.longValue();
        Long remove3 = concurrentHashMap.remove(KEY_SUB_DOWNLOAD_SIZE);
        if (remove3 != null) {
            j2 = remove3;
        }
        long size = j2.longValue();
        String subPkgName = mSubPkgName;
        mSubPkgName = "";
        boolean z = true;
        if ((subPkgName.length() > 0) && size > 0) {
            long j3 = endTime - startTime;
            if (0 > j3 || j3 >= 30001) {
                z = false;
            }
            if (z) {
                PerformanceObserverManager.INSTANCE.dispatchLoadPackageEvent(size, startTime, endTime, subPkgName);
            }
        }
    }
}
