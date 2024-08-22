package com.baidu.searchbox.plugins.center.detail.state;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.aps.base.ui.IDialogBuilder;
import com.baidu.searchbox.aps.base.ui.PluginDialogFactory;
import com.baidu.searchbox.aps.center.install.api.PluginInstallManager;
import com.baidu.searchbox.aps.center.install.api.PluginUninstallCallback;
import com.baidu.searchbox.plugins.R;
import com.baidu.searchbox.plugins.center.base.ImageUtils;
import com.baidu.searchbox.plugins.center.base.ResUtils;
import com.baidu.searchbox.plugins.center.detail.DialogHelper;
import com.baidu.searchbox.plugins.center.detail.PluginDetailCmdListHelper;
import com.baidu.searchbox.plugins.center.detail.PluginStateController;
import com.baidu.searchbox.plugins.center.detail.PluginView;
import com.baidu.searchbox.plugins.center.detail.StateUpdater;
import com.baidu.searchbox.plugins.center.model.BoxPlugin;
import com.baidu.searchbox.plugins.center.model.BoxPluginGroup;
import com.baidu.searchbox.plugins.center.model.BoxPluginHelper;
import com.facebook.drawee.view.SimpleDraweeView;

public class InstalledStateUpdater extends StateUpdater {
    /* access modifiers changed from: private */
    public Context mAppContext;

    public void initState(PluginView view2, BoxPluginGroup group, int installState) {
        PluginView pluginView = view2;
        Context context = view2.getContext();
        this.mAppContext = context.getApplicationContext();
        final BoxPlugin plugin = PluginStateController.getAny(group);
        if (plugin != null) {
            ImageUtils.loadPluginIcon((SimpleDraweeView) pluginView.findViewById(R.id.aps_center_plugin_icon), plugin.getPackageName(), plugin.getIcon(), (Drawable) null);
            ((TextView) pluginView.findViewById(R.id.aps_center_plugin_name)).setText(plugin.getName());
            TextView state = (TextView) pluginView.findViewById(R.id.aps_center_plugin_state);
            state.setText(ResUtils.getString(R.string.aps_center_plugin_installed));
            ResUtils.setTextColor(state, R.color.aps_center_plugin_installed_text_color);
            Drawable leftDrawable = ResUtils.getDrawable(R.drawable.aps_center_plugin_state_installed);
            leftDrawable.setBounds(0, 0, leftDrawable.getMinimumWidth(), leftDrawable.getMinimumHeight());
            state.setCompoundDrawables(leftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ((LinearLayout) pluginView.findViewById(R.id.aps_center_apk_size_zone)).setVisibility(8);
            ((TextView) pluginView.findViewById(R.id.aps_center_plugin_version)).setText(showVersioncode(state, plugin.getVersion().longValue(), group));
            ((TextView) pluginView.findViewById(R.id.aps_center_plugin_discription)).setText(plugin.getDescription());
            pluginView.findViewById(R.id.aps_center_line2).setVisibility(8);
            pluginView.findViewById(R.id.aps_center_plugin_tip).setVisibility(8);
            ((TextView) pluginView.findViewById(R.id.aps_center_plugin_feature_txt)).setVisibility(8);
            pluginView.findViewById(R.id.aps_center_plugin_downloading).setVisibility(8);
            pluginView.findViewById(R.id.aps_center_plugin_feature_root).setVisibility(8);
            LinearLayout capabilityContainer = (LinearLayout) pluginView.findViewById(R.id.aps_center_plugin_capability);
            capabilityContainer.setVisibility(8);
            PluginDetailCmdListHelper.drawCmdList(context, capabilityContainer, plugin.getPackageName(), plugin.getCmdList());
            ((LinearLayout) pluginView.findViewById(R.id.aps_center_plugin_dependence_list)).setVisibility(8);
            DialogHelper.showInstallingDialog((Activity) view2.getContext(), false, "");
            Button button = (Button) pluginView.findViewById(R.id.aps_center_plugin_feature_btn);
            button.setVisibility(plugin.getRemovable() ? 0 : 8);
            pluginView.findViewById(R.id.aps_center_install_update_layout).setVisibility(0);
            pluginView.findViewById(R.id.aps_center_plugin_update_new).setVisibility(8);
            pluginView.findViewById(R.id.aps_center_plugin_feature_btn_uninstall).setVisibility(8);
            button.setText(ResUtils.getString(R.string.aps_center_plugin_uninstall));
            if (plugin.getType() == BoxPluginHelper.Companion.getNPS_TYPE()) {
                button.setVisibility(8);
            }
            ResUtils.setTextColor(button, R.color.aps_center_plugin_update_text_color);
            ResUtils.setBackgroundDrawable(button, R.drawable.aps_center_plugin_option_uninstall);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    InstalledStateUpdater installedStateUpdater = InstalledStateUpdater.this;
                    installedStateUpdater.doUninstall(installedStateUpdater.mAppContext, plugin);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void doUninstall(final Context context, final BoxPlugin plugin) {
        String title = ResUtils.getString(R.string.aps_center_plugin_uninstall_dialog_title);
        String string = ResUtils.getString(R.string.aps_center_plugin_uninstall_common);
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(plugin.getName()) ? "" : plugin.getName();
        String message = String.format(string, objArr);
        IDialogBuilder builder = PluginDialogFactory.get().createBuilder();
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.aps_center_plugin_uninstall_dialog_btn, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                PluginInstallManager.getInstance(context).uninstall(plugin.getPackageName(), (PluginUninstallCallback) null);
            }
        });
        builder.setPositiveTextColor(ResUtils.getColor(R.color.aps_center_alert_dialog_btn_pos_txt_color));
        builder.setNegativeButton(R.string.aps_center_plugin_cancel_btn, (DialogInterface.OnClickListener) null);
        builder.show(context);
    }

    private String showVersioncode(TextView state, long versionCode, BoxPluginGroup group) {
        String versionDetail = String.valueOf(versionCode);
        if (group == null) {
            return versionDetail;
        }
        BoxPlugin installPlugin = group.getInstallPlugin();
        if (installPlugin != null) {
            if (versionCode <= installPlugin.getVersion().longValue()) {
                return versionDetail;
            }
            if (group.getDownloadPlugin() != null) {
                return String.format(this.mAppContext.getString(R.string.aps_center_nps_plugin_has_download), new Object[]{String.valueOf(installPlugin.getVersion()), String.valueOf(group.getDownloadPlugin().getVersion())});
            } else if (group.getUpdatePlugin() == null) {
                return versionDetail;
            } else {
                return String.format(this.mAppContext.getString(R.string.aps_center_nps_plugin_has_update), new Object[]{String.valueOf(installPlugin.getVersion()), String.valueOf(group.getUpdatePlugin().getVersion())});
            }
        } else if (group.getDownloadPlugin() != null) {
            state.setText(ResUtils.getString(R.string.aps_center_nps_plugin_download));
            return versionDetail;
        } else {
            state.setText(ResUtils.getString(R.string.aps_center_nps_plugin_update));
            return versionDetail;
        }
    }

    public void update(PluginView view2, BoxPluginGroup group, int installState) {
    }
}
