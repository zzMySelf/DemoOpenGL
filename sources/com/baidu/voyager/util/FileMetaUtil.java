package com.baidu.voyager.util;

import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FileMetaUtil {
    private static final String BOS_MESSAGE = "bosMessage";
    private static final String CREATE_TIME = "createTime";
    private static final String ERR_MSG = "errmsg";
    private static final String ERR_NO = "errno";
    private static final String ISFILE = "1";
    private static final String IS_FILE = "isFile";
    private static final String MODIFY_TIME = "modifiedTime";
    private static final String NOTFILE = "0";
    private static final String SIZE = "size";
    private static final String SPACE = "space";
    private static final String ZIP_PATH = "zipPath";

    public static JSONObject makeFileMeta(File abFile, String inZipFilePath, String errNo, String errMsg, boolean isFile) {
        JSONObject metaJSON = new JSONObject();
        try {
            metaJSON.put("errno", errNo);
            metaJSON.put("errmsg", errMsg);
            metaJSON.put(IS_FILE, isFile ? "1" : "0");
            if (abFile != null && abFile.exists() && abFile.isFile()) {
                metaJSON.put(ZIP_PATH, inZipFilePath);
                metaJSON.put("size", String.valueOf(abFile.length()));
                metaJSON.put("createTime", abFile.lastModified());
                metaJSON.put(MODIFY_TIME, abFile.lastModified());
            }
        } catch (Exception ex) {
            if (AppConfig.isDebug()) {
                ex.printStackTrace();
            }
        }
        return metaJSON;
    }

    public static JSONObject makeSpaceMeta(List<String> spaceList) {
        JSONObject spaceMeta = new JSONObject();
        if (spaceList != null) {
            try {
                if (spaceList.size() > 0) {
                    StringBuilder sbSpace = new StringBuilder();
                    for (String space : spaceList) {
                        sbSpace.append(space).append("&");
                    }
                    spaceMeta.put("space", sbSpace.toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return spaceMeta;
    }

    public static JSONObject appendBosMeta(JSONObject metaInfo, String bosMessage) {
        try {
            metaInfo.put(BOS_MESSAGE, bosMessage);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return metaInfo;
    }
}
