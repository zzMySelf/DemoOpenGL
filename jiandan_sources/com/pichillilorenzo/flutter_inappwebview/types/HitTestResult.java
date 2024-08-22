package com.pichillilorenzo.flutter_inappwebview.types;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.sapi2.SapiAccount;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class HitTestResult {
    @Nullable
    public String extra;
    public int type;

    public HitTestResult(int i2, @Nullable String str) {
        this.type = i2;
        this.extra = str;
    }

    @Nullable
    public static HitTestResult fromWebViewHitTestResult(@Nullable WebView.HitTestResult hitTestResult) {
        if (hitTestResult == null) {
            return null;
        }
        return new HitTestResult(hitTestResult.getType(), hitTestResult.getExtra());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HitTestResult.class != obj.getClass()) {
            return false;
        }
        HitTestResult hitTestResult = (HitTestResult) obj;
        if (this.type != hitTestResult.type) {
            return false;
        }
        String str = this.extra;
        String str2 = hitTestResult.extra;
        return str != null ? str.equals(str2) : str2 == null;
    }

    @Nullable
    public String getExtra() {
        return this.extra;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.type * 31;
        String str = this.extra;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public void setExtra(@Nullable String str) {
        this.extra = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    @Nullable
    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.type));
        hashMap.put(SapiAccount.SAPI_ACCOUNT_EXTRA, this.extra);
        return hashMap;
    }

    public String toString() {
        return "HitTestResultMap{type=" + this.type + ", extra='" + this.extra + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
