package com.baidu.swan.apps.inlinewidget.video.command;

import com.baidu.searchbox.player.inline.BdInlineCommand;
import com.baidu.swan.apps.inlinewidget.BaseCommandExecutor;
import com.baidu.swan.apps.inlinewidget.video.widget.IInlineVideo;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;

public class GetVideoSarDenExecutor extends BaseCommandExecutor<IInlineVideo> {
    public String getCommandName() {
        return BdInlineCommand.COMMAND_GET_VIDEO_SAR_DEN;
    }

    public void executeCommand(ZeusPlugin.Command command, IInlineVideo inlineWidget) {
        command.ret = inlineWidget.getVideoSarDen();
        printCommandLog(inlineWidget, command.what, "SarDen: " + command.ret, false);
    }
}
