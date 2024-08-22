package com.baidu.searchbox.aipersonal.manager;

import com.baidu.searchbox.database.FunctionCodeControl;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00032\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/aipersonal/manager/AiManagerCallBack;", "", "onFail", "", "msg", "", "onSuccess", "datas", "", "Lkotlin/Pair;", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiManagerDataRequestHelper.kt */
public interface AiManagerCallBack {
    void onFail(String str);

    void onSuccess(List<Pair<PersonalCenterTabItemModel, Boolean>> list);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiManagerDataRequestHelper.kt */
    public static final class DefaultImpls {
        public static void onSuccess(AiManagerCallBack aiManagerCallBack, List<Pair<PersonalCenterTabItemModel, Boolean>> datas) {
            Intrinsics.checkNotNullParameter(datas, FunctionCodeControl.FUNCTION_CODE_DATA_NAME);
        }

        public static void onFail(AiManagerCallBack aiManagerCallBack, String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }
}
