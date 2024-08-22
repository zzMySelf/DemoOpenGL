package com.baidu.searchbox.ioc.impl;

import com.baidu.searchbox.launch.restore.interfaces.IRestoreWordCommand;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/ioc/impl/RestoreWordCommand;", "Lcom/baidu/searchbox/launch/restore/interfaces/IRestoreWordCommand;", "()V", "isHaveWordCommand", "", "openWordCommandIfNeed", "", "lib-wordcommand-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RestoreWordCommand.kt */
public final class RestoreWordCommand implements IRestoreWordCommand {
    public boolean isHaveWordCommand() {
        return WordCommandManager.getInstance().isHaveWordCommand();
    }

    public void openWordCommandIfNeed() {
        WordCommandManager.setOnInitialUIReadyState(true);
        WordCommandManager.getInstance().handleClipboardData();
    }
}
