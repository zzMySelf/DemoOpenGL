package com.baidu.swan.apps.inlinewidget.video.command;

import com.baidu.swan.apps.inlinewidget.BaseCommandExecutor;
import com.baidu.swan.apps.inlinewidget.video.widget.IInlineVideo;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;

public class UpdateVideoRectExecutor extends BaseCommandExecutor<IInlineVideo> {
    public String getCommandName() {
        return "updateVideoRect";
    }

    public void executeCommand(ZeusPlugin.Command command, IInlineVideo inlineWidget) {
        inlineWidget.updateRect(command.arg1, command.arg2, command.arg3, command.arg4);
        printCommandLog(inlineWidget, command.what, "Rect: (" + command.arg1 + ", " + command.arg2 + ", " + command.arg3 + ", " + command.arg4 + ")", false);
    }
}
