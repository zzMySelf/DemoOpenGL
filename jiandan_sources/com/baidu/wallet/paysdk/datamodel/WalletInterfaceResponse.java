package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;
import org.json.JSONObject;

public class WalletInterfaceResponse implements IBeanResponse {
    public JSONObject login_data;
    public JSONObject unlogin_data;

    public static class WalletModuleData implements NoProguard, Serializable {
        public static final String NO_ANIM = "0";
        public String anim;
        public String link_addr;
        public String logo;
        public String name;
        public int type = -1;
        public String value;

        public boolean needAnim() {
            return !"0".equals(this.anim);
        }
    }

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
