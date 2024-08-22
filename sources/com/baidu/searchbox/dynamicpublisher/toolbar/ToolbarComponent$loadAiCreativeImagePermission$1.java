package com.baidu.searchbox.dynamicpublisher.toolbar;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.dynamicpublisher.aicreative.AiCreativeImageAction;
import com.baidu.searchbox.dynamicpublisher.aicreative.AiCreativeImageState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.ugc.model.AiCreativeImageData;
import com.baidu.searchbox.ugc.model.AiCreativeImageModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "", "model", "Lcom/baidu/searchbox/ugc/model/AiCreativeImageModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToolbarComponent.kt */
final class ToolbarComponent$loadAiCreativeImagePermission$1 extends Lambda implements Function2<Boolean, AiCreativeImageModel, Unit> {
    final /* synthetic */ ToolbarComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ToolbarComponent$loadAiCreativeImagePermission$1(ToolbarComponent toolbarComponent) {
        super(2);
        this.this$0 = toolbarComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), (AiCreativeImageModel) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean result, AiCreativeImageModel model) {
        Boolean isDraftHandleFinish;
        Store access$getStore;
        AbsState absState;
        AiCreativeImageState aiCreativeImageState;
        MutableLiveData<Boolean> draftControlAiCreativeImageEnterIsDone;
        if (result) {
            if (model != null ? Intrinsics.areEqual((Object) true, (Object) model.isPopular()) : false) {
                Store access$getStore2 = this.this$0.getStore();
                if (access$getStore2 != null) {
                    access$getStore2.dispatch(new AiCreativeImageAction.InitShowAiCreativeImageAction(new AiCreativeImageData(model.getImageUrl(), model.getAiAbstract(), model.getTitle(), model.getScheme())));
                }
                Store access$getStore3 = this.this$0.getStore();
                if (access$getStore3 == null || (absState = (AbsState) access$getStore3.getState()) == null || (aiCreativeImageState = (AiCreativeImageState) absState.select(AiCreativeImageState.class)) == null || (draftControlAiCreativeImageEnterIsDone = aiCreativeImageState.getDraftControlAiCreativeImageEnterIsDone()) == null) {
                    isDraftHandleFinish = null;
                } else {
                    isDraftHandleFinish = draftControlAiCreativeImageEnterIsDone.getValue();
                }
                if (Intrinsics.areEqual((Object) true, (Object) isDraftHandleFinish) && (access$getStore = this.this$0.getStore()) != null) {
                    access$getStore.dispatch(new AiCreativeImageAction.HideAiCreativeImageAction(false));
                }
            }
        }
    }
}
