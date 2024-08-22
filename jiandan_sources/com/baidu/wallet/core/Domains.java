package com.baidu.wallet.core;

import com.baidu.wallet.core.utils.LogUtil;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class Domains implements NoProguard {
    public static final String DEFAULT_JSIPC = "{\".duxiaomankj.com\":15,\".paydxm.com\":15,\".juhedxm.com\":15,\".dxmjuhe.com\":15,\".dxmjinr.com\":15,\".baidu.com\":15,\".dxmbaoxian.com\":15,\".nuomi.com\":15,\".baifubao.com\":15,\".duxiaoman.com\":15,\".baiyingfund.com\":15,\".dxmgyl.com\":15,\".manlianrong.com\":15,\".duxiaomanfund.com\":15,\".dxmpay.com\":15,\"bdtrust.gt-trust.com\":10,\"bdtrust.mintrust.com\":10,\"bdtrust.ebtrust.com\":10,\"bdtrust.cfitc.com\":10}";
    public final Map<String, EnumSet<Permission>> DEFAULT_PERMISSION_CONFIG;
    public Map<String, EnumSet<Permission>> mDomainsPermissionConfig;

    public static class a {
        public static final Domains a = new Domains();
    }

    public static final Domains getInstance() {
        return a.a;
    }

    public Map<String, EnumSet<Permission>> getDomainsPermissionConfig() {
        Map<String, EnumSet<Permission>> map = this.mDomainsPermissionConfig;
        if (map == null || map.isEmpty()) {
            LogUtil.d("Domains", "use the default jsipc");
            return this.DEFAULT_PERMISSION_CONFIG;
        }
        LogUtil.d("Domains", "use the online jsipc");
        return this.mDomainsPermissionConfig;
    }

    public void setDomainsPermissionConfig(Map<String, EnumSet<Permission>> map) {
        this.mDomainsPermissionConfig = map;
    }

    public Domains() {
        Map<String, EnumSet<Permission>> map;
        try {
            LogUtil.d("Domains", "parse the default jsipc: {\".duxiaomankj.com\":15,\".paydxm.com\":15,\".juhedxm.com\":15,\".dxmjuhe.com\":15,\".dxmjinr.com\":15,\".baidu.com\":15,\".dxmbaoxian.com\":15,\".nuomi.com\":15,\".baifubao.com\":15,\".duxiaoman.com\":15,\".baiyingfund.com\":15,\".dxmgyl.com\":15,\".manlianrong.com\":15,\".duxiaomanfund.com\":15,\".dxmpay.com\":15,\"bdtrust.gt-trust.com\":10,\"bdtrust.mintrust.com\":10,\"bdtrust.ebtrust.com\":10,\"bdtrust.cfitc.com\":10}");
            map = Permission.parseDomainsConfig(DEFAULT_JSIPC);
        } catch (JSONException unused) {
            map = new HashMap<>();
        }
        this.DEFAULT_PERMISSION_CONFIG = map;
    }
}
