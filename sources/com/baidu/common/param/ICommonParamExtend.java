package com.baidu.common.param;

public abstract class ICommonParamExtend {
    public String getIid() {
        return null;
    }

    public boolean isAgreePrivacy() {
        return true;
    }

    public String getMatrixstyle() {
        return null;
    }

    public String getAppMode() {
        return null;
    }

    public boolean isNeedCustomOS() {
        return true;
    }

    public boolean usePrivacyPolicy() {
        return true;
    }

    public boolean networkMapping() {
        return true;
    }

    public void recordEvent(NonExpectedEvent event) {
    }

    public int getDeviceType() {
        return 0;
    }
}
