package com.baidu.swan.apps.inlinewidget.input.command;

import com.baidu.swan.apps.inlinewidget.BaseCommandExecutor;
import com.baidu.swan.apps.inlinewidget.input.SwanInlineInputWidget;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;

public class ShowCustomKeyboardExecutor extends BaseCommandExecutor<SwanInlineInputWidget> {
    public String getCommandName() {
        return "showsoftkeyboard";
    }

    public void executeCommand(ZeusPlugin.Command command, SwanInlineInputWidget inlineWidget) {
        int type = command.arg1;
        printCommandLog(inlineWidget, command.what, "Type:" + type, false);
        inlineWidget.postShowKeyboard(type);
    }
}
