package com.baidu.searchbox.ioc;

import com.baidu.searchbox.ad.IAdDownloadRuntime;
import com.baidu.searchbox.feed.ad.feedlogic.AdUserTrackDBControl;
import com.baidu.searchbox.feed.ad.model.AdDownloadApkInfo;
import java.util.ArrayList;

public class AdDownloadRuntimeImpl implements IAdDownloadRuntime {
    public void addApkInfo(AdDownloadApkInfo info) {
        AdUserTrackDBControl.getInstance().addApkInfo(info);
    }

    public void deleteExpirationApkList(long expirationTime) {
        AdUserTrackDBControl.getInstance().deleteExpirationApkList(expirationTime);
    }

    public ArrayList<AdDownloadApkInfo> selectSuccessDownloadApkList(String business, long startTime, long endTime) {
        return AdUserTrackDBControl.getInstance().selectSuccessDownloadApkList(business, startTime, endTime);
    }

    public ArrayList<AdDownloadApkInfo> selectSuccessDownloadApkListByAppend(long startTime, long endTime) {
        return AdUserTrackDBControl.getInstance().selectSuccessDownloadApkListByAppend(startTime, endTime);
    }

    public void updateApkInfo(int id, String ext1, String ext2, String ext3) {
        AdUserTrackDBControl.getInstance().updateApkInfo(id, ext1, ext2, ext3);
    }
}
