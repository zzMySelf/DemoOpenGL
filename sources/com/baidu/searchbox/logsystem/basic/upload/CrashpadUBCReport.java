package com.baidu.searchbox.logsystem.basic.upload;

import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.monitor.LokiConfig;
import com.baidu.monitor.MonitorUploadFileProvider;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;

public class CrashpadUBCReport {
    private static final String CRASHPAD_UBC_ROOT_DIR = "crashpad_ubc";
    private static final String DEFAULT_LOG_STORE_ROOT_DIR = "log_store";
    private static final String GZIP_TMP_UPLOAD_FILE_SUFFIX = ".gzip.tmp";
    private static final String GZIP_UPLOAD_FILE_SUFFIX = ".gzip";
    private static final long TMP_FILE_DELETE_THRESHOLD = 15000;
    private static final String TMP_UPLOAD_FILE_SUFFIX = ".tmp";
    private static final String UBC_ID = "6514";
    private static final String UPLOAD_FILE_SUFFIX = ".upload";
    private static volatile CrashpadUBCReport sInstance = null;
    private File sCrashpadUBCRootDir = null;

    private CrashpadUBCReport() {
        try {
            File crashpadUBCRootDir = new File(new File(AppRuntime.getAppContext().getFilesDir(), DEFAULT_LOG_STORE_ROOT_DIR), CRASHPAD_UBC_ROOT_DIR);
            if (crashpadUBCRootDir.exists() || crashpadUBCRootDir.mkdirs()) {
                this.sCrashpadUBCRootDir = crashpadUBCRootDir;
            }
        } catch (Throwable th2) {
        }
    }

    private static CrashpadUBCReport getInstance() {
        if (sInstance == null) {
            synchronized (CrashpadUBCReport.class) {
                if (sInstance == null) {
                    sInstance = new CrashpadUBCReport();
                }
            }
        }
        return sInstance;
    }

    public static void reportCrash(String fileName, boolean isReUpload) {
        if (LLog.sDebug) {
            Log.d("CRASHPAD", "CrashpadUBCReport reportCrash: fileName=" + fileName + ", isReUpload=" + isReUpload + ", LokiConfig.enableCrashpadUBC()=" + LokiConfig.enableCrashpadUBC());
        }
        if (LokiConfig.enableCrashpadUBC()) {
            getInstance().doReportCrash(fileName);
            if (isReUpload) {
                reUpload();
            }
        }
    }

    private static void reUpload() {
        getInstance().doReUpload();
    }

    public static boolean isLokiServiceFirst() {
        return LokiConfig.isLokiServiceFirst();
    }

    public static boolean isPerfUBCFirst() {
        return LokiConfig.isPerfUBCFirst();
    }

    private void doReportCrash(String filePath) {
        File uploadFile;
        if (this.sCrashpadUBCRootDir != null && !TextUtils.isEmpty(filePath)) {
            String fileName = new File(filePath).getName();
            if (!TextUtils.isEmpty(fileName) && (uploadFile = createUploadUBCFile(fileName)) != null && uploadFile.exists() && uploadSync(uploadFile)) {
                uploadFile.delete();
                reUpload();
            }
        }
    }

