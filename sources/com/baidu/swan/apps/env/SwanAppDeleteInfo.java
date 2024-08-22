package com.baidu.swan.apps.env;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;

public class SwanAppDeleteInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppDeleteInfo> CREATOR = new Parcelable.Creator<SwanAppDeleteInfo>() {
        public SwanAppDeleteInfo createFromParcel(Parcel in) {
            return new SwanAppDeleteInfo(in);
        }

        public SwanAppDeleteInfo[] newArray(int size) {
            return new SwanAppDeleteInfo[size];
        }
    };
    public static final int HIS_FAVOR_CHECK = 0;
    public static final int HIS_FAVOR_IGNORE = 1;
    public String mAppId;
    public int mCheckHisAndFavor;
    private int mPurgerScenes;

    public SwanAppDeleteInfo(String appId) {
        this.mPurgerScenes = 0;
        this.mAppId = appId;
        this.mCheckHisAndFavor = 0;
    }

    public SwanAppDeleteInfo(String appId, int checkHisAndFavor) {
        this.mPurgerScenes = 0;
        this.mAppId = appId;
        this.mCheckHisAndFavor = checkHisAndFavor;
    }

    private SwanAppDeleteInfo(Parcel in) {
        this.mPurgerScenes = 0;
        this.mAppId = in.readString();
        this.mCheckHisAndFavor = in.readInt();
        this.mPurgerScenes = in.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mAppId);
        dest.writeInt(this.mCheckHisAndFavor);
        dest.writeInt(this.mPurgerScenes);
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mCheckHisAndFavor:" + this.mCheckHisAndFavor + ",mPurgerScenes:" + this.mPurgerScenes;
    }

    public SwanAppDeleteInfo setPurgerScenes(int purgerScenes) {
        this.mPurgerScenes = purgerScenes;
        return this;
    }

    public int getPurgerScenes() {
        return this.mPurgerScenes;
    }
}
