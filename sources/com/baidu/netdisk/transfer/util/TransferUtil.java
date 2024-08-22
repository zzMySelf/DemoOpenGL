package com.baidu.netdisk.transfer.util;

import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.netdisk.BaseApplication;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.transfer.TransferFileNameConstant;

public class TransferUtil {
    public static final String ACTION_TASK_NUM_CHANGED = "com.baidu.netdisk.ACTION_TASK_NUM_CHANGED";
    public static final String IS_DOWNLOAD_TYPE = "is_download_type";
    private static final String TAG = "TransferUtil";
    public static final String TRANSFER_TODAY_REPORT = "com.baidu.netdisk.transfer.TRANSFER_TODAY_REPORT";
    public static final String TYPE_DOWNLOAD = "download";
    public static final String TYPE_UPLOAD = "upload";
    public static final String TYPE_UPLOAD_OR_DOWNLOAD = "upload_or_download";

    public static void sendTaskFinishedBroadCast(int type) {
    }

    public static void sendUpTransferBroadcast() {
        NetDiskLog.d(TAG, "【Upload-SDK】发送上传报活广播");
        Intent transferBroadcast = new Intent(TRANSFER_TODAY_REPORT);
        transferBroadcast.putExtra(TYPE_UPLOAD_OR_DOWNLOAD, "upload");
        LocalBroadcastManager.getInstance(BaseApplication.getInstance()).sendBroadcast(transferBroadcast);
    }

    public static void sendTaskChanged(boolean isDownloadType) {
        LocalBroadcastManager.getInstance(BaseApplication.getInstance()).sendBroadcast(new Intent(ACTION_TASK_NUM_CHANGED).putExtra(IS_DOWNLOAD_TYPE, isDownloadType));
    }

    public static String getFileNameWithoutHidePrefix(String path) {
        if (TextUtils.isEmpty(path)) {
            return "";
        }
        int backslash = path.lastIndexOf("/");
        String s = path.substring(backslash + 1, backslash + 2);
        if (backslash < 0 || !".".equals(s)) {
            return "";
        }
        return path.substring(backslash + 2);
    }

    public static String removeBN(String path) {
        if (path.endsWith(TransferFileNameConstant.DOWNLOAD_SUFFIX)) {
            return path.substring(0, path.lastIndexOf(TransferFileNameConstant.DOWNLOAD_SUFFIX));
        }
        return path;
    }

    public static String getFileNameDisplay(String filePath) {
        String s = filePath.substring(filePath.lastIndexOf(47) + 1);
        int dot = s.lastIndexOf(".");
        if (dot >= 0 && s.substring(dot).equals(TransferFileNameConstant.DOWNLOAD_SUFFIX)) {
            return s.substring(0, dot);
        }
        return s;
    }
}
