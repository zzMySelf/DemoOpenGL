package com.baidu.swan.card.storage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.storage.SwanAppStorage;
import com.baidu.swan.card.storage.sp.SwanAppSharedPrefsWrapper;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.utils.SwanAppFileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SwanCardStorage {
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final int ERR_CODE_STORAGE_EXCEED_LENGTH = 1003;
    public static final int INVALID_INDEX = -1;
    public static final String LOG_TAG = "SwanCardStorage";
    private static final int MAX_KEY_BYTE_SIZE = 512;
    public static final int MAX_SIZE_LIMIT = 10485760;
    public static final int MAX_VALUE_BYTE_SIZE = 3145728;
    public static final String MSG_KEY_EXCEED_LENGTH = "exceed storage key max length";
    public static final String MSG_STORAGE_EXCEED_LENGTH = "exceed storage max length";
    public static final String MSG_VALUE_EXCEED_LENGTH = "exceed storage item max length";
    public static final int ONE_INCREAMENT = 1;
    public static final int SIZE_BUFFER = 1024;
    public static final String SWAN_APP_PREFIX = "aiapp_";
    private final String mAppId;
    private volatile SwanAppSharedPrefsWrapper mPref;
    public final String name;
    public final String prefName;

    public SwanCardStorage(String appId) {
        this.mAppId = appId;
        String storageName = StorageUtil.getStorageName(appId);
        this.name = storageName;
        this.prefName = "aiapp_" + storageName;
    }

    public boolean available() {
        return currentSize() < limitSize();
    }

    public SwanAppSharedPrefsWrapper getReferences() {
        if (this.mPref == null) {
            synchronized (this) {
                if (this.mPref == null) {
                    this.mPref = new SwanAppSharedPrefsWrapper(this.prefName, true);
                }
            }
        }
        return this.mPref;
    }

    public void clear() {
        clear(false);
    }

    public void clear(boolean isUseCommit) {
        if (isUseCommit) {
            getReferences().edit().clear().commit();
        } else {
            getReferences().edit().clear().apply();
        }
        SwanAppFileUtils.deleteFile(StorageUtil.getSwanAppTmpDirectory(this.mAppId));
        SwanAppFileUtils.deleteFile(StorageUtil.getSwanAppStoreDirectory(this.mAppId));
    }

    public int checkFilePath(String filePath) {
        File f2 = new File(filePath);
        if (!f2.exists() || !f2.isFile()) {
            return 2001;
        }
        if (f2.length() > 10485760) {
            return 2002;
        }
        return 2000;
    }

    public String getFileName(String path) {
        if (TextUtils.isEmpty(path) || path.endsWith(File.separator)) {
            return null;
        }
        int start = path.lastIndexOf(File.separator);
        int end = path.length();
        if (start == -1 || end <= start) {
            return null;
        }
        return path.substring(start + 1, end);
    }

    public String saveFile(String tempFilePath) {
        String savedFilePath;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        String swanAppDir = StorageUtil.getSwanAppStoreDirectory(this.mAppId);
        if (TextUtils.isEmpty(swanAppDir)) {
            return "";
        }
        try {
            File saveFile = getStorageFile(swanAppDir, getFileName(tempFilePath));
            fis = new FileInputStream(new File(tempFilePath));
            fos = new FileOutputStream(saveFile);
            byte[] tempBuffer = new byte[1024];
            while (true) {
                int read = fis.read(tempBuffer);
                int len = read;
                if (read == -1) {
                    break;
                }
                fos.write(tempBuffer, 0, len);
                fos.flush();
            }
            savedFilePath = saveFile.getAbsolutePath();
        } catch (FileNotFoundException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            savedFilePath = "";
        } catch (IOException e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            savedFilePath = "";
        } catch (Throwable th2) {
            SwanAppFileUtils.closeSafely((Closeable) null);
            SwanAppFileUtils.closeSafely((Closeable) null);
            throw th2;
        }
        SwanAppFileUtils.closeSafely(fis);
        SwanAppFileUtils.closeSafely(fos);
        return savedFilePath;
    }

    private File getStorageFile(String dir, String fileName) {
        File f2 = new File(dir);
        if (!f2.exists()) {
            f2.mkdirs();
        }
        return new File(dir, fileName);
    }

    public FileInfo getSavedFileInfo(String filePath) {
        File file = new File(filePath);
        if (!file.isFile()) {
            return null;
        }
        FileInfo info = new FileInfo();
        info.setSize(file.length());
        info.setCreatedTime(file.lastModified());
        return info;
    }

    public List<FileInfo> getSavedFileList() {
        String dir = StorageUtil.getSwanAppStoreDirectory(this.mAppId);
        if (TextUtils.isEmpty(dir)) {
            return null;
        }
        return getSavedFileList(dir);
    }

    public List<FileInfo> getSavedFileList(String dir) {
        if (DEBUG) {
            Log.d(SwanAppStorage.LOG_TAG, "——> getSavedFileList:  dir " + dir);
        }
        File root = new File(dir);
        if (!root.exists() || !root.isDirectory()) {
            return null;
        }
        return getSavedFileList(root);
    }

    public List<FileInfo> getSavedFileList(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (DEBUG) {
            Log.d(SwanAppStorage.LOG_TAG, "——> getSavedFileList: " + file.getAbsolutePath());
        }
        FileInfo info = new FileInfo();
        List<FileInfo> fileInfos = new ArrayList<>();
        if (file.isFile()) {
            info.setPath(file.getAbsolutePath());
            info.setSize(file.length());
            info.setCreatedTime(file.lastModified());
            fileInfos.add(info);
        } else {
            File[] files = file.listFiles();
            if (files == null) {
                return null;
            }
            for (File f2 : files) {
                List<FileInfo> tempInfos = getSavedFileList(f2);
                if (tempInfos != null) {
                    fileInfos.addAll(fileInfos.size(), tempInfos);
                }
            }
        }
        return fileInfos;
    }

    public long currentSize() {
        if (DEBUG) {
            File mPrefFile = getReferences().getFile();
            Log.i(LOG_TAG, this.name + " exists = " + mPrefFile.exists() + " isFile = " + mPrefFile.isFile() + " path = " + mPrefFile.getPath() + " size = " + mPrefFile.length());
        }
        return getReferences().getContentSize();
    }

    public long limitSize() {
        return 10485760;
    }

    public boolean isOverLimit(String key, String value) {
        return (currentSize() - ((long) getReferences().getString(key, "").length())) + ((long) value.length()) > limitSize();
    }

    public static boolean checkKeyInvalid(String key) {
        return key.getBytes(StandardCharsets.UTF_8).length > 512;
    }

    public static boolean checkValueInvalid(String value) {
        return value.getBytes(StandardCharsets.UTF_8).length > 3145728;
    }
}
