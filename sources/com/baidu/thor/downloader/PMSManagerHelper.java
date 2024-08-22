package com.baidu.thor.downloader;

import android.text.TextUtils;
import com.baidu.searchbox.pms.db.PackageManager;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.thor.sdk.manager.ioc.IThorConfig;
import com.baidu.thor.sdk.manager.ioc.PluginFuncInfo;
import com.baidu.thor.sdk.plugin.PluginManagerService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PMSManagerHelper {
    public static PMSManagerHelper getInstance() {
        return Holder.SINSTANCE;
    }

    public void process(IThorConfig config, IProcessListener listener) {
        HashMap<String, PluginFuncInfo> pluginFuncInfos;
        if (config != null && listener != null && (pluginFuncInfos = config.getPluginFuncInfos()) != null && !pluginFuncInfos.isEmpty()) {
            Set<String> packageNames = new HashSet<>();
            for (PluginFuncInfo info : pluginFuncInfos.values()) {
                if (info != null && !TextUtils.isEmpty(info.getPluginPackageName())) {
                    packageNames.add(info.getPluginPackageName());
                }
            }
            PmsManager.getInstance().execute(new RequestParams().setRunType(ThorPluginChannel.RUN_TYPE).addChannel(new ThorPluginChannel(new ArrayList(packageNames), config, listener)));
        }
    }

    public void uninstall(String packageName) {
        if (!TextUtils.isEmpty(packageName)) {
            PluginManagerService.getInstance().unInstall(packageName);
            resetPMSInfo(packageName);
        }
    }

    public void resetPMSInfo(String packageName) {
        if (!TextUtils.isEmpty(packageName)) {
            PackageManager.resetUpdateVersion("162", new ArrayList<String>(packageName) {
                final /* synthetic */ String val$packageName;

                {
                    this.val$packageName = r2;
                    add(r2);
                }
            });
            PackageManager.deleteLatestPackageFile("162", packageName);
        }
    }

    private static final class Holder {
        public static final PMSManagerHelper SINSTANCE = new PMSManagerHelper();

        private Holder() {
        }
    }
}
