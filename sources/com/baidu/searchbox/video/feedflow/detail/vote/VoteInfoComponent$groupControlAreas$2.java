package com.baidu.searchbox.video.feedflow.detail.vote;

import com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/video/feedflow/detail/controlvisible/GroupControlArea;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoteInfoComponent.kt */
final class VoteInfoComponent$groupControlAreas$2 extends Lambda implements Function0<List<GroupControlArea>> {
    public static final VoteInfoComponent$groupControlAreas$2 INSTANCE = new VoteInfoComponent$groupControlAreas$2();

    VoteInfoComponent$groupControlAreas$2() {
        super(0);
    }

    public final List<GroupControlArea> invoke() {
        return CollectionsKt.mutableListOf(GroupControlArea.LeftAreaGroup.INSTANCE);
    }
}
