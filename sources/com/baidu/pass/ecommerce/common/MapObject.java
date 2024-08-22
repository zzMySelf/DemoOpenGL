package com.baidu.pass.ecommerce.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.sapi2.NoProguard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class MapObject implements NoProguard, Parcelable {
    public static final Parcelable.Creator<MapObject> CREATOR = new Parcelable.Creator<MapObject>() {
        public MapObject createFromParcel(Parcel parcel) {
            return new MapObject(parcel);
        }

        public MapObject[] newArray(int i2) {
            return new MapObject[i2];
        }
    };
    private HashMap<String, Object> nameValuePairs;

    public MapObject() {
        this.nameValuePairs = new LinkedHashMap();
    }

    public int describeContents() {
        return 0;
    }

    public int getIntValue(String str) {
        if (this.nameValuePairs.get(str) == null) {
            return 0;
        }
        return ((Integer) this.nameValuePairs.get(str)).intValue();
    }

    public Object getObjValue(String str) {
        return this.nameValuePairs.get(str);
    }

    public String getStrValue(String str) {
        return (String) this.nameValuePairs.get(str);
    }

    public Iterator<String> keyIterator() {
        return this.nameValuePairs.keySet().iterator();
    }

    public void putValue(String str, Object obj) {
        this.nameValuePairs.put(str, obj);
    }

    public String toString() {
        Set<String> keySet = this.nameValuePairs.keySet();
        StringBuilder sb = new StringBuilder();
        for (String next : keySet) {
            sb.append(next).append("=").append(getObjValue(next)).append(",");
        }
        return "MapObject{" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeMap(this.nameValuePairs);
    }

    protected MapObject(Parcel parcel) {
        this.nameValuePairs = parcel.readHashMap(Object.class.getClassLoader());
    }
}
