package com.baidu.android.imsdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMConfigInternal;

public class ChatObject {
    public static final long DEFAULT_PAID = -1;
    public static final int DEFAULT_TYPE = -1;
    public static final int MMD_TYPE = 1000;
    private int mBusinessType = -1;
    private int mCategory;
    private long mContacter;
    private Context mContext;
    private long mPaid = -1;
    private long mTimeInterval = 0;
    private int mType = -1;

    public ChatObject(Context context, int category, long contacter, long paid, int type) {
        this.mContext = context;
        this.mCategory = category;
        this.mContacter = contacter;
        this.mPaid = paid;
        this.mType = type;
    }

    public ChatObject(Context context, int category, long contacter) {
        this.mContext = context;
        this.mCategory = category;
        this.mContacter = contacter;
    }

    public ChatObject(Context context, int category, long contacter, long timeInterval) {
        this.mContext = context;
        this.mCategory = category;
        this.mContacter = contacter;
        this.mTimeInterval = timeInterval;
    }

    public ChatObject setType(int type) {
        this.mType = type;
        return this;
    }

    public String getToken() {
        return IMConfigInternal.getInstance().getIMConfig(this.mContext).getToken(this);
    }

    public int hashCode() {
        return (((((((1 * 31) + this.mCategory) * 31) + ((int) this.mContacter)) * 31) + ((int) this.mPaid)) * 31) + this.mType;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof ChatObject)) {
            return false;
        }
        ChatObject chatObject = (ChatObject) object;
        if (this.mCategory == chatObject.mCategory && this.mContacter == chatObject.mContacter && this.mPaid == chatObject.mPaid && this.mType == chatObject.mType) {
            return true;
        }
        return false;
    }

    public String toString() {
        return getToken();
    }

    public int getCategory() {
        return this.mCategory;
    }

    public long getContacter() {
        return this.mContacter;
    }

    public long getPaid() {
        return this.mPaid;
    }

    public void setPaid(long paid) {
        this.mPaid = paid;
    }

    public int getType() {
        return this.mType;
    }

    public int getBusinessType() {
        return this.mBusinessType;
    }

    public void setBusinessType(int mBusinessType2) {
        this.mBusinessType = mBusinessType2;
    }

    public long getTimeInterval() {
        return this.mTimeInterval;
    }
}
