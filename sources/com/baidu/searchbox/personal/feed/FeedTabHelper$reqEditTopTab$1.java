package com.baidu.searchbox.personal.feed;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.personalcenter.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isSuccess", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTabHelper.kt */
final class FeedTabHelper$reqEditTopTab$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $thirdId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedTabHelper$reqEditTopTab$1(String str) {
        super(1);
        this.$thirdId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isSuccess) {
        if (!isSuccess) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.personal_center_manager_title_empty).show();
            FeedTabHelper feedTabHelper = FeedTabHelper.INSTANCE;
            FeedTabHelper.isRequestingEditTab = false;
            return;
        }
        FeedTabUpdateCallback access$getFeedTabUpdateCallback$p = FeedTabHelper.feedTabUpdateCallback;
        if (access$getFeedTabUpdateCallback$p != null) {
            access$getFeedTabUpdateCallback$p.restoredTabId();
        }
        FeedTabHelper.INSTANCE.getPersonalPageRequest().reqTabList(this.$thirdId, false, AnonymousClass1.INSTANCE, (Function3<? super Boolean, ? super JSONArray, ? super JSONArray, Unit>) null);
    }
}
