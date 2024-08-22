package com.baidu.searchbox.account.userinfo.activity;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.account.userinfo.R;
import com.baidu.searchbox.account.userinfo.data.PersonalPageUserEntity;
import com.baidu.searchbox.account.userinfo.net.PersonalPageRequest;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isSuccess", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNaFragment.kt */
final class PersonalPageNaFragment$reqEditTopTab$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $thirdId;
    final /* synthetic */ PersonalPageNaFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalPageNaFragment$reqEditTopTab$1(PersonalPageNaFragment personalPageNaFragment, String str) {
        super(1);
        this.this$0 = personalPageNaFragment;
        this.$thirdId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isSuccess) {
        if (!this.this$0.isDetached() && this.this$0.getContext() != null) {
            if (!isSuccess) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.na_feed_bad_net_toast).show();
                this.this$0.isRequestingEditTab = false;
                return;
            }
            PersonalPageNaFragment personalPageNaFragment = this.this$0;
            MultiTabItemInfo multiTabItemInfo = (MultiTabItemInfo) CollectionsKt.getOrNull(personalPageNaFragment.tabList, this.this$0.curSelectedPage);
            String str = multiTabItemInfo != null ? multiTabItemInfo.mId : null;
            if (str == null) {
                str = "";
            }
            personalPageNaFragment.restoredTabId = str;
            PersonalPageRequest access$getPersonalPageRequest = this.this$0.getPersonalPageRequest();
            String str2 = this.$thirdId;
            final PersonalPageNaFragment personalPageNaFragment2 = this.this$0;
            access$getPersonalPageRequest.reqTabList(str2, false, new Function2<Boolean, JSONArray, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke(((Boolean) p1).booleanValue(), (JSONArray) p2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, JSONArray jsonArray) {
                    List it;
                    if (!personalPageNaFragment2.isDetached() && personalPageNaFragment2.getContext() != null) {
                        if (jsonArray != null) {
                            PersonalPageUserEntity access$getUserEntity$p = personalPageNaFragment2.userEntity;
                            if (access$getUserEntity$p != null) {
                                access$getUserEntity$p.updateTabs(jsonArray, (JSONArray) null);
                            }
                            PersonalPageUserEntity access$getUserEntity$p2 = personalPageNaFragment2.userEntity;
                            if (!(access$getUserEntity$p2 == null || (it = access$getUserEntity$p2.getTabsList()) == null)) {
                                PersonalPageNaFragment personalPageNaFragment = personalPageNaFragment2;
                                personalPageNaFragment.tabList = personalPageNaFragment.transformFeedTabs(it);
                                personalPageNaFragment.tabsAreDefault = false;
                                personalPageNaFragment.updateFeedTabs();
                            }
                        }
                        personalPageNaFragment2.isRequestingEditTab = false;
                    }
                }
            }, (Function3<? super Boolean, ? super JSONArray, ? super JSONArray, Unit>) null);
        }
    }
}
