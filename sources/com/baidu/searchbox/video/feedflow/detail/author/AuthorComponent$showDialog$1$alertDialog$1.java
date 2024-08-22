package com.baidu.searchbox.video.feedflow.detail.author;

import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.author.AuthorAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/author/AuthorComponent$showDialog$1$alertDialog$1", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorComponent.kt */
public final class AuthorComponent$showDialog$1$alertDialog$1 implements BdAlertDialog.OnItemClickListener {
    final /* synthetic */ AuthorModel $model;
    final /* synthetic */ AuthorComponent this$0;

    AuthorComponent$showDialog$1$alertDialog$1(AuthorComponent $receiver, AuthorModel $model2) {
        this.this$0 = $receiver;
        this.$model = $model2;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new AuthorAction.AuthorDialogClick(false));
        }
        AuthorSettingsPanelBehaviorSpHelper.INSTANCE.setVideoAuthorSettingPanelBehavior("0");
        this.this$0.skipPartnerH5Page(this.$model);
    }
}
