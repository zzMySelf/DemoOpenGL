package com.baidu.swan.apps.swancore.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.util.SwanAppSwanCoreUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class SwanCoreVersion extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanCoreVersion> CREATOR = new Parcelable.Creator<SwanCoreVersion>() {
        public SwanCoreVersion createFromParcel(Parcel in) {
            return new SwanCoreVersion(in);
        }

        public SwanCoreVersion[] newArray(int size) {
            return new SwanCoreVersion[size];
        }
    };
    public static final int TYPE_DEBUG = 2;
    public static final int TYPE_PRESET = 0;
    public static final int TYPE_REMOTE = 1;
    public String swanCorePath;
    public int swanCoreType;
    public long swanCoreVersionCode;
    public String swanCoreVersionName;

    public SwanCoreVersion() {
    }

    private SwanCoreVersion(Parcel in) {
        this.swanCoreType = in.readInt();
        this.swanCoreVersionCode = in.readLong();
        this.swanCoreVersionName = in.readString();
        this.swanCorePath = in.readString();
    }

    public String toString() {
        return "SwanCoreVersion{swanCorePath='" + this.swanCorePath + '\'' + ", swanCoreVersionName=" + this.swanCoreVersionName + ", swanCoreVersionCode=" + this.swanCoreVersionCode + ", swanCoreType=" + this.swanCoreType + ", isAvailable=" + isAvailable() + AbstractJsonLexerKt.END_OBJ;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.swanCoreType);
        dest.writeLong(this.swanCoreVersionCode);
        dest.writeString(this.swanCoreVersionName);
        dest.writeString(this.swanCorePath);
    }

    public boolean isAvailable() {
        return SwanAppSwanCoreUtils.isCoreAvailable(this.swanCorePath);
    }

    public static String getTypeString(int type) {
        switch (type) {
            case 0:
                return "preset";
            case 1:
                return "remote";
            case 2:
                return "debug";
            default:
                return "";
        }
    }
}
