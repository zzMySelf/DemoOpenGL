package fe.i.ad.rg.ad.qw;

import android.text.TextUtils;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {
    public static HashMap<String, String> ad(boolean z, String str) {
        JSONObject jSONObject = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                LogUtil.e("DxmPayRouterCallback", e.getMessage(), e);
                z = false;
            }
        }
        return de(z, jSONObject);
    }

    public static HashMap<String, String> de(boolean z, JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("result", fe(z, jSONObject));
        return hashMap;
    }

    public static String fe(boolean z, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                jSONObject2.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("result", z ? 0 : 1);
            jSONObject3.put("cnt", jSONObject2);
            return jSONObject3.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static HashMap<String, String> qw(int i2, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("result", fe(false, rg(i2, str)));
        return hashMap;
    }

    public static JSONObject rg(int i2, String str) {
        JSONObject jSONObject = new JSONObject();
        if (str == null) {
            str = "";
        }
        try {
            jSONObject.putOpt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i2));
            jSONObject.putOpt("des", str);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
