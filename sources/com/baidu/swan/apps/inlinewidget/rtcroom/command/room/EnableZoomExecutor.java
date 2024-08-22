package com.baidu.swan.apps.inlinewidget.rtcroom.command.room;

import com.baidu.swan.apps.inlinewidget.BaseCommandExecutor;
import com.baidu.swan.apps.inlinewidget.rtcroom.interfaces.IInlineRtcRoom;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;

public class EnableZoomExecutor extends BaseCommandExecutor<IInlineRtcRoom> {
    private static final String COMMAND_NAME = "enableZoom";

    public String getCommandName() {
        return "enableZoom";
    }

    public void executeCommand(ZeusPlugin.Command command, IInlineRtcRoom inlineWidget) {
        printCommandLog(inlineWidget, command.what, "" + command.obj, true);
        if (command.obj instanceof Boolean) {
            inlineWidget.enableZoom(((Boolean) command.obj).booleanValue());
        }
    }
}
