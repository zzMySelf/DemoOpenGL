package com.baidu.netdisk.transfer.base;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.account.model.ConfigPrivilegeExemption;
import com.baidu.netdisk.account.model.ConfigUpload;
import com.baidu.netdisk.account.model.ConfigUploadPrivilegeExemption;
import com.baidu.netdisk.base.NetdiskCommonConfig;
import com.baidu.netdisk.base.storage.config.ServerConfigKey;
import com.baidu.netdisk.base.utils.FileType;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.kernel.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class UploadPrivilegeFilter extends UploadFileFilter {
    private static final String TAG = "UploadPrivilegeFilter";

    public UploadPrivilegeFilter(int totalCount) {
        super(totalCount);
    }

    public Pair<Boolean, Boolean> filter(Uri uploadFileUri) {
        if (uploadFileUri == null) {
            return new Pair<>(Boolean.valueOf(this.transferEnable), false);
        }
        if (uploadFileUri.getPath() != null) {
            this.transferEnable = checkTransferEnable(uploadFileUri.getPath());
        }
        return super.filter(uploadFileUri);
    }

    private boolean checkTransferEnable(String localPath) {
        NetDiskLog.d(TAG, "【Upload-SDK】 checkTransferEnable 检查是否有文件的传输能力（视频特权检查）");
        boolean isVideo = FileType.isVideo(localPath);
        ConfigUpload uploadPrivilege = (ConfigUpload) AccountUtils.getInstance().getPrivilegeValue("upload");
        if (!isVideo) {
            return true;
        }
        if (checkBusinessTransferEnable()) {
            NetDiskLog.d(TAG, "【Upload-SDK】 业务已授权, 可以上传视频; localPath " + localPath);
            return true;
        }
        NetDiskLog.d(TAG, "【Upload-SDK】 业务未授权, 是否允许上传视频 " + uploadPrivilege.video + "; localPath " + localPath);
        return uploadPrivilege.video;
    }

    public static boolean checkBusinessTransferEnable() {
        if (TextUtils.isEmpty(NetdiskCommonConfig.SDK_HOST_NAME)) {
            NetDiskLog.d(TAG, "【Upload-SDK】 checkBusinessTransferEnable SDK_HOST_NAME is null");
            return false;
        }
        ArrayList<ConfigUploadPrivilegeExemption> business = new ConfigPrivilegeExemption(ServerConfigKey.getCfgConfigBodyByType(ServerConfigKey.ConfigType.PRIVILEGE_EXEMPTION)).getUpload();
        if (CollectionUtils.isEmpty(business)) {
            NetDiskLog.d(TAG, "【Upload-SDK】 checkBusinessTransferEnable SDK_HOST_NAME is null");
            return false;
        }
        Iterator<ConfigUploadPrivilegeExemption> it = business.iterator();
        while (it.hasNext()) {
            ConfigUploadPrivilegeExemption app = it.next();
            NetDiskLog.d(TAG, "【Upload-SDK】 checkBusinessTransferEnable app " + app.getPackageName() + " exemptible " + app.getExemptible());
            if (NetdiskCommonConfig.SDK_HOST_NAME.equals(app.getPackageName())) {
                return app.getExemptible().booleanValue();
            }
        }
        return false;
    }
}
