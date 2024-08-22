package com.baidu.swan.apps.inlinewidget.rtcroom.command.room;

import com.baidu.swan.apps.inlinewidget.BaseCommandExecutor;
import com.baidu.swan.apps.inlinewidget.rtcroom.interfaces.IInlineRtcRoom;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;

public class PageForegroundExecutor extends BaseCommandExecutor<IInlineRtcRoom> {
    private static final String COMMAND_NAME = "goForeground";

    public String getCommandName() {
        return "goForeground";
    }

    public void executeCommand(ZeusPlugin.Command command, IInlineRtcRoom inlineWidget) {
        printCommandLog(inlineWidget, command.what, (String) null, true);
        inlineWidget.onPageForeground();
    }
}
