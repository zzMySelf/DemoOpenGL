package com.baidu.netdisk.account.model;

import com.baidu.netdisk.base.storage.config.ServerConfigKey;
import com.baidu.netdisk.kernel.util.NoProguard;
import com.google.gson.annotations.SerializedName;

public class ConfigRecycleBin implements NoProguard {
    @SerializedName("keep_period")
    public int keepPeriod;
    @SerializedName("notify_before_deadline")
    public int notifyBeforeDeadline;

    /* access modifiers changed from: private */
    public ConfigRecycleBin init(int accountLevel) {
        switch (accountLevel) {
            case 0:
                this.keepPeriod = 10;
                break;
            case 1:
                this.keepPeriod = 15;
                break;
            case 2:
                this.keepPeriod = 30;
                break;
            default:
                this.keepPeriod = 10;
                break;
        }
        this.notifyBeforeDeadline = 3;
        return this;
    }

    private static class Factory extends AbstractPrivilegeCreator<ConfigRecycleBin> {
        private Factory() {
        }

        public ConfigRecycleBin choosePrivilege(ConfigAccountPrivileges privileges, int accountLevel) {
            if (privileges == null || privileges.recycleBin == null) {
                return new ConfigRecycleBin().init(accountLevel);
            }
            return privileges.recycleBin;
        }
    }

    public static ConfigRecycleBin createFromConfig(ConfigPrivileges configPrivileges, int accountLevel) {
        return (ConfigRecycleBin) new Factory().create(configPrivileges, accountLevel);
    }

    public static ConfigRecycleBin createFromDefaultValue(int accountLevel) {
        return (ConfigRecycleBin) new Factory().create((ConfigPrivileges) null, accountLevel);
    }

    public static int getKeepPeriod(int accountLevel) {
        return createFromConfig(new ConfigPrivileges(ServerConfigKey.getCfgConfigBodyByType(ServerConfigKey.ConfigType.PRIVILEGE)), accountLevel).keepPeriod;
    }
}
