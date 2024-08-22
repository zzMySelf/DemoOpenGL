package com.baidu.searchbox.video.feedflow.detail.longpressmore;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/longpressmore/LongPressMoreFullScreenChangedAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "checked", "", "(Z)V", "getChecked", "()Z", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: LongPressMoreActionManifest.kt */
public final class LongPressMoreFullScreenChangedAction implements Action {
    private final boolean checked;

    public LongPressMoreFullScreenChangedAction(boolean checked2) {
        this.checked = checked2;
    }

    public final boolean getChecked() {
        return this.checked;
    }
}
