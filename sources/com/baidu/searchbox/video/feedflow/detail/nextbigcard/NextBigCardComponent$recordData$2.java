package com.baidu.searchbox.video.feedflow.detail.nextbigcard;

import com.baidu.searchbox.video.feedflow.detail.nextbigcard.switcher.NextBigCardSpHelper;
import com.baidu.searchbox.video.feedflow.detail.relatedsearch.switcher.ConfigRecordData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/relatedsearch/switcher/ConfigRecordData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NextBigCardComponent.kt */
final class NextBigCardComponent$recordData$2 extends Lambda implements Function0<ConfigRecordData> {
    final /* synthetic */ NextBigCardComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NextBigCardComponent$recordData$2(NextBigCardComponent nextBigCardComponent) {
        super(0);
        this.this$0 = nextBigCardComponent;
    }

    public final ConfigRecordData invoke() {
        return NextBigCardSpHelper.INSTANCE.getNextBigCardRecordData(this.this$0.getSceneConfig());
    }
}
