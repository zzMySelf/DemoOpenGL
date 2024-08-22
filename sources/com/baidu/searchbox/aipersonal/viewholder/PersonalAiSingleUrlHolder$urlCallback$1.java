package com.baidu.searchbox.aipersonal.viewholder;

import com.baidu.searchbox.aipersonal.data.FavorHistoryModel;
import com.baidu.searchbox.aipersonal.widgets.PersonalAiFavorHisQueryCallBack;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/aipersonal/viewholder/PersonalAiSingleUrlHolder$urlCallback$1", "Lcom/baidu/searchbox/aipersonal/widgets/PersonalAiFavorHisQueryCallBack;", "onFavorHisQueryCallBack", "", "favorHisList", "", "Lcom/baidu/searchbox/aipersonal/data/FavorHistoryModel;", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalAiSingleUrlHolder.kt */
public final class PersonalAiSingleUrlHolder$urlCallback$1 implements PersonalAiFavorHisQueryCallBack {
    final /* synthetic */ PersonalAiSingleUrlHolder this$0;

    PersonalAiSingleUrlHolder$urlCallback$1(PersonalAiSingleUrlHolder $receiver) {
        this.this$0 = $receiver;
    }

    public void onFavorHisQueryCallBack(List<FavorHistoryModel> favorHisList) {
        Intrinsics.checkNotNullParameter(favorHisList, "favorHisList");
        if (favorHisList.isEmpty()) {
            PersonalAiSingleUrlHolder personalAiSingleUrlHolder = this.this$0;
            personalAiSingleUrlHolder.logE$lib_personal_center_release(personalAiSingleUrlHolder.TAG, " onFavorHisQueryCallBack url数据 = null");
            this.this$0.mFavorHisModel = null;
        } else {
            this.this$0.mFavorHisModel = favorHisList.get(0);
            PersonalAiSingleUrlHolder personalAiSingleUrlHolder2 = this.this$0;
            personalAiSingleUrlHolder2.log$lib_personal_center_release(personalAiSingleUrlHolder2.TAG, " onFavorHisQueryCallBack url数据, favorHisList = " + this.this$0.mFavorHisModel);
        }
        this.this$0.updateContent();
    }
}
