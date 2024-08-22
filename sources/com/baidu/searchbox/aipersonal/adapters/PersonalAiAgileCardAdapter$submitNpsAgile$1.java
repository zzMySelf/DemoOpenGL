package com.baidu.searchbox.aipersonal.adapters;

import android.util.Log;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.lightbrowser.RuntimeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSuccess", "", "toastText", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalAiAgileCardAdapter.kt */
final class PersonalAiAgileCardAdapter$submitNpsAgile$1 extends Lambda implements Function2<Boolean, String, Unit> {
    final /* synthetic */ String $score;
    final /* synthetic */ PersonalAiAgileCardAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalAiAgileCardAdapter$submitNpsAgile$1(PersonalAiAgileCardAdapter personalAiAgileCardAdapter, String str) {
        super(2);
        this.this$0 = personalAiAgileCardAdapter;
        this.$score = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), (String) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isSuccess, String toastText) {
        if (RuntimeKt.isDebug()) {
            Log.d(this.this$0.getTAG(), "submitNpsAgile: isSuccess: " + isSuccess + ", toastText: " + toastText);
        }
        if (isSuccess) {
            PersonalAiAgileCardAdapter personalAiAgileCardAdapter = this.this$0;
            String str = this.$score;
            PersonalCenterTabModel access$getMData$p = personalAiAgileCardAdapter.mData;
            personalAiAgileCardAdapter.handleSubmit(str, access$getMData$p != null ? access$getMData$p.getSwitchTitle() : null);
            return;
        }
        this.this$0.handleFailure(toastText);
    }
}
