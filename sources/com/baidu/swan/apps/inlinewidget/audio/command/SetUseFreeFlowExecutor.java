package com.baidu.swan.apps.inlinewidget.audio.command;

import com.baidu.searchbox.player.inline.BdInlineCommand;
import com.baidu.swan.apps.inlinewidget.BaseCommandExecutor;
import com.baidu.swan.apps.inlinewidget.audio.widget.IInlineAudio;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;

public class SetUseFreeFlowExecutor extends BaseCommandExecutor<IInlineAudio> {
    public String getCommandName() {
        return BdInlineCommand.COMMAND_SET_USE_FREE_FLOW;
    }

    public void executeCommand(ZeusPlugin.Command command, IInlineAudio inlineWidget) {
        boolean z = true;
        if (command.arg1 != 1) {
            z = false;
        }
        inlineWidget.setUseFreeFlow(z);
        printCommandLog(inlineWidget, command.what, (String) null, false);
    }
}
