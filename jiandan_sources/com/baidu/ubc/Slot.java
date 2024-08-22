package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Slot implements Parcelable {
    public static final String CATEGORY = "id";
    public static final Parcelable.Creator<Slot> CREATOR = new qw();
    public static final int DEFAULT_VALUE = 0;
    public static final String DURATION = "d";
    public static final String INFO = "info";
    public static final int MILLISECOND = 1000;
    public String mCategory;
    public float mDuration;
    public long mEnd = 0;
    public JSONObject mOption;
    public long mStart = 0;

    public class qw implements Parcelable.Creator<Slot> {
        /* renamed from: ad */
        public Slot[] newArray(int i2) {
            return new Slot[i2];
        }

        /* renamed from: qw */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }
    }

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = j;
        this.mCategory = str;
        this.mOption = jSONObject;
    }

    public void clean() {
        this.mStart = 0;
        this.mEnd = 0;
    }

    public int describeContents() {
        return 0;
    }

    public long getEnd() {
        return this.mEnd;
    }

    public JSONObject getJSONObject() {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(this.mCategory)) {
            return null;
        }
        float f = this.mDuration;
        if (f <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", new Object[]{Float.valueOf(f)});
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", this.mCategory);
                jSONObject2.put("d", format);
                if (this.mOption != null) {
                    jSONObject2.put("info", this.mOption);
                }
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            return jSONObject;
        }
    }

    public long getStart() {
        return this.mStart;
    }

    public boolean isBegin() {
        return this.mStart > 0;
    }

    public boolean isEnded() {
        return this.mEnd > 0;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void setEnd(long j) {
        this.mEnd = j;
        if (j > 0) {
            long j2 = this.mStart;
            if (j > j2) {
                this.mDuration += ((float) (j - j2)) / 1000.0f;
            }
        }
    }

    public void setOption(JSONObject jSONObject) {
        this.mOption = jSONObject;
    }

    public void setStart(long j) {
        this.mStart = j;
        this.mEnd = 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.mEnd);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.mDuration);
    }

    public Slot(Parcel parcel) {
        this.mStart = parcel.readLong();
        this.mEnd = parcel.readLong();
        this.mCategory = parcel.readString();
        this.mDuration = parcel.readFloat();
    }
}