    private void doReUpload() {
        File[] uploadFiles;
        File uploadFile;
        File file = this.sCrashpadUBCRootDir;
        if (file != null && file.exists() && (uploadFiles = this.sCrashpadUBCRootDir.listFiles()) != null && uploadFiles.length != 0) {
            for (File file2 : uploadFiles) {
                if (file2 != null) {
                    try {
                        if (file2.exists()) {
                            if (!file2.isDirectory()) {
                                String fileName = file2.getName();
                                if (TextUtils.isEmpty(fileName)) {
                                    file2.delete();
                                } else {
                                    if (!fileName.endsWith(".tmp")) {
                                        if (!fileName.endsWith(GZIP_TMP_UPLOAD_FILE_SUFFIX)) {
                                            if (fileName.endsWith(GZIP_UPLOAD_FILE_SUFFIX)) {
                                                if (uploadSync(file2)) {
                                                    file2.delete();
                                                }
                                            } else if (fileName.endsWith(UPLOAD_FILE_SUFFIX) && (uploadFile = createUBCGzipFile(file2)) != null) {
                                                file2.delete();
                                                if (uploadSync(uploadFile)) {
                                                    uploadFile.delete();
                                                }
                                            }
                                        }
                                    }
                                    if (System.currentTimeMillis() - file2.lastModified() > 15000) {
                                        file2.delete();
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                    }
                }
            }
        }
    }

    private File createUploadUBCFile(String fileName) {
        File ubcFile = createUBCJsonFile(fileName);
        if (ubcFile == null) {
            return null;
        }
        File uploadFile = createUBCGzipFile(ubcFile);
        if (uploadFile != null) {
            ubcFile.delete();
        }
        return uploadFile;
    }

    private File createUBCJsonFile(String fileName) {
        CrashContext crashContext = parseCrashContextFromFileName(fileName);
        if (crashContext == null) {
            return null;
        }
        JsonWriter writer = null;
        File tmpFile = null;
        try {
            tmpFile = new File(this.sCrashpadUBCRootDir, fileName + ".tmp");
            if (!tmpFile.exists() || tmpFile.delete()) {
                tmpFile.createNewFile();
                if (!tmpFile.exists()) {
                    Closeables.closeSafely((Closeable) null);
                    return null;
                }
                writer = new JsonWriter(new FileWriter(tmpFile));
                writer.beginObject();
                writer.name("data");
                writer.beginArray();
                writer.beginObject();
                writer.name("id").value(UBC_ID);
                writer.name("timestamp").value(System.currentTimeMillis());
                writer.name("idtype").value("1");
                writer.name("type").value("0");
                writer.name("isreal").value("1");
                writer.name("content");
                writer.beginObject();
                writer.name(MonitorUploadFileProvider.UBCConstant.CRASH_TIME).value(crashContext.crashTime);
                writer.name("appVersion").value(crashContext.appVersion);
                writer.name("osVersion").value(crashContext.osVersion);
                writer.name("fileName").value(fileName);
                writer.endObject();
                writer.endObject();
                writer.endArray();
                writer.endObject();
                writer.flush();
                File dstFile = new File(this.sCrashpadUBCRootDir, fileName + UPLOAD_FILE_SUFFIX);
                if (tmpFile.renameTo(dstFile)) {
                    tmpFile.delete();
                    Closeables.closeSafely((Closeable) writer);
                    return dstFile;
                }
                Closeables.closeSafely((Closeable) writer);
                return null;
            }
            Closeables.closeSafely((Closeable) null);
            return null;
        } catch (Throwable th2) {
            Closeables.closeSafely((Closeable) null);
            throw th2;
        }
    }

    private File createUBCGzipFile(File uploadFile) {
        File gzipTmp = new File(uploadFile.getAbsolutePath() + GZIP_TMP_UPLOAD_FILE_SUFFIX);
        File gzipFile = new File(uploadFile.getAbsolutePath() + GZIP_UPLOAD_FILE_SUFFIX);
        Utility.createNewEmptyFile(gzipTmp);
        if (!gzipTmp.exists() || !ContentUtil.gzipContent(uploadFile, gzipTmp)) {
            return null;
        }
        gzipTmp.renameTo(gzipFile);
        if (gzipFile.exists()) {
            return gzipFile;
        }
        return null;
    }

    private boolean uploadSync(File ubcFile) {
        BaseContentUploader supplyUploader;
        ResponseEntity contentResponse;
        try {
            BaseContentUploader defaultUploader = UploaderProvider.getDefaultContentUploader();
            ResponseEntity contentResponse2 = defaultUploader.uploadSync(ubcFile);
            boolean success = false;
            if (contentResponse2 != null) {
                success = contentResponse2.isSuccess();
            }
            if (success || (supplyUploader = UploaderProvider.getContentUploader()) == defaultUploader || (contentResponse = supplyUploader.uploadSync(ubcFile)) == null) {
                return success;
            }
            return contentResponse.isSuccess();
        } catch (Throwable th2) {
            return false;
        }
    }

    private static class CrashContext {
        String appVersion;
        String crashTime;
        String osVersion;

        private CrashContext() {
        }
    }

    private CrashContext parseCrashContextFromFileName(String originFileName) {
        String[] fileNameItems;
        String fileName = originFileName.substring(0, originFileName.indexOf(".bdmp") - 1);
        if (TextUtils.isEmpty(fileName) || (fileNameItems = fileName.split("-")) == null || fileNameItems.length < 10) {
            return null;
        }
        String appVersion = fileNameItems[0];
        String osVersion = fileNameItems[7];
        String crashTime = fileNameItems[9];
        CrashContext crashContext = new CrashContext();
        String str = "0";
        crashContext.appVersion = TextUtils.isEmpty(appVersion) ? str : appVersion;
        crashContext.osVersion = TextUtils.isEmpty(osVersion) ? str : osVersion;
        if (!TextUtils.isEmpty(crashTime)) {
            str = crashTime;
        }
        crashContext.crashTime = str;
        return crashContext;
    }
}
