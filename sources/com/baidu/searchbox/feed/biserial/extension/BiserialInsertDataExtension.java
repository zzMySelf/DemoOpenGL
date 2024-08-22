package com.baidu.searchbox.feed.biserial.extension;

import com.baidu.searchbox.feed.biserial.FeedBiSerialInsertManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/feed/biserial/extension/BiserialInsertDataExtension;", "Lcom/baidu/searchbox/feed/biserial/extension/IInsertDataExtension;", "()V", "cleanMaskShowId", "", "lib-feed-biserial_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiserialInsertDataExtension.kt */
public final class BiserialInsertDataExtension implements IInsertDataExtension {
    public void cleanMaskShowId() {
        FeedBiSerialInsertManager.clearMaskTalosliteShowId();
    }
}
