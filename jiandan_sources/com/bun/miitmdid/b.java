package com.bun.miitmdid;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.android.util.devices.RomUtils;
import com.bun.miitmdid.interfaces.IIdConfig;
import org.json.JSONObject;

@Keep
public class b implements IIdConfig {
    @Keep
    public a a = new a(this);

    @Keep
    public class a {
        @Keep
        public w a;

        @Keep
        public a(b bVar) {
        }
    }

    @Keep
    public static native b a(Context context);

    public static boolean a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null || bVar == null) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(RomUtils.MANUFACTURER_VIVO);
        w wVar = new w();
        if (optJSONObject != null) {
            wVar.a = optJSONObject.optString("appid");
            bVar.a.a = wVar;
        }
        return bVar.a.a != null;
    }

    @Keep
    public native String getVivoAppID();
}
