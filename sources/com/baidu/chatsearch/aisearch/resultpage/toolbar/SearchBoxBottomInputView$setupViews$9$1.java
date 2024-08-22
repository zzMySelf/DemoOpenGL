package com.baidu.chatsearch.aisearch.resultpage.toolbar;

import com.baidu.chatsearch.bottommenu.ChatSearchPhotoGuideManager;
import com.baidu.chatsearch.model.ubc.LidData;
import com.baidu.chatsearch.model.ubc.SSBottomMenuUbc;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "loginSuccess", "", "<anonymous parameter 1>", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchBoxBottomInputView.kt */
final class SearchBoxBottomInputView$setupViews$9$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ SearchBoxBottomInputView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBoxBottomInputView$setupViews$9$1(SearchBoxBottomInputView searchBoxBottomInputView) {
        super(2);
        this.this$0 = searchBoxBottomInputView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean loginSuccess, boolean z) {
        if (loginSuccess) {
            SearchBoxBottomInputView searchBoxBottomInputView = this.this$0;
            int i2 = 1;
            searchBoxBottomInputView.setBottomMenuOpen(!searchBoxBottomInputView.isBottomMenuOpen);
            if (this.this$0.isBottomMenuOpen && this.this$0.isInputSoftOpen) {
                this.this$0.hideIme();
            } else if (this.this$0.isBottomMenuOpen && !this.this$0.isInputSoftOpen) {
                i2 = 3;
            } else if (!this.this$0.isBottomMenuOpen) {
                i2 = 2;
            } else {
                i2 = -1;
            }
            int type = i2;
            Function1 access$getMBottomViewCallback$p = this.this$0.mBottomViewCallback;
            if (access$getMBottomViewCallback$p != null) {
                access$getMBottomViewCallback$p.invoke(Integer.valueOf(type));
            }
            LidData lidData = null;
            if (this.this$0.isBottomMenuOpen) {
                SSBottomMenuUbc sSBottomMenuUbc = SSBottomMenuUbc.INSTANCE;
                Function0 access$getLidData$p = this.this$0.lidData;
                if (access$getLidData$p != null) {
                    lidData = (LidData) access$getLidData$p.invoke();
                }
                sSBottomMenuUbc.openMenuClick(lidData);
            } else {
                SSBottomMenuUbc sSBottomMenuUbc2 = SSBottomMenuUbc.INSTANCE;
                Function0 access$getLidData$p2 = this.this$0.lidData;
                if (access$getLidData$p2 != null) {
                    lidData = (LidData) access$getLidData$p2.invoke();
                }
                sSBottomMenuUbc2.cancelBtnClick(lidData);
            }
            ChatSearchPhotoGuideManager.INSTANCE.dismissBubble();
        }
    }
}
