package com.baidu.searchbox.comment.view.taloslite;

import com.baidu.searchbox.talos.lite.IContainerEventRequestCallback;
import com.baidu.searchbox.talos.lite.ITalosLiteContainer;
import org.json.JSONObject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommentTalosLiteSlotView$$ExternalSyntheticLambda1 implements IContainerEventRequestCallback {
    public final /* synthetic */ ITalosLiteContainer f$0;

    public /* synthetic */ CommentTalosLiteSlotView$$ExternalSyntheticLambda1(ITalosLiteContainer iTalosLiteContainer) {
        this.f$0 = iTalosLiteContainer;
    }

    public final void onRequestSendEvent(String str, JSONObject jSONObject) {
        CommentTalosLiteSlotView.m16904updateCommentTitle$lambda5$lambda4(this.f$0, str, jSONObject);
    }
}
