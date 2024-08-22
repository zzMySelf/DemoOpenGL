package com.baidu.netdisk.account.model;

import android.text.TextUtils;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

public class ConfigPrivileges {
    private static final String TAG = "CfgConfigPrivileges";
    @SerializedName("normal_privilege")
    public ConfigAccountPrivileges mNotVipPrivilege;
    @SerializedName("svip_privilege")
    public ConfigAccountPrivileges mSVipPrivilege;
    @SerializedName("vip_privilege")
    public ConfigAccountPrivileges mVipPrivilege;
    public int ver;

    public ConfigPrivileges() {
    }

    public ConfigPrivileges(String body) {
        NetDiskLog.d(TAG, " DBG ConfigPrivileges body:" + body);
        if (!TextUtils.isEmpty(body)) {
            init(body);
        }
    }

    private void init(String body) {
        try {
            ConfigPrivileges configPrivileges = (ConfigPrivileges) new Gson().fromJson(body, getClass());
            if (configPrivileges != null) {
                ConfigAccountPrivileges configAccountPrivileges = configPrivileges.mVipPrivilege;
                this.mVipPrivilege = configAccountPrivileges;
                this.mNotVipPrivilege = configPrivileges.mNotVipPrivilege;
                this.mSVipPrivilege = configPrivileges.mSVipPrivilege;
                checkBackupValue(configAccountPrivileges.backup);
                checkBackupValue(this.mNotVipPrivilege.backup);
                checkBackupValue(this.mSVipPrivilege.backup);
                checkUploadValue(this.mVipPrivilege.upload);
                checkUploadValue(this.mNotVipPrivilege.upload);
                checkUploadValue(this.mSVipPrivilege.upload);
            }
        } catch (JsonSyntaxException e2) {
            NetDiskLog.d(TAG, "init.JsonSyntaxException.e:" + e2.getMessage());
        } catch (JsonIOException e3) {
            NetDiskLog.d(TAG, "init.IOException.e:" + e3.getMessage());
        } catch (NullPointerException e4) {
            NetDiskLog.d(TAG, "init.NullPointerException.e:" + e4.getMessage());
        } catch (JsonParseException e5) {
            NetDiskLog.d(TAG, "init.JsonParseException.e:" + e5.getMessage());
        } catch (IllegalArgumentException e6) {
            NetDiskLog.d(TAG, "init.IllegalArgumentException.e:" + e6.getMessage());
        }
    }

    private void checkBackupValue(ConfigBackup backup) {
        if (backup.syncVipThreshold < 600000 || backup.syncVipThreshold > 86400000) {
            backup.syncVipThreshold = 3600000;
        }
    }

    private void checkUploadValue(ConfigUpload upload) {
    }
}
