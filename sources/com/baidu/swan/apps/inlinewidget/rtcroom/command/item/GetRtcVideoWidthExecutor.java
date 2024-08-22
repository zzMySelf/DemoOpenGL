package com.baidu.swan.apps.inlinewidget.rtcroom.command.item;

import com.baidu.swan.apps.inlinewidget.BaseCommandExecutor;
import com.baidu.swan.apps.inlinewidget.rtcroom.interfaces.IInlineRtcItem;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;

public class GetRtcVideoWidthExecutor extends BaseCommandExecutor<IInlineRtcItem> {
    public static final String COMMAND_NAME = "getVideoWidth";

    public String getCommandName() {
        return "getVideoWidth";
    }

    public void executeCommand(ZeusPlugin.Command command, IInlineRtcItem inlineWidget) {
        command.ret = inlineWidget.getVideoWidth();
        printCommandLog(inlineWidget, command.what, "Width: " + command.ret, true);
    }
}
