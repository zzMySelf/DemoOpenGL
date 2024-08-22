package com.baidu.netdisk.network.caller;

import com.baidu.netdisk.component.core.communication.CommunicationInterPreter;

public final class AccountUtilsProviderCompManager {
    public static String getBduss() {
        AccountUtilsProviderGen caller = (AccountUtilsProviderGen) CommunicationInterPreter.getInstance().getCommunicationProxy().create(AccountUtilsProviderGen.class);
        if (caller != null) {
            return caller.getBduss();
        }
        return null;
    }

    public static String getUid() {
        AccountUtilsProviderGen caller = (AccountUtilsProviderGen) CommunicationInterPreter.getInstance().getCommunicationProxy().create(AccountUtilsProviderGen.class);
        if (caller != null) {
            return caller.getUid();
        }
        return null;
    }

    public static String getOsType() {
        AccountUtilsProviderGen caller = (AccountUtilsProviderGen) CommunicationInterPreter.getInstance().getCommunicationProxy().create(AccountUtilsProviderGen.class);
        if (caller != null) {
            return caller.getOsType();
        }
        return null;
    }

    public static int getLevel() {
        AccountUtilsProviderGen caller = (AccountUtilsProviderGen) CommunicationInterPreter.getInstance().getCommunicationProxy().create(AccountUtilsProviderGen.class);
        if (caller != null) {
            return caller.getLevel();
        }
        return -1;
    }
}
