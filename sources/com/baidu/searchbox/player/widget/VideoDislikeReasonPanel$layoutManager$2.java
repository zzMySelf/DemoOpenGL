package com.baidu.searchbox.player.widget;

import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/GridLayoutManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoDislikeReasonPanel.kt */
final class VideoDislikeReasonPanel$layoutManager$2 extends Lambda implements Function0<GridLayoutManager> {
    final /* synthetic */ VideoDislikeReasonPanel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoDislikeReasonPanel$layoutManager$2(VideoDislikeReasonPanel videoDislikeReasonPanel) {
        super(0);
        this.this$0 = videoDislikeReasonPanel;
    }

    public final GridLayoutManager invoke() {
        return new GridLayoutManager(this.this$0.context, 2);
    }
}
