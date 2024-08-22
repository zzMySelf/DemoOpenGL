package com.baidu.searchbox.video.component.base;

import android.view.View;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NestedViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u001d\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J*\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0016"}, d2 = {"com/baidu/searchbox/video/component/base/AbsItemComponent$createViewStateListener$1", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedViewHolder$ViewStateListener;", "onAttachToScreen", "", "tag", "", "onAttachToViewTree", "onBindData", "position", "", "model", "(ILjava/lang/Object;)V", "onDetachFromScreen", "onDetachFromViewTree", "onFling", "velocityX", "velocityY", "view", "Landroid/view/View;", "onSelected", "isUp", "", "lib-component-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsItemComponent.kt */
public final class AbsItemComponent$createViewStateListener$1 implements NestedViewHolder.ViewStateListener<M> {
    final /* synthetic */ AbsItemComponent<M, S> this$0;

    AbsItemComponent$createViewStateListener$1(AbsItemComponent<M, S> $receiver) {
        this.this$0 = $receiver;
    }

    public void onAttachToScreen(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.this$0.onAttachToScreen(tag);
    }

    public void onDetachFromScreen(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.this$0.onDetachFromScreen(tag);
    }

    public void onAttachToViewTree() {
        this.this$0.onAttachToViewTree();
    }

    public void onDetachFromViewTree() {
        this.this$0.onDetachFromViewTree();
    }

    public void onBindData(int position, M model) {
        this.this$0.getItemStore().dispatch(new NestedAction.OnBindData(position, model));
        this.this$0.onBindData(position, model);
    }

    public void onSelected(int position, boolean isUp, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.this$0.onSelected(position, isUp, tag);
    }

    public void onFling(int velocityX, int velocityY, View view2, int position) {
        this.this$0.onItemStartFling(velocityX, velocityY, view2, position);
    }
}
