package com.baidu.searchbox.videopublisher.publish;

import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.videopublisher.R;
import com.baidu.searchbox.videopublisher.draft.DraftAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/videopublisher/publish/PublishPlugin$createNumLimitDialog$1", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublishPlugin.kt */
public final class PublishPlugin$createNumLimitDialog$1 implements BdAlertDialog.OnItemClickListener {
    final /* synthetic */ PublishPlugin this$0;

    PublishPlugin$createNumLimitDialog$1(PublishPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(DraftAction.ForceSave.INSTANCE);
        }
        UniversalToast.makeText(AppRuntime.getAppContext(), R.string.video_publisher_draft_save_tips).show();
        UiThreadUtils.getMainHandler().post(new PublishPlugin$createNumLimitDialog$1$$ExternalSyntheticLambda0(this.this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: onItemClick$lambda-0  reason: not valid java name */
    public static final void m7272onItemClick$lambda0(PublishPlugin this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.getManager().finish();
    }
}
