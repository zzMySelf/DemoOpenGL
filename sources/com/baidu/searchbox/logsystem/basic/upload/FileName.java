package com.baidu.searchbox.logsystem.basic.upload;

import android.text.TextUtils;
import com.baidu.searchbox.logsystem.logsys.LogType;

public class FileName {
    private static final String FILE_ID_SEPARATOR = "_";
    private static final String SEPARATOR = "#";
    private String mFileID;
    private LogType mLogType;
    private String mProcessName;
    private Long mTimestamp;

    private FileName(String fileID, long timestamp, String processName, LogType logType) {
        this.mFileID = fileID;
        this.mTimestamp = Long.valueOf(timestamp);
        this.mProcessName = processName;
        this.mLogType = logType;
    }

    public static String createFileID(String fileIDPrefix, long timestamp) {
        return fileIDPrefix.replace("_", "").replace("#", "") + "_" + timestamp;
    }

    public static String getFileName(FileName fileName) {
        return fileName.mFileID + "#" + fileName.mProcessName + "#" + fileName.mLogType.getTypeName();
    }

    public static FileName getFileName(String fileID, String processName, LogType logType) {
        if (TextUtils.isEmpty(fileID) || TextUtils.isEmpty(processName) || logType == null) {
            return null;
        }
        long timeStamp = -1;
        String[] fileIDSplits = fileID.split("_");
        if (fileIDSplits != null && fileIDSplits.length == 2) {
            try {
                timeStamp = Long.valueOf(fileIDSplits[1]).longValue();
            } catch (NumberFormatException e2) {
                return null;
            }
        }
        if (timeStamp > 0) {
            return new FileName(fileID, timeStamp, processName, logType);
        }
        return null;
    }

    public static FileName getFileName(String fileName) {
        String[] splits;
        String[] fileIDSplits;
        if (TextUtils.isEmpty(fileName) || (splits = fileName.split("#")) == null || splits.length != 3) {
            return null;
        }
        long timeStamp = -1;
        String fileID = splits[0];
        if (!TextUtils.isEmpty(fileID) && (fileIDSplits = fileID.split("_")) != null && fileIDSplits.length == 2) {
            String timeStampStr = fileIDSplits[1];
            if (!TextUtils.isEmpty(timeStampStr)) {
                try {
                    timeStamp = Long.valueOf(timeStampStr).longValue();
                } catch (NumberFormatException e2) {
                    return null;
                }
            }
        }
        String processName = splits[1];
        LogType logType = LogType.getLogType(splits[2]);
        if (TextUtils.isEmpty(fileID) || timeStamp <= 0 || TextUtils.isEmpty(processName) || logType == null) {
            return null;
        }
        return new FileName(fileID, timeStamp, processName, logType);
    }

    public String fileID() {
        return this.mFileID;
    }

    public long timeStamp() {
        return this.mTimestamp.longValue();
    }

    public String toString() {
        return this.mFileID + "#" + this.mTimestamp + "#" + this.mProcessName + "#" + this.mLogType.getTypeName();
    }
}
