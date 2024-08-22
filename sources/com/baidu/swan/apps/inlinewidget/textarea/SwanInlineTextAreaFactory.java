package com.baidu.swan.apps.inlinewidget.textarea;

import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;

public class SwanInlineTextAreaFactory implements ZeusPluginFactory {
    private static final String FACTORY_NAME = "swan_textarea";
    public static final String TAG = " [[InlineTextAreaFactory]] ";
    private String mSlaveId;

    public SwanInlineTextAreaFactory(String slaveId) {
        this.mSlaveId = slaveId;
    }

    public String name() {
        return FACTORY_NAME;
    }

    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        SwanInlineTextAreaWidget inlineWidget = new SwanInlineTextAreaWidget(invoker, this.mSlaveId);
        if (SwanAppLibConfig.DEBUG) {
            Log.i(TAG, "Factory 「Hash:" + hashCode() + "」 is creating inline textArea「Hash:" + inlineWidget.hashCode() + "」");
        }
        return new InlineTextAreaController(inlineWidget);
    }
}
