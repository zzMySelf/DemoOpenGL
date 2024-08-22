package com.baidu.swan.apps.inlinewidget.rtcroom.command.item;

import com.baidu.swan.apps.inlinewidget.BaseCommandExecutor;
import com.baidu.swan.apps.inlinewidget.rtcroom.interfaces.IInlineRtcItem;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;

public class ZoomExecutor extends BaseCommandExecutor<IInlineRtcItem> {
    public static final String COMMAND_NAME = "onZoom";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    public void executeCommand(ZeusPlugin.Command command, IInlineRtcItem inlineWidget) {
        printCommandLog(inlineWidget, command.what, "" + command.obj, true);
        if (command.obj instanceof Integer) {
            inlineWidget.onZoom(((Integer) command.obj).intValue());
        }
    }
}
