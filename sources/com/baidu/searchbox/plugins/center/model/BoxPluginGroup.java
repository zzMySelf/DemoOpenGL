package com.baidu.searchbox.plugins.center.model;

import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.searchbox.aps.base.Plugin;
import com.baidu.searchbox.aps.base.manager.PluginGroupManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/plugins/center/model/BoxPluginGroup;", "", "()V", "downloadPlugin", "Lcom/baidu/searchbox/plugins/center/model/BoxPlugin;", "getDownloadPlugin", "()Lcom/baidu/searchbox/plugins/center/model/BoxPlugin;", "setDownloadPlugin", "(Lcom/baidu/searchbox/plugins/center/model/BoxPlugin;)V", "installPlugin", "getInstallPlugin", "setInstallPlugin", "updatePlugin", "getUpdatePlugin", "setUpdatePlugin", "transformAPS", "pluginGroup", "Lcom/baidu/searchbox/aps/base/manager/PluginGroupManager$PluginGroup;", "transformNPS", "Lcom/baidu/nps/pm/BundleInfoGroup;", "lib-aps-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxPluginGroup.kt */
public class BoxPluginGroup {
    private BoxPlugin downloadPlugin;
    private BoxPlugin installPlugin;
    private BoxPlugin updatePlugin;

    public final BoxPlugin getInstallPlugin() {
        return this.installPlugin;
    }

    public final void setInstallPlugin(BoxPlugin boxPlugin) {
        this.installPlugin = boxPlugin;
    }

    public final BoxPlugin getUpdatePlugin() {
        return this.updatePlugin;
    }

    public final void setUpdatePlugin(BoxPlugin boxPlugin) {
        this.updatePlugin = boxPlugin;
    }

    public final BoxPlugin getDownloadPlugin() {
        return this.downloadPlugin;
    }

    public final void setDownloadPlugin(BoxPlugin boxPlugin) {
        this.downloadPlugin = boxPlugin;
    }

    public final BoxPluginGroup transformAPS(PluginGroupManager.PluginGroup pluginGroup) {
        Intrinsics.checkNotNullParameter(pluginGroup, "pluginGroup");
        Plugin $this$transformAPS_u24lambda_u2d0 = pluginGroup.installPlugin;
        if ($this$transformAPS_u24lambda_u2d0 != null) {
            this.installPlugin = new BoxPlugin().transformAPS($this$transformAPS_u24lambda_u2d0);
        }
        Plugin $this$transformAPS_u24lambda_u2d1 = pluginGroup.updatePlugin;
        if ($this$transformAPS_u24lambda_u2d1 != null) {
            this.updatePlugin = new BoxPlugin().transformAPS($this$transformAPS_u24lambda_u2d1);
        }
        Plugin $this$transformAPS_u24lambda_u2d2 = pluginGroup.downloadPlugin;
        if ($this$transformAPS_u24lambda_u2d2 != null) {
            this.downloadPlugin = new BoxPlugin().transformAPS($this$transformAPS_u24lambda_u2d2);
        }
        return this;
    }

    public final BoxPluginGroup transformNPS(BundleInfoGroup pluginGroup) {
        Intrinsics.checkNotNullParameter(pluginGroup, "pluginGroup");
        BundleInfo $this$transformNPS_u24lambda_u2d3 = pluginGroup.getBundleByType(3);
        if ($this$transformNPS_u24lambda_u2d3 != null) {
            this.installPlugin = new BoxPlugin().transformNPS($this$transformNPS_u24lambda_u2d3);
        }
        BundleInfo $this$transformNPS_u24lambda_u2d4 = pluginGroup.getBundleByType(1);
        if ($this$transformNPS_u24lambda_u2d4 != null) {
            this.updatePlugin = new BoxPlugin().transformNPS($this$transformNPS_u24lambda_u2d4);
        }
        BundleInfo $this$transformNPS_u24lambda_u2d5 = pluginGroup.getBundleByType(2);
        if ($this$transformNPS_u24lambda_u2d5 != null) {
            this.downloadPlugin = new BoxPlugin().transformNPS($this$transformNPS_u24lambda_u2d5);
        }
        return this;
    }
}
