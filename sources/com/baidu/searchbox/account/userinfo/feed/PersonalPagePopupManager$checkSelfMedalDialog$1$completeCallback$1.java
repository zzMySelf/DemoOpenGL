package com.baidu.searchbox.account.userinfo.feed;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "showSuccess", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPagePopupManager.kt */
final class PersonalPagePopupManager$checkSelfMedalDialog$1$completeCallback$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ PersonalPagePopupManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalPagePopupManager$checkSelfMedalDialog$1$completeCallback$1(PersonalPagePopupManager personalPagePopupManager, Function1<? super Boolean, Unit> function1) {
        super(1);
        this.this$0 = personalPagePopupManager;
        this.$callback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean showSuccess) {
        if (AppConfig.isDebug()) {
            Log.d("PPPopupManager", "showMedalDetailDialog showSuccess:" + showSuccess);
        }
        if (showSuccess) {
            this.this$0.setHasShownPopup(true);
        }
        this.$callback.invoke(Boolean.valueOf(showSuccess));
    }
}
