package com.baidu.searchbox.download.center.clearcache.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/model/ExceptionStatsConfigUtils;", "", "()V", "DEFAULT_BAIDU_SIZE_THRESHOLD", "", "DEFAULT_BIG_DIRS_FILES_ENABLE", "", "DEFAULT_BIG_DIRS_THRESHOLD", "DEFAULT_BIG_FILES_THRESHOLD", "DISK_EXCEPTION_CONFIG_VERSION", "", "SP_KEY_BAIDU_SIZE_THRESHOLD", "SP_KEY_BIG_DIRS_FILES_ENABLE", "SP_KEY_BIG_DIRS_THRESHOLD", "SP_KEY_BIG_FILES_THRESHOLD", "getBadiuSizeThreshold", "getBigDirsThreshold", "getBigFilesThreshold", "isBigDirsFilesEnable", "saveData", "", "data", "Lorg/json/JSONObject;", "lib-clearcache-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExceptionStatsConfigUtils.kt */
public final class ExceptionStatsConfigUtils {
    public static final long DEFAULT_BAIDU_SIZE_THRESHOLD = 5000;
    public static final boolean DEFAULT_BIG_DIRS_FILES_ENABLE = false;
    public static final long DEFAULT_BIG_DIRS_THRESHOLD = 500;
    public static final long DEFAULT_BIG_FILES_THRESHOLD = 100;
    public static final String DISK_EXCEPTION_CONFIG_VERSION = "disk_exception_config_version";
    public static final ExceptionStatsConfigUtils INSTANCE = new ExceptionStatsConfigUtils();
    public static final String SP_KEY_BAIDU_SIZE_THRESHOLD = "baidu_size_threshold";
    public static final String SP_KEY_BIG_DIRS_FILES_ENABLE = "big_dirs_files_enable";
    public static final String SP_KEY_BIG_DIRS_THRESHOLD = "big_dirs_threshold";
    public static final String SP_KEY_BIG_FILES_THRESHOLD = "big_files_threshold";

    private ExceptionStatsConfigUtils() {
    }

    public final void saveData(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        DiskManagerSharedPrefsUtils.INSTANCE.putBoolean(SP_KEY_BIG_DIRS_FILES_ENABLE, data.optBoolean("bigDirsFilesEnable", false));
        DiskManagerSharedPrefsUtils.INSTANCE.putLong(SP_KEY_BAIDU_SIZE_THRESHOLD, data.optLong("baiduSizeThreshold", 5000));
        DiskManagerSharedPrefsUtils.INSTANCE.putLong(SP_KEY_BIG_DIRS_THRESHOLD, data.optLong("bigDirsThreshold", 500));
        DiskManagerSharedPrefsUtils.INSTANCE.putLong(SP_KEY_BIG_FILES_THRESHOLD, data.optLong("bigFilesThreshold", 100));
    }

    public final boolean isBigDirsFilesEnable() {
        return DiskManagerSharedPrefsUtils.INSTANCE.getBoolean(SP_KEY_BIG_DIRS_FILES_ENABLE, false);
    }

    public final long getBadiuSizeThreshold() {
        long j2 = (long) 1024;
        return DiskManagerSharedPrefsUtils.INSTANCE.getLong(SP_KEY_BAIDU_SIZE_THRESHOLD, 5000) * j2 * j2;
    }

    public final long getBigDirsThreshold() {
        long j2 = (long) 1024;
        return DiskManagerSharedPrefsUtils.INSTANCE.getLong(SP_KEY_BIG_DIRS_THRESHOLD, 500) * j2 * j2;
    }

    public final long getBigFilesThreshold() {
        long j2 = (long) 1024;
        return DiskManagerSharedPrefsUtils.INSTANCE.getLong(SP_KEY_BIG_FILES_THRESHOLD, 100) * j2 * j2;
    }
}
