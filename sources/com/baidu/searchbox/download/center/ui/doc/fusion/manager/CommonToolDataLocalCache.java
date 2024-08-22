package com.baidu.searchbox.download.center.ui.doc.fusion.manager;

import com.baidu.android.util.io.StreamUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0006¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/doc/fusion/manager/CommonToolDataLocalCache;", "", "()V", "prepareCacheFile", "Ljava/io/File;", "fileName", "", "prepareTemplateCacheFile", "prepareTipsCacheFile", "readCacheFile", "cacheFile", "readCommonToolData", "readTips", "resetCommonToolData", "", "resetTips", "storeCommonToolData", "templateDataStr", "storeTips", "tipsDataStr", "Companion", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonToolDataLocalCache.kt */
public final class CommonToolDataLocalCache {
    private static final String CACHE_PATH = "download_center_doc_sec";
    private static final String COMMON_TOOL_CACHE_FILE_NAME = "common_tool.json";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TIPS_CACHE_FILE_NAME = "common_tool_tips.json";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/doc/fusion/manager/CommonToolDataLocalCache$Companion;", "", "()V", "CACHE_PATH", "", "COMMON_TOOL_CACHE_FILE_NAME", "TIPS_CACHE_FILE_NAME", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommonToolDataLocalCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String readCommonToolData() {
        File cacheFile = prepareTemplateCacheFile();
        if (cacheFile == null) {
            return null;
        }
        return readCacheFile(cacheFile);
    }

    public final void storeCommonToolData(String templateDataStr) {
        Intrinsics.checkNotNullParameter(templateDataStr, "templateDataStr");
        File cacheFile = prepareTemplateCacheFile();
        if (cacheFile != null) {
            byte[] bytes = templateDataStr.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            StreamUtils.bytesToFile(bytes, cacheFile);
        }
    }

    public final void resetCommonToolData() {
        storeCommonToolData("");
    }

    public final String readTips() {
        File cacheFile = prepareTipsCacheFile();
        if (cacheFile == null) {
            return null;
        }
        return readCacheFile(cacheFile);
    }

    public final void storeTips(String tipsDataStr) {
        Intrinsics.checkNotNullParameter(tipsDataStr, "tipsDataStr");
        File cacheFile = prepareTipsCacheFile();
        if (cacheFile != null) {
            byte[] bytes = tipsDataStr.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            StreamUtils.bytesToFile(bytes, cacheFile);
        }
    }

    public final void resetTips() {
        storeTips("");
    }

    private final File prepareTemplateCacheFile() {
        return prepareCacheFile(COMMON_TOOL_CACHE_FILE_NAME);
    }

    private final File prepareTipsCacheFile() {
        return prepareCacheFile(TIPS_CACHE_FILE_NAME);
    }

    private final File prepareCacheFile(String fileName) {
        File filesDir = AppRuntime.getAppContext().getFilesDir();
        if (filesDir == null) {
            return null;
        }
        File cacheDir = new File(filesDir, CACHE_PATH);
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        File cacheFile = new File(cacheDir, fileName);
        try {
            if (!cacheFile.exists()) {
                cacheFile.createNewFile();
            }
            return cacheFile;
        } catch (Exception ioException) {
            if (AppConfig.isDebug()) {
                ioException.printStackTrace();
            }
            File file = null;
            return null;
        }
    }

    private final String readCacheFile(File cacheFile) {
        FileInputStream cacheFileStream;
        try {
            cacheFileStream = new FileInputStream(cacheFile);
        } catch (Exception fileNotFoundException) {
            if (AppConfig.isDebug()) {
                fileNotFoundException.printStackTrace();
            }
            FileInputStream fileInputStream = null;
            cacheFileStream = null;
        }
        if (cacheFileStream == null) {
            return null;
        }
        String localCache = StreamUtils.streamToString(cacheFileStream);
        CharSequence charSequence = localCache;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return localCache;
        }
        String str = null;
        return null;
    }
}
