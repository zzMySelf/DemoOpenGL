package com.baidu.swan.apps.extcore.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.util.SwanAppSwanCoreUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ExtensionCore extends SwanAppIPCData {
    public static final Parcelable.Creator<ExtensionCore> CREATOR = new Parcelable.Creator<ExtensionCore>() {
        public ExtensionCore createFromParcel(Parcel in) {
            return new ExtensionCore(in);
        }

        public ExtensionCore[] newArray(int size) {
            return new ExtensionCore[size];
        }
    };
    public static final int TYPE_DEBUG = 2;
    public static final int TYPE_PRESET = 0;
    public static final int TYPE_REMOTE = 1;
    public String extensionCorePath;
    public int extensionCoreType;
    public long extensionCoreVersionCode;
    public String extensionCoreVersionName;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public ExtensionCore() {
    }

    private ExtensionCore(Parcel in) {
        this.extensionCoreType = in.readInt();
        this.extensionCoreVersionCode = in.readLong();
        this.extensionCoreVersionName = in.readString();
        this.extensionCorePath = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.extensionCoreType);
        dest.writeLong(this.extensionCoreVersionCode);
        dest.writeString(this.extensionCoreVersionName);
        dest.writeString(this.extensionCorePath);
    }

    public String toString() {
        return "ExtensionCore{extensionCoreType=" + this.extensionCoreType + ", extensionCoreVersionCode=" + this.extensionCoreVersionCode + ", extensionCoreVersionName=" + this.extensionCoreVersionName + ", extensionCorePath='" + this.extensionCorePath + '\'' + ", isAvailable='" + isAvailable() + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean isAvailable() {
        return SwanAppSwanCoreUtils.isCoreAvailable(this.extensionCorePath);
    }
}
