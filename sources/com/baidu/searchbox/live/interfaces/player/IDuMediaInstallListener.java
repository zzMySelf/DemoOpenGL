package com.baidu.searchbox.live.interfaces.player;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\bH&¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/IDuMediaInstallListener;", "", "onInstallError", "", "installType", "", "errorType", "detail", "", "onInstallProgress", "progress", "onInstallSuccess", "coreVer", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: IDuMediaInstallListener.kt */
public interface IDuMediaInstallListener {
    void onInstallError(int i2, int i3, String str);

    void onInstallProgress(int i2, int i3);

    void onInstallSuccess(int i2, String str);
}
