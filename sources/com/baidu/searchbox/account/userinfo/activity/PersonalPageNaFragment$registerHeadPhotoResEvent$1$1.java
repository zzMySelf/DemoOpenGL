package com.baidu.searchbox.account.userinfo.activity;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isSuccess", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNaFragment.kt */
final class PersonalPageNaFragment$registerHeadPhotoResEvent$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ PersonalPageNaFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalPageNaFragment$registerHeadPhotoResEvent$1$1(PersonalPageNaFragment personalPageNaFragment) {
        super(1);
        this.this$0 = personalPageNaFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isSuccess) {
        if (!this.this$0.isDetached() && isSuccess) {
            UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "设置成功").showHighlightToast();
        }
    }
}
