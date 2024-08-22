package com.baidu.searchbox.pms.utils;

import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.statistic.PackageFileStatisticManager;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StatisticUtils {
    public static void sendBulkDownload(List<PackageInfo> successList, List<PackageInfo> errorList, List<PackageInfo> cancelList, int retryCount) {
        String channelId;
        String errMsg = String.format(ErrorConstant.ErrorMsg.DOWNLOAD_BULK_DOWNLOADED, new Object[]{Integer.valueOf(successList.size()), Integer.valueOf(errorList.size()), Integer.valueOf(cancelList.size())});
        if (successList.size() > 0) {
            List<PackageInfo> list = errorList;
            List<PackageInfo> list2 = cancelList;
            channelId = successList.get(0).channelId;
        } else {
            List<PackageInfo> list3 = successList;
            if (errorList.size() > 0) {
                List<PackageInfo> list4 = cancelList;
                channelId = errorList.get(0).channelId;
            } else {
                List<PackageInfo> list5 = errorList;
                if (cancelList.size() > 0) {
                    channelId = cancelList.get(0).channelId;
                } else {
                    List<PackageInfo> list6 = cancelList;
                    channelId = "";
                }
            }
        }
        PackageFileStatisticManager.getInstance().addDownloadStatistic2(ErrorConstant.Code.DOWNLOAD_BULK_DOWNLOADED, errMsg, channelId, (String) null, 0, "", "", 0, retryCount);
    }

    public static void sendDownload(PackageInfo info, int errCode) {
        sendDownload(info, new ErrorInfo(errCode));
    }

    public static void sendDownload(PackageInfo info, ErrorInfo errInfo) {
        PackageFileStatisticManager.getInstance().addDownloadStatistic2(errInfo.code, errInfo.errorMsg, info.channelId, info.packageName, info.version, info.downloadUrl, "", 0, info.retryCount);
    }

    public static void sendCloudCtrl(String msg, List<RequestParams.Channel> channelList) {
        StringBuilder channelIds = new StringBuilder();
        if (channelList != null) {
            for (RequestParams.Channel channel : channelList) {
                channelIds.append(channel).append(",");
            }
        }
        PackageFileStatisticManager.getInstance().addFetchStatistic2(2108, msg, channelIds.toString(), (JSONObject) null);
    }

    public static void sendDegradeData(List<DegradeData> degradeDataList) {
        if (degradeDataList != null) {
            JSONObject jsonObject = new JSONObject();
            try {
                for (DegradeData data : degradeDataList) {
                    if (data != null) {
                        JSONArray array = null;
                        if (data.isAllDegrade) {
                            array = new JSONArray();
                        } else if (!CommonUtils.isEmpty((Collection) data.packageNames)) {
                            array = new JSONArray();
                            for (String packageName : data.packageNames) {
                                array.put(packageName);
                            }
                        }
                        if (array != null) {
                            jsonObject.put(data.channelId, array);
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jsonObject.length() > 0) {
                PackageFileStatisticManager.getInstance().addFetchStatistic2(-1, (String) null, (String) null, jsonObject);
            }
        }
    }
}
