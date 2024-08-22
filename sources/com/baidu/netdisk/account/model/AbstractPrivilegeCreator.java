package com.baidu.netdisk.account.model;

abstract class AbstractPrivilegeCreator<T> implements ICreatePrivilegeFromConfig<T> {
    /* access modifiers changed from: protected */
    public abstract T choosePrivilege(ConfigAccountPrivileges configAccountPrivileges, int i2);

    AbstractPrivilegeCreator() {
    }

    public T create(ConfigPrivileges config, int accountLevel) {
        return choosePrivilege(createPrivileges(config, accountLevel), accountLevel);
    }

    private ConfigAccountPrivileges createPrivileges(ConfigPrivileges config, int accountLevel) {
        if (config == null) {
            return null;
        }
        if (1 == accountLevel && config.mVipPrivilege != null) {
            return config.mVipPrivilege;
        }
        if (2 == accountLevel && config.mSVipPrivilege != null) {
            return config.mSVipPrivilege;
        }
        if (config.mNotVipPrivilege != null) {
            return config.mNotVipPrivilege;
        }
        return null;
    }
}
