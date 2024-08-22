package com.baidu.searchbox.logsystem.logsys;

import android.os.Parcel;
import android.os.Parcelable;

public final class LogExtra implements Parcelable {
    public static final Parcelable.Creator<LogExtra> CREATOR = new qw();
    public String mCrashThreadName = null;
    public String mCrashThreadPriority = null;
    public String mCrashTime = null;
    public String mForeground = null;
    public String mHeapMem = null;
    public String mJSONAttach = null;
    public String mLaunchTime = null;
    public String mPSS = null;
    public String mPage = null;
    public String mProcessLifeTime = null;
    public int mSysLowMem = 1;
    public String mSysMem = null;
    public String mTraceID = null;
    public String mVSSRSS = null;

    public static class qw implements Parcelable.Creator<LogExtra> {
        /* renamed from: ad */
        public LogExtra[] newArray(int i2) {
            if (i2 <= 0) {
                return null;
            }
            return new LogExtra[i2];
        }

        /* renamed from: qw */
        public LogExtra createFromParcel(Parcel parcel) {
            return new LogExtra(parcel);
        }
    }

    public LogExtra() {
    }

    public static void init() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mPage);
        parcel.writeString(this.mCrashTime);
        parcel.writeString(this.mLaunchTime);
        parcel.writeString(this.mProcessLifeTime);
        parcel.writeString(this.mCrashThreadName);
        parcel.writeString(this.mCrashThreadPriority);
        parcel.writeString(this.mForeground);
        parcel.writeString(this.mTraceID);
        parcel.writeString(this.mJSONAttach);
        parcel.writeString(this.mHeapMem);
        parcel.writeString(this.mVSSRSS);
        parcel.writeString(this.mPSS);
        parcel.writeString(this.mSysMem);
        parcel.writeInt(this.mSysLowMem);
    }

    public LogExtra(Parcel parcel) {
        this.mPage = parcel.readString();
        this.mCrashTime = parcel.readString();
        this.mLaunchTime = parcel.readString();
        this.mProcessLifeTime = parcel.readString();
        this.mCrashThreadName = parcel.readString();
        this.mCrashThreadPriority = parcel.readString();
        this.mForeground = parcel.readString();
        this.mTraceID = parcel.readString();
        this.mJSONAttach = parcel.readString();
        this.mHeapMem = parcel.readString();
        this.mVSSRSS = parcel.readString();
        this.mPSS = parcel.readString();
        this.mSysMem = parcel.readString();
        this.mSysLowMem = parcel.readInt();
    }
}
