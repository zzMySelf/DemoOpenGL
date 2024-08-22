package com.baidu.searchbox.video.feedflow.detail.longpressmore;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/longpressmore/LongPressMoreContentQuickLookShowAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "type", "Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/OcrExt$OcrPanelScene;", "(Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/OcrExt$OcrPanelScene;)V", "getType", "()Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/OcrExt$OcrPanelScene;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: LongPressMoreActionManifest.kt */
public final class LongPressMoreContentQuickLookShowAction implements Action {
    private final OcrExt.OcrPanelScene type;

    public LongPressMoreContentQuickLookShowAction(OcrExt.OcrPanelScene type2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        this.type = type2;
    }

    public final OcrExt.OcrPanelScene getType() {
        return this.type;
    }
}
