package com.baidu.swan.apps.inlinewidget.video.command;

import com.baidu.searchbox.player.inline.BdInlineCommand;
import com.baidu.swan.apps.inlinewidget.BaseCommandExecutor;
import com.baidu.swan.apps.inlinewidget.video.widget.IInlineVideo;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;

public class PrepareAsyncExecutor extends BaseCommandExecutor<IInlineVideo> {
    public String getCommandName() {
        return BdInlineCommand.COMMAND_PREPARE_ASYNC;
    }

    public void executeCommand(ZeusPlugin.Command command, IInlineVideo inlineWidget) {
        command.ret = inlineWidget.prepareAsync() ? 1 : 0;
        printCommandLog(inlineWidget, command.what, "isSupport: " + command.ret, false);
    }

    public void mockCachedCommandReturnValue(ZeusPlugin.Command command) {
        command.ret = 1;
    }
}
