package com.baidu.searchbox.video.hotflow.more;

import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayConfigKt;
import com.baidu.searchbox.video.feedflow.detail.more.AutoplayNextBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.AutoplaySwitchClickAction;
import com.baidu.searchbox.video.feedflow.detail.more.MoreComponent;
import com.baidu.searchbox.video.feedflow.detail.more.RefreshMoreBadgeVisibility;
import com.baidu.searchbox.video.feedflow.detail.toast.ShowTipAction;
import com.baidu.searchbox.video.feedflow.detail.toast.TipLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/hotflow/more/HotMoreComponent;", "Lcom/baidu/searchbox/video/feedflow/detail/more/MoreComponent;", "()V", "forbidAllNewTip", "", "isNeedShowBadge", "needHideAutoplayNext", "onAutoplaySwitchClick", "", "syncVideoAutoplayNextItemState", "item", "Lcom/baidu/android/common/menu/CommonMenuItem;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotMoreComponent.kt */
public final class HotMoreComponent extends MoreComponent {
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean needHideAutoplayNext() {
        /*
            r7 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x002c
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0015
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0016
        L_0x0015:
            r5 = r2
        L_0x0016:
            if (r5 == 0) goto L_0x001f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.more.MoreState> r6 = com.baidu.searchbox.video.feedflow.detail.more.MoreState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0020
        L_0x001f:
            r5 = r2
        L_0x0020:
            com.baidu.searchbox.video.feedflow.detail.more.MoreState r5 = (com.baidu.searchbox.video.feedflow.detail.more.MoreState) r5
            if (r5 == 0) goto L_0x002c
            boolean r0 = r5.getHideAutoplayNext()
            if (r0 != 0) goto L_0x002c
            r0 = r1
            goto L_0x002d
        L_0x002c:
            r0 = r3
        L_0x002d:
            if (r0 == 0) goto L_0x004e
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r7.getManager()
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intercept.service.IInterceptStateService> r5 = com.baidu.searchbox.video.feedflow.detail.intercept.service.IInterceptStateService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r5)
            com.baidu.searchbox.video.feedflow.detail.intercept.service.IInterceptStateService r0 = (com.baidu.searchbox.video.feedflow.detail.intercept.service.IInterceptStateService) r0
            if (r0 == 0) goto L_0x0046
            boolean r0 = r0.isItemAutoPlayDisable()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
        L_0x0046:
            boolean r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r2)
            if (r0 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r1 = r3
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.hotflow.more.HotMoreComponent.needHideAutoplayNext():boolean");
    }

    /* access modifiers changed from: protected */
    public void syncVideoAutoplayNextItemState(CommonMenuItem item) {
        int resId;
        Intrinsics.checkNotNullParameter(item, "item");
        if (AutoplayConfigKt.findAutoplaySwitch((Store<?>) getStore())) {
            resId = R.drawable.video_flow_menu_autoplay_next_select_img;
        } else {
            resId = R.drawable.video_flow_menu_autoplay_next_unselect_img;
        }
        item.setIcon(resId);
        item.setTitleColorRes(com.baidu.searchbox.feed.styles.R.color.FC1);
    }

    /* access modifiers changed from: protected */
    public void onAutoplaySwitchClick() {
        boolean curAutoplaySwitch = AutoplayConfigKt.findAutoplaySwitch((Store<?>) getStore());
        Store<AbsState> store = getStore();
        if (store != null) {
            AutoplayConfigKt.updateAutoplaySwitchValue((Store<?>) store, !curAutoplaySwitch);
        }
        Store<AbsState> store2 = getStore();
        if (store2 != null) {
            StoreExtKt.post(store2, new AutoplaySwitchClickAction(!curAutoplaySwitch));
        }
        Store<AbsState> store3 = getStore();
        if (store3 != null) {
            store3.dispatch(new AutoplayNextBtnClick(!curAutoplaySwitch));
        }
        if (!curAutoplaySwitch) {
            Store<AbsState> store4 = getStore();
            if (store4 != null) {
                StoreExtKt.post(store4, new ShowTipAction(getContext().getString(R.string.video_flow_autoplay_open), (CharSequence) null, (String) null, 0, 0, TipLocation.MIDDLE, false, 94, (DefaultConstructorMarker) null));
            }
        } else {
            Store<AbsState> store5 = getStore();
            if (store5 != null) {
                StoreExtKt.post(store5, new ShowTipAction(getContext().getString(R.string.video_flow_autoplay_close), (CharSequence) null, (String) null, 0, 0, TipLocation.MIDDLE, false, 94, (DefaultConstructorMarker) null));
            }
        }
        Store<AbsState> store6 = getStore();
        if (store6 != null) {
            StoreExtKt.post(store6, RefreshMoreBadgeVisibility.INSTANCE);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isNeedShowBadge() {
        return false;
    }

    public boolean forbidAllNewTip() {
        return true;
    }
}
