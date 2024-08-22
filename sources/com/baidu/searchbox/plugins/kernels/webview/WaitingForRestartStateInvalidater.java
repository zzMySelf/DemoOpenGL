package com.baidu.searchbox.plugins.kernels.webview;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.appmanager.AppRestartController;
import com.baidu.searchbox.plugins.PluginView;
import com.baidu.searchbox.plugins.R;
import com.baidu.searchbox.plugins.state.PluginState;

class WaitingForRestartStateInvalidater implements PluginView.StateInvalidater {
    WaitingForRestartStateInvalidater() {
    }

    public void stateInvalidate(PluginView view2) {
        Context context = view2.getContext().getApplicationContext();
        final WebkitKernelPlugin plugin = WebkitKernelPlugin.getInstance(context);
        ((ImageView) view2.findViewById(R.id.plugin_icon)).setImageDrawable(plugin.getIcon());
        ((TextView) view2.findViewById(R.id.plugin_name)).setText(plugin.getName());
        TextView state = (TextView) view2.findViewById(R.id.plugin_state);
        state.setText(com.baidu.searchbox.deprecation.R.string.plugin_uninstalled);
        state.setTextColor(context.getResources().getColor(com.baidu.searchbox.deprecation.R.color.plugin_text_light));
        state.setCompoundDrawablesWithIntrinsicBounds(com.baidu.searchbox.deprecation.R.drawable.plugin_state_uninstalled, 0, 0, 0);
        ((TextView) view2.findViewById(R.id.plugin_discription)).setText(Html.fromHtml(plugin.getDescription()));
        view2.findViewById(R.id.line2).setVisibility(8);
        view2.findViewById(R.id.plugin_tip).setVisibility(8);
        TextView feature = (TextView) view2.findViewById(R.id.plugin_feature_txt);
        feature.setVisibility(0);
        feature.setText(com.baidu.searchbox.deprecation.R.string.plugin_state_nonactivate);
        view2.findViewById(R.id.plugin_downloading).setVisibility(8);
        view2.findViewById(R.id.plugin_feature_settings).setVisibility(8);
        Button button = (Button) view2.findViewById(R.id.plugin_feature_btn);
        button.setVisibility(0);
        view2.findViewById(R.id.install_update_layout).setVisibility(0);
        view2.findViewById(R.id.plugin_update_new).setVisibility(8);
        button.setText(com.baidu.searchbox.deprecation.R.string.plugin_active);
        button.setTextColor(context.getResources().getColor(com.baidu.searchbox.deprecation.R.color.plugin_update_text_color));
        button.setBackgroundResource(com.baidu.searchbox.deprecation.R.drawable.plugin_option_uninstall);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plugin.setState(PluginState.INSTALLED);
                AppRestartController.restart(v.getContext(), true, true);
            }
        });
    }
}
