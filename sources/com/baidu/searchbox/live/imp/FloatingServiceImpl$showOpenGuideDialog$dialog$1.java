package com.baidu.searchbox.live.imp;

import com.baidu.searchbox.live.floating.LiveFloatingGuideDialog;
import com.baidu.searchbox.live.interfaces.service.FloatingService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/live/imp/FloatingServiceImpl$showOpenGuideDialog$dialog$1", "Lcom/baidu/searchbox/live/floating/LiveFloatingGuideDialog$LiveFloatGuideClickCallBack;", "onClickNegative", "", "onClickPositive", "onResult", "result", "", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatingServiceImpl.kt */
public final class FloatingServiceImpl$showOpenGuideDialog$dialog$1 implements LiveFloatingGuideDialog.LiveFloatGuideClickCallBack {
    final /* synthetic */ FloatingService.OnShowFloatOpenGuideDialogListener $listener;
    final /* synthetic */ FloatingServiceImpl this$0;

    FloatingServiceImpl$showOpenGuideDialog$dialog$1(FloatingService.OnShowFloatOpenGuideDialogListener $listener2, FloatingServiceImpl $receiver) {
        this.$listener = $listener2;
        this.this$0 = $receiver;
    }

    public void onClickNegative() {
        FloatingService.OnShowFloatOpenGuideDialogListener onShowFloatOpenGuideDialogListener = this.$listener;
        if (onShowFloatOpenGuideDialogListener != null) {
            onShowFloatOpenGuideDialogListener.onClickNegative();
        }
    }

    public void onClickPositive() {
        this.this$0.setSettingSwitcher(true);
        FloatingService.OnShowFloatOpenGuideDialogListener onShowFloatOpenGuideDialogListener = this.$listener;
        if (onShowFloatOpenGuideDialogListener != null) {
            onShowFloatOpenGuideDialogListener.onClickPositive();
        }
    }

    public void onResult(int result) {
    }
}
