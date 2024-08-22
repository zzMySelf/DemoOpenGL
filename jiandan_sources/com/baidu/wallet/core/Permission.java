package com.baidu.wallet.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public enum Permission {
    NONE(0),
    READ_NORMAL(1),
    READ_PRIVATE(2),
    WRITE(4),
    READ_DEVICE(8);
    
    public final int val;

    /* access modifiers changed from: public */
    Permission(int i2) {
        this.val = i2;
    }

    public static Map<String, EnumSet<Permission>> parseDomainsConfig(@NonNull String str) throws JSONException {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, parsePermission(jSONObject.optInt(next)));
            }
        }
        return hashMap;
    }

    public static EnumSet<Permission> parsePermission(int i2) {
        EnumSet<Permission> of = EnumSet.of(NONE);
        if (READ_NORMAL.verify(i2)) {
            of.add(READ_NORMAL);
        }
        if (READ_PRIVATE.verify(i2)) {
            of.add(READ_PRIVATE);
        }
        if (WRITE.verify(i2)) {
            of.add(WRITE);
        }
        if (READ_DEVICE.verify(i2)) {
            of.add(READ_DEVICE);
        }
        return of;
    }

    public int getVal() {
        return this.val;
    }

    public boolean verify(int i2) {
        int i3 = this.val;
        return (i2 & i3) == i3;
    }
}
