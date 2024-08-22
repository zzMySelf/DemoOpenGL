package com.baidu.netdisk.component.core.communication;

import com.baidu.netdisk.component.core.communication.interpreter.CommunicationProxy;

public final class CommunicationInterPreter {
    private static CommunicationInterPreter mInstance;
    private CommunicationProxy mCommunicationProxy = new CommunicationProxy();

    private CommunicationInterPreter() {
    }

    public static synchronized CommunicationInterPreter getInstance() {
        CommunicationInterPreter communicationInterPreter;
        synchronized (CommunicationInterPreter.class) {
            if (mInstance == null) {
                mInstance = new CommunicationInterPreter();
            }
            communicationInterPreter = mInstance;
        }
        return communicationInterPreter;
    }

    public CommunicationProxy getCommunicationProxy() {
        return this.mCommunicationProxy;
    }
}
