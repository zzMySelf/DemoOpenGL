package com.baidu.swan.apps.inlinewidget.rtcroom.command.room;

import com.baidu.swan.apps.inlinewidget.BaseCommandExecutor;
import com.baidu.swan.apps.inlinewidget.rtcroom.interfaces.IInlineRtcRoom;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;

public class EnableAnsExecutor extends BaseCommandExecutor<IInlineRtcRoom> {
    private static final String COMMAND_NAME = "enableAns";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    public void executeCommand(ZeusPlugin.Command command, IInlineRtcRoom inlineWidget) {
        printCommandLog(inlineWidget, command.what, "" + command.obj, true);
        if (command.obj instanceof Boolean) {
            inlineWidget.enableAns(((Boolean) command.obj).booleanValue());
        }
    }
}
