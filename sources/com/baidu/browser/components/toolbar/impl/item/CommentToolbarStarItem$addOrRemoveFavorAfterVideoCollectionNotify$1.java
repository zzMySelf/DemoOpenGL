package com.baidu.browser.components.toolbar.impl.item;

import com.baidu.searchbox.favor.callback.FavorDataCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/browser/components/toolbar/impl/item/CommentToolbarStarItem$addOrRemoveFavorAfterVideoCollectionNotify$1", "Lcom/baidu/searchbox/favor/callback/FavorDataCallback;", "", "onResult", "", "isSuccess", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentToolbarStarItem.kt */
public final class CommentToolbarStarItem$addOrRemoveFavorAfterVideoCollectionNotify$1 extends FavorDataCallback<Boolean> {
    final /* synthetic */ Ref.ObjectRef<String> $url;
    final /* synthetic */ CommentToolbarStarItem this$0;

    CommentToolbarStarItem$addOrRemoveFavorAfterVideoCollectionNotify$1(CommentToolbarStarItem $receiver, Ref.ObjectRef<String> $url2) {
        this.this$0 = $receiver;
        this.$url = $url2;
    }

    public /* bridge */ /* synthetic */ void onResult(Object data) {
        onResult(((Boolean) data).booleanValue());
    }

    public void onResult(boolean isSuccess) {
        if (isSuccess) {
            this.this$0.updateStar(false, (String) this.$url.element);
        }
    }
}
