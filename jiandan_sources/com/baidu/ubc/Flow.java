package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import fe.fe.vvv.ad.ad.ad;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class Flow implements Parcelable {
    public static final Parcelable.Creator<Flow> CREATOR = new qw();
    public static final int CUSTOM_END_TIME = 1;
    public static final int INVALID_HANDLE = -1;
    public long mClockStartTime;
    public long mEndTime;
    public int mHandle;
    public boolean mHasEnd;
    public String mId;
    public int mIsCustomEndTime;
    public int mOption;
    public HashMap<String, Slot> mSlotMaps;
    public long mStartTime;
    public boolean mValid;

    public class qw implements Parcelable.Creator<Flow> {
        /* renamed from: ad */
        public Flow[] newArray(int i2) {
            return new Flow[i2];
        }

        /* renamed from: qw */
        public Flow createFromParcel(Parcel parcel) {
            return new Flow(parcel);
        }
    }

    public Flow() {
        this.mValid = true;
        this.mHasEnd = false;
        this.mIsCustomEndTime = 0;
        this.mId = "";
        this.mHandle = -1;
        this.mOption = 0;
        this.mStartTime = System.currentTimeMillis();
        this.mClockStartTime = SystemClock.elapsedRealtime();
        this.mSlotMaps = new HashMap<>();
    }

    @Deprecated
    public final void addEvent(String str) {
        addEvent(str, (String) null);
    }

    @Deprecated
    public final void cancel() {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowCancel(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public final void end() {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowEnd(this);
        }
    }

    @Deprecated
    public final void endSlot(String str) {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowEndSlot(this, str);
        }
    }

    public long getClockStartTime() {
        return this.mClockStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public int getHandle() {
        return this.mHandle;
    }

    public String getId() {
        return this.mId;
    }

    public int getOption() {
        return this.mOption;
    }

    public HashMap<String, Slot> getSlotMaps() {
        return this.mSlotMaps;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean getValid() {
        return this.mValid;
    }

    public boolean hasEnd() {
        return this.mHasEnd;
    }

    public boolean isCustomEndTime() {
        return this.mIsCustomEndTime == 1;
    }

    public void markEnd() {
        this.mHasEnd = true;
    }

    public void setCustomEndTime(long j) {
        this.mIsCustomEndTime = 1;
        this.mEndTime = j;
    }

    public void setEndTime(long j) {
        if (this.mIsCustomEndTime != 1) {
            this.mEndTime = j;
        }
    }

    public void setValid(boolean z) {
        this.mValid = z;
    }

    @Deprecated
    public final void setValue(String str) {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowSetValue(this, str);
        }
    }

    @Deprecated
    public void setValueWithDuration(String str) {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowSetValueWithDuration(this, str);
        }
    }

    @Deprecated
    public final void startSlot(String str, JSONObject jSONObject) {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowStartSlot(this, str, jSONObject);
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mId);
        parcel.writeInt(this.mHandle);
        parcel.writeInt(this.mOption);
        parcel.writeLong(this.mStartTime);
        parcel.writeLong(this.mEndTime);
        parcel.writeInt(this.mIsCustomEndTime);
        parcel.writeLong(this.mClockStartTime);
        parcel.writeByte(this.mValid ? (byte) 1 : 0);
        parcel.writeMap(this.mSlotMaps);
    }

    @Deprecated
    public final void addEvent(String str, String str2) {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowAddEvent(this, str, str2);
        }
    }

    @Deprecated
    public void setValue(Map<String, String> map) {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowSetValue(this, map);
        }
    }

    @Deprecated
    public final void addEvent(String str, String str2, long j) {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.flowAddEventWithDate(this, str, str2, j);
        }
    }

    public Flow(String str, AtomicInteger atomicInteger, int i2) {
        this.mValid = true;
        this.mHasEnd = false;
        this.mIsCustomEndTime = 0;
        this.mId = str;
        this.mHandle = atomicInteger.getAndIncrement();
        this.mOption = i2;
        this.mStartTime = System.currentTimeMillis();
        this.mClockStartTime = SystemClock.elapsedRealtime();
        this.mSlotMaps = new HashMap<>();
    }

    public Flow(Parcel parcel) {
        boolean z = true;
        this.mValid = true;
        this.mHasEnd = false;
        this.mIsCustomEndTime = 0;
        this.mId = parcel.readString();
        this.mHandle = parcel.readInt();
        this.mOption = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mEndTime = parcel.readLong();
        this.mIsCustomEndTime = parcel.readInt();
        this.mClockStartTime = parcel.readLong();
        this.mValid = parcel.readByte() == 0 ? false : z;
        this.mSlotMaps = parcel.readHashMap(Flow.class.getClassLoader());
    }
}
