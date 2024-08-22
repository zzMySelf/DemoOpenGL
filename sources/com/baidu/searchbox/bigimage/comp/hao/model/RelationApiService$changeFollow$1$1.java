package com.baidu.searchbox.bigimage.comp.hao.model;

import com.baidu.searchbox.bigimage.model.HaoInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelationApi.kt */
final class RelationApiService$changeFollow$1$1 extends Lambda implements Function1<String, Object> {
    final /* synthetic */ boolean $follow;
    final /* synthetic */ HaoInfo $info;
    final /* synthetic */ RelationApiService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RelationApiService$changeFollow$1$1(RelationApiService relationApiService, HaoInfo haoInfo, boolean z) {
        super(1);
        this.this$0 = relationApiService;
        this.$info = haoInfo;
        this.$follow = z;
    }

    public final Object invoke(String it) {
        if (it != null) {
            return this.this$0.parseChangeFollowResult(this.$info, this.$follow, new JSONObject(it));
        }
        throw new Exception("data is empty");
    }
}
