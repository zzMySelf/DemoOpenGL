package com.baidu.bdtask;

import com.baidu.bdtask.framework.service.http.HttpService;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/bdtask/TaskHttpService;", "Lcom/baidu/bdtask/framework/service/http/HttpService;", "()V", "getExtraRequestParams", "", "", "", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BDPTaskSdkService.kt */
public final class TaskHttpService implements HttpService {
    public Map<String, Object> getExtraRequestParams() {
        HashMap map = new HashMap();
        Map map2 = map;
        String zid = BaiduIdentityManager.getInstance().getZid();
        String str = "";
        if (zid == null) {
            zid = str;
        }
        map2.put("zid", zid);
        Map map3 = map;
        String versionName = AppConfig.AppInfo.getVersionName();
        if (versionName != null) {
            str = versionName;
        }
        map3.put("appVersion", str);
        return map;
    }
}
