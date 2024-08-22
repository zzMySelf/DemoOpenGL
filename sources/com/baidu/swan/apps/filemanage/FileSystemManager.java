package com.baidu.swan.apps.filemanage;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.swan.apps.filemanage.SwanGameFileSystemUtils;
import com.baidu.swan.apps.storage.filesystem.FileSystemConstants;
import com.baidu.swan.apps.storage.filesystem.ISwanFilePaths;
import com.baidu.swan.apps.storage.filesystem.ISwanFileSizeTracker;
import com.baidu.swan.utils.SwanAppFileUtils;
import com.baidu.swan.utils.SwanAppMD5Utils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FileSystemManager extends FileSystemConstants {
    private static final int BYTE_LENGTH = 1024;
    public static final int DATA_POSITION = 0;
    public static final String ENCODE_ASCII = "ascii";
    public static final String ENCODE_BASE64 = "base64";
    public static final String ENCODE_BINARY = "binary";
    public static final String ENCODE_HEX = "hex";
    public static final String ENCODE_LATIN1 = "latin1";
    public static final String ENCODE_UCS2 = "ucs2";
    public static final String ENCODE_UCS_2 = "ucs-2";
    public static final String ENCODE_UTF16LE = "utf16le";
    public static final String ENCODE_UTF8 = "utf8";
    public static final String ENCODE_UTF_16LE = "utf-16le";
    public static final String ENCODE_UTF_8 = "utf-8";
    public static final int ENCODING_POSITION = 1;
    private static List<String> encodeList;
    private Context mContext;
    private final ISwanFileSizeTracker mFileSizeTracker;
    private String mJsCodePath;
    private final ISwanFilePaths mPathProvider;
    private final String mRecordPath;

    static {
        ArrayList arrayList = new ArrayList();
        encodeList = arrayList;
        arrayList.add(ENCODE_ASCII);
        encodeList.add("base64");
        encodeList.add("binary");
        encodeList.add(ENCODE_HEX);
        encodeList.add("utf-8");
        encodeList.add(ENCODE_UTF8);
        encodeList.add(ENCODE_LATIN1);
        encodeList.add(ENCODE_UCS2);
        encodeList.add(ENCODE_UCS_2);
        encodeList.add(ENCODE_UTF16LE);
        encodeList.add(ENCODE_UTF_16LE);
    }

    public FileSystemManager(Context context, String jsCodePath) {
        this.mContext = context;
        this.mJsCodePath = jsCodePath;
        SwanGameFilePaths swanGameFilePaths = new SwanGameFilePaths();
        this.mPathProvider = swanGameFilePaths;
        SwanGameFileSystemUtils.mkAllBaseDir(SwanGameFileSystemUtils.getBasePath(), SwanGameFileSystemUtils.getCodePath());
        this.mFileSizeTracker = swanGameFilePaths.getFileSizeTracker();
        this.mRecordPath = new File(swanGameFilePaths.getUsrDirectory(), "record.pro").getAbsolutePath();
    }

    public FileSystemManager(Context context, String jsCodePath, ISwanFilePaths pathProvider) {
        this.mContext = context;
        this.mJsCodePath = jsCodePath;
        this.mPathProvider = pathProvider;
        this.mFileSizeTracker = pathProvider.getFileSizeTracker();
        this.mRecordPath = new File(pathProvider.getUsrDirectory(), "record.pro").getAbsolutePath();
    }

    private String getFullPath(String relativePath) {
        String str;
        if (TextUtils.isEmpty(relativePath)) {
            return "";
        }
        if (relativePath.startsWith("bdfile://code")) {
            if (this.mJsCodePath.endsWith(File.separator)) {
                String str2 = this.mJsCodePath;
                str = str2.substring(0, str2.length() - 1);
            } else {
                str = this.mJsCodePath;
            }
            this.mJsCodePath = str;
            return this.mJsCodePath + relativePath.substring("bdfile://code".length());
        } else if (relativePath.startsWith("bdfile://")) {
            return this.mPathProvider.schemeToRealPath(relativePath);
        } else {
            return "";
        }
    }

    private FileErrorMsg judgeWritePermission(String path) {
        FileErrorMsg errorMsg = getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + path);
        if (!TextUtils.isEmpty(path) && !SwanGameFileSystemUtils.isFrameworkPath(path) && path.startsWith("bdfile://usr")) {
            return null;
        }
        return errorMsg;
    }

    private FileErrorMsg getErrorMsg(int errCode, String errMsg) {
        FileErrorMsg errorMsg = new FileErrorMsg();
        errorMsg.errCode = errCode;
        errorMsg.errMsg = errMsg;
        return errorMsg;
    }

    private FileErrorMsg getFileNotExsitMsg(String filePath, boolean isJudgeFile) {
        if (TextUtils.isEmpty(filePath)) {
            FileErrorMsg errorMsg = new FileErrorMsg();
            errorMsg.errCode = -1;
            errorMsg.errMsg = FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + filePath;
            return errorMsg;
        }
        String fullPath = getFullPath(filePath);
        if (TextUtils.isEmpty(filePath)) {
            FileErrorMsg errorMsg2 = new FileErrorMsg();
            errorMsg2.errCode = -1;
            errorMsg2.errMsg = FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + filePath;
            return errorMsg2;
        }
        File file = new File(fullPath);
        if (!file.exists()) {
            FileErrorMsg errorMsg3 = new FileErrorMsg();
            errorMsg3.errCode = -1;
            errorMsg3.errMsg = FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + filePath;
            return errorMsg3;
        } else if (!isJudgeFile || file.isFile()) {
            return null;
        } else {
            FileErrorMsg errorMsg4 = new FileErrorMsg();
            errorMsg4.errCode = -1;
            errorMsg4.errMsg = FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + filePath;
            return errorMsg4;
        }
    }

    private FileErrorMsg getParentDirNotExsitMsg(String path, boolean recursive) {
        if (path.endsWith(File.separator)) {
            path = path.substring(0, path.length() - 1);
        }
        String fullPath = getFullPath(path);
        if (TextUtils.isEmpty(fullPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + path);
        }
        if (!fullPath.contains(File.separator)) {
            return null;
        }
        File parentFile = new File(fullPath.substring(0, fullPath.lastIndexOf(File.separator)));
        if (recursive) {
            return null;
        }
        if (!parentFile.exists() || (parentFile.exists() && parentFile.isFile())) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + path);
        }
        return null;
    }

    public FileErrorMsg mkdir(String dirPath, boolean recursive, boolean isSync) {
        String emptyStringErrorContent;
        String nullErrorContent;
        boolean result;
        if (isSync) {
            emptyStringErrorContent = "dirPath must be a string";
        } else {
            emptyStringErrorContent = FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + dirPath;
        }
        if (isSync) {
            nullErrorContent = FileErrorMsg.PATH_NULL_HINT;
        } else {
            nullErrorContent = "fail parameter error: parameter.dirPath should be String instead of Object;";
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(dirPath, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        FileErrorMsg errorMsg2 = judgeWritePermission(dirPath);
        if (errorMsg2 != null) {
            return errorMsg2;
        }
        if (!SwanGameFileSystemUtils.isValidPath(dirPath)) {
            return getErrorMsg(-4, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + dirPath);
        }
        String fullPath = getFullPath(dirPath);
        if (TextUtils.isEmpty(fullPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + dirPath);
        }
        FileErrorMsg errorMsg3 = getParentDirNotExsitMsg(dirPath, recursive);
        if (errorMsg3 != null) {
            return errorMsg3;
        }
        File file = new File(fullPath);
        if (file.exists()) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_FILE_ALREADY_EXISTS + dirPath);
        }
        if (recursive) {
            try {
                result = file.mkdirs();
            } catch (Exception e2) {
                return getErrorMsg(-1, "fail");
            }
        } else {
            result = file.mkdir();
        }
        if (!result) {
            return getErrorMsg(-1, "fail");
        }
        return getErrorMsg(0, "ok");
    }

    public FileErrorMsg writeFile(boolean isSync, String filePath, Object data, String encoding) {
        String emptyStringErrorContent;
        String nullErrorContent;
        if (isSync) {
            emptyStringErrorContent = "filePath must be a string";
        } else {
            emptyStringErrorContent = FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + filePath;
        }
        if (isSync) {
            nullErrorContent = FileErrorMsg.PATH_NULL_HINT;
        } else {
            nullErrorContent = "fail parameter error: parameter.dirPath should be String instead of Object;";
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(filePath, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        return writeFile(filePath, data, encoding, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0191 A[SYNTHETIC, Splitter:B:84:0x0191] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01a1 A[SYNTHETIC, Splitter:B:88:0x01a1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.swan.apps.filemanage.FileErrorMsg writeFile(java.lang.String r21, java.lang.Object r22, java.lang.String r23, boolean r24) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r24
            com.baidu.swan.apps.filemanage.FileErrorMsg r0 = r20.judgeWritePermission(r21)
            if (r0 == 0) goto L_0x000f
            return r0
        L_0x000f:
            r5 = -1
            if (r3 != 0) goto L_0x0019
            java.lang.String r6 = "The argument must be string or arrayBuffer"
            com.baidu.swan.apps.filemanage.FileErrorMsg r5 = r1.getErrorMsg(r5, r6)
            return r5
        L_0x0019:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "bdfile://usr"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = java.io.File.separator
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            int r6 = r6.length()
            boolean r7 = com.baidu.swan.apps.filemanage.SwanGameFileSystemUtils.isValidPath(r21)
            if (r7 != 0) goto L_0x0055
            r5 = -4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "fail permission denied, open "
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = r2.substring(r6)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.baidu.swan.apps.filemanage.FileErrorMsg r5 = r1.getErrorMsg(r5, r7)
            return r5
        L_0x0055:
            boolean r7 = r3 instanceof byte[]
            if (r7 != 0) goto L_0x0063
            boolean r8 = android.text.TextUtils.isEmpty(r23)
            if (r8 == 0) goto L_0x0063
            java.lang.String r8 = "utf-8"
            goto L_0x0065
        L_0x0063:
            r8 = r23
        L_0x0065:
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x00a3
            java.lang.String r9 = r8.toLowerCase()
            java.lang.String r10 = "binary"
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L_0x0079
            java.lang.String r8 = "latin1"
        L_0x0079:
            java.util.List<java.lang.String> r9 = encodeList
            java.lang.String r10 = r8.toLowerCase()
            boolean r9 = r9.contains(r10)
            if (r9 != 0) goto L_0x00a3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "fail invalid encoding \""
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r8)
            java.lang.String r10 = "\""
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.baidu.swan.apps.filemanage.FileErrorMsg r5 = r1.getErrorMsg(r5, r9)
            return r5
        L_0x00a3:
            r9 = 0
            r10 = 0
            r11 = 0
            com.baidu.swan.apps.filemanage.FileErrorMsg r0 = r1.getParentDirNotExsitMsg(r2, r11)
            if (r0 == 0) goto L_0x00ad
            return r0
        L_0x00ad:
            java.lang.String r12 = r20.getFullPath(r21)
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r13 == 0) goto L_0x00d3
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = "fail no such file or directory "
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.String r13 = r2.substring(r6)
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.String r11 = r11.toString()
            com.baidu.swan.apps.filemanage.FileErrorMsg r5 = r1.getErrorMsg(r5, r11)
            return r5
        L_0x00d3:
            r13 = 0
            java.io.File r15 = new java.io.File
            r15.<init>(r12)
            boolean r16 = r15.exists()
            if (r16 == 0) goto L_0x00ff
            boolean r16 = r15.isDirectory()
            if (r16 == 0) goto L_0x00ff
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r5 = " fail illegal operation on a directory, open "
            java.lang.StringBuilder r5 = r11.append(r5)
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r5 = r5.toString()
            r11 = -1
            com.baidu.swan.apps.filemanage.FileErrorMsg r5 = r1.getErrorMsg(r11, r5)
            return r5
        L_0x00ff:
            long r17 = com.baidu.swan.apps.filemanage.SwanGameFileSystemUtils.getFileSize((java.io.File) r15)
            java.lang.String r5 = "ok"
            com.baidu.swan.apps.filemanage.FileErrorMsg r5 = r1.getErrorMsg(r11, r5)
            if (r7 != 0) goto L_0x01f6
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01f2, all -> 0x01ed }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01f2, all -> 0x01ed }
            r11 = 2
            if (r0 != 0) goto L_0x0159
            java.lang.String r0 = "base64"
            boolean r0 = android.text.TextUtils.equals(r0, r8)     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            if (r0 == 0) goto L_0x0159
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            byte[] r0 = android.util.Base64.decode(r0, r11)     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            int r11 = r0.length     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            long r13 = (long) r11     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            com.baidu.swan.apps.storage.filesystem.ISwanFileSizeTracker r11 = r1.mFileSizeTracker     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            boolean r11 = r11.isOverLimit(r13)     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            if (r11 == 0) goto L_0x013f
            java.lang.String r11 = r20.obtainOverLimitErrorMessage()     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            r2 = -1
            com.baidu.swan.apps.filemanage.FileErrorMsg r2 = r1.getErrorMsg(r2, r11)     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r9)
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r10)
            return r2
        L_0x013f:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            r2.<init>(r15, r4)     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            r10 = r2
            r10.write(r0)     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            r10.flush()     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            r19 = r5
            goto L_0x0221
        L_0x014f:
            r0 = move-exception
            r19 = r5
            goto L_0x0265
        L_0x0154:
            r0 = move-exception
            r19 = r5
            goto L_0x0254
        L_0x0159:
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01f2, all -> 0x01ed }
            java.lang.String[] r0 = com.baidu.swan.apps.filemanage.SwanGameFileSystemUtils.getDataAndEncoding(r0, r8)     // Catch:{ Exception -> 0x01f2, all -> 0x01ed }
            if (r0 == 0) goto L_0x017a
            int r2 = r0.length     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            if (r2 == r11) goto L_0x0166
            goto L_0x017a
        L_0x0166:
            r2 = 0
            r2 = r0[r2]     // Catch:{ Exception -> 0x0154, all -> 0x014f }
            r3 = 1
            r3 = r0[r3]     // Catch:{ Exception -> 0x0174, all -> 0x016e }
            r8 = r3
            goto L_0x0180
        L_0x016e:
            r0 = move-exception
            r3 = r2
            r19 = r5
            goto L_0x0265
        L_0x0174:
            r0 = move-exception
            r3 = r2
            r19 = r5
            goto L_0x0254
        L_0x017a:
            java.lang.String r2 = ""
            java.lang.String r3 = "utf-8"
            r8 = r3
        L_0x0180:
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            int r3 = r3.length     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            long r13 = (long) r3     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            com.baidu.swan.apps.storage.filesystem.ISwanFileSizeTracker r3 = r1.mFileSizeTracker     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            boolean r3 = r3.isOverLimit(r13)     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            if (r3 == 0) goto L_0x01a1
            java.lang.String r3 = r20.obtainOverLimitErrorMessage()     // Catch:{ Exception -> 0x0174, all -> 0x016e }
            r11 = -1
            com.baidu.swan.apps.filemanage.FileErrorMsg r3 = r1.getErrorMsg(r11, r3)     // Catch:{ Exception -> 0x0174, all -> 0x016e }
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r9)
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r10)
            return r3
        L_0x01a1:
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            boolean r11 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            if (r11 == 0) goto L_0x01b8
            java.io.OutputStreamWriter r11 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0174, all -> 0x016e }
            r23 = r0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0174, all -> 0x016e }
            r0.<init>(r15, r4)     // Catch:{ Exception -> 0x0174, all -> 0x016e }
            r11.<init>(r0)     // Catch:{ Exception -> 0x0174, all -> 0x016e }
            r19 = r5
            goto L_0x01ca
        L_0x01b8:
            r23 = r0
            java.io.OutputStreamWriter r11 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            r0.<init>(r15, r4)     // Catch:{ Exception -> 0x01e7, all -> 0x01e1 }
            r19 = r5
            java.lang.String r5 = r8.toLowerCase()     // Catch:{ Exception -> 0x01dd, all -> 0x01d9 }
            r11.<init>(r0, r5)     // Catch:{ Exception -> 0x01dd, all -> 0x01d9 }
        L_0x01ca:
            r3.<init>(r11)     // Catch:{ Exception -> 0x01dd, all -> 0x01d9 }
            r9 = r3
            r0 = r2
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01dd, all -> 0x01d9 }
            r9.write(r0)     // Catch:{ Exception -> 0x01dd, all -> 0x01d9 }
            r9.flush()     // Catch:{ Exception -> 0x01dd, all -> 0x01d9 }
            r3 = r2
            goto L_0x0221
        L_0x01d9:
            r0 = move-exception
            r3 = r2
            goto L_0x0265
        L_0x01dd:
            r0 = move-exception
            r3 = r2
            goto L_0x0254
        L_0x01e1:
            r0 = move-exception
            r19 = r5
            r3 = r2
            goto L_0x0265
        L_0x01e7:
            r0 = move-exception
            r19 = r5
            r3 = r2
            goto L_0x0254
        L_0x01ed:
            r0 = move-exception
            r19 = r5
            goto L_0x0265
        L_0x01f2:
            r0 = move-exception
            r19 = r5
            goto L_0x0254
        L_0x01f6:
            r19 = r5
            r0 = r3
            byte[] r0 = (byte[]) r0     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
            int r2 = r0.length     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
            long r13 = (long) r2     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
            com.baidu.swan.apps.storage.filesystem.ISwanFileSizeTracker r2 = r1.mFileSizeTracker     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
            boolean r2 = r2.isOverLimit(r13)     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
            if (r2 == 0) goto L_0x0215
            java.lang.String r2 = r20.obtainOverLimitErrorMessage()     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
            r5 = -1
            com.baidu.swan.apps.filemanage.FileErrorMsg r2 = r1.getErrorMsg(r5, r2)     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r9)
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r10)
            return r2
        L_0x0215:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
            r2.<init>(r12, r4)     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
            r10 = r2
            r10.write(r0)     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
            r10.flush()     // Catch:{ Exception -> 0x0253, all -> 0x0251 }
        L_0x0221:
            if (r4 == 0) goto L_0x022d
            com.baidu.swan.apps.storage.filesystem.ISwanFileSizeTracker r0 = r1.mFileSizeTracker     // Catch:{ Exception -> 0x022b }
            r0.writeRecord(r13)     // Catch:{ Exception -> 0x022b }
            r22 = r3
            goto L_0x0236
        L_0x022b:
            r0 = move-exception
            goto L_0x0254
        L_0x022d:
            com.baidu.swan.apps.storage.filesystem.ISwanFileSizeTracker r0 = r1.mFileSizeTracker     // Catch:{ Exception -> 0x024d, all -> 0x0249 }
            r22 = r3
            long r2 = r13 - r17
            r0.writeRecord(r2)     // Catch:{ Exception -> 0x0245, all -> 0x0241 }
        L_0x0236:
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r9)
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r10)
            r3 = r22
            r5 = r19
            goto L_0x0263
        L_0x0241:
            r0 = move-exception
            r3 = r22
            goto L_0x0265
        L_0x0245:
            r0 = move-exception
            r3 = r22
            goto L_0x0254
        L_0x0249:
            r0 = move-exception
            r22 = r3
            goto L_0x0265
        L_0x024d:
            r0 = move-exception
            r22 = r3
            goto L_0x0254
        L_0x0251:
            r0 = move-exception
            goto L_0x0265
        L_0x0253:
            r0 = move-exception
        L_0x0254:
            java.lang.String r2 = "fail"
            r5 = -1
            com.baidu.swan.apps.filemanage.FileErrorMsg r2 = r1.getErrorMsg(r5, r2)     // Catch:{ all -> 0x0264 }
            r5 = r2
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r9)
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r10)
        L_0x0263:
            return r5
        L_0x0264:
            r0 = move-exception
        L_0x0265:
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r9)
            com.baidu.swan.utils.SwanAppFileUtils.closeSafely(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.filemanage.FileSystemManager.writeFile(java.lang.String, java.lang.Object, java.lang.String, boolean):com.baidu.swan.apps.filemanage.FileErrorMsg");
    }

    public FileErrorMsg unlink(String filePath, boolean isSync) {
        String emptyStringErrorContent;
        String nullErrorContent;
        String str = filePath;
        if (isSync) {
            emptyStringErrorContent = "filePath must be a string";
        } else {
            emptyStringErrorContent = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, (String) null, str, (String) null);
        }
        if (isSync) {
            nullErrorContent = FileErrorMsg.PATH_NULL_HINT;
        } else {
            nullErrorContent = "fail parameter error: parameter.filePath should be String instead of Object;";
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(str, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        if (!SwanGameFileSystemUtils.isValidUsrPath(filePath)) {
            return getErrorMsg(-4, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN, (String) null, str, (String) null));
        }
        FileErrorMsg errorMsg2 = getFileNotExsitMsg(str, false);
        if (errorMsg2 != null) {
            return errorMsg2;
        }
        FileErrorMsg errorMsg3 = judgeWritePermission(filePath);
        if (errorMsg3 != null) {
            return errorMsg3;
        }
        String fullPath = getFullPath(filePath);
        if (TextUtils.isEmpty(fullPath)) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, (String) null, str, (String) null));
        }
        File file = new File(fullPath);
        if (file.isDirectory()) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_OPERATION_NOT_PERMITTED, "unlink", str, (String) null));
        }
        long fileSize = SwanGameFileSystemUtils.getFileSize(fullPath);
        try {
            if (!file.delete()) {
                return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint("fail", (String) null, str, (String) null));
            }
            this.mFileSizeTracker.writeRecord(-fileSize);
            return getErrorMsg(0, "ok");
        } catch (Exception e2) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint("fail", (String) null, str, (String) null));
        }
    }

    public FileErrorMsg unzip(String zipFilePath, String targetPath) {
        String str = zipFilePath;
        String str2 = targetPath;
        String originZipPath = zipFilePath;
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(str, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "unzip", str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (errorMsg != null) {
            return errorMsg;
        }
        FileErrorMsg errorMsg2 = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(str2, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "unzip", str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
        if (errorMsg2 != null) {
            return errorMsg2;
        }
        if (!str2.startsWith("bdfile://tmp") && !str2.startsWith("bdfile://usr")) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + str2);
        }
        String zipFilePath2 = SwanGameFileSystemUtils.getRelativePath(zipFilePath);
        if (!this.mPathProvider.isSupportedScheme(zipFilePath2, true)) {
            return getErrorMsg(-4, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "unzip", originZipPath, str2, true));
        }
        if (!SwanGameFileSystemUtils.isValidPath(targetPath)) {
            return getErrorMsg(-4, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "unzip", originZipPath, str2, true));
        }
        if (isEndWithFile(str2)) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED, "unzip", originZipPath, str2, true));
        }
        String fullZipFilePath = getFullPath(zipFilePath2);
        String fullTargetPath = getFullPath(str2);
        if (TextUtils.isEmpty(fullZipFilePath)) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "unzip", originZipPath, str2, true));
        }
        if (TextUtils.isEmpty(fullTargetPath)) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "unzip", originZipPath, str2, true));
        }
        File file = new File(fullZipFilePath);
        if (!file.exists()) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "unzip", originZipPath, str2, true));
        }
        if (!fullZipFilePath.endsWith(".zip")) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_UNZIP_FAIL);
        }
        if (!file.isFile()) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED, "unzip", originZipPath, str2, true));
        }
        File targetFile = new File(fullTargetPath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        } else if (targetFile.isFile()) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_UNZIP_FAIL);
        }
        List<String> originFilePathList = SwanGameFileSystemUtils.getAllFiles(fullTargetPath, true);
        if (!SwanAppFileUtils.unzipFile(fullZipFilePath, fullTargetPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_UNZIP_FAIL);
        }
        if (str2.startsWith("bdfile://usr")) {
            List<String> filePaths = SwanGameFileSystemUtils.getAllFiles(fullTargetPath, true);
            List<String> unzipAllFilePaths = new ArrayList<>(filePaths.size());
            long addSize = 0;
            for (String pathStr : filePaths) {
                if (!originFilePathList.contains(pathStr)) {
                    unzipAllFilePaths.add(pathStr);
                    addSize += SwanGameFileSystemUtils.getFileSize(pathStr);
                }
            }
            if (this.mFileSizeTracker.isOverLimit(addSize)) {
                SwanGameFileSystemUtils.deleteFiles(unzipAllFilePaths);
                String str3 = zipFilePath2;
                return getErrorMsg(-1, obtainOverLimitErrorMessage());
            }
            this.mFileSizeTracker.writeRecord(addSize);
        }
        return getErrorMsg(0, "ok");
    }

    private boolean isEndWithFile(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        if (path.contains(File.separator)) {
            return isEndWithDot(path.substring(path.lastIndexOf(File.separator) + 1));
        }
        return isEndWithDot(path);
    }

    private boolean isEndWithDot(String path) {
        if (TextUtils.isEmpty(path) || !path.contains(".")) {
            return false;
        }
        String[] strs = path.split("\\.");
        if (strs.length != 2 || TextUtils.isEmpty(strs[0]) || TextUtils.isEmpty(strs[1])) {
            return false;
        }
        return true;
    }

    public FileErrorMsg saveFile(String tempFilePath, String filePath, boolean isSync) {
        String emptyStringErrorContent;
        String nullErrorContent;
        int i2;
        String str;
        String str2 = tempFilePath;
        if (isSync) {
            emptyStringErrorContent = "tempFilePath must be a string";
        } else {
            emptyStringErrorContent = FileErrorMsg.ERROR_MSG_FAIL_TEMPFILEPATH_NOT_EXIST;
        }
        if (isSync) {
            nullErrorContent = FileErrorMsg.PATH_NULL_HINT;
        } else {
            nullErrorContent = "fail parameter error: parameter.tempFilePath should be String instead of Object;";
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(str2, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        String originFilePath = filePath;
        String originTempPath = tempFilePath;
        String filePath2 = SwanGameFileSystemUtils.getRelativePath(filePath);
        if (TextUtils.isEmpty(filePath2)) {
            filePath2 = "bdfile://usr" + File.separator + SwanAppFileUtils.getFileNameFromPath(tempFilePath);
        }
        if (!filePath2.startsWith("bdfile://usr")) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN, (String) null, originFilePath, (String) null));
        }
        if (!this.mPathProvider.isTmpFileScheme(str2)) {
            return getErrorMsg(-4, FileErrorMsg.ERROR_MSG_FAIL_PATH_NOT_TEMPFILEPATH);
        }
        FileErrorMsg errorMsg2 = getParentDirNotExsitMsg(filePath2, false);
        if (errorMsg2 != null) {
            return errorMsg2;
        }
        FileErrorMsg errorMsg3 = getParentDirNotExsitMsg(str2, false);
        if (errorMsg3 != null) {
            return errorMsg3;
        }
        String fullFilePath = getFullPath(filePath2);
        if (TextUtils.isEmpty(fullFilePath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originFilePath);
        }
        File targetFile = new File(fullFilePath);
        if ("bdfile://usr".equals(filePath2)) {
            i2 = -1;
            str = null;
        } else if (!targetFile.exists() || !targetFile.isDirectory()) {
            FileErrorMsg errorMsg4 = getFileNotExsitMsg(str2, true);
            if (errorMsg4 != null) {
                errorMsg4.errMsg = FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY;
                return errorMsg4;
            }
            String fullTempPath = getFullPath(tempFilePath);
            if (TextUtils.isEmpty(fullTempPath)) {
                return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originTempPath);
            }
            String str3 = FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY;
            long addSize = SwanGameFileSystemUtils.getFileSize(fullTempPath);
            String str4 = emptyStringErrorContent;
            if (this.mFileSizeTracker.isOverLimit(addSize)) {
                return getErrorMsg(-1, obtainOverLimitErrorMessage());
            }
            if (!filePath2.startsWith("bdfile://usr") || SwanGameFileSystemUtils.isContainInvalidCharacter(filePath2) || SwanGameFileSystemUtils.isContainInvalidCharacter(tempFilePath)) {
                return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN, (String) null, originFilePath, (String) null));
            }
            FileErrorMsg errorMsg5 = getParentDirNotExsitMsg(filePath2, false);
            if (errorMsg5 != null) {
                return errorMsg5;
            }
            FileErrorMsg errorMsg6 = judgeWritePermission(filePath2);
            if (errorMsg6 != null) {
                return errorMsg6;
            }
            FileErrorMsg errorMsg7 = save(str2, filePath2);
            if (errorMsg7 != null && errorMsg7.errCode == 0) {
                this.mFileSizeTracker.writeRecord(addSize);
                if (TextUtils.isEmpty(tempFilePath)) {
                    return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(str3, (String) null, str2, (String) null));
                }
                File file = new File(fullTempPath);
                if (file.exists()) {
                    file.delete();
                }
                List<String> resultPath = new ArrayList<>();
                resultPath.add(filePath2);
                errorMsg7.result = resultPath;
                errorMsg7.errMsg = "ok";
            }
            return errorMsg7;
        } else {
            String str5 = emptyStringErrorContent;
            i2 = -1;
            str = null;
        }
        return getErrorMsg(i2, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_EISDIR_OPERATION_NOT_PERMITTED, str, originFilePath, str));
    }

    private FileErrorMsg save(String filePath, String toPath) {
        if (SwanGameFileSystemUtils.isFrameworkPath(filePath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + filePath);
        }
        String srcPath = getFullPath(filePath);
        String moveToPath = getFullPath(toPath);
        if (TextUtils.isEmpty(srcPath)) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, (String) null, filePath, (String) null));
        }
        if (TextUtils.isEmpty(moveToPath)) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, (String) null, toPath, (String) null));
        }
        FileErrorMsg errorMsg = getErrorMsg(0, "ok");
        try {
            File saveFile = new File(moveToPath);
            FileInputStream fis = new FileInputStream(new File(srcPath));
            FileOutputStream fos = new FileOutputStream(saveFile);
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
            SwanAppFileUtils.closeSafely(fis);
            SwanAppFileUtils.closeSafely(fos);
            if (!TextUtils.isEmpty(toPath)) {
                List<String> result = new ArrayList<>();
                result.add(toPath);
                errorMsg.result = result;
            } else {
                errorMsg.errMsg = "fail";
                errorMsg.errCode = -1;
            }
            return errorMsg;
        } catch (IOException e2) {
            e2.printStackTrace();
            FileErrorMsg errorMsg2 = getErrorMsg(-1, "fail");
            SwanAppFileUtils.closeSafely((Closeable) null);
            SwanAppFileUtils.closeSafely((Closeable) null);
            if (!TextUtils.isEmpty("")) {
                List<String> result2 = new ArrayList<>();
                result2.add(toPath);
                errorMsg.result = result2;
            } else {
                errorMsg.errMsg = "fail";
                errorMsg.errCode = -1;
            }
            return errorMsg2;
        } catch (Throwable th2) {
            SwanAppFileUtils.closeSafely((Closeable) null);
            SwanAppFileUtils.closeSafely((Closeable) null);
            if (!TextUtils.isEmpty("")) {
                List<String> result3 = new ArrayList<>();
                result3.add(toPath);
                errorMsg.result = result3;
            } else {
                errorMsg.errMsg = "fail";
                errorMsg.errCode = -1;
            }
            throw th2;
        }
    }

    public FileErrorMsg readdir(String dirPath, boolean isSync) {
        String emptyStringErrorContent;
        String nullErrorContent;
        String str = dirPath;
        String originDirPath = dirPath;
        if (isSync) {
            emptyStringErrorContent = "dirPath must be a string";
        } else {
            emptyStringErrorContent = FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + str;
        }
        if (isSync) {
            nullErrorContent = FileErrorMsg.PATH_NULL_HINT;
        } else {
            nullErrorContent = "fail parameter error: parameter.dirPath should be String instead of Object;";
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(str, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        String dirPath2 = SwanGameFileSystemUtils.getRelativePath(dirPath);
        if (!SwanGameFileSystemUtils.isValidUsrPath(dirPath2)) {
            return getErrorMsg(-4, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + originDirPath);
        }
        String fullDirPath = getFullPath(dirPath2);
        if (TextUtils.isEmpty(fullDirPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originDirPath);
        }
        File file = new File(fullDirPath);
        if (!file.exists()) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originDirPath);
        }
        if (!file.isDirectory()) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originDirPath);
        }
        File[] files = file.listFiles();
        List<String> names = new ArrayList<>();
        if (files != null) {
            for (File readFile : files) {
                if (readFile != null && readFile.exists() && !TextUtils.equals(readFile.getAbsolutePath(), this.mRecordPath)) {
                    names.add(SwanAppFileUtils.getFileNameFromPath(readFile.getAbsolutePath()));
                }
            }
        }
        FileErrorMsg errorMsg2 = getErrorMsg(0, "ok");
        errorMsg2.result = names;
        return errorMsg2;
    }

    public FileErrorMsg rmdir(String dirPath, boolean recursive, boolean isSync) {
        String emptyStringErrorContent;
        String nullErrorContent;
        boolean result;
        String str = dirPath;
        if (isSync) {
            emptyStringErrorContent = "dirPath must be a string";
        } else {
            emptyStringErrorContent = FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + str;
        }
        if (isSync) {
            nullErrorContent = FileErrorMsg.PATH_NULL_HINT;
        } else {
            nullErrorContent = "fail parameter error: parameter.dirPath should be String instead of Object;";
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(str, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        FileErrorMsg errorMsg2 = judgeWritePermission(dirPath);
        if (errorMsg2 != null) {
            return errorMsg2;
        }
        if (!SwanGameFileSystemUtils.isValidUsrPath(dirPath)) {
            return getErrorMsg(-4, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + str);
        }
        String fullPath = getFullPath(dirPath);
        if (TextUtils.isEmpty(fullPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + str);
        }
        File file = new File(fullPath);
        if (!file.exists() || file.isFile()) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + str);
        }
        boolean isContainChildFile = isContainChildFile(file.listFiles());
        if (recursive || !isContainChildFile) {
            if (!recursive) {
                long fileSize = SwanGameFileSystemUtils.getFileSize(file);
                result = file.delete();
                if (result) {
                    this.mFileSizeTracker.writeRecord(-fileSize);
                }
            } else {
                SwanGameFileSystemUtils.FsOperationInfo opInfo = new SwanGameFileSystemUtils.FsOperationInfo();
                boolean result2 = SwanGameFileSystemUtils.deleteFile(file, opInfo);
                this.mFileSizeTracker.writeRecord(-opInfo.size);
                result = result2;
            }
            if (!result) {
                return getErrorMsg(-1, "fail");
            }
            return getErrorMsg(0, "ok");
        }
        try {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_DIRECTORY_NOT_EMPTY);
        } catch (Exception e2) {
            return getErrorMsg(-1, "fail");
        }
    }

    private boolean isContainChildFile(File[] files) {
        return (files == null || files.length == 0) ? false : true;
    }

    public FileErrorMsg readFile(String dirPath, String encoding, boolean isSync) {
        String emptyStringErrorContent;
        String nullErrorContent;
        if (isSync) {
            emptyStringErrorContent = "filePath must be a string";
        } else {
            emptyStringErrorContent = FileErrorMsg.ERROR_MSG_FAIL_NOT_FOUND;
        }
        if (isSync) {
            nullErrorContent = FileErrorMsg.PATH_NULL_HINT;
        } else {
            nullErrorContent = "fail parameter error: parameter.dirPath should be String instead of NULL;";
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(dirPath, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        String originDirPath = dirPath;
        String dirPath2 = SwanGameFileSystemUtils.getRelativePath(dirPath);
        if (!this.mPathProvider.isSupportedScheme(dirPath2, true)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + originDirPath);
        }
        if (SwanGameFileSystemUtils.isFrameworkPath(originDirPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + originDirPath);
        }
        FileErrorMsg errorMsg2 = getFileNotExsitMsg(dirPath2, true);
        if (errorMsg2 != null) {
            errorMsg2.errMsg = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "open", originDirPath, (String) null);
            return errorMsg2;
        }
        boolean isEncodingEmpty = TextUtils.isEmpty(encoding);
        if (!isEncodingEmpty) {
            encoding = encoding.toLowerCase();
            if ("binary".equals(encoding)) {
                encoding = ENCODE_LATIN1;
            }
        }
        if (!isEncodingEmpty && !encodeList.contains(encoding)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_UNKNOWN_ENCODING + encoding);
        }
        String fullDirPath = getFullPath(dirPath2);
        if (TextUtils.isEmpty(fullDirPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originDirPath);
        }
        File file = new File(fullDirPath);
        String content = "";
        byte[] bytesData = new byte[0];
        FileErrorMsg errorMsg3 = getErrorMsg(0, "ok");
        try {
            if (TextUtils.isEmpty(encoding)) {
                bytesData = SwanGameFileSystemUtils.getByteArrayByReadFile(fullDirPath);
            } else if ("base64".equals(encoding)) {
                bytesData = SwanGameFileSystemUtils.getByteArrayByReadFile(fullDirPath);
                content = bytesData.length == 0 ? "" : Base64.encodeToString(bytesData, 2);
            } else if (ENCODE_HEX.equals(encoding)) {
                content = SwanGameFileSystemUtils.fileByteToHexString(fullDirPath);
            } else {
                content = readInputStream(new FileInputStream(file), encoding);
            }
            if (TextUtils.isEmpty(encoding)) {
                errorMsg3.bytesData = bytesData;
            } else {
                List<String> list = new ArrayList<>();
                list.add(content);
                errorMsg3.result = list;
            }
            return errorMsg3;
        } catch (Exception ex) {
            ex.printStackTrace();
            return getErrorMsg(-1, "fail");
        }
    }

    private String readInputStream(FileInputStream inputStream, String encoding) {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(TextUtils.isEmpty(encoding) ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, encoding));
            char[] data = new char[1024];
            while (true) {
                int read = br.read(data);
                int len = read;
                if (read == -1) {
                    return sb.toString();
                }
                sb.append(data, 0, len);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        } finally {
            SwanAppFileUtils.closeSafely(inputStream);
        }
    }

    public FileErrorMsg rename(String oldPath, String newPath, boolean isSync) {
        String emptyStringErrorContent;
        String nullErrorContent;
        String emptyStringErrorContent2;
        String str = oldPath;
        String str2 = newPath;
        if (SwanGameFileSystemUtils.isFrameworkPath(oldPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + str);
        }
        if (SwanGameFileSystemUtils.isFrameworkPath(newPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + str2);
        }
        if (isSync) {
            emptyStringErrorContent = "oldPath must be a string";
        } else {
            emptyStringErrorContent = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "rename", str, (String) null);
        }
        String nullErrorContent2 = FileErrorMsg.PATH_NULL_HINT;
        if (isSync) {
            nullErrorContent = nullErrorContent2;
        } else {
            nullErrorContent = FileErrorMsg.ERROR_MSG_FAIL_PARAMETER_OLDPATH_ERROR;
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(str, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        if (isSync) {
            emptyStringErrorContent2 = "newPath must be a string";
        } else {
            emptyStringErrorContent2 = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "rename", str2, (String) null);
        }
        if (!isSync) {
            nullErrorContent2 = "fail parameter error: parameter.newPath should be String instead of Undefined;";
        }
        FileErrorMsg errorMsg2 = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(str2, emptyStringErrorContent2, nullErrorContent2);
        if (errorMsg2 != null) {
            return errorMsg2;
        }
        String originOldPath = oldPath;
        String oldPath2 = SwanGameFileSystemUtils.getRelativePath(oldPath);
        FileErrorMsg errorMsg3 = judgeWritePermission(oldPath2);
        if (errorMsg3 != null) {
            errorMsg3.errMsg = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED, "rename", originOldPath, str2);
            return errorMsg3;
        }
        String originNewPath = newPath;
        String newPath2 = SwanGameFileSystemUtils.getRelativePath(newPath);
        FileErrorMsg errorMsg4 = judgeWritePermission(newPath2);
        if (errorMsg4 != null) {
            errorMsg4.errMsg = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED, "rename", originOldPath, originNewPath);
            return errorMsg4;
        }
        FileErrorMsg errorMsg5 = getFileNotExsitMsg(oldPath2, false);
        if (errorMsg5 != null) {
            errorMsg5.errMsg = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "rename", originOldPath, originNewPath);
            return errorMsg5;
        } else if (!SwanGameFileSystemUtils.isValidPath(oldPath2) || !SwanGameFileSystemUtils.isValidPath(newPath2)) {
            return getErrorMsg(-4, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED, "rename", originOldPath, originNewPath));
        } else {
            FileErrorMsg errorMsg6 = getParentDirNotExsitMsg(newPath2, false);
            if (errorMsg6 != null) {
                errorMsg6.errMsg = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "rename", originOldPath, originNewPath);
                return errorMsg6;
            }
            String fullOldPath = getFullPath(oldPath2);
            if (TextUtils.isEmpty(fullOldPath)) {
                return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originOldPath);
            }
            String fullNewPath = getFullPath(newPath2);
            if (TextUtils.isEmpty(fullNewPath)) {
                return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originNewPath);
            }
            File srcFile = new File(fullOldPath);
            File destFile = new File(fullNewPath);
            boolean isExist = destFile.exists();
            if (!SwanGameFileSystemUtils.isValidFile(srcFile, destFile) || (srcFile.isDirectory() && !isExist && isEndWithFile(fullNewPath))) {
                return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_RENAME_FAILED);
            }
            try {
                if ((!destFile.isDirectory() || destFile.listFiles() == null || destFile.listFiles().length <= 0) && srcFile.renameTo(destFile)) {
                    return getErrorMsg(0, "ok");
                }
                return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_RENAME_FAILED);
            } catch (Exception e2) {
                return getErrorMsg(-1, "fail");
            }
        }
    }

    public FileErrorMsg copyFile(String srcPath, String destPath, boolean isSync) {
        FileErrorMsg errorMsg;
        String str = srcPath;
        String str2 = destPath;
        if (SwanGameFileSystemUtils.isFrameworkPath(srcPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + str);
        }
        if (SwanGameFileSystemUtils.isFrameworkPath(destPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + str2);
        }
        FileErrorMsg errorMsg2 = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(str, "srcPath must be a string", FileErrorMsg.PATH_NULL_HINT);
        if (errorMsg2 != null) {
            return errorMsg2;
        }
        FileErrorMsg errorMsg3 = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(str2, "destPath must be a string", FileErrorMsg.PATH_NULL_HINT);
        if (errorMsg3 != null) {
            return errorMsg3;
        }
        String originSrcPath = srcPath;
        String srcPath2 = SwanGameFileSystemUtils.getRelativePath(srcPath);
        if (!this.mPathProvider.isSupportedScheme(srcPath2, true)) {
            return getErrorMsg(-4, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "copyFile", originSrcPath, (String) null));
        }
        String originDestPath = destPath;
        String destPath2 = SwanGameFileSystemUtils.getRelativePath(destPath);
        if (!SwanGameFileSystemUtils.isValidPath(destPath2)) {
            return getErrorMsg(-4, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN, "copyFile", originDestPath, (String) null));
        }
        FileErrorMsg errorMsg4 = judgeWritePermission(destPath2);
        if (errorMsg4 != null) {
            return errorMsg4;
        }
        String fullSrcPath = getFullPath(srcPath2);
        if (TextUtils.isEmpty(fullSrcPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originSrcPath);
        }
        File srcfile = new File(fullSrcPath);
        if (!srcfile.exists() || !srcfile.isFile()) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "copyFile", originSrcPath, (String) null));
        }
        FileErrorMsg errorMsg5 = getParentDirNotExsitMsg(destPath2, false);
        if (errorMsg5 != null) {
            errorMsg5.errMsg = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "copyFile", originDestPath, (String) null);
            return errorMsg5;
        } else if (destPath2.endsWith(File.separator)) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED, "copyFile", originSrcPath, originDestPath));
        } else {
            String fullDestPath = getFullPath(destPath2);
            if (TextUtils.isEmpty(fullDestPath)) {
                return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originDestPath);
            }
            File file = new File(fullDestPath);
            if (file.exists() && file.isDirectory()) {
                if (isContainChildFile(file.listFiles())) {
                    return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED, "copyFile", originSrcPath, originDestPath));
                }
                try {
                    file.delete();
                } catch (Exception e2) {
                    Exception exc = e2;
                    return getErrorMsg(-1, "fail");
                }
            }
            long addSize = SwanGameFileSystemUtils.getFileSize(fullSrcPath);
            boolean needRecord = !srcPath2.equals(destPath2) && !srcPath2.startsWith("bdfile://usr");
            if (needRecord && this.mFileSizeTracker.isOverLimit(addSize)) {
                return getErrorMsg(-1, obtainOverLimitErrorMessage());
            }
            if (!srcPath2.equals(destPath2)) {
                errorMsg = save(srcPath2, destPath2);
            } else {
                errorMsg = getErrorMsg(0, "ok");
            }
            if (needRecord && errorMsg != null && errorMsg.errCode == 0) {
                this.mFileSizeTracker.writeRecord(addSize);
            }
            return errorMsg;
        }
    }

    public FileErrorMsg appendFile(String filePath, Object data, String encoding, boolean isSync) {
        String nullErrorContent;
        String emptyStringErrorContent = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN, (String) null, filePath, (String) null);
        if (isSync) {
            nullErrorContent = FileErrorMsg.PATH_NULL_HINT;
        } else {
            nullErrorContent = "fail parameter error: parameter.filePath should be String instead of NULL;";
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(filePath, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        String originFilePath = filePath;
        String filePath2 = SwanGameFileSystemUtils.getRelativePath(filePath);
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_SDCARD_NOT_MOUNTED);
        }
        FileErrorMsg errorMsg2 = judgeWritePermission(filePath2);
        if (errorMsg2 != null) {
            return errorMsg2;
        }
        if (data == null) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_ARGUMENT_MUST_INVALID);
        }
        String fullPath = getFullPath(filePath2);
        if (TextUtils.isEmpty(fullPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originFilePath);
        }
        File file = new File(fullPath);
        if (!file.exists()) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "open", originFilePath, (String) null));
        }
        if (file.isDirectory()) {
            return getErrorMsg(-1, "fail illegal operation on a directory, open " + originFilePath);
        }
        return writeFile(filePath2, data, encoding, true);
    }

    public FileErrorMsg access(String path, boolean isSync) {
        String emptyStringErrorContent;
        String nullErrorContent;
        if (SwanGameFileSystemUtils.isFrameworkPath(path)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + path);
        }
        if (isSync) {
            emptyStringErrorContent = "path must be a string";
        } else {
            emptyStringErrorContent = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "access", path, (String) null);
        }
        if (isSync) {
            nullErrorContent = FileErrorMsg.PATH_NULL_HINT;
        } else {
            nullErrorContent = FileErrorMsg.ERROR_MSG_FAIL_PARAMETER_ERROR;
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(path, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        String originPath = path;
        String path2 = SwanGameFileSystemUtils.getRelativePath(path);
        if (!this.mPathProvider.isSupportedScheme(path2, true)) {
            return getErrorMsg(-4, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "access", originPath, (String) null));
        }
        String fullPath = getFullPath(path2);
        if (TextUtils.isEmpty(fullPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originPath);
        }
        if (!new File(fullPath).exists()) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, "access", originPath, (String) null));
        }
        return getErrorMsg(0, "ok");
    }

    public FileErrorMsg stat(String path, boolean isSync) {
        String emptyStringErrorContent;
        String nullErrorContent;
        if (isSync) {
            emptyStringErrorContent = "path must be a string";
        } else {
            emptyStringErrorContent = SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, (String) null, path, (String) null);
        }
        if (isSync) {
            nullErrorContent = FileErrorMsg.PATH_NULL_HINT;
        } else {
            nullErrorContent = "fail parameter error: parameter.path should be String instead of Object;";
        }
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(path, emptyStringErrorContent, nullErrorContent);
        if (errorMsg != null) {
            return errorMsg;
        }
        if (!this.mPathProvider.isTmpFileScheme(path) && !this.mPathProvider.isUsrFileScheme(path)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_PERMISSION_DENIED_OPEN + path);
        }
        FileErrorMsg errorMsg2 = getFileNotExsitMsg(path, false);
        if (errorMsg2 != null) {
            return errorMsg2;
        }
        Stats stats = new Stats();
        String fullPath = getFullPath(path);
        if (TextUtils.isEmpty(fullPath)) {
            return getErrorMsg(-1, SwanGameFileSystemUtils.getMethodParamsErrorHint(FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY, (String) null, path, (String) null));
        }
        File file = new File(fullPath);
        stats.setIsDirectory(file.isDirectory());
        stats.setIsFile(file.isFile());
        return getStats(path, stats);
    }

    private FileErrorMsg getStats(String path, Stats stats) {
        String fullPath = getFullPath(path);
        if (TextUtils.isEmpty(fullPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + path);
        }
        File file = new File(fullPath);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                stats.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                stats.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                stats.mode = (long) Os.lstat(file.getAbsolutePath()).st_mode;
                stats.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e2) {
                e2.printStackTrace();
                return getErrorMsg(-1, "fail");
            }
        } else {
            try {
                Field field = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Object os = field.get((Object) null);
                Object lstat = os.getClass().getMethod("lstat", new Class[]{String.class}).invoke(os, new Object[]{file.getAbsolutePath()});
                Field field2 = lstat.getClass().getDeclaredField("st_atime");
                if (!field2.isAccessible()) {
                    field2.setAccessible(true);
                }
                stats.lastAccessedTime = field2.getLong(lstat);
                Field field3 = lstat.getClass().getDeclaredField("st_mtime");
                if (!field3.isAccessible()) {
                    field3.setAccessible(true);
                }
                stats.lastModifiedTime = field3.getLong(lstat);
                Field field4 = lstat.getClass().getDeclaredField("st_mode");
                if (!field4.isAccessible()) {
                    field4.setAccessible(true);
                }
                stats.mode = (long) field4.getInt(lstat);
                Field field5 = lstat.getClass().getDeclaredField("st_size");
                if (!field5.isAccessible()) {
                    field5.setAccessible(true);
                }
                stats.size = field5.getLong(lstat);
            } catch (Exception e3) {
                e3.printStackTrace();
                return getErrorMsg(-1, "fail");
            }
        }
        FileErrorMsg errorMsg = getErrorMsg(0, "ok");
        errorMsg.stats = stats;
        errorMsg.errMsg = "ok";
        return errorMsg;
    }

    public FileErrorMsg getSavedFileList() {
        String path = getFullPath("bdfile://usr");
        if (TextUtils.isEmpty(path)) {
            return getErrorMsg(-1, "path must be a string");
        }
        String basePath = this.mPathProvider.getUsrDirectory();
        List<FileItem> fileInfos = new ArrayList<>();
        for (String strPath : SwanGameFileSystemUtils.getAllFiles(path, false)) {
            if (!TextUtils.equals(strPath, this.mRecordPath)) {
                File file = new File(strPath);
                FileItem info = new FileItem();
                long j2 = 0;
                info.createTime = file.exists() ? file.lastModified() : 0;
                String filePath = file.getAbsolutePath();
                if (file.exists() && !TextUtils.isEmpty(filePath) && !TextUtils.isEmpty(basePath) && filePath.startsWith(basePath)) {
                    info.filePath = this.mPathProvider.realPathToScheme(filePath);
                }
                if (file.exists()) {
                    j2 = file.length();
                }
                info.size = j2;
                fileInfos.add(info);
            }
        }
        FileErrorMsg errorMsg = getErrorMsg(0, "ok");
        errorMsg.fileList = fileInfos;
        return errorMsg;
    }

    public FileErrorMsg removeSavedFile(String filePath) {
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(filePath, FileErrorMsg.ERROR_MSG_FAIL_NOT_EXIST, "fail parameter error: parameter.filePath should be String instead of Object;");
        if (errorMsg != null) {
            return errorMsg;
        }
        if (judgeWritePermission(filePath) != null) {
            return getErrorMsg(-4, FileErrorMsg.ERROR_MSG_FAIL_NOT_EXIST);
        }
        String fullPath = getFullPath(filePath);
        if (TextUtils.isEmpty(fullPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + filePath);
        }
        File file = new File(fullPath);
        if (!file.exists() || file.isDirectory()) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_NOT_EXIST);
        }
        long fileSize = SwanGameFileSystemUtils.getFileSize(fullPath);
        try {
            if (!file.delete()) {
                return getErrorMsg(-1, "fail");
            }
            this.mFileSizeTracker.writeRecord(-fileSize);
            return getErrorMsg(0, "ok");
        } catch (Exception e2) {
            return getErrorMsg(-1, "fail");
        }
    }

    public FileErrorMsg getFileInfo(String filePath) {
        FileErrorMsg errorMsg = SwanGameFileSystemUtils.getErrorMsgByPathIsEmpty(filePath, FileErrorMsg.ERROR_MSG_FAIL_NOT_EXIST, FileErrorMsg.ERROR_MSG_FAIL_PARAMETER_FILEPATH_ERROR);
        if (errorMsg != null) {
            return errorMsg;
        }
        String originFilePath = filePath;
        String filePath2 = SwanGameFileSystemUtils.getRelativePath(filePath);
        if (!this.mPathProvider.isSupportedScheme(filePath2, true)) {
            return getErrorMsg(-4, FileErrorMsg.ERROR_MSG_FAIL_NOT_EXIST);
        }
        String fullPath = getFullPath(filePath2);
        if (TextUtils.isEmpty(fullPath)) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_NO_SUCH_FILE_OR_DIRECTORY + originFilePath);
        }
        File file = new File(fullPath);
        if (!file.exists()) {
            return getErrorMsg(-1, FileErrorMsg.ERROR_MSG_FAIL_NOT_EXIST);
        }
        if (file.isDirectory()) {
            return getErrorMsg(-1, "fail " + originFilePath + " is directory");
        }
        FileErrorMsg errorMsg2 = getErrorMsg(0, "ok");
        errorMsg2.size = file.exists() ? file.length() : 0;
        errorMsg2.digest = file.exists() ? SwanAppMD5Utils.toMd5(file, false) : null;
        return errorMsg2;
    }

    private String obtainOverLimitErrorMessage() {
        String fileSize = SwanAppFileUtils.generateFileSizeText(this.mFileSizeTracker.getMaxSize());
        if (TextUtils.isEmpty(fileSize) || TextUtils.equals(fileSize, "未知")) {
            fileSize = "";
        }
        return String.format(FileErrorMsg.ERROR_MSG_FILE_SIZE_OVER_LIMIT_USR, new Object[]{fileSize});
    }
}
