package com.baidu.browser.components.toolbar.impl.item;

import com.baidu.searchbox.favor.callback.FavorDataCallback;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.sync.FavorUIOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/browser/components/toolbar/impl/item/CommentToolbarStarItem$processStar$3", "Lcom/baidu/searchbox/favor/callback/FavorDataCallback;", "", "onResult", "", "data", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentToolbarStarItem.kt */
public final class CommentToolbarStarItem$processStar$3 extends FavorDataCallback<Object> {
    final /* synthetic */ Ref.ObjectRef<FavorModel> $favor;
    final /* synthetic */ String $statisticFrame;
    final /* synthetic */ Ref.ObjectRef<String> $url;
    final /* synthetic */ CommentToolbarStarItem this$0;

    CommentToolbarStarItem$processStar$3(CommentToolbarStarItem $receiver, Ref.ObjectRef<String> $url2, Ref.ObjectRef<FavorModel> $favor2, String $statisticFrame2) {
        this.this$0 = $receiver;
        this.$url = $url2;
        this.$favor = $favor2;
        this.$statisticFrame = $statisticFrame2;
    }

    public void onResult(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String str = null;
        FavorUIOperator.OperatorStatus status = data instanceof FavorUIOperator.OperatorStatus ? (FavorUIOperator.OperatorStatus) data : null;
        if (status != null) {
            this.this$0.updateStar(true, (String) this.$url.element);
            if (status == FavorUIOperator.OperatorStatus.ADD_SUCCESS || status == FavorUIOperator.OperatorStatus.REMOVE_SUCCESS) {
                CommentToolbarStarItem commentToolbarStarItem = this.this$0;
                String str2 = (String) this.$url.element;
                FavorModel favorModel = (FavorModel) this.$favor.element;
                String str3 = favorModel != null ? favorModel.title : null;
                FavorModel favorModel2 = (FavorModel) this.$favor.element;
                if (favorModel2 != null) {
                    str = favorModel2.tplId;
                }
                commentToolbarStarItem.doUbcAndPostEventAfterCollection(status, str2, str3, str, this.$statisticFrame);
            }
        }
    }
}
