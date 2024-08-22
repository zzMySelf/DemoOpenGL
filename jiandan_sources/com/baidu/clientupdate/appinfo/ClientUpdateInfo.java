package com.baidu.clientupdate.appinfo;

public class ClientUpdateInfo extends AppInfo {
    public String mContentUrl;
    public String mIsForceUpdate;
    public String mReverson;
    public String mStatus;

    public String toString() {
        return super.toString() + " isforce: " + this.mIsForceUpdate + " status: " + this.mStatus + " re_version: " + this.mReverson;
    }
}
