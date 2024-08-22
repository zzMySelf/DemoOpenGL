package com.baidu.swan.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class SwanAppLifecycleEvent implements Parcelable {
    public static final Parcelable.Creator<SwanAppLifecycleEvent> CREATOR = new Parcelable.Creator<SwanAppLifecycleEvent>() {
        public SwanAppLifecycleEvent createFromParcel(Parcel in) {
            return new SwanAppLifecycleEvent(in);
        }

        public SwanAppLifecycleEvent[] newArray(int size) {
            return new SwanAppLifecycleEvent[size];
        }
    };
    public String appId;
    public boolean isNightMode;
    public boolean isSendNightModeMsg;
    public boolean isWhiteActionBar;
    public String token;
    public String type;

    public SwanAppLifecycleEvent(String appId2, String type2) {
        this.appId = appId2;
        this.type = type2;
    }

    protected SwanAppLifecycleEvent(Parcel in) {
        this.type = in.readString();
        this.appId = in.readString();
        this.token = in.readString();
        boolean z = false;
        this.isNightMode = in.readInt() == 1;
        this.isSendNightModeMsg = in.readInt() == 1 ? true : z;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.appId);
        dest.writeString(this.token);
        dest.writeInt(this.isNightMode ? 1 : 0);
        dest.writeInt(this.isSendNightModeMsg ? 1 : 0);
    }

    public int describeContents() {
        return 0;
    }

    public static boolean isValid(SwanAppLifecycleEvent event) {
        return event != null && !TextUtils.isEmpty(event.appId) && !TextUtils.isEmpty(event.type);
    }

    public String toString() {
        return "SwanAppLifecycleEvent{type='" + this.type + '\'' + ", appId='" + this.appId + '\'' + ", token='" + this.token + '\'' + ", isNightMode=" + this.isNightMode + ", isSendNightModeMsg=" + this.isSendNightModeMsg + AbstractJsonLexerKt.END_OBJ;
    }
}
