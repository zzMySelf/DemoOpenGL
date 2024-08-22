package com.baidu.searchbox.download;

import com.baidu.cyberplayer.sdk.videodownload.DuMediaVideoDownloadBean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\"\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/download/ICyberVideoDownloadAction;", "", "getType", "", "onDataTransfer", "", "taskID", "model", "Lcom/baidu/cyberplayer/sdk/videodownload/DuMediaVideoDownloadBean;", "operationCallback", "url", "operationType", "", "result", "lib-player-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ICyberVideoDownloadAction.kt */
public interface ICyberVideoDownloadAction {
    String getType();

    void onDataTransfer(String str, DuMediaVideoDownloadBean duMediaVideoDownloadBean);

    void operationCallback(String str, int i2, int i3);
}
