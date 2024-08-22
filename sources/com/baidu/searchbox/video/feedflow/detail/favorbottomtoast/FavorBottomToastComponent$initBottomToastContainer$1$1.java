package com.baidu.searchbox.video.feedflow.detail.favorbottomtoast;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.bookmark.BookmarkUtil;
import com.baidu.searchbox.favor.util.FavorFolderPanelUtils;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.favor.favorpanel.ShowFavorPanelAction;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/favorbottomtoast/FavorBottomToastComponent$initBottomToastContainer$1$1", "Lcom/baidu/searchbox/video/feedflow/detail/favorbottomtoast/ToastClickListener;", "onToastClick", "", "toastType", "Lcom/baidu/searchbox/video/feedflow/detail/favorbottomtoast/ToastType;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorBottomToastComponent.kt */
public final class FavorBottomToastComponent$initBottomToastContainer$1$1 implements ToastClickListener {
    final /* synthetic */ FavorBottomToastView $this_apply;
    final /* synthetic */ FavorBottomToastComponent this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FavorBottomToastComponent.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToastType.values().length];
            iArr[ToastType.COLLECTION_FAVOR_SUCCESS.ordinal()] = 1;
            iArr[ToastType.FAVOR_SUCCESS.ordinal()] = 2;
            iArr[ToastType.ADD_SUCCESS.ordinal()] = 3;
            iArr[ToastType.NORMAL.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    FavorBottomToastComponent$initBottomToastContainer$1$1(FavorBottomToastComponent $receiver, FavorBottomToastView $receiver2) {
        this.this$0 = $receiver;
        this.$this_apply = $receiver2;
    }

    public void onToastClick(ToastType toastType) {
        Function0<Unit> toastClickCallback;
        Intrinsics.checkNotNullParameter(toastType, "toastType");
        this.this$0.hideToast();
        boolean z = false;
        switch (WhenMappings.$EnumSwitchMapping$0[toastType.ordinal()]) {
            case 1:
                Store access$getStore = this.this$0.getStore();
                Context context = this.$this_apply.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                VideoFlowUtilsKt.executeShortPlayRoute(access$getStore, context);
                return;
            case 2:
                Store access$getStore2 = this.this$0.getStore();
                if (access$getStore2 != null) {
                    StoreExtKt.post(access$getStore2, new FavorBottomToastClickAction(this.this$0.data));
                }
                Store access$getStore3 = this.this$0.getStore();
                if (access$getStore3 != null) {
                    StoreExtKt.post(access$getStore3, new ShowFavorPanelAction(false, false, 2, (DefaultConstructorMarker) null));
                    return;
                }
                return;
            case 3:
                Store access$getStore4 = this.this$0.getStore();
                if (access$getStore4 != null) {
                    StoreExtKt.post(access$getStore4, new FavorBottomToastClickAction(this.this$0.data));
                }
                if (this.this$0.data.getToastText().length() == 0) {
                    z = true;
                }
                if (z) {
                    Bundle bundle = new Bundle();
                    bundle.putString("source", "from_toast");
                    bundle.putString("classify_id", "video");
                    BookmarkUtil.startUserAssetsCenter(this.$this_apply.getContext(), "favor", bundle);
                    return;
                }
                FavorFolderPanelUtils favorFolderPanelUtils = FavorFolderPanelUtils.INSTANCE;
                String toastText = this.this$0.data.getToastText();
                Context context2 = this.$this_apply.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                favorFolderPanelUtils.openFavorDir(toastText, context2, "from_toast");
                return;
            case 4:
                BottomToastExtendData extentData = this.this$0.data.getExtentData();
                if (extentData != null && (toastClickCallback = extentData.getToastClickCallback()) != null) {
                    toastClickCallback.invoke();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
