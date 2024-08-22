package com.baidu.searchbox.aicreative.creating.plugin.creating;

import com.baidu.searchbox.aicreative.creating.AiCreativeImageCreatingQueryData;
import com.baidu.searchbox.aicreative.creating.AiCreativeImageGenData;
import com.baidu.searchbox.aicreative.creating.plugin.creating.AiCreativeImageCreatingAction;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.ugc.model.ImageStruct;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "state", "", "msg", "", "result", "Lcom/baidu/searchbox/aicreative/creating/AiCreativeImageCreatingQueryData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiCreativeImageCreatingPlugin.kt */
final class AiCreativeImageCreatingPlugin$startLoopQueryCreatingImage$1 extends Lambda implements Function3<Integer, String, AiCreativeImageCreatingQueryData, Unit> {
    final /* synthetic */ AiCreativeImageGenData $data;
    final /* synthetic */ AiCreativeImageCreatingPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiCreativeImageCreatingPlugin$startLoopQueryCreatingImage$1(AiCreativeImageCreatingPlugin aiCreativeImageCreatingPlugin, AiCreativeImageGenData aiCreativeImageGenData) {
        super(3);
        this.this$0 = aiCreativeImageCreatingPlugin;
        this.$data = aiCreativeImageGenData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke(((Number) p1).intValue(), (String) p2, (AiCreativeImageCreatingQueryData) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(int state, String msg, AiCreativeImageCreatingQueryData result) {
        List<ImageStruct> images;
        ImageStruct imageStruct;
        this.this$0.creatingState = state;
        if (this.this$0.creatingState == 0) {
            JSONObject jSONObject = null;
            this.$data.setTaskId(result != null ? result.getTaskId() : null);
            this.$data.setImageUrl((result == null || (images = result.getImages()) == null || (imageStruct = images.get(0)) == null) ? null : imageStruct.httpUrl);
            AiCreativeImageGenData aiCreativeImageGenData = this.$data;
            if (result != null) {
                jSONObject = result.getUgcUbcEventData();
            }
            aiCreativeImageGenData.setUgcUbcEventData(jSONObject);
            this.this$0.updateCreatingStatus(5);
            Store access$getStore = this.this$0.getStore();
            if (access$getStore != null) {
                access$getStore.dispatch(new AiCreativeImageCreatingAction.CreateImageSuccess(this.$data));
            }
            this.this$0.ubcEventAiCreatingSuccess(this.$data.getUgcUbcEventData());
            return;
        }
        this.this$0.onRequestCreatingImageFail(state, msg);
    }
}
